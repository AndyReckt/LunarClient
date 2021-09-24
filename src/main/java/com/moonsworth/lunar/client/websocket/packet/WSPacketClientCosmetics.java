package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.cosmetic.Cosmetic;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.List;

public class WSPacketClientCosmetics extends AbstractWebSocketPacket {
    public final List<Cosmetic> IlllIIIIIIlllIlIIlllIlIIl;

    public WSPacketClientCosmetics(final List<Cosmetic> illlIIIIIIlllIlIIlllIlIIl) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeInt(this.IlllIIIIIIlllIlIIlllIlIIl.size());
        for (final Cosmetic cosmetic : this.IlllIIIIIIlllIlIIlllIlIIl) {
            packetBufferBridge.bridge$writeLong(cosmetic.lIlIlIlIlIIlIIlIIllIIIIIl());
            packetBufferBridge.bridge$writeBoolean(cosmetic.llIIIIIIIllIIllIlIllIIIIl());
        }
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
    }

    public List<Cosmetic> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}
