package com.moonsworth.lunar.client.websocket;

public enum Status {
    ONLINE("Online"),
    AWAY("Away"),
    BUSY("Busy"),
    OFFLINE("Offline");

    public final String label;

    Status(final String label) {
        this.label = label;
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.label;
    }
}