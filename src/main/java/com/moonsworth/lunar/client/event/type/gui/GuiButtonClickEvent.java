package com.moonsworth.lunar.client.event.type.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiButtonBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class GuiButtonClickEvent
extends CancellableEvent {
    public final GuiScreenBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public final GuiButtonBridge IlllIIIIIIlllIlIIlllIlIIl;

    public GuiScreenBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public GuiButtonBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public GuiButtonClickEvent(GuiScreenBridge guiScreenBridge, GuiButtonBridge guiButtonBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = guiScreenBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = guiButtonBridge;
    }
}