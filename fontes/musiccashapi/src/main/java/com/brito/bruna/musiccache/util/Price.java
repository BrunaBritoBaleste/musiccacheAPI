/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.util;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author Bruna
 */
public class Price {
    
    private static DecimalFormat df = new DecimalFormat("##");
    
    public static Double generatePrice(){
        
        Random r = new Random();
        String sp = String.valueOf(r.nextInt(50))+"."+ String.valueOf(r.nextInt(99));
        return Double.parseDouble(sp);
    }
}
