package com.moonsworth.lunar.bridge.lunar;

import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.FontRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.lIlIIIIIIlIIIllllIllIIlII;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.lIlIlIlIlIIlIIlIIllIIIIIl;
import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.List;
import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 16:11
 */
public interface RenderUtilBridge {
    void bridge$circleHollow(double var1, double var3, double var5, double var7, double var9, int var11, double var12, int var14);

    void bridge$drawRect(float var1, float var2, float var3, float var4, int var5);

    void bridge$drawRectColor(float var1, float var2, float var3, float var4, int[] var5);

    void bridge$drawRoundedRectColor(float var1, float var2, float var3, float var4, float var5, int[] var6);

    void bridge$drawGradientRect(int var1, int var2, int var3, int var4, int var5, int var6, float var7);

    void bridge$drawRectGui(float var1, float var2, float var3, float var4, int var5);

    void bridge$drawCircle(double var1, double var3, double var5, int var7);

    void bridge$drawTriangle(float var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8);

    void bridge$drawCircleSegment(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8);

default void lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        this.bridge$drawCircleSegment((float)d, (float)d2, (float)d3, (float)d4, (float)d5, (float)d6, (float)d7, (float)d8);
    }

    void bridge$renderSkybox(int var1, int var2, int var3, float var4);

    void bridge$rotateAndBlurSkyBox(int var1, int var2);

    void bridge$mainMenuPanorama(int var1, float var2);

default void bridge$highlightBlock(double d, double d2, double d3, double d4, double d5, double d6, int n) {
    }

default void bridge$highlightRegion(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, int n) {
    }

default void bridge$drawCircleHollow(double d, double d2, double d3, double d4, double d5, int n, double d6) {
    }

default void lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2, double d3, int n) {
    }

default void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
    }

default void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, MatrixStackBridge matrixStackBridge) {
    }

default Optional lIlIlIlIlIIlIIlIIllIIIIIl(lIlIIIIIIlIIIllllIllIIlII lIlIIIIIIlIIIllllIllIIlII2) {
        return Optional.empty();
    }

default Optional lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge, boolean bl, boolean bl2) {
        return Optional.empty();
    }

    void bridge$enableStandardItemLighting();

    void bridge$enableGUIStandardItemLighting();

    void bridge$disableStandardItemLighting();

    void bridge$texturedModalRect(float var1, float var2, int var3, int var4, int var5, int var6);

    void bridge$project(float var1, float var2, float var3, FloatBuffer var4, FloatBuffer var5, IntBuffer var6, FloatBuffer var7);

    void bridge$drawEntityOnScreen(float var1, float var2, float var3, float var4, float var5, float var6, EntityLivingBaseBridge var7);

    void bridge$drawNameplates(FontRendererBridge var1, List var2, double var3, double var5, double var7, float var9, boolean var10, boolean var11, EntityBridge var12);

    void bridge$drawNameplate(FontRendererBridge var1, String var2, double var3, double var5, double var7, float var9, boolean var10, boolean var11, EntityBridge var12);

default void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, List list, MatrixStackBridge matrixStackBridge, lIlIlIlIlIIlIIlIIllIIIIIl lIlIlIlIlIIlIIlIIllIIIIIl2, int n) {
    }

    void bridge$drawModalRectWithCustomSizedTexture(int var1, int var2, float var3, float var4, int var5, int var6, float var7, float var8);

default void bridge$turnOnLighting() {
    }
}
