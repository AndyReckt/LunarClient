package com.moonsworth.lunar.client.ui.component.type.overlay;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

public class FriendRequestButtonUIComponent extends UIComponent {
    public final ResourceLocationBridge location;
    public final ColorEase ease;

    public FriendRequestButtonUIComponent(UIComponent uIComponent, ResourceLocationBridge location, int startColor, int endColor) {
        super(uIComponent);
        this.location = location;
        this.ease = new ColorEase(startColor, endColor);
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        float f3 = 2.5f;
        int n = this.ease.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY));
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(n), ColorUtil.lIllIlIIIlIIIIIIIlllIlIll(n), ColorUtil.llllIIlIIlIIlIIllIIlIIllI(n), ColorUtil.llIIIIIIIllIIllIlIllIIIIl(n));
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.location, f3, this.x + this.width / 2.0f - f3, this.y + this.height / 2.0f - f3);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }
}
