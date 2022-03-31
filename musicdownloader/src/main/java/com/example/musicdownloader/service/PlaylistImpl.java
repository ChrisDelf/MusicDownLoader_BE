package com.example.musicdownloader.service;

import com.example.musicdownloader.Repository.PlaylistRepository;
import com.example.musicdownloader.exceptions.ResourceNotFoundException;
import com.example.musicdownloader.model.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PlaylistImpl implements PlaylistService{
    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private PlaylistService playlistService;

    @Override
    public Playlist createPlaylist(Playlist playlist) {
        Date date = new Date();
        playlist.setDate(date);

    playlistRepository.save(playlist);

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

        if (playlist.getSongs().size() != target_playlist.getSongs().size())
        {
            target_playlist.setSongs(playlist.getSongs());
        }

      //  playlistRepository.save(target_playlist);

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
}
