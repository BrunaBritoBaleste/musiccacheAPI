/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;

/**
 *
 * @author Bruna
 */
@Entity
@Table(name = "TB_VENDA_ITEM")
public class VendaItem implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private int id;
    @ManyToOne
    private Album album;
//    @Null
    private Double valor;
//    @Null
    private Double valorcashback;
//    @Null
    private Double perccashback;
    @ManyToOne
    private Venda idVenda;

    public VendaItem() {
    }

    public VendaItem(int id, Album album, Double valor, Double valorcashback, Double perccashback, Venda idVenda) {
        this.id = id;
        this.album = album;
        this.valor = valor;
        this.valorcashback = valorcashback;
        this.perccashback = perccashback;
        this.idVenda = idVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValorcashback() {
        return valorcashback;
    }

    public void setValorcashback(Double valorcashback) {
        this.valorcashback = valorcashback;
    }

    public Double getPerccashback() {
        return perccashback;
    }

    public void setPerccashback(Double perccashback) {
        this.perccashback = perccashback;
    }

    @JsonIgnore
    public Venda getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Venda idVenda) {
        this.idVenda = idVenda;
    }

    @Override
    public String toString() {
        return "VendaItem{" + "id=" + id + ", album=" + album + ", valor=" + valor + ", valorcashback=" + valorcashback + ", perccashback=" + perccashback + '}';
    }

    

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final VendaItem other = (VendaItem) obj;
        return true;
    }

    
}
