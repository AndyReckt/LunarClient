package com.moonsworth.lunar.bridge.minecraft.client.particle;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.WorldRendererBridge;

public interface EntityFXBridge {
    default public void bridge$renderParticle(WorldRendererBridge worldRendererBridge, EntityBridge entityBridge, float f, float f2, float f3, float f4, float f5, float f6) {
    }
}
 