package com.moonsworth.lunar.bridge.minecraft.client.model;

public interface ModelPlayerBridge
    extends ModelBipedBridge {
    ModelRendererBridge bridge$cloak();

default ModelRendererBridge bridge$head() {
        return this.bridge$bipedHead();
    }
}
