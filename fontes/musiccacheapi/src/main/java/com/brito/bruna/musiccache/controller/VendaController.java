/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.controller;

import com.brito.bruna.musiccache.entity.Album;
import com.brito.bruna.musiccache.entity.Venda;
import com.brito.bruna.musiccache.entity.VendaItem;
import com.brito.bruna.musiccache.repository.AlbumRepository;
import com.brito.bruna.musiccache.repository.VendaRepository;
import com.brito.bruna.musiccache.repository.VigentCashbackTableRepository;
import com.brito.bruna.musiccache.util.CalculeCashBack;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bruna
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/venda", produces = "application/json")
public class VendaController {
    
    @Autowired
    VendaRepository vendaRepository;
    
    @Autowired
    AlbumRepository albumRepository;
    
    @Autowired
    VigentCashbackTableRepository vigentCashbackTableRepository;
    
     //GET All
    @GetMapping(produces = "application/json")
    public ResponseEntity getAllgetAll(
             @RequestParam(value = "page",
             required = false,
             defaultValue = "0") int page, 
             @RequestParam(value = "size",
             required = false,
             defaultValue = "10") int size,
             @RequestParam(value = "orderBy",
             required = false,
             defaultValue = "dtvenda") String orderBy,
             @And({
                  @Spec(path = "dtvenda", params = "from", spec = GreaterThanOrEqual.class),
                  @Spec(path = "dtvenda", params = "to", spec = LessThanOrEqual.class)
             }) Specification<Venda> specification
    ) {
        try {
            Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, orderBy));
            Pageable pageable = new PageRequest(page, size, sort);
            Page<Venda> vendas = vendaRepository.findAll(specification,pageable); 
            return ResponseEntity.ok().body(vendas);
        } catch (Exception e) {
            //Deixa o erro registrado no Console
            System.out.println("ERRO NA CHAMADA DO SERVIÇO|||Requisição:GET ALL|||Venda|||Mensagem:" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    //GET Id
    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity findById(@PathVariable(value = "id") Integer id) {
        try {
            Optional<Venda> venda = vendaRepository.findById(id);

            if (!venda.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(venda);
        } catch (Exception e) {
            //Deixa o erro registrado no Console
            System.out.println("ERRO NA CHAMADA DO SERVIÇO|||Requisição:GET ID|||Venda|||Mensagem:" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    

    //COUNT
    @GetMapping(path = "/count", produces = "application/json")
    public ResponseEntity count() {
        try {
            return ResponseEntity.ok().body(vendaRepository.count());
        } catch (Exception e) {
            //Deixa o erro registrado no Console
            System.out.println("ERRO NA CHAMADA DO SERVIÇO|||Requisição:GET COUNT|||Venda|||Mensagem:" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @PostMapping(produces = "application/json")
    public ResponseEntity save(@Valid @RequestBody Venda venda) {
        try {
            boolean valid = true;
            
            //verifica se todos os albuns informados no serviço existem
            for(VendaItem item : venda.getItensvenda()){
                Optional<Album> album = albumRepository.findById(item.getAlbum().getId());
                if(!album.isPresent()){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).
                            body("ERRO: Venda não pode ser inserida! Album não encontrado: "+item.getAlbum().getId());
                }
            }
             //todos os albuns existem - continua o processo
            Double acumdesconto = Double.parseDouble("0");
            Double acumvalortotal = Double.parseDouble("0");
            
            Calendar c = Calendar.getInstance();
            Date dtvenda = new Date();
            c.setTime(dtvenda);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            
           
            for(VendaItem item : venda.getItensvenda()){
                Optional<Album> album = albumRepository.findById(item.getAlbum().getId());
                item.setAlbum(album.get());
                item.setValor(album.get().getPrice());
                acumvalortotal+=album.get().getPrice();
                Double perc = vigentCashbackTableRepository.findcashback(album.get().getGenre(),dayOfWeek);
                item.setPerccashback(perc);
                Double desc = CalculeCashBack.calculacashback(album.get().getPrice(),perc);
                item.setValorcashback(desc);
                acumdesconto+=desc;
            }
            
            venda.setDtvenda(dtvenda);
            venda.setVlTotal(acumvalortotal);
            venda.setVltotalcashback(acumdesconto);
            venda.setVlFinal(acumvalortotal - acumdesconto);
            
            Venda v = vendaRepository.registravenda(venda);
            return ResponseEntity.ok().body(v);
        } catch (Exception e) {
            //Deixa o erro registrado no Console
            System.out.println("ERRO NA CHAMADA DO SERVIÇO|||Requisição:POST|||Venda|||Mensagem:" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }//fim post cultura
}
