package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class EntityDeathEvent
    extends CancellableEvent {
    public EntityLivingBaseBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public EntityDeathEvent(EntityLivingBaseBridge entityLivingBaseBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityLivingBaseBridge;
    }
}