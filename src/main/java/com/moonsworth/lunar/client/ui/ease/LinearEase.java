package com.moonsworth.lunar.client.ui.ease;

public class LinearEase extends AbstractEase {
    public LinearEase(long duration) {
        super(duration, 1.0f);
    }

    public LinearEase(long duration, float maxValue) {
        super(duration, maxValue);
    }

    @Override
    public float getTimePassedAsFloat() {
        return (float)(this.duration - this.lIlIIIIIIlIIIllllIllIIlII()) / (float)this.duration;
    }

    @Override
    public long getTimeScale(float scale) {
        return (long)((float)this.duration * scale);
    }
}