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

public class DefaultModuleUIComponent extends AbstractFeatureUIComponent {
    public static final float DEFAULT_WIDTH = 115.0f;
    public static final float DEFAULT_HEIGHT = 112.0f;
    public final IllIllIIIllIIIlIlIlIIIIll llIlIIIllIIlIllIllIllllIl;
    public final OptionsSpacedButtonUIComponent IllIllIIIllIIIlIlIlIIIIll;
    public final ColorEase ease = new ColorEase(542594903, 1348953959);

    public DefaultModuleUIComponent(UIComponent parent, ClientSettingsParentUIComponent clientSettingsUIComponent, Feature feature) {
        super(parent, feature);
        this.setWidth(DEFAULT_WIDTH);
        this.setHeight(DEFAULT_HEIGHT);
        this.llIlIIIllIIlIllIllIllllIl = new IllIllIIIllIIIlIlIlIIIIll(this, feature.llIIIlllIIlllIllllIlIllIl(), feature.llIllIlIllIlllIllIIIIllII() == null || feature.llIllIlIllIlllIllIIIIllII());
        this.IllIllIIIllIIIlIlIlIIIIll = new OptionsSpacedButtonUIComponent(this, clientSettingsUIComponent, this.feature);
        this.onMouseClick((float f, float f2, int n) -> {
            if (this.llIlIIIllIIlIllIllIllllIl.mouseInside(f, f2)) {
                return this.llIlIIIllIIlIllIllIllllIl.onMouseClicked(f, f2, n);
            }
            if (this.IllIllIIIllIIIlIlIlIIIIll.mouseInside(f, f2)) {
                return this.IllIllIIIllIIIlIlIlIIIIll.onMouseClicked(f, f2, n);
            }
            return false;
        });
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        this.llIlIIIllIIlIllIllIllllIl.setPositionAndSize(x, y + height - 20.0f, width, 20.0f);
        this.IllIllIIIllIIIlIlIlIIIIll.setPositionAndSize(x, y + height - 40.0f, width, 20.0f);
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 6.0f, 0, 0, this.ease.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY)));
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, 6.0f, 0x20E2E2E2);
        ResourceLocationBridge resourceLocationBridge = this.feature.llllIlIllllIlIlIIIllIlIlI();
        if (resourceLocationBridge != null) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.85f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(resourceLocationBridge, this.x + this.width / 2.0f - 13.0f, this.y + this.height / 2.0f - 40.0f, 26.0f, 26.0f);
        } else {
            this.feature.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height / 2.0f, mouseX, mouseY, bl);
        }
        String string = this.feature.getDetails().get("name");
        FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl(string, this.x + this.width / 2.0f, this.y + this.height / 2.0f - 3.0f, -8487555);
        this.llIlIIIllIIlIllIllIllllIl.drawComponent(mouseX, mouseY, bl);
        this.IllIllIIIllIIIlIlIlIIIIll.drawComponent(mouseX, mouseY, bl);
        if (this.getFeature().getDetails().getCategories().contains(ModuleCategory.NEW) && !this.feature.lllllIllIllIllllIlIllllII()) {
            float f3 = FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl(string);
            FontRegistry.lIlIIIIIIlIIIllllIllIIlII().IlllIIIIIIlllIlIIlllIlIIl(this.get("new").toUpperCase(), this.x + this.width / 2.0f + f3 / 2.0f, this.y + this.height / 2.0f - 8.0f, -1879104990);
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }
}
