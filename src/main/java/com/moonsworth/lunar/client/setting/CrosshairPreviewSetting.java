package com.moonsworth.lunar.client.setting;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.feature.type.crosshair.CrosshairMod;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.CrosshairPreviewUIComponent;

public class CrosshairPreviewSetting
    extends AbstractSetting {
    public final CrosshairMod lIlIlIlIlIIlIIlIIllIIIIIl;

    public CrosshairPreviewSetting(CrosshairMod crosshairMod) {
        super("crosshairPreview", 0);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = crosshairMod;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
    }

    @Override
    public void write(JsonObject jsonObject) {
    }

    @Override
    public void read(JsonObject jsonObject) {
    }

    @Override
    public AbstractDescritiveSettingUIComponent getUIComponent(UIComponent uIComponent) {
        return new CrosshairPreviewUIComponent(this, uIComponent);
    }

    public CrosshairMod IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}