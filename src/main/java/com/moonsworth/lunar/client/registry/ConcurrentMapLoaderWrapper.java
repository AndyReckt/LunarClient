package com.moonsworth.lunar.client.registry;

import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.type.network.NetHandlerConnectionStateUpdateEvent;
import com.moonsworth.lunar.client.json.file.ItemMapLoader;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapLoaderWrapper
extends ItemMapLoader<UUID, List<String>>
implements EventHandler {
    public ConcurrentMapLoaderWrapper() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent netHandlerConnectionStateUpdateEvent) {
        this.llIlllIIIllllIIlllIllIIIl().clear();
    }

    @Override
    public Map lIlIlIlIlIIlIIlIIllIIIIIl() {
        return new ConcurrentHashMap();
    }
}
 