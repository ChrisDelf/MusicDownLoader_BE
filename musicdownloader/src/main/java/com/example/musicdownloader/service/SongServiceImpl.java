package com.example.musicdownloader.service;

import com.example.musicdownloader.Repository.SongRepository;
import com.example.musicdownloader.TerminalProcess.TerminalProcessMain;
import com.example.musicdownloader.Utilities.ListofFiles;

import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.requestBody.uploadRequest;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl {
    @Autowired
    private SongRepository songRepository;

    public int uploadSong(uploadRequest request) throws Exception {
        System.out.println(request);
        TerminalProcessMain uploadSong = new TerminalProcessMain();
        uploadSong.main(request);
        return 1;
    }

    public List<Song> getSongList() throws IOException {

       List<Song> songList = new ArrayList<>();
       songRepository.findAll()
               .iterator()
               .forEachRemaining(songList::add);
        return songList;

    };

    public File transferSongFile(String songName) {
        File songFile = new File("/home/chris/Documents/Music/"+ songName);

    return songFile;
    }
}
