package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.NumberSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;

/**
 * @author Decencies
 * @since 10/07/2021 18:22
 */
public class NumberSettingUIComponent extends AbstractDescritiveSettingUIComponent<Number> {
    public final IntSliderUIComponent lIlIlIlIlIIlIIlIIllIIIIIl;

    public NumberSettingUIComponent(NumberSetting numberSetting, UIComponent uIComponent) {
        super(numberSetting, uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new IntSliderUIComponent(numberSetting, this);
        this.setting = numberSetting;
        this.onMouseClick((float f, float f2, int n) -> {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(f, f2)) {
                return this.lIlIlIlIlIIlIIlIIllIIIIIl.onMouseClicked(f, f2, n);
            }
            return false;
        });
    }

    @Override
    public void resoze(float f, float f2, float f3) {
        super.resoze(f, f2, f3);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.setPositionAndSize(f + f3 / 3.0f, f2, f3 - f3 / 3.0f, this.height);
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
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.setting.f_(), this.x, this.y + 1.5f, -4079426);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.drawComponent(mouseX, mouseY, bl);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }
}
