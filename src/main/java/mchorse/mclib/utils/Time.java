/*
 * Decompiled with CFR 0.150.
 */
package mchorse.mclib.utils;

public class Time {
    public static int toTicks(int n) {
        return (int)Math.floor((float)n / 30.0f * 20.0f);
    }
}

