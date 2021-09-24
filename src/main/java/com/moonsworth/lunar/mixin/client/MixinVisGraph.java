package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.chunk.VisGraphBridge;
import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.util.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VisGraph.class)
public abstract class MixinVisGraph implements VisGraphBridge {
    public MixinVisGraph() {
    }

    @Inject(method = "func_178606_a", at = @At("HEAD"), cancellable = true)
    public void impl$func_178606_a(BlockPos var1, CallbackInfo var2) {
        if (Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().IIlIllIlllllllIIlIIIllIIl().IlllllIlIIIlIIlIIllIIlIll().lIIlIIIIIIlIIlIIllIlIIlII()) {
            var2.cancel();
        }
    }
}
