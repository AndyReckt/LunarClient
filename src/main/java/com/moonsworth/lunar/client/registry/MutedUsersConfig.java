package com.moonsworth.lunar.client.registry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.lunarclient.bukkitapi.nethandler.client.LCPacketVoiceMute;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.network.NetHandlerConnectionStateUpdateEvent;
import com.moonsworth.lunar.client.json.file.JsonFile;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.logger.LunarLogger;
import io.netty.util.internal.ConcurrentSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class MutedUsersConfig extends ItemSetLoader<UUID> implements EventHandler, JsonFile {
    public List<UUID> lIlIlIlIlIIlIIlIIllIIIIIl = new ArrayList<>();

    public MutedUsersConfig() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    @Override
    public Set<UUID> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new ConcurrentSet<>();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent netHandlerConnectionStateUpdateEvent) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.clear();
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(UUID uUID) {
        if (!this.lIlIlIlIlIIlIIlIIllIIIIIl.contains(uUID)) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.add(uUID);
            LunarClient.getInstance().llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(new LCPacketVoiceMute(uUID, -1));
            return true;
        }
        return false;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(UUID uUID) {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl.contains(uUID)) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.removeIf(uUID::equals);
            LunarClient.getInstance().llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(new LCPacketVoiceMute(uUID, -1));
            return true;
        }
        return false;
    }

    @Override
    public void b_() {
        super.b_();
        this.load();
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.save();
    }

    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "muted_users.json";
    }

    @Override
    public void read(JsonObject jsonObject) {
        JsonArray jsonArray = jsonObject.getAsJsonArray("mutes");
        for (JsonElement jsonElement : jsonArray) {
            try {
                LunarLogger.debug((Object)"Added Mute [%s]", jsonElement.getAsString());
                this.llIlllIIIllllIIlllIllIIIl().add(UUID.fromString(jsonElement.getAsString()));
            } catch (Exception exception) {}
        }
    }

    @Override
    public void write(JsonObject jsonObject) {
        JsonArray jsonArray = new JsonArray();
        jsonObject.add("mutes", jsonArray);
        for (UUID uUID : this.llIlllIIIllllIIlllIllIIIl()) {
            jsonArray.add(new JsonPrimitive(uUID.toString()));
        }
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(UUID uUID) {
        if (this.llIlllIIIllllIIlllIllIIIl().contains(uUID)) {
            this.llIlllIIIllllIIlllIllIIIl().removeIf(uUID::equals);
            this.IlllIIIIIIlllIlIIlllIlIIl(uUID);
        } else {
            this.llIlllIIIllllIIlllIllIIIl().add(uUID);
            this.lIlIlIlIlIIlIIlIIllIIIIIl(uUID);
        }
    }
}