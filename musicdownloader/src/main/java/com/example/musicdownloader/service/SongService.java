package com.example.musicdownloader.service;

import com.example.musicdownloader.model.Song;

import java.io.File;
import java.util.List;

public interface SongService {
    public int UpLoadSong(Song song, String songAddress);
    public List<Song> getSongList();
    public File transferSongFile(String songName);
}
