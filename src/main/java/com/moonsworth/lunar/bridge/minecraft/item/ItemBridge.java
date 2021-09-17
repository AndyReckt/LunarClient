package com.moonsworth.lunar.bridge.minecraft.item;

import java.util.Map;
import java.util.Optional;

public interface ItemBridge {
    public boolean bridge$isItemPotion();

    public boolean bridge$isItemSoup();

    default public boolean bridge$isItemSkull() {
        return false;
    }

    public boolean bridge$hasEffect(ItemStackBridge var1);

    public Integer bridge$getColorFromItemStack(ItemStackBridge var1, int var2);

    default public Optional lIlIlIlIlIIlIIlIIllIIIIIl(ItemStackBridge itemStackBridge, int n) {
        return Optional.empty();
    }

    default public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return false;
    }

    public boolean bridge$isItemBlock();

    public String bridge$getRegistryName();

    public boolean bridge$isRepairable(ItemStackBridge var1, ItemStackBridge var2);

    public Map bridge$getEnchantments(ItemStackBridge var1);
}