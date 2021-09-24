package com.moonsworth.lunar.mixin.client.resources.data;

import com.moonsworth.lunar.bridge.minecraft.client.resources.data.TextureMetadataSectionBridge;
import net.minecraft.client.resources.data.TextureMetadataSection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(TextureMetadataSection.class)
public abstract class MixinTextureMetadataSectionz implements TextureMetadataSectionBridge {

    @Shadow
    public abstract boolean getTextureBlur();

    @Shadow
    public abstract boolean getTextureClamp();

    public boolean bridge$getTextureBlur() {
        return getTextureBlur();
    }

    public boolean bridge$getTextureClamp() {
        return getTextureClamp();
    }
}