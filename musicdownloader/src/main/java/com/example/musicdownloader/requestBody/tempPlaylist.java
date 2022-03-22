package com.example.musicdownloader.requestBody;

import com.example.musicdownloader.model.Song;

import java.util.ArrayList;

public class tempPlaylist {

    String PlayListName;

    ArrayList<Song> songs = new ArrayList<>();

    public tempPlaylist(String playListName, ArrayList<Song> songs) {
        PlayListName = playListName;
        this.songs = songs;
    }

    public String getPlayListName() {
        return PlayListName;
    }

    public void setPlayListName(String playListName) {
        PlayListName = playListName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
