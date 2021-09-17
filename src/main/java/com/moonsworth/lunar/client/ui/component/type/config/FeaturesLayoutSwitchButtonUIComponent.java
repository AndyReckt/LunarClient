package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class FeaturesLayoutSwitchButtonUIComponent
extends UIComponent {
    public final ColorEase lIlIlIlIlIIlIIlIIllIIIIIl = new ColorEase(-1593835521, -1);

    public FeaturesLayoutSwitchButtonUIComponent(UIComponent uIComponent) {
        super(uIComponent);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, (float)(this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) >> 24 & 0xFF) / 255.0f);
        if (((Boolean) LunarClient.IIllIlIllIlIllIllIllIllII().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIlIIIIIIllIlIIIIllIIII().llIlllIIIllllIIlllIllIIIl()).booleanValue()) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/large-menu-24x24.png"), this.x + 1.0f, this.y + 1.0f, 12.0f, 12.0f);
        } else {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/compact-menu-24x24.png"), this.x + 1.0f, this.y + 1.0f, 12.0f, 12.0f);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}
 