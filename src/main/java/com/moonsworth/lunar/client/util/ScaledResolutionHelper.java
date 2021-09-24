package com.moonsworth.lunar.client.util;

import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;

public class ScaledResolutionHelper {
    public final double lIlIlIlIlIIlIIlIIllIIIIIl;
    public final double IlllIIIIIIlllIlIIlllIlIIl;
    public int lIllIlIIIlIIIIIIIlllIlIll;
    public int llIlllIIIllllIIlllIllIIIl;
    public int llllIIlIIlIIlIIllIIlIIllI;

    public ScaledResolutionHelper(MinecraftBridge minecraftBridge) {
        this.lIllIlIIIlIIIIIIIlllIlIll = minecraftBridge.bridge$displayWidth();
        this.llIlllIIIllllIIlllIllIIIl = minecraftBridge.bridge$displayHeight();
        this.llllIIlIIlIIlIIllIIlIIllI = 1;
        boolean bl = minecraftBridge.bridge$unicode();
        int n = minecraftBridge.bridge$getGuiScale();
        if (n == 0) {
            n = 1000;
        }
        while (this.llllIIlIIlIIlIIllIIlIIllI < n && this.lIllIlIIIlIIIIIIIlllIlIll / (this.llllIIlIIlIIlIIllIIlIIllI + 1) >= 320 && this.llIlllIIIllllIIlllIllIIIl / (this.llllIIlIIlIIlIIllIIlIIllI + 1) >= 240) {
            ++this.llllIIlIIlIIlIIllIIlIIllI;
        }
        if (bl && this.llllIIlIIlIIlIIllIIlIIllI % 2 != 0 && this.llllIIlIIlIIlIIllIIlIIllI != 1) {
            --this.llllIIlIIlIIlIIllIIlIIllI;
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl = (double)this.lIllIlIIIlIIIIIIIlllIlIll / (double)this.llllIIlIIlIIlIIllIIlIIllI;
        this.IlllIIIIIIlllIlIIlllIlIIl = (double)this.llIlllIIIllllIIlllIllIIIl / (double)this.llllIIlIIlIIlIIllIIlIIllI;
        this.lIllIlIIIlIIIIIIIlllIlIll = MathHelperUtil.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl);
        this.llIlllIIIllllIIlllIllIIIl = MathHelperUtil.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl);
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public double lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public double llIlllIIIllllIIlllIllIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public int llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }
}