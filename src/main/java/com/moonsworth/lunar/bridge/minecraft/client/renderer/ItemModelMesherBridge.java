package com.moonsworth.lunar.bridge.minecraft.client.renderer;

import com.moonsworth.lunar.bridge.minecraft.client.resources.model.BuiltInModelBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.IBakedModelBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;

public interface ItemModelMesherBridge {
    IBakedModelBridge bridge$getItemModel(ItemStackBridge var1);

    IBakedModelBridge bridge$getItemModel(ItemBridge var1, int var2);
}
