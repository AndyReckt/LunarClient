package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.util.FoodStatsBridge;
import net.minecraft.util.FoodStats;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FoodStats.class)
public abstract class MixinFoodStatsz implements FoodStatsBridge {

    @Shadow
    public abstract float getSaturationLevel();

    @Shadow
    public abstract int getFoodLevel();

    public float bridge$getSaturationLevel() {
        return this.getSaturationLevel();
    }

    public float bridge$getFoodLevel() {
        return this.getFoodLevel();
    }
}
