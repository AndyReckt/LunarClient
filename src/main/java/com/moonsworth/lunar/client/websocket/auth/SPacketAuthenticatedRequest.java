package com.moonsworth.lunar.client.websocket.auth;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.websocket.AuthenticatorWebSocket;

public class SPacketAuthenticatedRequest extends AbstractAuthenticatorPacket {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AuthenticatorWebSocket authenticatorWebSocket) {
        authenticatorWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    @Override
    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return "SPacketAuthenticatedRequest";
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(final JsonObject jsonObject) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = jsonObject.get("jwtKey").getAsString();
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll(JsonObject p0) {

    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
