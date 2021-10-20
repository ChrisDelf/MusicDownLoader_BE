package com.example.musicdownloader.service;

import com.example.musicdownloader.dao.SongDao;
import com.example.musicdownloader.model.Song;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class SongService {
    private final SongDao songDao;


    @Autowired
    public SongService(@Qualifier("song") SongDao songDao) {
        this.songDao = songDao;
    }

    public int uploadSong(Song song, String songAddress) throws IOException {
        songDao.upLoadSong(song, songAddress);
        return 1;
    }

    public String getSongList() throws IOException {

        ArrayList<String> songList = new ArrayList<String>();
        songList = songDao.listOfSongs();
        String json = new Gson().toJson(songList);
        return json;

    };

    public File transferSongFile(String songName) {
        File songFile = new File("/home/dude/Documents/Music/"+ songName);

    return songFile;
    }
}
