package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.List;

public class WSPacketEmotesList extends AbstractWebSocketPacket {
    public List<Integer> IlllIIIIIIlllIlIIlllIlIIl;

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeVarIntToBuffer(this.IlllIIIIIIlllIlIIlllIlIIl.size());
        this.IlllIIIIIIlllIlIIlllIlIIl.forEach(packetBufferBridge::bridge$writeVarIntToBuffer);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
    }

    public WSPacketEmotesList(final List<Integer> illlIIIIIIlllIlIIlllIlIIl) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
    }
}
