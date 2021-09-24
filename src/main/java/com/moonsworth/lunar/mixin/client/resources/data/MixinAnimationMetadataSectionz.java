package com.moonsworth.lunar.mixin.client.resources.data;

import com.moonsworth.lunar.bridge.minecraft.client.resources.data.AnimationFrameBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.data.AnimationMetadataSectionBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.data.IMetadataSectionBridge;

import net.minecraft.client.resources.data.AnimationFrame;
import net.minecraft.client.resources.data.AnimationMetadataSection;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Set;

@Mixin(AnimationMetadataSection.class)
public abstract class MixinAnimationMetadataSectionz implements AnimationMetadataSectionBridge, IMetadataSectionBridge {

    @Final
    @Shadow
    private int frameHeight;

    @Final
    @Shadow
    private int frameWidth;

    @Final
    @Shadow
    private int frameTime;

    @Shadow
    public abstract int getFrameCount();

    @Shadow
    public abstract boolean isInterpolate();

    @Shadow
    protected abstract AnimationFrame getAnimationFrame(int var1);

    @Shadow
    public abstract int getFrameTimeSingle(int var1);

    @Shadow
    public abstract Set getFrameIndexSet();

    @Shadow
    public abstract boolean frameHasTime(int var1);

    @Shadow
    public abstract int getFrameIndex(int var1);

    public int bridge$getFrameHeight() {
        return frameHeight;
    }

    public int bridge$getFrameWidth() {
        return frameWidth;
    }

    public int bridge$getFrameCount() {
        return getFrameCount();
    }

    public int bridge$getFrameTime() {
        return frameTime;
    }

    public boolean bridge$shouldInterpolate() {
        return isInterpolate();
    }

    public AnimationFrameBridge bridge$getAnimationFrame(int var1) {
        return (AnimationFrameBridge) getAnimationFrame(var1);
    }

    public int bridge$getFrameTimeSingle(int var1) {
        return getFrameTimeSingle(var1);
    }

    public boolean bridge$hasTime(int var1) {
        return frameHasTime(var1);
    }

    public int bridge$getFrameIndex(int var1) {
        return getFrameIndex(var1);
    }

    public Set bridge$getFrameIndexSet() {
        return getFrameIndexSet();
    }
}