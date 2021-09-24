package com.moonsworth.lunar.mixin.client.item;

import com.moonsworth.lunar.bridge.minecraft.item.ItemSpadeBridge;
import net.minecraft.item.ItemSpade;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemSpade.class)
public abstract class MixinItemSpade implements ItemSpadeBridge {
    public MixinItemSpade() {
    }
}
