/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.repository;

import com.brito.bruna.musiccache.entity.Album;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Bruna
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AlbumRepositoryTests implements RepositoryTests{
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private AlbumRepository albumRepository;

    @Override
    @Before
    public void setup() {
        Album album = new Album();
        album.setArtists("teste1");
        album.setGenre("POP");
        album.setName("TESTE");
        album.setPrice(Double.parseDouble("10"));
        album.setType("album");    
        albumRepository.save(album);
    }

    @Override
    @Test
    public void testFindAll() throws Exception {
        List<Album> album = albumRepository.findAll();
        assertThat(album.size()).isGreaterThan(0);
    }

    @Override
    @Test
    public void testCreate() throws Exception {
        Album album = new Album();
        album.setArtists("teste");
        album.setGenre("POP");
        album.setName("TESTE");
        album.setPrice(Double.parseDouble("10"));
        album.setType("album");    
        albumRepository.save(album);
    }

    @Override
    @Test
    public void testEdit() throws Exception {
        List<Album> album = albumRepository.findAll();
        Album ab = album.get(0);
        ab.setType("alteracao");
        albumRepository.save(ab);
    }

    @Override
    @Test
    public void testRemove() throws Exception {
    }

    @Override
    @Test
    public void testFind() throws Exception {
    }

    @Override
    @Test
    public void testFindRange() throws Exception {
    }

    @Override
    @Test
    public void testCount() throws Exception {
    }
    
}
