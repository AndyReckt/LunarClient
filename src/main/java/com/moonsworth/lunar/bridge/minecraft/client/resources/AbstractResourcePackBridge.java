package com.moonsworth.lunar.bridge.minecraft.client.resources;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.io.InputStream;
import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 14:24
 */
public interface AbstractResourcePackBridge {
    public InputStream bridge$getInputStream(ResourceLocationBridge var1);

    public String bridge$getPackName();

    default public Optional bridge$getPackImage() {
        return Optional.empty();
    }
}
