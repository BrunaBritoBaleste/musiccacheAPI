package com.brito.bruna.musiccache;

import com.brito.bruna.musiccache.entity.VigentCashbackTable;
import com.brito.bruna.musiccache.repository.AlbumRepository;
import com.brito.bruna.musiccache.repository.VigentCashbackTableRepository;
import com.brito.bruna.musiccache.spotify.SpotifyAPI;
import com.brito.bruna.musiccache.spotify.model.AlbumSpotify;
import com.brito.bruna.musiccache.util.Convert;
import com.brito.bruna.musiccache.util.LoadVigentCashbackTable;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ComponentScan
@SpringBootApplication
@EnableJpaRepositories
public class MusiccacheApplication extends SpringBootServletInitializer implements WebApplicationInitializer,WebMvcConfigurer{

    @Autowired
    SpotifyAPI spotify;

    @Autowired
    AlbumRepository albumRepository;
    
    @Autowired
    VigentCashbackTableRepository vigentCashbackTableRepository;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new SpecificationArgumentResolver());
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MusiccacheApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MusiccacheApplication.class, args);
    }
    
    @PreDestroy()
    private void exitApplication()
    {
        System.out.println("Encerrando a Aplicação");
        
    }

    @PostConstruct
    private void loadAlbum() {

        //realiza a autenticação no serviço spotify
        try {
            System.out.println("Carregando biblioteca de discos de spotify. Este processo pode demorar alguns minutos. Aguarde...");
            spotify.autenticar();
            String[] genres = spotify.loadGenres();
            for (int i = 0; i < genres.length; i++) {              
                List<AlbumSpotify> albuns = spotify.findAlbunsByGenre(genres[i]);
                if (albuns != null) {
                    System.out.println("#########" + genres[i] + "##########");
                    for (int j = 0; j < albuns.size(); j++) {
                        albumRepository.savewithdependence(Convert.convertAlbumSpotifyToAlbum(albuns.get(j)));
                        System.out.println("Álbum Inserido: " + albuns.get(j).getName());
                    }
                }
            }
            System.out.println("Biblioteca de discos carregada com sucesso!");
            
            System.out.println("Setando tabela de cashback por genero musical");
            List<VigentCashbackTable> cashbacklist = LoadVigentCashbackTable.loadCashbackTable();
            
            for(int k=0; k<cashbacklist.size(); k++){
                vigentCashbackTableRepository.save(cashbacklist.get(k));
            }
            System.out.println("Tabela de cashback setada com sucesso!");
        } catch (Exception e) {         
            System.out.println("Erro ao carregar dados para inicialização: " + e.getMessage());
             exitApplication();
             System.exit(0);
        }
    }

}
