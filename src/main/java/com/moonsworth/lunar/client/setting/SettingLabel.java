package com.moonsworth.lunar.client.setting;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.llIlIIIllIIlIllIllIllllIl;

public class SettingLabel extends AbstractSetting<String> {
    public SettingLabel(String string) {
        super(string, string, () -> false);
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.get((String)super.llIlllIIIllllIIlllIllIIIl(), new Object[0]);
    }

    @Override
    public String f_() {
        return this.get((String)super.llIlllIIIllllIIlllIllIIIl(), new Object[0]);
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl(Object ... objectArray) {
        return this.get(this.IlllIIIIIIlllIlIIlllIlIIl(), objectArray);
    }

    @Override
    public AbstractDescritiveSettingUIComponent lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent) {
        return new llIlIIIllIIlIllIllIllllIl(this, uIComponent);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
    }

    @Override
    public String getLanguagePath() {
        return super.getLanguagePath() + ".labels";
    }

    // todo was previously "Object", possibly indicates a T type.
    @Override
    public String llIlllIIIllllIIlllIllIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl();
    }
}
 