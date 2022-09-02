package com.unalgar.APIUnalgar.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Pokemon {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("pokedexId")
    private Long pokedexId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("image")
    private String image;


    public Pokemon() {
    }

    public Pokemon(Long id, Long pokedexId, String name, String image) {
        this.id = id;
        this.pokedexId = pokedexId;
        this.name = name;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPokedexId() {
        return pokedexId;
    }

    public void setPokedexId(Long pokedexId) {
        this.pokedexId = pokedexId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
