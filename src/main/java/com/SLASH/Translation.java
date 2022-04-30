package com.SLASH;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import static com.SLASH.DiscordMain.LOGGER;


public class Translation{
    private final String DEFAULT_URL = "https://api.mymemory.translated.net/get?q=%s&langpair=%s%7C%s";
    public String[] translate(String[] arguments) {

        String lang = arguments[arguments.length -2], lang2 = arguments[arguments.length-1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arguments.length - 2; i++) {
            sb.append(arguments[i]).append("%20");
        }
        String url = DEFAULT_URL.replaceFirst("%s", String.valueOf(sb)).replaceFirst("%s",lang).replaceFirst("%s",lang2);
        LOGGER.info("URL: "+url);
        String temp = "";

        try {
            Connection connect = Jsoup.connect(url);
            Document doc = connect.ignoreContentType(true).get();
            temp = doc.getAllElements().text();
        } catch (IOException e) {
            LOGGER.error("Error translating text ", e);

        }
        JSONObject json = new JSONObject(temp);
        JSONArray array = json.getJSONArray("matches");
        String[] result = new String[array.length()];

        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            result[i] = object.getString("translation");
        }
        return result;
    }
}
