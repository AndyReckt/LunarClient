package com.moonsworth.lunar.client.event.type.network;

import com.moonsworth.lunar.client.event.Event;

public class CustomPayloadEvent extends Event {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public byte[] IlllIIIIIIlllIlIIlllIlIIl;

    public CustomPayloadEvent(String string, byte[] byArray) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.IlllIIIIIIlllIlIIlllIlIIl = byArray;
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public byte[] IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}
