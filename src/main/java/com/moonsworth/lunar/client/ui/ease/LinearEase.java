package com.moonsworth.lunar.client.ui.ease;

public class LinearEase
extends AbstractEase {
    public LinearEase(long l) {
        super(l, 1.0f);
    }

    public LinearEase(long l, float f) {
        super(l, f);
    }

    @Override
    public float IlllIIIIIIlllIlIIlllIlIIl() {
        return (float)(this.lIllIlIIIlIIIIIIIlllIlIll - this.lIlIIIIIIlIIIllllIllIIlII()) / (float)this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    @Override
    public long lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        return (long)((float)this.lIllIlIIIlIIIIIIIlllIlIll * f);
    }
}