package com.moonsworth.lunar.client.setting;

import com.google.gson.JsonObject;

import java.io.IOException;

/**
 * @author Decencies
 * @since 10/07/2021 12:23
 */
public interface Json {
    void read(JsonObject var1) throws IOException;

    void write(JsonObject var1) throws IOException;
}
