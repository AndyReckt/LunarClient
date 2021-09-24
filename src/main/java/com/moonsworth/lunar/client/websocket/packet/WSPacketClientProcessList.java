package com.moonsworth.lunar.client.websocket.packet;

import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WSPacketClientProcessList extends AbstractWebSocketPacket {
    public List<String> lIllIlIIIlIIIIIIIlllIlIll;
    public static byte[] IlllIIIIIIlllIlIIlllIlIIl;

    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeInt(this.lIllIlIIIlIIIIIIIlllIlIll.size());
        this.lIllIlIIIlIIIIIIIlllIlIll.forEach(packetBufferBridge::bridge$writeString);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        final int bridge$readInt = packetBufferBridge.bridge$readInt();
        this.lIllIlIIIlIIIIIIIlllIlIll = new ArrayList<>();
        for (int i = 0; i < bridge$readInt; ++i) {
            this.lIllIlIIIlIIIIIIIlllIlIll.add(packetBufferBridge.bridge$readStringFromBuffer(512));
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
    }

    public WSPacketClientProcessList() {
    }

    public WSPacketClientProcessList(final List<String> lIllIlIIIlIIIIIIIlllIlIll) {
        this.lIllIlIIIlIIIIIIIlllIlIll = lIllIlIIIlIIIIIIIlllIlIll;
    }

    public List<String> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    static {
        WSPacketClientProcessList.IlllIIIIIIlllIlIIlllIlIIl = new byte[] { 36, -70, -63, 3, -116, 46, -121, -127, 117, 64, 58, 5, 75, 96, -63, 36 };
    }
}
