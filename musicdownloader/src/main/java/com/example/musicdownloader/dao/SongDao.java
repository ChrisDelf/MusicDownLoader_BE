package com.example.musicdownloader.dao;

import com.example.musicdownloader.model.Song;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public interface SongDao {

    boolean upLoadSong(Song song, String songAddress) throws IOException;

   Optional<Song> selectSongByName(String name);

   File selectSongFile(String name);

   ArrayList<String> listOfSongs() throws IOException;





}
