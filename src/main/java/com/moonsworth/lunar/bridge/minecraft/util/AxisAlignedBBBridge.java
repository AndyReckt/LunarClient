package com.moonsworth.lunar.bridge.minecraft.util;

/**
 * @author Decencies
 * @since 10/07/2021 14:15
 */
public interface AxisAlignedBBBridge {
    double bridge$getMinX();

    double bridge$getMinY();

    double bridge$getMinZ();

    double bridge$getMaxX();

    double bridge$getMaxY();

    double bridge$getMaxZ();

    AxisAlignedBBBridge bridge$expand(double var1, double var3, double var5);

    AxisAlignedBBBridge bridge$offset(double var1, double var3, double var5);

    boolean bridge$intersectsWith(AxisAlignedBBBridge var1);
}