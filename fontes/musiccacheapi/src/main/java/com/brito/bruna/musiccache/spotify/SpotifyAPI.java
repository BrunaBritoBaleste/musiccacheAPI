/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.spotify;

import com.brito.bruna.musiccache.spotify.model.AlbumSpotify;
import java.util.List;

/**
 *
 * @author Bruna
 */
public interface SpotifyAPI {
    
    public void autenticar() throws Exception;
    
    public String[] loadGenres() throws Exception;
    
    public List<AlbumSpotify> findAlbunsByGenre(String genre) throws Exception;
}
