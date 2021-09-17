package com.moonsworth.lunar.client.setting;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.EnumSettingUIComponent;

public class EnumSetting<T extends Enum<T>> extends AbstractSetting<Enum<T>> {
    public EnumSetting(String string, T enum_) {
        super(string, enum_);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        Enum enum_ = this.IlllIIIIIIlllIlIIlllIlIIl(string);
        if (enum_ != null) {
            super.lIlIlIlIlIIlIIlIIllIIIIIl(enum_);
        }
    }

    public T IlllIIIIIIlllIlIIlllIlIIl(String string) {
        Class<?> clazz = ((Enum)this.IllIllIIIllIIIlIlIlIIIIll()).getClass();
        for (Enum<?> enum_ : (Enum<?>[])clazz.getEnumConstants()) {
            if (!((IEnumSetting)((Object)enum_)).lIlIlIlIlIIlIIlIIllIIIIIl().equals(string)) continue;
            return (T) enum_;
        }
        return null;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        if (((Enum)this.IllIllIIIllIIIlIlIlIIIIll()).equals(this.IIlIllIlllllllIIlIIIllIIl())) {
            return;
        }
        jsonObject.addProperty(this.lIIlIlllIlIlIIIlllIIlIIII(), ((IEnumSetting)((Object)((Enum)this.IllIllIIIllIIIlIlIlIIIIll()))).lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    @Override
    public AbstractDescritiveSettingUIComponent lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent) {
        return new EnumSettingUIComponent(this, uIComponent);
    }
}
 