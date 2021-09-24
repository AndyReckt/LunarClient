package com.moonsworth.lunar.mixin.client.item;

import com.moonsworth.lunar.bridge.minecraft.item.ItemPotionBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Collection;
import java.util.List;

@Mixin(ItemPotion.class)
public abstract class MixinItemPotion implements ItemPotionBridge {
    public MixinItemPotion() {
    }

    @Shadow
    public abstract List getEffects(ItemStack var1);

    public Collection bridge$getEffects(ItemStackBridge var1) {
        return getEffects((ItemStack) var1);
    }
}
