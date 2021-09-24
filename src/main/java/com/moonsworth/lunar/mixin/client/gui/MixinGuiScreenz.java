package com.moonsworth.lunar.mixin.client.gui;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.net.URI;
import java.util.List;
import java.util.Set;

@Mixin(GuiScreen.class)
public abstract class MixinGuiScreenz extends Gui implements GuiScreenBridge {
    @Shadow
    public int width;
    @Shadow
    public int height;
    @Shadow
    private URI clickedLinkURI;
    @Shadow
    public boolean allowUserInput;
    @Shadow
    private int eventButton;
    @Shadow
    protected FontRenderer fontRendererObj;
    @Shadow
    protected RenderItem itemRender;

    public boolean renderedTooltip;
    public double lastDrawY;
    public double lastMaxHeight;
    private static final Set<Class<? extends GuiScreen>> HIDE_BRAND_ON = ImmutableSet.of(GuiMultiplayer.class, GuiScreenServerList.class, GuiScreenAddServer.class, GuiChat.class, GuiControls.class, GuiSelectWorld.class, GuiRenameWorld.class, GuiConnecting.class, GuiCreateWorld.class, GuiLanguage.class, GuiYesNo.class, GuiDownloadTerrain.class);

    @Shadow
    public abstract void drawScreen(int var1, int var2, float var3);

    @Shadow
    public abstract void setWorldAndResolution(Minecraft var1, int var2, int var3);

    @Shadow
    protected abstract void mouseClicked(int var1, int var2, int var3);

    @Shadow
    protected abstract void mouseReleased(int var1, int var2, int var3);

    @Shadow
    public abstract void onGuiClosed();

    @Shadow
    public abstract void updateScreen();

    @Shadow
    protected abstract void keyTyped(char var1, int var2);

    @Shadow
    public abstract void handleMouseInput();

    @Shadow
    public static boolean isShiftKeyDown() {
        return false;
    }

    @Shadow
    protected abstract void drawHoveringText(List var1, int var2, int var3);

    @Shadow
    public abstract boolean doesGuiPauseGame();

    @Shadow
    public abstract void handleKeyboardInput();

    @Shadow
    protected abstract void actionPerformed(GuiButton var1);

    public void bridge$drawScreen(int var1, int var2, float var3) {
    }

    public void bridge$setWorldAndResolution(MinecraftBridge var1, int var2, int var3) {
    }

    public void impl$setWorldAndResolution(Minecraft var1, int var2, int var3, CallbackInfo var4) {
    }

    public void impl$setWorldAndResolution$tail(Minecraft var1, int var2, int var3, CallbackInfo var4) {
    }

    public void impl$setWorldAndResolution$pre(Minecraft var1, int var2, int var3, CallbackInfo var4) {
    }

    public void proxy$handleMouseInput() {
    }

    public void proxy$handleKeyboardInput() {
    }

    public void bridge$mouseClicked(int var1, int var2, int var3) {
    }

    public void bridge$mouseReleased(int var1, int var2, int var3) {
    }

    public void impl$onMouseScroll(CallbackInfo var1) {
    }

    public void impl$onDrawItemTooltip(GuiScreen var1, List var2, int var3, int var4, ItemStack var5) {
    }

    public void impl$onMouseClicked(GuiScreen var1, GuiButton var2) {
    }

    public void bridge$drawScrollableHoveringText(List var1, int var2, int var3) {
    }

    public void bridge$onGuiClosed() {
    }

    public void bridge$updateScreen() {
    }

    public void bridge$keyTyped(char var1, KeyType var2) {
    }

    public void bridge$handleMouseInput() {
    }

    public void bridge$setClickedLinkURI(URI var1) {
    }

    public boolean bridge$isControlsGui() {
        return (GuiScreenBridge) this instanceof GuiControls;
    }

    public void impl$renderLunarClientBrand(CallbackInfo var1) {
    }

    public void impl$menuBlurGradient(GuiScreen var1, int var2, int var3, int var4, int var5, int var6, int var7) {
    }

    private static void lunar$blurMenus(CallbackInfo var0) {
    }

    @Override
    public boolean bridge$allowUserInput() {
        return this.allowUserInput;
    }

    @Override
    public boolean bridge$doesGuiPauseGame() {
        return this.doesGuiPauseGame();
    }

}