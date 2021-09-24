package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiControlsBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiKeyBindingList;
import net.minecraft.client.gui.GuiListExtended;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(GuiControls.class)
public abstract class MixinGuiControlsz implements I18nBridge, GuiControlsBridge {
    @Shadow
    public GuiKeyBindingList keyBindingList;

    public MixinGuiControlsz() {
    }

    @Inject(method = "drawScreen", at = @At("RETURN"))
    public void impl$onDrawScreen(int var1, int var2, float var3, CallbackInfo var4) {
//        GuiListExtended.IGuiListEntry[] var5 = this.keyBindingList.listEntries;
//        int var6 = var5.length;
//
//        for(int var7 = 0; var7 < var6; ++var7) {
//            GuiListExtended.IGuiListEntry var8 = var5[var7];
//            if (var8 instanceof GuiKeyBindingList.KeyEntry) {
//                KeyBindingBridge var9 = (KeyBindingBridge)((GuiKeyBindingList.KeyEntry)var8).keybinding;
//                GuiButton var10 = ((GuiKeyBindingList.KeyEntry)var8).btnChangeKeyBinding;
//                if (!var9.bridge$getClashesWith().isEmpty()) {
//                    boolean var11 = var1 > var10.xPosition && var1 < var10.xPosition + var10.width && var2 > var10.yPosition && var2 < var10.yPosition + var10.height;
//                    if (var11) {
//                        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((List)ImmutableList.of(this.get("clashesWith", new Object[]{EnumChatColor.lllIIIIIlllIIlIllIIlIIIlI + var9.bridge$getClashesWith().toString()})), var1, var2);
//                    }
//                }
//            }
//        }
    }

    public String getLanguagePath() {
        return "gui.components";
    }
}
