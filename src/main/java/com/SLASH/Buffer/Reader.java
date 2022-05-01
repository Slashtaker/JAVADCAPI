package com.SLASH.Buffer;

import java.io.*;
import java.nio.file.Files;

import static com.SLASH.DiscordMain.LOGGER;

public class Reader {
    private BufferedReader reader;

    public String reader() throws IOException {
        try {
            reader = new BufferedReader(new FileReader(".\\src\\main\\resources\\Guild.json"));
        } catch (FileNotFoundException e) {
            Files.createFile(new File(".\\src\\main\\resources\\Guild.json").toPath());
        }
        StringBuilder jsontext = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsontext.append(line).append("\n");
        }
        reader.close();
        LOGGER.info("Guild.json loaded");
        return jsontext.toString();
    }
}
