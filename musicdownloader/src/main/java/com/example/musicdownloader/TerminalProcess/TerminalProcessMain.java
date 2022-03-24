package com.example.musicdownloader.TerminalProcess;

import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.requestBody.uploadRequest;
import com.example.musicdownloader.requestBody.TerminalOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TerminalProcessMain {



    public TerminalOutput main(uploadRequest request) throws Exception {

        // Where we want to execute
        File location = new File(String.format("/home/chris/Documents/Music/"));

        // going to create our commands
        List<String> cmdList = new ArrayList<String>();
        cmdList.add("youtube-dl" );
        cmdList.add(request.getAddress());

        //runCommand


        return runCommand(location,cmdList);
    }

    public static TerminalOutput runCommand(File whereToRun, List<String> cmdList) throws Exception {
        TerminalOutput songOutput = new TerminalOutput();
        System.out.println("we are running in: "+ whereToRun);
        System.out.println("Our Command is: " + cmdList);

        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(whereToRun);
        builder.command(cmdList.get(0), cmdList.get(1));
        Process process = builder.start();

        OutputStream outputStream = process.getOutputStream();
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();

        songOutput = printStream(inputStream);

        printStream(errorStream);

        boolean isFinished = process.waitFor(30, TimeUnit.SECONDS);
        outputStream.flush();
        outputStream.close();

        if(!isFinished) {
            process.destroyForcibly();
            return songOutput;
        }
        return songOutput;
    }

    private static TerminalOutput printStream(InputStream inputStream) throws IOException {

        ArrayList<Song> songsDownloaded = new ArrayList<Song>();
        TerminalOutput songOutput = new TerminalOutput();
        String playlistName;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            String songName;

            boolean foundName = false;
            boolean isReadable = false;

            while((line = bufferedReader.readLine()) != null) {
                if (line.length() > 3) {

                            //going to need to check if : exists in the line before we  indexOf
                            for (int i = 0; (line.length()) > i; i++) {

                                if (line.charAt(i) == ':') {
                                    isReadable = true;
                                    break;
                                }
                            }

                            if (isReadable == true) {

                                String readOut = line.substring(line.indexOf("]") + 2, line.lastIndexOf(":"));

                            // If the song is successfully downloaded we want to added to an array to save for later.

                                if (readOut.equals("Destination")) {

                                    Song tempSong = new Song();
                                    songName = line.substring(line.indexOf(":") + 1, line.indexOf(".mp3"));
                                    tempSong.setTitle(songName);
                                    songsDownloaded.add(tempSong);



                                }
                                if (readOut.equals("Downloading playlist"))
                                {
                                    int lineL = line.length();
                                    playlistName = line.substring(line.indexOf(":") + 1, lineL);
                                    songOutput.setPlaylistName(playlistName);
                                }

                                isReadable = false;

                        }

                  System.out.println(line);
                }
            }

        }

        songOutput.setSongs(songsDownloaded);
        return songOutput;
    }



}
