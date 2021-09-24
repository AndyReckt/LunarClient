package com.moonsworth.lunar.bridge.minecraft.item;

import java.util.Map;
import java.util.function.BiPredicate;

public interface ItemStackBridge {
    String bridge$getDisplayName();

    ItemBridge bridge$getItem();

    int bridge$getStackSize();

    void bridge$setStackSize(int var1);

    int bridge$getMaxDamage();

    int bridge$getItemDamage();

    boolean bridge$isItemDamaged();

    int bridge$getMaxStackSize();

    boolean bridge$isItemStackDamageableNoUnbr();

    int bridge$getRepairCost();

    boolean bridge$hasDisplayName();

    boolean bridge$isItemStackDamageable();

    void bridge$clearCustomName();

    void bridge$setItemDamage(int var1);

    void bridge$setStackDisplayName(String var1);

    ItemStackBridge bridge$copy();

    void bridge$setRepairCost(int var1);

    void bridge$setEnchantments(Map<EnchantmentBridge, Integer> var1);

    boolean bridge$isEmpty();

    lIlIlIlIlIIlIIlIIllIIIIIl bridge$getItemUseAction();

    boolean bridge$areItemsEqual(ItemStackBridge var1);

    boolean bridge$areItemsEqual(ItemStackBridge var1, BiPredicate var2);

    enum lIlIlIlIlIIlIIlIIllIIIIIl {
        lIlIlIlIlIIlIIlIIllIIIIIl,
        IlllIIIIIIlllIlIIlllIlIIl,
        lIllIlIIIlIIIIIIIlllIlIll,
        llIlllIIIllllIIlllIllIIIl,
        llllIIlIIlIIlIIllIIlIIllI,
        IlIlIlllllIlIIlIlIlllIlIl,
        llIIIIIIIllIIllIlIllIIIIl

    }
}