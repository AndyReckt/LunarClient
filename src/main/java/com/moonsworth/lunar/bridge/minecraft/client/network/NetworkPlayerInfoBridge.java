package com.moonsworth.lunar.bridge.minecraft.client.network;

import com.mojang.authlib.GameProfile;

import java.util.UUID;

public interface NetworkPlayerInfoBridge {
    GameProfile bridge$getGameProfile();

    UUID bridge$getProfileTextureId();
}