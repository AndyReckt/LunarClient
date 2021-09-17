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

import java.util.function.Supplier;

/**
 * @author Decencies
 * @since 10/07/2021 18:15
 */
public class IlllIIIIIIlllIlIIlllIlIIl
        extends UIComponent {
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public final LCFontRenderer lIllIlIIIlIIIIIIIlllIlIll;
    public ResourceLocationBridge llIlIIIllIIlIllIllIllllIl = null;
    public float IllIllIIIllIIIlIlIlIIIIll = 14.0f;
    public ColorEase IIlIllIlllllllIIlIIIllIIl = new ColorEase(1076176165, 1076176165);
    public ColorEase lIIlIlllIlIlIIIlllIIlIIII = new ColorEase(0x20FFFFFF, 0x45FFFFFF);
    public int llIllIlIllIlllIllIIIIllII = -4275267;
    public Supplier IllllllllllIlIIIlllIlllll = null;
    public boolean lllllIllIlIIlIIlIIIlllIlI;
    public boolean IllIIIlllIIIlIlllIlIIlIII;
    public boolean IIlIllIlIIllIIlIlIllllllI;
    public int lIIIlllIIIIllllIlIIIlIIll;
    public float lIlIlIlIlIIlIIlIIllIIIIIl = 0.0f;

    public IlllIIIIIIlllIlIIlllIlIIl(UIComponent uIComponent, String string) {
        this(uIComponent, string, FontRegistry.IlIlIlllllIlIIlIlIlllIlIl);
    }

    public IlllIIIIIIlllIlIIlllIlIIl(UIComponent uIComponent, String string, LCFontRenderer lCFontRenderer) {
        this(uIComponent, string, lCFontRenderer, true);
    }

    public IlllIIIIIIlllIlIIlllIlIIl(UIComponent uIComponent, String string, LCFontRenderer lCFontRenderer, boolean bl) {
        super(uIComponent);
        this.IllIIIlllIIIlIlllIlIIlIII = !bl;
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
        this.lIllIlIIIlIIIIIIIlllIlIll = lCFontRenderer;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(string, false);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string, boolean bl) {
        this.IllIIIlllIIIlIlllIlIIlIII = bl;
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        ++this.lIIIlllIIIIllllIlIIIlIIll;
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        int n = this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllllIllIlIIlIIlIIIlllIlI || bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2));
        int n2 = this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllllIllIlIIlIIlIIIlllIlI || bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2));
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.0f, n, 0x20FFFFFF, n2);
        float f3 = this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl();
        if (this.llIlIIIllIIlIllIllIllllIl != null) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, ColorUtil.llIIIIIIIllIIllIlIllIIIIl(n2) * 2.5f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl, this.x + this.width / 2.0f - this.IllIllIIIllIIIlIlIlIIIIll / 2.0f, this.y + this.height / 2.0f - this.IllIllIIIllIIIlIlIlIIIIll / 2.0f, this.IllIllIIIllIIIlIlIlIIIIll, this.IllIllIIIllIIIlIlIlIIIIll);
        } else {
            String string = !this.IllIIIlllIIIlIlllIlIIlIII ? this.get(this.IlllIIIIIIlllIlIIlllIlIIl, new Object[0]).toUpperCase().replace("", " ").trim() : this.get(this.IlllIIIIIIlllIlIIlllIlIIl, new Object[0]);
            int n3 = this.IllllllllllIlIIIlllIlllll == null ? this.llIllIlIllIlllIllIIIIllII : (Integer)this.IllllllllllIlIIIlllIlllll.get();
            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(string + (this.IIlIllIlIIllIIlIlIllllllI && this.lllllIllIlIIlIIlIIIlllIlI && this.lIIIlllIIIIllllIlIIIlIIll / 6 % 2 == 0 ? "_" : ""), this.x + this.width / 2.0f + 1.0f - (float)this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(string) / 2.0f, this.y + this.height / 2.0f - f3 + 1.0f + this.lIlIlIlIlIIlIIlIIllIIIIIl, 0x20000000);
            this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(string + (this.IIlIllIlIIllIIlIlIllllllI && this.lllllIllIlIIlIIlIIIlllIlI && this.lIIIlllIIIIllllIlIIIlIIll / 6 % 2 == 0 ? "_" : ""), this.x + this.width / 2.0f - (float)this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(string) / 2.0f, this.y + this.height / 2.0f - f3 + this.lIlIlIlIlIIlIIlIIllIIIIIl, n3);
        }
    }

    public String lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge) {
        this.llIlIIIllIIlIllIllIllllIl = resourceLocationBridge;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.IllIllIIIllIIIlIlIlIIIIll = f;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ColorEase colorEase) {
        this.IIlIllIlllllllIIlIIIllIIl = colorEase;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(ColorEase colorEase) {
        this.lIIlIlllIlIlIIIlllIIlIIII = colorEase;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.llIllIlIllIlllIllIIIIllII = n;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Supplier supplier) {
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