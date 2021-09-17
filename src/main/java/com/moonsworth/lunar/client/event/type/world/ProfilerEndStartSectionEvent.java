package com.moonsworth.lunar.client.event.type.world;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.RenderGlobalBridge;
import com.moonsworth.lunar.client.event.Event;

public class ProfilerEndStartSectionEvent
extends Event {
    public final RenderGlobalBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public final float IlllIIIIIIlllIlIIlllIlIIl;

    public RenderGlobalBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public float IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public ProfilerEndStartSectionEvent(RenderGlobalBridge renderGlobalBridge, float f) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = renderGlobalBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
    }
}