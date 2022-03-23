package com.example.musicdownloader.service;

import com.example.musicdownloader.model.Playlist;

public interface PlaylistService {
    public Playlist createPlaylist(Playlist playlist);
    public void removePlaylist(Playlist playlist);
    public Playlist updatePlaylist(Playlist playlist);
}
