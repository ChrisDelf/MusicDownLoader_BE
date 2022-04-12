package com.example.musicdownloader.Repository;


import com.example.musicdownloader.model.AddSong;
import org.springframework.data.repository.CrudRepository;

public interface AddSongRepository extends CrudRepository<AddSong, Long> {

    AddSong findById(long id);
}
