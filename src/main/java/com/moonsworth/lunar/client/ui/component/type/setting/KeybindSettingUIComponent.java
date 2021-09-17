package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.BooleanCallbackSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;

/**
 * @author Decencies
 * @since 10/07/2021 18:10
 */
public class KeybindSettingUIComponent extends ClashesWithWarningUIComponent implements BooleanCallbackSetting {
    public boolean llIlIIIllIIlIllIllIllllIl;
    public KeyType IllIllIIIllIIIlIlIlIIIIll = null;

    public KeybindSettingUIComponent(LunarKeybindSetting lunarKeybindSetting, UIComponent uIComponent) {
        super(lunarKeybindSetting, uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new IlllIIIIIIlllIlIIlllIlIIl(this, (lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() ? "CTRL + " : (lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() ? "ALT + " : (lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() ? "SHIFT + " : ""))) + lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (!this.llIlIIIllIIlIllIllIllllIl && !lunarKeybindSetting.IlIlIlllllIlIIlIlIlllIlIl()) {
                return -2538942;
            }
            return -4275267;
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if ((n == 4 || n == 5 || n == 3 || n == 2) && this.llIlIIIllIIlIllIllIllllIl) {
                this.llIlIIIllIIlIllIllIllllIl = false;
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                lunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.valueOf("KEY_MOUSE" + (n + 1)), false, false, false);
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                return true;
            }
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                if (n == 1 && !this.llIlIIIllIIlIllIllIllllIl) {
                    lunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.lIlIlIlIlIIlIIlIIllIIIIIl, false, false, false);
                    this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                } else {
                    boolean bl = this.llIlIIIllIIlIllIllIllllIl = !this.llIlIIIllIIlIllIllIllllIl;
                    if (this.llIlIIIllIIlIllIllIllllIl) {
                        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl("?");
                    } else {
                        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl((lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() ? "CTRL + " : (lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() ? "ALT + " : (lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() ? "SHIFT + " : ""))) + lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                    }
                }
                return true;
            }
            return false;
        });
    }

    @Override
    public float IllIllIIIllIIIlIlIlIIIIll() {
        return this.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0f : 14.0f;
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl();
        if (this.IllIllIIIllIIIlIlIlIIIIll != null && this.llIlIIIllIIlIllIllIllllIl && !this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll)) {
            ((LunarKeybindSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll, false, false, false);
            this.llIlIIIllIIlIllIllIllllIl = false;
            this.IllIllIIIllIIIlIlIlIIIIll = null;
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(((LunarKeybindSetting)this.IlllIIIIIIlllIlIIlllIlIIl).llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.f_(), this.x, this.y + 1.5f, -4079426);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.width - 70.0f, this.y + 2.0f, 70.0f, 12.0f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        if (this.llIlIIIllIIlIllIllIllllIl) {
            if (keyType == KeyType.lIIIlIllllIIlIIlIIlIIIIlI) {
                ((LunarKeybindSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.lIlIlIlIlIIlIIlIIllIIIIIl, false, false, false);
                this.llIlIIIllIIlIllIllIllllIl = false;
                this.IllIllIIIllIIIlIlIlIIIIll = null;
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(((LunarKeybindSetting)this.IlllIIIIIIlllIlIIlllIlIIl).llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                return;
            }
            if (keyType == KeyType.IlIlIllIIllllIllllllIIlIl || keyType == KeyType.llIllIIIIlIIIIIIlllIllIlI || keyType == KeyType.llIIIIllIlIIlIlIIlllIllIl) {
                this.IllIllIIIllIIIlIlIlIIIIll = keyType;
                return;
            }
            ((LunarKeybindSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIlIlIlIlIIlIIlIIllIIIIIl(keyType, this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlIllIIllllIllllllIIlIl), this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.llIIIIllIlIIlIlIIlllIllIl), this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.llIllIIIIlIIIIIIlllIllIlI));
            this.llIlIIIllIIlIllIllIllllIl = false;
            this.IllIllIIIllIIIlIlIlIIIIll = null;
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl((((LunarKeybindSetting)this.IlllIIIIIIlllIlIIlllIlIIl).llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() ? "CTRL + " : "") + (((LunarKeybindSetting)this.IlllIIIIIIlllIlIIlllIlIIl).llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() ? "ALT + " : "") + (((LunarKeybindSetting)this.IlllIIIIIIlllIlIIlllIlIIl).llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() ? "SHIFT + " : "") + ((LunarKeybindSetting)this.IlllIIIIIIlllIlIIlllIlIIl).llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(KeyType keyType) {
        if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlIllIIllllIllllllIIlIl)) {
            return keyType == KeyType.IlIlIllIIllllIllllllIIlIl;
        }
        if (AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) {
            return keyType == KeyType.llIllIIIIlIIIIIIlllIllIlI;
        }
        if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.llIIIIllIlIIlIlIIlllIllIl)) {
            return keyType == KeyType.llIIIIllIlIIlIlIIlllIllIl;
        }
        return Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(keyType);
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        return super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2) && !this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2);
    }

    @Override
    public boolean c_() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl(float f, float f2) {
        return super.IlllIIIIIIlllIlIIlllIlIIl(f, f2) || this.c_();
    }
}