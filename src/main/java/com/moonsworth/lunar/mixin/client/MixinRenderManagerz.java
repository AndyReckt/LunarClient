package com.moonsworth.lunar.mixin.client;

import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderManager.class)
public abstract class MixinRenderManagerz {
    public MixinRenderManagerz() {
    }

    public void impl$shouldRender(Entity var1, ICamera var2, double var3, double var5, double var7, CallbackInfoReturnable var9) {
    }
}
