package com.example.musicdownloader.api;

import com.example.musicdownloader.Repository.PlaylistRepository;
import com.example.musicdownloader.model.Playlist;
import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.model.User;
import com.example.musicdownloader.requestBody.TerminalOutput;
import com.example.musicdownloader.requestBody.uploadRequest;
import com.example.musicdownloader.service.PlaylistService;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/user")
@RestController
public class UserController {









}
