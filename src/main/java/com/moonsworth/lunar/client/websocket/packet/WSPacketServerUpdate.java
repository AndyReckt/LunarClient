package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

public class WSPacketServerUpdate extends AbstractWebSocketPacket {
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public String lIllIlIIIlIIIIIIIlllIlIll;

    public WSPacketServerUpdate() {
    }

    public WSPacketServerUpdate(final String lIllIlIIIlIIIIIIIlllIlIll, final String illlIIIIIIlllIlIIlllIlIIl) {
        this.lIllIlIIIlIIIIIIIlllIlIll = lIllIlIIIlIIIIIIIlllIlIll;
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeString(this.lIllIlIIIlIIIIIIIlllIlIll);
        packetBufferBridge.bridge$writeString(this.IlllIIIIIIlllIlIIlllIlIIl);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        this.lIllIlIIIlIIIIIIIlllIlIll = packetBufferBridge.bridge$readStringFromBuffer(52);
        this.IlllIIIIIIlllIlIIlllIlIIl = packetBufferBridge.bridge$readStringFromBuffer(100);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
        assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }
}
