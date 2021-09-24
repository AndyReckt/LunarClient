package com.moonsworth.lunar.client.event.type.network;

import com.moonsworth.lunar.client.event.Event;

public class VanillaCustomPayloadEvent
    extends Event {
    public final String lIlIlIlIlIIlIIlIIllIIIIIl;

    public VanillaCustomPayloadEvent(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
