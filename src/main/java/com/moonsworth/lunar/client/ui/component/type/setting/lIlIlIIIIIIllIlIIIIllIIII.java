package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

public class lIlIlIIIIIIllIlIIIIllIIII extends UIComponent {
    public String translationKey;
    public final LCFontRenderer fontRenderer;
    public final ColorEase ease = new ColorEase(0, 0x45000000);
    public int color = -1;
    public boolean hoverOverride;

    public lIlIlIIIIIIllIlIIIIllIIII(UIComponent uIComponent, String string, int n) {
        this(uIComponent, string, FontRegistry.lIIIllIllIIllIlllIlIIlllI(), n);
    }

    public lIlIlIIIIIIllIlIIIIllIIII(UIComponent uIComponent, String string) {
        this(uIComponent, string, FontRegistry.lIIIllIllIIllIlllIlIIlllI(), -1);
    }

    public lIlIlIIIIIIllIlIIIIllIIII(UIComponent uIComponent, String string, LCFontRenderer lCFontRenderer, int n) {
        super(uIComponent);
        this.translationKey = string;
        this.fontRenderer = lCFontRenderer;
        this.color = n;
    }

    public void setTranslationKey(String string) {
        this.translationKey = string;
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
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, this.ease.lIlIlIlIlIIlIIlIIllIIIIIl(this.hoverOverride || bl && this.mouseInside(mouseX, mouseY)));
        float f3 = this.fontRenderer.getHeight();
        float f4 = this.x + 5.0f;
        if (this.color != -1) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f4 + 3.0f, this.y + this.height / 2.0f + 0.5f, 2.0, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(ColorUtil.IlllIIIIIIlllIlIIlllIlIIl(this.color), ColorUtil.llIlllIIIllllIIlllIllIIIl(this.color), ColorUtil.IlIlIlllllIlIIlIlIlllIlIl(this.color), 255));
            f4 += 10.0f;
        }
        String translation = this.get(this.translationKey);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(translation, f4, this.y + this.height / 2.0f - f3, 0x20000000);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(translation, f4 - 1.0f, this.y + this.height / 2.0f - f3 - 1.0f, -538778910);
    }

    public String getTranslationText() {
        return this.get(this.translationKey);
    }

    public void setHoverOverride(boolean bl) {
        this.hoverOverride = bl;
    }
}