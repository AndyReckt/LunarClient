package com.moonsworth.lunar.client.bridge;

public enum MinecraftVersion {
    lIlIlIlIlIIlIIlIIllIIIIIl("1.7.10"),
    IlllIIIIIIlllIlIIlllIlIIl("1.8.9"),
    lIllIlIIIlIIIIIIIlllIlIll("1.12.2"),
    llIlllIIIllllIIlllIllIIIl("1.15.2"),
    llllIIlIIlIIlIIllIIlIIllI("1.16.5");

    public final String IlIlIlllllIlIIlIlIlllIlIl;

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this == llIlllIIIllllIIlllIllIIIl || this == llllIIlIIlIIlIIllIIlIIllI;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this == lIlIlIlIlIIlIIlIIllIIIIIl || this == IlllIIIIIIlllIlIIlllIlIIl || this == lIllIlIIIlIIIIIIIlllIlIll;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return this == llIlllIIIllllIIlllIllIIIl || this == llllIIlIIlIIlIIllIIlIIllI;
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this == lIlIlIlIlIIlIIlIIllIIIIIl || this == IlllIIIIIIlllIlIIlllIlIIl;
    }

    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return this.ordinal() == values().length - 1;
    }

    public String IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    MinecraftVersion(String var3) {
        this.IlIlIlllllIlIIlIlIlllIlIl = var3;
    }
}