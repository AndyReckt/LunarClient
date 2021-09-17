package com.moonsworth.lunar.bridge.minecraft.client.renderer;

import com.moonsworth.lunar.bridge.minecraft.client.shader.ShaderGroupBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.io.IOException;

/**
 * @author Decencies
 * @since 10/07/2021 14:29
 */
public interface EntityRendererBridge {
    public void bridge$loadShader(ResourceLocationBridge var1) throws IOException;

    public boolean bridge$isShaderActive();

    public ShaderGroupBridge bridge$getShaderGroup();

    public void bridge$stopUseShader();
}
