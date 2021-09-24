package com.moonsworth.lunar.bridge.minecraft.client.network;

import java.util.List;

/**
 * @author Decencies
 * @since 10/07/2021 14:18
 */
public interface NetHandlerPlayClientBridge extends INetHandlerBridge {
    void bridge$addToSendQueue(PacketBridge var1);

    String bridge$getRegisterPacketName();

    String bridge$getLCChannelName();

    void bridge$quit();

    NetworkManagerBridge bridge$getNetworkManager();

    List<NetworkPlayerInfoBridge> bridge$getPlayerInfoMap();
}
