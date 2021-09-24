package com.moonsworth.lunar.client.account;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.setting.Json;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MinecraftProfileJson implements Json {

    public String id;
    public String name;

    @Override
    public void read(JsonObject jsonObject) {
        this.id = jsonObject.get("id").getAsString();
        this.name = jsonObject.get("name").getAsString();
    }

    @Override
    public void write(JsonObject jsonObject) {
        JsonObject object = new JsonObject();
        jsonObject.add("minecraftProfile", object);
        object.addProperty("id", this.id);
        object.addProperty("name", this.name);
    }

}
