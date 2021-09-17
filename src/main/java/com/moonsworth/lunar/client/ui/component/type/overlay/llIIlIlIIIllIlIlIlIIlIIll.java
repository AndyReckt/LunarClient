package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class llIIlIlIIIllIlIlIlIIlIIll
extends UIComponent {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public final LCFontRenderer IlllIIIIIIlllIlIIlllIlIIl;
    public ColorEase lIllIlIIIlIIIIIIIlllIlIll = new ColorEase(-15627600, -12346181);
    public int llIlIIIllIIlIllIllIllllIl = -12346181;
    public boolean IllIllIIIllIIIlIlIlIIIIll;

    public llIIlIlIIIllIlIlIlIIlIIll(UIComponent uIComponent, String string) {
        this(uIComponent, string, FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
    }

    public llIIlIlIIIllIlIlIlIIlIIll(UIComponent uIComponent, String string, LCFontRenderer lCFontRenderer) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string.replace("", " ").trim();
        this.IlllIIIIIIlllIlIIlllIlIIl = lCFontRenderer;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string.replace("", " ").trim();
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
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 5.0f, 0, this.llIlIIIllIIlIllIllIllllIl, this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll || bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)));
        float f3 = this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl();
        this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl, this.x + this.width / 2.0f + 1.0f, this.y + this.height / 2.0f - f3, 0x20000000);
        this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl, this.x + this.width / 2.0f, this.y + this.height / 2.0f - f3, -4275267);
    }

    public String lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ColorEase colorEase) {
        this.lIllIlIIIlIIIIIIIlllIlIll = colorEase;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.llIlIIIllIIlIllIllIllllIl = n;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.IllIllIIIllIIIlIlIlIIIIll = bl;
    }
}