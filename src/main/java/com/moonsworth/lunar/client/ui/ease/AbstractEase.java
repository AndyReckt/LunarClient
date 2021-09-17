package com.moonsworth.lunar.client.ui.ease;

public abstract class AbstractEase {
    public long lIlIlIlIlIIlIIlIIllIIIIIl;
    public long IlllIIIIIIlllIlIIlllIlIIl;
    public long lIllIlIIIlIIIIIIIlllIlIll;
    public boolean llIlllIIIllllIIlllIllIIIl = true;
    public float llllIIlIIlIIlIIllIIlIIllI;
    public long IlIlIlllllIlIIlIlIlllIlIl;
    public final float llIIIIIIIllIIllIlIllIIIIl;
    public boolean lIIIllIllIIllIlllIlIIlllI;
    public int IlllllIlIIIlIIlIIllIIlIll = 1;
    public int llIIlIlIIIllIlIlIlIIlIIll = 1;
    public boolean llIIIlllIIlllIllllIlIllIl;

    public AbstractEase(long l, float f) {
        this.lIllIlIIIlIIIIIIIlllIlIll = l;
        this.llIIIIIIIllIIllIlIllIIIIl = f;
    }

    public abstract float IlllIIIIIIlllIlIIlllIlIIl();

    public abstract long lIlIlIlIlIIlIIlIIllIIIIIl(float var1);

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = System.currentTimeMillis();
        this.llIlllIIIllllIIlllIllIIIl = true;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(long l) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = System.currentTimeMillis() - l;
        this.llIlllIIIllllIIlllIllIIIl = true;
    }

    public void llIlllIIIllllIIlllIllIIIl() {
        this.lIIIllIllIIllIlllIlIIlllI = true;
    }

    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl != 0L;
    }

    public boolean IlIlIlllllIlIIlIlIlllIlIl() {
        return this.lIlIIIIIIlIIIllllIllIIlII() <= 0L && this.llIlllIIIllllIIlllIllIIIl;
    }

    public void llIIIIIIIllIIllIlIllIIIIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = 0L;
        this.IlllllIlIIIlIIlIIllIIlIll = 1;
    }

    public boolean lIIIllIllIIllIlllIlIIlllI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl != 0L && this.lIlIIIIIIlIIIllllIllIIlII() > 0L;
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl() {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl == 0L) {
            return 0.0f;
        }
        if (this.lIlIIIIIIlIIIllllIllIIlII() <= 0L) {
            return 1.0f;
        }
        return this.IlllIIIIIIlllIlIIlllIlIIl();
    }

    public float IlllllIlIIIlIIlIIllIIlIll() {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl == 0L) {
            return 0.0f;
        }
        if (this.IlIlIlllllIlIIlIlIlllIlIl()) {
            if (this.lIIIllIllIIllIlllIlIIlllI || this.llIIlIlIIIllIlIlIlIIlIIll >= 1 && this.IlllllIlIIIlIIlIIllIIlIll < this.llIIlIlIIIllIlIlIlIIlIIll) {
                this.lIllIlIIIlIIIIIIIlllIlIll();
                ++this.IlllllIlIIIlIIlIIllIIlIll;
            }
            return this.llIIIIIIIllIIllIlIllIIIIl;
        }
        if (this.llIlllIIIllllIIlllIllIIIl) {
            return this.IlllIIIIIIlllIlIIlllIlIIl();
        }
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public void llIIlIlIIIllIlIlIlIIlIIll() {
        this.llIlllIIIllllIIlllIllIIIl = false;
        this.llllIIlIIlIIlIIllIIlIIllI = this.IlllIIIIIIlllIlIIlllIlIIl();
        this.IlIlIlllllIlIIlIlIlllIlIl = System.currentTimeMillis() - this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void llIIIlllIIlllIllllIlIllIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = System.currentTimeMillis() - this.IlIlIlllllIlIIlIlIlllIlIl;
        this.llIlllIIIllllIIlllIllIIIl = true;
    }

    public long lllllIllIllIllllIlIllllII() {
        long l = this.llIlllIIIllllIIlllIllIIIl ? this.lIlIIIIIIlIIIllllIllIIlII() : System.currentTimeMillis() - this.IlIlIlllllIlIIlIlIlllIlIl + this.lIllIlIIIlIIIIIIIlllIlIll - System.currentTimeMillis();
        return Math.min(this.lIllIlIIIlIIIIIIIlllIlIll, Math.max(0L, l));
    }

    public long lllIIIIIlllIIlIllIIlIIIlI() {
        return this.lIllIlIIIlIIIIIIIlllIlIll - this.lllllIllIllIllllIlIllllII();
    }

    public long lIlIIIIIIlIIIllllIllIIlII() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl + this.lIllIlIIIlIIIIIIIlllIlIll - System.currentTimeMillis();
    }

    public long llIlIIIllIIlIllIllIllllIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public long IllIllIIIllIIIlIlIlIIIIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public long IIlIllIlllllllIIlIIIllIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public boolean lIIlIlllIlIlIIIlllIIlIIII() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public float llIllIlIllIlllIllIIIIllII() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public long IllllllllllIlIIIlllIlllll() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public float lllllIllIlIIlIIlIIIlllIlI() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.llIIlIlIIIllIlIlIlIIlIIll = n;
    }

    public boolean IllIIIlllIIIlIlllIlIIlIII() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }
}