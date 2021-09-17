package com.moonsworth.lunar.bridge.minecraft.client.network;

import java.util.List;

/**
 * @author Decencies
 * @since 10/07/2021 14:18
 */
public interface NetHandlerPlayClientBridge extends INetHandlerBridge {
    public void bridge$addToSendQueue(PacketBridge var1);

    public String bridge$getRegisterPacketName();

    public String bridge$getLCChannelName();

    public void bridge$quit();

    public NetworkManagerBridge bridge$getNetworkManager();

    public List bridge$getPlayerInfoMap();
}
