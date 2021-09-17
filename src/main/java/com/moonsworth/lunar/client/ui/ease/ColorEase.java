package com.moonsworth.lunar.client.ui.ease;

import java.awt.*;

public class ColorEase
extends LinearEase {
    public int startColor;
    public int endColor;
    public boolean llIIlIlIIIllIlIlIlIIlIIll;
    public Color llIIIlllIIlllIllllIlIllIl;
    public Color lllllIllIllIllllIlIllllII;

    public ColorEase(long l, int n, int n2) {
        super(l);
        this.startColor = n;
        this.endColor = n2;
    }

    public ColorEase(int n, int n2) {
        this(125L, n, n2);
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        int n;
        int n2 = n = bl ? this.endColor : this.startColor;
        if (bl && !this.llIIlIlIIIllIlIlIlIIlIIll) {
            this.llIIlIlIIIllIlIlIlIIlIIll = true;
            this.llIIIlllIIlllIllllIlIllIl = new Color(this.startColor, true);
            this.lllllIllIllIllllIlIllllII = new Color(this.endColor, true);
            this.lIllIlIIIlIIIIIIIlllIlIll();
        } else if (this.llIIlIlIIIllIlIlIlIIlIIll && !bl) {
            this.llIIlIlIIIllIlIlIlIIlIIll = false;
            this.llIIIlllIIlllIllllIlIllIl = new Color(this.endColor, true);
            this.lllllIllIllIllllIlIllllII = new Color(this.startColor, true);
            this.lIllIlIIIlIIIIIIIlllIlIll();
        }
        if (this.lIIIllIllIIllIlllIlIIlllI()) {
            float f = super.IlllllIlIIIlIIlIIllIIlIll();
            int n3 = (int)Math.abs(f * (float)this.lllllIllIllIllllIlIllllII.getRed() + (1.0f - f) * (float)this.llIIIlllIIlllIllllIlIllIl.getRed());
            int n4 = (int)Math.abs(f * (float)this.lllllIllIllIllllIlIllllII.getGreen() + (1.0f - f) * (float)this.llIIIlllIIlllIllllIlIllIl.getGreen());
            int n5 = (int)Math.abs(f * (float)this.lllllIllIllIllllIlIllllII.getBlue() + (1.0f - f) * (float)this.llIIIlllIIlllIllllIlIllIl.getBlue());
            int n6 = (int)Math.abs(f * (float)this.lllllIllIllIllllIlIllllII.getAlpha() + (1.0f - f) * (float)this.llIIIlllIIlllIllllIlIllIl.getAlpha());
            n = (n6 & 0xFF) << 24 | (n3 & 0xFF) << 16 | (n4 & 0xFF) << 8 | n5 & 0xFF;
        }
        return n;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.startColor = n;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(int n) {
        this.endColor = n;
    }

    // lIlIlIlIlIIlIIlIIllIIIIIl()
    public int getEndColor() {
        return this.endColor;
    }
}