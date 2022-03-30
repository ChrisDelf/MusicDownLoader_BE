package com.example.musicdownloader.api;


import com.example.musicdownloader.model.Playlist;
import com.example.musicdownloader.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
