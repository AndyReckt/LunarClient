package com.moonsworth.lunar.mixin.client.item;

import com.moonsworth.lunar.bridge.minecraft.item.ItemAxeBridge;
import net.minecraft.item.ItemAxe;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemAxe.class)
public abstract class MixinItemAxe implements ItemAxeBridge {
    public MixinItemAxe() {
    }
}
