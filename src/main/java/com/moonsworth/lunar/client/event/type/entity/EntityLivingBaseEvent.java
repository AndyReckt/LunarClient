package com.moonsworth.lunar.client.event.type.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.client.event.Event;

public class EntityLivingBaseEvent
extends Event {
    public EntityLivingBaseBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public EntityLivingBaseEvent(EntityLivingBaseBridge entityLivingBaseBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityLivingBaseBridge;
    }

    public static class UpdateEvent
    extends EntityLivingBaseEvent {
        public UpdateEvent(EntityLivingBaseBridge entityLivingBaseBridge) {
            super(entityLivingBaseBridge);
        }
    }
}