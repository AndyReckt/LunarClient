package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class ColorSettingUIComponent extends UIComponent {
    public final ColorSetting color;

    public ColorSettingUIComponent(UIComponent uIComponent, ColorSetting colorSetting) {
        super(uIComponent);
        this.color = colorSetting;
        this.onMouseClick((float f, float f2, int n) -> {
            ((ColorPickerUIComponent)uIComponent).lIlIlIlIlIIlIIlIIllIIIIIl(this);
            return true;
        });
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        return this.color.lIlIlIlIlIIlIIlIIllIIIIIl(f);
    }

    @Override
    public void onUpdateScreen() {
    }

    public ColorSettingUIComponent lIllIlIIIlIIIIIIIlllIlIll() {
        return new ColorSettingUIComponent(this.parent, this.color);
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y, this.width, this.height, 5.0f, this.color.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.y), true, true, true, true);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 1.0f, this.y + 1.0f, this.width - 2.0f, this.height - 2.0f, 2.5f, -1342177281, true, true, true, true);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }

    public Object clone() {
        return this.lIllIlIIIlIIIIIIIlllIlIll();
    }
}