package com.moonsworth.lunar.bridge.minecraft.client.resources.model;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.block.model.ItemCameraTransformsBridge;

/**
 * @author Decencies
 * @since 10/07/2021 14:37
 */
public interface IBakedModelBridge {
    public boolean bridge$isGui3D();

    public ItemCameraTransformsBridge bridge$getItemCameraTransforms();
}
