package com.moonsworth.lunar.client.feature.hud.simple;

public class SimpleHudModSize {
    public int lIlIlIlIlIIlIIlIIllIIIIIl;
    public int IlllIIIIIIlllIlIIlllIlIIl;
    public int lIllIlIIIlIIIIIIIlllIlIll;
    public int llIlllIIIllllIIlllIllIIIl;
    public int llllIIlIIlIIlIIllIIlIIllI;
    public int IlIlIlllllIlIIlIlIlllIlIl;

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public int lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public int llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public int llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public int IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.IlllIIIIIIlllIlIIlllIlIIl = n;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(int n) {
        this.lIllIlIIIlIIIIIIIlllIlIll = n;
    }

    public void llIlllIIIllllIIlllIllIIIl(int n) {
        this.llIlllIIIllllIIlllIllIIIl = n;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(int n) {
        this.llllIIlIIlIIlIIllIIlIIllI = n;
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(int n) {
        this.IlIlIlllllIlIIlIlIlllIlIl = n;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SimpleHudModSize)) {
            return false;
        }
        SimpleHudModSize simpleHudModSize = (SimpleHudModSize)object;
        if (!simpleHudModSize.lIlIlIlIlIIlIIlIIllIIIIIl(this)) {
            return false;
        }
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl() != simpleHudModSize.lIlIlIlIlIIlIIlIIllIIIIIl()) {
            return false;
        }
        if (this.IlllIIIIIIlllIlIIlllIlIIl() != simpleHudModSize.IlllIIIIIIlllIlIIlllIlIIl()) {
            return false;
        }
        if (this.lIllIlIIIlIIIIIIIlllIlIll() != simpleHudModSize.lIllIlIIIlIIIIIIIlllIlIll()) {
            return false;
        }
        if (this.llIlllIIIllllIIlllIllIIIl() != simpleHudModSize.llIlllIIIllllIIlllIllIIIl()) {
            return false;
        }
        if (this.llllIIlIIlIIlIIllIIlIIllI() != simpleHudModSize.llllIIlIIlIIlIIllIIlIIllI()) {
            return false;
        }
        return this.IlIlIlllllIlIIlIlIlllIlIl() == simpleHudModSize.IlIlIlllllIlIIlIlIlllIlIl();
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object object) {
        return object instanceof SimpleHudModSize;
    }

    public int hashCode() {
        int n = 59;
        int n2 = 1;
        n2 = n2 * 59 + this.lIlIlIlIlIIlIIlIIllIIIIIl();
        n2 = n2 * 59 + this.IlllIIIIIIlllIlIIlllIlIIl();
        n2 = n2 * 59 + this.lIllIlIIIlIIIIIIIlllIlIll();
        n2 = n2 * 59 + this.llIlllIIIllllIIlllIllIIIl();
        n2 = n2 * 59 + this.llllIIlIIlIIlIIllIIlIIllI();
        n2 = n2 * 59 + this.IlIlIlllllIlIIlIlIlllIlIl();
        return n2;
    }

    public String toString() {
        return "SimpleHudModSize(minHeight=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", height=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", maxHeight=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ", minWidth=" + this.llIlllIIIllllIIlllIllIIIl() + ", width=" + this.llllIIlIIlIIlIIllIIlIIllI() + ", maxWidth=" + this.IlIlIlllllIlIIlIlIlllIlIl() + ")";
    }

    public SimpleHudModSize(int n, int n2, int n3, int n4, int n5, int n6) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
        this.IlllIIIIIIlllIlIIlllIlIIl = n2;
        this.lIllIlIIIlIIIIIIIlllIlIll = n3;
        this.llIlllIIIllllIIlllIllIIIl = n4;
        this.llllIIlIIlIIlIIllIIlIIllI = n5;
        this.IlIlIlllllIlIIlIlIlllIlIl = n6;
    }
}
 