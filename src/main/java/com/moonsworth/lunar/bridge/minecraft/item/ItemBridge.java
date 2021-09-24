package com.moonsworth.lunar.bridge.minecraft.item;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureAtlasSpriteBridge;

import java.util.Map;
import java.util.Optional;

public interface ItemBridge {
    boolean bridge$isItemPotion();

    boolean bridge$isItemSoup();

default boolean bridge$isItemSkull() {
        return false;
    }

    boolean bridge$hasEffect(ItemStackBridge var1);

    Integer bridge$getColorFromItemStack(ItemStackBridge var1, int var2);

default Optional<TextureAtlasSpriteBridge> lIlIlIlIlIIlIIlIIllIIIIIl(ItemStackBridge itemStackBridge, int n) {
        return Optional.empty();
    }

default boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return false;
    }

    boolean bridge$isItemBlock();

    String bridge$getRegistryName();

    boolean bridge$isRepairable(ItemStackBridge var1, ItemStackBridge var2);

    Map bridge$getEnchantments(ItemStackBridge var1);
}