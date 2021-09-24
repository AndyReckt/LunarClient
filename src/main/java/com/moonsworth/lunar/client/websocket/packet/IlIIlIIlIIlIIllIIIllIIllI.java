package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.UUID;

public class IlIIlIIlIIlIIllIIIllIIllI extends AbstractWebSocketPacket {
    public UUID IlllIIIIIIlllIlIIlllIlIIl;
    public int lIllIlIIIlIIIIIIIlllIlIll;

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeLong(this.IlllIIIIIIlllIlIIlllIlIIl.getMostSignificantBits());
        packetBufferBridge.bridge$writeLong(this.IlllIIIIIIlllIlIIlllIlIIl.getLeastSignificantBits());
        packetBufferBridge.bridge$writeInt(this.lIllIlIIIlIIIIIIIlllIlIll);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = new UUID(packetBufferBridge.bridge$readLong(), packetBufferBridge.bridge$readLong());
        this.lIllIlIIIlIIIIIIIlllIlIll = packetBufferBridge.bridge$readInt();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
        assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    public IlIIlIIlIIlIIllIIIllIIllI(final UUID illlIIIIIIlllIlIIlllIlIIl, final int lIllIlIIIlIIIIIIIlllIlIll) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
        this.lIllIlIIIlIIIIIIIlllIlIll = lIllIlIIIlIIIIIIIlllIlIll;
    }

    public IlIIlIIlIIlIIllIIIllIIllI() {
    }

    public UUID lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }
}