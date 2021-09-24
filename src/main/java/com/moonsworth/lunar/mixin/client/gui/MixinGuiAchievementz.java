package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiAchievementBridge;
import net.minecraft.client.gui.achievement.GuiAchievement;
import net.minecraft.stats.Achievement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiAchievement.class)
public abstract class MixinGuiAchievementz implements GuiAchievementBridge {
    public MixinGuiAchievementz() {
    }

    public void impl$displayAchievement(Achievement var1, CallbackInfo var2) {
    }

    public void displayUnformattedAchievement(Achievement var1, CallbackInfo var2) {
    }
}
