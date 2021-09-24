package com.moonsworth.lunar.mixin.client.resources.data;

import com.moonsworth.lunar.bridge.minecraft.client.resources.data.AnimationFrameBridge;

import net.minecraft.client.resources.data.AnimationFrame;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AnimationFrame.class)
public abstract class MixinAnimationFrame implements AnimationFrameBridge {

    @Final
    @Shadow
    private int frameTime;

    @Final
    @Shadow
    private int frameIndex;

    @Shadow
    public abstract boolean hasNoTime();

    public boolean bridge$hasNoTime() {
        return hasNoTime();
    }

    public int bridge$getFrameTime() {
        return frameTime;
    }

    public int bridge$getFrameIndex() {
        return frameIndex;
    }
}