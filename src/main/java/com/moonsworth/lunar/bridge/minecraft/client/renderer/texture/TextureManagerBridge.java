package com.moonsworth.lunar.bridge.minecraft.client.renderer.texture;

import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerReloadListenerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.util.Map;

/**
 * @author Decencies
 * @since 10/07/2021 14:25
 */
public interface TextureManagerBridge extends IResourceManagerReloadListenerBridge {
    public boolean bridge$loadTexture(ResourceLocationBridge var1, AbstractTextureBridge var2);

    public void bridge$bindTexture(ResourceLocationBridge var1);

    public void bridge$deleteTexture(ResourceLocationBridge var1);

    public AbstractTextureBridge bridge$getTexture(ResourceLocationBridge var1);

    public ResourceLocationBridge bridge$getDynamicTextureLocation(String var1, DynamicTextureBridge var2);

    public void bridge$loadTickableTexture(ResourceLocationBridge var1, AbstractTextureBridge var2);

    public Map bridge$getTextureMap();
}