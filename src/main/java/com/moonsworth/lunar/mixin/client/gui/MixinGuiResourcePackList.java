package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiResourcePackListBridge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiResourcePackList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(GuiResourcePackList.class)
public abstract class MixinGuiResourcePackList extends GuiListExtended implements GuiResourcePackListBridge {
    @Shadow
    public List field_148204_l;

    public MixinGuiResourcePackList(Minecraft mcIn, int widthIn, int heightIn, int topIn, int bottomIn, int slotHeightIn) {
        super(mcIn, widthIn, heightIn, topIn, bottomIn, slotHeightIn);
    }

//    public MixinGuiResourcePackList(Minecraft var1, int var2, int var3, int var4, int var5, int var6) {
//    }

    public void setUnderlyingList(List var1) {
    }

    public void overlayBackground(int var1, int var2, int var3, int var4) {
    }

    public void drawScreen(int var1, int var2, float var3) {
    }
}