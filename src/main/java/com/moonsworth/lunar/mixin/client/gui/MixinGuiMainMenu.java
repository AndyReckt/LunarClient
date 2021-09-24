package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiMainMenuBridge;
import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;

/**
 * @author Decencies
 * @since 13/07/2021 23:00
 */
@Mixin(GuiMainMenu.class)
public abstract class MixinGuiMainMenu implements GuiMainMenuBridge {
}
