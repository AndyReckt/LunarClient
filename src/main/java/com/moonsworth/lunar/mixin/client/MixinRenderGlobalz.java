package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.RenderGlobalBridge;
import com.moonsworth.lunar.bridge.minecraft.util.MovingObjectPositionBridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.world.DrawSelectionBoundingBoxEvent;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.ViewFrustum;
import net.minecraft.client.renderer.chunk.CompiledChunk;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(RenderGlobal.class)
public abstract class MixinRenderGlobalz implements RenderGlobalBridge {

    @Shadow
    private ViewFrustum viewFrustum;
    @Shadow
    private List<RenderGlobal.ContainerLocalRenderInformation> renderInfos;
    @Shadow
    private boolean displayListEntitiesDirty;

    @Shadow
    public abstract void loadRenderers();

    public int bridge$getMaximumRenderCount() {
        return this.viewFrustum.renderChunks.length;
    }

    public int bridge$getUnculledRenderCount() {
        return (int)this.renderInfos.stream().filter(containerLocalRenderInformation -> {
            RenderChunk renderChunk = containerLocalRenderInformation.renderChunk;
            CompiledChunk compiledChunk = renderChunk.compiledChunk;
            return compiledChunk != CompiledChunk.DUMMY && !compiledChunk.isEmpty();
        }).count();
    }

    public void bridge$setDisplayListEntitiesDirty(boolean var1) {
        displayListEntitiesDirty = var1;
    }

    // todo
    // @Redirect(method = "drawSelectionBox", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/state/IBlockState;getBlock()Lnet/minecraft/block/Block;"))
    public Block impl$drawSelectionBox$getBlock(IBlockState var1, EntityPlayer var2, MovingObjectPosition var3) {
        if (((MovingObjectPositionBridge)var3).bridge$isBorder()) {
            return Blocks.stone;
        }
        return var1.getBlock();
    }

    @Inject(method = "drawSelectionBoundingBox", at = @At("HEAD"), cancellable = true)
    private static void impl$drawSelectionBoundingBox(AxisAlignedBB axisAlignedBB, CallbackInfo var1) {
        DrawSelectionBoundingBoxEvent drawSelectionBoundingBoxEvent = new DrawSelectionBoundingBoxEvent(axisAlignedBB.minX, axisAlignedBB.minY, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.maxY, axisAlignedBB.maxZ);
        EventBus.getInstance().call(drawSelectionBoundingBoxEvent);
        if (drawSelectionBoundingBoxEvent.isCancelled()) {
            var1.cancel();
        }
    }

    public void bridge$reloadChunks() {
        this.loadRenderers();
    }

}