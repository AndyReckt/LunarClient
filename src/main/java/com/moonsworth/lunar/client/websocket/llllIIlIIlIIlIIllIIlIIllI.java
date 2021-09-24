package com.moonsworth.lunar.client.websocket;

public class llllIIlIIlIIlIIllIIlIIllI {
    public final boolean lIlIlIlIlIIlIIlIIllIIIIIl;
    public int IlllIIIIIIlllIlIIlllIlIIl;
    public long lIllIlIIIlIIIIIIIlllIlIll;

    public llllIIlIIlIIlIIllIIlIIllI(final int illlIIIIIIlllIlIIlllIlIIl, final boolean lIlIlIlIlIIlIIlIIllIIIIIl) {
        this.lIllIlIIIlIIIIIIIlllIlIll = System.currentTimeMillis();
        this.lIlIlIlIlIIlIIlIIllIIIIIl = lIlIlIlIlIIlIIlIIllIIIIIl;
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        if (System.currentTimeMillis() - this.lIllIlIIIlIIIIIIIlllIlIll <= this.IlllIIIIIIlllIlIIlllIlIIl * 1000L) {
            return false;
        }
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            this.IlllIIIIIIlllIlIIlllIlIIl = Math.min(this.IlllIIIIIIlllIlIIlllIlIIl * 2, 120);
        }
        this.lIllIlIIIlIIIIIIIlllIlIll = System.currentTimeMillis();
        return true;
    }
}
