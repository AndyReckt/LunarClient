package com.moonsworth.lunar.client.event.type.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.client.event.Event;
import com.moonsworth.lunar.client.event.state.EventState;

public class GuiResizeEvent
extends Event {
    public final EventState lIlIlIlIlIIlIIlIIllIIIIIl;
    public final GuiScreenBridge IlllIIIIIIlllIlIIlllIlIIl;

    public GuiResizeEvent(EventState eventState, GuiScreenBridge guiScreenBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = eventState;
        this.IlllIIIIIIlllIlIIlllIlIIl = guiScreenBridge;
    }

    public EventState lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public GuiScreenBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}