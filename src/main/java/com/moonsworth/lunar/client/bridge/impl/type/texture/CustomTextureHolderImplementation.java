package com.moonsworth.lunar.client.bridge.impl.type.texture;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.CustomTextureBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.CustomTextureHolder;
import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerBridge;
import lombok.SneakyThrows;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.resources.IResourceManager;

public class CustomTextureHolderImplementation extends AbstractTexture implements CustomTextureHolder {
    public CustomTextureBridge customTexture;

    public CustomTextureHolderImplementation(CustomTextureBridge var1) {
        this.customTexture = var1;
    }

    @SneakyThrows // todo bridge$loadTexture()
    public void bridge$loadTexture(IResourceManagerBridge var1) {
        if (!LunarClient.getInstance().IIlIllIlIIllIIlIlIllllllI().lllIIIIIlllIIlIllIIlIIIlI()) {
            this.customTexture.bridge$setGlTextureId(this.getGlTextureId());
            this.customTexture.bridge$loadTexture(var1);
        }
    }

    public void bridge$setBlurMipmap(boolean var1, boolean var2) {
        this.setBlurMipmap(var1, var2);
    }

    public void bridge$deleteGlTexture() {
        this.deleteGlTexture();
    }

    public int bridge$getGlTextureId() {
        int var1 = this.getGlTextureId();
        this.customTexture.bridge$setGlTextureId(var1);
        return var1;
    }

    public void loadTexture(IResourceManager var1) {
        this.bridge$loadTexture((IResourceManagerBridge)var1);
    }

    public CustomTextureBridge getCustomTexture() {
        return this.customTexture;
    }
}