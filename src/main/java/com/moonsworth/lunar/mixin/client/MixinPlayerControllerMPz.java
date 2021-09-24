package com.moonsworth.lunar.mixin.client;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerControllerMP.class)
public class MixinPlayerControllerMPz {
    public MixinPlayerControllerMPz() {
    }

    public void impl$clickBlock(BlockPos var1, EnumFacing var2, CallbackInfoReturnable var3) {
    }

    public void impl$onPlayerDestroyBlock(BlockPos var1, EnumFacing var2, CallbackInfoReturnable var3) {
    }

    public void impl$windowClick(int var1, int var2, int var3, int var4, EntityPlayer var5, CallbackInfoReturnable var6) {
    }
}
