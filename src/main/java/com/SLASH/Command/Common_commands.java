package com.SLASH.Command;

import com.SLASH.Translation;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import static com.SLASH.DiscordMain.*;


public class Common_commands extends ListenerAdapter {

    public static int MEMBERS_COUNT;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Message msg = event.getMessage();
        String content = msg.getContentRaw().split(" ")[0];
        switch (content){
            case (Prefix + "shutdown") ->{
                Member ADMINISTRATOR = event.getMember();
                assert ADMINISTRATOR != null;
                if(!ADMINISTRATOR.hasPermission(Permission.ADMINISTRATOR)){
                    LOGGER.info(GetUserTagAndNickName(event.getMember()) + " tried to shutdown the bot");
                    msg.reply("You don't have permission to use this command!").queue();
                }
                else {
                    LOGGER.info(GetUserTagAndNickName(event.getMember()) + " shutdown the bot");
                    msg.reply("Shutting down...").queue(e -> System.exit(0));
                }
            }
            case (Prefix + "help") -> msg.reply("""
                    ```
                    Prefix: "!!"
                    Commands:\s
                    help - Shows this message
                    shutdown - Shuts down the bot
                    translate - Translates a message
                    Usage: !!translate <message> <language> <language>
                    ```""").queue();
            case (Prefix + "translate") -> {
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
            case ("TUPA") -> {
                if (!msg.getAuthor().isBot()) {
                    msg.delete().queue();
                } else {
                    MEMBERS_COUNT =  msg.getGuild().getMemberCount();
                }
                JSONObject jsonObject = new JSONObject();
                JSONObject Guild = new JSONObject();
                Guild.put("Name", msg.getGuild().getName());
                Guild.put("ID", msg.getGuild().getId());
                Guild.put("Members_amount", MEMBERS_COUNT);
                jsonObject.put("Guild", Guild);
                try {
                    Files.write(Paths.get("D:\\Java\\JAVADCAPI\\src\\main\\resources\\Guild.json"), jsonObject.toString().getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case (Prefix + "test") -> {
                if (Objects.requireNonNull(event.getMember()).hasPermission(Permission.ADMINISTRATOR)) {

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