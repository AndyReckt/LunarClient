package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

public class WSPacketClientRequestsStatus extends AbstractWebSocketPacket {
    public boolean IlllIIIIIIlllIlIIlllIlIIl;

    public WSPacketClientRequestsStatus(final boolean illlIIIIIIlllIlIIlllIlIIl) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
    }

    public WSPacketClientRequestsStatus() {
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeBoolean(this.IlllIIIIIIlllIlIIlllIlIIl);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = packetBufferBridge.bridge$readBoolean();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}
