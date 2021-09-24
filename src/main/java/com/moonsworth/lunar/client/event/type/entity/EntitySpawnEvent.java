package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.world.WorldBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class EntitySpawnEvent
    extends CancellableEvent {
    public EntityBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public WorldBridge IlllIIIIIIlllIlIIlllIlIIl;

    public EntitySpawnEvent(EntityBridge entityBridge, WorldBridge worldBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = worldBridge;
    }
}
