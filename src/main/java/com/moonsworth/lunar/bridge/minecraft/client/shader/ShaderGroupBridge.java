package com.moonsworth.lunar.bridge.minecraft.client.shader;

import java.util.List;

/**
 * @author Decencies
 * @since 10/07/2021 14:30
 */
public interface ShaderGroupBridge {
    List<ShaderBridge> bridge$listShaders();

    String bridge$getShaderGroupName();
}

