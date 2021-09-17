package com.moonsworth.lunar.client.json.file;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.moonsworth.lunar.client.setting.Json;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.LunarClient;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author Decencies
 * @since 10/07/2021 12:23
 */
// todo rename to "JsonFile"
public interface DefaultJson extends Json {

    String llllIIlIIlIIlIIllIIlIIllI();

    default File IlIlIlllllIlIIlIlIlllIlIl() {
        return new File(LunarClient.IIllIlIllIlIllIllIllIllII().IlIlIlllllIlIIlIlIlllIlIl(), this.llllIIlIIlIIlIIllIIlIIllI());
    }

    default boolean load() {
        try {
            File file = this.IlIlIlllllIlIIlIlIlllIlIl();
            if (!file.exists()) {
                return false;
            }
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(new FileReader(file));
            if (element.isJsonObject()) {
                this.IlllIIIIIIlllIlIIlllIlIIl(element.getAsJsonObject());
                LunarLogger.lIlIlIlIlIIlIIlIIllIIIIIl("Loaded File: [%s]", this.llllIIlIIlIIlIIllIIlIIllI());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            LunarLogger.llIlllIIIllllIIlllIllIIIl("Couldn't load file " + this.llllIIlIIlIIlIIllIIlIIllI() + " [" + exception.getMessage() + "]");
            return false;
        }
        return true;
    }

    @SneakyThrows
    default void save() {
        JsonObject jsonObject = new JsonObject();
        this.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject);
        File file = this.IlIlIlllllIlIIlIlIlllIlIl();
        try {
            if (!file.exists() && !file.createNewFile()) {
                return;
            }
            try (FileWriter writer = new FileWriter(file)) {
                LunarClient.llIIlIlIIIllIlIlIlIIlIIll.toJson(jsonObject, writer);
                LunarLogger.lIlIlIlIlIIlIIlIIllIIIIIl("Saved File: [%s]", this.llllIIlIIlIIlIIllIIlIIllI());
            }
        } catch (Exception exception) {
            LunarLogger.llIlllIIIllllIIlllIllIIIl("Couldn't save to " + this.llllIIlIIlIIlIIllIIlIIllI() + " [%s]", exception.getMessage());
        }
    }

}
