package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

public class WSPacketFriendUpdate extends AbstractWebSocketPacket {
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public String lIllIlIIIlIIIIIIIlllIlIll;
    public long llIlllIIIllllIIlllIllIIIl;
    public boolean llllIIlIIlIIlIIllIIlIIllI;
    public String IlIlIlllllIlIIlIlIlllIlIl;

    public WSPacketFriendUpdate() {
    }

    public WSPacketFriendUpdate(final String illlIIIIIIlllIlIIlllIlIIl, final String lIllIlIIIlIIIIIIIlllIlIll, final long llIlllIIIllllIIlllIllIIIl, final boolean llllIIlIIlIIlIIllIIlIIllI, final String ilIlIlllllIlIIlIlIlllIlIl) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
        this.lIllIlIIIlIIIIIIIlllIlIll = lIllIlIIIlIIIIIIIlllIlIll;
        this.llIlllIIIllllIIlllIllIIIl = llIlllIIIllllIIlllIllIIIl;
        this.llllIIlIIlIIlIIllIIlIIllI = llllIIlIIlIIlIIllIIlIIllI;
        this.IlIlIlllllIlIIlIlIlllIlIl = ilIlIlllllIlIIlIlIlllIlIl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeString(this.IlllIIIIIIlllIlIIlllIlIIl);
        packetBufferBridge.bridge$writeString(this.lIllIlIIIlIIIIIIIlllIlIll);
        packetBufferBridge.bridge$writeLong(this.llIlllIIIllllIIlllIllIIIl);
        packetBufferBridge.bridge$writeBoolean(this.llllIIlIIlIIlIIllIIlIIllI);
        packetBufferBridge.bridge$writeString(this.IlIlIlllllIlIIlIlIlllIlIl);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = packetBufferBridge.bridge$readStringFromBuffer(52);
        this.lIllIlIIIlIIIIIIIlllIlIll = packetBufferBridge.bridge$readStringFromBuffer(32);
        this.llIlllIIIllllIIlllIllIIIl = packetBufferBridge.bridge$readLong();
        this.llllIIlIIlIIlIIllIIlIIllI = packetBufferBridge.bridge$readBoolean();
        this.IlIlIlllllIlIIlIlIlllIlIl = packetBufferBridge.bridge$readStringFromBuffer(16);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
        assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public long lIllIlIIIlIIIIIIIlllIlIll() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public String llllIIlIIlIIlIIllIIlIIllI() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }
}
