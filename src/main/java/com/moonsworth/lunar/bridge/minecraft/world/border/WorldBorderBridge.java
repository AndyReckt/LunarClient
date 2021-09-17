package com.moonsworth.lunar.bridge.minecraft.world.border;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;

public interface WorldBorderBridge {
    public double bridge$getClosestDistance(EntityBridge var1);

    public double bridge$minX();

    public double bridge$minZ();

    public double bridge$maxX();

    public double bridge$maxZ();
}
 