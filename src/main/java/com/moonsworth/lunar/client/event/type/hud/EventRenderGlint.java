package com.moonsworth.lunar.client.event.type.hud;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.BuiltInModelBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.IBakedModelBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class EventRenderGlint
    extends CancellableEvent {
    public final Where lIlIlIlIlIIlIIlIIllIIIIIl;
    public final IBakedModelBridge IlllIIIIIIlllIlIIlllIlIIl;
    public final EntityBridge lIllIlIIIlIIIIIIIlllIlIll;
    public final ItemStackBridge llIlllIIIllllIIlllIllIIIl;

    public Where lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public IBakedModelBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public EntityBridge lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public ItemStackBridge llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public EventRenderGlint(Where where, IBakedModelBridge bakedModelBridge, EntityBridge entityBridge, ItemStackBridge itemStackBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = where;
        this.IlllIIIIIIlllIlIIlllIlIIl = bakedModelBridge;
        this.lIllIlIIIlIIIIIIIlllIlIll = entityBridge;
        this.llIlllIIIllllIIlllIllIIIl = itemStackBridge;
    }

    public enum Where {
        lIlIlIlIlIIlIIlIIllIIIIIl, // EQUIPPED_ARMOR
        IlllIIIIIIlllIlIIlllIlIIl, // ITEM
        lIllIlIIIlIIIIIIIlllIlIll // GUI

    }
}