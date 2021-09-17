package com.moonsworth.lunar.client.profile.main;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.json.file.DefaultJson;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.BindableSetting;
import com.moonsworth.lunar.client.setting.KeyBind;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;
import com.moonsworth.lunar.client.ui.component.type.config.WaypointsListUIComponent;
import com.moonsworth.lunar.client.ui.screen.type.SettingsUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.emotes.EmotesRadialMenuUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.movement.MovementUI;
import com.moonsworth.lunar.client.websocket.AssetsWebSocket;
import com.moonsworth.lunar.client.websocket.WebSocketState;

import java.io.File;
import java.util.Set;

public class ControlsMenu
extends ItemSetLoader<AbstractSetting<?>>
implements DefaultJson {
    public BindableSetting lIlIlIlIlIIlIIlIIllIIIIIl;
    public BindableSetting IlllIIIIIIlllIlIIlllIlIIl;
    public BindableSetting lIllIlIIIlIIIIIIIlllIlIll;
    public LunarKeybindSetting llIlllIIIllllIIlllIllIIIl;
    public LunarKeybindSetting llllIIlIIlIIlIIllIIlIIllI;
    public LunarKeybindSetting IlIlIlllllIlIIlIlIlllIlIl;
    public boolean llIIIIIIIllIIllIlIllIIIIl = true;

    public ControlsMenu() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(() -> Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MovementUI()))).lIlIlIlIlIIlIIlIIllIIIIIl(true).IlllIIIIIIlllIlIIlllIlIIl(true);
        this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(true).lIlIlIlIlIIlIIlIIllIIIIIl(true).lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll()) {
                return;
            }
            if (!Ref.getAssetsWebsocket().isPresent() || ((AssetsWebSocket)Ref.getAssetsWebsocket().get()).lIlIlIlIlIIlIIlIIllIIIIIl() != WebSocketState.READY) {
                return;
            }
            if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IIlllIllIIlllllIllllllIII)) {
                return;
            }
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new EmotesRadialMenuUIScreen(this.lIllIlIIIlIIIIIIIlllIlIll.g_())));
        });
        this.IlIlIlllllIlIIlIlIlllIlIl.IlllIIIIIIlllIlIIlllIlIIl(true).lIlIlIlIlIIlIIlIIllIIIIIl(true).lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (Ref.llIIIIIIIllIIllIlIllIIIIl() != null) {
                Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(!Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().llIlIIIllIIlIllIllIllllIl());
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl("Nametags are " + (Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().llIlIIIllIIlIllIllIllllIl() ? "now" : "no longer") + " enabled.");
            }
        });
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (Ref.llIIIIIIIllIIllIlIllIIIIl() != null) {
                SettingsUIScreen settingsUIScreen = new SettingsUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen());
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(settingsUIScreen));
                settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(new WaypointsListUIComponent(settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl()));
                settingsUIScreen.llIlllIIIllllIIlllIllIIIl(2);
            }
        });
    }

    @Override
    public Set<AbstractSetting<?>> lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new BindableSetting("mod_menu", KeyType.IlIIIlIlIlIlIlIllIIllIIlI);
        this.IlllIIIIIIlllIlIIlllIlIIl = new BindableSetting("waypoints", KeyType.lIIIlllIIIIllllIlIIIlIIll);
        this.lIllIlIIIlIIIIIIIlllIlIll = new BindableSetting("emote", KeyType.lllIIIIIlllIIlIllIIlIIIlI);
        this.llIlllIIIllllIIlllIllIIIl = new LunarKeybindSetting("dropStack", KeyType.llIllIIIIlIIIIIIlllIllIlI, false);
        this.llllIIlIIlIIlIIllIIlIIllI = new LunarKeybindSetting("friendMenuKey", new KeyBind(false, true, false, KeyType.IllIlIIllIIlllIIllIlIlIII));
        this.IlIlIlllllIlIIlIlIlllIlIl = new LunarKeybindSetting("toggleNametags", KeyType.lIlIlIlIlIIlIIlIIllIIIIIl);
        return ImmutableSet.of(this.lIlIlIlIlIIlIIlIIllIIIIIl, this.IlllIIIIIIlllIlIIlllIlIIl, this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl, this.llllIIlIIlIIlIIllIIlIIllI, this.IlIlIlllllIlIIlIlIlllIlIl, Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().lllIIIIIlllIIlIllIIlIIIlI().IlIllIIlIIlIIIllIllllIIll());
    }

    @Override
    public void b_() {
        super.b_();
        this.load();
    }

    @Override
    public File IlIlIlllllIlIIlIlIlllIlIl() {
        return new File(LunarClient.IIllIlIllIlIllIllIllIllII().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + Ref.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIIIIIIllIlIIIIllIIII().llllIIlIIlIIlIIllIIlIIllI().IlllIIIIIIlllIlIIlllIlIIl(), this.llllIIlIIlIIlIIllIIlIIllI());
    }

    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "controls.json";
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        for (AbstractSetting abstractSetting : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                abstractSetting.IlllIIIIIIlllIlIIlllIlIIl(jsonObject);
            }
            catch (Exception exception) {}
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        for (AbstractSetting abstractSetting : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                abstractSetting.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject);
            }
            catch (Exception exception) {}
        }
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.save();
    }

    public BindableSetting IlllllIlIIIlIIlIIllIIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public BindableSetting llIIlIlIIIllIlIlIlIIlIIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public BindableSetting llIIIlllIIlllIllllIlIllIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public LunarKeybindSetting lllllIllIllIllllIlIllllII() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public LunarKeybindSetting lllIIIIIlllIIlIllIIlIIIlI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public LunarKeybindSetting lIlIIIIIIlIIIllllIllIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public boolean llIlIIIllIIlIllIllIllllIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.llIIIIIIIllIIllIlIllIIIIl = bl;
    }
}
 