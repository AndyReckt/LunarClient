package com.moonsworth.lunar.mixin.client.item;

import com.moonsworth.lunar.bridge.minecraft.item.ItemPickaxeBridge;
import net.minecraft.item.ItemPickaxe;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemPickaxe.class)
public abstract class MixinItemPickaxe implements ItemPickaxeBridge {
    public MixinItemPickaxe() {
    }
}
