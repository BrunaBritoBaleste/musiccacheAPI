/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.spotify.model;

import java.util.List;

/**
 *
 * @author Bruna
 */
public class AlbumSpotify {
    
    private String albumtype;
    private List<ArtistSpotify> artists;
    private List<ImageSpotify> images;
    private String genre;
    private String id;
    private String type;
    private String releasedate;
    private String name;

    public AlbumSpotify() {
    }

    public AlbumSpotify(String albumtype, List<ArtistSpotify> artists, List<ImageSpotify> images, String genre, String id, String type, String releasedate, String name) {
        this.albumtype = albumtype;
        this.artists = artists;
        this.images = images;
        this.genre = genre;
        this.id = id;
        this.type = type;
        this.releasedate = releasedate;
        this.name = name;
    }

    public String getAlbumtype() {
        return albumtype;
    }

    public void setAlbumtype(String albumtype) {
        this.albumtype = albumtype;
    }

    public List<ArtistSpotify> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistSpotify> artists) {
        this.artists = artists;
    }

    public List<ImageSpotify> getImages() {
        return images;
    }

    public void setImages(List<ImageSpotify> images) {
        this.images = images;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AlbumSpotify{" + "albumtype=" + albumtype + ", artists=" + artists + ", images=" + images + ", genre=" + genre + ", id=" + id + ", type=" + type + ", releasedate=" + releasedate + ", name=" + name + '}';
    }  
}
