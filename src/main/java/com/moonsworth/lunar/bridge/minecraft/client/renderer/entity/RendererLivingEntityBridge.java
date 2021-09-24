package com.moonsworth.lunar.bridge.minecraft.client.renderer.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.FontRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers.CustomLayer;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers.LayerCapeBridge;

import java.util.List;

public interface RendererLivingEntityBridge {
default void lIlIlIlIlIIlIIlIIllIIIIIl(CustomLayer customLayer) {
        this.bridge$addLayer(customLayer, false);
    }

    void bridge$addLayer(CustomLayer var1, boolean var2);

    LayerCapeBridge bridge$getLayerCape();

    void lIlIlIlIlIIlIIlIIllIIIIIl(FontRendererBridge var1, List var2, double var3, double var5, double var7, float var9, boolean var10, boolean var11, EntityBridge var12);
}
