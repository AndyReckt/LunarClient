package com.moonsworth.lunar.client.event.type.entity.player;

import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.client.event.Event;

public class CreatePlayerEvent
    extends Event {
    public AbstractClientPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public CreatePlayerEvent(AbstractClientPlayerBridge abstractClientPlayerBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = abstractClientPlayerBridge;
    }

    public AbstractClientPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}