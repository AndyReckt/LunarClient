package com.moonsworth.lunar.bridge.minecraft.client.entity;

import com.moonsworth.lunar.bridge.minecraft.client.network.NetHandlerPlayClientBridge;
import com.moonsworth.lunar.bridge.minecraft.util.MovementInputBridge;

import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 14:10
 */
public interface EntityPlayerSPBridge extends AbstractClientPlayerBridge {
    public NetHandlerPlayClientBridge bridge$getSendQueue();

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(String string, float f, float f2) {
        this.bridge$getWorld().bridge$playSound(this.bridge$getPosX(), this.bridge$getPosX(), this.bridge$getPosZ(), string, f, f2, false);
    }

    public Optional<String> bridge$getClientBrand();

    public void bridge$sendChatMessage(String var1);

    public MovementInputBridge bridge$getMovementInput();

    public void bridge$onCriticalHit(EntityBridge var1);

    public void bridge$setMovementInput(MovementInputBridge var1);

    @Override
    public boolean bridge$isSprinting();

    public void bridge$setSprinting(boolean var1);

    public boolean bridge$isRidingHorse();

    public void bridge$playPortalSound();

    public void bridge$sendRidingJumpPacket();

    public int bridge$getSprintingTicksLeft();

    public void bridge$setSprintingTicksLeft(int var1);

    public int bridge$getSprintToggleTimer();

    public void bridge$setSprintToggleTimer(int var1);

    public float bridge$getPrevTimeInPortal();

    public void bridge$setPrevTimeInPortal(float var1);

    public float bridge$getTimeInPortal();

    public void bridge$setTimeInPortal(float var1);

    public void bridge$setInPortal(boolean var1);

    public int bridge$getTimeUntilPortal();

    public void bridge$setTimeUntilPortal(int var1);

    public void bridge$pushOutOfBlocks(double var1, double var3, double var5);

    public void bridge$sendPlayerAbilities();

    public void bridge$setHorseJumpPowerCounter(int var1);

    public int bridge$getHorseJumpPowerCounter();

    public void bridge$setHorseJumpPower(float var1);

    public float bridge$getHorseJumpPower();

    default public float lIlIlIlIlIIlIIlIIllIIIIIl() {
        return 0.0f;
    }

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
    }
}
