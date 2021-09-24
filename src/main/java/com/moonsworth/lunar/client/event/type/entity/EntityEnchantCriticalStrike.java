package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class EntityEnchantCriticalStrike extends CancellableEvent {
    public EntityBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public EntityEnchantCriticalStrike(EntityBridge var1) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
    }

    public EntityBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
