package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.HKTextSetting;
import com.moonsworth.lunar.client.setting.KeyBind;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.BooleanCallbackSetting;

public class HKTextSettingUIComponent
extends ClashesWithWarningUIComponent
implements BooleanCallbackSetting {
    public boolean llIlIIIllIIlIllIllIllllIl;
    public KeyType IllIllIIIllIIIlIlIlIIIIll = null;
    public IlllIIIIIIlllIlIIlllIlIIl IIlIllIlllllllIIlIIIllIIl;
    public IIlllIllIlIllIllIIllIlIIl lIIlIlllIlIlIIIlllIIlIIII;

    public HKTextSettingUIComponent(HKTextSetting hKTextSetting, UIComponent uIComponent) {
        super(hKTextSetting, uIComponent);
        this.IIlIllIlllllllIIlIIIllIIl = new IlllIIIIIIlllIlIIlllIlIIl(this, (((KeyBind)hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).lIllIlIIIlIIIIIIIlllIlIll() ? "CTRL + " : (((KeyBind)hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).lIlIlIlIlIIlIIlIIllIIIIIl() ? "ALT + " : (((KeyBind)hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl() ? "SHIFT + " : ""))) + ((KeyBind)hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (!this.llIlIIIllIIlIllIllIllllIl && !hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().IlIlIlllllIlIIlIlIlllIlIl()) {
                return -2538942;
            }
            return -4275267;
        });
        this.lIIlIlllIlIlIIIlllIIlIIII = new IIlllIllIlIllIllIIllIlIIl(this, (String)hKTextSetting.llIlllIIIllllIIlllIllIIIl());
        this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(hKTextSetting::llIlllIIIllllIIlllIllIIIl);
        this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(hKTextSetting::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(hKTextSetting::IlllIIIIIIlllIlIIlllIlIIl);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(hKTextSetting::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll(() -> !this.llIlIIIllIIlIllIllIllllIl);
        this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl((f, f2, n) -> {
            Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().lllllIllIllIllllIlIllllII().getIcon(hKTextSetting.lIIlIlllIlIlIIIlllIIlIIII());
            return true;
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> {
            this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n);
            return true;
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if ((n == 4 || n == 5 || n == 3 || n == 2) && this.llIlIIIllIIlIllIllIllllIl) {
                this.llIlIIIllIIlIllIllIllllIl = false;
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.valueOf("KEY_MOUSE" + (n + 1)), false, false, false);
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(((KeyBind)hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                return true;
            }
            if (this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().lllllIllIllIllllIlIllllII().getIcon((String)hKTextSetting.llIlllIIIllllIIlllIllIIIl());
                if (n == 1 && !this.llIlIIIllIIlIllIllIllllIl) {
                    hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.lIlIlIlIlIIlIIlIIllIIIIIl, false, false, false);
                    this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(((KeyBind)hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                } else if (n == 0) {
                    this.llIlIIIllIIlIllIllIllllIl = !this.llIlIIIllIIlIllIllIllllIl;
                    this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl);
                    if (this.llIlIIIllIIlIllIllIllllIl) {
                        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl("?");
                    } else {
                        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl((((KeyBind)hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).lIllIlIIIlIIIIIIIlllIlIll() ? "CTRL + " : (((KeyBind)hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).lIlIlIlIlIIlIIlIIllIIIIIl() ? "ALT + " : (((KeyBind)hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl() ? "SHIFT + " : ""))) + ((KeyBind)hKTextSetting.lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                    }
                }
                return true;
            }
            if (this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            } else if (hKTextSetting.IlllIIIIIIlllIlIIlllIlIIl()) {
                hKTextSetting.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            }
            return false;
        });
    }

    @Override
    public float IllIllIIIllIIIlIlIlIIIIll() {
        return ((HKTextSetting)this.llIIIIIIIllIIllIlIllIIIIl()).llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0f : 14.0f;
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl();
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl();
        if (this.IllIllIIIllIIIlIlIlIIIIll != null && this.llIlIIIllIIlIllIllIllllIl && !this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll)) {
            ((HKTextSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll, false, false, false);
            this.llIlIIIllIIlIllIllIllllIl = false;
            this.IllIllIIIllIIIlIlIlIIIIll = null;
            this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(((KeyBind)((HKTextSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(((HKTextSetting)this.IlllIIIIIIlllIlIIlllIlIIl).f_(), this.x, this.y + 1.5f, -4079426);
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.width - 70.0f, this.y + 2.0f, 70.0f, 12.0f);
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.width - 230.0f, this.y + 2.0f, 140.0f, 12.0f);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        if (this.llIlIIIllIIlIllIllIllllIl) {
            if (keyType == KeyType.lIIIlIllllIIlIIlIIlIIIIlI) {
                ((HKTextSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.lIlIlIlIlIIlIIlIIllIIIIIl, false, false, false);
                this.llIlIIIllIIlIllIllIllllIl = false;
                this.IllIllIIIllIIIlIlIlIIIIll = null;
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(((KeyBind)((HKTextSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
                return;
            }
            if (keyType == KeyType.IlIlIllIIllllIllllllIIlIl || keyType == KeyType.llIllIIIIlIIIIIIlllIllIlI || keyType == KeyType.llIIIIllIlIIlIlIIlllIllIl) {
                this.IllIllIIIllIIIlIlIlIIIIll = keyType;
                return;
            }
            ((HKTextSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIllIlIIIlIIIIIIIlllIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(keyType, this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlIllIIllllIllllllIIlIl), this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.llIIIIllIlIIlIlIIlllIllIl), this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.llIllIIIIlIIIIIIlllIllIlI));
            this.llIlIIIllIIlIllIllIllllIl = false;
            this.IllIllIIIllIIIlIlIlIIIIll = null;
            this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl((((KeyBind)((HKTextSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).lIllIlIIIlIIIIIIIlllIlIll() ? "CTRL + " : "") + (((KeyBind)((HKTextSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).lIlIlIlIlIIlIIlIIllIIIIIl() ? "ALT + " : "") + (((KeyBind)((HKTextSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl() ? "SHIFT + " : "") + ((KeyBind)((HKTextSetting)this.IlllIIIIIIlllIlIIlllIlIIl).lIllIlIIIlIIIIIIIlllIlIll().llIlllIIIllllIIlllIllIIIl()).llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        }
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
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
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        return super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2) && !this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    @Override
    public boolean c_() {
        return this.llIlIIIllIIlIllIllIllllIl || this.lIIlIlllIlIlIIIlllIIlIIII.llIIIIIIIllIIllIlIllIIIIl().getAsBoolean();
    }

    @Override
    public IlllIIIIIIlllIlIIlllIlIIl llllIIlIIlIIlIIllIIlIIllI() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }
}
 