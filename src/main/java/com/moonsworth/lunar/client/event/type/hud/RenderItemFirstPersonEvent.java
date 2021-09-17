package com.moonsworth.lunar.client.event.type.hud;

import com.moonsworth.lunar.bridge.minecraft.item.ItemBridge;
import com.moonsworth.lunar.client.event.Event;

public class RenderItemFirstPersonEvent
extends Event {
    public final ItemBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public RenderItemFirstPersonEvent(ItemBridge itemBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = itemBridge;
    }

    public ItemBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}