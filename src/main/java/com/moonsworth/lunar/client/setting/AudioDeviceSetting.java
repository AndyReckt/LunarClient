package com.moonsworth.lunar.client.setting;

import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AudioDeviceUIComponent;

import java.util.List;

public class AudioDeviceSetting extends AbstractSetting {
    public List lIlIlIlIlIIlIIlIIllIIIIIl;

    public AudioDeviceSetting(String var1, List var2) {
        super(var1, null);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = var2;
    }

    public AudioDeviceSetting(String var1, Object var2, List var3) {
        super(var1, var2);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = var3;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Object var1) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(var1);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1) {
    }

    public AbstractDescritiveSettingUIComponent<AudioDeviceSetting> getUIComponent(UIComponent var1) {
        return new AudioDeviceUIComponent(this, var1);
    }

    public List IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(List var1) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
    }
}