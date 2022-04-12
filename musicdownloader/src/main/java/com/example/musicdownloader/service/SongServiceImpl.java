package com.example.musicdownloader.service;

import com.example.musicdownloader.Repository.SongRepository;
import com.example.musicdownloader.TerminalProcess.TerminalProcessMain;
import com.example.musicdownloader.Utilities.ListofFiles;

import com.example.musicdownloader.exceptions.ResourceNotFoundException;
import com.example.musicdownloader.model.Playlist;
import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.requestBody.uploadRequest;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.musicdownloader.requestBody.TerminalOutput;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SongServiceImpl implements SongService{
    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SongService songService;


    @Override
    public TerminalOutput uploadSong(uploadRequest request) throws Exception {
        TerminalOutput tempOutput = new TerminalOutput();
        System.out.println(request);
        TerminalProcessMain uploadSong = new TerminalProcessMain();
       tempOutput = uploadSong.main(request);
       // if the terminalOutput includes a name that means we are dealing with a playlist

        return tempOutput;
    }

    @Override
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



    @Override
    public ArrayList<Song> saveSong(ArrayList<Song> songs) {


            for (Song song : songs) {
                Date date = new Date();
                song.setDate(date);
                songRepository.save(song);

        }


        return songs;
    }

    @Override
    public Song getSongById(long id) throws ResourceNotFoundException {
        Song song = songRepository.findById(id);

        if (song == null)
        {
            throw new ResourceNotFoundException("The song by the id of " + id + "was not found");

        }
        else
        {
            return song;
        }


    }

    @Override
    public Song updateSong(Song song) {
        Song target_song = songService.getSongById(song.getId());

        if (target_song == null) {
            return null;
        }


        songRepository.save(target_song);
        return target_song;
    }
}
