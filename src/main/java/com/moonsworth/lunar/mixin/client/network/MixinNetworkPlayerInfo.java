package com.moonsworth.lunar.mixin.client.network;

import com.mojang.authlib.GameProfile;
import com.moonsworth.lunar.bridge.minecraft.client.network.NetworkPlayerInfoBridge;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.UUID;

@Mixin(NetworkPlayerInfo.class)
public abstract class MixinNetworkPlayerInfo implements NetworkPlayerInfoBridge {
    @Shadow
    public GameProfile gameProfile;
    @Shadow
    public String skinType;
    public UUID profileTextureUuid;

    public MixinNetworkPlayerInfo() {
    }

    @Shadow
    public abstract GameProfile getGameProfile();

    @Shadow
    public abstract String getSkinType();

    @Shadow
    public abstract ResourceLocation getLocationSkin();

    public GameProfile bridge$getGameProfile() {
        return gameProfile;
    }

    public UUID bridge$getProfileTextureId() {
        return profileTextureUuid;
    }

    public ResourceLocation proxy$getLocationSkin() {
        return getLocationSkin();
    }
}