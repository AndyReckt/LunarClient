package com.moonsworth.lunar.bridge.optifine;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderItemBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.BuiltInModelBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import net.minecraft.client.resources.model.IBakedModel;

import java.util.Optional;

public interface CustomItemsBridge {
    boolean useGlint();

    boolean renderCustomEffect(RenderItemBridge var1, ItemStackBridge var2, BuiltInModelBridge var3);

default Optional<IBakedModel> getCustomItemModel(ItemStackBridge itemStackBridge, BuiltInModelBridge builtInModelBridge, ResourceLocationBridge resourceLocationBridge, boolean bl) {
        return Optional.empty();
    }
}
