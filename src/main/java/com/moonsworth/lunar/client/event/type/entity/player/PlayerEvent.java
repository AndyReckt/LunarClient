package com.moonsworth.lunar.client.event.type.entity.player;

import com.moonsworth.lunar.bridge.minecraft.client.entity.item.EntityItemBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class PlayerEvent
    extends CancellableEvent {
    public final EntityPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public EntityPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public PlayerEvent(EntityPlayerBridge entityPlayerBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityPlayerBridge;
    }

    public static class CollisionEvent
        extends PlayerEvent {
        public final EntityItemBridge lIlIlIlIlIIlIIlIIllIIIIIl;

        public CollisionEvent(EntityPlayerBridge entityPlayerBridge, EntityItemBridge entityItemBridge) {
            super(entityPlayerBridge);
            this.lIlIlIlIlIIlIIlIIllIIIIIl = entityItemBridge;
        }

        public EntityItemBridge IlllIIIIIIlllIlIIlllIlIIl() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }
    }
}