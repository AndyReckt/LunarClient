package com.moonsworth.lunar.client.ui.component.type.overlay;

public class lIlIlIlIlIIlIIlIIllIIIIIl
extends UIComponent {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public final LCFontRenderer IlllIIIIIIlllIlIIlllIlIIl;
    public ColorEase lIllIlIIIlIIIIIIIlllIlIll = new ColorEase(0x20FFFFFF, 0x45FFFFFF);
    public boolean llIlIIIllIIlIllIllIllllIl;

    public lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent, String string) {
        this(uIComponent, string, FontRegistry.llIIIlllIIlllIllllIlIllIl());
    }

    public lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent, String string, LCFontRenderer lCFontRenderer) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string.replace("", " ").trim();
        this.IlllIIIIIIlllIlIIlllIlIIl = lCFontRenderer;
        this.lIllIlIIIlIIIIIIIlllIlIll = new ColorEase(0x20909090, 1167102096);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string.replace("", " ").trim();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl || bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)));
        float f3 = (float)this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl() + 1.0f;
        this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl, this.x + this.width / 2.0f, this.y + this.height / 2.0f - f3, -4275267);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    public String lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.llIlIIIllIIlIllIllIllllIl = bl;
    }
}
 