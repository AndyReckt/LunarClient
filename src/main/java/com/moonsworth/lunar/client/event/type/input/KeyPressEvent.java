package com.moonsworth.lunar.client.event.type.input;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.CancellableEvent;
import com.moonsworth.lunar.client.event.handler.UIEventHandler;
import com.moonsworth.lunar.client.event.state.KeyState;
import com.moonsworth.lunar.client.feature.type.replaymod.ReplayMod;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BindableSetting;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;

import java.util.Set;

/**
 * @author Decencies
 * @since 10/07/2021 13:18
 */
public class KeyPressEvent extends CancellableEvent {
    public final KeyType lIlIlIlIlIIlIIlIIllIIIIIl;
    public final KeyState IlllIIIIIIlllIlIIlllIlIIl;

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(BindableSetting bindableSetting) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(bindableSetting, true);
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(BindableSetting bindableSetting, boolean bl) {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl == KeyType.KEY_NONE || this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl)) {
            return false;
        }
        if (!(Ref.getMinecraft().bridge$getCurrentScreen() != null || this.IlllIIIIIIlllIlIIlllIlIIl != KeyState.DOWN || this.lIlIlIlIlIIlIIlIIllIIIIIl != Bridge.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(bindableSetting.llIlllIIIllllIIlllIllIIIl()) || bl && UIEventHandler.lIlIlIlIlIIlIIlIIllIIIIIl())) {
            this.cancel();
            return true;
        }
        return false;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(LunarKeybindSetting lunarKeybindSetting) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(lunarKeybindSetting, true);
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(LunarKeybindSetting lunarKeybindSetting, boolean bl) {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl == KeyType.KEY_NONE || this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl)) {
            return false;
        }
        if (!(Ref.getMinecraft().bridge$getCurrentScreen() != null || this.IlllIIIIIIlllIlIIlllIlIIl != KeyState.DOWN || !lunarKeybindSetting.lIllIlIIIlIIIIIIIlllIlIll() || this.lIlIlIlIlIIlIIlIIllIIIIIl != lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl() || bl && UIEventHandler.lIlIlIlIlIIlIIlIIllIIIIIl())) {
            if (lunarKeybindSetting.llllIIlIIlIIlIIllIIlIIllI()) {
                this.cancel();
            }
            return true;
        }
        return false;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(LunarKeybindSetting lunarKeybindSetting, KeyState keyState) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(lunarKeybindSetting, keyState, true);
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(LunarKeybindSetting lunarKeybindSetting, KeyState keyState, boolean bl) {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl == KeyType.KEY_NONE || this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl)) {
            return false;
        }
        if (!(Ref.getMinecraft().bridge$getCurrentScreen() != null || keyState != this.IlllIIIIIIlllIlIIlllIlIIl || !lunarKeybindSetting.lIllIlIIIlIIIIIIIlllIlIll() || this.lIlIlIlIlIIlIIlIIllIIIIIl != lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl() || bl && UIEventHandler.lIlIlIlIlIIlIIlIIllIIIIIl())) {
            if (lunarKeybindSetting.llllIIlIIlIIlIIllIIlIIllI()) {
                this.cancel();
            }
            return true;
        }
        return false;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(BindableSetting bindableSetting, KeyState keyState) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(bindableSetting, keyState, true);
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(BindableSetting bindableSetting, KeyState keyState, boolean bl) {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl == KeyType.KEY_NONE || this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl)) {
            return false;
        }
        if (!(Ref.getMinecraft().bridge$getCurrentScreen() != null || keyState != this.IlllIIIIIIlllIlIIlllIlIIl || this.lIlIlIlIlIIlIIlIIllIIIIIl != Bridge.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(bindableSetting.llIlllIIIllllIIlllIllIIIl()) || bl && UIEventHandler.lIlIlIlIlIIlIIlIIllIIIIIl())) {
            this.cancel();
            return true;
        }
        return false;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(KeyType keyType) {
        ReplayMod replayMod = LunarClient.getInstance().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI();
        if (!replayMod.IlllIIIIIIlllIlIIlllIlIIl() || !replayMod.lIllllIllIIlIIlIIIlIIIlII().isViewingReplay()) {
            return false;
        }
        Set<KeyBindingBridge> set = LunarClient.getInstance().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().lIllllIllIIlIIlIIIlIIIlII().getKeyBindings();
        for (KeyBindingBridge keyBindingBridge : set) {
            if (keyBindingBridge.bridge$getKey() != keyType) continue;
            return true;
        }
        return false;
    }

    public KeyType lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public KeyState IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public KeyPressEvent(KeyType keyType, KeyState keyState) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = keyType;
        this.IlllIIIIIIlllIlIIlllIlIIl = keyState;
    }
}

