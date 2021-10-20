package com.example.musicdownloader.api;

import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.model.User;
import com.example.musicdownloader.service.SongService;
import com.example.musicdownloader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/user")
@RestController
public class UserController {
    private final UserService userService;


    private final SongService songService;

    @Autowired
    public UserController(UserService userService, SongService songService) {
        this.userService = userService;
        this.songService = songService;
    }
    @PostMapping
    public void addUser(@Valid @NonNull @RequestBody User user) {
        userService.addUser(user);

    }

    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUser();
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") UUID id)
    {

        return userService.getUserById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") UUID id)
    {
        userService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@Valid @NonNull @RequestBody User user, @PathVariable("id") UUID id)
    {
        userService.updateUser(id, user);
    }
    /// Music related endpoitns

    @PostMapping(value = "/upload",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> downloadSong(@RequestBody Song song
                                          ) throws URISyntaxException, IOException {
        songService.uploadSong(song, song.getSongAddress());


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/musiclist",
    produces = {"applications/json"})
    public  ResponseEntity<?> getSongList() throws URISyntaxException, IOException {

        return new ResponseEntity<String>(songService.getSongList(), HttpStatus.OK);

    }

    @GetMapping(value = "/download",
            consumes = {"application/json"})
    public  ResponseEntity<Object> getSongFile(@RequestBody Song song ) throws URISyntaxException, IOException {
        File songFile = songService.transferSongFile(song.getName());


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
