package com.moonsworth.lunar.client.crash;

import com.google.gson.*;
import com.moonsworth.lunar.bridge.minecraft.crash.CrashReportBridge;

import java.lang.reflect.Type;

/**
 * @author Decencies
 * @since 10/07/2021 12:35
 */
public class CrashReportSerializer implements JsonSerializer<CrashReportBridge> {

    @Override public JsonElement serialize(CrashReportBridge src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("title", src.bridge$getTitle());
        Throwable throwable = src.bridge$getCause();
        jsonObject.addProperty("message", throwable.getClass().getName() + ": " + throwable.getMessage());
        JsonArray jsonArray = new JsonArray();
        for (StackTraceElement stackTraceElement : throwable.getStackTrace()) {
            jsonArray.add(new JsonPrimitive(stackTraceElement.toString()));
        }
        jsonObject.add("stacktrace", jsonArray);
        return jsonObject;
    }

}
