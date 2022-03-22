package com.example.musicdownloader.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private long playlistId;


    private String name;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(mappedBy = "playlist",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JsonIgnoreProperties("playlist")
    private List<Song> playlistSongs = new ArrayList<>();

    public Playlist() {
    }

    public Playlist(String name) {
        name = name;
    }

    public long getId() {
        return playlistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public List<Song> getPlaylistSongs() {
        return playlistSongs;
    }

    public void setPlaylistSongs(List<Song> playlistSongs) {
        this.playlistSongs = playlistSongs;
    }
}
