package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.entity.DataWatcherBridge;
import net.minecraft.entity.DataWatcher;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(DataWatcher.class)
public abstract class MixinDataWatcher implements DataWatcherBridge {
    @Shadow
    public abstract void updateObject(int var1, Object var2);

    public void bridge$updateObject(int var1, Object var2) {
        updateObject(var1, var2);
    }
}