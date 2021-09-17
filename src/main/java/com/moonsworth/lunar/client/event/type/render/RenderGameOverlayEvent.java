package com.moonsworth.lunar.client.event.type.render;

import com.moonsworth.lunar.client.event.Event;

public class RenderGameOverlayEvent
extends Event {
    public final double lIlIlIlIlIIlIIlIIllIIIIIl;
    public final double IlllIIIIIIlllIlIIlllIlIIl;

    public RenderGameOverlayEvent(double d, double d2) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = d;
        this.IlllIIIIIIlllIlIIlllIlIIl = d2;
    }

    public double lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public double IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}
 