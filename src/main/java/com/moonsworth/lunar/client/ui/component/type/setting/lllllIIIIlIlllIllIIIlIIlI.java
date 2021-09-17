package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.BooleanCallbackSetting;

import java.util.function.BooleanSupplier;

public class lllllIIIIlIlllIllIIIlIIlI
extends AbstractSetting<String>
implements BooleanCallbackSetting {
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl;

    public lllllIIIIlIlllIllIIIlIIlI(String string, String string2) {
        super(string, string2);
    }

    public lllllIIIIlIlllIllIIIlIIlI(String string, String string2, BooleanSupplier booleanSupplier) {
        super(string, string2, booleanSupplier);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(string);
    }

    @Override
    public AbstractDescritiveSettingUIComponent lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent) {
        return new IlIIlIIlIIlIIllIIIllIIllI(this, uIComponent);
    }

    @Override
    public boolean c_() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = bl;
    }
}