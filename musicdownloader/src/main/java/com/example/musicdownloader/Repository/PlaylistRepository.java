package com.example.musicdownloader.Repository;

import com.example.musicdownloader.model.Playlist;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
    Playlist findById(long id);



}
