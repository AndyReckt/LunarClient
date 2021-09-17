package com.moonsworth.lunar.client.event.type.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.CustomScreen;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class CloseCustomScreenEvent
extends CancellableEvent {
    public final CustomScreen lIlIlIlIlIIlIIlIIllIIIIIl;

    public CloseCustomScreenEvent(CustomScreen customScreen) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = customScreen;
    }

    public CustomScreen lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}