package com.moonsworth.lunar.client.websocket.packet;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;

public abstract class AbstractWebSocketPacket {
    public static BiMap REGISTRY;

    public abstract void IlllIIIIIIlllIlIIlllIlIIl(final PacketBufferBridge p0);

    public abstract void lIllIlIIIlIIIIIIIlllIlIll(final PacketBufferBridge p0);

    public abstract void lIlIlIlIlIIlIIlIIllIIIIIl(final AssetsWebSocket p0);

    public void writeKey(final PacketBufferBridge packetBufferBridge, final byte[] array) {
        packetBufferBridge.bridge$writeShort(array.length);
        packetBufferBridge.bridge$writeBytes(array);
    }

    public byte[] readKey(final PacketBufferBridge packetBufferBridge) {
        final short bridge$readShort = packetBufferBridge.bridge$readShort();
        if (bridge$readShort < 0) {
            LunarLogger.error("Invalid Key.");
            return new byte[0];
        }
        final byte[] array = new byte[bridge$readShort];
        packetBufferBridge.bridge$readBytes(array);
        return array;
    }

    static {
        (REGISTRY = HashBiMap.create()).put(WSPacketJoinServer.class, 0);
        REGISTRY.put(WSPacketClientJoinServerResponse.class, 1);
        REGISTRY.put(WSPacketConsole.class, 2);
        REGISTRY.put(WSPacketFormattedConsoleOutput.class, 3);
        REGISTRY.put(WSPacketFriendsUpdate.class, 4);
        REGISTRY.put(WSPacketMessage.class, 5);
        REGISTRY.put(WSPacketServerUpdate.class, 6);
        REGISTRY.put(AssetsPacketBulkFriends.class, 7);
        REGISTRY.put(WSPacketClientUnknownCosmetic.class, 8);
        REGISTRY.put(WSPacketFriendRequest.class, 9);
        REGISTRY.put(WSPacketFriendStatusUpdate.class, 16);
        REGISTRY.put(WSPacketClientFriendRemove.class, 17);
        REGISTRY.put(WSPacketFriendUpdate.class, 18);
        REGISTRY.put(WSPacketClientCosmetics.class, 20);
        REGISTRY.put(WSPacketClientFriendRequestUpdate.class, 21);
        REGISTRY.put(WSPacketClientRequestsStatus.class, 22);
        REGISTRY.put(WSPacketClientSync.class, 24);
        REGISTRY.put(WSPacketClientKeyResponse.class, 25);
        REGISTRY.put(WSPacketForceCrash.class, 33);
        REGISTRY.put(WSPacketRequestProcessList.class, 35);
        REGISTRY.put(WSPacketClientProcessList.class, 36);
        REGISTRY.put(IIlIlIIIllIIllllIllllIlIl.class, 38);
        REGISTRY.put(WSPacketClientEmote.class, 39);
        REGISTRY.put(llIIIlllIIlllIllllIlIllIl.class, 40);
        REGISTRY.put(llIlIIIllIIlIllIllIllllIl.class, 48);
        REGISTRY.put(IIlIllIlllllllIIlIIIllIIl.class, 50);
        REGISTRY.put(IlIIlIIlIIlIIllIIIllIIllI.class, 51);
        REGISTRY.put(IIlllIllIlIllIllIIllIlIIl.class, 52);
        REGISTRY.put(lIlIIIIIllIIlIIlIIlIlIIlI.class, 53);
        REGISTRY.put(llIIIIIIIllIIllIlIllIIIIl.class, 54);
        REGISTRY.put(IlIlIlllllIlIIlIlIlllIlIl.class, 55);
        REGISTRY.put(WSPacketEmotesList.class, 56);
        REGISTRY.put(IlIlIllIIllllIllllllIIlIl.class, 57);
        REGISTRY.put(FeaturesConfigWebsocketPacket.class, 64);
        REGISTRY.put(WSPacketChat.class, 65);
        REGISTRY.put(WSPacketClientBan.class, 1056);
        REGISTRY.put(WSPacketHostsList.class, 67);
        REGISTRY.put(WSPacketHostsListResponse.class, 68);
        REGISTRY.put(llIlllIIIllllIIlllIllIIIl.class, 69);
        REGISTRY.put(llllIIlIIlIIlIIllIIlIIllI.class, 70);
    }
}
