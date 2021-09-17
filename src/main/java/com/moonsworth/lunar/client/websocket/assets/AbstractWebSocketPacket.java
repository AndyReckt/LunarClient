package com.moonsworth.lunar.client.websocket.assets;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.moonsworth.lunar.bridge.minecraft.client.network.PacketBufferBridge;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.websocket.*;

public abstract class AbstractWebSocketPacket extends AbstractPacket {
    public static BiMap REGISTRY = HashBiMap.create();

    public abstract void lIlIlIlIlIIlIIlIIllIIIIIl(AssetsWebSocket var1);

    public void writeKey(PacketBufferBridge packetBufferBridge, byte[] byArray) {
        packetBufferBridge.bridge$writeShort(byArray.length);
        packetBufferBridge.bridge$writeBytes(byArray);
    }

    public byte[] readKey(PacketBufferBridge packetBufferBridge) {
        short s = packetBufferBridge.bridge$readShort();
        if (s >= 0) {
            byte[] byArray = new byte[s];
            packetBufferBridge.bridge$readBytes(byArray);
            return byArray;
        }
        LunarLogger.llIlllIIIllllIIlllIllIIIl((Object)"Invalid Key.", new Object[0]);
        return new byte[0];
    }

    static {
//        REGISTRY.put(WSPacketJoinServer.class, 0);
//        REGISTRY.put(WSPacketClientJoinServerResponse.class, 1);
//        REGISTRY.put(WSPacketConsole.class, 2);
//        REGISTRY.put(WSPacketFormattedConsoleOutput.class, 3);
//        REGISTRY.put(WSPacketFriendsUpdate.class, 4);
//        REGISTRY.put(WSPacketMessage.class, 5);
//        REGISTRY.put(WSPacketServerUpdate.class, 6);
//        REGISTRY.put(AssetsPacketBulkFriends.class, 7);
//        REGISTRY.put(WSPacketClientUnknownCosmetic.class, 8);
//        REGISTRY.put(WSPacketFriendRequest.class, 9);
//        REGISTRY.put(WSPacketFriendStatusUpdate.class, 16);
//        REGISTRY.put(WSPacketClientFriendRemove.class, 17);
//        REGISTRY.put(WSPacketFriendUpdate.class, 18);
//        REGISTRY.put(WSPacketClientCosmetics.class, 20);
//        REGISTRY.put(WSPacketClientFriendRequestUpdate.class, 21);
//        REGISTRY.put(WSPacketClientRequestsStatus.class, 22);
//        REGISTRY.put(WSPacketClientSync.class, 24);
//        REGISTRY.put(WSPacketClientKeyResponse.class, 25);
//        REGISTRY.put(WSPacketForceCrash.class, 33);
//        REGISTRY.put(WSPacketRequestProcessList.class, 35);
//        REGISTRY.put(WSPacketClientProcessList.class, 36);
//        REGISTRY.put(IIlIlIIIllIIllllIllllIlIl.class, 38);
//        REGISTRY.put(WSPacketClientEmote.class, 39);
//        REGISTRY.put(llIIIlllIIlllIllllIlIllIl.class, 40);
//        REGISTRY.put(llIlIIIllIIlIllIllIllllIl.class, 48);
//        REGISTRY.put(IIlIllIlllllllIIlIIIllIIl.class, 50);
//        REGISTRY.put(IlIIlIIlIIlIIllIIIllIIllI.class, 51);
//        REGISTRY.put(IIlllIllIlIllIllIIllIlIIl.class, 52);
//        REGISTRY.put(lIlIIIIIllIIlIIlIIlIlIIlI.class, 53);
//        REGISTRY.put(llIIIIIIIllIIllIlIllIIIIl.class, 54);
//        REGISTRY.put(IlIlIlllllIlIIlIlIlllIlIl.class, 55);
//        REGISTRY.put(WSPacketEmotesList.class, 56);
//        REGISTRY.put(IlIlIllIIllllIllllllIIlIl.class, 57);
//        REGISTRY.put(FeaturesConfigWebsocketPacket.class, 64);
//        REGISTRY.put(WSPacketChat.class, 65);
//        REGISTRY.put(WSPacketClientBan.class, 1056);
//        REGISTRY.put(WSPacketHostsList.class, 67);
//        REGISTRY.put(WSPacketHostsListResponse.class, 68);
//        REGISTRY.put(llIlllIIIllllIIlllIllIIIl.class, 69);
//        REGISTRY.put(llllIIlIIlIIlIIllIIlIIllI.class, 70);
    }
}