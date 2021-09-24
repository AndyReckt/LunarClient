package com.moonsworth.lunar.mixin.client.item;

import com.moonsworth.lunar.bridge.minecraft.item.ItemSwordBridge;
import net.minecraft.item.ItemSword;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemSword.class)
public abstract class MixinItemSword implements ItemSwordBridge {
    public MixinItemSword() {
    }
}
