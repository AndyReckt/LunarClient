package com.moonsworth.lunar.bridge.minecraft.util;

public interface MovementInputBridge {
    public float bridge$getStrafeSpeed();

    public float bridge$getForwardSpeed();

    public boolean bridge$isSneaking();

    public boolean bridge$isJumping();

    default public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    public void bridge$setMoveForward(float var1);

    public void bridge$setMoveStrafe(float var1);

    public void bridge$setJump(boolean var1);

    public void bridge$setSneak(boolean var1);

    default public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return false;
    }

    default public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    default public boolean llIlllIIIllllIIlllIllIIIl() {
        return false;
    }

    default public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return false;
    }

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
    }

    default public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
    }

    default public void lIllIlIIIlIIIIIIIlllIlIll(boolean bl) {
    }

    default public void llIlllIIIllllIIlllIllIIIl(boolean bl) {
    }
}