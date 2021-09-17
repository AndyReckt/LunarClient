package com.moonsworth.lunar.client.account;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.setting.Json;

public class MojangAccount
implements Json {
    public String lIlIlIlIlIIlIIlIIllIIIIIl = null;
    public boolean IlllIIIIIIlllIlIIlllIlIIl = false;
    public boolean lIllIlIIIlIIIIIIIlllIlIll = false;
    public boolean llIlllIIIllllIIlllIllIIIl = false;
    public boolean llllIIlIIlIIlIIllIIlIIllI = true;
    public JsonArray IlIlIlllllIlIIlIlIlllIlIl = new JsonArray();

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        if (jsonObject.has("avatar") && !jsonObject.get("avatar").isJsonNull()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = jsonObject.get("avatar").getAsString();
        }
        this.IlllIIIIIIlllIlIIlllIlIIl = jsonObject.get("eligibleForMigration").getAsBoolean();
        this.lIllIlIIIlIIIIIIIlllIlIll = jsonObject.get("hasMultipleProfiles").getAsBoolean();
        this.llIlllIIIllllIIlllIllIIIl = jsonObject.get("legacy").getAsBoolean();
        this.llllIIlIIlIIlIIllIIlIIllI = jsonObject.get("persistent").getAsBoolean();
        this.IlIlIlllllIlIIlIlIlllIlIl = jsonObject.getAsJsonArray("userProperites");
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl != null) {
            jsonObject.addProperty("avatar", this.lIlIlIlIlIIlIIlIIllIIIIIl);
        }
        jsonObject.addProperty("eligibleForMigration", this.IlllIIIIIIlllIlIIlllIlIIl);
        jsonObject.addProperty("hasMultipleProfiles", this.lIllIlIIIlIIIIIIIlllIlIll);
        jsonObject.addProperty("legacy", this.llIlllIIIllllIIlllIllIIIl);
        jsonObject.addProperty("persistent", this.llllIIlIIlIIlIIllIIlIIllI);
        jsonObject.add("userProperites", this.IlIlIlllllIlIIlIlIlllIlIl);
    }
}
 