package com.moonsworth.lunar.client.util;

public final class MathHelperUtil {
    public static double lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d, d3));
    }

    public static int lIlIlIlIlIIlIIlIIllIIIIIl(int n, int n2, int n3) {
        return Math.max(n2, Math.min(n, n3));
    }

    public static int lIlIlIlIlIIlIIlIIllIIIIIl(double d) {
        int n = (int)d;
        return d > (double)n ? n + 1 : n;
    }

    public static int IlllIIIIIIlllIlIIlllIlIIl(double d) {
        int n = (int)d;
        return d < (double)n ? n - 1 : n;
    }

    public static float lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        if ((f %= 360.0f) >= 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    public static double lIllIlIIIlIIIIIIIlllIlIll(double d) {
        if ((d %= 360.0) >= 180.0) {
            d -= 360.0;
        }
        if (d < -180.0) {
            d += 360.0;
        }
        return d;
    }

    public static double llIlllIIIllllIIlllIllIIIl(double d) {
        return d - Math.floor(d);
    }

    public static float lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3) {
        return f3 >= 1.0f ? f2 : (f3 <= 0.0f ? f : f + (f2 - f) * f3);
    }

    public MathHelperUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}