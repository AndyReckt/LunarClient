package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

public class IllllllllllIlIIIlllIlllll
extends UIComponent {
    public final ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public final float IlllIIIIIIlllIlIIlllIlIIl;
    public final ColorEase lIllIlIIIlIIIIIIIlllIlIll = new ColorEase(0, -1);
    public boolean llIlIIIllIIlIllIllIllllIl = false;

    public IllllllllllIlIIIlllIlllll(UIComponent uIComponent, ResourceLocationBridge resourceLocationBridge, float f) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = resourceLocationBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, this.IlllIIIIIIlllIlIIlllIlIIl * 2.0f + 4.0f, this.IlllIIIIIIlllIlIIlllIlIIl * 2.0f + 4.0f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, 100876083);
        if (this.llIlIIIllIIlIllIllIllllIl) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(0.0f, 0.2f, 0.2f, 0.5f + 0.5f * ColorUtil.llIIIIIIIllIIllIlIllIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2))));
        } else {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(0.0f, 1.0f, 1.0f, 0.5f + 0.5f * ColorUtil.llIIIIIIIllIIllIlIllIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2))));
        }
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl, this.IlllIIIIIIlllIlIIlllIlIIl, this.x + this.IlllIIIIIIlllIlIIlllIlIIl / 2.0f, this.y + this.IlllIIIIIIlllIlIIlllIlIIl / 2.0f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    public ResourceLocationBridge lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public float llIlllIIIllllIIlllIllIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public ColorEase llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public boolean load() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.llIlIIIllIIlIllIllIllllIl = bl;
    }
}