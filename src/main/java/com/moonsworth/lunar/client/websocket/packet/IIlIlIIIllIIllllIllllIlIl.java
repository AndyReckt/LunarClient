package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.ArrayList;
import java.util.List;

public class IIlIlIIIllIIllllIllllIlIl extends AbstractWebSocketPacket {

    public List<Integer> IlllIIIIIIlllIlIIlllIlIIl;

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        final int bridge$readInt = packetBufferBridge.bridge$readInt();
        this.IlllIIIIIIlllIlIIlllIlIIl = new ArrayList<>();
        for (int i = 0; i < bridge$readInt; ++i) {
            this.IlllIIIIIIlllIlIIlllIlIIl.add(packetBufferBridge.bridge$readInt());
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
        assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    public IIlIlIIIllIIllllIllllIlIl(final List illlIIIIIIlllIlIIlllIlIIl) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
    }

    public IIlIlIIIllIIllllIllllIlIl() {
    }

    public List lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}
