package com.unalgar.APIUnalgar.entity;

public class Card {

    private Long id;
    private String title;
    private String img;
    private String date;

    public Card() {
    }

    public Card(Long id, String title, String img, String date) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.date = date;
    }

    public static Card buildMovie(Movie movie){
        return new Card(movie.getId(), movie.getTitle(), movie.getBackdrop_path(), movie.getRelease_date());
    }

    public static Card buildPokemon(Pokemon pokemon){
        return new Card(pokemon.getId(), pokemon.getName(), pokemon.getImage(), pokemon.getPokedexId().toString());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
