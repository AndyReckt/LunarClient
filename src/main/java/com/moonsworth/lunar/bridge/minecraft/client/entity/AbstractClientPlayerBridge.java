package com.moonsworth.lunar.bridge.minecraft.client.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

/**
 * @author Decencies
 * @since 10/07/2021 14:10
 */
public interface AbstractClientPlayerBridge extends EntityPlayerBridge {
    public void bridge$setLocationOfCape(ResourceLocationBridge var1);

    public void bridge$setLocationOfCapeOverride(ResourceLocationBridge var1);

    public String bridge$getSkinType();

    public ResourceLocationBridge bridge$getLocationSkin();
}
