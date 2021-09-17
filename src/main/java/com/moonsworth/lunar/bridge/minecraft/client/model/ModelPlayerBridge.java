package com.moonsworth.lunar.bridge.minecraft.client.model;

public interface ModelPlayerBridge
extends ModelBipedBridge {
    public ModelRendererBridge bridge$cloak();

    default public ModelRendererBridge bridge$head() {
        return this.bridge$bipedHead();
    }
}
 