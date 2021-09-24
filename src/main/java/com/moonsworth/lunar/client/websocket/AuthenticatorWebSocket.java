package com.moonsworth.lunar.client.websocket;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import com.mojang.authlib.exceptions.InvalidCredentialsException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.UsedEnum;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.notification.NotificationType;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.websocket.auth.AbstractAuthenticatorPacket;
import com.moonsworth.lunar.client.websocket.auth.CPacketEncryptionResponse;
import com.moonsworth.lunar.client.websocket.auth.SPacketAuthenticatedRequest;
import com.moonsworth.lunar.client.websocket.auth.SPacketEncryptionRequest;
import com.moonsworth.lunar.client.websocket.packet.AbstractWebSocketPacket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.math.BigInteger;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class AuthenticatorWebSocket extends WebSocketClient implements llIlllIIIllllIIlllIllIIIl {
    public final Consumer<String> lIlIlIlIlIIlIIlIIllIIIIIl;
    public boolean IlllIIIIIIlllIlIIlllIlIIl;

    public AuthenticatorWebSocket(final Map map, final Consumer<String> lIlIlIlIlIIlIIlIIllIIIIIl) throws URISyntaxException {
        super(new URI("wss://authenticator.lunarclientprod.com"), new Draft_6455(), map, 30000);
        this.IlllIIIIIIlllIlIIlllIlIIl = false;
        LunarLogger.info("Authentication", "Instantiate");
        this.lIlIlIlIlIIlIIlIIllIIIIIl = lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void onOpen(final ServerHandshake serverHandshake) {
    }

    public void onMessage(final String s) {
    }

    public void onMessage(final ByteBuffer byteBuffer) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(new JsonParser().parse(new String(byteBuffer.array())).getAsJsonObject());
    }

    public void onClose(final int n, final String s, final boolean b) {
        LunarLogger.info("Auth", "Connection closed (%d, \"%s\")", n, s);
        if (this.IlllIIIIIIlllIlIIlllIlIIl) {
            return;
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl.accept(null);
    }

    public void onError(final Exception ex) {
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final SPacketEncryptionRequest sPacketEncryptionRequest) {
        final SecretKey bridge$createNewSharedKey = Bridge.IlIlIlllllIlIIlIlIlllIlIl().bridge$createNewSharedKey();
        final PublicKey illlIIIIIIlllIlIIlllIlIIl = sPacketEncryptionRequest.IlllIIIIIIlllIlIIlllIlIIl();
        final byte[] bridge$getServerIdHash = Bridge.IlIlIlllllIlIIlIlIlllIlIl().bridge$getServerIdHash("", illlIIIIIIlllIlIIlllIlIIl, bridge$createNewSharedKey);
        if (bridge$getServerIdHash == null) {
            return;
        }
        final String string = new BigInteger(bridge$getServerIdHash).toString(16);
        try {
            new YggdrasilAuthenticationService(Proxy.NO_PROXY, UUID.randomUUID().toString()).createMinecraftSessionService().joinServer(Ref.getMinecraft().bridge$getSession().bridge$getProfile(), Ref.getMinecraft().bridge$getSession().bridge$getToken(), string);
        } catch (AuthenticationUnavailableException ex) {
            Ref.getLC().IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(NotificationType.ERROR, "Authentication Unavailable", ex.getMessage());
            LunarLogger.info("Auth", "Authentication Unavailable (%s)", ex.getMessage());
            return;
        } catch (InvalidCredentialsException ex2) {
            Ref.getLC().IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(NotificationType.ERROR, "Invalid Credentials", ex2.getMessage());
            LunarLogger.info("Auth", "Invalid Credentials (%s)", ex2.getMessage());
            return;
        } catch (AuthenticationException ex3) {
            Ref.getLC().IIIlIIIIIIllIIIIllIIIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(NotificationType.ERROR, "Authentication Error", ex3.getMessage());
            LunarLogger.info("Auth", "Authentication Error (%s)", ex3.getMessage());
            return;
        } catch (NullPointerException ex4) {
            this.close();
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(new CPacketEncryptionResponse(bridge$createNewSharedKey, illlIIIIIIlllIlIIlllIlIIl, sPacketEncryptionRequest.lIllIlIIIlIIIIIIIlllIlIll()));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final SPacketAuthenticatedRequest sPacketAuthenticatedRequest) {
        this.IlllIIIIIIlllIlIIlllIlIIl = true;
        this.close();
        this.lIlIlIlIlIIlIIlIIllIIIIIl.accept(sPacketAuthenticatedRequest.IlllIIIIIIlllIlIIlllIlIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AbstractAuthenticatorPacket abstractAuthenticatorPacket) {
        if (!this.isOpen()) {
            return;
        }
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("packetType", abstractAuthenticatorPacket.lIlIlIlIlIIlIIlIIllIIIIIl());
        try {
            abstractAuthenticatorPacket.IlllIIIIIIlllIlIIlllIlIIl(jsonObject);
            this.send(LunarClient.GSON.toJson(jsonObject).getBytes(StandardCharsets.UTF_8));
            if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl(UsedEnum.ASSET_SERVER)) {
                LunarLogger.info("Auth", "Sent: %s", abstractAuthenticatorPacket.getClass().getSimpleName());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final JsonObject jsonObject) {
        final String asString = jsonObject.get("packetType").getAsString();
        AbstractAuthenticatorPacket abstractAuthenticatorPacket = null;
        switch (asString) {
            case "SPacketEncryptionRequest": {
                abstractAuthenticatorPacket = new SPacketEncryptionRequest();
                break;
            }
            case "SPacketAuthenticatedRequest": {
                abstractAuthenticatorPacket = new SPacketAuthenticatedRequest();
                break;
            }
            default: {
                return;
            }
        }
        try {
            abstractAuthenticatorPacket.lIllIlIIIlIIIIIIIlllIlIll(jsonObject);
            abstractAuthenticatorPacket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
        } catch (IOException ex) {
            LunarLogger.info("Auth", "Error from: " + abstractAuthenticatorPacket);
            ex.printStackTrace();
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractWebSocketPacket p0) {

    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(Object p0) {

    }
}
