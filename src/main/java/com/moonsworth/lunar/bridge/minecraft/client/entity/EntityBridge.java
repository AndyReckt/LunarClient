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
    boolean bridge$isSneaking();

    boolean bridge$isRiding();

    int bridge$getTicksExisted();

    WorldBridge bridge$getWorld();

    double bridge$getPosX();

    void bridge$setPosX(double var1);

    double bridge$getPosY();

    void bridge$setPosY(double var1);

    double bridge$getPosZ();

    void bridge$setPosZ(double var1);

    double bridge$getPreviousPosX();

    void bridge$setPreviousPosX(double var1);

    double bridge$getPreviousPosY();

    void bridge$setPreviousPosY(double var1);

    double bridge$getPreviousPosZ();

    void bridge$setPreviousPosZ(double var1);

    double bridge$getMotionX();

    void lIlIlIlIlIIlIIlIIllIIIIIl(double var1);

    double bridge$getMotionY();

    void bridge$setMotionY(double var1);

    double bridge$getMotionZ();

    void IlllIIIIIIlllIlIIlllIlIIl(double var1);

    double bridge$getRotationYaw();

    double bridge$getRotationPitch();

    void bridge$setRotationYaw(double var1);

    void bridge$setRotationPitch(double var1);

    double bridge$getPreviousRotationYaw();

    void bridge$setPreviousRotationYaw(double var1);

    double bridge$getPreviousRotationPitch();

    void bridge$setPreviousRotationPitch(double var1);

    UUID bridge$getUniqueID();

    AxisAlignedBBBridge bridge$getBoundingBox();

    AxisAlignedBBBridge bridge$getFrustumBoundingBox();

    boolean bridge$isOnGround();

    boolean bridge$isInvisibleTo(EntityPlayerBridge var1);

default double lIlIlIlIlIIlIIlIIllIIIIIl(EntityBridge entityBridge) {
        double d = this.bridge$getPosX() - entityBridge.bridge$getPosX();
        double d2 = this.bridge$getPosY() - entityBridge.bridge$getPosY();
        double d3 = this.bridge$getPosZ() - entityBridge.bridge$getPosZ();
        return d * d + d2 * d2 + d3 * d3;
    }

default double IlllIIIIIIlllIlIIlllIlIIl(EntityBridge entityBridge) {
        return Math.sqrt(this.lIlIlIlIlIIlIIlIIllIIIIIl(entityBridge));
    }

default double lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2, double d3) {
        double d4 = this.bridge$getPosX() - d;
        double d5 = this.bridge$getPosY() - d2;
        double d6 = this.bridge$getPosZ() - d3;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

default double IlllIIIIIIlllIlIIlllIlIIl(double d, double d2, double d3) {
        return Math.sqrt(this.lIlIlIlIlIIlIIlIIllIIIIIl(d, d2, d3));
    }

    int bridge$getEntityId();

    Vec3Bridge bridge$getLookAngle();

    int bridge$getDimension();

    void bridge$setDimension(int var1);

default String bridge$getDimensionName() {
        return "";
    }

    float bridge$getEyeHeight();

    EntityBridge bridge$getRidingEntity();

    float bridge$getFallDistance();

    boolean bridge$hitByEntity(EntityBridge var1);

    double bridge$lastTickX();

    double bridge$lastTickY();

    double bridge$lastTickZ();

    DataWatcherBridge bridge$getDataWatcher();

    int bridge$getBrightnessForRender(float var1);

    boolean bridge$isBurning();

    boolean bridge$isInvisible();

    float bridge$getWidth();

    boolean bridge$isCollidedHorizontally();
}
