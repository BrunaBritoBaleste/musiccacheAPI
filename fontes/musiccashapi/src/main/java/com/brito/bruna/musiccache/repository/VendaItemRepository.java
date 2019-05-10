/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.repository;

import com.brito.bruna.musiccache.entity.VendaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bruna
 */
@Repository
public interface VendaItemRepository extends JpaRepository<VendaItem, Integer>{
    
}
