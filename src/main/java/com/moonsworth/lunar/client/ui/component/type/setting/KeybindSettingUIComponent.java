package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.UIScreenCloseException;
import com.moonsworth.lunar.client.ui.component.UIComponent;

/**
 * @author Decencies
 * @since 10/07/2021 18:10
 */
public class KeybindSettingUIComponent extends ClashesWithWarningUIComponent implements UIScreenCloseException {
    public boolean editing;
    public KeyType IllIllIIIllIIIlIlIlIIIIll = null;

    public KeybindSettingUIComponent(LunarKeybindSetting lunarKeybindSetting, UIComponent uIComponent) {
        super(lunarKeybindSetting, uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new DefaultButtonUIComponent(this, (lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() ? "CTRL + " : (lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() ? "ALT + " : (lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() ? "SHIFT + " : ""))) + lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (!this.editing && !lunarKeybindSetting.IlIlIlllllIlIIlIlIlllIlIl()) {
                return -2538942;
            }
            return -4275267;
        });
        this.onMouseClick((float f, float f2, int n) -> {
            if ((n == 4 || n == 5 || n == 3 || n == 2) && this.editing) {
                this.editing = false;
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                lunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.valueOf("KEY_MOUSE" + (n + 1)), false, false, false);
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                return true;
            }
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(f, f2)) {
                if (n == 1 && !this.editing) {
                    lunarKeybindSetting.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_NONE, false, false, false);
                    this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(lunarKeybindSetting.llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                } else {
                    boolean bl = this.editing = !this.editing;
                    if (this.editing) {
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
    public float getHeight() {
        return this.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0f : 14.0f;
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    @Override
    public void onUpdateScreen() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.onUpdateScreen();
        if (this.IllIllIIIllIIIlIlIlIIIIll != null && this.editing && !this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll)) {
            ((LunarKeybindSetting)this.setting).lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll, false, false, false);
            this.editing = false;
            this.IllIllIIIllIIIlIlIlIIIIll = null;
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(((LunarKeybindSetting)this.setting).llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        }
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.setting.f_(), this.x, this.y + 1.5f, -4079426);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.setPositionAndSize(this.x + this.width - 70.0f, this.y + 2.0f, 70.0f, 12.0f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.drawComponent(mouseX, mouseY, bl);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        if (this.editing) {
            if (keyType == KeyType.KEY_ESCAPE) {
                ((LunarKeybindSetting)this.setting).lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_NONE, false, false, false);
                this.editing = false;
                this.IllIllIIIllIIIlIlIlIIIIll = null;
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(((LunarKeybindSetting)this.setting).llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                return;
            }
            if (keyType == KeyType.KEY_LSHIFT || keyType == KeyType.KEY_LCONTROL || keyType == KeyType.KEY_LMENU) {
                this.IllIllIIIllIIIlIlIlIIIIll = keyType;
                return;
            }
            ((LunarKeybindSetting)this.setting).lIlIlIlIlIIlIIlIIllIIIIIl(keyType, this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LSHIFT), this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LMENU), this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LCONTROL));
            this.editing = false;
            this.IllIllIIIllIIIlIlIlIIIIll = null;
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl((((LunarKeybindSetting)this.setting).llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() ? "CTRL + " : "") + (((LunarKeybindSetting)this.setting).llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() ? "ALT + " : "") + (((LunarKeybindSetting)this.setting).llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() ? "SHIFT + " : "") + ((LunarKeybindSetting)this.setting).llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        }
    }

    @Override
    public void onGuiClosed() {
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(KeyType keyType) {
        if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LSHIFT)) {
            return keyType == KeyType.KEY_LSHIFT;
        }
        if (AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) {
            return keyType == KeyType.KEY_LCONTROL;
        }
        if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LMENU)) {
            return keyType == KeyType.KEY_LMENU;
        }
        return Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(keyType);
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        return super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2) && !this.lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(f, f2);
    }

    @Override
    public boolean shouldCancel() {
        return this.editing;
    }

    @Override
    public boolean mouseInside(float mouseX, float mouseY) {
        return super.mouseInside(mouseX, mouseY) || this.shouldCancel();
    }
}