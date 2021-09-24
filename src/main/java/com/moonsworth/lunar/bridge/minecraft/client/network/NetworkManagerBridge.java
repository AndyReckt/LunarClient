package com.moonsworth.lunar.bridge.minecraft.client.network;

import io.netty.channel.Channel;

public interface NetworkManagerBridge {
    Channel bridge$getChannel();

    INetHandlerBridge bridge$getNetHandler();

    boolean bridge$isLocalChannel();
}
