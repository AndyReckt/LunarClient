package com.moonsworth.lunar.client.websocket.packet;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WSPacketFriendsUpdate extends AbstractWebSocketPacket {
    public boolean IlllIIIIIIlllIlIIlllIlIIl;
    public boolean lIllIlIIIlIIIIIIIlllIlIll;
    public Map<String, List<Object>> llIlllIIIllllIIlllIllIIIl;
    public Map<String, List<Object>> llllIIlIIlIIlIIllIIlIIllI;

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = packetBufferBridge.bridge$readBoolean();
        this.lIllIlIIIlIIIIIIIlllIlIll = packetBufferBridge.bridge$readBoolean();
        final int bridge$readInt = packetBufferBridge.bridge$readInt();
        final int bridge$readInt2 = packetBufferBridge.bridge$readInt();
        this.llIlllIIIllllIIlllIllIIIl = new HashMap<>();
        for (int i = 0; i < bridge$readInt; ++i) {
            this.llIlllIIIllllIIlllIllIIIl.put(packetBufferBridge.bridge$readStringFromBuffer(52), ImmutableList.of(packetBufferBridge.bridge$readStringFromBuffer(32), packetBufferBridge.bridge$readInt(), packetBufferBridge.bridge$readStringFromBuffer(256)));
        }
        this.llllIIlIIlIIlIIllIIlIIllI = new HashMap<>();
        for (int j = 0; j < bridge$readInt2; ++j) {
            this.llllIIlIIlIIlIIllIIlIIllI.put(packetBufferBridge.bridge$readStringFromBuffer(52), ImmutableList.of(packetBufferBridge.bridge$readStringFromBuffer(32), packetBufferBridge.bridge$readLong()));
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
        assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public Map<String, List<Object>> lIllIlIIIlIIIIIIIlllIlIll() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public Map<String, List<Object>> llIlllIIIllllIIlllIllIIIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }
}
