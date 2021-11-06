package com.example.musicdownloader.Repository;

import com.example.musicdownloader.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
    Song findBySongId(long id);
}
