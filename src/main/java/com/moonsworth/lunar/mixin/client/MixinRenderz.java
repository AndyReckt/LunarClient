package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Render.class)
public abstract class MixinRenderz {
    public MixinRenderz() {
    }

    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    public void impl$shouldRender(Entity var1, ICamera var2, double var3, double var5, double var7, CallbackInfoReturnable<Boolean> var9) {
        if (!LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().lIlIlIlIlIIlIIlIIllIIIIIl((EntityBridge) var1)) {
            var9.setReturnValue(false);
        }

        if (var1 instanceof EntityArrow && ((EntityArrow) var1).inGround) {
            BooleanSetting var10 = Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().lllllIllIllIllllIlIllllII();
            if (!(Boolean) var10.llIlllIIIllllIIlllIllIIIl()) {
                var9.setReturnValue(false);
            }
        }
    }

    @Redirect(
        method = "doRenderShadowAndFire",
        at =
            @At(
                value = "INVOKE",
                target = "Lnet/minecraft/client/renderer/entity/Render;renderShadow(Lnet/minecraft/entity/Entity;DDDFF)V"
            )
    )
    public void impl$doRenderShadowAndFire(Render var1, Entity var2, double var3, double var5, double var7, float var9, float var10) {
        if (LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().IllllllllllIlIIIlllIlllll().llIlllIIIllllIIlllIllIIIl()) {
            var1.renderShadow(var2, var3, var5, var7, var9, var10);
        }
    }
}
