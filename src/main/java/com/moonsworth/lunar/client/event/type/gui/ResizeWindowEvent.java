package com.moonsworth.lunar.client.event.type.gui;

import com.moonsworth.lunar.client.event.Event;

public class ResizeWindowEvent
    extends Event {
    public final int lIlIlIlIlIIlIIlIIllIIIIIl;
    public final int IlllIIIIIIlllIlIIlllIlIIl;

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public ResizeWindowEvent(int n, int n2) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
        this.IlllIIIIIIlllIlIIlllIlIIl = n2;
    }
}
