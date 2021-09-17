package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

public class lIlIlIIIIIIllIlIIIIllIIII
extends UIComponent {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public final LCFontRenderer IlllIIIIIIlllIlIIlllIlIIl;
    public final ColorEase lIllIlIIIlIIIIIIIlllIlIll = new ColorEase(0, 0x45000000);
    public int llIlIIIllIIlIllIllIllllIl = -1;
    public boolean IllIllIIIllIIIlIlIlIIIIll;

    public lIlIlIIIIIIllIlIIIIllIIII(UIComponent uIComponent, String string, int n) {
        this(uIComponent, string, FontRegistry.lIIIllIllIIllIlllIlIIlllI(), n);
    }

    public lIlIlIIIIIIllIlIIIIllIIII(UIComponent uIComponent, String string) {
        this(uIComponent, string, FontRegistry.lIIIllIllIIllIlllIlIIlllI(), -1);
    }

    public lIlIlIIIIIIllIlIIIIllIIII(UIComponent uIComponent, String string, LCFontRenderer lCFontRenderer, int n) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.IlllIIIIIIlllIlIIlllIlIIl = lCFontRenderer;
        this.llIlIIIllIIlIllIllIllllIl = n;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll || bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)));
        float f3 = this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl();
        float f4 = this.x + 5.0f;
        if (this.llIlIIIllIIlIllIllIllllIl != -1) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((double)(f4 + 3.0f), (double)(this.y + this.height / 2.0f + 0.5f), 2.0, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(ColorUtil.IlllIIIIIIlllIlIIlllIlIIl(this.llIlIIIllIIlIllIllIllllIl), ColorUtil.llIlllIIIllllIIlllIllIIIl(this.llIlIIIllIIlIllIllIllllIl), ColorUtil.IlIlIlllllIlIIlIlIlllIlIl(this.llIlIIIllIIlIllIllIllllIl), 255));
            f4 += 10.0f;
        }
        String string = this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl, new Object[0]);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(string, f4, this.y + this.height / 2.0f - f3, 0x20000000);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(string, f4 - 1.0f, this.y + this.height / 2.0f - f3 - 1.0f, -538778910);
    }

    public String lIllIlIIIlIIIIIIIlllIlIll() {
        return this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl, new Object[0]);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.IllIllIIIllIIIlIlIlIIIIll = bl;
    }
}