package com.moonsworth.lunar.mixin.client;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.profiler.Profiler;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldClient.class)
public abstract class MixinWorldClient extends World {

    public MixinWorldClient(ISaveHandler var1, WorldInfo var2, WorldProvider var3, Profiler var4, boolean var5) {
        super(var1, var2, var3, var4, var5);
    }

    // todo sba
    public void impl$onEntityRemoved(Entity entity, CallbackInfo callbackInfo) {
        //WorldClientHook.onEntityRemoved(entity);
    }
}