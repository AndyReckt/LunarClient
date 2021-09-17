package com.moonsworth.lunar.bridge.minecraft.util;

/**
 * @author Decencies
 * @since 10/07/2021 14:15
 */
public interface AxisAlignedBBBridge {
    public double bridge$getMinX();

    public double bridge$getMinY();

    public double bridge$getMinZ();

    public double bridge$getMaxX();

    public double bridge$getMaxY();

    public double bridge$getMaxZ();

    public AxisAlignedBBBridge bridge$expand(double var1, double var3, double var5);

    public AxisAlignedBBBridge bridge$offset(double var1, double var3, double var5);

    public boolean bridge$intersectsWith(AxisAlignedBBBridge var1);
}