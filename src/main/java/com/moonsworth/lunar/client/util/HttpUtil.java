package com.moonsworth.lunar.client.util;

import com.google.common.base.Charsets;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.function.Consumer;

public final class HttpUtil {
    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String string, Map<String, String> map, Map map2, boolean bl, Consumer<JsonObject> consumer) {
        try {
            if (!bl) {
                HttpUtil.lIlIlIlIlIIlIIlIIllIIIIIl(string, map, HttpUtil.IlllIIIIIIlllIlIIlllIlIIl(map2), consumer);
            } else {
                HttpUtil.lIlIlIlIlIIlIIlIIllIIIIIl(string, map, HttpUtil.lIlIlIlIlIIlIIlIIllIIIIIl(map2), consumer);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String string, Map<String, String> map, Consumer<JsonObject> consumer) {
        new Thread(() -> {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(string).openConnection();
                httpURLConnection.setRequestMethod("GET");
                map.forEach(httpURLConnection::setRequestProperty);
                httpURLConnection.setReadTimeout(8000);
                httpURLConnection.setConnectTimeout(8000);
                httpURLConnection.setDoOutput(true);
                String string2 = IOUtils.toString(httpURLConnection.getInputStream(), Charsets.UTF_8);
                JsonObject jsonObject = null;
                try {
                    JsonParser jsonParser = new JsonParser();
                    jsonObject = jsonParser.parse(string2).getAsJsonObject();
                } catch (JsonParseException jsonParseException) {
                    jsonParseException.printStackTrace();
                }
                if (jsonObject != null) {
                    consumer.accept(jsonObject);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
                consumer.accept(null);
            }
        }).start();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String string, Map<String, String> map, String string2, Consumer<JsonObject> consumer) {
        new Thread(() -> {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(string).openConnection();
                httpURLConnection.setRequestMethod("POST");
                map.forEach(httpURLConnection::setRequestProperty);
                httpURLConnection.setRequestProperty("Content-Length", "" + string2.getBytes().length);
                httpURLConnection.setReadTimeout(8000);
                httpURLConnection.setConnectTimeout(8000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                byte[] byArray = string2.getBytes(StandardCharsets.UTF_8);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(byArray);
                outputStream.close();
                String string3 = IOUtils.toString(httpURLConnection.getInputStream(), Charsets.UTF_8);
                JsonObject jsonObject = null;
                try {
                    JsonParser jsonParser = new JsonParser();
                    jsonObject = jsonParser.parse(string3).getAsJsonObject();
                } catch (JsonParseException jsonParseException) {
                    jsonParseException.printStackTrace();
                }
                if (jsonObject != null) {
                    consumer.accept(jsonObject);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }).start();
    }

    public static String lIlIlIlIlIIlIIlIIllIIIIIl(Map map) {
        return new JSONObject(map).toString();
    }

    // todo check @SneakyThrows usage here.
    @SneakyThrows
    public static String IlllIIIIIIlllIlIIlllIlIIl(Map<Object, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(URLEncoder.encode(entry.getKey().toString(), "UTF-8"));
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
        }
        return stringBuilder.toString();
    }

    public HttpUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
