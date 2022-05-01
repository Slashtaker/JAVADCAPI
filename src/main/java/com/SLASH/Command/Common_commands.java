package com.SLASH.Command;

import com.SLASH.Guild;
import com.SLASH.Translation;
import com.google.gson.Gson;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import static com.SLASH.DiscordMain.*;


public class Common_commands extends ListenerAdapter {

    public static int MEMBERS_COUNT;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Message msg = event.getMessage();
        String content = msg.getContentRaw().split(" ")[0];
        switch (content){
            case (PREFIX + "shutdown") ->{
                Member ADMINISTRATOR = event.getMember();
                assert ADMINISTRATOR != null;
                if(!ADMINISTRATOR.hasPermission(Permission.ADMINISTRATOR)){
                    LOGGER.info(GetUserTagAndNickName(event.getMember()) + " tried to shutdown the bot");
                    msg.reply("You don't have permission to use this command!").queue();
                }
                else {
                    LOGGER.info(GetUserTagAndNickName(event.getMember()) + " shutdown the bot");
                    msg.reply("Shutting down...").queue(e -> jda.shutdownNow());
                }
            }
            case (PREFIX + "help") -> msg.reply("""
                    ```
                    Prefix: "!!"
                    Commands:\s
                    help - Shows this message
                    shutdown - Shuts down the bot
                    translate - Translates a message
                    Usage: !!translate <message> <language> <language>
                    ```""").queue();
            case (PREFIX + "translate") -> {
                Translation translation = new Translation();
                String Data= msg.getContentRaw();
                String[] DataArray = Data.split(" ");
                String[] NextData = new String[DataArray.length-1];
                for (int i = 0, k = 0; i < DataArray.length; i++) {
                    if (i == 0) {
                        continue;
                    }
                    NextData[k++] = DataArray[i];
                }
                try {
                    String[] result = translation.translate(NextData);
                    StringBuilder results = new StringBuilder();
                    for (String s : result) {
                        results.append(s).append("\n");
                    }
                    msg.reply(results).queue();
                } catch (ArrayIndexOutOfBoundsException e) {
                    msg.reply("Please enter the correct amount argument").queue();
                }
                LOGGER.info(GetUserTagAndNickName(Objects.requireNonNull(event.getMember()))
                        + " used the translate command" + " with the message: " + msg.getContentRaw());
            }
            case (PREFIX + "init") -> {
                if (Objects.requireNonNull(msg.getMember()).hasPermission(Permission.ADMINISTRATOR)) {
                    msg.reply("Initializing...").queue();
                    MEMBERS_COUNT = msg.getGuild().getMemberCount();
                    Gson gson = new Gson();
                    String[] Welcome_Message = new String[]{
                            "%s just joined the server - glhf!",
                            "%s just joined. Everyone, look busy!",
                            "%s just joined. Can I get a heal?",
                            "%s joined your party.",
                            "%s joined. You must construct additional pylons.",
                            "Ermagherd. %s is here.",
                            "Welcome, %s. Stay awhile and listen.",
                            "Welcome, %s. We were expecting you ( ͡° ͜ʖ ͡°)",
                            "Welcome, %s. We hope you brought pizza.",
                            "Welcome %s. Leave your weapons by the door.",
                            "A wild %s appeared.",
                            "Swoooosh. %s just landed.",
                            "Brace yourselves. %s just joined the server.",
                            "%s just joined. Hide your bananas.",
                            "%s just arrived. Seems OP - please nerf.",
                            "%s just slid into the server.",
                            "A %s has spawned in the server.",
                            "Big %s showed up!",
                            "Where’s %s? In the server!",
                            "%s hopped into the server. Kangaroo!!",
                            "%s just showed up. Hold my beer.",
                    };
                    String[] Leave_Message = new String[]{"%s leave the server"};
                    Guild guild = new Guild(msg.getGuild().getIdLong(), msg.getGuild().getName(), msg.getGuild()
                            .getMemberCount(),0L,0L,Welcome_Message,Leave_Message);
                    String json = gson.toJson(guild);
                    BufferedWriter writer;
                    try {
                        writer = new BufferedWriter(new FileWriter(".\\src\\main\\resources\\Guild.json"));
                        writer.write(json);
                        writer.flush();
                    } catch (IOException e) {
                        LOGGER.error("Error: " + e.getMessage());
                    }
                    msg.reply("Done!").queue();
                    LOGGER.info(GetUserTagAndNickName(Objects.requireNonNull(event.getMember())) + "used the init command");
                } else {
                    msg.reply("You don't have permission to use this command!").queue();
                }
            }
            case (PREFIX + "test") -> {
                if (Objects.requireNonNull(event.getMember()).hasPermission(Permission.ADMINISTRATOR)) {
                    msg.reply("Test").getChannel().sendMessage("hi").queue();
                } else {
                    msg.reply("You don't have permission to use this command!").queue();
                }
            }
        }
    }
    String GetUserTagAndNickName(@NotNull Member member){
        return member.getUser().getAsTag();
    }
}