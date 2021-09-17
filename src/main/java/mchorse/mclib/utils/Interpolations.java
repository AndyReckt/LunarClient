/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  lunar.a.Bridge
 */
package mchorse.mclib.utils;

import lunar.a.Bridge;

public class Interpolations {
    public static float lerp(float f, float f2, float f3) {
        return f + (f2 - f) * f3;
    }

    public static float lerpYaw(float f, float f2, float f3) {
        f = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_float(f);
        f2 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_float(f2);
        return Interpolations.lerp(f, Interpolations.normalizeYaw(f, f2), f3);
    }

    public static double cubicHermite(double d, double d2, double d3, double d4, double d5) {
        double d6 = -0.5 * d + 1.5 * d2 - 1.5 * d3 + 0.5 * d4;
        double d7 = d - 2.5 * d2 + 2.0 * d3 - 0.5 * d4;
        double d8 = -0.5 * d + 0.5 * d3;
        return ((d6 * d5 + d7) * d5 + d8) * d5 + d2;
    }

    public static double cubicHermiteYaw(float f, float f2, float f3, float f4, float f5) {
        f = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_float(f);
        f2 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_float(f2);
        f3 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_float(f3);
        f4 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_float(f4);
        f2 = Interpolations.normalizeYaw(f, f2);
        f3 = Interpolations.normalizeYaw(f2, f3);
        f4 = Interpolations.normalizeYaw(f3, f4);
        return Interpolations.cubicHermite(f, f2, f3, f4, f5);
    }

    public static float cubic(float f, float f2, float f3, float f4, float f5) {
        float f6 = f4 - f3 - f + f2;
        float f7 = f - f2 - f6;
        float f8 = f3 - f;
        return ((f6 * f5 + f7) * f5 + f8) * f5 + f2;
    }

    public static float cubicYaw(float f, float f2, float f3, float f4, float f5) {
        f = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_float(f);
        f2 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_float(f2);
        f3 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_float(f3);
        f4 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_float(f4);
        f2 = Interpolations.normalizeYaw(f, f2);
        f3 = Interpolations.normalizeYaw(f2, f3);
        f4 = Interpolations.normalizeYaw(f3, f4);
        return Interpolations.cubic(f, f2, f3, f4, f5);
    }

    public static float bezierX(float f, float f2, float f3, float f4) {
        float f5 = f3;
        float f6 = Interpolations.bezier(0.0f, f, f2, 1.0f, f3);
        float f7 = Math.copySign(0.1f, f3 - f6);
        while (Math.abs(f3 - f6) > f4) {
            float f8 = f7;
            f6 = Interpolations.bezier(0.0f, f, f2, 1.0f, f5 += f7);
            if (Math.copySign(f7, f3 - f6) == f8) continue;
            f7 *= -0.25f;
        }
        return f5;
    }

    public static float bezierX(float f, float f2, float f3) {
        return Interpolations.bezierX(f, f2, f3, 5.0E-4f);
    }

    public static float bezier(float f, float f2, float f3, float f4, float f5) {
        float f6 = Interpolations.lerp(f, f2, f5);
        float f7 = Interpolations.lerp(f2, f3, f5);
        float f8 = Interpolations.lerp(f3, f4, f5);
        float f9 = Interpolations.lerp(f6, f7, f5);
        float f10 = Interpolations.lerp(f7, f8, f5);
        return Interpolations.lerp(f9, f10, f5);
    }

    public static float normalizeYaw(float f, float f2) {
        float f3 = f - f2;
        if (f3 > 180.0f || f3 < -180.0f) {
            f3 = Math.copySign(360.0f - Math.abs(f3), f3);
            return f + f3;
        }
        return f2;
    }

    public static double lerp(double d, double d2, double d3) {
        return d + (d2 - d) * d3;
    }

    public static double lerpYaw(double d, double d2, double d3) {
        d = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_double(d);
        d2 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_double(d2);
        return Interpolations.lerp(d, Interpolations.normalizeYaw(d, d2), d3);
    }

    public static double cubic(double d, double d2, double d3, double d4, double d5) {
        double d6 = d4 - d3 - d + d2;
        double d7 = d - d2 - d6;
        double d8 = d3 - d;
        return ((d6 * d5 + d7) * d5 + d8) * d5 + d2;
    }

    public static double cubicYaw(double d, double d2, double d3, double d4, double d5) {
        d = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_double(d);
        d2 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_double(d2);
        d3 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_double(d3);
        d4 = Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$wrapAngleTo180_double(d4);
        d2 = Interpolations.normalizeYaw(d, d2);
        d3 = Interpolations.normalizeYaw(d2, d3);
        d4 = Interpolations.normalizeYaw(d3, d4);
        return Interpolations.cubic(d, d2, d3, d4, d5);
    }

    public static double bezierX(double d, double d2, double d3, double d4) {
        double d5 = d3;
        double d6 = Interpolations.bezier(0.0, d, d2, 1.0, d3);
        double d7 = Math.copySign((double)0.1f, d3 - d6);
        while (Math.abs(d3 - d6) > d4) {
            double d8 = d7;
            d6 = Interpolations.bezier(0.0, d, d2, 1.0, d5 += d7);
            if (Math.copySign(d7, d3 - d6) == d8) continue;
            d7 *= -0.25;
        }
        return d5;
    }

    public static double bezierX(double d, double d2, float f) {
        return Interpolations.bezierX(d, d2, (double)f, (double)5.0E-4f);
    }

    public static double bezier(double d, double d2, double d3, double d4, double d5) {
        double d6 = Interpolations.lerp(d, d2, d5);
        double d7 = Interpolations.lerp(d2, d3, d5);
        double d8 = Interpolations.lerp(d3, d4, d5);
        double d9 = Interpolations.lerp(d6, d7, d5);
        double d10 = Interpolations.lerp(d7, d8, d5);
        return Interpolations.lerp(d9, d10, d5);
    }

    public static double normalizeYaw(double d, double d2) {
        double d3 = d - d2;
        if (d3 > 180.0 || d3 < -180.0) {
            d3 = Math.copySign(360.0 - Math.abs(d3), d3);
            return d + d3;
        }
        return d2;
    }
}

