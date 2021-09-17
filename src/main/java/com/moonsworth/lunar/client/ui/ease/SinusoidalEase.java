package com.moonsworth.lunar.client.ui.ease;

public class SinusoidalEase
extends LinearEase {
    public SinusoidalEase(long l) {
        super(l, 0.0f);
    }

    @Override
    public float IlllIIIIIIlllIlIIlllIlIIl() {
        float f = super.IlllIIIIIIlllIlIIlllIlIIl();
        float f2 = f * 2.0f - 1.0f;
        return (float)(Math.cos((double)f2 * Math.PI) + 1.0) / 2.0f;
    }

    @Override
    public long lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        return (long)((float)this.lIllIlIIIlIIIIIIIlllIlIll * f);
    }
}
 