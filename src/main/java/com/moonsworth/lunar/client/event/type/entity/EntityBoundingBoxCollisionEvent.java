package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.util.AxisAlignedBBBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

import java.util.List;

public class EntityBoundingBoxCollisionEvent
    extends CancellableEvent {
    public final EntityBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public final AxisAlignedBBBridge IlllIIIIIIlllIlIIlllIlIIl;
    public final List<AxisAlignedBBBridge> lIllIlIIIlIIIIIIIlllIlIll;

    public EntityBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public AxisAlignedBBBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public List<AxisAlignedBBBridge> lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public EntityBoundingBoxCollisionEvent(EntityBridge entityBridge, AxisAlignedBBBridge axisAlignedBBBridge, List<AxisAlignedBBBridge> list) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = axisAlignedBBBridge;
        this.lIllIlIIIlIIIIIIIlllIlIll = list;
    }
}