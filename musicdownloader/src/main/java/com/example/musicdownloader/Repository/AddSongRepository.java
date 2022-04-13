package com.example.musicdownloader.Repository;


import com.example.musicdownloader.model.AddSong;
import com.example.musicdownloader.view.JustTheCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AddSongRepository extends CrudRepository<AddSong, Long> {

    AddSong findById(long id);

    AddSong deleteById(long id);

    // Custom sreach that allows us to find the particular
    @Query(value = "SELECT * FROM  add_song WHERE add_song_FK_playlist_id = :playlist_id and add_song_FK_song_id = :song_id"
    , nativeQuery = true)
    AddSong selectAddSong(long playlist_id, long song_id);



}
