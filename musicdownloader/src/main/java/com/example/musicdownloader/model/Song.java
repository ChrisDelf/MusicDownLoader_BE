package com.example.musicdownloader.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Song {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private final long id;

    private String name;

    private String genre;

    private String artest;

    private String date;

    public Song(long id) {
        this.id = id;
    }

    public Song(long id, String name, String genre, String artest, String date) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.artest = artest;
        this.date = date;
    }


    public String getArtest() {
        return artest;
    }

    public void setArtest(String artest) {
        this.artest = artest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
