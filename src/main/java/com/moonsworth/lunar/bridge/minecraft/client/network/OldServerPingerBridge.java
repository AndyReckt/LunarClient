package com.moonsworth.lunar.bridge.minecraft.client.network;

import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.ServerDataBridge;

import java.net.UnknownHostException;

public interface OldServerPingerBridge {
    public void bridge$ping(ServerDataBridge var1) throws UnknownHostException;
}
 