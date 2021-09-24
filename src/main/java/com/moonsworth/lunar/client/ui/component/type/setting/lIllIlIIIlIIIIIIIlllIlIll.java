package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.ButtonsSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;

public class lIllIlIIIlIIIIIIIlllIlIll extends AbstractDescritiveSettingUIComponent {
    public DefaultButtonUIComponent lIlIlIlIlIIlIIlIIllIIIIIl;

    public lIllIlIIIlIIIIIIIlllIlIll(ButtonsSetting buttonsSetting, UIComponent uIComponent) {
        super(buttonsSetting, uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new DefaultButtonUIComponent(this, buttonsSetting.f_(), FontRegistry.lIlIIIIIIlIIIllllIllIIlII());
        this.lIlIlIlIlIIlIIlIIllIIIIIl.IlIlIlllllIlIIlIlIlllIlIl(-0.7f);
        this.onMouseClick((float f, float f2, int n) -> {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(f, f2)) {
                buttonsSetting.lIlIlIlIlIIlIIlIIllIIIIIl().accept(f, f2, n);
                return true;
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
        this.lIlIlIlIlIIlIIlIIllIIIIIl.setPositionAndSize(this.x, this.y, 70.0f, 12.0f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.drawComponent(mouseX, mouseY, bl);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }
}
