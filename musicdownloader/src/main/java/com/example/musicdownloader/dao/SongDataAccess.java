package com.example.musicdownloader.dao;

import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;
import java.util.UUID;

public class SongDataAccess implements SongDao{


    /// allows for construct functions with the database
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SongDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int addSong(Song song, String songAddress) {
        // we need to check if the song exists already in our database

        String path = String.format("cd /home/dude/Documents/Music/", song.getGenre());
        String command = String.format("youtube-dl", songAddress);

        ProcessBuilder builder = new ProcessBuilder("/bin/bash",path, command);
        builder.redirectErrorStream(true);


        return 0;
    }

    @Override
    public Optional<Song> selectSongByName(String input) {
        String sql = "SELECT input, id FROM song input =?";
        Song song= jdbcTemplate.queryForObject(sql, new Object[]{input},(resultSet, i) -> {
            long id = resultSet.getLong("id");
            String name =  resultSet.getString("name");
            String genre = resultSet.getString("genre");
            String artest = resultSet.getString("artest");
            String date = resultSet.getString("date");
            return new Song(id, name,genre,artest,date);
        });
        return Optional.ofNullable(song);
    }
}
