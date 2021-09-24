package com.moonsworth.lunar.bridge.minecraft.client.entity.player;

public interface PlayerCapabilitiesBridge {
    boolean bridge$isFlying();

    void bridge$setFlying(boolean var1);

    boolean bridge$isCreativeMode();

    float bridge$getFlySpeed();

    void bridge$setFlySpeed(float var1);

    float bridge$getWalkSpeed();

    boolean bridge$isAllowFlying();
}
