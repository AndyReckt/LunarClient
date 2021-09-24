package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IIlIllIlllllllIIlIIIllIIl extends AbstractWebSocketPacket {
    public List<UUID> IlllIIIIIIlllIlIIlllIlIIl;

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeVarIntToBuffer(this.IlllIIIIIIlllIlIIlllIlIIl.size());
        for (final UUID uuid : this.IlllIIIIIIlllIlIIlllIlIIl) {
            packetBufferBridge.bridge$writeLong(uuid.getMostSignificantBits());
            packetBufferBridge.bridge$writeLong(uuid.getLeastSignificantBits());
        }
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        final int bridge$readVarIntFromBuffer = packetBufferBridge.bridge$readVarIntFromBuffer();
        this.IlllIIIIIIlllIlIIlllIlIIl = new ArrayList<>();
        for (int i = 0; i < bridge$readVarIntFromBuffer; ++i) {
            this.IlllIIIIIIlllIlIIlllIlIIl.add(new UUID(packetBufferBridge.bridge$readLong(), packetBufferBridge.bridge$readLong()));
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
    }

    public IIlIllIlllllllIIlIIIllIIl() {
    }

    public IIlIllIlllllllIIlIIIllIIl(final List illlIIIIIIlllIlIIlllIlIIl) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
    }
}
