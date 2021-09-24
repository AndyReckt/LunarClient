package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.HKTextSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.UIScreenCloseException;

public class HKTextSettingUIComponent extends ClashesWithWarningUIComponent implements UIScreenCloseException {
    public boolean llIlIIIllIIlIllIllIllllIl;
    public KeyType IllIllIIIllIIIlIlIlIIIIll = null;
    public DefaultButtonUIComponent IIlIllIlllllllIIlIIIllIIl;
    public AutoTextUIComponent lIIlIlllIlIlIIIlllIIlIIII;

    public HKTextSettingUIComponent(HKTextSetting hKTextSetting, UIComponent uIComponent) {
        super(hKTextSetting, uIComponent);
        this.IIlIllIlllllllIIlIIIllIIl = new DefaultButtonUIComponent(this, (hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() ? "CTRL + " : (hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() ? "ALT + " : (hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() ? "SHIFT + " : ""))) + hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (!this.llIlIIIllIIlIllIllIllllIl && !hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().IlIlIlllllIlIIlIlIlllIlIl()) {
                return -2538942;
            }
            return -4275267;
        });
        this.lIIlIlllIlIlIIIlllIIlIIII = new AutoTextUIComponent(this, hKTextSetting.llIlllIIIllllIIlllIllIIIl());
        this.lIIlIlllIlIlIIIlllIIlIIII.setSuppiler(hKTextSetting::llIlllIIIllllIIlllIllIIIl);
        this.lIIlIlllIlIlIIIlllIIlIIII.setConsumer(hKTextSetting::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(hKTextSetting::IlllIIIIIIlllIlIIlllIlIIl);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(hKTextSetting::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll(() -> !this.llIlIIIllIIlIllIllIllllIl);
        this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl((f, f2, n) -> {
            Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIllIllllIlIllllII().getIcon(hKTextSetting.lIIlIlllIlIlIIIlllIIlIIII());
            return true;
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> {
            this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
            return true;
        });
        this.onMouseClick((float f, float f2, int n) -> {
            if ((n == 4 || n == 5 || n == 3 || n == 2) && this.llIlIIIllIIlIllIllIllllIl) {
                this.llIlIIIllIIlIllIllIllllIl = false;
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.valueOf("KEY_MOUSE" + (n + 1)), false, false, false);
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                return true;
            }
            if (this.IIlIllIlllllllIIlIIIllIIl.mouseInside(f, f2)) {
                Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIllIllllIlIllllII().getIcon(hKTextSetting.llIlllIIIllllIIlllIllIIIl());
                if (n == 1 && !this.llIlIIIllIIlIllIllIllllIl) {
                    hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_NONE, false, false, false);
                    this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                } else if (n == 0) {
                    this.llIlIIIllIIlIllIllIllllIl = !this.llIlIIIllIIlIllIllIllllIl;
                    this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl);
                    if (this.llIlIIIllIIlIllIllIllllIl) {
                        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl("?");
                    } else {
                        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl((hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() ? "CTRL + " : (hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() ? "ALT + " : (hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() ? "SHIFT + " : ""))) + hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                    }
                }
                return true;
            }
            if (this.lIIlIlllIlIlIIIlllIIlIIII.mouseInside(f, f2)) {
                this.lIIlIlllIlIlIIIlllIIlIIII.onMouseClicked(f, f2, n);
            } else if (hKTextSetting.IlllIIIIIIlllIlIIlllIlIIl()) {
                hKTextSetting.lIlIlIlIlIIlIIlIIllIIIIIl(false);
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
        this.lIIlIlllIlIlIIIlllIIlIIII.onUpdateScreen();
        this.IIlIllIlllllllIIlIIIllIIl.onUpdateScreen();
        if (this.IllIllIIIllIIIlIlIlIIIIll != null && this.llIlIIIllIIlIllIllIllllIl && !this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll)) {
            ((HKTextSetting)this.setting).lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll, false, false, false);
            this.llIlIIIllIIlIllIllIllllIl = false;
            this.IllIllIIIllIIIlIlIlIIIIll = null;
            this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(((HKTextSetting)this.setting).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        }
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.setting.f_(), this.x, this.y + 1.5f, -4079426);
        this.IIlIllIlllllllIIlIIIllIIl.setPositionAndSize(this.x + this.width - 70.0f, this.y + 2.0f, 70.0f, 12.0f);
        this.IIlIllIlllllllIIlIIIllIIl.drawComponent(mouseX, mouseY, bl);
        this.lIIlIlllIlIlIIIlllIIlIIII.setPositionAndSize(this.x + this.width - 230.0f, this.y + 2.0f, 140.0f, 12.0f);
        this.lIIlIlllIlIlIIIlllIIlIIII.drawComponent(mouseX, mouseY, bl);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        if (this.llIlIIIllIIlIllIllIllllIl) {
            if (keyType == KeyType.KEY_ESCAPE) {
                ((HKTextSetting)this.setting).lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_NONE, false, false, false);
                this.llIlIIIllIIlIllIllIllllIl = false;
                this.IllIllIIIllIIIlIlIlIIIIll = null;
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(((HKTextSetting)this.setting).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                return;
            }
            if (keyType == KeyType.KEY_LSHIFT || keyType == KeyType.KEY_LCONTROL || keyType == KeyType.KEY_LMENU) {
                this.IllIllIIIllIIIlIlIlIIIIll = keyType;
                return;
            }
            ((HKTextSetting)this.setting).lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(keyType, this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LSHIFT), this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LMENU), this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LCONTROL));
            this.llIlIIIllIIlIllIllIllllIl = false;
            this.IllIllIIIllIIIlIlIlIIIIll = null;
            this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl((((HKTextSetting)this.setting).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().lIllIlIIIlIIIIIIIlllIlIll() ? "CTRL + " : "") + (((HKTextSetting)this.setting).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl() ? "ALT + " : "") + (((HKTextSetting)this.setting).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().IlllIIIIIIlllIlIIlllIlIIl() ? "SHIFT + " : "") + ((HKTextSetting)this.setting).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl().llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        }
        this.lIIlIlllIlIlIIIlllIIlIIII.onKeyTyped(c, keyType);
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
    public void handleMouseScrollDelta(int n) {
        super.handleMouseScrollDelta(n);
        this.lIIlIlllIlIlIIIlllIIlIIII.handleMouseScrollDelta(n);
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        return super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2) && !this.IIlIllIlllllllIIlIIIllIIl.mouseInside(f, f2);
    }

    @Override
    public void onGuiClosed() {
    }

    @Override
    public boolean shouldCancel() {
        return this.llIlIIIllIIlIllIllIllllIl || this.lIIlIlllIlIlIIIlllIIlIIII.llIIIIIIIllIIllIlIllIIIIl().getAsBoolean();
    }

    @Override
    public DefaultButtonUIComponent llllIIlIIlIIlIIllIIlIIllI() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }
}
