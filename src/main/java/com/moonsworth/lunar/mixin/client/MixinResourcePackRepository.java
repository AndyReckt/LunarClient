package com.moonsworth.lunar.mixin.client;

import net.minecraft.client.resources.ResourcePackRepository;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;

@Mixin(ResourcePackRepository.class)
public abstract class MixinResourcePackRepository {
    @Final
    @Shadow
    private File dirServerResourcepacks;

    public MixinResourcePackRepository() {
    }

    @Inject(method = "deleteOldServerResourcesPacks", at = @At("HEAD"), cancellable = true)
    public void impl$deleteOldServerResourcesPacks(CallbackInfo var1) {
        if (!this.dirServerResourcepacks.exists()) {
            var1.cancel();
        }
    }
}
