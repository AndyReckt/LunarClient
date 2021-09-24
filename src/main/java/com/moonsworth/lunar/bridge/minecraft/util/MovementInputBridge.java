package com.moonsworth.lunar.bridge.minecraft.util;

public interface MovementInputBridge {
    float bridge$getStrafeSpeed();

    float bridge$getForwardSpeed();

    boolean bridge$isSneaking();

    boolean bridge$isJumping();

    default void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    void bridge$setMoveForward(float var1);

    void bridge$setMoveStrafe(float var1);

    void bridge$setJump(boolean var1);

    void bridge$setSneak(boolean var1);

    default boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return false;
    }

    default boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    default boolean llIlllIIIllllIIlllIllIIIl() {
        return false;
    }

    default boolean llllIIlIIlIIlIIllIIlIIllI() {
        return false;
    }

    default void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
    }

    default void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
    }

    default void lIllIlIIIlIIIIIIIlllIlIll(boolean bl) {
    }

    default void llIlllIIIllllIIlllIllIIIl(boolean bl) {
    }
}