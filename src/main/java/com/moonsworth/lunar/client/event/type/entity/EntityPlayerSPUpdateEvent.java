package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class EntityPlayerSPUpdateEvent
    extends CancellableEvent {
    public final Runnable lIlIlIlIlIIlIIlIIllIIIIIl;
    public final EntityPlayerSPBridge IlllIIIIIIlllIlIIlllIlIIl;
    public int lIllIlIIIlIIIIIIIlllIlIll;
    public boolean llIlllIIIllllIIlllIllIIIl;
    public int llllIIlIIlIIlIIllIIlIIllI;
    public int IlIlIlllllIlIIlIlIlllIlIl;
    public float llIIIIIIIllIIllIlIllIIIIl;

    public Runnable lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public EntityPlayerSPBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public int lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public int llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public int IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public float llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public EntityPlayerSPUpdateEvent(Runnable runnable, EntityPlayerSPBridge entityPlayerSPBridge, int n, boolean bl, int n2, int n3, float f) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = runnable;
        this.IlllIIIIIIlllIlIIlllIlIIl = entityPlayerSPBridge;
        this.lIllIlIIIlIIIIIIIlllIlIll = n;
        this.llIlllIIIllllIIlllIllIIIl = bl;
        this.llllIIlIIlIIlIIllIIlIIllI = n2;
        this.IlIlIlllllIlIIlIlIlllIlIl = n3;
        this.llIIIIIIIllIIllIlIllIIIIl = f;
    }
}