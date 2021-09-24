package com.moonsworth.lunar.bridge.lunar;

import com.moonsworth.lunar.bridge.minecraft.client.particle.EntityFXBridge;
import com.moonsworth.lunar.bridge.lunar.emote.SaltParticle;
import com.moonsworth.lunar.bridge.lunar.emote.PopcornParticle;
import com.moonsworth.lunar.bridge.minecraft.world.WorldBridge;

public interface CosmeticBridge {
    SkeletalWings initSkeletalWings();

    SaltParticle initSalt();

    PopcornParticle popKernel(int var1, int var2);

    EntityFXBridge initSaltParticle(WorldBridge var1, double var2, double var4, double var6, double var8);

    EntityFXBridge initPopcornParticle(WorldBridge var1, double var2, double var4, double var6, double var8);
}