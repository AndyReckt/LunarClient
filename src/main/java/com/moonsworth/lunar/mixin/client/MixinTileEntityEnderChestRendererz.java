package com.moonsworth.lunar.mixin.client;

import net.minecraft.client.renderer.tileentity.TileEntityEnderChestRenderer;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TileEntityEnderChestRenderer.class)
public abstract class MixinTileEntityEnderChestRendererz {
    @Final
    @Shadow
    private static ResourceLocation ENDER_CHEST_TEXTURE;

    public MixinTileEntityEnderChestRendererz() {
    }

    public void impl$bindTexture(TileEntityEnderChestRenderer var1, ResourceLocation var2) {
//        if (var2 == ENDER_CHEST_TEXTURE) {
//            TileEntityEnderChestRendererHook.bindTexture(var1, var2);
//        } else {
//            var1.bindTexture(var2);
//        }
    }

    public void impl$renderAll(CallbackInfo var1) {
    }
}
