package com.moonsworth.lunar.bridge.minecraft.client.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.AxisAlignedBBBridge;
import com.moonsworth.lunar.bridge.minecraft.util.Vec3Bridge;
import com.moonsworth.lunar.bridge.minecraft.world.WorldBridge;

import java.util.UUID;

/**
 * @author Decencies
 * @since 10/07/2021 14:12
 */
public interface EntityBridge {
    public boolean bridge$isSneaking();

    public boolean bridge$isRiding();

    public int bridge$getTicksExisted();

    public WorldBridge bridge$getWorld();

    public double bridge$getPosX();

    public void bridge$setPosX(double var1);

    public double bridge$getPosY();

    public void bridge$setPosY(double var1);

    public double bridge$getPosZ();

    public void bridge$setPosZ(double var1);

    public double bridge$getPreviousPosX();

    public void bridge$setPreviousPosX(double var1);

    public double bridge$getPreviousPosY();

    public void bridge$setPreviousPosY(double var1);

    public double bridge$getPreviousPosZ();

    public void bridge$setPreviousPosZ(double var1);

    public double bridge$getMotionX();

    public void lIlIlIlIlIIlIIlIIllIIIIIl(double var1);

    public double bridge$getMotionY();

    public void bridge$setMotionY(double var1);

    public double bridge$getMotionZ();

    public void IlllIIIIIIlllIlIIlllIlIIl(double var1);

    public double bridge$getRotationYaw();

    public double bridge$getRotationPitch();

    public void bridge$setRotationYaw(double var1);

    public void bridge$setRotationPitch(double var1);

    public double bridge$getPreviousRotationYaw();

    public void bridge$setPreviousRotationYaw(double var1);

    public double bridge$getPreviousRotationPitch();

    public void bridge$setPreviousRotationPitch(double var1);

    public UUID bridge$getUniqueID();

    public AxisAlignedBBBridge bridge$getBoundingBox();

    public AxisAlignedBBBridge bridge$getFrustumBoundingBox();

    public boolean bridge$isOnGround();

    public boolean bridge$isInvisibleTo(EntityPlayerBridge var1);

    default public double lIlIlIlIlIIlIIlIIllIIIIIl(EntityBridge entityBridge) {
        double d = this.bridge$getPosX() - entityBridge.bridge$getPosX();
        double d2 = this.bridge$getPosY() - entityBridge.bridge$getPosY();
        double d3 = this.bridge$getPosZ() - entityBridge.bridge$getPosZ();
        return d * d + d2 * d2 + d3 * d3;
    }

    default public double IlllIIIIIIlllIlIIlllIlIIl(EntityBridge entityBridge) {
        return Math.sqrt(this.lIlIlIlIlIIlIIlIIllIIIIIl(entityBridge));
    }

    default public double lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2, double d3) {
        double d4 = this.bridge$getPosX() - d;
        double d5 = this.bridge$getPosY() - d2;
        double d6 = this.bridge$getPosZ() - d3;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    default public double IlllIIIIIIlllIlIIlllIlIIl(double d, double d2, double d3) {
        return Math.sqrt(this.lIlIlIlIlIIlIIlIIllIIIIIl(d, d2, d3));
    }

    public int bridge$getEntityId();

    public Vec3Bridge bridge$getLookAngle();

    public int bridge$getDimension();

    public void bridge$setDimension(int var1);

    default public String bridge$getDimensionName() {
        return "";
    }

    public float bridge$getEyeHeight();

    public EntityBridge bridge$getRidingEntity();

    public float bridge$getFallDistance();

    public boolean bridge$hitByEntity(EntityBridge var1);

    public double bridge$lastTickX();

    public double bridge$lastTickY();

    public double bridge$lastTickZ();

    public DataWatcherBridge bridge$getDataWatcher();

    public int bridge$getBrightnessForRender(float var1);

    public boolean bridge$isBurning();

    public boolean bridge$isInvisible();

    public float bridge$getWidth();

    public boolean bridge$isCollidedHorizontally();
}
