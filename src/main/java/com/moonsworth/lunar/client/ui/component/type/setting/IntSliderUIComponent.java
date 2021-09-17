package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.NumberSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.AbstractEase;
import com.moonsworth.lunar.client.ui.ease.QuadraticEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class IntSliderUIComponent
extends UIComponent {
    public final AbstractEase lIlIlIlIlIIlIIlIIllIIIIIl = new QuadraticEase(500L);
    public Number IlllIIIIIIlllIlIIlllIlIIl;
    public boolean lIllIlIIIlIIIIIIIlllIlIll;
    public NumberSetting llIlIIIllIIlIllIllIllllIl;

    public IntSliderUIComponent(NumberSetting numberSetting, UIComponent uIComponent) {
        super(uIComponent);
        this.llIlIIIllIIlIllIllIllllIl = numberSetting;
        this.IlllIIIIIIlllIlIIlllIlIIl = (Number)numberSetting.llIlllIIIllllIIlllIllIIIl();
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            this.lIllIlIIIlIIIIIIIlllIlIll = true;
            return true;
        });
    }

    @Override
    public float IllIllIIIllIIIlIlIlIIIIll() {
        return 14.0f;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, boolean bl) {
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        if (!Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.lIllIlIIIlIIIIIIIlllIlIll) {
            this.lIllIlIIIlIIIIIIIlllIlIll = false;
        }
        if (this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.lIllIlIIIlIIIIIIIlllIlIll) {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.IlIlIlllllIlIIlIlIlllIlIl()) {
                this.IlllIIIIIIlllIlIIlllIlIIl = (Number)this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl();
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll();
            }
            f9 = this.llIlIIIllIIlIllIllIllllIl.lllllIllIllIllllIlIllllII().floatValue();
            f8 = this.llIlIIIllIIlIllIllIllllIl.lllIIIIIlllIIlIllIIlIIIlI().floatValue();
            f7 = f - this.x;
            f6 = f7 / this.width;
            f5 = f9 + f6 * (f8 - f9);
            if ((double)f6 <= 0.01) {
                f5 = f9;
            } else if ((double)f6 >= 0.99) {
                f5 = f8;
            }
            this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl((double)Math.round((double)f5 * 100.0) / 100.0);
        } else if (!((Number)this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl()).equals(this.IlllIIIIIIlllIlIIlllIlIIl) && this.lIlIlIlIlIIlIIlIIllIIIIIl.IlIlIlllllIlIIlIlIlllIlIl()) {
            this.IlllIIIIIIlllIlIIlllIlIIl = (Number)this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl();
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll();
        }
        f9 = this.llIlIIIllIIlIllIllIllllIl.lllllIllIllIllllIlIllllII().floatValue();
        f8 = this.llIlIIIllIIlIllIllIllllIl.lllIIIIIlllIIlIllIIlIIIlI().floatValue();
        f7 = ((Number)this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl()).floatValue();
        f6 = (f7 - f9) / (f8 - f9);
        f5 = this.width * f6;
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl.lIIlIlllIlIlIIIlllIIlIIII()) {
            f4 = (float)(this.IlllIIIIIIlllIlIIlllIlIIl.doubleValue() - (double)f9) / (f8 - f9);
            f3 = this.width * f6;
            float f10 = this.width * f4;
            float f11 = f10 - f3;
            f5 = f10 - f11 * this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllllIlIIIlIIlIIllIIlIll();
        }
        f4 = this.height / 4.0f;
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + this.height / 2.0f - f4 / 2.0f, this.width, f4, -15066341);
        f3 = this.height / 3.0f;
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((double)(this.x + f5), (double)(this.y + this.height / 2.0f), (double)f3, -11561732);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.14f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((double)(this.x + f5), (double)(this.y + this.height / 2.0f), (double)f3, (double)(f3 - 1.0f), 1.0, 1, 1.0);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        LCFontRenderer lCFontRenderer = FontRegistry.lllIIIIIlllIIlIllIIlIIIlI();
        String string = (double)Math.round((double)((Number)this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl()).floatValue() * 100.0) / 100.0 + "";
        float f3 = lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(string);
        lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(string, this.x - 8.0f - f3, this.y + this.height / 2.0f - (float)(lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl() / 2) - 2.0f, -1879048193);
        this.IlllIIIIIIlllIlIIlllIlIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}