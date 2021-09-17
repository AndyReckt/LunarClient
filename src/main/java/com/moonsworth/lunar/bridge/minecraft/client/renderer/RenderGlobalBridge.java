package com.moonsworth.lunar.bridge.minecraft.client.renderer;

public interface RenderGlobalBridge {
    public int bridge$getMaximumRenderCount();

    public int bridge$getUnculledRenderCount();

    public void bridge$setDisplayListEntitiesDirty(boolean var1);

    public void bridge$reloadChunks();
}
 