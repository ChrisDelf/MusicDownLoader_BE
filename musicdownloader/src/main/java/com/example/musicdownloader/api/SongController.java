package com.example.musicdownloader.api;


import com.example.musicdownloader.model.AddSong;
import com.example.musicdownloader.model.Playlist;
import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.requestBody.TerminalOutput;
import com.example.musicdownloader.requestBody.uploadRequest;
import com.example.musicdownloader.service.PlaylistService;
import com.example.musicdownloader.service.SongService;
import com.example.musicdownloader.service.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/user/song")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SongController {


    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private SongService songService;

    @PostMapping(value = "/upload",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> uploadSong(@RequestBody uploadRequest request) throws Exception {
        ArrayList<Song> songs = new ArrayList<>();
        ArrayList<AddSong> playlistSong = new ArrayList<>();
        TerminalOutput terminalOutput = new TerminalOutput();
        terminalOutput = songService.uploadSong(request);
        songs = songService.saveSong(terminalOutput.getSongs());


        if (terminalOutput.getPlayListName() != null )
        {   Playlist newPlaylist = new Playlist();
            newPlaylist.setName(terminalOutput.getPlayListName());
            playlistService.createPlaylist(newPlaylist);

            for (Song song : terminalOutput.getSongs()) {

                playlistService.addSong(newPlaylist.getId() ,song.getId());



            }





        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/music_list")
    public  ResponseEntity<List<Song>> getSongList() throws URISyntaxException, IOException {
        List<Song> tempList = songService.getSongList();

        return new ResponseEntity<>(tempList, HttpStatus.OK);

    }

    @GetMapping(value = "/download",
            consumes = {"application/json"})
    public  ResponseEntity<Object> getSongFile(@RequestBody Song song ) throws URISyntaxException, IOException {
        File songFile = songService.transferSongFile(song.getTitle());


        InputStreamResource resource = new InputStreamResource(new FileInputStream(songFile));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", songFile.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object>
                responseEntity = ResponseEntity.ok().headers(headers).contentLength(songFile.length()).contentType(
                MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;

    }
}
