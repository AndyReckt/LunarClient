package com.moonsworth.lunar.bridge.minecraft.client.renderer.texture;

public abstract class ITextureObjectImplementation
    implements CustomTextureBridge {
    public int glTextureId = -1;

    @Override
    public void bridge$setGlTextureId(int n) {
        this.glTextureId = n;
    }

    @Override
    public int bridge$getGlTextureId() {
        return this.glTextureId;
    }
}
