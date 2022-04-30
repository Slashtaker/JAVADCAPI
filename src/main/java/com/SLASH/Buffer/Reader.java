package com.SLASH.Buffer;

import java.io.*;
import java.nio.file.Files;

public class Reader {
    private StringBuilder builder;
    private BufferedReader reader;

    public String reader() throws IOException {
        try {
            reader = new BufferedReader(new FileReader("\\main\\resources\\Guild.json"));
        } catch (FileNotFoundException e) {
            Files.createFile(new File("\\main\\resources\\Guild.json").toPath());
        }
        while (reader.readLine() != null) {
            builder = builder.append(reader.readLine());
        }

        return builder.toString();
    }
}
