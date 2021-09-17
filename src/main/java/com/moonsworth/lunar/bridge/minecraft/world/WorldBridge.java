package com.moonsworth.lunar.bridge.minecraft.world;

import com.moonsworth.lunar.bridge.minecraft.block.BlockBridge;
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
    public Optional bridge$getPlayerByUniqueId(UUID var1);

    public void bridge$playSound(double var1, double var3, double var5, String var7, float var8, float var9, boolean var10);

    public List<EntityPlayerBridge> bridge$getPlayerEntities();

    public List bridge$getEntities();

    public boolean bridge$isRemote();

    public WorldInfoBridge bridge$getWorldInfo();

    public ChunkBridge bridge$getChunkFromBlockCoords(Vector3i var1);

    public WorldChunkManagerBridge bridge$getWorldChunkManager();

    public void bridge$setWorldTime(long var1);

    public int bridge$getDimensionId();

    public void bridge$spawnParticle(ParticleType var1, double var2, double var4, double var6, double var8, double var10, double var12, int ... var14);

    public void bridge$spawnParticle(ParticleType var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int ... var15);

    public BlockBridge bridge$getBlockAt(double var1, double var3, double var5);
}