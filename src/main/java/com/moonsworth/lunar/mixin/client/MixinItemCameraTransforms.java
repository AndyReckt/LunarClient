package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.block.model.ItemCameraTransformsBridge;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemCameraTransforms.class)
public abstract class MixinItemCameraTransforms implements ItemCameraTransformsBridge {
    public MixinItemCameraTransforms() {
    }

    @Shadow
    public abstract void applyTransform(ItemCameraTransforms.TransformType var1);

    public void bridge$applyTransform(ItemCameraTransformsBridge.lIlIlIlIlIIlIIlIIllIIIIIl var1) {
    }
}
