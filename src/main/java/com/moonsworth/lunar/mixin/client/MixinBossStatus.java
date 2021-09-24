package com.moonsworth.lunar.mixin.client;

import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BossStatus.class)
public abstract class MixinBossStatus {

    @Shadow
    public static int statusBarTime;

    @Inject(method = "setBossStatus", at = @At("HEAD"), cancellable = true)
    private static void impl$setBossStatus(IBossDisplayData var0, boolean var1, CallbackInfo var2) {
        if (statusBarTime == -1) {
            var2.cancel();
        }
    }
}
