package com.moonsworth.lunar.bridge.minecraft.client.renderer.texture;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

public interface TextureMapBridge extends AbstractTextureBridge {
    ResourceLocationBridge bridge$getBlockTextures();

    ResourceLocationBridge bridge$getItemTextures();
}
