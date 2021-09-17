package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.client.event.Event;

public class EntityStatusEvent
extends Event {
    public EntityBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public byte IlllIIIIIIlllIlIIlllIlIIl;

    public EntityStatusEvent(EntityBridge entityBridge, byte by) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = by;
    }

    public EntityBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public byte IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}