package com.moonsworth.lunar.bridge.minecraft.client.renderer.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.item.EntityItemBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.ItemModelMesherBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureAtlasSpriteBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.IBakedModelBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;

import java.util.Optional;

public interface RenderItemBridge {
    public void bridge$renderModel(IBakedModelBridge var1, int var2);

    public void bridge$setZLevel(float var1);

    public float bridge$getZLevel();

    public void bridge$renderItemAndEffectIntoGUI(ItemStackBridge var1, int var2, int var3);

    public void bridge$renderItemOverlayIntoGUI(ItemStackBridge var1, int var2, int var3);

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityItemBridge entityItemBridge, TextureAtlasSpriteBridge textureAtlasSpriteBridge, int n, float f, float f2, float f3, float f4) {
    }

    public void bridge$renderItem(ItemStackBridge var1, IBakedModelBridge var2);

    public Optional<ItemModelMesherBridge> bridge$getItemModelShaper();

    default public Optional bridge$getModelLocation() {
        return Optional.empty();
    }
}