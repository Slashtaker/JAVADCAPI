package com.SLASH;

import com.SLASH.Command.Set_command;
import com.SLASH.Event.JoinAndLeave;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;
import java.util.Objects;

import com.SLASH.Command.Common_commands;

public class DiscordMain extends ListenerAdapter {

    public final static Logger LOGGER = LoggerFactory.getLogger("TUPA");
    public static JDA jda;

    public static final String PREFIX = "!!";

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        Objects.requireNonNull(event.getJDA()
                        .getTextChannelById(966688365980307576L))
                .sendMessage("TUPA BOT HAVE STARTED")
                .queue();
        LOGGER.info("TUPA BOT HAVE STARTED");
    }

    public static void main(String[] args) throws LoginException{
        jda = JDABuilder
                .createDefault("OTE1NjA4MTY2Njc3NDkxNzQy.YaeEjg.oItKqMdqIV5NsOPYxpP59ytQ20U")
                .setActivity(Activity.streaming("Youtube", "https://www.youtube.com/watch?v=dQw4w9WgXcQ"))
                .setStatus(OnlineStatus.ONLINE)
                .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES,GatewayIntent.GUILD_MEMBERS)
                .setChunkingFilter(ChunkingFilter.ALL)
                .setMemberCachePolicy(MemberCachePolicy.ALL)
                .build();
        jda.addEventListener(new MusicPlayer(),new DiscordMain(),new Common_commands(),new Set_command(), new JoinAndLeave());
    }
}
