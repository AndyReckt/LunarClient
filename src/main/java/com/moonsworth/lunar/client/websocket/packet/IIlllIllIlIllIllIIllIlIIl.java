package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.UUID;

public class IIlllIllIlIllIllIIllIlIIl extends AbstractWebSocketPacket {
    public UUID IlllIIIIIIlllIlIIlllIlIIl;
    public boolean lIllIlIIIlIIIIIIIlllIlIll;

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeLong(this.IlllIIIIIIlllIlIIlllIlIIl.getMostSignificantBits());
        packetBufferBridge.bridge$writeLong(this.IlllIIIIIIlllIlIIlllIlIIl.getLeastSignificantBits());
        packetBufferBridge.bridge$writeBoolean(this.lIllIlIIIlIIIIIIIlllIlIll);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = new UUID(packetBufferBridge.bridge$readLong(), packetBufferBridge.bridge$readLong());
        this.lIllIlIIIlIIIIIIIlllIlIll = packetBufferBridge.bridge$readBoolean();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
    }

    public UUID lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public IIlllIllIlIllIllIIllIlIIl() {
    }

    public IIlllIllIlIllIllIIllIlIIl(final UUID illlIIIIIIlllIlIIlllIlIIl, final boolean lIllIlIIIlIIIIIIIlllIlIll) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
        this.lIllIlIIIlIIIIIIIlllIlIll = lIllIlIIIlIIIIIIIlllIlIll;
    }
}
