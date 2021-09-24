package com.moonsworth.lunar.bridge.minecraft.client.entity;

import com.moonsworth.lunar.bridge.minecraft.client.network.NetHandlerPlayClientBridge;
import com.moonsworth.lunar.bridge.minecraft.util.MovementInputBridge;

import java.util.Optional;

/**
 * @author Decencies
 * @since 10/07/2021 14:10
 */
public interface EntityPlayerSPBridge extends AbstractClientPlayerBridge {
    NetHandlerPlayClientBridge bridge$getSendQueue();

    default void lIlIlIlIlIIlIIlIIllIIIIIl(String string, float f, float f2) {
        this.bridge$getWorld().bridge$playSound(this.bridge$getPosX(), this.bridge$getPosX(), this.bridge$getPosZ(), string, f, f2, false);
    }

    Optional<String> bridge$getClientBrand();

    void bridge$sendChatMessage(String var1);

    MovementInputBridge bridge$getMovementInput();

    void bridge$onCriticalHit(EntityBridge var1);

    void bridge$setMovementInput(MovementInputBridge var1);

    @Override boolean bridge$isSprinting();

    void bridge$setSprinting(boolean var1);

    boolean bridge$isRidingHorse();

    void bridge$playPortalSound();

    void bridge$sendRidingJumpPacket();

    int bridge$getSprintingTicksLeft();

    void bridge$setSprintingTicksLeft(int var1);

    int bridge$getSprintToggleTimer();

    void bridge$setSprintToggleTimer(int var1);

    float bridge$getPrevTimeInPortal();

    void bridge$setPrevTimeInPortal(float var1);

    float bridge$getTimeInPortal();

    void bridge$setTimeInPortal(float var1);

    void bridge$setInPortal(boolean var1);

    int bridge$getTimeUntilPortal();

    void bridge$setTimeUntilPortal(int var1);

    void bridge$pushOutOfBlocks(double var1, double var3, double var5);

    void bridge$sendPlayerAbilities();

    void bridge$setHorseJumpPowerCounter(int var1);

    int bridge$getHorseJumpPowerCounter();

    void bridge$setHorseJumpPower(float var1);

    float bridge$getHorseJumpPower();

    default float lIlIlIlIlIIlIIlIIllIIIIIl() {
        return 0.0f;
    }

    default void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
    }
}
