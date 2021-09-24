package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.security.PublicKey;

public class WSPacketJoinServer extends AbstractWebSocketPacket {
    public PublicKey IlllIIIIIIlllIlIIlllIlIIl;
    public byte[] lIllIlIIIlIIIIIIIlllIlIll;

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
        assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = Bridge.IlIlIlllllIlIIlIlIlllIlIl().bridge$decodePublicKey(this.readKey(packetBufferBridge));
        this.lIllIlIIIlIIIIIIIlllIlIll = this.readKey(packetBufferBridge);
    }

    public PublicKey lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public byte[] IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }
}
