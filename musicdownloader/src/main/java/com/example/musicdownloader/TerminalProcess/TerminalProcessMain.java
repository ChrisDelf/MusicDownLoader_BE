package com.example.musicdownloader.TerminalProcess;

import com.example.musicdownloader.model.Song;
import com.example.musicdownloader.requestBody.uploadRequest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TerminalProcessMain {



    public boolean main(uploadRequest request) throws Exception {

        // Where we want to execute
        File location = new File(String.format("/home/chris/Documents/Music/"));

        // going to create our commands
        List<String> cmdList = new ArrayList<String>();
        cmdList.add("youtube-dl" );
        cmdList.add(request.getAddress());

        //runCommand


        return runCommand(location,cmdList);
    }

    public static boolean runCommand(File whereToRun, List<String> cmdList) throws Exception {
        System.out.println("we are running in: "+ whereToRun);
        System.out.println("Our Command is: " + cmdList);

        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(whereToRun);
        builder.command(cmdList.get(0), cmdList.get(1));
        Process process = builder.start();

        OutputStream outputStream = process.getOutputStream();
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();

        printStream(inputStream);
        printStream(errorStream);

        boolean isFinished = process.waitFor(30, TimeUnit.SECONDS);
        outputStream.flush();
        outputStream.close();

        if(!isFinished) {
            process.destroyForcibly();
            return false;
        }
        return true;
    }

    private static void printStream(InputStream inputStream) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            String songName;
            boolean foundName = false;
            while((line = bufferedReader.readLine()) != null) {
                if (line.length() > 3) {

                        if (foundName == false ) {
                            String readOut = line.substring(line.indexOf("]") + 2, line.indexOf(":"));

                            if (readOut.equals("Destination")) {
                                songName = line.substring(line.indexOf(":") + 1, line.indexOf("."));
                                foundName = true;
                            }
                        }


                    System.out.println(line);
                }
            }

        }
    }
}
