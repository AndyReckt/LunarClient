package com.moonsworth.lunar.client.event.type.input;

import com.moonsworth.lunar.client.event.CancellableEvent;
import com.moonsworth.lunar.client.event.state.KeyState;

/**
 * @author Decencies
 * @since 10/07/2021 13:20
 */
public class MouseActionEvent extends CancellableEvent {

    public final int lIlIlIlIlIIlIIlIIllIIIIIl;
    public final KeyState IlllIIIIIIlllIlIIlllIlIIl;

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public KeyState IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public MouseActionEvent(int n, KeyState keyState) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
        this.IlllIIIIIIlllIlIIlllIlIIl = keyState;
    }
}
