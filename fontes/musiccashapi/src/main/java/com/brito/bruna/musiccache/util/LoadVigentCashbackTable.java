/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.util;

import com.brito.bruna.musiccache.entity.VigentCashbackTable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruna
 */
public class LoadVigentCashbackTable {
    
    private static List<VigentCashbackTable> cashbacktable;
    private static final String[] genre = {"POP", "MPB", "CLASSIC", "ROCK"};
    private static final int[][] percent = new int[][]{
      {25, 7 , 6 , 2 , 10, 15, 20},
      {30, 5 , 10, 15, 20, 25, 30},
      {35, 3 , 5 , 8 , 13, 18, 25},
      {40, 10, 15, 15, 15, 20, 40}
    };
     //seg, ter. qua,qui,sex,sab,dom
    public static List<VigentCashbackTable> loadCashbackTable(){
        
        cashbacktable = new ArrayList<VigentCashbackTable>();
        
        for(int i=0; i<=6; i++){
            
            for(int j=0; j<genre.length;j++){
                
                VigentCashbackTable cashback = new VigentCashbackTable();
                cashback.setDayofweek(i+1);
                cashback.setGenre(genre[j]);
                cashback.setPercent(Double.parseDouble(String.valueOf(percent[j][i])));
                cashbacktable.add(cashback);
            }
  
        }
        
        return cashbacktable;
    }
    
   }
