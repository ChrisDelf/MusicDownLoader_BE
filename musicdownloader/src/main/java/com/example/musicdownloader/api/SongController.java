package com.example.musicdownloader.api;


import com.example.musicdownloader.model.Playlist;
import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.requestBody.TerminalOutput;
import com.example.musicdownloader.requestBody.uploadRequest;
import com.example.musicdownloader.service.PlaylistService;
import com.example.musicdownloader.service.SongServiceImpl;
import com.example.musicdownloader.service.UserServiceImpl;
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
    private  SongServiceImpl songServiceImpl;





    @PostMapping(value = "/upload",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> uploadSong(@RequestBody uploadRequest request) throws Exception {
        ArrayList<Song> songs = new ArrayList<>();
        TerminalOutput terminalOutput = new TerminalOutput();
        terminalOutput = songServiceImpl.uploadSong(request);
        songs = songServiceImpl.saveSong(terminalOutput.getSongs());


        if (terminalOutput.getPlayListName() != null )
        {   Playlist newPlaylist = new Playlist();
            newPlaylist.setSongs(songs);
            newPlaylist.setName(terminalOutput.getPlayListName());
            playlistService.createPlaylist(newPlaylist);

            for (Song song : terminalOutput.getSongs()) {
                song.setPlaylist(playlistService.getByPlaylistId( newPlaylist.getId()));
                songServiceImpl.updateSong(song);

            }
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/music_list")
    public  ResponseEntity<List<Song>> getSongList() throws URISyntaxException, IOException {
        List<Song> tempList = songServiceImpl.getSongList();

        return new ResponseEntity<>(tempList, HttpStatus.OK);

    }

    @GetMapping(value = "/download",
            consumes = {"application/json"})
    public  ResponseEntity<Object> getSongFile(@RequestBody Song song ) throws URISyntaxException, IOException {
        File songFile = songServiceImpl.transferSongFile(song.getTitle());


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