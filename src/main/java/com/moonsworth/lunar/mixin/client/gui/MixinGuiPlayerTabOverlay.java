package com.moonsworth.lunar.mixin.client.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.network.NetworkPlayerInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(GuiPlayerTabOverlay.class)
public abstract class MixinGuiPlayerTabOverlay {
    public UUID modifyingPlayerEntry;

    public MixinGuiPlayerTabOverlay() {
    }

    @Shadow
    public abstract String getPlayerName(NetworkPlayerInfo var1);

    public void impl$drawPing(int var1, int var2, int var3, NetworkPlayerInfo var4, CallbackInfo var5) {
    }

//    public String impl$onGetPlayerName(GuiPlayerTabOverlay var1, NetworkPlayerInfo var2) {
//    }
//
//    public int impl$onDrawString(FontRenderer var1, String var2, float var3, float var4, int var5) {
//    }

    @Mixin(targets = "net/minecraft/client/gui/GuiPlayerTabOverlay$PlayerComparator")
    public static abstract class MixinGuiPlayerTabOverlay$PlayerComparator {
        public MixinGuiPlayerTabOverlay$PlayerComparator() {
        }

        public int compare(NetworkPlayerInfo var1, NetworkPlayerInfo var2) {
            return 0;
        }
    }


}
