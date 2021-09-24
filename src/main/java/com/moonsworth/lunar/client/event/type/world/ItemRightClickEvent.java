package com.moonsworth.lunar.client.event.type.world;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class ItemRightClickEvent extends CancellableEvent {
    public ItemStackBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public EntityPlayerBridge IlllIIIIIIlllIlIIlllIlIIl;

    public ItemRightClickEvent(ItemStackBridge itemStackBridge, EntityPlayerBridge entityPlayerBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = itemStackBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = entityPlayerBridge;
    }
}