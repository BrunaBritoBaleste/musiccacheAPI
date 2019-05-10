/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.controller;

import com.brito.bruna.musiccache.entity.Album;
import com.brito.bruna.musiccache.repository.AlbumRepository;
import java.util.List;
import java.util.Optional;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bruna
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/album", produces = "application/json")
public class AlbumController {
    
    @Autowired
    AlbumRepository albumRepository;
    
     //GET All
    @GetMapping(produces = "application/json")
    public ResponseEntity getAll(
             @RequestParam(value = "page",
             required = false,
             defaultValue = "0") int page, 
             @RequestParam(value = "size",
             required = false,
             defaultValue = "10") int size,
             @RequestParam(value = "orderBy",
             required = false,
             defaultValue = "name") String orderBy,
             @And({
                @Spec(path = "genre", spec = Equal.class)
             }) Specification<Album> specification
    ) {
        try {
            Sort sort = new Sort(new Sort.Order(Direction.ASC, orderBy));
            Pageable pageable = new PageRequest(page, size, sort);
            Page<Album> albuns = albumRepository.findAll(specification,pageable); 
            return ResponseEntity.ok().body(albuns);
        } catch (Exception e) {
            //Deixa o erro registrado no Console
            System.out.println("ERRO NA CHAMADA DO SERVIÇO|||Requisição:GET ALL|||Entidade:Album|||Mensagem:" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    //GET Id
    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity findById(@PathVariable(value = "id") Long id) {
        try {
            Optional<Album> album = albumRepository.findById(id);

            if (!album.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(album);
        } catch (Exception e) {
            //Deixa o erro registrado no Console
            System.out.println("ERRO NA CHAMADA DO SERVIÇO|||Requisição:GET ID|||Entidade:Album|||Mensagem:" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
