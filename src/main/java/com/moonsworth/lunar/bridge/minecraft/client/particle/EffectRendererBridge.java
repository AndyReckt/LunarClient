package com.moonsworth.lunar.bridge.minecraft.client.particle;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ParticleType;

public interface EffectRendererBridge {
    void bridge$emitParticleAtEntity(EntityBridge var1, ParticleType var2);

    void bridge$addEffect(EntityFXBridge var1);
}