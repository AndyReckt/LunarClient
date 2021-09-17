package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.NumberSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;

/**
 * @author Decencies
 * @since 10/07/2021 18:22
 */
public class NumberSettingUIComponent
        extends AbstractDescritiveSettingUIComponent {
    public final IntSliderUIComponent lIlIlIlIlIIlIIlIIllIIIIIl;

    public NumberSettingUIComponent(NumberSetting numberSetting, UIComponent uIComponent) {
        super(numberSetting, uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new IntSliderUIComponent(numberSetting, this);
        this.IlllIIIIIIlllIlIIlllIlIIl = numberSetting;
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            return false;
        });
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 / 3.0f, f2, f3 - f3 / 3.0f, this.height);
    }

    @Override
    public float IllIllIIIllIIIlIlIlIIIIll() {
        return ((NumberSetting)this.llIIIIIIIllIIllIlIllIIIIl()).llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0f : 14.0f;
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(((NumberSetting)this.IlllIIIIIIlllIlIIlllIlIIl).f_(), this.x, this.y + 1.5f, -4079426);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}
