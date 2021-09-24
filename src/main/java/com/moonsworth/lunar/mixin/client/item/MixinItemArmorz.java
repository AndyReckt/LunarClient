package com.moonsworth.lunar.mixin.client.item;

import com.moonsworth.lunar.bridge.minecraft.item.ItemArmorBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemArmor.class)
public abstract class MixinItemArmorz extends Item implements ItemArmorBridge {
    @Final
    @Shadow
    public int armorType;
    @Final
    @Shadow
    public ItemArmor.ArmorMaterial material;

    @Shadow
    public abstract boolean hasColor(ItemStack var1);

    @Shadow
    public abstract int getColor(ItemStack var1);

    public int bridge$getArmorType() {
        return armorType;
    }

    public boolean bridge$hasColor(ItemStackBridge var1) {
        return hasColor((ItemStack) var1);
    }

    public int bridge$getColor(ItemStackBridge var1) {
        return getColor((ItemStack) var1);
    }

    public ItemArmorBridge.ArmorMaterial bridge$getArmorMaterial() {
        return ItemArmorBridge.ArmorMaterial.values()[this.material.ordinal()];
    }
}