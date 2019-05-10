/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.util;

import com.brito.bruna.musiccache.entity.VigentCashbackTable;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Bruna
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoadVigentCashbackTableTests {
    
     @Test
	public void loadCashbackTableTest() throws Exception {            
            List<VigentCashbackTable> cashback = LoadVigentCashbackTable.loadCashbackTable();
            assertThat(cashback).isNotNull();
	}
}
