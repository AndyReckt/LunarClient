package com.moonsworth.lunar.bridge.minecraft.client.shader;

import java.util.List;

/**
 * @author Decencies
 * @since 10/07/2021 14:30
 */
public interface ShaderGroupBridge {
    public List<ShaderBridge> bridge$listShaders();

    public String bridge$getShaderGroupName();
}

