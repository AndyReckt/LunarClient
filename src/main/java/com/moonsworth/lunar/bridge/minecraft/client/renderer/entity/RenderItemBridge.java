package com.moonsworth.lunar.bridge.minecraft.client.renderer.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.item.EntityItemBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.ItemModelMesherBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureAtlasSpriteBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.IBakedModelBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.util.Optional;

public interface RenderItemBridge {
    void bridge$renderModel(IBakedModelBridge var1, int var2);

    void bridge$setZLevel(float var1);

    float bridge$getZLevel();

    void bridge$renderItemAndEffectIntoGUI(ItemStackBridge var1, int var2, int var3);

    void bridge$renderItemOverlayIntoGUI(ItemStackBridge var1, int var2, int var3);

default void lIlIlIlIlIIlIIlIIllIIIIIl(EntityItemBridge entityItemBridge, TextureAtlasSpriteBridge textureAtlasSpriteBridge, int n, float f, float f2, float f3, float f4) {
    }

    void bridge$renderItem(ItemStackBridge var1, IBakedModelBridge var2);

    Optional<ItemModelMesherBridge> bridge$getItemModelShaper();

default Optional<ResourceLocationBridge> bridge$getModelLocation() {
        return Optional.empty();
    }
}