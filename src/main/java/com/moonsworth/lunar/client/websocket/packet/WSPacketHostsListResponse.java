package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WSPacketHostsListResponse extends AbstractWebSocketPacket {
    public List<String> IlllIIIIIIlllIlIIlllIlIIl;

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeInt(this.IlllIIIIIIlllIlIIlllIlIIl.size());
        final Iterator<String> iterator = this.IlllIIIIIIlllIlIIlllIlIIl.iterator();
        while (iterator.hasNext()) {
            packetBufferBridge.bridge$writeString(iterator.next());
        }
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        final int bridge$readInt = packetBufferBridge.bridge$readInt();
        this.IlllIIIIIIlllIlIIlllIlIIl = new ArrayList<>();
        for (int i = 0; i < bridge$readInt; ++i) {
            this.IlllIIIIIIlllIlIIlllIlIIl.add(packetBufferBridge.bridge$readStringFromBuffer(512));
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
    }

    public WSPacketHostsListResponse() {
    }

    public WSPacketHostsListResponse(final List<String> illlIIIIIIlllIlIIlllIlIIl) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
    }

    public List<String> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}
