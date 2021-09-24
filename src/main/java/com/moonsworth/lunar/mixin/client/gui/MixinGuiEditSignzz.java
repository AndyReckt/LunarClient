package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiEditSignBridge;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.tileentity.TileEntitySign;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GuiEditSign.class)
public abstract class MixinGuiEditSignzz implements GuiEditSignBridge {
    @Shadow
    private int editLine;
    @Shadow
    private TileEntitySign tileSign;

    public int bridge$getEditLine() {
        return editLine;
    }

    public String bridge$getLine(int var1) {
        return tileSign.signText[var1].getUnformattedText();
    }
}
