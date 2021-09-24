package com.moonsworth.lunar.client.bridge.impl.type.glstatemanager;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.OpenGlHelperBridge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;

public class OpenGlHelperImplementation implements OpenGlHelperBridge {
    public boolean bridge$isFramebufferEnabled() {
        return OpenGlHelper.isFramebufferEnabled();
    }

    public void bridge$glBlendFunc(int var1, int var2, int var3, int var4) {
        OpenGlHelper.glBlendFunc(var1, var2, var3, var4);
    }

    public void bridge$setLightmapTextureCoords(int var1, float var2, float var3) {
        OpenGlHelper.setLightmapTextureCoords(var1, var2, var3);
    }

    public int bridge$lightmapTexUnit() {
        return OpenGlHelper.lightmapTexUnit;
    }

    public int bridge$defaultTexUnit() {
        return OpenGlHelper.defaultTexUnit;
    }

    public float bridge$lastBrightnessX() {
        return 240.0F;
    }

    public float bridge$lastBrightnessY() {
        return 240.0F;
    }

    public String bridge$getCPU() {
        return OpenGlHelper.getCpu();
    }

    public void bridge$enableLightMap() {
        Minecraft.getMinecraft().entityRenderer.updateTorchFlicker();
    }

    public void bridge$disableLightMap() {
        Minecraft.getMinecraft().entityRenderer.enableLightmap();
    }
}
