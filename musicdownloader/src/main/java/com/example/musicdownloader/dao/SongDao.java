package com.example.musicdownloader.dao;

import com.example.musicdownloader.model.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public interface SongDao {

    boolean addSong(Song song, String songAddress) throws IOException;

   Optional<Song> selectSongByName(String name);

   ArrayList<String> listOfSongs() throws IOException;

}
