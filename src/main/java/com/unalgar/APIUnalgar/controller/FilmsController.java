package com.unalgar.APIUnalgar.controller;

import com.unalgar.APIUnalgar.entity.Card;
import com.unalgar.APIUnalgar.entity.Movie;
import com.unalgar.APIUnalgar.entity.ResultAPIMovie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/movies/")
public class FilmsController {

    @Value("${movies.api.url}")
    private String movieUrl;

    @Value("${movies.api.key}")
    private String moiveKey;

    public List<Movie> getMovies(Long page){
        try {
            String url = movieUrl + moiveKey + "&language=fr-FR&page=" + page;
            RestTemplate restTemplate = new RestTemplate();
            ResultAPIMovie response = restTemplate.getForObject(url, ResultAPIMovie.class);
            List<Movie>movieList = response.getResults();

            return movieList;
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("getCardMovies/{page}")
    public ResponseEntity<?> moviesToCards(@PathVariable("page")Long page){
        try {

            List<Movie>movieList = getMovies(page);
            List<Card>cardList = new ArrayList<>();
            for (Movie movie : movieList){
                Card card = Card.buildMovie(movie);
                cardList.add(card);
            }

            return ResponseEntity.ok(cardList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
