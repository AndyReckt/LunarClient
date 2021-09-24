package com.moonsworth.lunar.mixin.client.texture;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureAtlasSpriteBridge;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(TextureAtlasSprite.class)
public abstract class MixinTextureAtlasSprite implements TextureAtlasSpriteBridge {
    public MixinTextureAtlasSprite() {
    }
}
