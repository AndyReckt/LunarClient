package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class IllIllIIIllIIIlIlIlIIIIll
extends UIComponent {
    public final BooleanSetting lIlIlIlIlIIlIIlIIllIIIIIl;
    public final ColorEase IlllIIIIIIlllIlIIlllIlIIl = new ColorEase(-1356212614, -14035334);
    public final ColorEase lIllIlIIIlIIIIIIIlllIlIll = new ColorEase(-1344396974, -2219694);
    public final boolean llIlIIIllIIlIllIllIllllIl;

    public IllIllIIIllIIIlIlIlIIIIll(UIComponent uIComponent, BooleanSetting booleanSetting, boolean bl) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = booleanSetting;
        this.llIlIIIllIIlIllIllIllllIl = bl;
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            booleanSetting.lIlIlIlIlIIlIIlIIllIIIIIl((Boolean)booleanSetting.llIlllIIIllllIIlllIllIIIl() == false);
            return true;
        });
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        int n = this.llIlIIIllIIlIllIllIllllIl ? (((Boolean)this.lIlIlIlIlIIlIIlIIllIIIIIl.llIlllIIIllllIIlllIllIIIl()).booleanValue() ? this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) : this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2))) : -1346848584;
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y, this.width, this.height, 10.0f, n, false, false, true, true);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 1.0f, this.y + 1.0f, this.width - 2.0f, this.height - 2.0f, 5.0f, 0x35FFFFFF, false, false, true, true);
        FontRegistry.IlIlIlllllIlIIlIlIlllIlIl.IlllIIIIIIlllIlIIlllIlIIl((Boolean)this.lIlIlIlIlIIlIIlIIllIIIIIl.llIlllIIIllllIIlllIllIIIl() == false ? "D I S A B L E D" : "E N A B L E D", this.x + this.width / 2.0f, this.y + 6.0f, -1);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}
 