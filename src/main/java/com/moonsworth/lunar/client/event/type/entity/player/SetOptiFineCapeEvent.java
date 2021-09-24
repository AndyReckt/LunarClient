package com.moonsworth.lunar.client.event.type.entity.player;

import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class SetOptiFineCapeEvent
    extends CancellableEvent {
    public AbstractClientPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public SetOptiFineCapeEvent(AbstractClientPlayerBridge abstractClientPlayerBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = abstractClientPlayerBridge;
    }

    public AbstractClientPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}