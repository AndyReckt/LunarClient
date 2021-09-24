package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.tileentity.TileEntityBridge;
import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.tileentity.TileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TileEntityRendererDispatcher.class)
public abstract class MixinTileEntityRendererDispatcher {
    public MixinTileEntityRendererDispatcher() {
    }

    @Inject(method = "renderTileEntity", at = @At("HEAD"), cancellable = true)
    public void impl$renderTileEntity(TileEntity var1, float var2, int var3, CallbackInfo var4) {
        if (Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().lIIlIIIIIIlIIlIIllIlIIlII() && !Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().lIlIlIIIIIIllIlIIIIllIIII().contains(var1.getBlockType())) {
            var4.cancel();
        }

        if (!LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().lIlIlIlIlIIlIIlIIllIIIIIl((TileEntityBridge)var1)) {
            var4.cancel();
        }
    }
}
