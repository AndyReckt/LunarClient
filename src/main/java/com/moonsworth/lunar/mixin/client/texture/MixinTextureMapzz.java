package com.moonsworth.lunar.mixin.client.texture;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureMapBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import net.minecraft.client.renderer.texture.Stitcher;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.Map;

@Mixin(TextureMap.class)
public abstract class MixinTextureMapzz extends MixinAbstractTexture implements TextureMapBridge {
    public MixinTextureMapzz() {
    }

    @Shadow
    public abstract ResourceLocation completeResourceLocation(ResourceLocation var1, int var2);

    public void onLoadTextureAtlas(IResourceManager var1, CallbackInfo var2, int var3, Stitcher var4, int var5, int var6, Iterator var7, Map.Entry var8, TextureAtlasSprite var9, ResourceLocation var10, ResourceLocation var11, IResource var12, BufferedImage[] var13) {
    }

    public ResourceLocationBridge bridge$getBlockTextures() {
        return null;
    }

    public ResourceLocationBridge bridge$getItemTextures() {
        return null;
    }

    public ResourceLocation proxy$completeResourceLocation(ResourceLocation var1, int var2) {
        return null;
    }
}