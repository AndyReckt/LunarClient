package com.moonsworth.lunar.mixin.client;

import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.entity.item.EntityItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderEntityItem.class)
public abstract class MixinRenderEntityItemz {
    public MixinRenderEntityItemz() {
    }

    public void onRender(EntityItem var1, double var2, double var4, double var6, float var8, float var9, CallbackInfo var10) {
    }

    public void impl$onRenderScale(EntityItem var1, double var2, double var4, double var6, float var8, float var9, CallbackInfo var10) {
    }
}
