package com.moonsworth.lunar.client.account;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import com.moonsworth.lunar.client.setting.Json;

public class MojangAccountJson implements Json {
    public String avatar = null;
    public boolean eligibleForMigration = false;
    public boolean hasMultipleProfiles = false;
    public boolean legacy = false;
    public boolean persistent = true;
    public JsonArray userProperites = new JsonArray();

    @Override
    public void read(JsonObject jsonObject) {
        if (jsonObject.has("avatar") && !jsonObject.get("avatar").isJsonNull()) {
            this.avatar = jsonObject.get("avatar").getAsString();
        }
        this.eligibleForMigration = jsonObject.get("eligibleForMigration").getAsBoolean();
        this.hasMultipleProfiles = jsonObject.get("hasMultipleProfiles").getAsBoolean();
        this.legacy = jsonObject.get("legacy").getAsBoolean();
        this.persistent = jsonObject.get("persistent").getAsBoolean();
        this.userProperites = jsonObject.getAsJsonArray("userProperites");
    }

    @Override
    public void write(JsonObject jsonObject) {
        if (this.avatar != null) {
            jsonObject.addProperty("avatar", this.avatar);
        }
        jsonObject.addProperty("eligibleForMigration", this.eligibleForMigration);
        jsonObject.addProperty("hasMultipleProfiles", this.hasMultipleProfiles);
        jsonObject.addProperty("legacy", this.legacy);
        jsonObject.addProperty("persistent", this.persistent);
        jsonObject.add("userProperites", this.userProperites);
    }
}
