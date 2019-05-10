/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.repository;

import com.brito.bruna.musiccache.entity.Album;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bruna
 */
@Repository
public class AlbumRepositoryCustomImpl implements AlbumRepositoryCustom{
    
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void savewithdependence(Album album) {
  
        if(album.getImages()!=null){
        for(int i=0; i<album.getImages().size(); i++){
            entityManager.persist(album.getImages().get(i));
        }
        }
  
         entityManager.persist(album);
        
    }
    
}
