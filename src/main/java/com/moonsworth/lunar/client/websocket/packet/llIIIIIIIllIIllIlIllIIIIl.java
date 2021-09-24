package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.Collection;
import java.util.Iterator;

public class llIIIIIIIllIIllIlIllIIIIl extends AbstractWebSocketPacket {
    public Collection<Long> IlllIIIIIIlllIlIIlllIlIIl;
    public Collection<Long> lIllIlIIIlIIIIIIIlllIlIll;

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeInt(this.IlllIIIIIIlllIlIIlllIlIIl.size());
        for (Long aLong : this.IlllIIIIIIlllIlIIlllIlIIl) {
            packetBufferBridge.bridge$writeLong(aLong);
        }
        packetBufferBridge.bridge$writeInt(this.lIllIlIIIlIIIIIIIlllIlIll.size());
        for (Long aLong : this.lIllIlIIIlIIIIIIIlllIlIll) {
            packetBufferBridge.bridge$writeLong(aLong);
        }
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
    }

    public llIIIIIIIllIIllIlIllIIIIl() {
    }

    public llIIIIIIIllIIllIlIllIIIIl(final Collection<Long> illlIIIIIIlllIlIIlllIlIIl, final Collection<Long> lIllIlIIIlIIIIIIIlllIlIll) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
        this.lIllIlIIIlIIIIIIIlllIlIll = lIllIlIIIlIIIIIIIlllIlIll;
    }
}