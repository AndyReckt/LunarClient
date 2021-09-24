package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiIngameBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiNewChatBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.EventWithResult;
import com.moonsworth.lunar.client.event.type.hud.DrawChatEvent;
import com.moonsworth.lunar.client.event.type.hud.RenderCrosshairEvent;
import com.moonsworth.lunar.client.event.type.hud.RenderHotbarEvent;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.event.type.render.RenderScaledGameOverlayEvent;
import com.moonsworth.lunar.client.profile.main.GeneralOptions;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.movement.MovementUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.scoreboard.ScoreObjective;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GuiIngame.class)
public abstract class MixinGuiIngamez implements GuiIngameBridge {
    @Shadow
    public int lastPlayerHealth;
    @Shadow
    public int playerHealth;
    @Shadow
    public int titlesTimer;
    @Shadow
    public int titleDisplayTime;
    @Shadow
    public int titleFadeIn;
    @Shadow
    public int titleFadeOut;
    @Final
    @Shadow
    public GuiNewChat persistantChatGUI;

    @Shadow
    public abstract GuiNewChat getChatGUI();

    @Shadow
    public abstract void renderGameOverlay(float var1);

    @Shadow
    public abstract boolean showCrosshair();

    @Overwrite
    public void renderBossHealth() {
    }

    @Overwrite
    public void renderScoreboard(ScoreObjective var1, ScaledResolution var2) {
    }

    @Inject(method = "renderGameOverlay", at = @At(value = "FIELD", target = "Lnet/minecraft/client/gui/GuiIngame;recordPlayingUpFor:I", shift = At.Shift.BEFORE))
    public void impl$renderGameOverlay(float var1, CallbackInfo var2) {
        final ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        if (!Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            EventBus.getInstance().call(new RenderGameOverlayEvent(scaledResolution.getScaledWidth_double(), scaledResolution.getScaledHeight_double()));
        }
        float n2 = AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII();
        GlStateManager.pushMatrix();
        if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SomeScaleFactorShit.OFF) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(n2, n2, n2);
        }
        if (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SomeScaleFactorShit.MODS && Ref.getMinecraft().bridge$getCurrentScreen() != null && Ref.llIIIlllIIlllIllllIlIllIl() != MovementUI.class && Ref.llIIIlllIIlllIllllIlIllIl() != GuiChat.class) {
            n2 = AbstractUIScreen.llIllIlIllIlllIllIIIIllII();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(n2, n2, n2);
        }
        EventBus.getInstance().call(new RenderScaledGameOverlayEvent(scaledResolution.getScaledWidth_double() / n2, scaledResolution.getScaledHeight_double() / n2));
        GlStateManager.popMatrix();
    }

    @Inject(method = "renderTooltip", at = @At("HEAD"))
    public void impl$renderTooltip(CallbackInfo var1) {
        GlStateManager.enableDepth();
    }

    @Redirect(method = "renderGameOverlay", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiNewChat;drawChat(I)V"))
    public void impl$drawChat(GuiNewChat var1, int n) {
        final DrawChatEvent drawChatEvent = new DrawChatEvent((float)n);
        EventBus.getInstance().call(drawChatEvent);
        if (drawChatEvent.lIlIlIlIlIIlIIlIIllIIIIIl() != EventWithResult.EventStateResult.DENY) {
            this.persistantChatGUI.drawChat(n);
        }
    }

    @Inject(method = "renderTooltip", at = @At("HEAD"), cancellable = true)
    public void impl$renderHotbar(ScaledResolution var1, float var2, CallbackInfo var3) {
        final RenderHotbarEvent renderHotbarEvent = new RenderHotbarEvent();
        EventBus.getInstance().call(renderHotbarEvent);
        if (renderHotbarEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == EventWithResult.EventStateResult.DENY) {
            var3.cancel();
        }
    }

    @Inject(method = "showCrosshair", at = @At("HEAD"), cancellable = true)
    public void impl$showCrosshair(CallbackInfoReturnable<Boolean> var1) {
        final RenderCrosshairEvent renderCrosshairEvent = new RenderCrosshairEvent();
        EventBus.getInstance().call(renderCrosshairEvent);
        switch (renderCrosshairEvent.lIlIlIlIlIIlIIlIIllIIIIIl()) {
        case ALLOW: {
            var1.setReturnValue(true);
        }
        case DENY: {
            var1.setReturnValue(false);
        }
        default:
        {}
        }
    }

    @ModifyVariable(
        method = "renderPlayerStats(Lnet/minecraft/client/gui/ScaledResolution;)V",
        at = @At(
                 value = "STORE",
                 ordinal = 0
             ),
        ordinal = 1
    )
    public int impl$renderPlayerStats(int var1) {
        return LunarClient.getInstance().lllllIllIllIllllIlIllllII().IlllllIlIIIlIIlIIllIIlIll().lIlIlIIIIIIllIlIIIIllIIII().isLegacy() ? 0 : var1;
    }

    public GuiNewChatBridge bridge$getChatGUI() {
        return (GuiNewChatBridge) getChatGUI();
    }

    public void bridge$renderGameOverlay(float var1) {
        renderGameOverlay(var1);
    }

    public boolean bridge$showCrosshair() {
        return showCrosshair();
    }

    public void bridge$resetTitleTimer() {
        this.titlesTimer = 0;
        this.titleDisplayTime = 0;
        this.titleFadeIn = 0;
        this.titleFadeOut = 0;
    }
}