package com.example.musicdownloader.Repository;

import com.example.musicdownloader.model.AddPlaylist;
import org.springframework.data.repository.CrudRepository;

public interface AddPlaylistRepository extends CrudRepository<AddPlaylist, Long> {

    AddPlaylist findById(long id);


}
