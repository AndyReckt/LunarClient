package com.moonsworth.lunar.mixin.client.item;

import com.moonsworth.lunar.bridge.minecraft.item.ItemBlockBridge;
import net.minecraft.item.ItemBlock;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ItemBlock.class)
public abstract class MixinItemBlock implements ItemBlockBridge {
    public MixinItemBlock() {
    }
}
