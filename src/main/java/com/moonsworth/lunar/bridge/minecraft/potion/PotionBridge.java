package com.moonsworth.lunar.bridge.minecraft.potion;

import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;

public interface PotionBridge {
    public PotionBridge bridge$moveSlowdown();

    public PotionBridge bridge$moveSpeed();

    public PotionBridge bridge$confusion();

    public PotionBridge bridge$heal();

    public PotionBridge bridge$blindness();

    public PotionBridge bridge$getPotionTypes(int var1);

    public PotionEffectBridge bridge$initPotionEffect(int var1, int var2, int var3);

    public String bridge$translateToLocal(String var1);

    public String bridge$getDurationString(PotionEffectBridge var1);

    public boolean bridge$isPotionSplash(ItemStackBridge var1);

    default public boolean lIlIlIlIlIIlIIlIIllIIIIIl(ItemStackBridge itemStackBridge) {
        return false;
    }
}
 