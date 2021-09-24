package com.moonsworth.lunar.mixin.client;

import com.google.common.base.Predicate;
import com.moonsworth.lunar.bridge.minecraft.block.BlockBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ParticleType;
import com.moonsworth.lunar.bridge.minecraft.util.Vector3i;
import com.moonsworth.lunar.bridge.minecraft.world.WorldBridge;
import com.moonsworth.lunar.bridge.minecraft.world.biome.WorldChunkManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.world.chunk.ChunkBridge;
import com.moonsworth.lunar.bridge.minecraft.world.storage.WorldInfoBridge;
import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.profiler.Profiler;
import net.minecraft.util.*;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.WorldInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.*;
import java.util.stream.Collectors;

@Mixin(World.class)
public abstract class MixinWorldz implements WorldBridge, IBlockAccess {
    @Shadow
    public boolean isRemote;
    @Shadow
    public WorldInfo worldInfo;
    @Shadow
    public WorldProvider provider;
    @Shadow
    public List<Entity> loadedEntityList;
    @Shadow
    public Set activeChunkSet;
    @Shadow
    public Profiler theProfiler;
    @Shadow
    public int ambientTickCountdown;
    @Shadow
    public List playerEntities;
    @Shadow
    public Random rand;

    @Shadow
    public abstract EntityPlayer getPlayerEntityByUUID(UUID var1);

    @Shadow
    public abstract void playSound(double var1, double var3, double var5, String var7, float var8, float var9, boolean var10);

    @Shadow
    public abstract <T extends Entity> List<T> getEntities(Class<? extends T> entityType, Predicate<? super T> filter);

    @Shadow
    public abstract WorldChunkManager getWorldChunkManager();

    @Shadow
    public abstract Chunk getChunkFromBlockCoords(BlockPos var1);

    @Shadow
    public abstract void setWorldTime(long var1);

    @Shadow
    public abstract double getHorizon();

    @Shadow
    public abstract boolean isValid(BlockPos var1);

    @Shadow
    public abstract void spawnParticle(EnumParticleTypes var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15);

    @Shadow
    public abstract void onEntityAdded(Entity var1);

    @Shadow
    public abstract int getRenderDistanceChunks();

    @Shadow
    public abstract boolean checkLight(BlockPos var1);

    public Optional bridge$getPlayerByUniqueId(UUID var1) {
        return Optional.ofNullable(getPlayerEntityByUUID(var1));
    }

    public void bridge$playSound(double var1, double var3, double var5, String var7, float var8, float var9, boolean var10) {
        playSound(var1, var3, var5, var7, var8, var9, var10);
    }

    public List bridge$getPlayerEntities() {
        return this.getEntities(EntityPlayer.class, null).stream().map(entityPlayer -> (EntityPlayerBridge) entityPlayer).collect(Collectors.toList());
    }

    public List bridge$getEntities() {
        return this.loadedEntityList.stream().map(entity -> (EntityBridge) entity).collect(Collectors.toList());
    }

    public boolean bridge$isRemote() {
        return isRemote;
    }

    public ChunkBridge bridge$getChunkFromBlockCoords(Vector3i var1) {
        return (ChunkBridge) this.getChunkFromBlockCoords(new BlockPos(var1.getX(), var1.getY(), var1.getZ()));
    }

    public WorldChunkManagerBridge bridge$getWorldChunkManager() {
        return (WorldChunkManagerBridge) getWorldChunkManager();
    }

    public void bridge$setWorldTime(long var1) {
        setWorldTime(var1);
    }

    public double proxy$getHorizon() {
        return getHorizon();
    }

    public WorldInfoBridge bridge$getWorldInfo() {
        return (WorldInfoBridge) worldInfo;
    }

    public int bridge$getDimensionId() {
        return provider.getDimensionId();
    }

    public boolean impl$markBlocksDirtyVertical$getHasNoSky(WorldProvider var1) {
        return var1.getHasNoSky() || Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl();
    }

    public void impl$checkLightFor(EnumSkyBlock var1, BlockPos var2, CallbackInfoReturnable var3) {
    }

    public void bridge$spawnParticle(ParticleType var1, double var2, double var4, double var6, double var8, double var10, double var12, int... var14) {
    }

    public void bridge$spawnParticle(ParticleType var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
    }

    public void impl$getCollidingBoundingBoxes(Entity var1, AxisAlignedBB var2, CallbackInfoReturnable var3) {
    }

    public void impl$getCollisionBoxes(AxisAlignedBB var1, CallbackInfoReturnable var2) {
    }

    public void impl$rayTraceBlocks(Vec3 var1, Vec3 var2, boolean var3, boolean var4, boolean var5, CallbackInfoReturnable var6, int var7, int var8, int var9, int var10, int var11, int var12, BlockPos var13, MovingObjectPosition var14, int var15) {
    }

    public void setActivePlayerChunksAndCheckLight() {
    }

    public void impl$onSpawnEntityInWorld(Entity var1, CallbackInfoReturnable var2) {
    }

    public void proxy$loadEntities(Collection var1) {
    }

    public void impl$onJoinEntityInSurroundings(Entity var1, CallbackInfo var2) {
    }

    public void impl$removeEntity(Entity var1, CallbackInfo var2) {
    }

    public BlockBridge bridge$getBlockAt(double var1, double var3, double var5) {
        return (BlockBridge) this.getBlockState(new BlockPos(var1, var3, var5)).getBlock();
    }

//    // $FF: synthetic method
//    public static EntityBridge lambda$bridge$getEntities$1(Entity var0) {
//    }
//
//    // $FF: synthetic method
//    public static EntityPlayerBridge lambda$bridge$getPlayerEntities$0(EntityPlayer var0) {
//    }
}
