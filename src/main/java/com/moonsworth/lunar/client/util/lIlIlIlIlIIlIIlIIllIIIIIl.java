package com.moonsworth.lunar.client.util;

import java.util.List;

// font shit
public class lIlIlIlIlIIlIIlIIllIIIIIl {
    public final List<lIllIlIIIlIIIIIIIlllIlIll> lIlIlIlIlIIlIIlIIllIIIIIl;
    public final float IlllIIIIIIlllIlIIlllIlIIl;
    public long lIllIlIIIlIIIIIIIlllIlIll;
    public final boolean llIlllIIIllllIIlllIllIIIl;

    public lIlIlIlIlIIlIIlIIllIIIIIl(List list, float f, long l, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = list;
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
        this.lIllIlIIIlIIIIIIIlllIlIll = l;
        this.llIlllIIIllllIIlllIllIIIl = bl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        for (lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2 : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            lIllIlIIIlIIIIIIIlllIlIll2.lIlIlIlIlIIlIIlIIllIIIIIl();
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl() {
        for (lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2 : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            lIllIlIIIlIIIIIIIlllIlIll2.IlllIIIIIIlllIlIIlllIlIIl();
        }
    }

    public float lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public long llIlllIIIllllIIlllIllIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(long l) {
        this.lIllIlIIIlIIIIIIIlllIlIll = l;
    }

    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }
}