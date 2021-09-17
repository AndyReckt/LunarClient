package com.moonsworth.lunar.client.websocket;

public enum Status {
    lIlIlIlIlIIlIIlIIllIIIIIl("Online"),
    IlllIIIIIIlllIlIIlllIlIIl("Away"),
    lIllIlIIIlIIIIIIIlllIlIll("Busy"),
    llIlllIIIllllIIlllIllIIIl("Offline");

    public final String llllIIlIIlIIlIIllIIlIIllI;

    Status(String var3) {
        this.llllIIlIIlIIlIIllIIlIIllI = var3;
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }
}