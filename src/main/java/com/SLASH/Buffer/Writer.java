package com.SLASH.Buffer;

import com.SLASH.Guild;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static com.SLASH.DiscordMain.LOGGER;

public class Writer {
    BufferedWriter bw;
    Gson gson = new Gson();
    Reader reader = new Reader();

    public void Write_Welcome_Channel(long ChannelID){
        try {
            String json = reader.reader();
            bw = new BufferedWriter(new FileWriter(".\\src\\main\\resources\\Guild.json"));
            Guild guild = gson.fromJson(json, Guild.class);
            guild.setWelcome_Channel_ID(ChannelID);
            bw.write(gson.toJson(guild));
            bw.flush();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
    public void Write_Leave_Channel(long ChannelID){
        try {
            String json = reader.reader();
            bw = new BufferedWriter(new FileWriter(".\\src\\main\\resources\\Guild.json"));
            Guild guild = gson.fromJson(json, Guild.class);
            guild.setLeave_Channel_ID(ChannelID);
            bw.write(gson.toJson(guild));
            bw.flush();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
