/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Bruna
 */
@Entity
@Table(name = "TB_CASHBACK")
public class VigentCashbackTable implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private Long id;
    private String genre;
    private Double percent;
    private int dayofweek;

    public VigentCashbackTable() {
    }

    public VigentCashbackTable(Long id, String genre, Double percent, int dayofweek) {
        this.id = id;
        this.genre = genre;
        this.percent = percent;
        this.dayofweek = dayofweek;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public int getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(int dayofweek) {
        this.dayofweek = dayofweek;
    }

    @Override
    public String toString() {
        return "VigentCashbackTable{" + "id=" + id + ", genre=" + genre + ", percent=" + percent + ", dayofweek=" + dayofweek + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VigentCashbackTable other = (VigentCashbackTable) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
    
}
