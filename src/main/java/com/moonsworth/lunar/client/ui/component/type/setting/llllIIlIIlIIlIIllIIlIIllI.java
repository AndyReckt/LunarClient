package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class llllIIlIIlIIlIIllIIlIIllI
extends UIComponent {
    public final ColorSetting lIlIlIlIlIIlIIlIIllIIIIIl;

    public llllIIlIIlIIlIIllIIlIIllI(UIComponent uIComponent, ColorSetting colorSetting) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = colorSetting;
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            ((ColorPickerUIComponent)uIComponent).lIlIlIlIlIIlIIlIIllIIIIIl(this);
            return true;
        });
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    public llllIIlIIlIIlIIllIIlIIllI lIllIlIIIlIIIIIIIlllIlIll() {
        return new llllIIlIIlIIlIIllIIlIIllI(this.lIIIllIllIIllIlllIlIIlllI, this.lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y, this.width, this.height, 5.0f, this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.y), true, true, true, true);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 1.0f, this.y + 1.0f, this.width - 2.0f, this.height - 2.0f, 2.5f, -1342177281, true, true, true, true);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    public Object clone() {
        return this.lIllIlIIIlIIIIIIIlllIlIll();
    }
}