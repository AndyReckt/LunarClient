package com.moonsworth.lunar.client.event.type.hud;

import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelBipedBridge;
import com.moonsworth.lunar.client.event.Event;
import com.moonsworth.lunar.client.event.state.EventState;

public class ModelBipedRenderEvent
extends Event {
    public final EventState lIlIlIlIlIIlIIlIIllIIIIIl;
    public final AbstractClientPlayerBridge IlllIIIIIIlllIlIIlllIlIIl;
    public final ModelBipedBridge lIllIlIIIlIIIIIIIlllIlIll;
    public final float llIlllIIIllllIIlllIllIIIl;

    public EventState lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public AbstractClientPlayerBridge IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public ModelBipedBridge lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public float llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public ModelBipedRenderEvent(EventState eventState, AbstractClientPlayerBridge abstractClientPlayerBridge, ModelBipedBridge modelBipedBridge, float f) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = eventState;
        this.IlllIIIIIIlllIlIIlllIlIIl = abstractClientPlayerBridge;
        this.lIllIlIIIlIIIIIIIlllIlIll = modelBipedBridge;
        this.llIlllIIIllllIIlllIllIIIl = f;
    }
}