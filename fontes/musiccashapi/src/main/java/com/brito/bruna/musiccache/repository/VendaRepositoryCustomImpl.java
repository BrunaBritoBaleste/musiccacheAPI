/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.repository;

import com.brito.bruna.musiccache.entity.Venda;
import com.brito.bruna.musiccache.entity.VendaItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bruna
 */
@Repository
public class VendaRepositoryCustomImpl implements VendaRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    @Transactional
    public Venda registravenda(Venda venda) {
        
        Venda v = new Venda();
        v.setDtvenda(venda.getDtvenda());
        v.setVlFinal(venda.getVlFinal());
        v.setVlTotal(venda.getVlTotal());
        v.setVltotalcashback(venda.getVltotalcashback());
//        entityManager.persist(v);
        
        //registra os itens da venda
        List<VendaItem> itens = new ArrayList<VendaItem>();
        for(int i=0; i<venda.getItensvenda().size();i++){
            VendaItem item = new VendaItem();
            item.setAlbum(venda.getItensvenda().get(i).getAlbum());
            item.setPerccashback(venda.getItensvenda().get(i).getPerccashback());
            item.setValor(venda.getItensvenda().get(i).getValor());
            item.setValorcashback(venda.getItensvenda().get(i).getValorcashback());
            item.setIdVenda(v);
            entityManager.persist(item);
            itens.add(item); 
        }
        
        v.setItensvenda(itens);
        entityManager.persist(v);
        
        return v;
    }

    @Override
    public List<Venda> findbyrangedate(Date inicio, Date fim) {
        Query query = entityManager.createQuery("SELECT v FROM Venda v where v.dtvenda BETWEEN :dtinicio AND :dtfim");
        query.setParameter("dtinicio", inicio);
        query.setParameter("dtfim", fim);
        return query.getResultList();
    }
    
    
}
