package com.moonsworth.lunar.client.setting;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.lIllIlIIIlIIIIIIIlllIlIll;
import com.moonsworth.lunar.client.ui.event.MouseEventCallback;

public class ButtonsSetting extends AbstractSetting<String> {
    public MouseEventCallback clickCallback;

    public ButtonsSetting(String string, MouseEventCallback mouseEventCallback) {
        super(string, string);
        this.clickCallback = mouseEventCallback;
    }

    public ButtonsSetting(String string) {
        this(string, (float f, float f2, int n) -> false);
    }

    @Override
    public AbstractDescritiveSettingUIComponent lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent) {
        return new lIllIlIIIlIIIIIIIlllIlIll(this, uIComponent);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
    }

    @Override
    public String getLanguagePath() {
        return super.getLanguagePath() + ".buttons";
    }

    public MouseEventCallback lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.clickCallback;
    }
}
 