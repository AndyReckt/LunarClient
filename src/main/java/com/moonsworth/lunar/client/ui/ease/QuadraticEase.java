package com.moonsworth.lunar.client.ui.ease;

public class QuadraticEase extends LinearEase {
    public QuadraticEase(long l) {
        super(l);
    }

    @Override
    public float getTimePassedAsFloat() {
        float f = super.getTimePassedAsFloat();
        return (double)f < 0.5 ? 2.0f * f * f : -1.0f + (4.0f - 2.0f * f) * f;
    }

    @Override
    public long getTimeScale(float scale) {
        return (long)((float)this.duration * scale);
    }
}
