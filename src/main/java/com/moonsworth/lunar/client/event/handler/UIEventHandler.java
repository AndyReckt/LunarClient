package com.moonsworth.lunar.client.event.handler;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.*;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.event.EventWithResult;
import com.moonsworth.lunar.client.event.state.EventState;
import com.moonsworth.lunar.client.event.state.KeyState;
import com.moonsworth.lunar.client.event.type.gui.*;
import com.moonsworth.lunar.client.event.type.hud.RenderCrosshairEvent;
import com.moonsworth.lunar.client.event.type.hud.RenderNameEvent;
import com.moonsworth.lunar.client.event.type.input.KeyPressEvent;
import com.moonsworth.lunar.client.event.type.network.ServerDisconnectEvent;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.UIScreenCloseException;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.login.MainMenuLoginUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIEventHandler implements EventHandler {
    public long lIlIlIlIlIIlIIlIIllIIIIIl;
    public boolean IlllIIIIIIlllIlIIlllIlIIl;
    public final List<KeyBindingBridge> lIllIlIIIlIIIIIIIlllIlIll = ImmutableList.of(Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindForward(), Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindLeft(), Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindRight(), Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindBack(), Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindSprint(), Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindSneak(), Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindJump());
    public long llIlllIIIllllIIlllIllIIIl;
    public static long llllIIlIIlIIlIIllIIlIIllI;

    public UIEventHandler() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiOpenEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(CloseCustomScreenEvent.class, this::onClose);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiPostOpenEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyPressEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiResizeEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiCloseEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderCrosshairEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderNameEvent.class, renderNameEvent -> {
            if (!Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().isNametagsEnabled()) {
                renderNameEvent.setCancelled(true);
                renderNameEvent.lIlIlIlIlIIlIIlIIllIIIIIl(new ArrayList<>());
                renderNameEvent.lIlIlIlIlIIlIIlIIllIIIIIl("");
            }
        });
        this.IlllIIIIIIlllIlIIlllIlIIl = true;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent serverDisconnectEvent) {
        if (Bridge.getMinecraftVersion() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl) {
            return;
        }
        Ref.getMinecraft().bridge$getGuiIngame().bridge$resetTitleTimer();
    }

    public boolean canClose(AbstractUIScreen abstractUIScreen) {
        return abstractUIScreen.llIIIlIllIIIIlIIIlIlIllIl().stream().filter(uIComponent -> uIComponent instanceof UIScreenCloseException).anyMatch(uIComponent -> ((UIScreenCloseException) uIComponent).shouldCancel());
    }

    public void onClose(CloseCustomScreenEvent closeCustomScreenEvent) {
        if (!(closeCustomScreenEvent.getCustomScreen() instanceof AbstractUIScreen)) {
            return;
        }
        if (this.canClose((AbstractUIScreen)closeCustomScreenEvent.getCustomScreen())) {
            closeCustomScreenEvent.setCancelled(true);
        }
    }

    public static boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        if (llllIIlIIlIIlIIllIIlIIllI == 0L) {
            return false;
        }
        return System.nanoTime() - llllIIlIIlIIlIIllIIlIIllI <= TimeUnit.MILLISECONDS.toNanos(500L);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiCloseEvent guiCloseEvent) {
        if (guiCloseEvent.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof GuiChatBridge) {
            llllIIlIIlIIlIIllIIlIIllI = System.nanoTime();
        }
        if (guiCloseEvent.IlllIIIIIIlllIlIIlllIlIIl() != null && guiCloseEvent.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof WrappedGuiScreenBridge && ((WrappedGuiScreenBridge)guiCloseEvent.lIlIlIlIlIIlIIlIIllIIIIIl()).getCustomScreen().IlIlIlllllIlIIlIlIlllIlIl()) {
            Ref.getMinecraft().bridge$getGameSettings().bridge$unpressAllKeys();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderCrosshairEvent renderCrosshairEvent) {
        if (Ref.getMinecraft().bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge && !LunarClient.getInstance().lllllIllIllIllllIlIllllII().IIlIllIlIIllIIlIlIllllllI().llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl()) {
            renderCrosshairEvent.lIlIlIlIlIIlIIlIIllIIIIIl(EventWithResult.EventStateResult.DENY);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(KeyPressEvent keyPressEvent) {
        if (keyPressEvent.IlllIIIIIIlllIlIIlllIlIIl() == KeyState.DOWN) {
            LunarKeybindSetting lunarKeybindSetting = Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().getFriendMenuBind();
            if (!(!this.lIllIlIIIlIIIIIIIlllIlIll() || UIEventHandler.lIlIlIlIlIIlIIlIIllIIIIIl() || Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllllllllllIlIIIlllIlllll().llIlllIIIllllIIlllIllIIIl() || !lunarKeybindSetting.IlllIIIIIIlllIlIIlllIlIIl() || lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() || lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() || lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl())) {
                keyPressEvent.cancel();
                this.IlllIIIIIIlllIlIIlllIlIIl();
                return;
            }
            if (lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() && keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == KeyType.KEY_LSHIFT || lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() && keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == KeyType.KEY_LMENU || lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() && keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == KeyType.KEY_LCONTROL) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl = System.nanoTime();
            } else if (!Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllllllllllIlIIIlllIlllll().llIlllIIIllllIIlllIllIIIl() && lunarKeybindSetting.IlllIIIIIIlllIlIIlllIlIIl() && this.lIlIlIlIlIIlIIlIIllIIIIIl != 0L && (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LSHIFT) || Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LMENU) || AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) && System.nanoTime() - this.lIlIlIlIlIIlIIlIIllIIIIIl <= TimeUnit.MILLISECONDS.toNanos(500L)) {
                this.IlllIIIIIIlllIlIIlllIlIIl();
                keyPressEvent.cancel();
                return;
            }
        }
        if (Ref.getMinecraft().bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge && ((WrappedGuiScreenBridge)Ref.getMinecraft().bridge$getCurrentScreen()).getCustomScreen().IlIlIlllllIlIIlIlIlllIlIl()) {
            for (KeyBindingBridge keyBindingBridge : this.lIllIlIIIlIIIIIIIlllIlIll) {
                if (keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl() != keyBindingBridge.bridge$getKey()) continue;
                boolean bl = Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl());
                if (!bl && keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindSprint().bridge$getKey()) {
                    Ref.getPlayer().bridge$setSprinting(false);
                }
                keyBindingBridge.bridge$setKeyBindState(bl);
            }
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl() {
        if (Ref.getMinecraft().bridge$getCurrentScreen() instanceof GuiAchievementsBridge) {
            return;
        }
        if (Ref.getMinecraft().bridge$getCurrentScreen() != null && Ref.getMinecraft().bridge$getCurrentScreen().lIlIlIlIlIIlIIlIIllIIIIIl(FriendsUIScreen.class) && System.nanoTime() - this.llIlllIIIllllIIlllIllIIIl > TimeUnit.MILLISECONDS.toNanos(250L)) {
            Ref.getMinecraft().bridge$displayScreen(FriendsUIScreen.llIIIIIIIllIIllIlIllIIIIl().llIlIIIllIIlIllIllIllllIl());
            this.llIlllIIIllllIIlllIllIIIl = 0L;
        } else {
            Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(FriendsUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getMinecraft().bridge$getCurrentScreen())));
            this.llIlllIIIllllIIlllIllIIIl = System.nanoTime();
        }
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        GuiScreenBridge guiScreenBridge = Ref.getMinecraft().bridge$getCurrentScreen();
        if (guiScreenBridge == null) {
            return true;
        }
        if (guiScreenBridge instanceof GuiChatBridge || guiScreenBridge instanceof GuiNewChatBridge) {
            return false;
        }
        if (guiScreenBridge instanceof WrappedGuiScreenBridge) {
            CustomScreen customScreen = ((WrappedGuiScreenBridge)guiScreenBridge).getCustomScreen();
            return !(customScreen instanceof AbstractUIScreen) || !this.canClose((AbstractUIScreen)customScreen);
        }
        return true;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiPostOpenEvent guiPostOpenEvent) {
        if (guiPostOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof WrappedGuiScreenBridge && ((WrappedGuiScreenBridge)guiPostOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl()).getCustomScreen().IlIlIlllllIlIIlIlIlllIlIl()) {
            for (KeyBindingBridge keyBindingBridge : this.lIllIlIIIlIIIIIIIlllIlIll) {
                if (!Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(keyBindingBridge.bridge$getKey())) continue;
                Ref.getMinecraft().bridge$getGameSettings().bridge$setKeyBindState(keyBindingBridge.bridge$getKey(), true);
            }
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiOpenEvent guiOpenEvent) {
        if (Ref.getWorld() == null && !Ref.getLC().llIlIIIllIIlIllIllIllllIl().llIIIlllIIlllIllllIlIllIl()) {
            guiOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.getInstance().initCustomScreen(new MainMenuLoginUIScreen()));
            return;
        }
        if (guiOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl() != null) {
            if (guiOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof GuiMainMenuBridge) {
                guiOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.getInstance().initCustomScreen(new MainMenuUIScreen()));
            }
        } else if (Ref.getWorld() == null) {
            guiOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.getInstance().initCustomScreen(new MainMenuUIScreen()));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiResizeEvent guiResizeEvent) {
        if (guiResizeEvent.lIlIlIlIlIIlIIlIIllIIIIIl() != EventState.POST) {
            return;
        }
        if (guiResizeEvent.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIlIlIIlIIlIIllIIIIIl(GuiIngameMenuBridge.class)) {
            if (this.IlllIIIIIIlllIlIIlllIlIIl && Ref.getMinecraft().bridge$getGameSettings().bridge$getChatScale() == 0.0f) {
                Ref.getMinecraft().bridge$getGameSettings().bridge$setOptionFloatValue(25, 1.0f);
            }
            this.IlllIIIIIIlllIlIIlllIlIIl = false;
        }
    }
}