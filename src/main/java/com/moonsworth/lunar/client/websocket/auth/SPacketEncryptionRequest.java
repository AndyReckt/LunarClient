package com.moonsworth.lunar.client.websocket.auth;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.websocket.AuthenticatorWebSocket;

import java.security.PublicKey;
import java.util.Base64;

public class SPacketEncryptionRequest extends AbstractAuthenticatorPacket {
    public PublicKey lIlIlIlIlIIlIIlIIllIIIIIl;
    public byte[] IlllIIIIIIlllIlIIlllIlIIl;

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AuthenticatorWebSocket authenticatorWebSocket) {
        authenticatorWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    @Override
    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return "SPacketEncryptionRequest";
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(final JsonObject jsonObject) {
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final JsonObject jsonObject) {
        final Base64.Decoder urlDecoder = Base64.getUrlDecoder();
        this.lIlIlIlIlIIlIIlIIllIIIIIl = Bridge.IlIlIlllllIlIIlIlIlllIlIl().bridge$decodePublicKey(urlDecoder.decode(jsonObject.get("publicKey").getAsString()));
        this.IlllIIIIIIlllIlIIlllIlIIl = urlDecoder.decode(jsonObject.get("randomBytes").getAsString());
    }

    public PublicKey IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public byte[] lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}
