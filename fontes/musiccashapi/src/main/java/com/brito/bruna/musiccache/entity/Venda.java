/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 *
 * @author Bruna
 */
@Entity
@Table(name = "TB_VENDA")
public class Venda implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private int idvenda;
    @OneToMany(
        cascade = CascadeType.REMOVE,
        orphanRemoval = true
    )
//    @NotNull
    private List<VendaItem> itensvenda;
    @Temporal(TemporalType.TIMESTAMP)
//    @Null
    private Date dtvenda;
//    @Null
    private Double vltotalcashback;
//    @Null
    private Double vlTotal;
//    @Null
    private Double vlFinal;

    public Venda() {
    }

    public Venda(int idvenda, List<VendaItem> itensvenda, Date dtvenda, Double vltotalcashback, Double vlTotal, Double vlFinal) {
        this.idvenda = idvenda;
        this.itensvenda = itensvenda;
        this.dtvenda = dtvenda;
        this.vltotalcashback = vltotalcashback;
        this.vlTotal = vlTotal;
        this.vlFinal = vlFinal;
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public List<VendaItem> getItensvenda() {
        return itensvenda;
    }

    public void setItensvenda(List<VendaItem> itensvenda) {
        this.itensvenda = itensvenda;
    }

    public Date getDtvenda() {
        return dtvenda;
    }

    public void setDtvenda(Date dtvenda) {
        this.dtvenda = dtvenda;
    }

    public Double getVltotalcashback() {
        return vltotalcashback;
    }

    public void setVltotalcashback(Double vltotalcashback) {
        this.vltotalcashback = vltotalcashback;
    }

    public Double getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(Double vlTotal) {
        this.vlTotal = vlTotal;
    }

    public Double getVlFinal() {
        return vlFinal;
    }

    public void setVlFinal(Double vlFinal) {
        this.vlFinal = vlFinal;
    }
    
    

    @Override
    public String toString() {
        return "Venda{" + "idvenda=" + idvenda + ", itensvenda=" + itensvenda + ", dtvenda=" + dtvenda + ", vltotalcashback=" + vltotalcashback + ", vlTotal=" + vlTotal + ", vlFinal=" + vlFinal + '}';
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idvenda;
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
        final Venda other = (Venda) obj;
        if (this.idvenda != other.idvenda) {
            return false;
        }
        return true;
    }

    
}
