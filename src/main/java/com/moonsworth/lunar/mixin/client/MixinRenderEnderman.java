package com.moonsworth.lunar.mixin.client;

import net.minecraft.client.renderer.entity.RenderEnderman;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderEnderman.class)
public abstract class MixinRenderEnderman {
    public MixinRenderEnderman() {
    }

    public void impl$getEntityTexture(CallbackInfoReturnable var1) {
    }
}
