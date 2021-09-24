package com.moonsworth.lunar.mixin.client;

import com.mojang.authlib.GameProfile;
import com.moonsworth.lunar.bridge.minecraft.util.SessionBridge;
import net.minecraft.util.Session;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Session.class)
public abstract class MixinSessionz implements SessionBridge {

    @Shadow
    public abstract String getPlayerID();

    @Shadow
    public abstract String getUsername();

    @Shadow
    public abstract String getToken();

    @Shadow
    public abstract GameProfile getProfile();

    public String bridge$getPlayerID() {
        return getPlayerID();
    }

    public String bridge$getUsername() {
        return getUsername();
    }

    public String bridge$getToken() {
        return getToken();
    }

    public GameProfile bridge$getProfile() {
        return getProfile();
    }
}
