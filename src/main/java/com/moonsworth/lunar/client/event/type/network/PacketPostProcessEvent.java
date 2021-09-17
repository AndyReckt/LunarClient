package com.moonsworth.lunar.client.event.type.network;

import com.moonsworth.lunar.client.event.Event;

import com.lunarclient.bukkitapi.nethandler.LCPacket;

public class PacketPostProcessEvent
extends Event {
    public LCPacket lIlIlIlIlIIlIIlIIllIIIIIl;

    public PacketPostProcessEvent(LCPacket lCPacket) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = lCPacket;
    }

    public LCPacket lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
 