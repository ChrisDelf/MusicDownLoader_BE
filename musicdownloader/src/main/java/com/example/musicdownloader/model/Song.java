package com.example.musicdownloader.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

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

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "playlistId",
    nullable = true)
    @JsonIgnoreProperties("Song")
    private Playlist playlist;



    public Song() {
    }

    public Song(String title, String genre, String artist, Playlist playlist) {

        this.title = title;
        this.genre = genre;
        this.artist = artist;


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


}
