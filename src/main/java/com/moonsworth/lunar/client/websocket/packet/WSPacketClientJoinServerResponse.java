package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import javax.crypto.SecretKey;
import java.security.PublicKey;

public class WSPacketClientJoinServerResponse extends AbstractWebSocketPacket {
    public final byte[] IlllIIIIIIlllIlIIlllIlIIl;
    public final byte[] lIllIlIIIlIIIIIIIlllIlIll;

    public WSPacketClientJoinServerResponse(final SecretKey secretKey, final PublicKey publicKey, final byte[] array) {
        this.IlllIIIIIIlllIlIIlllIlIIl = Bridge.IlIlIlllllIlIIlIlIlllIlIl().bridge$encryptData(publicKey, secretKey.getEncoded());
        this.lIllIlIIIlIIIIIIIlllIlIll = Bridge.IlIlIlllllIlIIlIlIlllIlIl().bridge$encryptData(publicKey, array);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        this.writeKey(packetBufferBridge, this.IlllIIIIIIlllIlIIlllIlIIl);
        this.writeKey(packetBufferBridge, this.lIllIlIIIlIIIIIIIlllIlIll);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
    }
}
