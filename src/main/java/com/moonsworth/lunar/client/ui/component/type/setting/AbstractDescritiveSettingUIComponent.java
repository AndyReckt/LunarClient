package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.IIlIllIlllllllIIlIIIllIIl;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.List;

/**
 * @author Decencies
 * @since 10/07/2021 15:49
 */
public abstract class AbstractDescritiveSettingUIComponent<T> extends UIComponent {

    public AbstractSetting<T> setting;
    public String label;

    public AbstractDescritiveSettingUIComponent(AbstractSetting<T> abstractSetting, UIComponent uIComponent) {
        super(uIComponent);
        this.setting = abstractSetting;
        this.label = abstractSetting.f_().toUpperCase().replace("", " ").trim();
    }

    public void resoze(float f, float f2, float f3) {
        super.setPositionAndSize(f, f2, f3, this.getHeight());
    }

    @Override
    public abstract float getHeight();

    public abstract boolean lIllIlIIIlIIIIIIIlllIlIll();

    public void lIllIlIIIlIIIIIIIlllIlIll(float f, float f2) {
        String string = this.setting instanceof IIlIllIlllllllIIlIIIllIIl ? ((IIlIllIlllllllIIlIIIllIIl)this.setting).llllIIlIIlIIlIIllIIlIIllI() : this.setting.lIIlIlllIlIlIIIlllIIlIIII();
        String string2 = string + "Description";
        String string3 = this.setting.get(string2);
        if (!string3.equals(string2)) {
            List<String> list = FontRegistry.lIlIIIIIIlIIIllllIllIIlII().lIllIlIIIlIIIIIIIlllIlIll(string3, 150.0);
            float f3 = list.size() > 1 ? 150.0f : (float)FontRegistry.lIIIllIllIIllIlllIlIIlllI().IlllIIIIIIlllIlIIlllIlIIl(string3);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f + 8.0f, f2 + 6.0f, f3 + 10.0f, (float)(8 * list.size() + 5), 4.0f, -1879048192);
            int n = 0;
            for (String string4 : list) {
                FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(string4, f + 12.5f, f2 + 9.0f + (float)(n * 8), -1);
                ++n;
            }
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        return this.mouseInside(f, f2);
    }

    public AbstractSetting llIIIIIIIllIIllIlIllIIIIl() {
        return this.setting;
    }

}
