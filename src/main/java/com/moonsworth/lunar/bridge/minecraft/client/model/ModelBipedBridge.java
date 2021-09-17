package com.moonsworth.lunar.bridge.minecraft.client.model;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;

public interface ModelBipedBridge extends ModelBaseBridge {
    public ModelRendererBridge bridge$bipedHead();

    public ModelRendererBridge bridge$bipedHeadwear();

    public ModelRendererBridge bridge$bipedBody();

    public ModelRendererBridge bridge$bipedRightArm();

    public ModelRendererBridge bridge$bipedLeftArm();

    public ModelRendererBridge bridge$bipedRightLeg();

    public ModelRendererBridge bridge$bipedLeftLeg();

    public void bridge$setSneak(boolean var1);

    public void bridge$setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, EntityLivingBaseBridge var7);
}