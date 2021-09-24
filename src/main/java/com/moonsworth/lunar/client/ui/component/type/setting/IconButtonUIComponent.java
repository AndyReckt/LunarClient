package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

public class IconButtonUIComponent extends UIComponent {
    public final ResourceLocationBridge icon;
    public final float IlllIIIIIIlllIlIIlllIlIIl;
    public final ColorEase ease = new ColorEase(0, -1);
    public boolean llIlIIIllIIlIllIllIllllIl = false;

    public IconButtonUIComponent(UIComponent uIComponent, ResourceLocationBridge resourceLocationBridge, float f) {
        super(uIComponent);
        this.icon = resourceLocationBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
    }

    public void setPosition(float f, float f2) {
        super.setPositionAndSize(f, f2, this.IlllIIIIIIlllIlIIlllIlIIl * 2.0f + 4.0f, this.IlllIIIIIIlllIlIIlllIlIIl * 2.0f + 4.0f);
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, 100876083);
        if (this.llIlIIIllIIlIllIllIllllIl) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(0.0f, 0.2f, 0.2f, 0.5f + 0.5f * ColorUtil.llIIIIIIIllIIllIlIllIIIIl(this.ease.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY))));
        } else {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(0.0f, 1.0f, 1.0f, 0.5f + 0.5f * ColorUtil.llIIIIIIIllIIllIlIllIIIIl(this.ease.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY))));
        }
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.icon, this.IlllIIIIIIlllIlIIlllIlIIl, this.x + this.IlllIIIIIIlllIlIIlllIlIIl / 2.0f, this.y + this.IlllIIIIIIlllIlIIlllIlIIl / 2.0f);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }

    public ResourceLocationBridge lIllIlIIIlIIIIIIIlllIlIll() {
        return this.icon;
    }

    public float llIlllIIIllllIIlllIllIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public ColorEase llllIIlIIlIIlIIllIIlIIllI() {
        return this.ease;
    }

    public boolean load() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public void drawComponent(boolean bl) {
        this.llIlIIIllIIlIllIllIllllIl = bl;
    }
}