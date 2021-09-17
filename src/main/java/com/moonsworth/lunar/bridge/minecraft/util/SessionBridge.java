package com.moonsworth.lunar.bridge.minecraft.util;

import com.mojang.authlib.GameProfile;

public interface SessionBridge {
    public String bridge$getPlayerID();

    public String bridge$getUsername();

    public String bridge$getToken();

    public GameProfile bridge$getProfile();
}
 