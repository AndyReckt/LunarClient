package com.moonsworth.lunar.bridge.minecraft.client.network;

import io.netty.channel.Channel;

public interface NetworkManagerBridge {
    public Channel bridge$getChannel();

    public INetHandlerBridge bridge$getNetHandler();

    public boolean bridge$isLocalChannel();
}
 