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

public class IlllIIIIIIlllIlIIlllIlIIl
extends AbstractFeatureUIComponent {
    public static final float IlllIIIIIIlllIlIIlllIlIIl = 22.0f;
    public static final float lIllIlIIIlIIIIIIIlllIlIll = 115.0f;
    public final lIllIlIIIlIIIIIIIlllIlIll llIlIIIllIIlIllIllIllllIl;
    public final ColorEase IllIllIIIllIIIlIlIlIIIIll = new ColorEase(542594903, 1348953959);
    public final ColorEase IIlIllIlllllllIIlIIIllIIl = new ColorEase(1616336727, -1352177817);
    public final ColorEase lIIlIlllIlIlIIIlllIIlIIII = new ColorEase(1881790074, -1339435398);
    public final ColorEase llIllIlIllIlllIllIIIIllII = new ColorEase(1893605714, -1327619758);

    public IlllIIIIIIlllIlIIlllIlIIl(UIComponent uIComponent, ClientSettingsParentUIComponent clientSettingsParentUIComponent, ModuleListUIComponent moduleListUIComponent, Feature feature) {
        super(uIComponent, feature);
        this.llIlllIIIllllIIlllIllIIIl(115.0f);
        this.llllIIlIIlIIlIIllIIlIIllI(22.0f);
        this.llIlIIIllIIlIllIllIllllIl = new lIllIlIIIlIIIIIIIlllIlIll(this, clientSettingsParentUIComponent, this.lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIllIlIIIlIIIIIIIlllIlIll((f, f2, n) -> {
            if (moduleListUIComponent.llIIIIIIIllIIllIlIllIIIIl() != null) {
                return false;
            }
            if (this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl((Boolean)this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl() == false);
            return true;
        });
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + f4 - 40.0f, f3, 20.0f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.width - 22.0f, this.y, 22.0f, 22.0f);
        int n = this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2));
        int n2 = this.lIlIlIlIlIIlIIlIIllIIIIIl.llIllIlIllIlllIllIIIIllII() == null || this.lIlIlIlIlIIlIIlIIllIIIIIl.llIllIlIllIlllIllIIIIllII().booleanValue() ? (((Boolean)this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl()).booleanValue() ? this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) : this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2))) : -1346848584;
        int n3 = this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2));
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, n);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, 3.0f, n2);
        ResourceLocationBridge resourceLocationBridge = this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIIlIllIIIIlIIIlIlIllIl();
        if (resourceLocationBridge != null) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, (float)(n3 >> 24 & 0xFF) / 255.0f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(resourceLocationBridge, this.x + 6.0f, this.y + 6.0f, 10.0f, 10.0f);
        }
        String string = this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIlIlIIIllIlIlIlIIlIIll().get("name", new Object[0]);
        FontRegistry.llIlIIIllIIlIllIllIllllIl().lIlIlIlIlIIlIIlIIllIIIIIl(string, this.x + (resourceLocationBridge == null ? 6.0f : 20.0f), this.y + this.height / 2.0f - 4.0f, -4868683);
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        if (this.lIllIlIIIlIIIIIIIlllIlIll().llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl().contains(ModuleCategory.IlllIIIIIIlllIlIIlllIlIIl) && !this.lIlIlIlIlIIlIIlIIllIIIIIl.lllllIllIllIllllIlIllllII()) {
            float f3 = FontRegistry.llIlIIIllIIlIllIllIllllIl().IlllIIIIIIlllIlIIlllIlIIl(string);
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().IlllIIIIIIlllIlIIlllIlIIl(this.get("new", new Object[0]).toUpperCase(), this.x + (resourceLocationBridge == null ? 6.0f : 20.0f) + f3 + 4.0f, this.y + this.height / 2.0f - 8.0f, -1879104990);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}
 