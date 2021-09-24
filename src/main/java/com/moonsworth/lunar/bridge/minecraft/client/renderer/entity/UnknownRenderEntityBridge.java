package com.moonsworth.lunar.bridge.minecraft.client.renderer.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;

public interface UnknownRenderEntityBridge {
    boolean bridge$canRenderName(EntityLivingBaseBridge var1);

    boolean bridge$setBrightness(EntityLivingBaseBridge var1, float var2);

    void bridge$unsetBrightness();

    void bridge$create();
}