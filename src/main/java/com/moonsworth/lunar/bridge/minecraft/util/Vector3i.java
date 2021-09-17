package com.moonsworth.lunar.bridge.minecraft.util;

public class Vector3i {
    public final int lIlIlIlIlIIlIIlIIllIIIIIl;
    public final int IlllIIIIIIlllIlIIlllIlIIl;
    public final int lIllIlIIIlIIIIIIIlllIlIll;

    public Vector3i(int n, int n2, int n3) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
        this.IlllIIIIIIlllIlIIlllIlIIl = n2;
        this.lIllIlIIIlIIIIIIIlllIlIll = n3;
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public int lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Vector3i)) {
            return false;
        }
        Vector3i vector3i = (Vector3i)object;
        if (!vector3i.lIlIlIlIlIIlIIlIIllIIIIIl(this)) {
            return false;
        }
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl() != vector3i.lIlIlIlIlIIlIIlIIllIIIIIl()) {
            return false;
        }
        if (this.IlllIIIIIIlllIlIIlllIlIIl() != vector3i.IlllIIIIIIlllIlIIlllIlIIl()) {
            return false;
        }
        return this.lIllIlIIIlIIIIIIIlllIlIll() == vector3i.lIllIlIIIlIIIIIIIlllIlIll();
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object object) {
        return object instanceof Vector3i;
    }

    public int hashCode() {
        int n = 59;
        int n2 = 1;
        n2 = n2 * 59 + this.lIlIlIlIlIIlIIlIIllIIIIIl();
        n2 = n2 * 59 + this.IlllIIIIIIlllIlIIlllIlIIl();
        n2 = n2 * 59 + this.lIllIlIIIlIIIIIIIlllIlIll();
        return n2;
    }

    public String toString() {
        return "Vector3i(x=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", y=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", z=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ")";
    }
}