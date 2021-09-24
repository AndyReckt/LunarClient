package com.moonsworth.lunar.client.bridge.impl.type.potion;

import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.potion.PotionBridge;
import com.moonsworth.lunar.bridge.minecraft.potion.PotionEffectBridge;
import net.minecraft.item.ItemPotion;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;

public class PotionImplementation implements PotionBridge {
    public PotionBridge bridge$moveSlowdown() {
        return (PotionBridge) Potion.moveSlowdown;
    }

    public PotionBridge bridge$moveSpeed() {
        return (PotionBridge)Potion.moveSpeed;
    }

    public PotionBridge bridge$getPotionTypes(int var1) {
        return (PotionBridge)Potion.potionTypes[var1];
    }

    public PotionEffectBridge bridge$initPotionEffect(int var1, int var2, int var3) {
        return (PotionEffectBridge)(new PotionEffect(var1, var2, var3));
    }

    public String bridge$translateToLocal(String var1) {
        return StatCollector.translateToFallback(var1);
    }

    public String bridge$getDurationString(PotionEffectBridge var1) {
        return Potion.getDurationString((PotionEffect)var1);
    }

    public PotionBridge bridge$heal() {
        return (PotionBridge)Potion.heal;
    }

    public PotionBridge bridge$blindness() {
        return (PotionBridge)Potion.blindness;
    }

    @Override public boolean bridge$isBadEffect() {
        return false;
    }

    @Override public boolean bridge$hasStatusIcon() {
        return false;
    }

    @Override public int bridge$getStatusIconIndex() {
        return 0;
    }

    @Override public int bridge$getID() {
        return 0;
    }

    public boolean bridge$isPotionSplash(ItemStackBridge var1) {
        return ItemPotion.isSplash(var1.bridge$getItemDamage());
    }

    public PotionBridge bridge$confusion() {
        return (PotionBridge)Potion.confusion;
    }
}