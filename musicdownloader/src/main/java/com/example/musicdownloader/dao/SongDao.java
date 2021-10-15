package com.example.musicdownloader.dao;

import com.example.musicdownloader.model.Song;

import java.util.Optional;

public interface SongDao {

    int addSong(Song song, String songAddress);

   Optional<Song> selectSongByName(String name);

}
