package com.moonsworth.lunar.client.event.type.world;

import com.moonsworth.lunar.client.event.CancellableEvent;

public class DrawSelectionBoundingBoxEvent
extends CancellableEvent {
    public final double lIlIlIlIlIIlIIlIIllIIIIIl;
    public final double IlllIIIIIIlllIlIIlllIlIIl;
    public final double lIllIlIIIlIIIIIIIlllIlIll;
    public final double llIlllIIIllllIIlllIllIIIl;
    public final double llllIIlIIlIIlIIllIIlIIllI;
    public final double IlIlIlllllIlIIlIlIlllIlIl;

    public double lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public double IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public double lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public double llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public double llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public double IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public DrawSelectionBoundingBoxEvent(double d, double d2, double d3, double d4, double d5, double d6) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = d;
        this.IlllIIIIIIlllIlIIlllIlIIl = d2;
        this.lIllIlIIIlIIIIIIIlllIlIll = d3;
        this.llIlllIIIllllIIlllIllIIIl = d4;
        this.llllIIlIIlIIlIIllIIlIIllI = d5;
        this.IlIlIlllllIlIIlIlIlllIlIl = d6;
    }
}