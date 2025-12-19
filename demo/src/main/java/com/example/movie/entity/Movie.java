package com.example.movie.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String genre;
    private Double priceTicked;
    //Constructor

    public Movie(Integer id, String genre, String title, Double priceTicked) {
        this.id = id;
        this.genre = genre;
        this.title = title;
        this.priceTicked = priceTicked;
    }

    //Getter Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPriceTicked() {
        return priceTicked;
    }

    public void setPriceTicked(Double priceTicked) {
        this.priceTicked = priceTicked;
    }
}
