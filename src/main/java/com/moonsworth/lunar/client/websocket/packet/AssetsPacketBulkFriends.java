package com.moonsworth.lunar.client.websocket.packet;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

public class AssetsPacketBulkFriends extends AbstractWebSocketPacket {

    public String IlllIIIIIIlllIlIIlllIlIIl;
    public JsonArray lIllIlIIIlIIIIIIIlllIlIll;

    public AssetsPacketBulkFriends() {
    }

    public AssetsPacketBulkFriends(final String illlIIIIIIlllIlIIlllIlIIl) {
        this.IlllIIIIIIlllIlIIlllIlIIl = illlIIIIIIlllIlIIlllIlIIl;
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge packetBufferBridge) {
        packetBufferBridge.bridge$writeString(this.IlllIIIIIIlllIlIIlllIlIIl);
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge packetBufferBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = packetBufferBridge.bridge$readStringFromBuffer(32767);
        this.lIllIlIIIlIIIIIIIlllIlIll = new JsonParser().parse(this.IlllIIIIIIlllIlIIlllIlIIl).getAsJsonObject().getAsJsonArray("bulk");
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket assetsWebSocket) {
        assetsWebSocket.lIlIlIlIlIIlIIlIIllIIIIIl(this);
    }

    public JsonArray lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }
}
