package com.moonsworth.lunar.client.setting;

import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.WorldTimeSettingUIComponent;

public class WorldTimeSetting extends NumberSetting {
    public WorldTimeSetting(String var1, Integer var2, Integer var3, Integer var4) {
        super(var1, var2, var3, var4);
    }

    public AbstractDescritiveSettingUIComponent getUIComponent(UIComponent var1) {
        return new WorldTimeSettingUIComponent(this, var1);
    }
}
