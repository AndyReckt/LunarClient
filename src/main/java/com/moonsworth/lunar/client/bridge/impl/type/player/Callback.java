package com.moonsworth.lunar.client.bridge.impl.type.player;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.util.ResourceLocation;

public class Callback implements SkinManager.SkinAvailableCallback {
    public PlayerInfo playerInfo;

    public Callback(PlayerInfo var1) {
        this.playerInfo = var1;
    }

    public void skinAvailable(MinecraftProfileTexture.Type var1, ResourceLocation var2, MinecraftProfileTexture var3) {
        switch(var1) {
        case SKIN:
            this.playerInfo.locationSkin = var2;
            this.playerInfo.skinType = var3.getMetadata("model");
            if (this.playerInfo.skinType == null) {
                this.playerInfo.skinType = "default";
            }
            break;
        case CAPE:
            this.playerInfo.locationCape = var2;
        }

    }
}
