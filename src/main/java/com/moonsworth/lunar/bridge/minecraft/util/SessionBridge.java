package com.moonsworth.lunar.bridge.minecraft.util;

import com.mojang.authlib.GameProfile;

public interface SessionBridge {
    String bridge$getPlayerID();

    String bridge$getUsername();

    String bridge$getToken();

    GameProfile bridge$getProfile();
}
