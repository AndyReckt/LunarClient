package com.moonsworth.lunar.client.websocket.auth;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.websocket.AuthenticatorWebSocket;

import javax.crypto.SecretKey;
import java.security.PublicKey;
import java.util.Base64;

public class CPacketEncryptionResponse extends AbstractAuthenticatorPacket {
    public final byte[] lIlIlIlIlIIlIIlIIllIIIIIl;
    public final byte[] IlllIIIIIIlllIlIIlllIlIIl;

    public CPacketEncryptionResponse(final SecretKey secretKey, final PublicKey publicKey, final byte[] array) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = Bridge.IlIlIlllllIlIIlIlIlllIlIl().bridge$encryptData(publicKey, secretKey.getEncoded());
        this.IlllIIIIIIlllIlIIlllIlIIl = Bridge.IlIlIlllllIlIIlIlIlllIlIl().bridge$encryptData(publicKey, array);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AuthenticatorWebSocket authenticatorWebSocket) {
    }

    @Override
    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return "CPacketEncryptionResponse";
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(final JsonObject jsonObject) {
        final Base64.Encoder urlEncoder = Base64.getUrlEncoder();
        jsonObject.addProperty("secretKey", new String(urlEncoder.encode(this.lIlIlIlIlIIlIIlIIllIIIIIl)));
        jsonObject.addProperty("publicKey", new String(urlEncoder.encode(this.IlllIIIIIIlllIlIIlllIlIIl)));
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll(JsonObject p0) {

    }
}
