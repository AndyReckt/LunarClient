package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.util.Vector3i;
import com.moonsworth.lunar.bridge.minecraft.world.biome.BiomeGenBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.world.biome.WorldChunkManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.world.chunk.ChunkBridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.entity.EntityEvent;
import com.moonsworth.lunar.client.event.type.world.ChunkEvent;
import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Chunk.class)
public abstract class MixinChunk implements ChunkBridge {
    @Shadow
    private boolean isGapLightingUpdated;
    @Shadow
    private boolean isTerrainPopulated;
    @Shadow
    private boolean isLightPopulated;
    @Final
    @Shadow
    public int xPosition;
    @Final
    @Shadow
    public int zPosition;

    @Shadow
    public abstract BiomeGenBase getBiome(BlockPos var1, WorldChunkManager var2);

    @Shadow
    public abstract void generateSkylightMap();

    public BiomeGenBaseBridge bridge$getBiome(Vector3i var1, WorldChunkManagerBridge var2) {
        return (BiomeGenBaseBridge)this.getBiome(new BlockPos(var1.getX(), var1.getY(), var1.getZ()), (WorldChunkManager)var2);
    }

    public int bridge$getX() {
        return xPosition;
    }

    public int bridge$getZ() {
        return zPosition;
    }

    @Redirect(method = "recheckGaps", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;isAreaLoaded(Lnet/minecraft/util/BlockPos;I)Z"))
    public boolean impl$recheckGaps(World var1, BlockPos var2, int var3, boolean var4) {
        if (!(Boolean) LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl()) {
            if (!var4) {
                this.isGapLightingUpdated = false;
            }

            return false;
        } else {
            return var1.isAreaLoaded(var2, var3);
        }
    }

    @Inject(method = "checkSkylightNeighborHeight", at = @At("HEAD"), cancellable = true)
    public void impl$checkSkylightNeighborHeight(int var1, int var2, int var3, CallbackInfo var4) {
        if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl()) {
            var4.cancel();
        }
    }

    @Inject(method = "updateSkylightNeighborHeight", at = @At("HEAD"), cancellable = true)
    public void impl$updateSkylightNeighborHeight(int var1, int var2, int var3, int var4, CallbackInfo var5) {
        if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl()) {
            var5.cancel();
        }
    }

    @Inject(method = "enqueueRelightChecks", at = @At("HEAD"), cancellable = true)
    public void impl$enqueueRelightChecks(CallbackInfo var1) {
        if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl()) {
            var1.cancel();
        }
    }

    @Inject(method = "func_150809_p", at = @At("HEAD"), cancellable = true)
    public void impl$func_150809_p(CallbackInfo var1) {
        this.isTerrainPopulated = true;
        this.isLightPopulated = true;
        if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl()) {
            var1.cancel();
        }
    }

    @Redirect(method = "relightBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/WorldProvider;getHasNoSky()Z"))
    public boolean impl$relightBlock$getHasNoSky(WorldProvider var1) {
        return var1.getHasNoSky() || Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl();
    }

    @ModifyVariable(method = "setBlockState", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/chunk/storage/ExtendedBlockStorage;set(IIILnet/minecraft/block/state/IBlockState;)V"))
    public boolean impl$setBlockState$lightCheck1(boolean var1) {
        return var1 || Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl();
    }

    @Redirect(method = "setBlockState", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/chunk/Chunk;generateSkylightMap()V"))
    public void impl$setBlockState$lightCheck2(Chunk var1) {
        if (!Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl()) {
            this.generateSkylightMap();
        }
    }

    @Inject(method = "onChunkLoad", at = @At("RETURN"))
    public void impl$onChunkLoad(CallbackInfo var1) {
        ChunkEvent.ChunkLoadEvent var2 = new ChunkEvent.ChunkLoadEvent(this);
        EventBus.getInstance().call(var2);
    }

    @Inject(method = "addEntity", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/Entity;addedToChunk:Z", shift = At.Shift.BEFORE))
    public void impl$onAddEntity(Entity var1, CallbackInfo var2) {
        EventBus.getInstance().call(new EntityEvent.EntityAddEvent((EntityBridge)var1, this.xPosition, this.zPosition));
    }

}
