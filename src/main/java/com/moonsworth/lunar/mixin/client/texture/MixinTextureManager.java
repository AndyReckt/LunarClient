package com.moonsworth.lunar.mixin.client.texture;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.AbstractTextureBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.DynamicTextureBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.ITickableTextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(TextureManager.class)
public abstract class MixinTextureManager implements TextureManagerBridge {
    @Shadow
    public Map mapTextureCounters;
    @Shadow
    public Map mapTextureObjects;

    public MixinTextureManager() {
    }

    @Shadow
    public abstract boolean loadTexture(ResourceLocation var1, ITextureObject var2);

    @Shadow
    public abstract void bindTexture(ResourceLocation var1);

    @Shadow
    public abstract ResourceLocation getDynamicTextureLocation(String var1, DynamicTexture var2);

    @Shadow
    public abstract ITextureObject getTexture(ResourceLocation var1);

    @Shadow
    public abstract boolean loadTickableTexture(ResourceLocation var1, ITickableTextureObject var2);

    @Shadow
    public abstract void deleteTexture(ResourceLocation var1);

    public boolean bridge$loadTexture(ResourceLocationBridge var1, AbstractTextureBridge var2) {
        return loadTexture((ResourceLocation) var1, (ITextureObject) var2);
    }

    public void bridge$bindTexture(ResourceLocationBridge var1) {
        bindTexture((ResourceLocation) var1);
    }

    public void bridge$deleteTexture(ResourceLocationBridge var1) {
        deleteTexture((ResourceLocation) var1);
    }

    public AbstractTextureBridge bridge$getTexture(ResourceLocationBridge var1) {
        return (AbstractTextureBridge) getTexture((ResourceLocation) var1);
    }

    public ResourceLocationBridge bridge$getDynamicTextureLocation(String var1, DynamicTextureBridge var2) {
        return (ResourceLocationBridge) getDynamicTextureLocation(var1, (DynamicTexture) var2);
    }

    public void bridge$loadTickableTexture(ResourceLocationBridge var1, AbstractTextureBridge var2) {
        loadTickableTexture((ResourceLocation) var1, (ITickableTextureObject) var2);
    }

    public Map bridge$getTextureMap() {
        return mapTextureObjects;
    }
}