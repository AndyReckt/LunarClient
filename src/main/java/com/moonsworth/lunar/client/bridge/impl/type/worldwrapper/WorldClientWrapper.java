package com.moonsworth.lunar.client.bridge.impl.type.worldwrapper;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.profiler.Profiler;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;

public class WorldClientWrapper extends WorldClient {
    public WorldClientWrapper(NetHandlerPlayClient var1) {
        super(var1, new WorldSettings(0L, WorldSettings.GameType.NOT_SET, true, false, WorldType.DEFAULT), 0, EnumDifficulty.NORMAL, new Profiler());
    }
}
