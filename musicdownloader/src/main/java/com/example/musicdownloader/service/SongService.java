package com.example.musicdownloader.service;

import com.example.musicdownloader.model.Playlist;
import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.requestBody.TerminalOutput;
import com.example.musicdownloader.requestBody.uploadRequest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface SongService {
    public TerminalOutput uploadSong(uploadRequest request) throws Exception;
    public List<Song> getSongList() throws IOException;
    public File transferSongFile(String songName);
    public ArrayList<Song> saveSong(ArrayList<Song> songs);
    public Song updateSong(Song song);
    public Song getSongById(long id);

}
