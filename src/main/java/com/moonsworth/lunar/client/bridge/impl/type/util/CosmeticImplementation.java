package com.moonsworth.lunar.client.bridge.impl.type.util;

import com.moonsworth.lunar.bridge.lunar.CosmeticBridge;
import com.moonsworth.lunar.bridge.lunar.SkeletalWings;
import com.moonsworth.lunar.bridge.lunar.emote.PopcornParticle;
import com.moonsworth.lunar.bridge.lunar.emote.SaltParticle;
import com.moonsworth.lunar.bridge.minecraft.client.particle.EntityFXBridge;
import com.moonsworth.lunar.bridge.minecraft.world.WorldBridge;
import com.moonsworth.lunar.client.bridge.impl.type.model.ModelPopcornParticleImplementation;
import com.moonsworth.lunar.client.bridge.impl.type.model.ModelSaltParticleImplementation;
import net.minecraft.world.World;

public class CosmeticImplementation implements CosmeticBridge {
    public final ModelWingsImplementation modelWingsImplementation = new ModelWingsImplementation();
    public final ModelSaltParticleImplementation modelSaltParticle = new ModelSaltParticleImplementation();

    public SkeletalWings initSkeletalWings() {
        return this.modelWingsImplementation;
    }

    public SaltParticle initSalt() {
        return this.modelSaltParticle;
    }

    public PopcornParticle popKernel(int var1, int var2) {
        return new ModelPopcornParticleImplementation(var1, var2);
    }

    public EntityFXBridge initSaltParticle(WorldBridge var1, double var2, double var4, double var6, double var8) {
        return new com.moonsworth.lunar.client.bridge.impl.type.particle.SaltParticle((World)var1, var2, var4, var6, var8);
    }

    public EntityFXBridge initPopcornParticle(WorldBridge var1, double var2, double var4, double var6, double var8) {
        return new com.moonsworth.lunar.client.bridge.impl.type.particle.PopcornParticle((World)var1, var2, var4, var6, var8);
    }
}