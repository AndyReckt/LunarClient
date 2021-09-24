package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.ServerDataBridge;
import com.moonsworth.lunar.bridge.minecraft.client.network.OldServerPingerBridge;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.OldServerPinger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(OldServerPinger.class)
public abstract class MixinOldServerPinger implements OldServerPingerBridge {
    @Shadow
    public abstract void ping(ServerData var1);

    public void bridge$ping(ServerDataBridge var1) {
        ping((ServerData) var1);
    }
}