/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.util;

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
public class CalculeCashBackTests {
    
        @Test
	public void calculacashbackTest() {           
		assertThat(CalculeCashBack.calculacashback(Double.parseDouble("0"),Double.parseDouble("0"))).isEqualTo(Double.parseDouble("0"));
                assertThat(CalculeCashBack.calculacashback(Double.parseDouble("10"),Double.parseDouble("10"))).isEqualTo(Double.parseDouble("1.0"));
                assertThat(CalculeCashBack.calculacashback(Double.parseDouble("0"),Double.parseDouble("50"))).isEqualTo(Double.parseDouble("0.0"));
                assertThat(CalculeCashBack.calculacashback(Double.parseDouble("50"),Double.parseDouble("0"))).isEqualTo(Double.parseDouble("0"));
	}
    
}
