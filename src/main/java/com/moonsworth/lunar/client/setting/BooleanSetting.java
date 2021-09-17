package com.moonsworth.lunar.client.setting;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.BooleanSettingUIComponent;

import java.util.function.BooleanSupplier;

/**
 * @author Decencies
 * @since 10/07/2021 15:52
 */
public class BooleanSetting extends AbstractSetting<Boolean> {

    public BooleanSetting lIlIlIlIlIIlIIlIIllIIIIIl;

    public BooleanSetting(BooleanSetting booleanSetting, String string, Boolean bl, BooleanSupplier booleanSupplier) {
        super(string + "_bl", bl, booleanSupplier);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = booleanSetting;
    }

    public BooleanSetting(BooleanSetting booleanSetting, String string, Boolean bl) {
        this(booleanSetting, string, bl, () -> false);
    }

    public BooleanSetting(String string, Boolean bl, BooleanSupplier booleanSupplier) {
        super(string + "_bl", bl, booleanSupplier);
    }

    public BooleanSetting(String string, Boolean bl) {
        super(string + "_bl", bl);
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return (Boolean)this.lIlIlIlIlIIlIIlIIllIIIIIl.llIlllIIIllllIIlllIllIIIl() != false && (Boolean)this.llIlllIIIllllIIlllIllIIIl() != false;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(Boolean.parseBoolean(string));
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        if (((Boolean)this.IllIllIIIllIIIlIlIlIIIIll()).equals(this.IIlIllIlllllllIIlIIIllIIl())) {
            return;
        }
        jsonObject.addProperty(this.lIIlIlllIlIlIIIlllIIlIIII(), (Boolean)this.IllIllIIIllIIIlIlIlIIIIll());
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        if (!jsonObject.has(this.lIIlIlllIlIlIIIlllIIlIIII()) || jsonObject.get(this.lIIlIlllIlIlIIIlllIIlIIII()).isJsonNull()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlIllIlllllllIIlIIIllIIl());
            return;
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject.get(this.lIIlIlllIlIlIIIlllIIlIIII()).getAsBoolean());
    }

    @Override
    public AbstractDescritiveSettingUIComponent lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent) {
        return new BooleanSettingUIComponent(this, uIComponent);
    }

    public BooleanSetting IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
