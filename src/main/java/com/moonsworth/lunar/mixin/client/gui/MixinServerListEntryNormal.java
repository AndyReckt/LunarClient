package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.ServerListEntryNormalBridge;
import net.minecraft.client.gui.ServerListEntryNormal;
import net.minecraft.client.multiplayer.ServerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerListEntryNormal.class)
public abstract class MixinServerListEntryNormal implements ServerListEntryNormalBridge {
    public MixinServerListEntryNormal() {
    }

    @Shadow
    public abstract ServerData getServerData();

    public void impl$drawEntry(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, CallbackInfo var9) {
    }
}