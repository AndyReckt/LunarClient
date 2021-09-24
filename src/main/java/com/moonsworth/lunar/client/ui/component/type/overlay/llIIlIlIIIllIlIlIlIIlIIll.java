package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class llIIlIlIIIllIlIlIlIIlIIll extends UIComponent {
    public String spacedText;
    public final LCFontRenderer fontRenderer;
    public ColorEase ease = new ColorEase(-15627600, -12346181);
    public int llIlIIIllIIlIllIllIllllIl = -12346181;
    public boolean hoverOverride;

    public llIIlIlIIIllIlIlIlIIlIIll(UIComponent uIComponent, String string) {
        this(uIComponent, string, FontRegistry.lllIIIIIlllIIlIllIIlIIIlI());
    }

    public llIIlIlIIIllIlIlIlIIlIIll(UIComponent uIComponent, String string, LCFontRenderer lCFontRenderer) {
        super(uIComponent);
        this.spacedText = string.replace("", " ").trim();
        this.fontRenderer = lCFontRenderer;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.spacedText = string.replace("", " ").trim();
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
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 5.0f, 0, this.llIlIIIllIIlIllIllIllllIl, this.ease.lIlIlIlIlIIlIIlIIllIIIIIl(this.hoverOverride || bl && this.mouseInside(mouseX, mouseY)));
        float f3 = this.fontRenderer.getHeight();
        this.fontRenderer.IlllIIIIIIlllIlIIlllIlIIl(this.spacedText, this.x + this.width / 2.0f + 1.0f, this.y + this.height / 2.0f - f3, 0x20000000);
        this.fontRenderer.IlllIIIIIIlllIlIIlllIlIIl(this.spacedText, this.x + this.width / 2.0f, this.y + this.height / 2.0f - f3, -4275267);
    }

    public String getSpacedText() {
        return this.spacedText;
    }

    public void setEase(ColorEase colorEase) {
        this.ease = colorEase;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.llIlIIIllIIlIllIllIllllIl = n;
    }

    public void setHoverOverride(boolean bl) {
        this.hoverOverride = bl;
    }
}