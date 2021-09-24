package com.moonsworth.lunar.bridge.minecraft.entity.boss;

public interface BossStatusBridge {
    float bridge$getHealthScale();

    void bridge$setHealthScale(float var1);

    String bridge$getBossName();

    void bridge$setBossName(String var1);

    int bridge$getStatusBarTime();

    void bridge$setStatusBarTime(int var1);

    boolean bridge$hasColorModifier();

    void bridge$setHasColorModifier(boolean var1);

    void bridge$drawBar(float var1, float var2);
}