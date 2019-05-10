/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.entity;

import java.io.Serializable;
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
@Table(name = "TB_ALBUM_IMAGE")
public class AlbumImage implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private int id;
    private int widht;
    private int hight;
    private String url;

    public AlbumImage() {
    }

    public AlbumImage(int id, int widht, int hight, String url) {
        this.id = id;
        this.widht = widht;
        this.hight = hight;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWidht() {
        return widht;
    }

    public void setWidht(int widht) {
        this.widht = widht;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "AlbumImage{" + "id=" + id + ", widht=" + widht + ", hight=" + hight + ", url=" + url + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
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
        final AlbumImage other = (AlbumImage) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    

}
