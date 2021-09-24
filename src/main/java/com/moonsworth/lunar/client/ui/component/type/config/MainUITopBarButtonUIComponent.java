package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class MainUITopBarButtonUIComponent extends UIComponent {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public final LCFontRenderer fontRenderer;
    public ColorEase ease = new ColorEase(540752699, 0x20FFFFFF);
    public boolean selected;
    public float IllIllIIIllIIIlIlIlIIIIll;

    public MainUITopBarButtonUIComponent(UIComponent uIComponent, String string) {
        this(uIComponent, string, FontRegistry.llIIIlllIIlllIllllIlIllIl());
    }

    public MainUITopBarButtonUIComponent(UIComponent uIComponent, String string, LCFontRenderer lCFontRenderer) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.fontRenderer = lCFontRenderer;
        this.width = (float)lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl).replace("", " ").trim()) + 16.0f;
    }

    public void setPosition(float f, float f2) {
        super.setPositionAndSize(f, f2, (float)this.fontRenderer.IlllIIIIIIlllIlIIlllIlIIl(this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl).replace("", " ").trim()) + 16.0f, 16.0f);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void onGuiClosed() {
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.0f, 0, 0x20A2A2A2, this.ease.lIlIlIlIlIIlIIlIIllIIIIIl(this.selected || bl && this.mouseInside(mouseX, mouseY)));
        float f3 = this.fontRenderer.getHeight();
        String string = this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl).replace("", " ").trim();
        this.fontRenderer.IlllIIIIIIlllIlIIlllIlIIl(string, this.x + this.width / 2.0f + 1.0f, this.y + this.height / 2.0f - f3 + 1.0f - this.IllIllIIIllIIIlIlIlIIIIll, 0x20000000);
        this.fontRenderer.IlllIIIIIIlllIlIIlllIlIIl(string, this.x + this.width / 2.0f, this.y + this.height / 2.0f - f3 - this.IllIllIIIllIIIlIlIlIIIIll, this.mouseInside(mouseX, mouseY) && bl ? -4275267 : -1765882947);
    }

    public String llIlllIIIllllIIlllIllIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void setSelected(boolean bl) {
        this.selected = bl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.IllIllIIIllIIIlIlIlIIIIll = f;
    }
}
