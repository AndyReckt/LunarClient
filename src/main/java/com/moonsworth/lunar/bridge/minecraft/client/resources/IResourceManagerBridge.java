package com.moonsworth.lunar.bridge.minecraft.client.resources;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author Decencies
 * @since 10/07/2021 14:22
 */
public interface IResourceManagerBridge {
    Set<String> bridge$getResourceDomains();

    // todo might not thrown
default SimpleResourceBridge bridge$getResource(ResourceLocationBridge resourceLocationBridge) throws IOException {
            return this.bridge$getResource(resourceLocationBridge, false);
        }

    SimpleResourceBridge bridge$getResource(ResourceLocationBridge var1, boolean var2) throws IOException;

    List bridge$getAllResources(ResourceLocationBridge var1);
}

