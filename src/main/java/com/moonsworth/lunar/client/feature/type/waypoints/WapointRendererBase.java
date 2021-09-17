package com.moonsworth.lunar.client.feature.type.waypoints;

import org.lwjgl.opengl.GL11;

public class WapointRendererBase {
    public int lIlIlIlIlIIlIIlIIllIIIIIl = 100012;
    public int IlllIIIIIIlllIlIIlllIlIIl = 100020;
    public boolean lIllIlIIIlIIIIIIIlllIlIll = false;
    public int llIlllIIIllllIIlllIllIIIl = 100000;

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3) {
        float f4 = (float)Math.sqrt(f * f + f2 * f2 + f3 * f3);
        if (f4 > 1.0E-5f) {
            f /= f4;
            f2 /= f4;
            f3 /= f4;
        }
        GL11.glNormal3f((float)f, (float)f2, (float)f3);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.llIlllIIIllllIIlllIllIIIl = n;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(int n) {
        this.IlllIIIIIIlllIlIIlllIlIIl = n;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.lIllIlIIIlIIIIIIIlllIlIll = bl;
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public int lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll) {
            GL11.glTexCoord2f((float)f, (float)f2);
        }
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        return (float)Math.sin(f);
    }

    public float IlllIIIIIIlllIlIIlllIlIIl(float f) {
        return (float)Math.cos(f);
    }
}
 