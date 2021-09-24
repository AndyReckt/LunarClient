package com.moonsworth.lunar.bridge.minecraft.potion;

import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;

public interface PotionBridge {
    PotionBridge bridge$moveSlowdown();

    PotionBridge bridge$moveSpeed();

    PotionBridge bridge$confusion();

    PotionBridge bridge$heal();

    PotionBridge bridge$blindness();

    boolean bridge$isBadEffect();

    boolean bridge$hasStatusIcon();

    int bridge$getStatusIconIndex();

    int bridge$getID();

    PotionBridge bridge$getPotionTypes(int var1);

    PotionEffectBridge bridge$initPotionEffect(int var1, int var2, int var3);

    String bridge$translateToLocal(String var1);

    String bridge$getDurationString(PotionEffectBridge var1);

    boolean bridge$isPotionSplash(ItemStackBridge var1);

default boolean lIlIlIlIlIIlIIlIIllIIIIIl(ItemStackBridge itemStackBridge) {
        return false;
    }
}
