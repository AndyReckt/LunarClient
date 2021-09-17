package com.moonsworth.lunar.client.registry;

import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.feature.type.voice.VoiceModHandler;
import com.moonsworth.lunar.client.json.file.ItemMapLoader;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ProfileMapLoader
extends ItemMapLoader<UUID, Object>
implements EventHandler {
    public VoiceModHandler lIlIlIlIlIIlIIlIIllIIIIIl;

    public ProfileMapLoader() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent netHandlerConnectionStateUpdateEvent) {
        this.llIlllIIIllllIIlllIllIIIl().clear();
        this.lIlIlIlIlIIlIIlIIllIIIIIl = null;
    }

    @Override
    public Map lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new ConcurrentHashMap();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(UUID uUID) {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl != null && this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl().equals(uUID)) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = null;
        }
        this.llIlllIIIllllIIlllIllIIIl().remove(uUID);
    }

    public VoiceModHandler llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(VoiceModHandler profileManager) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = profileManager;
    }
}
 