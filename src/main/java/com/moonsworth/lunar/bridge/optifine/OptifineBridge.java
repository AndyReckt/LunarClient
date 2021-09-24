package com.moonsworth.lunar.bridge.optifine;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.util.List;
import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 17:32
 */
public interface OptifineBridge {
    ConfigBridge getConfig();

    ShadersBridge getShaders();

    Optional<CustomItemsBridge> getCustomItems();

    default Optional getCustomColors() {
        return Optional.empty();
    }

    default int getBossTextColor(int n) {
        return n;
    }

    default Optional initAsyncTexture(ResourceLocationBridge resourceLocationBridge) {
        return Optional.empty();
    }
}
