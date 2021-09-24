package com.moonsworth.lunar.client.bridge.impl.type.texture;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureUtilBridge;
import net.minecraft.client.renderer.texture.TextureUtil;

import java.awt.image.BufferedImage;

public class TextureUtilImplementation implements TextureUtilBridge {
    public int bridge$glGenTextures() {
        return TextureUtil.glGenTextures();
    }

    public void bridge$uploadTextureImage(int var1, BufferedImage var2) {
        TextureUtil.uploadTextureImage(var1, var2);
    }

    public void bridge$deleteTexture(int var1) {
        TextureUtil.deleteTexture(var1);
    }
}
