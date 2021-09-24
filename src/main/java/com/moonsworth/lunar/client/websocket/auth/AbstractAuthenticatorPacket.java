package com.moonsworth.lunar.client.websocket.auth;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AuthenticatorWebSocket;

import java.io.IOException;

public abstract class AbstractAuthenticatorPacket {

    public abstract void IlllIIIIIIlllIlIIlllIlIIl(final JsonObject p0) throws IOException;

    public abstract void lIllIlIIIlIIIIIIIlllIlIll(final JsonObject p0) throws IOException;

    public abstract void lIlIlIlIlIIlIIlIIllIIIIIl(final AuthenticatorWebSocket p0);

    public abstract String lIlIlIlIlIIlIIlIIllIIIIIl();
}
