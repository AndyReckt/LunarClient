package com.moonsworth.lunar.mixin.client.item;

import com.moonsworth.lunar.bridge.minecraft.item.EnchantmentBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.RegistryNamespaced;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Decencies
 * @since 14/07/2021 00:36
 */
@Mixin(Item.class)
public abstract class MixinItem implements ItemBridge {
    public MixinItem() {
    }

    @Shadow
    public abstract boolean hasEffect(ItemStack var1);

    @Shadow
    public abstract int getColorFromItemStack(ItemStack var1, int var2);

    @Shadow
    public abstract boolean getIsRepairable(ItemStack var1, ItemStack var2);

    @Shadow @Final public static RegistryNamespaced<ResourceLocation, Item> itemRegistry;

    public boolean bridge$isItemSkull() {
        return (ItemBridge) this instanceof ItemSkull;
    }

    public boolean bridge$isItemPotion() {
        return (ItemBridge) this instanceof ItemPotion;
    }

    public boolean bridge$isItemSoup() {
        return (ItemBridge) this instanceof ItemSoup;
    }

    public boolean bridge$hasEffect(ItemStackBridge var1) {
        return hasEffect((ItemStack) var1);
    }

    public Integer bridge$getColorFromItemStack(ItemStackBridge var1, int var2) {
        return getColorFromItemStack((ItemStack) var1, var2);
    }

    public boolean bridge$isRepairable(ItemStackBridge var1, ItemStackBridge var2) {
        return getIsRepairable((ItemStack) var1, (ItemStack) var2);
    }

    public Map bridge$getEnchantments(ItemStackBridge var1) {
        HashMap var2 = new HashMap();
        Iterator var3 = EnchantmentHelper.getEnchantments((ItemStack)var1).entrySet().iterator();

        while(var3.hasNext()) {
            Map.Entry var4 = (Map.Entry)var3.next();
            var2.put(Enchantment.getEnchantmentById((Integer)var4.getKey()), var4.getValue());
        }

        return var2;
    }

    public boolean bridge$isItemBlock() {
        return Block.getBlockFromItem((Item) (ItemBridge) this) != Blocks.air;
    }

    public String bridge$getRegistryName() {
        return itemRegistry.getNameForObject((Item) (ItemBridge) this).toString();
    }
}
