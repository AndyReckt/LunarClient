package com.moonsworth.lunar.client.event.type.entity.render;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.event.Event;

public class RenderHeldItemEvent
    extends Event {
    public final EntityBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public final ItemStackBridge IlllIIIIIIlllIlIIlllIlIIl;

    public RenderHeldItemEvent(EntityBridge entityBridge, ItemStackBridge itemStackBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = itemStackBridge;
    }

    public EntityBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public ItemStackBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}