package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class _UnusedUIComponent extends UIComponent {
    public String IlllIIIIIIlllIlIIlllIlIIl;
    public final LCFontRenderer lIllIlIIIlIIIIIIIlllIlIll;
    public ColorEase llIlIIIllIIlIllIllIllllIl;
    public int IllIllIIIllIIIlIlIlIIIIll;
    public boolean IIlIllIlllllllIIlIIIllIIl;
    public boolean lIIlIlllIlIlIIIlllIIlIIII;
    public int llIllIlIllIlllIllIIIIllII;
    public float lIlIlIlIlIIlIIlIIllIIIIIl;

    public _UnusedUIComponent(UIComponent var1, String var2) {
        this(var1, var2, FontRegistry.IlIlIlllllIlIIlIlIlllIlIl);
    }

    public _UnusedUIComponent(UIComponent var1, String var2, LCFontRenderer var3) {
        this(var1, var2, var3, true);
    }

    public _UnusedUIComponent(UIComponent var1, String var2, LCFontRenderer var3, boolean var4) {
        super(var1);
        this.IllIllIIIllIIIlIlIlIIIIll = -4275267;
        this.lIlIlIlIlIIlIIlIIllIIIIIl = 0.0F;
        this.IlllIIIIIIlllIlIIlllIlIIl = var4 ? var2.replace("", " ").trim() : var2;
        this.lIllIlIIIlIIIIIIIlllIlIll = var3;
        this.llIlIIIllIIlIllIllIllllIl = new ColorEase(-2141746990, -11561732);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(var1, false);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1, boolean var2) {
        this.IlllIIIIIIlllIlIIlllIlIIl = !var2 ? var1.replace("", " ").trim() : var1;
    }

    public void onUpdateScreen() {
        ++this.llIllIlIllIlllIllIIIIllII;
    }

    public void onGuiClosed() {
    }

    public void onKeyTyped(char var1, KeyType var2) {
    }

    public void drawComponent(float mouseX, float mouseY, boolean var3) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.0F, 0, !this.IIlIllIlllllllIIlIIIllIIl && (!var3 || !this.mouseInside(mouseX, mouseY)) ? 547529378 : 1621271202, this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlIllIlllllllIIlIIIllIIl || var3 && this.mouseInside(mouseX, mouseY)));
        float var4 = (float)this.lIllIlIIIlIIIIIIIlllIlIll.getHeight();
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl + (this.lIIlIlllIlIlIIIlllIIlIIII && this.IIlIllIlllllllIIlIIIllIIl && this.llIllIlIllIlllIllIIIIllII / 6 % 2 == 0 ? "_" : ""), this.x + this.width / 2.0F + 1.0F - (float)this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(this.IlllIIIIIIlllIlIIlllIlIIl) / 2.0F, this.y + this.height / 2.0F - var4 + 1.0F + this.lIlIlIlIlIIlIIlIIllIIIIIl, 536870912);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl + (this.lIIlIlllIlIlIIIlllIIlIIII && this.IIlIllIlllllllIIlIIIllIIl && this.llIllIlIllIlllIllIIIIllII / 6 % 2 == 0 ? "_" : ""), this.x + this.width / 2.0F - (float)this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(this.IlllIIIIIIlllIlIIlllIlIIl) / 2.0F, this.y + this.height / 2.0F - var4 + this.lIlIlIlIlIIlIIlIIllIIIIIl, this.IllIllIIIllIIIlIlIlIIIIll);
    }

    public String lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ColorEase var1) {
        this.llIlIIIllIIlIllIllIllllIl = var1;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int var1) {
        this.IllIllIIIllIIIlIlIlIIIIll = var1;
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean var1) {
        this.IIlIllIlllllllIIlIIIllIIl = var1;
    }

    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean var1) {
        this.lIIlIlllIlIlIIIlllIIlIIII = var1;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
    }
}
