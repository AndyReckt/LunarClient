package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.client.renderer.entity.layers.LayerArrow;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LayerArrow.class)
public class MixinLayerArrow {

    @Inject(method = "doRenderLayer", at = @At("HEAD"), cancellable = true)
    public void impl$onLayerRender(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, CallbackInfo var9) {
        if (!(Boolean) Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().lllIIIIIlllIIlIllIIlIIIlI().llIlllIIIllllIIlllIllIIIl()) {
            var9.cancel();
        }
    }

}
