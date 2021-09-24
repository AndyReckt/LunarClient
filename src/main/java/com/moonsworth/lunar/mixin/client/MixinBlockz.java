package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.block.BlockBridge;
import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class MixinBlockz implements BlockBridge {
    public MixinBlockz() {
    }

    @Inject(method = "shouldSideBeRendered", at = @At("HEAD"), cancellable = true)
    public void impl$shouldBeRendered(IBlockAccess var1, BlockPos var2, EnumFacing var3, CallbackInfoReturnable<Boolean> var4) {
        if (Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().lIIlIIIIIIlIIlIIllIlIIlII()) {
            var4.setReturnValue(Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().lIlIlIIIIIIllIlIIIIllIIII().contains(this));
        }
    }

    @Inject(method = "getAmbientOcclusionLightValue", at = @At("HEAD"), cancellable = true)
    public void impl$getAmbientOcculsionLightValue(CallbackInfoReturnable<Float> var1) {
        if (Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().lIIlIIIIIIlIIlIIllIlIIlII()) {
            var1.setReturnValue(1.0F);
        }
    }
}
