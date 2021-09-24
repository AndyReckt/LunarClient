package com.moonsworth.lunar.bridge.minecraft.util;

public interface Vec3Bridge {
    double bridge$xCoord();

    double bridge$yCoord();

    double bridge$zCoord();

    double bridge$lengthVector();

    double bridge$dotProduct(Vec3Bridge var1);

    Vec3Bridge bridge$normalize();

    Vec3Bridge bridge$crossProduct(Vec3Bridge var1);
}
