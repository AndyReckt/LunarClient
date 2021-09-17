package com.moonsworth.lunar.bridge.optifine;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 17:32
 */
public interface OptifineBridge {
    public ConfigBridge getConfig();

    public ShadersBridge getShaders();

    public Optional getCustomItems();

    default public Optional getCustomColors() {
        return Optional.empty();
    }

    default public int getBossTextColor(int n) {
        return n;
    }

    default public Optional initAsyncTexture(ResourceLocationBridge resourceLocationBridge) {
        return Optional.empty();
    }
}
