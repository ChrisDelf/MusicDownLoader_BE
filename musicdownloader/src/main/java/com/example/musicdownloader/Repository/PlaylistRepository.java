package com.example.musicdownloader.Repository;

import com.example.musicdownloader.model.Playlist;
import org.springframework.data.repository.CrudRepository;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
    Playlist findById(long id);


}
