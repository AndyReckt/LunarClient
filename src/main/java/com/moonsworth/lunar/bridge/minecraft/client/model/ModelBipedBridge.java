package com.moonsworth.lunar.bridge.minecraft.client.model;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;

public interface ModelBipedBridge extends ModelBaseBridge {
    ModelRendererBridge bridge$bipedHead();

    ModelRendererBridge bridge$bipedHeadwear();

    ModelRendererBridge bridge$bipedBody();

    ModelRendererBridge bridge$bipedRightArm();

    ModelRendererBridge bridge$bipedLeftArm();

    ModelRendererBridge bridge$bipedRightLeg();

    ModelRendererBridge bridge$bipedLeftLeg();

    void bridge$setSneak(boolean var1);

    void bridge$setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, EntityLivingBaseBridge var7);
}