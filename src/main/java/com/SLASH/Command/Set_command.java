package com.SLASH.Command;

import com.SLASH.Buffer.Writer;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static com.SLASH.DiscordMain.*;

public class Set_command extends ListenerAdapter {
    Writer writer = new Writer();
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Message msg = event.getMessage();
        switch (event.getMessage().getContentRaw()) {
            case (PREFIX + "setWelcome") -> {
                writer.Write_Welcome_Channel(event.getGuild().getIdLong());
                LOGGER.info(msg.getAuthor().getAsTag() + " set the welcome channel to " + event.getGuild().getIdLong());
            }
            case (PREFIX + "setLeave") -> {
                writer.Write_Leave_Channel(event.getGuild().getIdLong());
                LOGGER.info(msg.getAuthor().getAsTag() + " set the leave channel to " + event.getGuild().getIdLong());
            }
        }
    }
}
