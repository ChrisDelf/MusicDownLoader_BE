package com.example.musicdownloader.dao;

import com.example.musicdownloader.model.Song;

import java.io.IOException;
import java.util.Optional;

public interface SongDao {

    int addSong(Song song, String songAddress) throws IOException;

   Optional<Song> selectSongByName(String name);

}
