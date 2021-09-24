package com.moonsworth.lunar.bridge.minecraft.client.renderer;

public interface OpenGlHelperBridge {
    boolean bridge$isFramebufferEnabled();

    void bridge$glBlendFunc(int var1, int var2, int var3, int var4);

    void bridge$setLightmapTextureCoords(int var1, float var2, float var3);

    int bridge$lightmapTexUnit();

    int bridge$defaultTexUnit();

    float bridge$lastBrightnessX();

    float bridge$lastBrightnessY();

    String bridge$getCPU();

    void bridge$enableLightMap();

    void bridge$disableLightMap();
}