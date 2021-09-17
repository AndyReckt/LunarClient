package com.moonsworth.lunar.bridge.minecraft.client.resources.data;

import java.util.Set;

public interface AnimationMetadataSectionBridge
extends IMetadataSectionBridge {
    public int bridge$getFrameHeight();

    public int bridge$getFrameWidth();

    public int bridge$getFrameCount();

    public int bridge$getFrameTime();

    public boolean bridge$shouldInterpolate();

    public AnimationFrameBridge bridge$getAnimationFrame(int var1);

    public int bridge$getFrameTimeSingle(int var1);

    public boolean bridge$hasTime(int var1);

    public int bridge$getFrameIndex(int var1);

    public Set bridge$getFrameIndexSet();
}
 