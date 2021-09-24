package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

public class WSPacketFormattedConsoleOutput extends AbstractWebSocketPacket {
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public String lIllIlIIIlIIIIIIIlllIlIll;

    public WSPacketFormattedConsoleOutput() {
    }

    public WSPacketFormattedConsoleOutput(final String illlIIIIIIlllIlIIlllIlIIl, final String lIllIlIIIlIIIIIIIlllIlIll) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
        this.lIllIlIIIlIIIIIIIlllIlIll = lIllIlIIIlIIIIIIIlllIlIll;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeString(this.IlllIIIIIIlllIlIIlllIlIIl);
        packetBufferBridge.bridge$writeString(this.lIllIlIIIlIIIIIIIlllIlIll);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = packetBufferBridge.bridge$readStringFromBuffer(128);
        this.lIllIlIIIlIIIIIIIlllIlIll = packetBufferBridge.bridge$readStringFromBuffer(512);
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
