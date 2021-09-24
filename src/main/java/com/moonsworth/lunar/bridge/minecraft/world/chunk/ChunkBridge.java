package com.moonsworth.lunar.bridge.minecraft.world.chunk;

import com.moonsworth.lunar.bridge.minecraft.util.Vector3i;
import com.moonsworth.lunar.bridge.minecraft.world.biome.BiomeGenBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.world.biome.WorldChunkManagerBridge;

/**
 * @author Decencies
 * @since 10/07/2021 14:13
 */
public interface ChunkBridge {
    BiomeGenBaseBridge bridge$getBiome(Vector3i var1, WorldChunkManagerBridge var2);

    int bridge$getX();

    int bridge$getZ();
}