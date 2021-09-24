package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

public class WSPacketClientSync extends AbstractWebSocketPacket {
    public int IlllIIIIIIlllIlIIlllIlIIl;
    public String lIllIlIIIlIIIIIIIlllIlIll;

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeInt(this.IlllIIIIIIlllIlIIlllIlIIl);
        packetBufferBridge.bridge$writeString(this.lIllIlIIIlIIIIIIIlllIlIll);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = packetBufferBridge.bridge$readInt();
        this.lIllIlIIIlIIIIIIIlllIlIll = packetBufferBridge.bridge$readStringFromBuffer(128);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
    }

    public WSPacketClientSync() {
    }

    public WSPacketClientSync(final int illlIIIIIIlllIlIIlllIlIIl, final String lIllIlIIIlIIIIIIIlllIlIll) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
        this.lIllIlIIIlIIIIIIIlllIlIll = lIllIlIIIlIIIIIIIlllIlIll;
    }
}
