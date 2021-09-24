package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class CompactModuleUIComponent extends AbstractFeatureUIComponent {
    public static final float IlllIIIIIIlllIlIIlllIlIIl = 22.0f;
    public static final float lIllIlIIIlIIIIIIIlllIlIll = 115.0f;
    public final lIllIlIIIlIIIIIIIlllIlIll llIlIIIllIIlIllIllIllllIl;
    public final ColorEase IllIllIIIllIIIlIlIlIIIIll = new ColorEase(542594903, 1348953959);
    public final ColorEase IIlIllIlllllllIIlIIIllIIl = new ColorEase(1616336727, -1352177817);
    public final ColorEase lIIlIlllIlIlIIIlllIIlIIII = new ColorEase(1881790074, -1339435398);
    public final ColorEase llIllIlIllIlllIllIIIIllII = new ColorEase(1893605714, -1327619758);

    public CompactModuleUIComponent(UIComponent parent, ClientSettingsParentUIComponent clientSettingsParentUIComponent, ModuleListUIComponent moduleListUIComponent, Feature feature) {
        super(parent, feature);
        this.setWidth(115.0f);
        this.setHeight(22.0f);
        this.llIlIIIllIIlIllIllIllllIl = new lIllIlIIIlIIIIIIIlllIlIll(this, clientSettingsParentUIComponent, this.feature);
        this.onMouseRelease((f, f2, n) -> {
            if (moduleListUIComponent.getDragging() != null) {
                return false;
            }
            if (this.llIlIIIllIIlIllIllIllllIl.mouseInside(f, f2)) {
                return this.llIlIIIllIIlIllIllIllllIl.onMouseClicked(f, f2, n);
            }
            this.feature.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.feature.llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl() == false);
            return true;
        });
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        this.llIlIIIllIIlIllIllIllllIl.setPositionAndSize(x, y + height - 40.0f, width, 20.0f);
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        this.llIlIIIllIIlIllIllIllllIl.setPositionAndSize(this.x + this.width - 22.0f, this.y, 22.0f, 22.0f);
        int n = this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY));
        int n2 = this.feature.llIllIlIllIlllIllIIIIllII() == null || this.feature.llIllIlIllIlllIllIIIIllII().booleanValue() ? (this.feature.llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl().booleanValue() ? this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY)) : this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY))) : -1346848584;
        int n3 = this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY));
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, n);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, 3.0f, n2);
        ResourceLocationBridge resourceLocationBridge = this.feature.llIIIlIllIIIIlIIIlIlIllIl();
        if (resourceLocationBridge != null) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, (float)(n3 >> 24 & 0xFF) / 255.0f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(resourceLocationBridge, this.x + 6.0f, this.y + 6.0f, 10.0f, 10.0f);
        }
        String string = this.feature.getDetails().get("name");
        FontRegistry.llIlIIIllIIlIllIllIllllIl().lIlIlIlIlIIlIIlIIllIIIIIl(string, this.x + (resourceLocationBridge == null ? 6.0f : 20.0f), this.y + this.height / 2.0f - 4.0f, -4868683);
        this.llIlIIIllIIlIllIllIllllIl.drawComponent(mouseX, mouseY, bl);
        if (this.getFeature().getDetails().getCategories().contains(ModuleCategory.NEW) && !this.feature.lllllIllIllIllllIlIllllII()) {
            float f3 = FontRegistry.llIlIIIllIIlIllIllIllllIl().IlllIIIIIIlllIlIIlllIlIIl(string);
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI().IlllIIIIIIlllIlIIlllIlIIl(this.get("new").toUpperCase(), this.x + (resourceLocationBridge == null ? 6.0f : 20.0f) + f3 + 4.0f, this.y + this.height / 2.0f - 8.0f, -1879104990);
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }
}
