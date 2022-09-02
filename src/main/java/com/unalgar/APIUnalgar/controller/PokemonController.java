package com.unalgar.APIUnalgar.controller;

import com.unalgar.APIUnalgar.entity.Card;
import com.unalgar.APIUnalgar.entity.Pokemon;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/pokemons/")
public class PokemonController {

    @Value("${pokemon.api.url}")
    private String pokemonUrl;

    public List<Pokemon> getPokemons(){
        try{
            WebClient webClient = WebClient.builder()
                    .baseUrl(pokemonUrl)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .build();

            Flux<Pokemon> pokemonMono = webClient.get().uri("pokemon/limit/151").retrieve().bodyToFlux(Pokemon.class);
            List<Pokemon> pokemon = pokemonMono.collectList().block();
            return pokemon;
        }catch (Exception e){
            return null;
        }
    }

    @GetMapping("getPokemonsCards")
    public ResponseEntity<?> PokemonToCard(){
        try {
            List<Pokemon>pokemons = getPokemons();
            List<Card>cards = new ArrayList<>();
            for (Pokemon pokemon : pokemons){
                Card card = Card.buildPokemon(pokemon);
                cards.add(card);
            }
            return ResponseEntity.ok(cards);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}