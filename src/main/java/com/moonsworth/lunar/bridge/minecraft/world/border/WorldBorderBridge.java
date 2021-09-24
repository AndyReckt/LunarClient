package com.moonsworth.lunar.bridge.minecraft.world.border;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;

public interface WorldBorderBridge {
    double bridge$getClosestDistance(EntityBridge var1);

    double bridge$minX();

    double bridge$minZ();

    double bridge$maxX();

    double bridge$maxZ();
}
