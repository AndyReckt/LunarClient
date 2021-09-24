package com.moonsworth.lunar.client.cosmetic;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.setting.BooleanSetting;

public enum CosmeticType {
    CLOAK("cloak", "Cloak", "icons/cosmetics/cloak-40x40.png", 40, 54, "lunar"),
    HAT("hat", "Hat", "icons/cosmetics/hat-40x40.png", 40, 40, "lunarhats"),
    BODYWEAR("bodywear", "Bodywear", "icons/cosmetics/bodywear-40x40.png", 40, 40, "lunar"),
    MASK("mask", "Mask", HAT, "icons/cosmetics/mask-28x28.png", 40, 40, "lunarmasks"),
    BANDANNA("bandanna", "Bandanna", HAT, "icons/cosmetics/bandana-28x28.png", 40, 40, "lunarbandannas"),
    WINGS("dragon_wings", "Wing", "icons/cosmetics/wing-40x40.png", 40, 64, "wings");

    public String llIIIIIIIllIIllIlIllIIIIl;
    public String lIIIllIllIIllIlllIlIIlllI;
    public CosmeticType IlllllIlIIIlIIlIIllIIlIll;
    public ResourceLocationBridge llIIlIlIIIllIlIlIlIIlIIll;
    public int llIIIlllIIlllIllllIlIllIl;
    public int lllllIllIllIllllIlIllllII;
    public String lIlIIIIIIlIIIllllIllIIlII;
    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI;

    CosmeticType(String var3, String var4, CosmeticType var5, String var6, int var7, int var8, String var9) {
        this.llIIIIIIIllIIllIlIllIIIIl = var3;
        this.lIIIllIllIIllIlllIlIIlllI = var4;
        this.IlllllIlIIIlIIlIIllIIlIll = var5;
        this.llIIlIlIIIllIlIlIlIIlIIll = Bridge.getInstance().initResourceLocation("lunar", var6);
        this.llIIIlllIIlllIllllIlIllIl = var7;
        this.lllllIllIllIllllIlIllllII = var8;
        this.lllIIIIIlllIIlIllIIlIIIlI = new BooleanSetting(var3, true);
        this.lIlIIIIIIlIIIllllIllIIlII = var9;
    }

    CosmeticType(String var3, String var4, String var5, int var6, int var7, String var8) {
        this(var3, var4, null, var5, var6, var7, var8);
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public CosmeticType lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public ResourceLocationBridge llIlllIIIllllIIlllIllIIIl() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public int llllIIlIIlIIlIIllIIlIIllI() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public int IlIlIlllllIlIIlIlIlllIlIl() {
        return this.lllllIllIllIllllIlIllllII;
    }

    public String llIIIIIIIllIIllIlIllIIIIl() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public BooleanSetting lIIIllIllIIllIlllIlIIlllI() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }
}