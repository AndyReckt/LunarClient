package com.moonsworth.lunar.bridge.minecraft.client.renderer.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;

public interface UnknownRenderEntityBridge {
    public boolean bridge$canRenderName(EntityLivingBaseBridge var1);

    public boolean bridge$setBrightness(EntityLivingBaseBridge var1, float var2);

    public void bridge$unsetBrightness();

    public void bridge$create();
}