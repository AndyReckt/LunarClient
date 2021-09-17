package com.moonsworth.lunar.client.event.type.entity.player;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.client.event.Event;

public class RemovePlayerEvent
extends Event {
    public EntityPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl;

    public RemovePlayerEvent(EntityPlayerBridge entityPlayerBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityPlayerBridge;
    }

    public EntityPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}