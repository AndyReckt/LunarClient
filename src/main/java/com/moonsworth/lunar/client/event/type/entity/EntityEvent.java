package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.client.event.Event;

public class EntityEvent
    extends Event {
    public EntityBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public EntityEvent(EntityBridge entityBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityBridge;
    }

    public static class EntityAddEvent
        extends EntityEvent {
        public int IlllIIIIIIlllIlIIlllIlIIl;
        public int lIllIlIIIlIIIIIIIlllIlIll;

        public EntityAddEvent(EntityBridge entityBridge, int n, int n2) {
            super(entityBridge);
            this.IlllIIIIIIlllIlIIlllIlIIl = n;
            this.lIllIlIIIlIIIIIIIlllIlIll = n2;
        }
    }
}