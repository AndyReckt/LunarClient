package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.client.event.CancellableEvent;

public class EntityRendererSetAnglesEvent
    extends CancellableEvent {
    public float lIlIlIlIlIIlIIlIIllIIIIIl;
    public float IlllIIIIIIlllIlIIlllIlIIl;

    public EntityRendererSetAnglesEvent(float f, float f2) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
        this.IlllIIIIIIlllIlIIlllIlIIl = f2;
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public float IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}