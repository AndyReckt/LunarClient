package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.overlay.ClientSettingsParentUIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class lIllIlIIIlIIIIIIIlllIlIll
extends UIComponent {
    public final ColorEase lIlIlIlIlIIlIIlIIllIIIIIl = new ColorEase(-1593835521, -1);
    public static final ResourceLocationBridge IlllIIIIIIlllIlIIlllIlIIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/mainmenu/cog-20x20.png");

    public lIllIlIIIlIIIIIIIlllIlIll(UIComponent uIComponent, ClientSettingsParentUIComponent clientSettingsParentUIComponent, Feature feature) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            try {
                clientSettingsParentUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(new FeatureSettingsUIComponent(clientSettingsParentUIComponent, feature));
                clientSettingsParentUIComponent.IlllIIIIIIlllIlIIlllIlIIl(0);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return true;
        });
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, (float)(this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) >> 24 & 0xFF) / 255.0f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(IlllIIIIIIlllIlIIlllIlIIl, this.x + 6.0f, this.y + 6.0f, 9.0f, 9.0f);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + 6.0f, this.x + 0.5f, this.y + this.height - 6.0f, 0x1FFFFFFF);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}
 