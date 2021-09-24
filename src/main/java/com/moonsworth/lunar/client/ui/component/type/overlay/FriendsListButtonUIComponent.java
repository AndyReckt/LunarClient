package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import lombok.Getter;

@Getter
public class FriendsListButtonUIComponent extends UIComponent {
    public String textSpaced;
    public final LCFontRenderer fontRenderer;
    public ColorEase ease = new ColorEase(0x20FFFFFF, 0x45FFFFFF);
    public boolean hoverOverride;

    public FriendsListButtonUIComponent(UIComponent uIComponent, String string) {
        this(uIComponent, string, FontRegistry.llIIIlllIIlllIllllIlIllIl());
    }

    public FriendsListButtonUIComponent(UIComponent uIComponent, String string, LCFontRenderer lCFontRenderer) {
        super(uIComponent);
        this.textSpaced = string.replace("", " ").trim();
        this.fontRenderer = lCFontRenderer;
        this.ease = new ColorEase(0x20909090, 1167102096);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.textSpaced = string.replace("", " ").trim();
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, this.ease.lIlIlIlIlIIlIIlIIllIIIIIl(this.hoverOverride || bl && this.mouseInside(mouseX, mouseY)));
        float f3 = (float)this.fontRenderer.getHeight() + 1.0f;
        this.fontRenderer.IlllIIIIIIlllIlIIlllIlIIl(this.textSpaced, this.x + this.width / 2.0f, this.y + this.height / 2.0f - f3, -4275267);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }

    public String getTextSpaced() {
        return this.textSpaced;
    }

    public void setHoverOverride(boolean bl) {
        this.hoverOverride = bl;
    }
}
