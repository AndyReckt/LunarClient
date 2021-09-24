package com.moonsworth.lunar.client.bridge.impl.type.network;

import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;

public class NetworkManagerWrapper extends NetworkManager {
    public NetworkManagerWrapper() {
        super(EnumPacketDirection.SERVERBOUND);
    }
}
