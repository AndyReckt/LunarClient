package com.moonsworth.lunar.bridge.minecraft.client.renderer.texture;

import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerBridge;

import java.io.IOException;

public interface CustomTextureBridge {
    void bridge$setGlTextureId(int var1);

    int bridge$getGlTextureId();

    void bridge$loadTexture(IResourceManagerBridge var1) throws IOException;
}