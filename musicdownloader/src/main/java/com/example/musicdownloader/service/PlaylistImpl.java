package com.example.musicdownloader.service;

import com.example.musicdownloader.Repository.PlaylistRepository;
import com.example.musicdownloader.model.Playlist;
import org.springframework.beans.factory.annotation.Autowired;

public class PlaylistImpl implements PlaylistService{
    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public Playlist createPlaylist(Playlist playlist) {
    playlistRepository.save(playlist);

    return playlist;
    }

    @Override
    public void removePlaylist(Playlist playlist) {

    }

    @Override
    public Playlist updatePlaylist(Playlist playlist) {
        return null;
    }
}
