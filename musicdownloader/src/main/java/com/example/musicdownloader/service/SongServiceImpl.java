package com.example.musicdownloader.service;

import com.example.musicdownloader.Repository.SongRepository;
import com.example.musicdownloader.TerminalProcess.TerminalProcessMain;
import com.example.musicdownloader.Utilities.ListofFiles;

import com.example.musicdownloader.model.Song;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class SongServiceImpl {
    private SongRepository songRepository;

    public int uploadSong(Song song, String songAddress) throws Exception {
        TerminalProcessMain downloadSong = new TerminalProcessMain();
        downloadSong.main(song);
        return 1;
    }

    public String getSongList() throws IOException {
        ListofFiles songFiles = new ListofFiles();
        ArrayList<String> songList = songFiles.main();
        String json = new Gson().toJson(songList);
        return json;

    };

    public File transferSongFile(String songName) {
        File songFile = new File("/home/dude/Documents/Music/"+ songName);

    return songFile;
    }
}
