package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.ArrayList;
import java.util.List;

public class IlIlIllIIllllIllllllIIlIl extends AbstractWebSocketPacket {
    public List<Integer> IlllIIIIIIlllIlIIlllIlIIl;
    public List<Integer> lIllIlIIIlIIIIIIIlllIlIll;

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        final int bridge$readVarIntFromBuffer = packetBufferBridge.bridge$readVarIntFromBuffer();
        this.IlllIIIIIIlllIlIIlllIlIIl = new ArrayList();
        for (int i = 0; i < bridge$readVarIntFromBuffer; ++i) {
            this.IlllIIIIIIlllIlIIlllIlIIl.add(packetBufferBridge.bridge$readVarIntFromBuffer());
        }
        final int bridge$readVarIntFromBuffer2 = packetBufferBridge.bridge$readVarIntFromBuffer();
        this.lIllIlIIIlIIIIIIIlllIlIll = new ArrayList();
        for (int j = 0; j < bridge$readVarIntFromBuffer2; ++j) {
            this.lIllIlIIIlIIIIIIIlllIlIll.add(packetBufferBridge.bridge$readVarIntFromBuffer());
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
        assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    public IlIlIllIIllllIllllllIIlIl(final List<Integer> illlIIIIIIlllIlIIlllIlIIl, final List<Integer> lIllIlIIIlIIIIIIIlllIlIll) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
        this.lIllIlIIIlIIIIIIIlllIlIll = lIllIlIIIlIIIIIIIlllIlIll;
    }

    public IlIlIllIIllllIllllllIIlIl() {
    }

    public List<Integer> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public List<Integer> IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }
}
