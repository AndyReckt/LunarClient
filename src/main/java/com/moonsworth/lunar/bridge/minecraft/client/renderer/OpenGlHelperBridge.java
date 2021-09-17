package com.moonsworth.lunar.bridge.minecraft.client.renderer;

public interface OpenGlHelperBridge {
    public boolean bridge$isFramebufferEnabled();

    public void bridge$glBlendFunc(int var1, int var2, int var3, int var4);

    public void bridge$setLightmapTextureCoords(int var1, float var2, float var3);

    public int bridge$lightmapTexUnit();

    public int bridge$defaultTexUnit();

    public float bridge$lastBrightnessX();

    public float bridge$lastBrightnessY();

    public String bridge$getCPU();

    public void bridge$enableLightMap();

    public void bridge$disableLightMap();
}