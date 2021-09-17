package com.moonsworth.lunar.bridge.minecraft.client.renderer;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.SimpleTextureBridge;

public interface ThreadDownloadImageDataBridge extends SimpleTextureBridge {
    default public void bridge$setImageFound(boolean bl) {
    }
}