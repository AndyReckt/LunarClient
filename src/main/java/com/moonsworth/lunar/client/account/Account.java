package com.moonsworth.lunar.client.account;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.AccountsConfig;
import com.moonsworth.lunar.client.registry.PlayerHeadManager;
import com.moonsworth.lunar.client.setting.Json;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public abstract class Account implements Json {
    public static final ResourceLocationBridge STEVE_HEAD = Bridge.getInstance().initResourceLocation("lunar", "steve.png");
    public String accessToken;
    public Instant accessTokenExpiresAt;
    public String localId;
    public MinecraftProfileJson profile;
    public String remoteId;
    public AccountType type;
    public String username;
    public MojangAccountJson accountComplianceData;
    public transient String refreshToken;
    public transient ResourceLocationBridge head;

    public Account(String localId) {
        this.localId = localId;
    }

    @Override
    public void read(JsonObject jsonObject) {
        this.accessTokenExpiresAt = jsonObject.has("accessTokenExpiresAt") && !jsonObject.get("accessTokenExpiresAt").isJsonNull() ? Instant.parse(jsonObject.get("accessTokenExpiresAt").getAsString()) : null;
        this.localId = jsonObject.get("localId").getAsString();
        this.profile = new MinecraftProfileJson();
        this.profile.read(jsonObject.get("minecraftProfile").getAsJsonObject());
        this.remoteId = jsonObject.get("remoteId").getAsString();
        this.type = AccountType.valueOf(jsonObject.get("type").getAsString().toUpperCase());
        if (jsonObject.has("username")) {
            this.username = jsonObject.get("username").getAsString();
        }
        if (jsonObject.has("accessToken")) {
            this.accessToken = jsonObject.get("accessToken").getAsString();
        } else {
            AccountsConfig.lIlIlIlIlIIlIIlIIllIIIIIl("No access token found for [%s]", this.username);
        }
        this.accountComplianceData = new MojangAccountJson();
        this.accountComplianceData.read(jsonObject);
    }

    @Override
    public void write(JsonObject jsonObject) {
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.add(this.localId, jsonObject2);
        jsonObject2.addProperty("accessToken", this.accessToken);
        if (this.accessTokenExpiresAt != null) {
            jsonObject2.addProperty("accessTokenExpiresAt", this.accessTokenExpiresAt.toString());
        }
        if (this.accountComplianceData == null) {
            this.accountComplianceData = new MojangAccountJson();
        }
        this.accountComplianceData.write(jsonObject2);
        jsonObject2.addProperty("localId", this.localId);
        this.profile.write(jsonObject2);
        jsonObject2.addProperty("remoteId", this.remoteId);
        jsonObject2.addProperty("type", this.type.lIlIlIlIlIIlIIlIIllIIIIIl());
        jsonObject2.addProperty("username", this.username);
    }

    public abstract boolean lIlIlIlIlIIlIIlIIllIIIIIl();

    public abstract boolean IlllIIIIIIlllIlIIlllIlIIl();

    public abstract int lIllIlIIIlIIIIIIIlllIlIll();

    public ResourceLocationBridge getHead() {
        if (this.head == null) {
            if (this.profile == null) {
                return STEVE_HEAD;
            }
            this.head = PlayerHeadManager.lIlIlIlIlIIlIIlIIllIIIIIl(this.profile.getId());
        }
        return this.head;
    }

    public void setHead(ResourceLocationBridge head) {
        this.head = head;
    }

}
