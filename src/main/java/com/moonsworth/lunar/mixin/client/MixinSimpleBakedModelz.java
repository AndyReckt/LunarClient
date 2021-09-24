package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.block.model.ItemCameraTransformsBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.IBakedModelBridge;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.resources.model.SimpleBakedModel;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SimpleBakedModel.class)
public abstract class MixinSimpleBakedModelz implements IBakedModelBridge {

    @Final
    @Shadow
    protected boolean gui3d;

    @Shadow
    public abstract ItemCameraTransforms getItemCameraTransforms();

    public boolean bridge$isGui3D() {
        return gui3d;
    }

    public ItemCameraTransformsBridge bridge$getItemCameraTransforms() {
        return (ItemCameraTransformsBridge) this.getItemCameraTransforms();
    }
}
