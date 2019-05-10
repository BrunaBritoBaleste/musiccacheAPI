/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.util;

import com.brito.bruna.musiccache.entity.Album;
import com.brito.bruna.musiccache.entity.AlbumImage;
import com.brito.bruna.musiccache.entity.Artist;
import com.brito.bruna.musiccache.spotify.model.AlbumSpotify;
import com.brito.bruna.musiccache.spotify.model.ArtistSpotify;
import com.brito.bruna.musiccache.spotify.model.ImageSpotify;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruna
 */
public  class Convert {
    
    public static AlbumSpotify convertAlbumSimplifiedToAlbumSpotify(AlbumSimplified albumSimplified, String genre){
        AlbumSpotify album = new AlbumSpotify();
        album.setAlbumtype(albumSimplified.getAlbumType().getType());
        album.setGenre(genre);
        album.setId(albumSimplified.getId());
        album.setName(albumSimplified.getName());
        album.setReleasedate(null);
        album.setType(albumSimplified.getType().getType());
        
        //converte as imagens
        if(albumSimplified.getImages().length>0){
          List<ImageSpotify> imagens = new ArrayList<ImageSpotify>();
        for(int i=0; i<albumSimplified.getImages().length; i++){
            ImageSpotify image = new ImageSpotify();
            image.setHeight(albumSimplified.getImages()[i].getHeight());
            image.setUrl(albumSimplified.getImages()[i].getUrl());
            image.setWidth(albumSimplified.getImages()[i].getWidth());
            imagens.add(image);
        }
        album.setImages(imagens);
        }
        
        
        //converte os artistas
        if(albumSimplified.getArtists().length>0){
        List<ArtistSpotify> artists = new ArrayList<ArtistSpotify>();
        
        for(int j=0; j<albumSimplified.getArtists().length; j++){
            ArtistSpotify artist = new ArtistSpotify();
            artist.setId(albumSimplified.getArtists()[j].getId());
            artist.setName(albumSimplified.getArtists()[j].getName());
            artists.add(artist);
        }
        album.setArtists(artists);
         }
        return album;
    }
    
    public static Album convertAlbumSpotifyToAlbum(AlbumSpotify albumSpotify){
        
        if(albumSpotify==null){
            return null;
        }
        
        Album album = new Album();
        album.setGenre(albumSpotify.getGenre().toUpperCase());
        album.setName(albumSpotify.getName());
        album.setType(albumSpotify.getType());
        album.setPrice(Price.generatePrice());
        
         //converte as imagens
         if(albumSpotify.getImages()!=null){
        List<AlbumImage> imagens = new ArrayList<AlbumImage>();
        for(int i=0; i<albumSpotify.getImages().size(); i++){
            AlbumImage image = new AlbumImage();
            image.setHight(albumSpotify.getImages().get(i).getHeight());
            image.setUrl(albumSpotify.getImages().get(i).getUrl());
            image.setWidht(albumSpotify.getImages().get(i).getWidth());
            imagens.add(image);
        }
        album.setImages(imagens);
         } 
        
        //converte os artistas
        if(albumSpotify.getArtists()!=null){
            album.setArtists(albumSpotify.getArtists().get(0).getName());
        }
        return album;
    }
}
