package com.moonsworth.lunar.client.profile.main;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.json.file.JsonFile;
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
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Set;

@Getter
public class ControlsMenu extends ItemSetLoader<AbstractSetting<?>> implements JsonFile {
    public BindableSetting modMenuBind;
    public BindableSetting waypointsBind;
    public BindableSetting emoteBind;
    public LunarKeybindSetting dropStackBind;
    public LunarKeybindSetting friendMenuBind;
    public LunarKeybindSetting nametagsBind;
    @Setter
    public boolean nametagsEnabled = true;

    public ControlsMenu() {
        this.modMenuBind.lIlIlIlIlIIlIIlIIllIIIIIl(() -> Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MovementUI()))).lIlIlIlIlIIlIIlIIllIIIIIl(true).IlllIIIIIIlllIlIIlllIlIIl(true);
        this.emoteBind.IlllIIIIIIlllIlIIlllIlIIl(true).lIlIlIlIlIIlIIlIIllIIIIIl(true).lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (Ref.getLC().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll()) {
                return;
            }
            if (!Ref.getAssetsWebsocket().isPresent() || Ref.getAssetsWebsocket().get().lIlIlIlIlIIlIIlIIllIIIIIl() != WebSocketState.READY) {
                return;
            }
            if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_F3)) {
                return;
            }
            Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new EmotesRadialMenuUIScreen(this.emoteBind.g_())));
        });
        this.nametagsBind.IlllIIIIIIlllIlIIlllIlIIl(true).lIlIlIlIlIIlIIlIIllIIIIIl(true).lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (Ref.getWorld() != null) {
                Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().setNametagsEnabled(!Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().isNametagsEnabled());
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl("Nametags are " + (Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llIIIIIIIllIIllIlIllIIIIl().isNametagsEnabled() ? "now" : "no longer") + " enabled.");
            }
        });
        this.waypointsBind.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (Ref.getWorld() != null) {
                SettingsUIScreen settingsUIScreen = new SettingsUIScreen(Ref.getMinecraft().bridge$getCurrentScreen());
                Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(settingsUIScreen));
                settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(new WaypointsListUIComponent(settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl()));
                settingsUIScreen.llIlllIIIllllIIlllIllIIIl(2);
            }
        });
    }

    @Override
    public Set<AbstractSetting<?>> lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.modMenuBind = new BindableSetting("mod_menu", KeyType.KEY_RSHIFT);
        this.waypointsBind = new BindableSetting("waypoints", KeyType.KEY_M);
        this.emoteBind = new BindableSetting("emote", KeyType.KEY_B);
        this.dropStackBind = new LunarKeybindSetting("dropStack", KeyType.KEY_LCONTROL, false);
        this.friendMenuBind = new LunarKeybindSetting("friendMenuKey", new KeyBind(false, true, false, KeyType.KEY_TAB));
        this.nametagsBind = new LunarKeybindSetting("toggleNametags", KeyType.KEY_NONE);
        return ImmutableSet.of(this.modMenuBind, this.waypointsBind, this.emoteBind, this.dropStackBind, this.friendMenuBind, this.nametagsBind, Ref.getLC().lllllIllIllIllllIlIllllII().lllIIIIIlllIIlIllIIlIIIlI().IlIllIIlIIlIIIllIllllIIll());
    }

    @Override
    public void b_() {
        super.b_();
        this.load();
    }

    @Override
    public File IlIlIlllllIlIIlIlIlllIlIl() {
        return new File(LunarClient.getInstance().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().getSelectedProfile().getName(), this.llllIIlIIlIIlIIllIIlIIllI());
    }

    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "controls.json";
    }

    @Override
    public void read(JsonObject jsonObject) {
        for (AbstractSetting<?> abstractSetting : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                abstractSetting.read(jsonObject);
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void write(JsonObject jsonObject) {
        for (AbstractSetting<?> abstractSetting : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                abstractSetting.write(jsonObject);
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.save();
    }
}
