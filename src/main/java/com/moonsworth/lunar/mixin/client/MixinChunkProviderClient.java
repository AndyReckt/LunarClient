package com.moonsworth.lunar.mixin.client;

import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ChunkProviderClient.class)
public abstract class MixinChunkProviderClient {
    public MixinChunkProviderClient() {
    }

    public void impl$loadChunk(Chunk var1, boolean var2) {
    }
}
