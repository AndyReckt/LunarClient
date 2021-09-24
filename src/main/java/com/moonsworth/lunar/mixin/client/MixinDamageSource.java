package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.util.DamageSourceBridge;
import net.minecraft.util.DamageSource;
import org.spongepowered.asm.mixin.Mixin;

import static net.minecraft.util.DamageSource.generic;

@Mixin(DamageSource.class)
public abstract class MixinDamageSource implements DamageSourceBridge {

    public boolean isGeneric() {
        return (DamageSourceBridge) this == generic;
    }

}
