package com.example.musicdownloader.service;

import com.example.musicdownloader.model.AddSong;
import com.example.musicdownloader.model.Playlist;
import com.example.musicdownloader.model.Song;

import java.util.List;

public interface PlaylistService {
    public Playlist createPlaylist(Playlist playlist);
    public void removePlaylist(Playlist playlist);
    public Playlist updatePlaylist(Playlist playlist);
    public List<Playlist> allPlaylist();
    public Playlist  getByPlaylistId(long id);

    public Playlist removeSong( long playlist_id , long song_id);
    void addSong( long playlist_id , long song_id);
    public AddSong selectAddSong(long playlist_id , long song_id);

}
