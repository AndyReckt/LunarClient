package com.moonsworth.lunar.client.event.type.hud;

import com.moonsworth.lunar.bridge.minecraft.client.entity.item.EntityItemBridge;
import com.moonsworth.lunar.client.event.Event;

public class RenderEntityItemScaleEvent
extends Event {
    public final EntityItemBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public boolean IlllIIIIIIlllIlIIlllIlIIl = false;
    public boolean lIllIlIIIlIIIIIIIlllIlIll = false;
    public float llIlllIIIllllIIlllIllIIIl = 1.0f;

    public RenderEntityItemScaleEvent(EntityItemBridge entityItemBridge, boolean bl, boolean bl2) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityItemBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = bl;
        this.lIllIlIIIlIIIIIIIlllIlIll = bl2;
    }

    public EntityItemBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public float llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.IlllIIIIIIlllIlIIlllIlIIl = bl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        this.lIllIlIIIlIIIIIIIlllIlIll = bl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.llIlllIIIllllIIlllIllIIIl = f;
    }

    public RenderEntityItemScaleEvent(EntityItemBridge entityItemBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityItemBridge;
    }

    public RenderEntityItemScaleEvent(EntityItemBridge entityItemBridge, boolean bl, boolean bl2, float f) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityItemBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = bl;
        this.lIllIlIIIlIIIIIIIlllIlIll = bl2;
        this.llIlllIIIllllIIlllIllIIIl = f;
    }
}