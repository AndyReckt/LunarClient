package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTripWire;
import net.minecraft.client.renderer.BlockModelRenderer;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockModelRenderer.class)
public abstract class MixinBlockModelRendererzz {

    @Inject(method = "renderModelAmbientOcclusion", at = @At("HEAD"), cancellable = true)
    public void impl$renderModelAmbientOcclusion(IBlockAccess blockAccess, IBakedModel bakedModel, Block block, BlockPos blockPos, WorldRenderer worldRenderer, boolean b, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().lIIlIIIIIIlIIlIIllIlIIlII() && !Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().lIlIlIIIIIIllIlIIIIllIIII().contains(block)) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }

    @Inject(method = "renderModelAmbientOcclusion", at = @At("HEAD"), cancellable = true)
    public void impl$renderModelStandard(IBlockAccess blockAccess, IBakedModel bakedModel, Block block, BlockPos blockPos, WorldRenderer worldRenderer, boolean var6, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().lIIlIIIIIIlIIlIIllIlIIlII() && !Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().lIlIlIIIIIIllIlIIIIllIIII().contains(block)) {
            callbackInfoReturnable.setReturnValue(false);
        }
    }

    @Redirect(method = "renderModelAmbientOcclusionQuads", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/block/model/BakedQuad;hasTintIndex()Z"))
    public boolean impl$renderModelAmbientOcclusionQuads$hasTintIndex(BakedQuad bakedQuad, IBlockAccess blockAccess, Block block) {
        return (block instanceof BlockTripWire && LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIIlIlllIlIlIIIlllIIlIIII().llIlllIIIllllIIlllIllIIIl()) || bakedQuad.hasTintIndex();
    }

    @Redirect(method = "renderModelStandardQuads", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/block/model/BakedQuad;hasTintIndex()Z"))
    public boolean impl$renderModelStandardQuads$hasTintIndex(BakedQuad bakedQuad, IBlockAccess blockAccess, Block block) {
        return (block instanceof BlockTripWire && LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIIlIlllIlIlIIIlllIIlIIII().llIlllIIIllllIIlllIllIIIl()) || bakedQuad.hasTintIndex();
    }

}