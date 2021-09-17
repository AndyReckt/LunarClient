package com.moonsworth.lunar.client.event.type.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class GuiOpenEvent
extends CancellableEvent {
    public GuiScreenBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public GuiOpenEvent(GuiScreenBridge guiScreenBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = guiScreenBridge;
    }

    public GuiScreenBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiScreenBridge guiScreenBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = guiScreenBridge;
    }
}