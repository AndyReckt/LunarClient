package com.moonsworth.lunar.bridge.minecraft.client.renderer.texture;

import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerBridge;

import java.io.IOException;

public interface LoadableTickingTexture
extends AbstractTextureBridge,
TickingTexture {
    public static final LoadableTickingTexture lIlIlIlIlIIlIIlIIllIIIIIl = new LoadableTickingTexture(){

        @Override
        public boolean bridge$ready() {
            return true;
        }

        @Override
        public void bridge$setBlurMipmap(boolean bl, boolean bl2) {
        }

        @Override
        public void bridge$deleteGlTexture() {
        }

        @Override
        public void bridge$tick() {
        }

        @Override
        public void bridge$setGlTextureId(int n) {
        }

        @Override
        public int bridge$getGlTextureId() {
            return 0;
        }

        @Override
        public void bridge$loadTexture(IResourceManagerBridge iResourceManagerBridge) throws IOException {
        }
    };

    public boolean bridge$ready();
}