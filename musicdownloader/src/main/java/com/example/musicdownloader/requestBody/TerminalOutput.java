package com.example.musicdownloader.requestBody;

import com.example.musicdownloader.model.Song;

import java.util.ArrayList;

public class TerminalOutput {

    String playlistName;

    ArrayList<Song> songs = new ArrayList<>();

    public TerminalOutput() {
    }

    public TerminalOutput(String playlistName, ArrayList<Song> songs) {
        this.playlistName = playlistName;
        this.songs = songs;
    }

    public String getPlayListName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
