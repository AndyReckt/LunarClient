package com.moonsworth.lunar.bridge.minecraft.client.resources;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 14:24
 */
public interface AbstractResourcePackBridge {
    InputStream bridge$getInputStream(ResourceLocationBridge var1);

    String bridge$getPackName();

default Optional<BufferedImage> bridge$getPackImage() {
        return Optional.empty();
    }
}
