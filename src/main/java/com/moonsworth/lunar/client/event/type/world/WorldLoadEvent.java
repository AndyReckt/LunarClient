package com.moonsworth.lunar.client.event.type.world;

import com.moonsworth.lunar.bridge.minecraft.world.WorldBridge;
import com.moonsworth.lunar.client.event.Event;

public class WorldLoadEvent extends Event {
    public final WorldBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public WorldLoadEvent(WorldBridge worldBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = worldBridge;
    }

    public WorldBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
