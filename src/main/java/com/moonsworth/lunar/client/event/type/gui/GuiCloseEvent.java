package com.moonsworth.lunar.client.event.type.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.client.event.Event;

public class GuiCloseEvent
extends Event {
    public GuiScreenBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public GuiScreenBridge IlllIIIIIIlllIlIIlllIlIIl;

    public GuiScreenBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public GuiScreenBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiScreenBridge guiScreenBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = guiScreenBridge;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(GuiScreenBridge guiScreenBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = guiScreenBridge;
    }

    public GuiCloseEvent(GuiScreenBridge guiScreenBridge, GuiScreenBridge guiScreenBridge2) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = guiScreenBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = guiScreenBridge2;
    }
}