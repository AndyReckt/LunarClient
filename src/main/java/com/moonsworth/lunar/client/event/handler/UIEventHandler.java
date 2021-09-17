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
import com.moonsworth.lunar.client.setting.KeyBind;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.BooleanCallbackSetting;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuLoginUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIEventHandler
implements EventHandler {
    public long lIlIlIlIlIIlIIlIIllIIIIIl;
    public boolean IlllIIIIIIlllIlIIlllIlIIl;
    public final List<KeyBindingBridge> lIllIlIIIlIIIIIIIlllIlIll = ImmutableList.of(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$keyBindForward(), Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$keyBindLeft(), Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$keyBindRight(), Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$keyBindBack(), Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$keyBindSprint(), Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$keyBindSneak(), Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$keyBindJump());
    public long llIlllIIIllllIIlllIllIIIl;
    public static long llllIIlIIlIIlIIllIIlIIllI;

    public UIEventHandler() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiOpenEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(CloseCustomScreenEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiPostOpenEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyPressEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiResizeEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiCloseEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderCrosshairEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderNameEvent.class, renderNameEvent -> {
            if (!Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().llIlIIIllIIlIllIllIllllIl()) {
                renderNameEvent.setCancelled(true);
                renderNameEvent.lIlIlIlIlIIlIIlIIllIIIIIl(new ArrayList());
                renderNameEvent.lIlIlIlIlIIlIIlIIllIIIIIl("");
            }
        });
        this.IlllIIIIIIlllIlIIlllIlIIl = true;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ServerDisconnectEvent serverDisconnectEvent) {
        if (Bridge.IlllIIIIIIlllIlIIlllIlIIl() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl) {
            return;
        }
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGuiIngame().bridge$resetTitleTimer();
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(AbstractUIScreen abstractUIScreen) {
        return abstractUIScreen.llIIIlIllIIIIlIIIlIlIllIl().stream().filter(uIComponent -> uIComponent instanceof BooleanCallbackSetting).anyMatch(uIComponent -> ((BooleanCallbackSetting)((Object)uIComponent)).c_());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(CloseCustomScreenEvent closeCustomScreenEvent) {
        if (!(closeCustomScreenEvent.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof AbstractUIScreen)) {
            return;
        }
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl((AbstractUIScreen)closeCustomScreenEvent.lIlIlIlIlIIlIIlIIllIIIIIl())) {
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
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$unpressAllKeys();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderCrosshairEvent renderCrosshairEvent) {
        if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge && !((Boolean) LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIllIllllIlIllllII().IIlIllIlIIllIIlIlIllllllI().llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl()).booleanValue()) {
            renderCrosshairEvent.lIlIlIlIlIIlIIlIIllIIIIIl(EventWithResult.EventStateResult.IlllIIIIIIlllIlIIlllIlIIl);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(KeyPressEvent keyPressEvent) {
        if (keyPressEvent.IlllIIIIIIlllIlIIlllIlIIl() == KeyState.DOWN) {
            LunarKeybindSetting lunarKeybindSetting = Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().lllIIIIIlllIIlIllIIlIIIlI();
            if (!(!this.lIllIlIIIlIIIIIIIlllIlIll() || UIEventHandler.lIlIlIlIlIIlIIlIIllIIIIIl() || ((Boolean)Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllllllllllIlIIIlllIlllll().llIlllIIIllllIIlllIllIIIl()).booleanValue() || !lunarKeybindSetting.IlllIIIIIIlllIlIIlllIlIIl() || ((KeyBind)lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl()).lIllIlIIIlIIIIIIIlllIlIll() || ((KeyBind)lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl()).lIlIlIlIlIIlIIlIIllIIIIIl() || ((KeyBind)lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl())) {
                keyPressEvent.cancel();
                this.IlllIIIIIIlllIlIIlllIlIIl();
                return;
            }
            if (((KeyBind)lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl() && keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == KeyType.IlIlIllIIllllIllllllIIlIl || ((KeyBind)lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl()).lIlIlIlIlIIlIIlIIllIIIIIl() && keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == KeyType.llIIIIllIlIIlIlIIlllIllIl || ((KeyBind)lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl()).lIllIlIIIlIIIIIIIlllIlIll() && keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == KeyType.llIllIIIIlIIIIIIlllIllIlI) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl = System.nanoTime();
            } else if (!((Boolean)Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllllllllllIlIIIlllIlllll().llIlllIIIllllIIlllIllIIIl()).booleanValue() && lunarKeybindSetting.IlllIIIIIIlllIlIIlllIlIIl() && this.lIlIlIlIlIIlIIlIIllIIIIIl != 0L && (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlIllIIllllIllllllIIlIl) || Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.llIIIIllIlIIlIlIIlllIllIl) || AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) && System.nanoTime() - this.lIlIlIlIlIIlIIlIIllIIIIIl <= TimeUnit.MILLISECONDS.toNanos(500L)) {
                this.IlllIIIIIIlllIlIIlllIlIIl();
                keyPressEvent.cancel();
                return;
            }
        }
        if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge && ((WrappedGuiScreenBridge)Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen()).getCustomScreen().IlIlIlllllIlIIlIlIlllIlIl()) {
            for (KeyBindingBridge keyBindingBridge : this.lIllIlIIIlIIIIIIIlllIlIll) {
                if (keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl() != keyBindingBridge.bridge$getKey()) continue;
                boolean bl = Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl());
                if (!bl && keyPressEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$keyBindSprint().bridge$getKey()) {
                    Ref.IlIlIlllllIlIIlIlIlllIlIl().bridge$setSprinting(false);
                }
                keyBindingBridge.bridge$setKeyBindState(bl);
            }
            return;
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl() {
        if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen() instanceof GuiAchievementsBridge) {
            return;
        }
        if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen() != null && Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen().lIlIlIlIlIIlIIlIIllIIIIIl(FriendsUIScreen.class) && System.nanoTime() - this.llIlllIIIllllIIlllIllIIIl > TimeUnit.MILLISECONDS.toNanos(250L)) {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(FriendsUIScreen.llIIIIIIIllIIllIlIllIIIIl().llIlIIIllIIlIllIllIllllIl());
            this.llIlllIIIllllIIlllIllIIIl = 0L;
        } else {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(FriendsUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen())));
            this.llIlllIIIllllIIlllIllIIIl = System.nanoTime();
        }
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        GuiScreenBridge guiScreenBridge = Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen();
        if (guiScreenBridge == null) {
            return true;
        }
        if (guiScreenBridge instanceof GuiChatBridge || guiScreenBridge instanceof GuiNewChatBridge) {
            return false;
        }
        if (guiScreenBridge instanceof WrappedGuiScreenBridge) {
            CustomScreen customScreen = ((WrappedGuiScreenBridge)guiScreenBridge).getCustomScreen();
            return !(customScreen instanceof AbstractUIScreen) || !this.lIlIlIlIlIIlIIlIIllIIIIIl((AbstractUIScreen)customScreen);
        }
        return true;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiPostOpenEvent guiPostOpenEvent) {
        if (guiPostOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof WrappedGuiScreenBridge && ((WrappedGuiScreenBridge)guiPostOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl()).getCustomScreen().IlIlIlllllIlIIlIlIlllIlIl()) {
            for (KeyBindingBridge keyBindingBridge : this.lIllIlIIIlIIIIIIIlllIlIll) {
                if (!Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(keyBindingBridge.bridge$getKey())) continue;
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$setKeyBindState(keyBindingBridge.bridge$getKey(), true);
            }
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiOpenEvent guiOpenEvent) {
        if (Ref.llIIIIIIIllIIllIlIllIIIIl() == null && !Ref.IlllIIIIIIlllIlIIlllIlIIl().llIlIIIllIIlIllIllIllllIl().llIIIlllIIlllIllllIlIllIl()) {
            guiOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuLoginUIScreen()));
            return;
        }
        if (guiOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl() != null) {
            if (guiOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof GuiMainMenuBridge) {
                guiOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIScreen()));
            }
        } else if (Ref.llIIIIIIIllIIllIlIllIIIIl() == null) {
            guiOpenEvent.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIScreen()));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GuiResizeEvent guiResizeEvent) {
        if (guiResizeEvent.lIlIlIlIlIIlIIlIIllIIIIIl() != EventState.POST) {
            return;
        }
        if (guiResizeEvent.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIlIlIIlIIlIIllIIIIIl(GuiIngameMenuBridge.class)) {
            if (this.IlllIIIIIIlllIlIIlllIlIIl && Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$getChatScale() == 0.0f) {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$setOptionFloatValue(25, 1.0f);
            }
            this.IlllIIIIIIlllIlIIlllIlIIl = false;
        }
    }
}