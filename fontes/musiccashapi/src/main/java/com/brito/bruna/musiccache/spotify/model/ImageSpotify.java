/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.spotify.model;

/**
 *
 * @author Bruna
 */
public class ImageSpotify {
    
    private Integer height;
    private Integer width;
    private String url;

    public ImageSpotify() {
    }

    public ImageSpotify(Integer height, Integer width, String url) {
        this.height = height;
        this.width = width;
        this.url = url;
    }
 
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImageSpotify{" + "height=" + height + ", width=" + width + ", url=" + url + '}';
    }

}
