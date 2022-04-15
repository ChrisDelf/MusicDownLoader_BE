package com.example.musicdownloader.service;

import com.example.musicdownloader.model.AddSong;
import com.example.musicdownloader.model.Playlist;

import java.util.List;

public interface PlaylistService {
    public Playlist createPlaylist(Playlist playlist, Long userid);
    public void removePlaylist(Playlist playlist);
    public Playlist updatePlaylist(Playlist playlist);
    public List<Playlist> allPlaylist();
    public Playlist  getByPlaylistId(long id);

    public Playlist removeSong( long playlist_id , long song_id);
    void addSong( long playlist_id , long song_id);
    public AddSong selectAddSong(long playlist_id , long song_id);
    public Playlist removeSongFromPlaylist(long addSong_id);

}
