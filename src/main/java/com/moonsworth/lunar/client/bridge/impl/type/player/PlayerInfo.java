package com.moonsworth.lunar.client.bridge.impl.type.player;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;

public class PlayerInfo extends NetworkPlayerInfo {
    public final DummyPlayerWrapper dummyPlayerWrapper;

    public PlayerInfo(DummyPlayerWrapper var1, GameProfile var2) {
        super(var2);
        this.dummyPlayerWrapper = var1;
    }

    public void loadPlayerTextures() {
        synchronized(this) {
            if (!this.playerTexturesLoaded) {
                this.playerTexturesLoaded = true;
                Minecraft.getMinecraft().getSkinManager().loadProfileTextures(this.dummyPlayerWrapper.mc.getSession().getProfile(), new Callback(this), true);
            }

        }
    }
}