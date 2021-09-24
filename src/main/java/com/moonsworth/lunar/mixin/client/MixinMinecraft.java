package com.moonsworth.lunar.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.resources.IReloadableResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {
    @Shadow
    public IReloadableResourceManager mcResourceManager;
    @Shadow
    public PlayerControllerMP playerController;

    public MixinMinecraft() {
    }

    public void impl$refreshResources(CallbackInfo var1) {
    }

    public void impl$rightClickMouse(CallbackInfo var1) {
    }

    public void impl$runTick(CallbackInfo var1) {
    }
}