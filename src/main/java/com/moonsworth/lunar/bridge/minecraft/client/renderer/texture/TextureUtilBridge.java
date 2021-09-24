package com.moonsworth.lunar.bridge.minecraft.client.renderer.texture;

import java.awt.image.BufferedImage;

public interface TextureUtilBridge {
    int bridge$glGenTextures();

    void bridge$uploadTextureImage(int var1, BufferedImage var2);

    void bridge$deleteTexture(int var1);
}
