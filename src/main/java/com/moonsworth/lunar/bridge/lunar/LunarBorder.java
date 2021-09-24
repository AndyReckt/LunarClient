package com.moonsworth.lunar.bridge.lunar;

import com.moonsworth.lunar.bridge.minecraft.util.AxisAlignedBBBridge;
import com.moonsworth.lunar.bridge.minecraft.world.border.WorldBorderBridge;

import java.util.List;

public interface LunarBorder extends WorldBorderBridge {
    String getId();

    void update(double var1, double var3, double var5, double var7, int var9);

    void setCancelEntry(boolean var1);

    void setCancelExit(boolean var1);

    void setColor(int var1);

    boolean shouldRender();

default void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
    }

    boolean isCancelEntry();

    boolean contains(double var1, double var3);

    boolean isCancelExit();

    List<AxisAlignedBBBridge> getWalls();

    void setCanShrink(boolean var1);

    void bridge$setCenter(double var1, double var3);

    void setStaticBounds(AxisAlignedBBBridge var1);

    void bridge$setTransition(double var1);

    boolean allowsInteraction();

    int getColor();

    String getWorld();

    boolean isWorldBorder();
}