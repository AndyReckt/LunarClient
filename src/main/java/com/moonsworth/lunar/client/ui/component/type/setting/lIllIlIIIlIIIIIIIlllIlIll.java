package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.ButtonsSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;

public class lIllIlIIIlIIIIIIIlllIlIll
extends AbstractDescritiveSettingUIComponent {
    public IlllIIIIIIlllIlIIlllIlIIl lIlIlIlIlIIlIIlIIllIIIIIl;

    public lIllIlIIIlIIIIIIIlllIlIll(ButtonsSetting buttonsSetting, UIComponent uIComponent) {
        super(buttonsSetting, uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new IlllIIIIIIlllIlIIlllIlIIl(this, buttonsSetting.f_(), FontRegistry.lIlIIIIIIlIIIllllIllIIlII());
        this.lIlIlIlIlIIlIIlIIllIIIIIl.IlIlIlllllIlIIlIlIlllIlIl(-0.7f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                buttonsSetting.lIlIlIlIlIIlIIlIIllIIIIIl().accept(f, f2, n);
                return true;
            }
            return false;
        });
    }

    @Override
    public float IllIllIIIllIIIlIlIlIIIIll() {
        return ((ButtonsSetting)this.llIIIIIIIllIIllIlIllIIIIl()).llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0f : 14.0f;
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
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, 70.0f, 12.0f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}
 