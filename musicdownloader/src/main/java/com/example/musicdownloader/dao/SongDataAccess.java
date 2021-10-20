package com.example.musicdownloader.dao;

import com.example.musicdownloader.TerminalProcess.TerminalProcessMain;
import com.example.musicdownloader.Utilities.ListofFiles;
import com.example.musicdownloader.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

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
    public boolean upLoadSong(Song song, String songAddress) throws IOException {
        boolean isDownload = false;

        TerminalProcessMain downloader = new TerminalProcessMain();
        try {
           isDownload = downloader.main(song);

        } catch (Exception e) {
            e.printStackTrace();
        }



    return isDownload;

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

    @Override
    public ArrayList<String> listOfSongs() throws IOException {
        ListofFiles listOfSongs = new ListofFiles();

        return  listOfSongs.main();
    }

    @Override
    public File selectSongFile(String name) {
        File songFile = new File("name");



        return songFile;
    }
}
