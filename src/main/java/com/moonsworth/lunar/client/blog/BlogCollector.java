package com.moonsworth.lunar.client.blog;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.blog.BlogCache;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class BlogCollector implements Runnable {

    @Override
    public void run() {
        try {
            URL url = new URL("https://api.lunarclientprod.com/game/metadata");
            byte[] byArray = "{}".getBytes(StandardCharsets.UTF_8);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(byArray.length));
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.getOutputStream().write(byArray);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
            JsonObject jsonObject = new JsonParser().parse(bufferedReader.readLine()).getAsJsonObject();
            jsonObject.getAsJsonArray("blogPosts").forEach(jsonElement -> {
                JsonObject postObject = jsonElement.getAsJsonObject();
                BlogCache blogCache = new BlogCache(postObject.get("title").getAsString(), postObject.get("image").getAsString(), postObject.get("link").getAsString());
                LunarClient.IIllIlIllIlIllIllIllIllII().IIlllIllIlIllIllIIllIlIIl().llIlllIIIllllIIlllIllIIIl().add(blogCache);
            });
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
}