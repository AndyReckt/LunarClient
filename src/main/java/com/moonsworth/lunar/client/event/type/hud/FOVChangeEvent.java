package com.moonsworth.lunar.client.event.type.hud;

import com.moonsworth.lunar.client.event.CancellableEvent;
import com.moonsworth.lunar.client.event.EventWithResult;
import lombok.AllArgsConstructor;

/**
 * @author Decencies
 * @since 10/07/2021 13:31
 */
@AllArgsConstructor
public class FOVChangeEvent extends CancellableEvent {

    public final Result lIlIlIlIlIIlIIlIIllIIIIIl;
    public float IlllIIIIIIlllIlIIlllIlIIl;
    public final float lIllIlIIIlIIIIIIIlllIlIll;
    public final float llIlllIIIllllIIlllIllIIIl;
    public final float llllIIlIIlIIlIIllIIlIIllI;

    public Result lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public float IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public float lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public float llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public float llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
    }

    public enum Result {
        RETURN,
        CONSTANT
    }

}
