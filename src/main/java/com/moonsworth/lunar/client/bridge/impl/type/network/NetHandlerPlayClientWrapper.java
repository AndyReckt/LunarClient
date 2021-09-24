package com.moonsworth.lunar.client.bridge.impl.type.network;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;

import java.util.UUID;

public class NetHandlerPlayClientWrapper extends NetHandlerPlayClient {
    public NetHandlerPlayClientWrapper(Minecraft var1) {
        super(var1, var1.currentScreen, new NetworkManagerWrapper(), new GameProfile(UUID.randomUUID(), var1.getSession().getProfile().getName()));
    }
}
