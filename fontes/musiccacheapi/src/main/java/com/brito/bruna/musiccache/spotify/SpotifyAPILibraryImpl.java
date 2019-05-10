/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brito.bruna.musiccache.spotify;

import com.brito.bruna.musiccache.spotify.model.AlbumSpotify;
import com.brito.bruna.musiccache.util.Convert;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.browse.miscellaneous.GetAvailableGenreSeedsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchAlbumsRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bruna
 */
@Component
public class SpotifyAPILibraryImpl implements SpotifyAPI{
    
    @Value("${spotify.key.client}") 
    private String clietkey;
    
    @Value("${spotify.key.client.secret}") 
    private String clietsecretkey;
    
    private SpotifyApi spotifyApi;
    
    private ClientCredentialsRequest clientCredentialsRequest;
    
    private ClientCredentials clientCredentials;

    @Override
    public void autenticar() throws Exception{
      this.spotifyApi = new SpotifyApi.Builder()
          .setClientId(clietkey)
          .setClientSecret(clietsecretkey)
          .build();
       //cria o client request
      this.clientCredentialsRequest = spotifyApi.clientCredentials().build();
      //autentica o client com base nas credenciais  
      this.clientCredentials = clientCredentialsRequest.execute();
       //seta o token 
      spotifyApi.setAccessToken(clientCredentials.getAccessToken());    
    
    }

    @Override
    public String[] loadGenres() throws Exception{
       GetAvailableGenreSeedsRequest getAvailableGenreSeedsRequest = this.spotifyApi.getAvailableGenreSeeds().build();
       return getAvailableGenreSeedsRequest.execute();    }

    @Override
    public List<AlbumSpotify> findAlbunsByGenre(String genre) throws Exception{
           
          List<AlbumSpotify> albuns = null;
        
          SearchAlbumsRequest searchAlbumsRequest = spotifyApi.searchAlbums(genre)
          .limit(50)
          .build();
           
          Paging<AlbumSimplified> albumSimplifiedPaging = searchAlbumsRequest.execute(); 
          
          if(albumSimplifiedPaging.getItems().length>0){
              albuns = new ArrayList<AlbumSpotify>();
              
              for(int i=0; i<albumSimplifiedPaging.getItems().length; i++){
                  albuns.add(Convert.convertAlbumSimplifiedToAlbumSpotify(albumSimplifiedPaging.getItems()[i], genre));
              }
          }
          
          return albuns;
    }
    
}
