package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.WorldClientBridge;
import com.moonsworth.lunar.bridge.minecraft.scoreboard.ScoreboardBridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.network.ServerDisconnectEvent;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldClient.class)
public abstract class MixinWorldClientz extends World implements WorldClientBridge {

    public MixinWorldClientz(ISaveHandler var1, WorldInfo var2, WorldProvider var3, Profiler var4, boolean var5) {
        super(var1, var2, var3, var4, var5);
    }

    public ScoreboardBridge bridge$getScoreboard() {
        return (ScoreboardBridge) getScoreboard();
    }

    @Inject(method = "sendQuittingDisconnectingPacket", at = @At("HEAD"))
    public void impl$sendQuittingDisconnectingPacket(CallbackInfo var1) {
        EventBus.getInstance().call(new ServerDisconnectEvent());
    }
}
