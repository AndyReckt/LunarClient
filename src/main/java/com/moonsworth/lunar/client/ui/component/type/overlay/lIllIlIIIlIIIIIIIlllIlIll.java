package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

public class lIllIlIIIlIIIIIIIlllIlIll
extends UIComponent {
    public final ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public final ColorEase IlllIIIIIIlllIlIIlllIlIIl;

    public lIllIlIIIlIIIIIIIlllIlIll(UIComponent uIComponent, ResourceLocationBridge resourceLocationBridge, int n, int n2) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = resourceLocationBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = new ColorEase(n, n2);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        float f3 = 2.5f;
        int n = this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2));
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(n), ColorUtil.lIllIlIIIlIIIIIIIlllIlIll(n), ColorUtil.llllIIlIIlIIlIIllIIlIIllI(n), ColorUtil.llIIIIIIIllIIllIlIllIIIIl(n));
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl, f3, this.x + this.width / 2.0f - f3, this.y + this.height / 2.0f - f3);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}
 