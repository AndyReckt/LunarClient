package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.client.event.Event;
import com.moonsworth.lunar.client.ref.Ref;

public class EventPreAttackEntity extends Event {
    public EntityPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl = Ref.getPlayer();
    public final EntityBridge IlllIIIIIIlllIlIIlllIlIIl;
    public final double lIllIlIIIlIIIIIIIlllIlIll;

    public EventPreAttackEntity(EntityBridge entityBridge, double d) {
        this.IlllIIIIIIlllIlIIlllIlIIl = entityBridge;
        this.lIllIlIIIlIIIIIIIlllIlIll = d;
    }

    public String toString() {
        return "EventPreAttackEntity(player=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", target=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", distance=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ")";
    }

    public EntityPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public EntityBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public double lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }
}