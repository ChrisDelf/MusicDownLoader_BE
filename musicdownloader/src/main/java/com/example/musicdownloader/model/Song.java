package com.example.musicdownloader.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String genre;

    private String artist;

    private Date date;




    public Song() {
    }

    public Song(long id, String name, String genre, String artist, Date date) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.artist = artist;
        this.date = date;

    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
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


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
