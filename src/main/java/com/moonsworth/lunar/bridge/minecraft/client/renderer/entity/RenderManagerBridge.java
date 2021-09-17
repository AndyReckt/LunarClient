package com.moonsworth.lunar.bridge.minecraft.client.renderer.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.settings.GameSettingsBridge;
import com.moonsworth.lunar.bridge.minecraft.world.WorldBridge;

import java.util.Map;

public interface RenderManagerBridge {
    public double getRenderPosX();

    public double getRenderPosY();

    public double getRenderPosZ();

    public double getPlayerViewX();

    public double getPlayerViewY();

    public double bridge$viewerPosX();

    public double bridge$viewerPosY();

    public double bridge$viewerPosZ();

    public RenderPlayerBridge bridge$defaultPlayerRenderer();

    public Map bridge$getSkinMap();

    public void bridge$setTextureManager(TextureManagerBridge var1);

    public void bridge$setLivingEntity(EntityLivingBaseBridge var1);

    public void bridge$setOptions(GameSettingsBridge var1);

    public void bridge$setRenderShadow(boolean var1);

    public void bridge$setPlayerViewY(float var1);

    public void bridge$renderEntityWithPosYaw(EntityBridge var1, double var2, double var4, double var6, float var8, float var9);

    public void bridge$setDebugBoundingBox(boolean var1);

    public boolean bridge$showDebugBoundingBox();

    public void bridge$prepare(WorldBridge var1, EntityBridge var2);
}