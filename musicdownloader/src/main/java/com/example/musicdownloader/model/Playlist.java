package com.example.musicdownloader.model;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;

    private String Name;

    public Playlist(UUID id, String name) {
        id = id;
        Name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
