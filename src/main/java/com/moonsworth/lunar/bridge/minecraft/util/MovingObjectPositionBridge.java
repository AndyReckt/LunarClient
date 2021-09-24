package com.moonsworth.lunar.bridge.minecraft.util;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;

public interface MovingObjectPositionBridge {
    EntityBridge bridge$getEntityHit();

    boolean bridge$isTypeOfHit(MovingObjectPosition var1);

    void bridge$border();

    boolean bridge$isBorder();
}
