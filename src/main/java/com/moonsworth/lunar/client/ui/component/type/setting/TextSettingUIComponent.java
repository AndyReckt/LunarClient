package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.CustomScreen;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.config.FeatureSettingsUIComponent;
import com.moonsworth.lunar.client.ui.screen.type.SettingsUIScreen;

public class TextSettingUIComponent extends AbstractDescritiveSettingUIComponent<String> {
    public AutoTextUIComponent lIlIlIlIlIIlIIlIIllIIIIIl;

    public TextSettingUIComponent(TextSetting parent, UIComponent uIComponent) {
        super(parent, uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new AutoTextUIComponent(uIComponent, parent.llIlllIIIllllIIlllIllIIIl());
        this.lIlIlIlIlIIlIIlIIllIIIIIl.setSuppiler(parent::llIlllIIIllllIIlllIllIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(parent::getBool);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(parent::getBool);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(parent::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(() -> true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(parent.llIlllIIIllllIIlllIllIIIl());
        this.lIlIlIlIlIIlIIlIIllIIIIIl.llIlllIIIllllIIlllIllIIIl((f, f2, n) -> {
            SettingsUIScreen settingsUIScreen;
            CustomScreen customScreen;
            GuiScreenBridge guiScreenBridge = Ref.getMinecraft().bridge$getCurrentScreen();
            if (guiScreenBridge instanceof WrappedGuiScreenBridge && (customScreen = ((WrappedGuiScreenBridge)guiScreenBridge).getCustomScreen()) instanceof SettingsUIScreen && (settingsUIScreen = (SettingsUIScreen)customScreen).llIIIIIIIllIIllIlIllIIIIl().lIIlIlllIlIlIIIlllIIlIIII() instanceof FeatureSettingsUIComponent) {
                FeatureSettingsUIComponent featureSettingsUIComponent = (FeatureSettingsUIComponent)settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl().lIIlIlllIlIlIIIlllIIlIIII();
                for (AbstractSetting<?> abstractSetting : featureSettingsUIComponent.llllIIlIIlIIlIIllIIlIIllI().lllIIIIIlllIIlIllIIlIIIlI()) {
                    if (!(abstractSetting instanceof TextSetting) || abstractSetting.f_().equals(parent.f_())) continue;
                    ((TextSetting)abstractSetting).lIlIlIlIlIIlIIlIIllIIIIIl(false);
                }
            }
            return true;
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n));
        this.onMouseClick((float f, float f2, int n) -> {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(f, f2)) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl.onMouseClicked(f, f2, n);
            } else if (parent.getBool()) {
                parent.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            }
            return false;
        });
    }

    @Override
    public float getHeight() {
        return this.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0f : 14.0f;
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    @Override
    public void onUpdateScreen() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.onUpdateScreen();
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.setting.f_(), this.x, this.y + 1.5f, -4079426);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.setPositionAndSize(this.x + this.width - 90.0f, this.y + 2.0f, 90.0f, 12.0f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.drawComponent(mouseX, mouseY, bl);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.onKeyTyped(c, keyType);
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        super.handleMouseScrollDelta(n);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.handleMouseScrollDelta(n);
    }

    @Override
    public void onGuiClosed() {
    }
}
