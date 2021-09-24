package com.moonsworth.lunar.mixin.client.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemBucket.class)
public abstract class MixinItemBucket {
    public MixinItemBucket() {
    }

    public void impl$onItemRightClick(ItemStack var1, World var2, EntityPlayer var3, CallbackInfoReturnable var4) {
    }
}
