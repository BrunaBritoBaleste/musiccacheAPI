/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.repository;

/**
 *
 * @author Bruna
 */

public interface RepositoryTests {
           
    
    public void setup();
    
   
    public void testFindAll() throws Exception;
    
    
    public void testCreate() throws Exception;
 
    
    public void testEdit() throws Exception;
    
    
    public void testRemove() throws Exception;
    
    
    public void testFind() throws Exception;
     
    
    public void testFindRange() throws Exception;
    
   
    public void testCount() throws Exception;
    
}
