package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WSPacketClientBan extends AbstractWebSocketPacket {
    public int IlllIIIIIIlllIlIIlllIlIIl;
    public String lIllIlIIIlIIIIIIIlllIlIll;
    public List<String> llIlllIIIllllIIlllIllIIIl;

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeInt(this.IlllIIIIIIlllIlIIlllIlIIl);
        packetBufferBridge.bridge$writeString(this.lIllIlIIIlIIIIIIIlllIlIll);
        packetBufferBridge.bridge$writeInt(this.llIlllIIIllllIIlllIllIIIl.size());
        this.llIlllIIIllllIIlllIllIIIl.forEach(packetBufferBridge::bridge$writeString);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = packetBufferBridge.bridge$readInt();
        this.lIllIlIIIlIIIIIIIlllIlIll = packetBufferBridge.bridge$readStringFromBuffer(128);
        for (int bridge$readInt = packetBufferBridge.bridge$readInt(), i = 0; i < bridge$readInt; ++i) {
            this.llIlllIIIllllIIlllIllIIIl.add(packetBufferBridge.bridge$readStringFromBuffer(128));
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
        assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public List<String> lIllIlIIIlIIIIIIIlllIlIll() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public WSPacketClientBan(final int illlIIIIIIlllIlIIlllIlIIl, final String lIllIlIIIlIIIIIIIlllIlIll, final List<String> llIlllIIIllllIIlllIllIIIl) {
        this.llIlllIIIllllIIlllIllIIIl = new ArrayList<>();
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
        this.lIllIlIIIlIIIIIIIlllIlIll = lIllIlIIIlIIIIIIIlllIlIll;
        this.llIlllIIIllllIIlllIllIIIl = llIlllIIIllllIIlllIllIIIl;
    }

    public WSPacketClientBan() {
        this.llIlllIIIllllIIlllIllIIIl = new ArrayList<>();
    }
}
