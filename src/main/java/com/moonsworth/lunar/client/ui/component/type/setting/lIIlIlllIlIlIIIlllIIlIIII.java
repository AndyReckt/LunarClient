package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.ArrayList;
import java.util.List;

public abstract class lIIlIlllIlIlIIIlllIIlIIII
extends AbstractListUIComponent {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public boolean IlllIIIIIIlllIlIIlllIlIIl = true;
    public boolean lIllIlIIIlIIIIIIIlllIlIll = true;

    public lIIlIlllIlIlIIIlllIIlIIII(UIComponent uIComponent, String string) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        this.IlllIIIIIIlllIlIIlllIlIIl(f, f2, f3, f4);
    }

    public abstract void IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, float var3, float var4);

    @Override
    public List lIllIlIIIlIIIIIIIlllIlIll() {
        return new ArrayList();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        super.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll) {
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 24.0f, this.width, 0.5f, 0x20FFFFFF);
            AbstractUIScreen.llllIIlIIlIIlIIllIIlIIllI(this.x, this.y + 1.0f, this.width, 23.0f, 5.0f, 0x25000000);
        }
        if (this.IlllIIIIIIlllIlIIlllIlIIl) {
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + this.height - 30.0f, this.width, 0.5f, 0x20FFFFFF);
            AbstractUIScreen.llIIIIIIIllIIllIlIllIIIIl(this.x, this.y + this.height - 29.5f, this.width, 28.5f, 5.0f, 0x45000000);
        }
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x - 1.0f, this.y, this.width + 2.0f, this.height, 4.0f, 0x40000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 3.0f, 0x20FFFFFF);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 5.0f, Integer.MIN_VALUE);
        if (this.lIllIlIIIlIIIIIIIlllIlIll) {
            FontRegistry.IllIllIIIllIIIlIlIlIIIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl, new Object[0]), this.x + 8.0f, this.y + 6.0f, -1);
        }
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
        super.IlllIIIIIIlllIlIIlllIlIIl();
    }

    public String llllIIlIIlIIlIIllIIlIIllI() {
        return this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl, new Object[0]);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.IlllIIIIIIlllIlIIlllIlIIl = bl;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(boolean bl) {
        this.lIllIlIIIlIIIIIIIlllIlIll = bl;
    }
}