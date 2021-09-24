package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiAchievementsBridge;
import net.minecraft.client.gui.achievement.GuiAchievements;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GuiAchievements.class)
public class MixinGuiAchievements implements GuiAchievementsBridge {
    public MixinGuiAchievements() {
    }
}
