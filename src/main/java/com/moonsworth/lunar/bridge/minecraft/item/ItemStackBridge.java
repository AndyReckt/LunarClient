package com.moonsworth.lunar.bridge.minecraft.item;

import java.util.Map;
import java.util.function.BiPredicate;

public interface ItemStackBridge {
    public String bridge$getDisplayName();

    public ItemBridge bridge$getItem();

    public int bridge$getStackSize();

    public void bridge$setStackSize(int var1);

    public int bridge$getMaxDamage();

    public int bridge$getItemDamage();

    public boolean bridge$isItemDamaged();

    public int bridge$getMaxStackSize();

    public boolean bridge$isItemStackDamageableNoUnbr();

    public int bridge$getRepairCost();

    public boolean bridge$hasDisplayName();

    public boolean bridge$isItemStackDamageable();

    public void bridge$clearCustomName();

    public void bridge$setItemDamage(int var1);

    public void bridge$setStackDisplayName(String var1);

    public ItemStackBridge bridge$copy();

    public void bridge$setRepairCost(int var1);

    public void bridge$setEnchantments(Map var1);

    public boolean bridge$isEmpty();

    public lIlIlIlIlIIlIIlIIllIIIIIl bridge$getItemUseAction();

    public boolean bridge$areItemsEqual(ItemStackBridge var1);

    public boolean bridge$areItemsEqual(ItemStackBridge var1, BiPredicate var2);

    public static enum lIlIlIlIlIIlIIlIIllIIIIIl {
        lIlIlIlIlIIlIIlIIllIIIIIl,
        IlllIIIIIIlllIlIIlllIlIIl,
        lIllIlIIIlIIIIIIIlllIlIll,
        llIlllIIIllllIIlllIllIIIl,
        llllIIlIIlIIlIIllIIlIIllI,
        IlIlIlllllIlIIlIlIlllIlIl,
        llIIIIIIIllIIllIlIllIIIIl;

    }
}