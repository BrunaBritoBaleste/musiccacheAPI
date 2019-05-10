/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.repository;

import com.brito.bruna.musiccache.entity.Venda;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bruna
 */

public interface VendaRepositoryCustom{
    
    public Venda registravenda(Venda venda);
    
    public List<Venda> findbyrangedate(Date inicio, Date fim);
}
