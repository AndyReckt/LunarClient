package com.moonsworth.lunar.client.event.type.hud;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.RenderGlobalBridge;
import com.moonsworth.lunar.client.event.CancellableEvent;

public class RenderHandEvent extends CancellableEvent {
    public final RenderGlobalBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public final float IlllIIIIIIlllIlIIlllIlIIl;
    public final int lIllIlIIIlIIIIIIIlllIlIll;

    public RenderGlobalBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public float IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public int lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public RenderHandEvent(RenderGlobalBridge renderGlobalBridge, float f, int n) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = renderGlobalBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
        this.lIllIlIIIlIIIIIIIlllIlIll = n;
    }
}