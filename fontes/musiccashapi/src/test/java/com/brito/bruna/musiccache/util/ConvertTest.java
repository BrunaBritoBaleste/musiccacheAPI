/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.util;

import com.brito.bruna.musiccache.entity.Album;
import com.brito.bruna.musiccache.spotify.SpotifyAPI;
import com.brito.bruna.musiccache.spotify.model.AlbumSpotify;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Bruna
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConvertTest {
    
    @Autowired
    SpotifyAPI spotify;
    
        @Test
	public void convertAlbumSpotifyToAlbumTest() throws Exception {            
            List<AlbumSpotify> albuns = spotify.findAlbunsByGenre("POP");
            System.out.println("Album carregado"+albuns.get(0).getName());
            Album album = Convert.convertAlbumSpotifyToAlbum(albuns.get(0));
            assertThat(album).isNotNull();
	}
}
