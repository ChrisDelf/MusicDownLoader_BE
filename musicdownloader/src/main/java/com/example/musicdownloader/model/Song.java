package com.example.musicdownloader.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private long id;

    private String title;

    private String genre;

    private String artist;

    private Date date;




    public Song() {
    }

    public Song( String title, String genre, String artist, Date date) {

        this.title = title;
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


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
