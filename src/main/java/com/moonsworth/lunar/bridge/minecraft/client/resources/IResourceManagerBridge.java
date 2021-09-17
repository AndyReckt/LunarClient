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
    public Set bridge$getResourceDomains();

    // todo might not thrown
    default public SimpleResourceBridge bridge$getResource(ResourceLocationBridge resourceLocationBridge) throws IOException {
        return this.bridge$getResource(resourceLocationBridge, false);
    }

    public SimpleResourceBridge bridge$getResource(ResourceLocationBridge var1, boolean var2) throws IOException;

    public List bridge$getAllResources(ResourceLocationBridge var1);
}

