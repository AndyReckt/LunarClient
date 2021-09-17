package com.moonsworth.lunar.bridge.minecraft.util;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;

public interface MovingObjectPositionBridge {
    public EntityBridge bridge$getEntityHit();

    public boolean bridge$isTypeOfHit(MovingObjectPosition var1);

    public void bridge$border();

    public boolean bridge$isBorder();
}
 