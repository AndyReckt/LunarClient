package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.util.MovementInputFromOptionsBridge;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovementInputFromOptions;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MovementInputFromOptions.class)
public abstract class MixinMovementInputFromOptions extends MovementInput implements MovementInputFromOptionsBridge {
}
