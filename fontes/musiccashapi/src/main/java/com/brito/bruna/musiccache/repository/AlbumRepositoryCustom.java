/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.repository;

import com.brito.bruna.musiccache.entity.Album;

/**
 *
 * @author Bruna
 */

public interface AlbumRepositoryCustom{
    
    public void savewithdependence(Album album);
}
