package com.moonsworth.lunar.bridge.minecraft.client.resources;

import java.util.List;

public interface SimpleReloadableResourceManagerBridge extends IResourceManagerBridge {
    void bridge$reloadResources(List<AbstractResourcePackBridge> var1);

    void bridge$registerReloadListener(IResourceManagerReloadListenerBridge var1);

    void bridge$putDomainResourceManager(String var1, IResourceManagerBridge var2);
}
