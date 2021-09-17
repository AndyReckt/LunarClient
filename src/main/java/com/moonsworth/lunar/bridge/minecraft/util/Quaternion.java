package com.moonsworth.lunar.bridge.minecraft.util;

public final class Quaternion {
    public static final Quaternion lIlIlIlIlIIlIIlIIllIIIIIl = new Quaternion(0.0f, 0.0f, 0.0f, 1.0f);
    public float IlllIIIIIIlllIlIIlllIlIIl;
    public float lIllIlIIIlIIIIIIIlllIlIll;
    public float llIlllIIIllllIIlllIllIIIl;
    public float llllIIlIIlIIlIIllIIlIIllI;

    public Quaternion(float f, float f2, float f3, float f4) {
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
        this.lIllIlIIIlIIIIIIIlllIlIll = f2;
        this.llIlllIIIllllIIlllIllIIIl = f3;
        this.llllIIlIIlIIlIIllIIlIIllI = f4;
    }

    public Quaternion(Vector3f vector3f, float f, boolean bl) {
        if (bl) {
            f *= (float)Math.PI / 180;
        }
        float f2 = Quaternion.lIllIlIIIlIIIIIIIlllIlIll(f / 2.0f);
        this.IlllIIIIIIlllIlIIlllIlIIl = vector3f.llIIIIIIIllIIllIlIllIIIIl * f2;
        this.lIllIlIIIlIIIIIIIlllIlIll = vector3f.lIIIllIllIIllIlllIlIIlllI * f2;
        this.llIlllIIIllllIIlllIllIIIl = vector3f.IlllllIlIIIlIIlIIllIIlIll * f2;
        this.llllIIlIIlIIlIIllIIlIIllI = Quaternion.IlllIIIIIIlllIlIIlllIlIIl(f / 2.0f);
    }

    public Quaternion(float f, float f2, float f3, boolean bl) {
        if (bl) {
            f *= (float)Math.PI / 180;
            f2 *= (float)Math.PI / 180;
            f3 *= (float)Math.PI / 180;
        }
        float f4 = Quaternion.lIllIlIIIlIIIIIIIlllIlIll(0.5f * f);
        float f5 = Quaternion.IlllIIIIIIlllIlIIlllIlIIl(0.5f * f);
        float f6 = Quaternion.lIllIlIIIlIIIIIIIlllIlIll(0.5f * f2);
        float f7 = Quaternion.IlllIIIIIIlllIlIIlllIlIIl(0.5f * f2);
        float f8 = Quaternion.lIllIlIIIlIIIIIIIlllIlIll(0.5f * f3);
        float f9 = Quaternion.IlllIIIIIIlllIlIIlllIlIIl(0.5f * f3);
        this.IlllIIIIIIlllIlIIlllIlIIl = f4 * f7 * f9 + f5 * f6 * f8;
        this.lIllIlIIIlIIIIIIIlllIlIll = f5 * f6 * f9 - f4 * f7 * f8;
        this.llIlllIIIllllIIlllIllIIIl = f4 * f6 * f9 + f5 * f7 * f8;
        this.llllIIlIIlIIlIIllIIlIIllI = f5 * f7 * f9 - f4 * f6 * f8;
    }

    public Quaternion(Quaternion quaternion) {
        this.IlllIIIIIIlllIlIIlllIlIIl = quaternion.IlllIIIIIIlllIlIIlllIlIIl;
        this.lIllIlIIIlIIIIIIIlllIlIll = quaternion.lIllIlIIIlIIIIIIIlllIlIll;
        this.llIlllIIIllllIIlllIllIIIl = quaternion.llIlllIIIllllIIlllIllIIIl;
        this.llllIIlIIlIIlIIllIIlIIllI = quaternion.llllIIlIIlIIlIIllIIlIIllI;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            Quaternion quaternion = (Quaternion)object;
            if (Float.compare(quaternion.IlllIIIIIIlllIlIIlllIlIIl, this.IlllIIIIIIlllIlIIlllIlIIl) != 0) {
                return false;
            }
            if (Float.compare(quaternion.lIllIlIIIlIIIIIIIlllIlIll, this.lIllIlIIIlIIIIIIIlllIlIll) != 0) {
                return false;
            }
            if (Float.compare(quaternion.llIlllIIIllllIIlllIllIIIl, this.llIlllIIIllllIIlllIllIIIl) != 0) {
                return false;
            }
            return Float.compare(quaternion.llllIIlIIlIIlIIllIIlIIllI, this.llllIIlIIlIIlIIllIIlIIllI) == 0;
        }
        return false;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Quaternion quaternion) {
        float f = this.llIlllIIIllllIIlllIllIIIl();
        float f2 = this.llllIIlIIlIIlIIllIIlIIllI();
        float f3 = this.IlIlIlllllIlIIlIlIlllIlIl();
        float f4 = this.llIIIIIIIllIIllIlIllIIIIl();
        float f5 = quaternion.llIlllIIIllllIIlllIllIIIl();
        float f6 = quaternion.llllIIlIIlIIlIIllIIlIIllI();
        float f7 = quaternion.IlIlIlllllIlIIlIlIlllIlIl();
        float f8 = quaternion.llIIIIIIIllIIllIlIllIIIIl();
        this.IlllIIIIIIlllIlIIlllIlIIl = f4 * f5 + f * f8 + f2 * f7 - f3 * f6;
        this.lIllIlIIIlIIIIIIIlllIlIll = f4 * f6 - f * f7 + f2 * f8 + f3 * f5;
        this.llIlllIIIllllIIlllIllIIIl = f4 * f7 + f * f6 - f2 * f5 + f3 * f8;
        this.llllIIlIIlIIlIIllIIlIIllI = f4 * f8 - f * f5 - f2 * f6 - f3 * f7;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.IlllIIIIIIlllIlIIlllIlIIl *= f;
        this.lIllIlIIIlIIIIIIIlllIlIll *= f;
        this.llIlllIIIllllIIlllIllIIIl *= f;
        this.llllIIlIIlIIlIIllIIlIIllI *= f;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.IlllIIIIIIlllIlIIlllIlIIl = -this.IlllIIIIIIlllIlIIlllIlIIl;
        this.lIllIlIIIlIIIIIIIlllIlIll = -this.lIllIlIIIlIIIIIIIlllIlIll;
        this.llIlllIIIllllIIlllIllIIIl = -this.llIlllIIIllllIIlllIllIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
        this.lIllIlIIIlIIIIIIIlllIlIll = f2;
        this.llIlllIIIllllIIlllIllIIIl = f3;
        this.llllIIlIIlIIlIIllIIlIIllI = f4;
    }

    public static float IlllIIIIIIlllIlIIlllIlIIl(float f) {
        return (float)Math.cos(f);
    }

    public static float lIllIlIIIlIIIIIIIlllIlIll(float f) {
        return (float)Math.sin(f);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl() {
        float f = this.llIlllIIIllllIIlllIllIIIl() * this.llIlllIIIllllIIlllIllIIIl() + this.llllIIlIIlIIlIIllIIlIIllI() * this.llllIIlIIlIIlIIllIIlIIllI() + this.IlIlIlllllIlIIlIlIlllIlIl() * this.IlIlIlllllIlIIlIlIlllIlIl() + this.llIIIIIIIllIIllIlIllIIIIl() * this.llIIIIIIIllIIllIlIllIIIIl();
        if (f > 1.0E-6f) {
            float f2 = Quaternion.llIlllIIIllllIIlllIllIIIl(f);
            this.IlllIIIIIIlllIlIIlllIlIIl *= f2;
            this.lIllIlIIIlIIIIIIIlllIlIll *= f2;
            this.llIlllIIIllllIIlllIllIIIl *= f2;
            this.llllIIlIIlIIlIIllIIlIIllI *= f2;
        } else {
            this.IlllIIIIIIlllIlIIlllIlIIl = 0.0f;
            this.lIllIlIIIlIIIIIIIlllIlIll = 0.0f;
            this.llIlllIIIllllIIlllIllIIIl = 0.0f;
            this.llllIIlIIlIIlIIllIIlIIllI = 0.0f;
        }
    }

    public Quaternion lIllIlIIIlIIIIIIIlllIlIll() {
        return new Quaternion(this);
    }

    public static float llIlllIIIllllIIlllIllIIIl(float f) {
        float f2 = 0.5f * f;
        int n = Float.floatToIntBits(f);
        n = 1597463007 - (n >> 1);
        f = Float.intBitsToFloat(n);
        f *= 1.5f - f2 * f * f;
        return f;
    }

    public float llIlllIIIllllIIlllIllIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public float llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public float IlIlIlllllIlIIlIlIlllIlIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public float llIIIIIIIllIIllIlIllIIIIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(float f) {
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(float f) {
        this.lIllIlIIIlIIIIIIIlllIlIll = f;
    }

    public void llIIIIIIIllIIllIlIllIIIIl(float f) {
        this.llIlllIIIllllIIlllIllIIIl = f;
    }

    public void lIIIllIllIIllIlllIlIIlllI(float f) {
        this.llllIIlIIlIIlIIllIIlIIllI = f;
    }

    public String toString() {
        return "Quaternion(x=" + this.llIlllIIIllllIIlllIllIIIl() + ", y=" + this.llllIIlIIlIIlIIllIIlIIllI() + ", z=" + this.IlIlIlllllIlIIlIlIlllIlIl() + ", w=" + this.llIIIIIIIllIIllIlIllIIIIl() + ")";
    }
}