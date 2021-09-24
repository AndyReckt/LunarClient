package com.moonsworth.lunar.mixin.client.gui;

import com.google.common.collect.ImmutableSet;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiButtonBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ChatComponentTextBridge;
import com.moonsworth.lunar.bridge.minecraft.util.IChatComponentBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.impl.type.keyboard.KeyboardImplementation;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.state.EventState;
import com.moonsworth.lunar.client.event.type.gui.*;
import com.moonsworth.lunar.client.event.type.input.MouseScrollEvent;
import com.moonsworth.lunar.client.feature.type.blur.MenuBlurMod;
import com.moonsworth.lunar.client.feature.type.tooltips.ScrollableTooltipsMod;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ScaledResolutionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Decencies
 * @since 13/07/2021 23:00
 */
@Mixin(GuiScreen.class)
public abstract class MixinGuiScreen extends Gui implements GuiScreenBridge {

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
    protected abstract void drawHoveringText(List var1, int var2, int var3);

    @Shadow
    public abstract boolean doesGuiPauseGame();

    @Shadow
    public abstract void handleKeyboardInput();

    @Shadow
    protected abstract void actionPerformed(GuiButton var1);

    @Override
    public void bridge$drawScreen(int n, int n2, float f) {
        this.drawScreen(n, n2, f);
    }

    @Override
    public void bridge$setWorldAndResolution(MinecraftBridge minecraftBridge, int n, int n2) {
        this.setWorldAndResolution((Minecraft)minecraftBridge, n, n2);
    }


    public void handler$zdc000$impl$setWorldAndResolution(Minecraft minecraft, int n, int n2, CallbackInfo callbackInfo) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(new ScaledResolutionHelper(Ref.getMinecraft()));
    }


    public void handler$zdc000$impl$setWorldAndResolution$tail(Minecraft minecraft, int n, int n2, CallbackInfo callbackInfo) {
        EventBus.getInstance().call(new GuiResizeEvent(EventState.POST, this));
    }


    public void handler$zdc000$impl$setWorldAndResolution$pre(Minecraft minecraft, int n, int n2, CallbackInfo callbackInfo) {
        EventBus.getInstance().call(new GuiResizeEvent(EventState.PRE, this));
    }

    //@Proxy(value="handleMouseInput")

    public void asppppepspshaaappaeaepahh() {
        GuiMouseClickPreEvent guiMouseClickPreEvent = new GuiMouseClickPreEvent();
        EventBus.getInstance().call(guiMouseClickPreEvent);
        if (guiMouseClickPreEvent.isCancelled()) {
            return;
        }
        this.handleMouseInput();
        this.handler$zdc000$impl$onMouseScroll(new CallbackInfo("handleMouseInput", false));
    }

    //@Proxy(value="handleKeyboardInput")

    public void hahesesaphpepssashaaphpee() {
        GuiKeyboardInputEvent guiKeyboardInputEvent = new GuiKeyboardInputEvent();
        EventBus.getInstance().call(guiKeyboardInputEvent);
        if (guiKeyboardInputEvent.isCancelled()) {
            return;
        }
        this.handleKeyboardInput();
    }

    @Override

    public void bridge$mouseClicked(int n, int n2, int n3) {
        this.mouseClicked(n, n2, n3);
    }

    @Override

    public void bridge$mouseReleased(int n, int n2, int n3) {
        this.mouseReleased(n, n2, n3);
    }


    public void handler$zdc000$impl$onMouseScroll(CallbackInfo callbackInfo) {
        int n = Mouse.getEventDWheel();
        if (n != 0) {
            EventBus.getInstance().call(new MouseScrollEvent(n));
        }
    }


    public void redirect$zdc000$impl$onDrawItemTooltip(GuiScreen guiScreen, List<String> list, int n, int n2, ItemStack itemStack) {
        this.renderedTooltip = true;
        List<ChatComponentTextBridge> list2 = list.stream().map(Bridge.getInstance()::initChatText).collect(Collectors.toList());
        DrawTooltipEvent drawTooltipEvent = new DrawTooltipEvent(this, list2, n, n2, (ItemStackBridge) itemStack);
        EventBus.getInstance().call(drawTooltipEvent);
        if (drawTooltipEvent.isCancelled()) {
            return;
        }
        this.drawHoveringText(list, n, n2);
        this.renderedTooltip = false;
    }


    public void redirect$zdc000$impl$onMouseClicked(GuiScreen guiScreen, GuiButton guiButton) {
        GuiButtonClickEvent guiButtonClickEvent = new GuiButtonClickEvent((GuiScreenBridge) guiScreen, (GuiButtonBridge) guiButton);
        EventBus.getInstance().call(guiButtonClickEvent);
        if (!guiButtonClickEvent.isCancelled()) {
            this.actionPerformed(guiButton);
        }
    }

    @Override

    public void bridge$drawScrollableHoveringText(List<IChatComponentBridge> list, int n, int n2) {
        if (!list.isEmpty()) {
            int n3;
            GL11.glDisable(32826);
            RenderHelper.disableStandardItemLighting();
            GL11.glDisable(2896);
            GL11.glDisable(2929);
            int n4 = 0;
            for (IChatComponentBridge iChatComponentBridge : list) {
                if (!(iChatComponentBridge instanceof ChatComponentTextBridge) || (n3 = this.fontRendererObj.getStringWidth(((ChatComponentTextBridge)iChatComponentBridge).bridge$getRawText())) <= n4) continue;
                n4 = n3;
            }
            int n5 = Minecraft.getMinecraft().displayWidth;
            int n6 = n + 12;
            n3 = n2 - 12;
            int n7 = 8;
            boolean bl = false;
            boolean bl2 = false;
            if (list.size() > 1) {
                n7 += 2 + (list.size() - 1) * 10;
            }
            if (n4 + n6 > this.width) {
                n6 -= 28 + n4;
            }
            if (n6 < 0) {
                n6 = n + 12;
            }
            if (n6 < 12) {
                bl = true;
            } else if (n6 + n4 >= this.width) {
                bl = true;
            }
            if (n3 + n7 + 6 > this.height) {
                n3 = this.height - n7 - 6;
            }
            if (this.lastMaxHeight != (double)n7 && ScrollableTooltipsMod.IlIlIlllllIlIIlIlIlllIlIl != 0) {
                ScrollableTooltipsMod.IlIlIlllllIlIIlIlIlllIlIl = 0;
            }
            this.lastMaxHeight = n7;
            this.lastDrawY = n3;
            if (n3 < 6) {
                bl2 = true;
            } else if (n3 + n7 >= this.height - 6) {
                bl2 = true;
            }
            if (!bl2) {
                ScrollableTooltipsMod.IlIlIlllllIlIIlIlIlllIlIl = 0;
                this.lastDrawY = 0.0;
            }
            if (!bl) {
                ScrollableTooltipsMod.llllIIlIIlIIlIIllIIlIIllI = 0;
            }
            this.zLevel = 300.0f;
            this.itemRender.zLevel = 300.0f;
            int n8 = -267386864;
            int n9 = Mouse.getDWheel();
            if (n9 != 0) {
                LunarKeybindSetting lunarKeybindSetting = Ref.getLC().lllllIllIllIllllIlIllllII().lIIlIIIIIIlIIlIIllIlIIlII().IlIllIIlIIlIIIllIllllIIll();
                if (lunarKeybindSetting.IlllIIIIIIlllIlIIlllIlIIl() && bl) {
                    ScrollableTooltipsMod.llllIIlIIlIIlIIllIIlIIllI = n9 < 0 ? (ScrollableTooltipsMod.llllIIlIIlIIlIIllIIlIIllI -= 10) : (ScrollableTooltipsMod.llllIIlIIlIIlIIllIIlIIllI += 10);
                } else if (bl2) {
                    if (n9 < 0) {
                        if (n7 + n3 + ScrollableTooltipsMod.IlIlIlllllIlIIlIlIlllIlIl > this.height - 6) {
                            ScrollableTooltipsMod.IlIlIlllllIlIIlIlIlllIlIl -= 10;
                        }
                    } else if (n3 + ScrollableTooltipsMod.IlIlIlllllIlIIlIlIlllIlIl <= 6) {
                        ScrollableTooltipsMod.IlIlIlllllIlIIlIlIlllIlIl += 10;
                    }
                }
            }
            GlStateManager.pushAttrib();
            GlStateManager.color(ScrollableTooltipsMod.llllIIlIIlIIlIIllIIlIIllI, ScrollableTooltipsMod.IlIlIlllllIlIIlIlIlllIlIl, 0.0f);
            this.drawGradientRect(n6 - 3, n3 - 4, n6 + n4 + 3, n3 - 3, n8, n8);
            this.drawGradientRect(n6 - 3, n3 + n7 + 3, n6 + n4 + 3, n3 + n7 + 4, n8, n8);
            this.drawGradientRect(n6 - 3, n3 - 3, n6 + n4 + 3, n3 + n7 + 3, n8, n8);
            this.drawGradientRect(n6 - 4, n3 - 3, n6 - 3, n3 + n7 + 3, n8, n8);
            this.drawGradientRect(n6 + n4 + 3, n3 - 3, n6 + n4 + 4, n3 + n7 + 3, n8, n8);
            int n10 = 0x505000FF;
            int n11 = (n10 & 0xFEFEFE) >> 1 | n10 & 0xFF000000;
            this.drawGradientRect(n6 - 3, n3 - 3 + 1, n6 - 3 + 1, n3 + n7 + 3 - 1, n10, n11);
            this.drawGradientRect(n6 + n4 + 2, n3 - 3 + 1, n6 + n4 + 3, n3 + n7 + 3 - 1, n10, n11);
            this.drawGradientRect(n6 - 3, n3 - 3, n6 + n4 + 3, n3 - 3 + 1, n10, n10);
            this.drawGradientRect(n6 - 3, n3 + n7 + 2, n6 + n4 + 3, n3 + n7 + 3, n11, n11);
            for (int i = 0; i < list.size(); ++i) {
                IChatComponentBridge iChatComponentBridge = list.get(i);
                if (!(iChatComponentBridge instanceof ChatComponentTextBridge)) continue;
                String string = ((ChatComponentTextBridge)iChatComponentBridge).bridge$getRawText();
                this.fontRendererObj.drawStringWithShadow(string, n6, n3, -1);
                if (i == 0) {
                    n3 += 2;
                }
                n3 += 10;
            }
            this.zLevel = 0.0f;
            this.itemRender.zLevel = 0.0f;
            GlStateManager.popAttrib();
            GL11.glEnable(2896);
            GL11.glEnable(2929);
            RenderHelper.enableStandardItemLighting();
            GL11.glEnable(32826);
        }
    }

    @Override

    public void bridge$onGuiClosed() {
        this.onGuiClosed();
    }

    @Override

    public void bridge$updateScreen() {
        this.updateScreen();
    }

    @Override

    public void bridge$keyTyped(char c, KeyType keyType) {
        this.keyTyped(c, KeyboardImplementation.llIlllIIIllllIIlllIllIIIl(keyType));
    }

    @Override

    public void bridge$handleMouseInput() {
        this.asppppepspshaaappaeaepahh();
    }

    @Override

    public void bridge$setClickedLinkURI(URI uRI) {
        this.clickedLinkURI = uRI;
    }

    @Override

    public boolean bridge$isControlsGui() {
        return (GuiScreenBridge) this instanceof GuiControls;
    }


    public void handler$zdc000$impl$renderLunarClientBrand(CallbackInfo callbackInfo) {
        MenuBlurMod menuBlurMod = LunarClient.getInstance().lllllIllIllIllllIlIllllII().lIllllIllIIlIIlIIIlIIIlII();
        GuiScreenBridge guiScreen = this;
        if (menuBlurMod.IlllIIIIIIlllIlIIlllIlIIl() && menuBlurMod.IlllIIIIIIlllIlIIlllIlIIl(guiScreen)) {
            menuBlurMod.lIllllIllIIlIIlIIIlIIIlII();
        }
        if (!Ref.getLC().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().lIllllIllIIlIIlIIIlIIIlII().shouldRenderBrand(guiScreen)) {
            return;
        }
        if (!HIDE_BRAND_ON.contains(this.getClass()) && !(guiScreen instanceof GuiChat)) {
            AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.width, this.height);
        }
    }


    private void redirect$zdc000$impl$menuBlurGradient(GuiScreen guiScreen, int n, int n2, int n3, int n4, int n5, int n6) {
        Optional<Integer> optional;
        MenuBlurMod menuBlurMod = LunarClient.getInstance().lllllIllIllIllllIlIllllII().lIllllIllIIlIIlIIIlIIIlII();
        GuiScreenBridge guiScreen2 = this;
        if (menuBlurMod.IlllIIIIIIlllIlIIlllIlIIl() && (optional = menuBlurMod.lIlIlIlIlIIlIIlIIllIIIIIl(guiScreen2)).isPresent()) {
            n5 = n6 = optional.get();
        }
        guiScreen.drawGradientRect(n, n2, n3, n4, n5, n6);
    }


    private static void handler$zdc000$lunar$blurMenus(CallbackInfo callbackInfo) {
        MenuBlurMod menuBlurMod = LunarClient.getInstance().lllllIllIllIllllIlIllllII().lIllllIllIIlIIlIIIlIIIlII();
        List list = menuBlurMod.IIIlIIIIIIllIIIIllIIIIlII().llIlllIIIllllIIlllIllIIIl();
        list.add(GuiIngameMenu.class);
        list.add(GuiVideoSettings.class);
        list.add(GuiOptions.class);
        List list2 = menuBlurMod.lIIlllIIIIIlllIIIlIlIlllI().llIlllIIIllllIIlllIllIIIl();
        list2.add(GuiInventory.class);
        list2.add(GuiContainer.class);
    }

    @Override

    public boolean bridge$allowUserInput() {
        return this.allowUserInput;
    }

    @Override

    public boolean bridge$doesGuiPauseGame() {
        return this.doesGuiPauseGame();
    }


    public void handler$zhk000$impl$renderToolTip(ItemStack itemStack, int n, int n2, CallbackInfo callbackInfo) {
//        ReturnValue returnValue = new ReturnValue();
//        GuiScreenHook.renderBackpack(itemStack, n, n2, returnValue);
//        if (returnValue.isCancelled()) {
//            callbackInfo.cancel();
//        }
    }


    public void handler$zhk000$impl$handleComponentClick(IChatComponent iChatComponent, CallbackInfoReturnable callbackInfoReturnable) {
        //GuiScreenHook.handleComponentClick(iChatComponent);
    }


    private static void handler$zzi000$lunar$blurMenusOptiFine(CallbackInfo callbackInfo) {
//        MenuBlurMod menuBlurMod = LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIllIllllIlIllllII().lIllllIllIIlIIlIIIlIIIlII();
//        List list = menuBlurMod.IIIlIIIIIIllIIIIllIIIIlII().llIlllIIIllllIIlllIllIIIl();
//        list.add(GuiAnimationSettingsOF.class);
//        list.add(GuiDetailSettingsOF.class);
//        list.add(GuiQualitySettingsOF.class);
//        list.add(GuiPerformanceSettingsOF.class);
//        list.add(GuiOtherSettingsOF.class);
    }

}
