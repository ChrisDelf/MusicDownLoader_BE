package com.example.musicdownloader.service;

import com.example.musicdownloader.model.Playlist;
import com.example.musicdownloader.model.Song;

import java.util.List;

public interface PlaylistService {
    public Playlist createPlaylist(Playlist playlist);
    public void removePlaylist(Playlist playlist);
    public Playlist updatePlaylist(Playlist playlist);
    public List<Playlist> allPlaylist();
    public Playlist  getByPlaylistId(long id);
    public void addSong(Long songId , Playlist playlist);

    void addSong( long playlist_id , long song_id);

}
