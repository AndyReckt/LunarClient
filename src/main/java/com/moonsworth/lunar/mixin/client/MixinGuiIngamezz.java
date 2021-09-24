package com.moonsworth.lunar.mixin.client;

import net.minecraft.client.gui.GuiIngame;
import net.minecraft.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GuiIngame.class)
public abstract class MixinGuiIngamezz {
    public boolean cancelCurrentStatRender;

    @Redirect(method = "renderPlayerStats", at = @At(value = "INVOKE", target = "Lnet/minecraft/profiler/Profiler;startSection(Ljava/lang/String;)V"))
    public void impl$startSection(Profiler var1, String var2) {
        this.cancelCurrentStatRender = !this.shouldRenderStat(var2);
        var1.startSection(var2);
    }

    @Redirect(method = "renderPlayerStats", at = @At(value = "INVOKE", target = "Lnet/minecraft/profiler/Profiler;endStartSection(Ljava/lang/String;)V"))
    public void impl$endStartSection(Profiler var1, String var2) {
        this.cancelCurrentStatRender = !this.shouldRenderStat(var2);
        var1.endStartSection(var2);
    }

    @Redirect(method = "renderPlayerStats", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiIngame;drawTexturedModalRect(IIIIII)V"))
    public void impl$drawTexturedModalRect(GuiIngame var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        if (!this.cancelCurrentStatRender) {
            var1.drawTexturedModalRect(var2, var3, var4, var5, var6, var7);
        }
    }

    // todo sba
    public boolean shouldRenderStat(String var1) {
//        switch (var1) {
//            case "armor": {
//                return GuiIngameCustomHook.shouldRenderArmor();
//            }
//            case "health": {
//                return GuiIngameCustomHook.shouldRenderHealth();
//            }
//            case "food": {
//                return GuiIngameCustomHook.shouldRenderFood();
//            }
//            case "mountHealth": {
//                return GuiIngameCustomHook.shouldRenderMountHealth();
//            }
//            default: {
//                return true;
//            }
//        }
        return true;
    }
}
