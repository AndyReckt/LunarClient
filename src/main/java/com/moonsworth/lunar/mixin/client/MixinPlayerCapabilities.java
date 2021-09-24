package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.PlayerCapabilitiesBridge;
import net.minecraft.entity.player.PlayerCapabilities;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(PlayerCapabilities.class)
public abstract class MixinPlayerCapabilities implements PlayerCapabilitiesBridge {
    @Shadow
    public boolean isFlying;
    @Shadow
    public boolean isCreativeMode;
    @Shadow
    public float flySpeed;
    @Shadow
    public boolean allowFlying;

    public MixinPlayerCapabilities() {
    }

    @Shadow
    public abstract float getWalkSpeed();

    public boolean bridge$isFlying() {
        return isFlying;
    }

    public boolean bridge$isCreativeMode() {
        return isCreativeMode;
    }

    public float bridge$getFlySpeed() {
        return flySpeed;
    }

    public void bridge$setFlySpeed(float var1) {
    }

    public float bridge$getWalkSpeed() {
        return getWalkSpeed();
    }

    public boolean bridge$isAllowFlying() {
        return allowFlying;
    }

    public void bridge$setFlying(boolean var1) {
    }
}