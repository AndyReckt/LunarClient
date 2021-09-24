package com.moonsworth.lunar.bridge.minecraft.client.renderer;

import com.moonsworth.lunar.bridge.current.b.Matrix4fBridge;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public interface GlStateManagerBridge {
    void bridge$pushMatrix();

    void bridge$popMatrix();

    void bridge$scale(double var1, double var3, double var5);

    void bridge$bindTexture(int var1);

default void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        int n2 = n >> 24 & 0xFF;
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        this.bridge$color(n3, n4, n5, n2);
    }

    void bridge$color(float var1, float var2, float var3, float var4);

    void bridge$color(float var1, float var2, float var3);

    void bridge$enableBlend();

    void bridge$enableTexture2D();

    void bridge$disableBlend();

    void bridge$disableTexture2D();

    void bridge$blendFunc(int var1, int var2);

    void bridge$disableAlpha();

    void bridge$alphaFunc(int var1, float var2);

    void bridge$tryBlendFuncSeparate(int var1, int var2, int var3, int var4);

    void bridge$shadeModel(int var1);

    void bridge$enableAlpha();

    void bridge$translate(float var1, float var2, float var3);

    void bridge$rotate(float var1, float var2, float var3, float var4);

    void bridge$depthMask(boolean var1);

    void bridge$depthFunc(int var1);

    void bridge$disableLighting();

    void bridge$enableLighting();

    void bridge$matrixMode(int var1);

    void bridge$disableDepth();

    void bridge$enableDepth();

    void bridge$enableRescaleNormal();

    void bridge$disableRescaleNormal();

    void bridge$enableCull();

    void bridge$disableCull();

    void bridge$getFloat(int var1, FloatBuffer var2);

    void bridge$glGetInteger(int var1, IntBuffer var2);

    void bridge$callList(int var1);

    void bridge$deleteLists(int var1, int var2);

    void bridge$enableColorMaterial();

    void bridge$setActiveTexture(int var1);

    void bridge$enablePolygonOffset();

    void bridge$doPolygonOffset(float var1, float var2);

    void bridge$disablePolygonOffset();

    void bridge$multMatrix(FloatBuffer var1);

default void lIlIlIlIlIIlIIlIIllIIIIIl(Matrix4fBridge matrix4fBridge) {
        throw new UnsupportedOperationException("Unsupport multMatrix on legacy!");
    }

    void bridge$glLineWidth(float var1);
}