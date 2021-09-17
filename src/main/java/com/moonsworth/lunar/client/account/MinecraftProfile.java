package com.moonsworth.lunar.client.account;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.setting.Json;

public class MinecraftProfile
implements Json {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public String IlllIIIIIIlllIlIIlllIlIIl;

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = jsonObject.get("id").getAsString();
        this.IlllIIIIIIlllIlIIlllIlIIl = jsonObject.get("name").getAsString();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.add("minecraftProfile", jsonObject2);
        jsonObject2.addProperty("id", this.lIlIlIlIlIIlIIlIIllIIIIIl);
        jsonObject2.addProperty("name", this.IlllIIIIIIlllIlIIlllIlIIl);
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(String string) {
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof MinecraftProfile)) {
            return false;
        }
        MinecraftProfile minecraftProfile = (MinecraftProfile)object;
        if (!minecraftProfile.lIlIlIlIlIIlIIlIIllIIIIIl(this)) {
            return false;
        }
        String string = this.lIlIlIlIlIIlIIlIIllIIIIIl();
        String string2 = minecraftProfile.lIlIlIlIlIIlIIlIIllIIIIIl();
        if (string == null ? string2 != null : !string.equals(string2)) {
            return false;
        }
        String string3 = this.IlllIIIIIIlllIlIIlllIlIIl();
        String string4 = minecraftProfile.IlllIIIIIIlllIlIIlllIlIIl();
        return !(string3 == null ? string4 != null : !string3.equals(string4));
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object object) {
        return object instanceof MinecraftProfile;
    }

    public int hashCode() {
        int n = 59;
        int n2 = 1;
        String string = this.lIlIlIlIlIIlIIlIIllIIIIIl();
        n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
        String string2 = this.IlllIIIIIIlllIlIIlllIlIIl();
        n2 = n2 * 59 + (string2 == null ? 43 : string2.hashCode());
        return n2;
    }

    public String toString() {
        return "MinecraftProfile(id=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", name=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ")";
    }

    public MinecraftProfile(String string, String string2) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.IlllIIIIIIlllIlIIlllIlIIl = string2;
    }

    public MinecraftProfile() {
    }
}
 