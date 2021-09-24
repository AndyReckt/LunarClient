package com.moonsworth.lunar.mixin.client.item;

import com.moonsworth.lunar.bridge.minecraft.item.EnchantmentBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Enchantment.class)
public abstract class MixinEnchantmentz implements EnchantmentBridge {

    @Shadow
    public abstract int getMaxLevel();

    @Shadow
    public abstract int getWeight();

    @Shadow
    public abstract boolean canApplyTogether(Enchantment var1);

    @Shadow
    public abstract boolean canApply(ItemStack var1);

    public int bridge$getMaxLevel() {
        return getMaxLevel();
    }

    public int bridge$getWeight() {
        return getWeight();
    }

    public boolean bridge$canApplyTogether(EnchantmentBridge var1) {
        return canApplyTogether((Enchantment) var1);
    }

    public boolean bridge$canApply(ItemStackBridge var1) {
        return canApply((ItemStack) var1);
    }
}