package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.block.model.ItemCameraTransformsBridge;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.client.resources.model.WeightedBakedModel;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(WeightedBakedModel.class)
public abstract class MixinWeightedBakedModelz implements IBakedModel {

    @Final
    @Shadow
    private IBakedModel baseModel;

    @Shadow
    public abstract ItemCameraTransforms getItemCameraTransforms();

    public boolean bridge$isGui3D() {
        return this.baseModel.isGui3d();
    }

    public ItemCameraTransformsBridge bridge$getItemCameraTransforms() {
        return (ItemCameraTransformsBridge) this.getItemCameraTransforms();
    }
}