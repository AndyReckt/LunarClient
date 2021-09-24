package com.moonsworth.lunar.client.util;

import com.moonsworth.lunar.bridge.minecraft.util.Vector3f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL15;

import java.nio.IntBuffer;

public final class GLBufferUtil {
    public static final float[] lIlIlIlIlIIlIIlIIllIIIIIl = new float[] {0.0F, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F};
    public static final int[] IlllIIIIIIlllIlIIlllIlIIl = new int[] {0, 3, 2, 2, 1, 0};
    public static int lIllIlIIIlIIIIIIIlllIlIll = 0;

    public static void lIlIlIlIlIIlIIlIIllIIIIIl() {
        if (lIllIlIIIlIIIIIIIlllIlIll == 0) {
            lIllIlIIIlIIIIIIIlllIlIll = GL15.glGenBuffers();
            IntBuffer var0 = BufferUtils.createIntBuffer(IlllIIIIIIlllIlIIlllIlIIl.length);
            var0.put(IlllIIIIIIlllIlIIlllIlIIl);
            var0.flip();
            GL15.glBindBuffer(34963, lIllIlIIIlIIIIIIIlllIlIll);
            GL15.glBufferData(34963, var0, 35044);
        }

    }

    public static float lIlIlIlIlIIlIIlIIllIIIIIl(float var0, float var1, float var2) {
        return var0 + var2 * (var1 - var0);
    }

    public static float IlllIIIIIIlllIlIIlllIlIIl(float var0, float var1, float var2) {
        return Math.abs(var1 - var0) < Float.MIN_VALUE ? var0 : (var2 - var0) / (var1 - var0);
    }

    public static float[] lIlIlIlIlIIlIIlIIllIIIIIl(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        float var7 = 1.0F / (float)var2;
        float var8 = 1.0F / (float)var3;
        float var9 = IlllIIIIIIlllIlIIlllIlIIl(0.0F, var7, (float)var0 / (float)var2);
        float var10 = IlllIIIIIIlllIlIIlllIlIIl(0.0F, var7, (float)(var0 + var4) / (float)var2);
        float var11 = IlllIIIIIIlllIlIIlllIlIIl(0.0F, var8, (float)var1 / (float)var3);
        float var12 = IlllIIIIIIlllIlIIlllIlIIl(0.0F, var8, (float)(var1 + var5) / (float)var3);
        return new float[] {lIlIlIlIlIIlIIlIIllIIIIIl(var9, var10, 0.0F) / (float)var2, lIlIlIlIlIIlIIlIIllIIIIIl(var11, var12, 1.0F) / (float)var3, lIlIlIlIlIIlIIlIIllIIIIIl(var9, var10, 1.0F) / (float)var2, lIlIlIlIlIIlIIlIIllIIIIIl(var11, var12, 1.0F) / (float)var3, lIlIlIlIlIIlIIlIIllIIIIIl(var9, var10, 1.0F) / (float)var2, lIlIlIlIlIIlIIlIIllIIIIIl(var11, var12, 0.0F) / (float)var3, lIlIlIlIlIIlIIlIIllIIIIIl(var9, var10, 0.0F) / (float)var2, lIlIlIlIlIIlIIlIIllIIIIIl(var11, var12, 0.0F) / (float)var3};
    }

    public static Vector3f[] lIlIlIlIlIIlIIlIIllIIIIIl(Vector3f var0, Vector3f var1) {
        return new Vector3f[] {new Vector3f(var1.llIIIIIIIllIIllIlIllIIIIl, var0.lIIIllIllIIllIlllIlIIlllI, var1.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var0.llIIIIIIIllIIllIlIllIIIIl, var0.lIIIllIllIIllIlllIlIIlllI, var1.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var0.llIIIIIIIllIIllIlIllIIIIl, var1.lIIIllIllIIllIlllIlIIlllI, var1.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var1.llIIIIIIIllIIllIlIllIIIIl, var1.lIIIllIllIIllIlllIlIIlllI, var1.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var1.llIIIIIIIllIIllIlIllIIIIl, var0.lIIIllIllIIllIlllIlIIlllI, var0.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var0.llIIIIIIIllIIllIlIllIIIIl, var0.lIIIllIllIIllIlllIlIIlllI, var0.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var0.llIIIIIIIllIIllIlIllIIIIl, var0.lIIIllIllIIllIlllIlIIlllI, var1.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var1.llIIIIIIIllIIllIlIllIIIIl, var0.lIIIllIllIIllIlllIlIIlllI, var1.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var1.llIIIIIIIllIIllIlIllIIIIl, var1.lIIIllIllIIllIlllIlIIlllI, var1.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var0.llIIIIIIIllIIllIlIllIIIIl, var1.lIIIllIllIIllIlllIlIIlllI, var1.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var0.llIIIIIIIllIIllIlIllIIIIl, var1.lIIIllIllIIllIlllIlIIlllI, var0.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var1.llIIIIIIIllIIllIlIllIIIIl, var1.lIIIllIllIIllIlllIlIIlllI, var0.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var0.llIIIIIIIllIIllIlIllIIIIl, var0.lIIIllIllIIllIlllIlIIlllI, var1.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var0.llIIIIIIIllIIllIlIllIIIIl, var0.lIIIllIllIIllIlllIlIIlllI, var0.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var0.llIIIIIIIllIIllIlIllIIIIl, var1.lIIIllIllIIllIlllIlIIlllI, var0.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var0.llIIIIIIIllIIllIlIllIIIIl, var1.lIIIllIllIIllIlllIlIIlllI, var1.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var1.llIIIIIIIllIIllIlIllIIIIl, var0.lIIIllIllIIllIlllIlIIlllI, var0.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var1.llIIIIIIIllIIllIlIllIIIIl, var0.lIIIllIllIIllIlllIlIIlllI, var1.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var1.llIIIIIIIllIIllIlIllIIIIl, var1.lIIIllIllIIllIlllIlIIlllI, var1.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var1.llIIIIIIIllIIllIlIllIIIIl, var1.lIIIllIllIIllIlllIlIIlllI, var0.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var0.llIIIIIIIllIIllIlIllIIIIl, var0.lIIIllIllIIllIlllIlIIlllI, var0.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var1.llIIIIIIIllIIllIlIllIIIIl, var0.lIIIllIllIIllIlllIlIIlllI, var0.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var1.llIIIIIIIllIIllIlIllIIIIl, var1.lIIIllIllIIllIlllIlIIlllI, var0.IlllllIlIIIlIIlIIllIIlIll), new Vector3f(var0.llIIIIIIIllIIllIlIllIIIIl, var1.lIIIllIllIIllIlllIlIIlllI, var0.IlllllIlIIIlIIlIIllIIlIll)};
    }
}