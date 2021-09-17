package com.moonsworth.lunar.bridge.lunar;

import com.moonsworth.lunar.bridge.minecraft.client.particle.EntityFXBridge;
import com.moonsworth.lunar.bridge.lunar.emote.SaltParticle;
import com.moonsworth.lunar.bridge.lunar.emote.PopcornParticle;
import com.moonsworth.lunar.bridge.minecraft.world.WorldBridge;

public interface CosmeticBridge {
    public SkeletalWings initSkeletalWings();

    public SaltParticle initSalt();

    public PopcornParticle popKernel(int var1, int var2);

    public EntityFXBridge initSaltParticle(WorldBridge var1, double var2, double var4, double var6, double var8);

    public EntityFXBridge initPopcornParticle(WorldBridge var1, double var2, double var4, double var6, double var8);
}