package com.moonsworth.lunar.bridge.minecraft.client.renderer;

import com.moonsworth.lunar.bridge.minecraft.util.Matrix4fBridge;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public interface GlStateManagerBridge {
    public void bridge$pushMatrix();

    public void bridge$popMatrix();

    public void bridge$scale(double var1, double var3, double var5);

    public void bridge$bindTexture(int var1);

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        int n2 = n >> 24 & 0xFF;
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        this.bridge$color(n3, n4, n5, n2);
    }

    public void bridge$color(float var1, float var2, float var3, float var4);

    public void bridge$color(float var1, float var2, float var3);

    public void bridge$enableBlend();

    public void bridge$enableTexture2D();

    public void bridge$disableBlend();

    public void bridge$disableTexture2D();

    public void bridge$blendFunc(int var1, int var2);

    public void bridge$disableAlpha();

    public void bridge$alphaFunc(int var1, float var2);

    public void bridge$tryBlendFuncSeparate(int var1, int var2, int var3, int var4);

    public void bridge$shadeModel(int var1);

    public void bridge$enableAlpha();

    public void bridge$translate(float var1, float var2, float var3);

    public void bridge$rotate(float var1, float var2, float var3, float var4);

    public void bridge$depthMask(boolean var1);

    public void bridge$depthFunc(int var1);

    public void bridge$disableLighting();

    public void bridge$enableLighting();

    public void bridge$matrixMode(int var1);

    public void bridge$disableDepth();

    public void bridge$enableDepth();

    public void bridge$enableRescaleNormal();

    public void bridge$disableRescaleNormal();

    public void bridge$enableCull();

    public void bridge$disableCull();

    public void bridge$getFloat(int var1, FloatBuffer var2);

    public void bridge$glGetInteger(int var1, IntBuffer var2);

    public void bridge$callList(int var1);

    public void bridge$deleteLists(int var1, int var2);

    public void bridge$enableColorMaterial();

    public void bridge$setActiveTexture(int var1);

    public void bridge$enablePolygonOffset();

    public void bridge$doPolygonOffset(float var1, float var2);

    public void bridge$disablePolygonOffset();

    public void bridge$multMatrix(FloatBuffer var1);

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(Matrix4fBridge matrix4fBridge) {
        throw new UnsupportedOperationException("Unsupport multMatrix on legacy!");
    }

    public void bridge$glLineWidth(float var1);
}