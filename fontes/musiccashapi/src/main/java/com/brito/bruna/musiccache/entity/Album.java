/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.entity;

import com.wrapper.spotify.model_objects.specification.ArtistSimplified;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Bruna
 */

@Entity
@Table(name = "TB_ALBUM")
public class Album implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;
    private String genre;
    private String type;
    @OneToMany
    private List<AlbumImage> images;
    private String artists;
    private Double price;

    public Album() {
    }

    public Album(Long id, String name, String genre, String type, List<AlbumImage> images, String artists, Double price) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.type = type;
        this.images = images;
        this.artists = artists;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AlbumImage> getImages() {
        return images;
    }

    public void setImages(List<AlbumImage> images) {
        this.images = images;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", name=" + name + ", genre=" + genre + ", type=" + type + ", images=" + images + ", artists=" + artists + ", price=" + price + '}';
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
        final Album other = (Album) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
}
