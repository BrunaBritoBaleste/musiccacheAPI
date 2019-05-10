/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.spotify.model;

import java.util.logging.Logger;

/**
 *
 * @author Bruna
 */
public class ArtistSpotify {
    
    private String id;
    private String name;

    public ArtistSpotify() {
    }

    public ArtistSpotify(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ArtistSpotify{" + "id=" + id + ", name=" + name + '}';
    }
 
}
