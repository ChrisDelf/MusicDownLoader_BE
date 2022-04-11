package com.example.musicdownloader.Repository;

import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.view.JustTheCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
    Song findById(long id);
    @Query( value = "SELECT COUNT(*) as count FROM song_id WHERE song_id = :song_id and playlist_id = :playlist_id",
    nativeQuery = true)
    JustTheCount checkSong(long song_id, long playlist_id);
}
