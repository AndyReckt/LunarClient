package com.moonsworth.lunar.bridge.minecraft.util;

public class Vector3d {
    public double lIlIlIlIlIIlIIlIIllIIIIIl;
    public double IlllIIIIIIlllIlIIlllIlIIl;
    public double lIllIlIIIlIIIIIIIlllIlIll;

    public static Vector3d lIlIlIlIlIIlIIlIIllIIIIIl(Vector3d vector3d, Vector3d vector3d2, Vector3d vector3d3) {
        if (vector3d3 == null) {
            vector3d3 = new Vector3d();
        }
        vector3d3.lIlIlIlIlIIlIIlIIllIIIIIl = vector3d.lIlIlIlIlIIlIIlIIllIIIIIl - vector3d2.lIlIlIlIlIIlIIlIIllIIIIIl;
        vector3d3.IlllIIIIIIlllIlIIlllIlIIl = vector3d.IlllIIIIIIlllIlIIlllIlIIl - vector3d2.IlllIIIIIIlllIlIIlllIlIIl;
        vector3d3.lIllIlIIIlIIIIIIIlllIlIll = vector3d.lIllIlIIIlIIIIIIIlllIlIll - vector3d2.lIllIlIIIlIIIIIIIlllIlIll;
        return vector3d3;
    }

    public double lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public double IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public double lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(double d) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = d;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(double d) {
        this.IlllIIIIIIlllIlIIlllIlIIl = d;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(double d) {
        this.lIllIlIIIlIIIIIIIlllIlIll = d;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Vector3d)) {
            return false;
        }
        Vector3d vector3d = (Vector3d)object;
        if (!vector3d.lIlIlIlIlIIlIIlIIllIIIIIl(this)) {
            return false;
        }
        if (Double.compare(this.lIlIlIlIlIIlIIlIIllIIIIIl(), vector3d.lIlIlIlIlIIlIIlIIllIIIIIl()) != 0) {
            return false;
        }
        if (Double.compare(this.IlllIIIIIIlllIlIIlllIlIIl(), vector3d.IlllIIIIIIlllIlIIlllIlIIl()) != 0) {
            return false;
        }
        return Double.compare(this.lIllIlIIIlIIIIIIIlllIlIll(), vector3d.lIllIlIIIlIIIIIIIlllIlIll()) == 0;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object object) {
        return object instanceof Vector3d;
    }

    public int hashCode() {
        int n = 59;
        int n2 = 1;
        long l = Double.doubleToLongBits(this.lIlIlIlIlIIlIIlIIllIIIIIl());
        n2 = n2 * 59 + (int)(l >>> 32 ^ l);
        long l2 = Double.doubleToLongBits(this.IlllIIIIIIlllIlIIlllIlIIl());
        n2 = n2 * 59 + (int)(l2 >>> 32 ^ l2);
        long l3 = Double.doubleToLongBits(this.lIllIlIIIlIIIIIIIlllIlIll());
        n2 = n2 * 59 + (int)(l3 >>> 32 ^ l3);
        return n2;
    }

    public String toString() {
        return "Vector3d(x=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", y=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", z=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ")";
    }

    public Vector3d() {
    }

    public Vector3d(double d, double d2, double d3) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = d;
        this.IlllIIIIIIlllIlIIlllIlIIl = d2;
        this.lIllIlIIIlIIIIIIIlllIlIll = d3;
    }
}