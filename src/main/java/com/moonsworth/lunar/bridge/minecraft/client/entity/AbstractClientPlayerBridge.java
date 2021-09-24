package com.moonsworth.lunar.bridge.minecraft.client.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

/**
 * @author Decencies
 * @since 10/07/2021 14:10
 */
public interface AbstractClientPlayerBridge extends EntityPlayerBridge {
    void bridge$setLocationOfCape(ResourceLocationBridge var1);

    void bridge$setLocationOfCapeOverride(ResourceLocationBridge var1);

    String bridge$getSkinType();

    ResourceLocationBridge bridge$getLocationSkin();
}
