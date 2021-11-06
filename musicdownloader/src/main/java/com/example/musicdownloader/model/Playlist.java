package com.example.musicdownloader.model;

import java.util.UUID;

public class Playlist {

    private final UUID id;

    String Name;

    public Playlist(UUID id, String name) {
        this.id = id;
        Name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
