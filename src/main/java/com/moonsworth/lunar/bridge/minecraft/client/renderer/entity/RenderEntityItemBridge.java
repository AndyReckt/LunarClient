package com.moonsworth.lunar.bridge.minecraft.client.renderer.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.item.EntityItemBridge;
import com.moonsworth.lunar.bridge.current.MatrixStackBridge;

public interface RenderEntityItemBridge {
    default public void renderItemSprite(EntityItemBridge entityItemBridge, double d, double d2, double d3, float f) {
    }

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityItemBridge entityItemBridge, MatrixStackBridge matrixStackBridge, double d, double d2, double d3, int n, float f) {
    }
}