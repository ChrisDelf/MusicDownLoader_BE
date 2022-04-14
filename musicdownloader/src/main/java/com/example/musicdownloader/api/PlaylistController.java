package com.example.musicdownloader.api;


import com.example.musicdownloader.model.Playlist;
import com.example.musicdownloader.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/user/playlist")
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PlaylistController {


    @Autowired
    private PlaylistService playlistService;


    @GetMapping(value = "/all")
    public ResponseEntity<List<Playlist>> getAllPlaylist()throws URISyntaxException, IOException
    {
        List<Playlist> tempList = new ArrayList<>();
        tempList = playlistService.allPlaylist();


        return new ResponseEntity<>(tempList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",
    produces = {"application/json"})
    public ResponseEntity<?> getPlaylistById(HttpServletRequest request, @PathVariable Long id)
    {
        Playlist tempPlaylist = playlistService.getByPlaylistId(id);
        return new ResponseEntity<>(tempPlaylist, HttpStatus.OK);
    }

    @PostMapping(value= "/create",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> createAPlaylist(HttpServletRequest request,
    @RequestBody
            Playlist playlist)throws URISyntaxException, IOException
    {


        playlistService.createPlaylist(playlist);

        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping(value= "/update/{songId}",
    consumes = {"application/json"},
    produces = {"application/json"})
    public ResponseEntity<?> update(HttpServletRequest request,
                                    @PathVariable Long songId,
                                    @RequestBody Playlist playlist)
    {
        playlistService.addSong(playlist.getId(), songId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove/{addSongId}",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> removeSong(HttpServletRequest request,
                                        @PathVariable Long addSongId,
                                        @RequestBody Playlist playlist) {
        Playlist tempPlaylist = playlistService.removeSongFromPlaylist(addSongId);


        return new ResponseEntity<Playlist>( tempPlaylist , HttpStatus.OK);
    }



}
