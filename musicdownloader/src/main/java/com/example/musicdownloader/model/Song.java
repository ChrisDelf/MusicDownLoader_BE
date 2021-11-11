package com.example.musicdownloader.model;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private final long id;

    private String name;

    private String genre;

    private String artist;

    private String downloadDate;

    private String songAddress;

    public Song(long id) {
        this.id = id;
    }

    public Song(long id, String name, String genre, String artist, String downloadDate) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.artist = artist;
        this.downloadDate = downloadDate;
    }

    public String getSongAddress() {
        return songAddress;
    }

    public void setSongAddress(String songAddress) {
        this.songAddress = songAddress;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDownloadDate() {
        return downloadDate;
    }

    public void setDownloadDate(String downloadDate) {
        this.downloadDate = downloadDate;
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
