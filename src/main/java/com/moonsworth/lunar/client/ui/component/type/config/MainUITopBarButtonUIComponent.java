package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class MainUITopBarButtonUIComponent
extends UIComponent {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public final LCFontRenderer IlllIIIIIIlllIlIIlllIlIIl;
    public ColorEase lIllIlIIIlIIIIIIIlllIlIll = new ColorEase(540752699, 0x20FFFFFF);
    public boolean llIlIIIllIIlIllIllIllllIl;
    public float IllIllIIIllIIIlIlIlIIIIll;

    public MainUITopBarButtonUIComponent(UIComponent uIComponent, String string) {
        this(uIComponent, string, FontRegistry.llIIIlllIIlllIllllIlIllIl());
    }

    public MainUITopBarButtonUIComponent(UIComponent uIComponent, String string, LCFontRenderer lCFontRenderer) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.IlllIIIIIIlllIlIIlllIlIIl = lCFontRenderer;
        this.width = (float)lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl, new Object[0]).replace("", " ").trim()) + 16.0f;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, (float)this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl, new Object[0]).replace("", " ").trim()) + 16.0f, 16.0f);
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
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.0f, 0, 0x20A2A2A2, this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl || bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)));
        float f3 = this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl();
        String string = this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl, new Object[0]).replace("", " ").trim();
        this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(string, this.x + this.width / 2.0f + 1.0f, this.y + this.height / 2.0f - f3 + 1.0f - this.IllIllIIIllIIIlIlIlIIIIll, 0x20000000);
        this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(string, this.x + this.width / 2.0f, this.y + this.height / 2.0f - f3 - this.IllIllIIIllIIIlIlIlIIIIll, this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && bl ? -4275267 : -1765882947);
    }

    public String llIlllIIIllllIIlllIllIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.llIlIIIllIIlIllIllIllllIl = bl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.IllIllIIIllIIIlIlIlIIIIll = f;
    }
}
 