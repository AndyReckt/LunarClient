package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.overlay.ClientSettingsParentUIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class NewLabelHolderUIComponent
extends AbstractFeatureUIComponent {
    public static final float IlllIIIIIIlllIlIIlllIlIIl = 112.0f;
    public static final float lIllIlIIIlIIIIIIIlllIlIll = 115.0f;
    public final IllIllIIIllIIIlIlIlIIIIll llIlIIIllIIlIllIllIllllIl;
    public final OptionsSpacedButtonUIComponent IllIllIIIllIIIlIlIlIIIIll;
    public final ColorEase IIlIllIlllllllIIlIIIllIIl = new ColorEase(542594903, 1348953959);

    public NewLabelHolderUIComponent(UIComponent uIComponent, ClientSettingsParentUIComponent clientSettingsParentUIComponent, Feature feature) {
        super(uIComponent, feature);
        this.llIlllIIIllllIIlllIllIIIl(115.0f);
        this.llllIIlIIlIIlIIllIIlIIllI(112.0f);
        this.llIlIIIllIIlIllIllIllllIl = new IllIllIIIllIIIlIlIlIIIIll(this, feature.llIIIlllIIlllIllllIlIllIl(), feature.llIllIlIllIlllIllIIIIllII() == null || feature.llIllIlIllIlllIllIIIIllII() != false);
        this.IllIllIIIllIIIlIlIlIIIIll = new OptionsSpacedButtonUIComponent(this, clientSettingsParentUIComponent, this.lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            if (this.IllIllIIIllIIIlIlIlIIIIll.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            return false;
        });
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + f4 - 20.0f, f3, 20.0f);
        this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + f4 - 40.0f, f3, 20.0f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 6.0f, 0, 0, this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)));
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, 6.0f, 0x20E2E2E2);
        ResourceLocationBridge resourceLocationBridge = this.lIlIlIlIlIIlIIlIIllIIIIIl.llllIlIllllIlIlIIIllIlIlI();
        if (resourceLocationBridge != null) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.85f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(resourceLocationBridge, this.x + this.width / 2.0f - 13.0f, this.y + this.height / 2.0f - 40.0f, 26.0f, 26.0f);
        } else {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height / 2.0f, f, f2, bl);
        }
        String string = this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIlIlIIIllIlIlIlIIlIIll().get("name", new Object[0]);
        FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl(string, this.x + this.width / 2.0f, this.y + this.height / 2.0f - 3.0f, -8487555);
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        if (this.lIllIlIIIlIIIIIIIlllIlIll().llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl().contains(ModuleCategory.IlllIIIIIIlllIlIIlllIlIIl) && !this.lIlIlIlIlIIlIIlIIllIIIIIl.lllllIllIllIllllIlIllllII()) {
            float f3 = FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl(string);
            FontRegistry.lIlIIIIIIlIIIllllIllIIlII().IlllIIIIIIlllIlIIlllIlIIl(this.get("new", new Object[0]).toUpperCase(), this.x + this.width / 2.0f + f3 / 2.0f, this.y + this.height / 2.0f - 8.0f, -1879104990);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}
 