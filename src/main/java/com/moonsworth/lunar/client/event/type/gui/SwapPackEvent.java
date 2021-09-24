package com.moonsworth.lunar.client.event.type.gui;

import com.moonsworth.lunar.bridge.minecraft.client.resources.AbstractResourcePackBridge;
import com.moonsworth.lunar.client.event.Event;

public class SwapPackEvent
    extends Event {
    public final AbstractResourcePackBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public AbstractResourcePackBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public SwapPackEvent(AbstractResourcePackBridge abstractResourcePackBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = abstractResourcePackBridge;
    }
}