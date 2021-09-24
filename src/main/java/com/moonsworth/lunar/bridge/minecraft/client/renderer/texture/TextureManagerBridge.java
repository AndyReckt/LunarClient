package com.moonsworth.lunar.bridge.minecraft.client.renderer.texture;

import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerReloadListenerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.util.Map;

/**
 * @author Decencies
 * @since 10/07/2021 14:25
 */
public interface TextureManagerBridge extends IResourceManagerReloadListenerBridge {
    boolean bridge$loadTexture(ResourceLocationBridge var1, AbstractTextureBridge var2);

    void bridge$bindTexture(ResourceLocationBridge var1);

    void bridge$deleteTexture(ResourceLocationBridge var1);

    AbstractTextureBridge bridge$getTexture(ResourceLocationBridge var1);

    ResourceLocationBridge bridge$getDynamicTextureLocation(String var1, DynamicTextureBridge var2);

    void bridge$loadTickableTexture(ResourceLocationBridge var1, AbstractTextureBridge var2);

    Map<ResourceLocationBridge, Object> bridge$getTextureMap();
}