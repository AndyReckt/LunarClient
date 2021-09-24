package com.moonsworth.lunar.mixin.client.entity;

import com.moonsworth.lunar.bridge.minecraft.client.entity.DataWatcherBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.AxisAlignedBBBridge;
import com.moonsworth.lunar.bridge.minecraft.util.Vec3Bridge;
import com.moonsworth.lunar.bridge.minecraft.world.WorldBridge;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(Entity.class)
public abstract class MixinEntityz implements EntityBridge, ICommandSender {
    // @Shadow
    public AxisAlignedBB frustumBoundingBox;
    @Shadow
    public int ticksExisted;
    @Shadow
    public World worldObj;
    @Shadow
    public double posX;
    @Shadow
    public double posY;
    @Shadow
    public double posZ;
    @Shadow
    public double prevPosX;
    @Shadow
    public double prevPosY;
    @Shadow
    public double motionX;
    @Shadow
    public double motionY;
    @Shadow
    public double motionZ;
    @Shadow
    public float rotationYaw;
    @Shadow
    public float rotationPitch;
    @Shadow
    public float prevRotationYaw;
    @Shadow
    public float prevRotationPitch;
    @Shadow
    public UUID entityUniqueID;
    @Shadow
    public AxisAlignedBB boundingBox;
    @Shadow
    public boolean onGround;
    @Shadow
    public int dimension;
    @Shadow
    public double lastTickPosX;
    @Shadow
    public double lastTickPosY;
    @Shadow
    public double lastTickPosZ;
    @Shadow
    public Entity ridingEntity;
    @Shadow
    public float fallDistance;
    @Shadow
    public double prevPosZ;
    @Shadow
    public float width;
    @Shadow
    public float height;
    @Shadow
    public boolean isCollidedHorizontally;

    public MixinEntityz() {
    }

    @Shadow
    public abstract void setAngles(float var1, float var2);

    @Shadow
    public abstract boolean isInvisibleToPlayer(EntityPlayer var1);

    @Shadow
    public abstract boolean isSneaking();

    @Shadow
    public abstract int getEntityId();

    @Shadow
    public abstract Vec3 getLookVec();

    @Shadow
    public abstract boolean isRiding();

    @Shadow
    public abstract float getEyeHeight();

    @Shadow
    public abstract boolean hitByEntity(Entity var1);

    @Shadow
    public abstract DataWatcher getDataWatcher();

    @Shadow
    public abstract boolean isInvisible();

    @Shadow
    public abstract boolean isInWater();

    @Shadow
    public abstract boolean isBurning();

    @Shadow
    public abstract int getBrightnessForRender(float var1);

    @Shadow public abstract UUID getUniqueID();

    @Shadow protected DataWatcher dataWatcher;

    @Shadow public double renderDistanceWeight;

    @Shadow protected boolean inWater;

    public void impl$stopAnimatingWhenSneaking(boolean var1, CallbackInfo var2) {
    }

    public boolean isWet() {
        return this.inWater;
    }

    public void impl$setFrustumBoundingBox(AxisAlignedBB var1, CallbackInfo var2) {
    }

    public boolean bridge$isSneaking() {
        return this.isSneaking();
    }

    public boolean bridge$isRiding() {
        return this.isRiding();
    }

    public int bridge$getTicksExisted() {
        return this.ticksExisted;
    }

    public WorldBridge bridge$getWorld() {
        return (WorldBridge) this.worldObj;
    }

    public double bridge$getPosX() {
        return this.posX;
    }

    public double bridge$getPosY() {
        return this.posY;
    }

    public double bridge$getPosZ() {
        return this.posZ;
    }

    public double bridge$getPreviousPosX() {
        return this.prevPosX;
    }

    public double bridge$getPreviousPosY() {
        return this.prevPosY;
    }

    public double bridge$getPreviousPosZ() {
        return this.prevPosZ;
    }

    public void bridge$setPosX(double var1) {
        this.posX = var1;
    }

    public void bridge$setPosY(double var1) {
        this.posY = var1;
    }

    public void bridge$setPosZ(double var1) {
        this.posZ = var1;
    }

    public void bridge$setPreviousPosX(double var1) {
        this.prevPosX = var1;
    }

    public void bridge$setPreviousPosY(double var1) {
        this.prevPosY = var1;
    }

    public void bridge$setPreviousPosZ(double var1) {
        this.prevPosZ = var1;
    }

    public double bridge$getMotionX() {
        return this.motionX;
    }

    public double bridge$getMotionY() {
        return this.motionY;
    }

    public void bridge$setMotionY(double var1) {
        this.motionY = var1;
    }

    public double bridge$getMotionZ() {
        return this.motionZ;
    }

    public double bridge$getRotationYaw() {
        return this.rotationYaw;
    }

    public double bridge$getRotationPitch() {
        return this.rotationPitch;
    }

    public void bridge$setRotationPitch(double var1) {
        this.rotationPitch = (float) var1;
    }

    public void bridge$setRotationYaw(double var1) {
        this.rotationYaw = (float) var1;
    }

    public double bridge$getPreviousRotationYaw() {
        return this.prevRotationYaw;
    }

    public double bridge$getPreviousRotationPitch() {
        return this.prevRotationPitch;
    }

    public UUID bridge$getUniqueID() {
        return this.getUniqueID();
    }

    public AxisAlignedBBBridge bridge$getBoundingBox() {
        return (AxisAlignedBBBridge) this.boundingBox;
    }

    public boolean bridge$isOnGround() {
        return this.onGround;
    }

    public AxisAlignedBBBridge bridge$getFrustumBoundingBox() {
        return (AxisAlignedBBBridge) this.frustumBoundingBox;
    }

    public boolean bridge$isInvisibleTo(EntityPlayerBridge var1) {
        return this.isInvisibleToPlayer((EntityPlayer) var1);
    }

    public int bridge$getEntityId() {
        return this.getEntityId();
    }

    public Vec3Bridge bridge$getLookAngle() {
        return (Vec3Bridge) getLookVec();
    }

    public int bridge$getDimension() {
        return this.dimension;
    }

    public void bridge$setDimension(int var1) {
        this.dimension = var1;
    }

    public String bridge$getDimensionName() {
        return this.worldObj.getWorldInfo().getWorldName();
    }

    public float bridge$getEyeHeight() {
        return this.getEyeHeight();
    }

    public EntityBridge bridge$getRidingEntity() {
        return (EntityBridge) this.ridingEntity;
    }

    public float bridge$getFallDistance() {
        return this.fallDistance;
    }

    public boolean bridge$hitByEntity(EntityBridge var1) {
        return this.hitByEntity((Entity) var1);
    }

    public double bridge$lastTickX() {
        return this.lastTickPosX;
    }

    public double bridge$lastTickY() {
        return this.lastTickPosY;
    }

    public double bridge$lastTickZ() {
        return this.lastTickPosZ;
    }

    public DataWatcherBridge bridge$getDataWatcher() {
        return (DataWatcherBridge) this.dataWatcher;
    }

    public boolean bridge$isBurning() {
        return this.isBurning();
    }

    public int bridge$getBrightnessForRender(float var1) {
        return this.getBrightnessForRender(var1);
    }

    public void bridge$setPreviousRotationPitch(double var1) {
        this.prevRotationPitch = (float) var1;
    }

    public void bridge$setPreviousRotationYaw(double var1) {
        this.prevRotationYaw = (float) var1;
    }

    public boolean bridge$isInvisible() {
        return this.isInvisible();
    }

    public float bridge$getWidth() {
        return this.width;
    }

    public boolean bridge$isCollidedHorizontally() {
        return this.isCollidedHorizontally;
    }
}