package com.moonsworth.lunar.bridge.minecraft.client.renderer;

public interface RenderGlobalBridge {
    int bridge$getMaximumRenderCount();

    int bridge$getUnculledRenderCount();

    void bridge$setDisplayListEntitiesDirty(boolean var1);

    void bridge$reloadChunks();
}
