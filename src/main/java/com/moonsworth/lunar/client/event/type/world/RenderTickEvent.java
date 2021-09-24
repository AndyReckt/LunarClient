package com.moonsworth.lunar.client.event.type.world;

import com.moonsworth.lunar.client.event.Event;
import com.moonsworth.lunar.client.event.state.EventState;

public class RenderTickEvent extends Event {
    public final EventState lIlIlIlIlIIlIIlIIllIIIIIl;
    public final float IlllIIIIIIlllIlIIlllIlIIl;

    public EventState lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public float IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public RenderTickEvent(EventState eventState, float f) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = eventState;
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
    }
}