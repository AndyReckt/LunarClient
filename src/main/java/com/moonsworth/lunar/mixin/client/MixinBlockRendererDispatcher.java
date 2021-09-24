package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.client.profile.main.GlassRenderSetting;
import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockStainedGlass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockRendererDispatcher.class)
public abstract class MixinBlockRendererDispatcher {

    @Inject(method = "renderBlock", at = @At("HEAD"), cancellable = true)
    public void impl$renderBlock(IBlockState var1, BlockPos var2, IBlockAccess var3, WorldRenderer var4, CallbackInfoReturnable<Boolean> var5) {
        GlassRenderSetting var6 = (GlassRenderSetting) Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IIlIllIlllllllIIlIIIllIIl().llIlllIIIllllIIlllIllIIIl();
        if (var6 != GlassRenderSetting.OFF) {
            if (var1.getBlock() instanceof BlockGlass) {
                if (var6 == GlassRenderSetting.REGULAR || var6 == GlassRenderSetting.ALL) {
                    var5.setReturnValue(false);
                }
            } else if (var1.getBlock() instanceof BlockStainedGlass && var6 == GlassRenderSetting.ALL) {
                var5.setReturnValue(false);
            }
        }
    }
}
