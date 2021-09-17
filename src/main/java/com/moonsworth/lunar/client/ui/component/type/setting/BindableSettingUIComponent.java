package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.BindableSetting;
import com.moonsworth.lunar.client.ui.screen.BooleanCallbackSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;

/**
 * @author Decencies
 * @since 10/07/2021 18:13
 */
public class BindableSettingUIComponent extends ClashesWithWarningUIComponent implements BooleanCallbackSetting {

    public boolean llIlIIIllIIlIllIllIllllIl;

    public BindableSettingUIComponent(BindableSetting bindableSetting, UIComponent uIComponent) {
        super(bindableSetting, uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new IlllIIIIIIlllIlIIlllIlIIl(this, this.lIIIllIllIIllIlllIlIIlllI());
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (!this.llIlIIIllIIlIllIllIllllIl && !bindableSetting.IlIlIlllllIlIIlIlIlllIlIl()) {
                return -2538942;
            }
            return -4275267;
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if ((n == 4 || n == 5 || n == 3 || n == 2) && this.llIlIIIllIIlIllIllIllllIl) {
                this.llIlIIIllIIlIllIllIllllIl = false;
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                bindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.valueOf("KEY_MOUSE" + (n + 1)).name());
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl((String) bindableSetting.llIlllIIIllllIIlllIllIIIl());
                return true;
            }
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                if (n == 1 && !this.llIlIIIllIIlIllIllIllllIl) {
                    bindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.lIlIlIlIlIIlIIlIIllIIIIIl.name());
                    this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIllIllIIllIlllIlIIlllI());
                } else {
                    boolean bl = this.llIlIIIllIIlIllIllIllllIl = !this.llIlIIIllIIlIllIllIllllIl;
                    if (this.llIlIIIllIIlIllIllIllllIl) {
                        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl("?");
                    } else {
                        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIllIllIIllIlllIlIIlllI());
                    }
                }
                return true;
            }
            return false;
        });
    }

    @Override
    public float IllIllIIIllIIIlIlIlIIIIll() {
        return ((BindableSetting) this.llIIIIIIIllIIllIlIllIIIIl()).llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0f : 14.0f;
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(((BindableSetting) this.IlllIIIIIIlllIlIIlllIlIIl).f_(), this.x, this.y + 1.5f, -4079426);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.width - 70.0f, this.y + 2.0f, 70.0f, 12.0f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        if (this.llIlIIIllIIlIllIllIllllIl) {
            if (keyType == KeyType.lIIIlIllllIIlIIlIIlIIIIlI) {
                ((BindableSetting) this.IlllIIIIIIlllIlIIlllIlIIl).lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.lIlIlIlIlIIlIIlIIllIIIIIl.name());
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIllIllIIllIlllIlIIlllI());
                this.llIlIIIllIIlIllIllIllllIl = false;
                return;
            }
            this.llIlIIIllIIlIllIllIllllIl = false;
            ((BindableSetting) this.IlllIIIIIIlllIlIIlllIlIIl).lIlIlIlIlIIlIIlIIllIIIIIl(keyType.name());
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIllIllIIllIlllIlIIlllI());
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    public String lIIIllIllIIllIlllIlIIlllI() {
        return KeyType.valueOf((String) ((BindableSetting) this.IlllIIIIIIlllIlIIlllIlIIl).llIlllIIIllllIIlllIllIIIl()).lIlIlIlIlIIlIIlIIllIIIIIl();
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