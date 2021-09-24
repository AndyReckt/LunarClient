package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.block.model.ItemCameraTransformsBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.IBakedModelBridge;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.resources.model.BuiltInModel;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BuiltInModel.class)
public abstract class MixinBuiltInModelz implements IBakedModelBridge {

    public MixinBuiltInModelz() {
    }

    @Shadow
    public abstract boolean isGui3d();

    @Shadow
    public abstract ItemCameraTransforms getItemCameraTransforms();

    public boolean bridge$isGui3D() {
        return isGui3d();
    }

    public ItemCameraTransformsBridge bridge$getItemCameraTransforms() {
        return (ItemCameraTransformsBridge) getItemCameraTransforms();
    }
}