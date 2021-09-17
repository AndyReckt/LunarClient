package com.moonsworth.lunar.client.websocket;

public class llllIIlIIlIIlIIllIIlIIllI {
    public final boolean lIlIlIlIlIIlIIlIIllIIIIIl;
    public int IlllIIIIIIlllIlIIlllIlIIl;
    public long lIllIlIIIlIIIIIIIlllIlIll = System.currentTimeMillis();

    public llllIIlIIlIIlIIllIIlIIllI(int n, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = bl;
        this.IlllIIIIIIlllIlIIlllIlIIl = n;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        if (System.currentTimeMillis() - this.lIllIlIIIlIIIIIIIlllIlIll <= (long)this.IlllIIIIIIlllIlIIlllIlIIl * 1000L) {
            return false;
        }
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            this.IlllIIIIIIlllIlIIlllIlIIl = Math.min(this.IlllIIIIIIlllIlIIlllIlIIl * 2, 120);
        }
        this.lIllIlIIIlIIIIIIIlllIlIll = System.currentTimeMillis();
        return true;
    }
}