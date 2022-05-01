package com.SLASH.Event;

import com.SLASH.Buffer.Reader;
import com.SLASH.Buffer.Writer;
import com.SLASH.Guild;
import com.google.gson.Gson;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import static com.SLASH.DiscordMain.LOGGER;

public class JoinAndLeave extends ListenerAdapter {
    Reader reader = new Reader();
    Gson gson = new Gson();
    Writer writer = new Writer();
    Random random = new Random();
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        try {
            Guild guild =  gson.fromJson(reader.reader(), Guild.class);
            writer.Increase_Member_Amount();
            String[] Welcome_mess = guild.getWelcome_Message();
            int index = random.nextInt(Welcome_mess.length);
            String Message = Welcome_mess[index];
            Message = String.format(Message, "@"+event.getUser().getAsTag());
            Objects.requireNonNull(event.getGuild().getTextChannelById(guild.getWelcome_Channel_ID())).sendMessage(Message).queue();
            LOGGER.info("User: " + event.getUser().getAsTag() + " Joined the Guild: " + event.getGuild().getName());
        } catch (IOException e) {
            LOGGER.error("Error: " + e);
        }
    }

    @Override
    public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
        try {
            Guild guild =  gson.fromJson(reader.reader(), Guild.class);
            writer.Decrease_Member_Amount();
            String[] Leave_mess = guild.getLeave_Message();
            int index = random.nextInt(Leave_mess.length);
            String Message = Leave_mess[index];
            Message = String.format(Message, "@"+event.getUser().getAsTag());
            Objects.requireNonNull(event.getGuild().getTextChannelById(guild.getLeave_Channel_ID())).sendMessage(Message).queue();
            LOGGER.info("User: " + event.getUser().getAsTag() + " Left the Guild: " + event.getGuild().getName());
        } catch (IOException e) {
            LOGGER.error("Error: " + e);
        }
    }
}
