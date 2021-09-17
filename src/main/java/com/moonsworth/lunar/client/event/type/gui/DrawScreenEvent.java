package com.moonsworth.lunar.client.event.type.gui;

import com.moonsworth.lunar.client.event.Event;

import lombok.RequiredArgsConstructor;

/**
 * @author Decencies
 * @since 10/07/2021 13:57
 */
@RequiredArgsConstructor
public class DrawScreenEvent extends Event {
    public final int lIlIlIlIlIIlIIlIIllIIIIIl;
    public final int IlllIIIIIIlllIlIIlllIlIIl;
    public final float lIllIlIIIlIIIIIIIlllIlIll;

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public float lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }
}
