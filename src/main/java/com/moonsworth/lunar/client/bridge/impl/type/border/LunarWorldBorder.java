package com.moonsworth.lunar.client.bridge.impl.type.border;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.LunarBorder;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.util.AxisAlignedBBBridge;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.border.EnumBorderStatus;
import net.minecraft.world.border.IBorderListener;
import net.minecraft.world.border.WorldBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LunarWorldBorder extends WorldBorder implements LunarBorder {
    public final String world;
    public String id;
    public int color = (new Color(50, 50, 50)).getRGB();
    public boolean cancelExit;
    public boolean cancelEntry;
    public boolean canShrink;
    public boolean allowInteraction;
    public boolean worldBorder;
    public AxisAlignedBBBridge staticBounds;
    public List<AxisAlignedBBBridge> walls = new ArrayList<>();
    public static final int WALL_WIDTH = 5;
    public boolean wasInside;
    public boolean first = true;

    public LunarWorldBorder(String var1, String var2, int var3) {
        this.world = var2;
        this.id = var1;
        this.color = var3;
        this.addListener(new IBorderListener() {
            public void onSizeChanged(WorldBorder var1, double var2) {
                LunarWorldBorder.this.recalculateWalls(LunarWorldBorder.this.walls, var1.contains(Minecraft.getMinecraft().thePlayer.getPosition()));
            }

            public void onTransitionStarted(WorldBorder var1, double var2, double var4, long var6) {
            }

            public void onCenterChanged(WorldBorder var1, double var2, double var4) {
            }

            public void onWarningTimeChanged(WorldBorder var1, int var2) {
            }

            public void onWarningDistanceChanged(WorldBorder var1, int var2) {
            }

            public void onDamageAmountChanged(WorldBorder var1, double var2) {
            }

            public void onDamageBufferChanged(WorldBorder var1, double var2) {
            }
        });
    }

    public boolean isStatic() {
        return this.staticBounds != null;
    }

    public void setTransition(double var1, double var3, long var5) {
        Preconditions.checkArgument(!this.isStatic(), "Cannot transition static border");
        super.setTransition(var1, var3, var5);
    }

    public void bridge$setCenter(double var1, double var3) {
        this.setCenter(var1, var3);
    }

    public void bridge$setTransition(double var1) {
        this.setTransition(var1);
    }

    public double minX() {
        return this.isStatic() ? this.staticBounds.bridge$getMinX() : super.minX();
    }

    public double minZ() {
        return this.isStatic() ? this.staticBounds.bridge$getMinZ() : super.minZ();
    }

    public double maxX() {
        return this.isStatic() ? this.staticBounds.bridge$getMaxX() : super.maxX();
    }

    public double maxZ() {
        return this.isStatic() ? this.staticBounds.bridge$getMaxZ() : super.maxZ();
    }

    public List getWalls() {
        boolean var1 = this.contains(Minecraft.getMinecraft().thePlayer.getPosition());
        if (var1 && !this.cancelExit) {
            return ImmutableList.of();
        } else if (!var1 && !this.cancelEntry) {
            return ImmutableList.of();
        } else if (this.getStatus() != EnumBorderStatus.STATIONARY) {
            ArrayList<AxisAlignedBBBridge> var2 = new ArrayList<>();
            this.recalculateWalls(var2, var1);
            return var2;
        } else {
            if (this.first || var1 != this.wasInside) {
                this.recalculateWalls(this.walls, var1);
            }

            return this.walls;
        }
    }

    public boolean contains(double var1, double var3) {
        return this.contains(new BlockPos(var1, 100.0D, var3));
    }

    public void recalculateWalls(List<AxisAlignedBBBridge> var1, boolean var2) {
        var1.clear();
        if (var2) {
            var1.add((AxisAlignedBBBridge)(new AxisAlignedBB(this.minX() - 5.0D, -2.147483648E9D, this.minZ() - 5.0D, this.maxX() + 5.0D, 2.147483647E9D, this.minZ())));
            var1.add((AxisAlignedBBBridge)(new AxisAlignedBB(this.minX() - 5.0D, -2.147483648E9D, this.minZ() - 5.0D, this.minX(), 2.147483647E9D, this.maxZ() + 1.0D)));
            var1.add((AxisAlignedBBBridge)(new AxisAlignedBB(this.maxX(), -2.147483648E9D, this.minZ() - 5.0D, this.maxX() + 5.0D, 2.147483647E9D, this.maxZ() + 1.0D)));
            var1.add((AxisAlignedBBBridge)(new AxisAlignedBB(this.minX() - 5.0D, -2.147483648E9D, this.maxZ(), this.maxX() + 5.0D, 2.147483647E9D, this.maxZ() + 5.0D)));
        } else {
            var1.add((AxisAlignedBBBridge)(new AxisAlignedBB(this.minX(), -2.147483648E9D, this.minZ(), this.maxX(), 2.147483647E9D, this.minZ() + 5.0D)));
            var1.add((AxisAlignedBBBridge)(new AxisAlignedBB(this.minX(), -2.147483648E9D, this.minZ(), this.minX() + 5.0D, 2.147483647E9D, this.maxZ())));
            var1.add((AxisAlignedBBBridge)(new AxisAlignedBB(this.maxX() - 5.0D, -2.147483648E9D, this.minZ(), this.maxX(), 2.147483647E9D, this.maxZ())));
            var1.add((AxisAlignedBBBridge)(new AxisAlignedBB(this.minX(), -2.147483648E9D, this.maxZ() - 5.0D, this.maxX(), 2.147483647E9D, this.maxZ())));
        }

        this.wasInside = var2;
        this.first = false;
    }

    public boolean shouldRender() {
        return LunarClient.getInstance().lIlIlIlIlIIlIIlIIllIIIIIl(this.world);
    }

    public boolean allowsInteraction() {
        return this.allowInteraction;
    }

    public void update(double var1, double var3, double var5, double var7, int var9) {
        double var10 = var5 - var1;
        double var12 = var7 - var3;
        if (var9 == 0) {
            this.setTransition(var10 / 2.0D + var12 / 2.0D);
        } else {
            this.setTransition(this.getDiameter(), var10 / 2.0D + var12 / 2.0D, var9);
        }

    }

    public double bridge$getClosestDistance(EntityBridge var1) {
        return this.getClosestDistance((Entity)var1);
    }

    public double bridge$minX() {
        return this.minX();
    }

    public double bridge$minZ() {
        return this.minZ();
    }

    public double bridge$maxX() {
        return this.maxX();
    }

    public double bridge$maxZ() {
        return this.maxZ();
    }

    public String getWorld() {
        return this.world;
    }

    public String getId() {
        return this.id;
    }

    public int getColor() {
        return this.color;
    }

    public boolean isCancelExit() {
        return this.cancelExit;
    }

    public boolean isCancelEntry() {
        return this.cancelEntry;
    }

    public boolean isCanShrink() {
        return this.canShrink;
    }

    public boolean isAllowInteraction() {
        return this.allowInteraction;
    }

    public boolean isWorldBorder() {
        return this.worldBorder;
    }

    public AxisAlignedBBBridge getStaticBounds() {
        return this.staticBounds;
    }

    public boolean isWasInside() {
        return this.wasInside;
    }

    public boolean isFirst() {
        return this.first;
    }

    public void setColor(int var1) {
        this.color = var1;
    }

    public void setCancelExit(boolean var1) {
        this.cancelExit = var1;
    }

    public void setCancelEntry(boolean var1) {
        this.cancelEntry = var1;
    }

    public void setCanShrink(boolean var1) {
        this.canShrink = var1;
    }

    public void setAllowInteraction(boolean var1) {
        this.allowInteraction = var1;
    }

    public void setWorldBorder(boolean var1) {
        this.worldBorder = var1;
    }

    public void setStaticBounds(AxisAlignedBBBridge var1) {
        this.staticBounds = var1;
    }
}