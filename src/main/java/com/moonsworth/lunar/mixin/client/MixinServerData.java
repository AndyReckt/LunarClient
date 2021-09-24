package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.multiplayer.ServerDataBridge;
import net.minecraft.client.multiplayer.ServerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ServerData.class)
public abstract class MixinServerData implements ServerDataBridge {
    @Shadow
    public String serverIP;
    @Shadow
    public long pingToServer;
    @Shadow
    private String serverIcon;

    public String lunarServer;
    public boolean supportsLC;
    public boolean checkedLunar;

    public String bridge$serverIP() {
        return serverIP;
    }

    public long bridge$getPingToServer() {
        return pingToServer;
    }

    public String getLunarServer() {
        return lunarServer;
    }

    public void setLunarServer(String var1) {
        this.lunarServer = var1;
    }

    public boolean getCheckedLunar() {
        return checkedLunar;
    }

    public void setCheckedLunar(boolean var1) {
        this.checkedLunar = var1;
    }

    public boolean getSupportsLunar() {
        return supportsLC;
    }

    public void setSupportsLunar(boolean var1) {
        this.supportsLC = var1;
    }

    public String bridge$getBase64Icon() {
        return serverIcon;
    }
}