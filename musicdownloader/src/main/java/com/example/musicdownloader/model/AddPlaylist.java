package com.example.musicdownloader.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "add_song")
public class AddPlaylist implements Serializable {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private long id;

    @Id
    @ManyToOne
    @JoinColumn(name = "playlist_id")
    @JsonIgnoreProperties("addPlaylist")
    private Playlist playlist;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("user_roles")
    private User user;

    public AddPlaylist() {
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
