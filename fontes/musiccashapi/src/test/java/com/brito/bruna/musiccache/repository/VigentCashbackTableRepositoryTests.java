/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Bruna
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class VigentCashbackTableRepositoryTests implements RepositoryTests{
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private VigentCashbackTableRepository vigentCashbackTableRepository;

    @Override
    @Before
    public void setup() {
    }

    @Override
    @Test
    public void testFindAll() throws Exception {
    }

    @Override
    @Test
    public void testCreate() throws Exception {
    }

    @Override
    @Test
    public void testEdit() throws Exception {
    }

    @Override
    @Test
    public void testRemove() throws Exception {
    }

    @Override
    @Test
    public void testFind() throws Exception {
    }

    @Override
    @Test
    public void testFindRange() throws Exception {
    }

    @Override
    @Test
    public void testCount() throws Exception {
    }
}
