package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiMultiplayerBridge;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.ServerListEntryNormal;
import net.minecraft.client.gui.ServerSelectionList;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMultiplayer.class)
public abstract class MixinGuiMultiplayerz implements GuiMultiplayerBridge {
    @Shadow
    private ServerList savedServerList;
    @Shadow
    private ServerSelectionList serverListSelector;

    public MixinGuiMultiplayerz() {
    }

    @Shadow
    public abstract void selectServer(int var1);

    @Shadow
    public abstract void connectToServer(ServerData var1);

    public void impl$onConnectToServer(ServerData var1, CallbackInfo var2) {
    }

//    public boolean func_175392_a(ServerListEntryNormal var1, int var2) {
//    }

    public void func_175391_a(ServerListEntryNormal var1, int var2, boolean var3) {
    }

    public void impl$connectToSelected(CallbackInfo var1, GuiListExtended.IGuiListEntry var2) {
    }
}