package com.moonsworth.lunar.bridge.minecraft.client.renderer.texture;

import java.awt.image.BufferedImage;

public interface TextureUtilBridge {
    public int bridge$glGenTextures();

    public void bridge$uploadTextureImage(int var1, BufferedImage var2);

    public void bridge$deleteTexture(int var1);
}
 