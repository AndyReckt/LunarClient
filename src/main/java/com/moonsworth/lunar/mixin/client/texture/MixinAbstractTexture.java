package com.moonsworth.lunar.mixin.client.texture;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.AbstractTextureBridge;
import net.minecraft.client.renderer.texture.AbstractTexture;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractTexture.class)
public abstract class MixinAbstractTexture implements AbstractTextureBridge {
    public MixinAbstractTexture() {
    }
}
