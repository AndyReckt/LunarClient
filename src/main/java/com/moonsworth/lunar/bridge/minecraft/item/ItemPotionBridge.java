package com.moonsworth.lunar.bridge.minecraft.item;

import com.moonsworth.lunar.bridge.minecraft.potion.PotionBridge;
import com.moonsworth.lunar.bridge.minecraft.potion.PotionEffectBridge;

import java.util.Collection;

public interface ItemPotionBridge extends ItemBridge {
    Collection<PotionEffectBridge> bridge$getEffects(ItemStackBridge var1);
}