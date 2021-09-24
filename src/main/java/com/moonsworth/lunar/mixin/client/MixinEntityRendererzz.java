package com.moonsworth.lunar.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EntityRenderer.class)
public abstract class MixinEntityRendererzz {
    public boolean renderingWorldDirections;
    @Shadow
    private Minecraft mc;

    public MixinEntityRendererzz() {
    }

    @Shadow
    protected abstract void orientCamera(float var1);

    public void impl$onTranslateEyeHeight(float var1, float var2, float var3) {
    }

    public void impl$renderWorldDirections(EntityRenderer var1, float var2) {
    }
}
