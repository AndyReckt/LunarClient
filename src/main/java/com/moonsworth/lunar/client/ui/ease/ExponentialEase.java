package com.moonsworth.lunar.client.ui.ease;

public class ExponentialEase
extends LinearEase {
    public ExponentialEase(long l) {
        super(l);
    }

    @Override
    public float IlllIIIIIIlllIlIIlllIlIIl() {
        float f = super.IlllIIIIIIlllIlIIlllIlIIl();
        return (float)Math.pow(f * (2.0f - f), 1.0);
    }
}