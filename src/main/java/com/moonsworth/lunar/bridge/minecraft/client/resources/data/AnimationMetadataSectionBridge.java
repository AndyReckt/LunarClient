package com.moonsworth.lunar.bridge.minecraft.client.resources.data;

import java.util.Set;

public interface AnimationMetadataSectionBridge
    extends IMetadataSectionBridge {
    int bridge$getFrameHeight();

    int bridge$getFrameWidth();

    int bridge$getFrameCount();

    int bridge$getFrameTime();

    boolean bridge$shouldInterpolate();

    AnimationFrameBridge bridge$getAnimationFrame(int var1);

    int bridge$getFrameTimeSingle(int var1);

    boolean bridge$hasTime(int var1);

    int bridge$getFrameIndex(int var1);

    Set bridge$getFrameIndexSet();
}
