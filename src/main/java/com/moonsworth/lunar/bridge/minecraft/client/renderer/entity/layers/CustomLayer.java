package com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.current.lIllIlIIIlIIIIIIIlllIlIll;
import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.util.Optional;

public interface CustomLayer {
    default public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityLivingBaseBridge entityLivingBaseBridge, ModelPlayerBridge modelPlayerBridge, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
    }

    default public Optional lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, int n) {
        return Optional.empty();
    }

    default public int lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge) {
        return 1;
    }

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityLivingBaseBridge entityLivingBaseBridge, lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2, MatrixStackBridge matrixStackBridge, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
    }

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityLivingBaseBridge entityLivingBaseBridge, ModelPlayerBridge modelPlayerBridge, int n, int n2, lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2, MatrixStackBridge matrixStackBridge, float f) {
    }

    default public Optional lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge) {
        return Optional.empty();
    }
}