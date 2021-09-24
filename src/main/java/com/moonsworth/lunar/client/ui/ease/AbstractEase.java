package com.moonsworth.lunar.client.ui.ease;

public abstract class AbstractEase {
    public long startTime;
    public long _unusedLong;
    public long duration;
    public boolean someBool = true;
    public float timePassedAsFloat;
    public long currentTimeMinusStartTime;
    public final float maxValue;
    public boolean setTrueByMethod;
    public int tick = 1;
    public int maxTicks = 1;
    public boolean _unusedBool;

    public AbstractEase(long duration, float maxValue) {
        this.duration = duration;
        this.maxValue = maxValue;
    }

    public abstract float getTimePassedAsFloat();

    public abstract long getTimeScale(float scale);

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.startTime = System.currentTimeMillis();
        this.someBool = true;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(long time) {
        this.startTime = System.currentTimeMillis() - time;
        this.someBool = true;
    }

    public void llIlllIIIllllIIlllIllIIIl() {
        this.setTrueByMethod = true;
    }

    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return this.startTime != 0L;
    }

    public boolean IlIlIlllllIlIIlIlIlllIlIl() {
        return this.lIlIIIIIIlIIIllllIllIIlII() <= 0L && this.someBool;
    }

    public void llIIIIIIIllIIllIlIllIIIIl() {
        this.startTime = 0L;
        this.tick = 1;
    }

    public boolean lIIIllIllIIllIlllIlIIlllI() {
        return this.startTime != 0L && this.lIlIIIIIIlIIIllllIllIIlII() > 0L;
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl() {
        if (this.startTime == 0L) {
            return 0.0f;
        }
        if (this.lIlIIIIIIlIIIllllIllIIlII() <= 0L) {
            return 1.0f;
        }
        return this.getTimePassedAsFloat();
    }

    public float getProgress() {
        if (this.startTime == 0L) {
            return 0.0f;
        }
        if (this.IlIlIlllllIlIIlIlIlllIlIl()) {
            if (this.setTrueByMethod || this.maxTicks >= 1 && this.tick < this.maxTicks) {
                this.lIllIlIIIlIIIIIIIlllIlIll();
                ++this.tick;
            }
            return this.maxValue;
        }
        if (this.someBool) {
            return this.getTimePassedAsFloat();
        }
        return this.timePassedAsFloat;
    }

    public void llIIlIlIIIllIlIlIlIIlIIll() {
        this.someBool = false;
        this.timePassedAsFloat = this.getTimePassedAsFloat();
        this.currentTimeMinusStartTime = System.currentTimeMillis() - this.startTime;
    }

    public void llIIIlllIIlllIllllIlIllIl() {
        this.startTime = System.currentTimeMillis() - this.currentTimeMinusStartTime;
        this.someBool = true;
    }

    public long lllllIllIllIllllIlIllllII() {
        long l = this.someBool ? this.lIlIIIIIIlIIIllllIllIIlII() : System.currentTimeMillis() - this.currentTimeMinusStartTime + this.duration - System.currentTimeMillis();
        return Math.min(this.duration, Math.max(0L, l));
    }

    public long lllIIIIIlllIIlIllIIlIIIlI() {
        return this.duration - this.lllllIllIllIllllIlIllllII();
    }

    public long lIlIIIIIIlIIIllllIllIIlII() {
        return this.startTime + this.duration - System.currentTimeMillis();
    }

    public long llIlIIIllIIlIllIllIllllIl() {
        return this.startTime;
    }

    public long IllIllIIIllIIIlIlIlIIIIll() {
        return this._unusedLong;
    }

    public long getDuration() {
        return this.duration;
    }

    public boolean lIIlIlllIlIlIIIlllIIlIIII() {
        return this.someBool;
    }

    public float llIllIlIllIlllIllIIIIllII() {
        return this.timePassedAsFloat;
    }

    public long IllllllllllIlIIIlllIlllll() {
        return this.currentTimeMinusStartTime;
    }

    public float getMaxValue() {
        return this.maxValue;
    }

    public void setMaxTicks(int n) {
        this.maxTicks = n;
    }

    public boolean IllIIIlllIIIlIlllIlIIlIII() {
        return this._unusedBool;
    }
}