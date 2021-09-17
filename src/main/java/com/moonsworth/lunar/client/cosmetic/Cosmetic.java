package com.moonsworth.lunar.client.cosmetic;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.cosmetic.iface.IlllIIIIIIlllIlIIlllIlIIl;

/**
 * @author Decencies
 * @since 11/07/2021 13:21
 */
public abstract class Cosmetic
        implements IlllIIIIIIlllIlIIlllIlIIl {
    public long lIlIlIlIlIIlIIlIIllIIIIIl;
    public String asas;
    public CosmeticType lIllIlIIIlIIIIIIIlllIlIll;
    public float llIlllIIIllllIIlllIllIIIl;
    public ResourceLocationBridge llllIIlIIlIIlIIllIIlIIllI;
    public ResourceLocationBridge IlIlIlllllIlIIlIlIlllIlIl;
    public boolean llIIIIIIIllIIllIlIllIIIIl;

    public Cosmetic(long l, String string, float f, String string2, CosmeticType cosmeticType, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = l;
        this.asas = string;
        this.llIlllIIIllllIIlllIllIIIl = f;
        this.lIllIlIIIlIIIIIIIlllIlIll = cosmeticType;
        this.llllIIlIIlIIlIIllIIlIIllI = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", string2);
        String[] stringArray = string2.split("/");
        this.IlIlIlllllIlIIlIlIlllIlIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar:cosmetics/wings/thumbnail/" + stringArray[stringArray.length - 1]);
        this.llIIIIIIIllIIllIlIllIIIIl = bl;
    }

    public long lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.asas;
    }

    public CosmeticType lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public float llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public ResourceLocationBridge llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public ResourceLocationBridge IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public boolean llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.llIIIIIIIllIIllIlIllIIIIl = bl;
    }
}
