package com.moonsworth.lunar.mixin.client.item;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.item.EnchantmentBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.event.Event;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.hud.ItemTooltipEvent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/**
 * @author Decencies
 * @since 13/07/2021 00:27
 */
@Mixin(ItemStack.class)
public abstract class MixinItemStack implements ItemStackBridge {

    @Shadow
    public int stackSize;
    @Shadow
    public Item item;

    @Shadow
    public abstract String getDisplayName();

    @Shadow
    public abstract Item getItem();

    @Shadow
    public abstract int getMaxDamage();

    @Shadow
    public abstract int getItemDamage();

    @Shadow
    public abstract boolean isItemDamaged();

    @Shadow
    public abstract int getMaxStackSize();

    @Shadow
    public abstract int getRepairCost();

    @Shadow
    public abstract boolean hasDisplayName();

    @Shadow
    public abstract boolean isItemStackDamageable();

    @Shadow
    public abstract void clearCustomName();

    @Shadow
    public abstract void setItemDamage(int var1);

    @Shadow
    public abstract ItemStack setStackDisplayName(String var1);

    @Shadow
    public abstract ItemStack copy();

    @Shadow
    public abstract void setRepairCost(int var1);

    @Shadow
    public abstract boolean isItemEqual(ItemStack var1);

    @Shadow
    public abstract EnumAction getItemUseAction();

    @Shadow
    public abstract void updateAnimation(World var1, Entity var2, int var3, boolean var4);

    @Shadow public static boolean areItemsEqual(ItemStack stackA, ItemStack stackB) {
        return false;
    }

    public String bridge$getDisplayName() {
        return this.getDisplayName();
    }

    public ItemBridge bridge$getItem() {
        return (ItemBridge) this.getItem();
    }

    public int bridge$getStackSize() {
        return this.stackSize;
    }

    public int bridge$getMaxDamage() {
        return this.getMaxDamage();
    }

    public boolean bridge$isItemDamaged() {
        return this.hahpsehhseepsphshsehepehe();
    }

    public int bridge$getItemDamage() {
        return this.getItemDamage();
    }

    public int bridge$getMaxStackSize() {
        return this.getMaxStackSize();
    }

    public boolean bridge$isItemStackDamageableNoUnbr() {
        return this.item != null && this.item.getMaxDamage() > 0;
    }

    public int bridge$getRepairCost() {
        return this.getRepairCost();
    }

    public boolean bridge$hasDisplayName() {
        return this.hasDisplayName();
    }

    public boolean bridge$isItemStackDamageable() {
        return this.isItemStackDamageable();
    }

    public void bridge$clearCustomName() {
        this.clearCustomName();
    }

    public void bridge$setItemDamage(int var1) {
        this.setItemDamage(var1);
    }

    public void bridge$setStackDisplayName(String var1) {
        this.setStackDisplayName(var1);
    }

    public ItemStackBridge bridge$copy() {
        return (ItemStackBridge) this.copy();
    }

    public void bridge$setRepairCost(int var1) {
        this.setRepairCost(var1);
    }

    public void bridge$setEnchantments(Map<EnchantmentBridge, Integer> var1) {
        EnchantmentHelper.setEnchantments(var1.entrySet().stream()
                                          .map((var0) -> new AbstractMap.SimpleEntry<>(((Enchantment) var0.getKey()).effectId, var0.getValue()))
                                          .collect(Collectors.toMap(k ->  k.getKey(), v -> v.getValue())),
                                          (ItemStack) (ItemStackBridge) this);
    }

    public boolean bridge$isEmpty() {
        return this.isItemEqual((ItemStack) LunarClient.emptyItemStack);
    }

    public ItemStackBridge.lIlIlIlIlIIlIIlIIllIIIIIl bridge$getItemUseAction() {
        return ItemStackBridge.lIlIlIlIlIIlIIlIIllIIIIIl.values()[this.getItemUseAction().ordinal()];
    }

    public boolean bridge$areItemsEqual(ItemStackBridge var1) {
        return areItemsEqual((ItemStack) ((ItemStackBridge) this), (ItemStack) var1);
    }

    public boolean bridge$areItemsEqual(ItemStackBridge var1, BiPredicate var2) {
        return var2.test(this, var1);
    }

    public void bridge$setStackSize(int var1) {
        this.stackSize = var1;
    }

    public void handler$zce000$impl$getTooltip(EntityPlayer var1, boolean var2, CallbackInfoReturnable var3) {
        ItemTooltipEvent var4 = new ItemTooltipEvent((EntityPlayerBridge) var1, this, (List) var3.getReturnValue(), var2);
        EventBus.getInstance().call((Event) var4);
    }

    public boolean hahpsehhseepsphshsehepehe() {
        return this.isItemDamaged();//ItemHook.isItemDamaged(this) ? true : this.isItemDamaged();
    }

}
