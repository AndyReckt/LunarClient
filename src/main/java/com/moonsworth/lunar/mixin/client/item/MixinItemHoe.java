package com.moonsworth.lunar.mixin.client.item;

import com.moonsworth.lunar.bridge.minecraft.item.ItemHoeBridge;
import net.minecraft.item.ItemHoe;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemHoe.class)
public abstract class MixinItemHoe implements ItemHoeBridge {
    public MixinItemHoe() {
    }
}
