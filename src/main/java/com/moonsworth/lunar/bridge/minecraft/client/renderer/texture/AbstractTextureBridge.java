package com.moonsworth.lunar.bridge.minecraft.client.renderer.texture;

import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerBridge;

import java.io.IOException;

/**
 * @author Decencies
 * @since 10/07/2021 14:27
 */
public interface AbstractTextureBridge extends ITextureObjectBridge {
    public void bridge$loadTexture(IResourceManagerBridge var1) throws IOException;

    public void bridge$setBlurMipmap(boolean var1, boolean var2);

    public void bridge$deleteGlTexture();

    public int bridge$getGlTextureId();
}