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
public abstract class AbstractDescritiveSettingUIComponent extends UIComponent {

    public AbstractSetting IlllIIIIIIlllIlIIlllIlIIl;
    public String lIllIlIIIlIIIIIIIlllIlIll;

    public AbstractDescritiveSettingUIComponent(AbstractSetting abstractSetting, UIComponent uIComponent) {
        super(uIComponent);
        this.IlllIIIIIIlllIlIIlllIlIIl = abstractSetting;
        this.lIllIlIIIlIIIIIIIlllIlIll = abstractSetting.f_().toUpperCase().replace("", " ").trim();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, this.IllIllIIIllIIIlIlIlIIIIll());
    }

    @Override
    public abstract float IllIllIIIllIIIlIlIlIIIIll();

    //@Override
    public abstract boolean lIllIlIIIlIIIIIIIlllIlIll();

    public void lIllIlIIIlIIIIIIIlllIlIll(float f, float f2) {
        String string = this.IlllIIIIIIlllIlIIlllIlIIl instanceof IIlIllIlllllllIIlIIIllIIl ? ((IIlIllIlllllllIIlIIIllIIl)this.IlllIIIIIIlllIlIIlllIlIIl).llllIIlIIlIIlIIllIIlIIllI() : this.IlllIIIIIIlllIlIIlllIlIIl.lIIlIlllIlIlIIIlllIIlIIII();
        String string2 = string + "Description";
        String string3 = this.IlllIIIIIIlllIlIIlllIlIIl.get(string2, new Object[0]);
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
        return this.IlllIIIIIIlllIlIIlllIlIIl(f, f2);
    }

    public AbstractSetting llIIIIIIIllIIllIlIllIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

}
