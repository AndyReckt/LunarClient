package com.moonsworth.lunar.bridge.minecraft.world;

import com.moonsworth.lunar.bridge.minecraft.block.BlockBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ParticleType;
import com.moonsworth.lunar.bridge.minecraft.util.Vector3i;
import com.moonsworth.lunar.bridge.minecraft.world.biome.WorldChunkManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.world.chunk.ChunkBridge;
import com.moonsworth.lunar.bridge.minecraft.world.storage.WorldInfoBridge;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Decencies
 * @since 10/07/2021 14:12
 */
public interface WorldBridge {
    Optional<EntityPlayerBridge> bridge$getPlayerByUniqueId(UUID var1);

    void bridge$playSound(double var1, double var3, double var5, String var7, float var8, float var9, boolean var10);

    List<EntityPlayerBridge> bridge$getPlayerEntities();

    List<EntityBridge> bridge$getEntities();

    boolean bridge$isRemote();

    WorldInfoBridge bridge$getWorldInfo();

    ChunkBridge bridge$getChunkFromBlockCoords(Vector3i var1);

    WorldChunkManagerBridge bridge$getWorldChunkManager();

    void bridge$setWorldTime(long var1);

    int bridge$getDimensionId();

    void bridge$spawnParticle(ParticleType var1, double var2, double var4, double var6, double var8, double var10, double var12, int... var14);

    void bridge$spawnParticle(ParticleType var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15);

    BlockBridge bridge$getBlockAt(double var1, double var3, double var5);
}