package com.moonsworth.lunar.client.bridge.impl.type.texture;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.CustomTextureBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.CustomTextureHolder;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TickingTexture;
import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerBridge;
import lombok.SneakyThrows;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.ITickableTextureObject;
import net.minecraft.client.resources.IResourceManager;

public class TickingTextureImplementation extends AbstractTexture implements CustomTextureHolder, ITickableTextureObject {
    public final TickingTexture tickingTexture;

    public TickingTextureImplementation(TickingTexture var1) {
        this.tickingTexture = var1;
    }

    public void tick() {
        this.tickingTexture.bridge$tick();
    }

    public void loadTexture(IResourceManager var1) {
        this.bridge$loadTexture((IResourceManagerBridge)var1);
    }

    @SneakyThrows // todo bridge$loadTexture()
    public void bridge$loadTexture(IResourceManagerBridge var1) {
        if (!LunarClient.getInstance().IIlIllIlIIllIIlIlIllllllI().lllIIIIIlllIIlIllIIlIIIlI()) {
            this.tickingTexture.bridge$setGlTextureId(this.getGlTextureId());
            this.tickingTexture.bridge$loadTexture(var1);
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
        this.tickingTexture.bridge$setGlTextureId(var1);
        return var1;
    }

    public CustomTextureBridge getCustomTexture() {
        return this.tickingTexture;
    }
}