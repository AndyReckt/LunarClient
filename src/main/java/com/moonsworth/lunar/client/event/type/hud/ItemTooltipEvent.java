package com.moonsworth.lunar.client.event.type.hud;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.event.Event;

import java.util.List;

public class ItemTooltipEvent
    extends Event {
    public final EntityPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public final ItemStackBridge IlllIIIIIIlllIlIIlllIlIIl;
    public final List lIllIlIIIlIIIIIIIlllIlIll;
    public boolean llIlllIIIllllIIlllIllIIIl = false;

    public ItemTooltipEvent(EntityPlayerBridge entityPlayerBridge, ItemStackBridge itemStackBridge, List list) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityPlayerBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = itemStackBridge;
        this.lIllIlIIIlIIIIIIIlllIlIll = list;
    }

    public ItemTooltipEvent(EntityPlayerBridge entityPlayerBridge, ItemStackBridge itemStackBridge, List list, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityPlayerBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = itemStackBridge;
        this.lIllIlIIIlIIIIIIIlllIlIll = list;
        this.llIlllIIIllllIIlllIllIIIl = bl;
    }

    public EntityPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public ItemStackBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public List lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }
}