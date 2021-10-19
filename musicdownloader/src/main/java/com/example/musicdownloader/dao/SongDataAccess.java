package com.example.musicdownloader.dao;

import com.example.musicdownloader.TerminalProcess.TerminalProcessMain;
import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.model.User;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.Optional;
import java.util.UUID;

@Repository("song")
public class SongDataAccess implements SongDao{


    /// allows for construct functions with the database
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SongDataAccess(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static void printStream(InputStream inputStream) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        }
    }

    @Override
    public int addSong(Song song, String songAddress) throws IOException {


        TerminalProcessMain downloader = new TerminalProcessMain();
        try {
            downloader.main(song);

        } catch (Exception e) {
            e.printStackTrace();
        }




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
