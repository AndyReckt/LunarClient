package com.moonsworth.lunar.client.bridge.impl.type.texture;

import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.texture.AbstractUploadableTickingTexture;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import org.lwjgl.opengl.GL11;

public class UploadableTextureImplementation extends AbstractUploadableTickingTexture implements ITextureObject {
    public UploadableTextureImplementation(ResourceLocationBridge var1) {
        super(var1);
    }

    public void uploadTexture() {
        TextureUtil.allocateTextureImpl(this.glTextureId, 0, this.textureWidth, this.textureHeight);
        GlStateManager.shadeModel(this.glTextureId);
        int var1 = this.textureWidth;
        int var2 = this.textureHeight;
        int var3 = 4194304 / var1;
        TextureUtil.setTextureClamped(this.blur);
        TextureUtil.setTextureBlurred(this.clamp);
        this.dataMap.forEach((var3x, var4) -> {
            int var5 = var3x / var1;
            int var6 = Math.min(var3, var2 - var5);
            int var7 = var1 * var6;
            dataBuffer.clear();
            dataBuffer.put(var4, 0, var7);
            dataBuffer.position(0).limit(var7);
            GL11.glTexSubImage2D(3553, 0, 0, var5, var1, var6, 32993, 33639, dataBuffer);
        });
    }

    public void loadTexture(IResourceManager var1) {
        this.bridge$loadTexture((IResourceManagerBridge)var1);
    }

    public int getGlTextureId() {
        return this.bridge$getGlTextureId();
    }

    public void setBlurMipmap(boolean var1, boolean var2) {
    }

    public void restoreLastBlurMipmap() {
    }
}