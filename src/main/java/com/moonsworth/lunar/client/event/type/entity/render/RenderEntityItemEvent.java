package com.moonsworth.lunar.client.event.type.entity.render;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.item.EntityItemBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class RenderEntityItemEvent
    extends CancellableEvent {
    public int lIlIlIlIlIIlIIlIIllIIIIIl;
    public Object IlllIIIIIIlllIlIIlllIlIIl;
    public MatrixStackBridge lIllIlIIIlIIIIIIIlllIlIll;
    public EntityItemBridge llIlllIIIllllIIlllIllIIIl;
    public double llllIIlIIlIIlIIllIIlIIllI;
    public double IlIlIlllllIlIIlIlIlllIlIl;
    public double llIIIIIIIllIIllIlIllIIIIl;
    public boolean lIIIllIllIIllIlllIlIIlllI = false;
    public float IlllllIlIIIlIIlIIllIIlIll = 1.0f;

    public RenderEntityItemEvent() {
    }

    public RenderEntityItemEvent(int n, Object object, MatrixStackBridge matrixStackBridge, EntityItemBridge entityItemBridge, double d, double d2, double d3, boolean bl, float f) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
        this.IlllIIIIIIlllIlIIlllIlIIl = object;
        this.lIllIlIIIlIIIIIIIlllIlIll = matrixStackBridge;
        this.llIlllIIIllllIIlllIllIIIl = entityItemBridge;
        this.llllIIlIIlIIlIIllIIlIIllI = d;
        this.IlIlIlllllIlIIlIlIlllIlIl = d2;
        this.llIIIIIIIllIIllIlIllIIIIl = d3;
        this.lIIIllIllIIllIlllIlIIlllI = bl;
        this.IlllllIlIIIlIIlIIllIIlIll = f;
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public Object IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public MatrixStackBridge lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public EntityItemBridge llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public double llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public double IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public double llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public boolean lIIIllIllIIllIlllIlIIlllI() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public float IlllllIlIIIlIIlIIllIIlIll() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }
}