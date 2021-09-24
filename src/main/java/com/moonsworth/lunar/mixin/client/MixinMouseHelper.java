package com.moonsworth.lunar.mixin.client;

import net.minecraft.util.MouseHelper;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MouseHelper.class)
public abstract class MixinMouseHelper {
    public MixinMouseHelper() {
    }

    public void impl$ungrabMouseCursor(int var1, int var2) {
    }
}