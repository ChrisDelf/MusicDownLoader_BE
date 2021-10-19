package com.example.musicdownloader.service;

import com.example.musicdownloader.dao.SongDao;
import com.example.musicdownloader.dao.UserDao;
import com.example.musicdownloader.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SongService {
    private final SongDao songDao;


    @Autowired
    public SongService(@Qualifier("song") SongDao songDao) {
        this.songDao = songDao;
    }

    public int downloadSong(Song song, String songAddress) throws IOException {
        songDao.addSong(song, songAddress);
        return 1;
    }
}
