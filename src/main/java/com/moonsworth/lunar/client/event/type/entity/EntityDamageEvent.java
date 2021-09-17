package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.util.DamageSourceBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class EntityDamageEvent
extends CancellableEvent {
    public final EntityLivingBaseBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public DamageSourceBridge IlllIIIIIIlllIlIIlllIlIIl;
    public float lIllIlIIIlIIIIIIIlllIlIll;

    public EntityLivingBaseBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public DamageSourceBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public float lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public EntityDamageEvent(EntityLivingBaseBridge entityLivingBaseBridge, DamageSourceBridge damageSourceBridge, float f) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityLivingBaseBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = damageSourceBridge;
        this.lIllIlIIIlIIIIIIIlllIlIll = f;
    }
}