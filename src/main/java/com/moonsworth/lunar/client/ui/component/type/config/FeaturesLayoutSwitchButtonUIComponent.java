package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class FeaturesLayoutSwitchButtonUIComponent extends UIComponent {
    public final ColorEase lIlIlIlIlIIlIIlIIllIIIIIl = new ColorEase(-1593835521, -1);

    public FeaturesLayoutSwitchButtonUIComponent(UIComponent uIComponent) {
        super(uIComponent);
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, (float)(this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY)) >> 24 & 0xFF) / 255.0f);
        if (LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().getCompactMenu().llIlllIIIllllIIlllIllIIIl()) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.getInstance().initResourceLocation("lunar", "icons/large-menu-24x24.png"), this.x + 1.0f, this.y + 1.0f, 12.0f, 12.0f);
        } else {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.getInstance().initResourceLocation("lunar", "icons/compact-menu-24x24.png"), this.x + 1.0f, this.y + 1.0f, 12.0f, 12.0f);
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }
}
