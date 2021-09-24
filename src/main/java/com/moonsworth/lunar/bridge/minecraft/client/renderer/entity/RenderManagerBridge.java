package com.moonsworth.lunar.bridge.minecraft.client.renderer.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.settings.GameSettingsBridge;
import com.moonsworth.lunar.bridge.minecraft.world.WorldBridge;

import java.util.Map;

public interface RenderManagerBridge {
    double getRenderPosX();

    double getRenderPosY();

    double getRenderPosZ();

    double getPlayerViewX();

    double getPlayerViewY();

    double bridge$viewerPosX();

    double bridge$viewerPosY();

    double bridge$viewerPosZ();

    RenderPlayerBridge bridge$defaultPlayerRenderer();

    Map bridge$getSkinMap();

    void bridge$setTextureManager(TextureManagerBridge var1);

    void bridge$setLivingEntity(EntityLivingBaseBridge var1);

    void bridge$setOptions(GameSettingsBridge var1);

    void bridge$setRenderShadow(boolean var1);

    void bridge$setPlayerViewY(float var1);

    void bridge$renderEntityWithPosYaw(EntityBridge var1, double var2, double var4, double var6, float var8, float var9);

    void bridge$setDebugBoundingBox(boolean var1);

    boolean bridge$showDebugBoundingBox();

    void bridge$prepare(WorldBridge var1, EntityBridge var2);
}