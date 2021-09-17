package com.moonsworth.lunar.bridge.minecraft.client.renderer.texture;

import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerBridge;

import java.io.IOException;

public interface CustomTextureBridge {
    public void bridge$setGlTextureId(int var1);

    public int bridge$getGlTextureId();

    public void bridge$loadTexture(IResourceManagerBridge var1) throws IOException;
}