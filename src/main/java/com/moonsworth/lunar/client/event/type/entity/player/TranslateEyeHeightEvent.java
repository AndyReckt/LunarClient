package com.moonsworth.lunar.client.event.type.entity.player;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.client.event.Event;

public class TranslateEyeHeightEvent extends Event {
    public final EntityPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public float IlllIIIIIIlllIlIIlllIlIIl;

    public TranslateEyeHeightEvent(EntityPlayerBridge entityPlayerBridge, float f) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = entityPlayerBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
    }

    public EntityPlayerBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public float IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
    }
}