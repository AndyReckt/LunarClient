package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

import java.awt.*;
import java.util.function.Supplier;

/**
 * @author Decencies
 * @since 10/07/2021 18:15
 */
public class DefaultButtonUIComponent extends UIComponent {
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public final LCFontRenderer fontRenderer;
    public ResourceLocationBridge icon = null;
    public float IllIllIIIllIIIlIlIlIIIIll = 14.0f;
    public ColorEase ease1 = new ColorEase(1076176165, 1076176165);
    public ColorEase ease2 = new ColorEase(0x20FFFFFF, 0x45FFFFFF);
    public int llIllIlIllIlllIllIIIIllII = -4275267;
    public Supplier<Integer> IllllllllllIlIIIlllIlllll = null;
    public boolean lllllIllIlIIlIIlIIIlllIlI;
    public boolean noLetterSpacing;
    public boolean IIlIllIlIIllIIlIlIllllllI;
    public int lIIIlllIIIIllllIlIIIlIIll;
    public float lIlIlIlIlIIlIIlIIllIIIIIl = 0.0f;

    public DefaultButtonUIComponent(UIComponent uIComponent, String string) {
        this(uIComponent, string, FontRegistry.IlIlIlllllIlIIlIlIlllIlIl);
    }

    public DefaultButtonUIComponent(UIComponent uIComponent, String string, LCFontRenderer lCFontRenderer) {
        this(uIComponent, string, lCFontRenderer, true);
    }

    public DefaultButtonUIComponent(UIComponent uIComponent, String string, LCFontRenderer lCFontRenderer, boolean bl) {
        super(uIComponent);
        this.noLetterSpacing = !bl;
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
        this.fontRenderer = lCFontRenderer;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(string, false);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string, boolean bl) {
        this.noLetterSpacing = bl;
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
    }

    @Override
    public void onUpdateScreen() {
        ++this.lIIIlllIIIIllllIlIIIlIIll;
    }

    @Override
    public void onGuiClosed() {
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {

        FontRegistry.lIIlIlllIlIlIIIlllIIlIIII().IlllIIIIIIlllIlIIlllIlIIl(ease1.lllllIllIllIllllIlIllllII() + "", x + 1, y + 1, Color.WHITE.getRGB());

        int n = this.ease1.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllllIllIlIIlIIlIIIlllIlI || bl && this.mouseInside(mouseX, mouseY));
        int n2 = this.ease2.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllllIllIlIIlIIlIIIlllIlI || bl && this.mouseInside(mouseX, mouseY));
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.0f, n, 0x20FFFFFF, n2);
        float f3 = this.fontRenderer.getHeight();
        if (this.icon != null) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, ColorUtil.llIIIIIIIllIIllIlIllIIIIl(n2) * 2.5f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.icon, this.x + this.width / 2.0f - this.IllIllIIIllIIIlIlIlIIIIll / 2.0f, this.y + this.height / 2.0f - this.IllIllIIIllIIIlIlIlIIIIll / 2.0f, this.IllIllIIIllIIIlIlIlIIIIll, this.IllIllIIIllIIIlIlIlIIIIll);
        } else {
            String string = !this.noLetterSpacing ? this.get(this.IlllIIIIIIlllIlIIlllIlIIl).toUpperCase().replace("", " ").trim() : this.get(this.IlllIIIIIIlllIlIIlllIlIIl);
            int color = this.IllllllllllIlIIIlllIlllll == null ? this.llIllIlIllIlllIllIIIIllII : this.IllllllllllIlIIIlllIlllll.get();
            this.fontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(string + (this.IIlIllIlIIllIIlIlIllllllI && this.lllllIllIlIIlIIlIIIlllIlI && this.lIIIlllIIIIllllIlIIIlIIll / 6 % 2 == 0 ? "_" : ""), this.x + this.width / 2.0f + 1.0f - (float)this.fontRenderer.IlllIIIIIIlllIlIIlllIlIIl(string) / 2.0f, this.y + this.height / 2.0f - f3 + 1.0f + this.lIlIlIlIlIIlIIlIIllIIIIIl, 0x20000000);
            this.fontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(string + (this.IIlIllIlIIllIIlIlIllllllI && this.lllllIllIlIIlIIlIIIlllIlI && this.lIIIlllIIIIllllIlIIIlIIll / 6 % 2 == 0 ? "_" : ""), this.x + this.width / 2.0f - (float)this.fontRenderer.IlllIIIIIIlllIlIIlllIlIIl(string) / 2.0f, this.y + this.height / 2.0f - f3 + this.lIlIlIlIlIIlIIlIIllIIIIIl, color);
        }
    }

    public String lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge) {
        this.icon = resourceLocationBridge;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.IllIllIIIllIIIlIlIlIIIIll = f;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ColorEase colorEase) {
        this.ease1 = colorEase;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(ColorEase colorEase) {
        this.ease2 = colorEase;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.llIllIlIllIlllIllIIIIllII = n;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Supplier<Integer> supplier) {
        this.IllllllllllIlIIIlllIlllll = supplier;
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.lllllIllIlIIlIIlIIIlllIlI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.lllllIllIlIIlIIlIIIlllIlI = bl;
    }

    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return this.IIlIllIlIIllIIlIlIllllllI;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        this.IIlIllIlIIllIIlIlIllllllI = bl;
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(float f) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
    }
}