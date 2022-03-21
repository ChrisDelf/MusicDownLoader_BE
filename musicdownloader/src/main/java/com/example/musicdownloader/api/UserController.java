package com.example.musicdownloader.api;

import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.model.User;
import com.example.musicdownloader.requestBody.uploadRequest;
import com.example.musicdownloader.service.SongServiceImpl;
import com.example.musicdownloader.service.UserServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/user")
@RestController
public class UserController {
    private final UserServiceImpl userServiceImpl;


    private final SongServiceImpl songServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl, SongServiceImpl songServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.songServiceImpl = songServiceImpl;
    }
    @PostMapping
    public void addUser( @NonNull @RequestBody User user) {
        userServiceImpl.addUser(user);

    }

    @GetMapping
    public List<User> getAllUsers() {

        return userServiceImpl.getAllUser();
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") UUID id)
    {

        return userServiceImpl.getUserById(id);

    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") UUID id)
    {
        userServiceImpl.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@NonNull @RequestBody User user, @PathVariable("id") UUID id)
    {
        userServiceImpl.updateUser(id, user);
    }
    /// Music related endpoitns
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/upload",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> uploadSong(@RequestBody uploadRequest request) throws Exception {
        ArrayList<Song> songsDownloaded = new ArrayList<Song>();
        songsDownloaded = songServiceImpl.uploadSong(request);

        songServiceImpl.saveSong(songsDownloaded);




        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/musiclist",
    produces = {"applications/json"})
    public  ResponseEntity<?> getSongList() throws URISyntaxException, IOException {
      List<Song> tempList = songServiceImpl.getSongList();
        String json = new Gson().toJson(tempList);
        return new ResponseEntity<>(json, HttpStatus.OK);

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

    @GetMapping(value = "/play",
    consumes = {"application/json"})
    public ResponseEntity<Object> playSong(@RequestBody Song song) throws URISyntaxException, IOException {

        
        return new ResponseEntity<Object>( HttpStatus.OK);
    }
}
