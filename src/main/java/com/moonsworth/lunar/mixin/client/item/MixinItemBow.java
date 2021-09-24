package com.moonsworth.lunar.mixin.client.item;

import com.moonsworth.lunar.bridge.minecraft.item.ItemBowBridge;
import net.minecraft.item.ItemBow;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemBow.class)
public abstract class MixinItemBow implements ItemBowBridge {
    public MixinItemBow() {
    }
}
