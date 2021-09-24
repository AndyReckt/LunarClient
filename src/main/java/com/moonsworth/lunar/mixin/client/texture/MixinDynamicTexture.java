package com.moonsworth.lunar.mixin.client.texture;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.DynamicTextureBridge;
import net.minecraft.client.renderer.texture.DynamicTexture;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DynamicTexture.class)
public abstract class MixinDynamicTexture implements DynamicTextureBridge {
    public MixinDynamicTexture() {
    }
}
