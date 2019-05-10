/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.repository;

import com.brito.bruna.musiccache.entity.VigentCashbackTable;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bruna
 */
@Repository
public class VigentCashbackTableRepositoryCustomImpl implements VigentCashbackTableRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public Double findcashback(String genre, int day) {
        Query query = entityManager.createQuery("SELECT v FROM VigentCashbackTable v where v.genre=:genre AND v.dayofweek=:day");
        query.setParameter("genre", genre);
        query.setParameter("day", day);
        
        List<VigentCashbackTable> tablecashback = query.getResultList();
        
        if(tablecashback.size()>0){
            return tablecashback.get(0).getPercent();
        }else{
            return Double.parseDouble("0");
        }
    }
    
}
