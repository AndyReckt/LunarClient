package com.moonsworth.lunar.client.cosmetic;

public final class CosmeticIndexEntry {
    public final int lIlIlIlIlIIlIIlIIllIIIIIl;
    public final float IlllIIIIIIlllIlIIlllIlIIl;
    public final String lIllIlIIIlIIIIIIIlllIlIll;
    public final String llIlllIIIllllIIlllIllIIIl;
    public final String llllIIlIIlIIlIIllIIlIIllI;
    public final boolean IlIlIlllllIlIIlIlIlllIlIl;

    public CosmeticIndexEntry(String string) {
        String[] stringArray = string.split(",");
        this.lIlIlIlIlIIlIIlIIllIIIIIl = Integer.parseInt(stringArray[0]);
        this.IlllIIIIIIlllIlIIlllIlIIl = Float.parseFloat(stringArray[1]);
        this.lIllIlIIIlIIIIIIIlllIlIll = stringArray[2];
        this.llIlllIIIllllIIlllIllIIIl = stringArray[3];
        this.llllIIlIIlIIlIIllIIlIIllI = stringArray[4];
        this.IlIlIlllllIlIIlIlIlllIlIl = Boolean.parseBoolean(stringArray[5]);
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public float IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public String lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public String llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public String llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public boolean IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public String toString() {
        return "CosmeticIndexEntry(id=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", scale=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", resource=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ", name=" + this.llIlllIIIllllIIlllIllIIIl() + ", type=" + this.llllIIlIIlIIlIIllIIlIIllI() + ", animated=" + this.IlIlIlllllIlIIlIlIlllIlIl() + ")";
    }
}
