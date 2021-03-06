package com.example.musicdownloader.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "add_playlist")
public class AddPlaylist implements Serializable {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private long id;


    @ManyToOne
    @JoinColumn(name = "add_playlist_FK_playlist_id")
    @JsonIgnoreProperties("addPlaylist")
    private Playlist playlist;

    
    @ManyToOne
    @JoinColumn(name = "add_playlist_FK_user_id")
    @JsonIgnoreProperties("user")
    private User user;

    public AddPlaylist() {
    }

    public long getId() {
        return id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
