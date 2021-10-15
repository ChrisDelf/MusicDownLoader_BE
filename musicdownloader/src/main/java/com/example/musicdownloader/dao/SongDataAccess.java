package com.example.musicdownloader.dao;

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
        // we need to check if the song exists already in our database
// "/usr/bin/python",
        // /var/lib/snapd/snap/bin/youtube-dl
        String path = String.format("/home/dude/Documents/Music/", song.getGenre());
        String command = String.format("youtube-dl ", songAddress);
        File fPath = new File(path);
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("/usr/bin/python","/var/lib/snapd/snap/bin/youtube-dl","/bin/bash",command);
        builder.directory(fPath);


        try {
            Process process = builder.start();
            OutputStream outputStream = process.getOutputStream();
            InputStream inputStream = process.getInputStream();
            InputStream errorStream = process.getErrorStream();

            printStream(inputStream);
            printStream(errorStream);

        }
        catch (IOException e)
        {
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
