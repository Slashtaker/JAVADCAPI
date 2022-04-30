package com.SLASH;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;
import org.jetbrains.annotations.NotNull;

import static com.SLASH.DiscordMain.Prefix;

public class MusicPlayer extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentRaw();
        if (msg.startsWith(Prefix + "play")) {
            String[] args = msg.split(" ");
            VoiceChannel myChannel = (VoiceChannel) event.getMember().getVoiceState().getChannel();
            AudioManager audioManager = event.getGuild().getAudioManager();
            audioManager.openAudioConnection(myChannel);
            
        }
    }
}

