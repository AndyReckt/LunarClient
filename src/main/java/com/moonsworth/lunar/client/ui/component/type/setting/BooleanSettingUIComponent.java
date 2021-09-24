package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

/**
 * @author Decencies
 * @since 10/07/2021 15:55
 */
public class BooleanSettingUIComponent extends AbstractDescritiveSettingUIComponent<Boolean> {
    public BooleanSettingUIComponent(BooleanSetting booleanSetting, UIComponent uIComponent) {
        super(booleanSetting, uIComponent);
        this.onMouseClick((float f, float f2, int n) -> {
            booleanSetting.lIlIlIlIlIIlIIlIIllIIIIIl(!booleanSetting.llIlllIIIllllIIlllIllIIIl());
            return true;
        });
    }

    @Override
    public void resoze(float f, float f2, float f3) {
        super.setPositionAndSize(f, f2, f3, this.getHeight());
    }

    @Override
    public float getHeight() {
        return this.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0f : 14.0f;
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return true;
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        float f3 = FontRegistry.llIIIIIIIllIIllIlIllIIIIl().IlllIIIIIIlllIlIIlllIlIIl(this.setting.f_());
        if (f3 + 10.0f > this.width - 20.0f) {
            FontRegistry.llIlIIIllIIlIllIllIllllIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.setting.f_(), this.x + 20.0f, this.y + 3.0f, -4079426);
        } else {
            FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.setting.f_(), this.x + 20.0f, this.y + 1.5f, -4079426);
        }
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + 2.0f, 10.0f, 10.0f, 5.0f, bl && this.mouseInside(mouseX, mouseY) ? -11561732 : -1437625092, true, true, true, true);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 1.0f, this.y + 3.0f, 8.0f, 8.0f, 2.5f, 0x35FFFFFF, true, true, true, true);
        if (this.setting.llIlllIIIllllIIlllIllIIIl()) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.getInstance().initResourceLocation("lunar", "icons/settings/checked-14x14.png"), 3.0f, this.x + 2.0f, this.y + 3.5f);
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }
}