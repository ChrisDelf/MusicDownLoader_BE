package com.example.musicdownloader.service;

import com.example.musicdownloader.Repository.AddPlaylistRepository;
import com.example.musicdownloader.Repository.AddSongRepository;
import com.example.musicdownloader.Repository.PlaylistRepository;
import com.example.musicdownloader.Repository.SongRepository;
import com.example.musicdownloader.exceptions.ResourceNotFoundException;
import com.example.musicdownloader.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistImpl implements PlaylistService{
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private AddSongRepository addSongRepository;

    @Autowired
    SongService songService;

    @Autowired
    private AddPlaylistRepository addPlaylistRepository;

    @Autowired
    private UserService userService;

    @Override
    public Playlist createPlaylist(Playlist playlist, Long userid) {
        Date date = new Date();
        playlist.setDate(date);
        playlistRepository.save(playlist);
        // if we have a user associated with the creation of this playlist then we add it to the join table
        User tempUser = userService.getUserById(userid);
        if (tempUser != null )
        {
            AddPlaylist newAddPlaylist = new AddPlaylist();
            newAddPlaylist.setPlaylist(playlist);
            newAddPlaylist.setUser(tempUser);
            addPlaylistRepository.save(newAddPlaylist);

        }

    return playlist;
    }

    @Override
    public void removePlaylist(Playlist playlist) {

    }

    @Override
    public Playlist updatePlaylist(Playlist playlist) {
        Playlist target_playlist = new Playlist();

        if(playlistRepository.findById(playlist.getId()) != null) {
            target_playlist = playlistRepository.findById(playlist.getId());
        }
        else {
            return null;
        }

        if(playlist.getName() != target_playlist.getName())
        {
            target_playlist.setName(playlist.getName());
        }

//        if (playlist.getSongs().size() != target_playlist.getSongs().size())
//        {
//            for (Song song: playlist.getSongs()) {
//
//
//                target_playlist.getSongs().add(song);
//
//
//            }
//            System.out.println(target_playlist.getSongs().get(0).getTitle());
//        }

        playlistRepository.save(target_playlist);

        return target_playlist;
    }



    @Override
    public List<Playlist> allPlaylist() {
        List<Playlist> playlists = new ArrayList<>();
        playlistRepository.findAll()
                .iterator()
                .forEachRemaining(playlists :: add);


        return playlists;
    }

    @Transactional
    @Override
    public Playlist getByPlaylistId(long id) throws ResourceNotFoundException {
        Playlist playlist = playlistRepository.findById(id);

        if (playlist == null)
        {
            throw new ResourceNotFoundException("The playlist was not found by the id of "+ id );
        }
        else
        {
            return playlist;
        }

    }

    @Transactional
    @Override
    public void addSong(long playlist_id, long song_id) {

        // we are going to create a unique instance of addSong so that song can remain untethered
        // basicly it stops the issue when someone adds the same song to their playlist it removes the previous key

        // instantiating our objects
        AddSong newAddSong = new AddSong();
        Song selectedSong = new Song();
        Playlist selectedPlaylist = new Playlist();

        // checking for the existence of our playlist in our database
       selectedPlaylist = Optional.ofNullable(playlistRepository.findById(playlist_id))
                .orElseThrow(() -> new ResourceNotFoundException("Playlist id of :"+ playlist_id+ " was not found!"));
        //checking for the existence  of our song in our database
        selectedSong = Optional.ofNullable(songRepository.findById(song_id))
                .orElseThrow(() -> new ResourceNotFoundException("Song of the id :"+ song_id + " was not found!"));


        // check to make soure that we have both a playlist and a song
        if (selectedPlaylist != null & selectedSong != null )
        {
            newAddSong.setSong(selectedSong);
            newAddSong.setPlaylist(selectedPlaylist);
            addSongRepository.save(newAddSong);

        }



        }
    @Transactional
    @Override
    public AddSong selectAddSong(long playlist_id, long song_id) {
        AddSong tempAddSong = addSongRepository.selectAddSong(playlist_id, song_id);

        return tempAddSong;
    }

    @Override
    public Playlist removeSong(long playlist_id, long song_id) {
        AddSong tempAddSong = selectAddSong(playlist_id, song_id);

        long id = tempAddSong.getId();

        Optional.ofNullable(addSongRepository.findById(id))
                .orElseThrow( () -> new ResourceNotFoundException("Add_Song id " + id + "not found!"));


        if (addSongRepository.findById(id) != null )
        {
            addSongRepository.deleteById(id);

            Playlist returnPlaylist = playlistRepository.findById(playlist_id);
            return returnPlaylist;
        }

        return null;
    }

    @Override
    public Playlist removeSongFromPlaylist(long id) {




        AddSong tempAddSong =  Optional.ofNullable(addSongRepository.findById(id))
                .orElseThrow( () -> new ResourceNotFoundException("Add_Song id " + id + "not found!"));


        if (addSongRepository.findById(id) != null )
        {
            long playlist_id = tempAddSong.getId();
            addSongRepository.deleteById(id);

            Playlist returnPlaylist = playlistRepository.findById(playlist_id);
            return returnPlaylist;
        }

        return null;
    }
}
