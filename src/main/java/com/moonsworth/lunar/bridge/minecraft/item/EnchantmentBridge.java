package com.moonsworth.lunar.bridge.minecraft.item;

public interface EnchantmentBridge {
    int bridge$getMaxLevel();

    int bridge$getWeight();

    boolean bridge$canApplyTogether(EnchantmentBridge var1);

    boolean bridge$canApply(ItemStackBridge var1);
}
