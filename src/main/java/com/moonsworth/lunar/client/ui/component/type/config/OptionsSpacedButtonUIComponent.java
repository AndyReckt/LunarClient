package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.overlay.ClientSettingsParentUIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class OptionsSpacedButtonUIComponent
extends UIComponent {
    public final ColorEase lIlIlIlIlIIlIIlIIllIIIIIl = new ColorEase(0x20FFFFFF, 0x50FFFFFF);
    public static final ResourceLocationBridge IlllIIIIIIlllIlIIlllIlIIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/mainmenu/cog-20x20.png");

    public OptionsSpacedButtonUIComponent(UIComponent uIComponent, ClientSettingsParentUIComponent clientSettingsParentUIComponent, Feature feature) {
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
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)));
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 1.0f, 1.0f, this.height - 2.0f, 0x20FFFFFF);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + this.width - 1.0f, this.y + 1.0f, 1.0f, this.height - 2.0f, 0x20FFFFFF);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x + this.width - 21.0f, this.y + 1.0f, 1.0f, this.height - 2.0f, 0x20FFFFFF);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, 1.0f, 0x20FFFFFF);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + this.height - 1.0f, this.width, 1.0f, 0x20FFFFFF);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(IlllIIIIIIlllIlIIlllIlIIl, this.x + this.width - 15.0f, this.y + 5.5f, 9.0f, 9.0f);
        FontRegistry.llIIIlllIIlllIllllIlIllIl().IlllIIIIIIlllIlIIlllIlIIl("O P T I O N S", this.x + (this.width - 21.0f) / 2.0f, this.y + 6.0f, -1);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}
 