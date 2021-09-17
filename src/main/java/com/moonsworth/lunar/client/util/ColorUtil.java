package com.moonsworth.lunar.client.util;

public final class ColorUtil {
    public static float lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        return (float)ColorUtil.IlllIIIIIIlllIlIIlllIlIIl(n) / 255.0f;
    }

    public static int IlllIIIIIIlllIlIIlllIlIIl(int n) {
        return n >> 16 & 0xFF;
    }

    public static float lIllIlIIIlIIIIIIIlllIlIll(int n) {
        return (float)ColorUtil.llIlllIIIllllIIlllIllIIIl(n) / 255.0f;
    }

    public static int llIlllIIIllllIIlllIllIIIl(int n) {
        return n >> 8 & 0xFF;
    }

    public static float llllIIlIIlIIlIIllIIlIIllI(int n) {
        return (float)ColorUtil.IlIlIlllllIlIIlIlIlllIlIl(n) / 255.0f;
    }

    public static int IlIlIlllllIlIIlIlIlllIlIl(int n) {
        return n >> 0 & 0xFF;
    }

    public static float llIIIIIIIllIIllIlIllIIIIl(int n) {
        return (float)ColorUtil.lIIIllIllIIllIlllIlIIlllI(n) / 255.0f;
    }

    public static int lIIIllIllIIllIlllIlIIlllI(int n) {
        return n >> 24 & 0xFF;
    }

    public static int lIlIlIlIlIIlIIlIIllIIIIIl(int n, int n2, int n3, int n4) {
        return (n4 & 0xFF) << 24 | (n & 0xFF) << 16 | (n2 & 0xFF) << 8 | n3 & 0xFF;
    }

    public static int lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        return ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl((int)((double)(f * 255.0f) + 0.5), (int)((double)(f2 * 255.0f) + 0.5), (int)((double)(f3 * 255.0f) + 0.5), (int)((double)(f4 * 255.0f) + 0.5));
    }

    public static int lIlIlIlIlIIlIIlIIllIIIIIl(int n, float f) {
        int n2 = (int)((float)ColorUtil.lIIIllIllIIllIlllIlIIlllI(n) * f);
        return n2 << 24 | n & 0xFFFFFF;
    }

    public ColorUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}