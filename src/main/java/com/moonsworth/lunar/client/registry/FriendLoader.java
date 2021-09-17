package com.moonsworth.lunar.client.registry;

import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.json.file.ItemMapLoader;
import com.moonsworth.lunar.client.websocket.FriendProfile;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FriendLoader
extends ItemMapLoader
implements EventHandler {
    public FriendLoader() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent netHandlerConnectionStateUpdateEvent) {
        this.llIlllIIIllllIIlllIllIIIl().clear();
    }

    @Override
    public Map lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new ConcurrentHashMap();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(FriendProfile profile) {
        if (this.llIlllIIIllllIIlllIllIIIl().containsKey(profile.lIllIlIIIlIIIIIIIlllIlIll())) {
            return;
        }
        this.llIlllIIIllllIIlllIllIIIl().put(profile.lIllIlIIIlIIIIIIIlllIlIll(), profile);
        profile.IlllIIIIIIlllIlIIlllIlIIl(System.currentTimeMillis());
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(FriendProfile profile) {
        this.llIlllIIIllllIIlllIllIIIl().remove(profile.lIllIlIIIlIIIIIIIlllIlIll());
    }
}
 