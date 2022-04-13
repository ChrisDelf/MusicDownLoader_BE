package com.example.musicdownloader.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "add_song")
public class AddSong implements Serializable {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private long id;


    @ManyToOne
//    @Transient
    @JoinColumn(name = "add_song_FK_song_id")
    @JsonIgnoreProperties("addsong")
    private Song song;


    @ManyToOne
   // @Transient
    @JoinColumn(name = "add_song_FK_playlist_id" )
    @JsonIgnoreProperties("playlist")
    private Playlist playlist;

    public AddSong() {
    }

    public AddSong(Song song, Playlist playlist) {
        this.song = song;
        this.playlist = playlist;
    }

    public long getId() {
        return id;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
