package com.moonsworth.lunar.client.bridge.impl.type.player;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.world.World;

import java.util.UUID;

public class DummyPlayerWrapper extends EntityPlayerSP {
    public final UUID realUuid;

    public DummyPlayerWrapper(Minecraft var1, World var2, NetHandlerPlayClient var3, StatFileWriter var4) {
        super(var1, var2, var3, var4);
        this.realUuid = this.mc.getSession().getProfile().getId();
    }

    public void entityInit() {
        super.entityInit();
        if (!this.dataWatcher.watchedObjects.containsKey(10)) {
            this.dataWatcher.addObject(10, "");
        }

    }

    public boolean getAlwaysRenderNameTagForRender() {
        return false;
    }

    public boolean hasSkin() {
        return false;
    }

    public boolean aM() {
        return false;
    }

    public boolean t() {
        return false;
    }

    public boolean aQ(EntityPlayerMP var1) {
        return false;
    }

    public boolean isSpectator() {
        return false;
    }

    public NetworkPlayerInfo getPlayerInfo() {
        if (this.playerInfo == null) {
            this.playerInfo = new PlayerInfo(this, this.getGameProfile());
        }

        return this.playerInfo;
    }
}