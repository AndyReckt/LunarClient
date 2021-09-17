package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class EntityCriticalStrikeEvent
extends CancellableEvent {
    public EntityBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public EntityCriticalStrikeEvent(EntityBridge entityBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityBridge;
    }

    public EntityBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}