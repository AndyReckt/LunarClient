package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.UIScreenCloseException;

import java.util.function.BooleanSupplier;

public class TextSetting extends AbstractSetting<String> implements UIScreenCloseException {
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl;

    public TextSetting(String string, String string2) {
        super(string, string2);
    }

    public TextSetting(String string, String string2, BooleanSupplier booleanSupplier) {
        super(string, string2, booleanSupplier);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(string);
    }

    @Override
    public AbstractDescritiveSettingUIComponent<String> getUIComponent(UIComponent uIComponent) {
        return new TextSettingUIComponent(this, uIComponent);
    }

    @Override
    public boolean shouldCancel() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public boolean getBool() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = bl;
    }
}