package com.example.musicdownloader.api;

import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.model.User;
import com.example.musicdownloader.service.SongService;
import com.example.musicdownloader.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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

    @PostMapping(value = "/musicdl",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> downloadSong(@RequestBody Song song
                                          ) throws URISyntaxException, IOException {
        songService.downloadSong(song, song.getSongAddress());


        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/musiclist",
    produces = {"applications/json"})
    public  ResponseEntity<?> getSongList() throws URISyntaxException, IOException {

        return new ResponseEntity<String>(songService.getSongList(), HttpStatus.OK);

    }

}
