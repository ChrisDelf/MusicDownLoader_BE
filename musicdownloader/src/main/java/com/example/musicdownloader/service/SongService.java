package com.example.musicdownloader.service;

import com.example.musicdownloader.model.Song;

import java.io.File;

public interface SongService {
    public int UpLoadSong(Song song, String songAddress);
    public String getSongList();
    public File transferSongFile(String songName);
}
