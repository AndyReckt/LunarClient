package com.moonsworth.lunar.bridge.lunar;

import com.moonsworth.lunar.bridge.minecraft.util.AxisAlignedBBBridge;
import com.moonsworth.lunar.bridge.minecraft.world.border.WorldBorderBridge;

import java.util.List;

public interface LunarBorder extends WorldBorderBridge {
    public String getId();

    public void update(double var1, double var3, double var5, double var7, int var9);

    public void setCancelEntry(boolean var1);

    public void setCancelExit(boolean var1);

    public void setColor(int var1);

    public boolean shouldRender();

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
    }

    public boolean isCancelEntry();

    public boolean contains(double var1, double var3);

    public boolean isCancelExit();

    public List<AxisAlignedBBBridge> getWalls();

    public void setCanShrink(boolean var1);

    public void bridge$setCenter(double var1, double var3);

    public void setStaticBounds(AxisAlignedBBBridge var1);

    public void bridge$setTransition(double var1);

    public boolean allowsInteraction();

    public int getColor();

    public String getWorld();

    public boolean isWorldBorder();
}