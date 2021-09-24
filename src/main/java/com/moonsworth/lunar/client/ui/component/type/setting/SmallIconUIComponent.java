package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.Position;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.movement.MovementUI;
import com.moonsworth.lunar.client.util.ColorUtil;

public class SmallIconUIComponent extends UIComponent {
    public ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public boolean IlllIIIIIIlllIlIIlllIlIIl;
    public boolean lIllIlIIIlIIIIIIIlllIlIll = true;
    public float llIlIIIllIIlIllIllIllllIl = 1.0f;
    public float IllIllIIIllIIIlIlIlIIIIll = -1.0f;
    public float IIlIllIlllllllIIlIIIllIIl = -1.0f;
    public float lIIlIlllIlIlIIIlllIIlIIII = -1.0f;
    public float llIllIlIllIlllIllIIIIllII = -1.0f;
    public boolean IllllllllllIlIIIlllIlllll = false;
    public String lllllIllIlIIlIIlIIIlllIlI = null;
    public ColorEase IllIIIlllIIIlIlllIlIIlIII = new ColorEase(0x50FFFFFF, -1342177281);
    public ColorEase IIlIllIlIIllIIlIlIllllllI = new ColorEase(1076176165, 1076176165);
    public ColorEase lIIIlllIIIIllllIlIIIlIIll = new ColorEase(0x20FFFFFF, 0x50FFFFFF);

    public SmallIconUIComponent(UIComponent uIComponent, ResourceLocationBridge resourceLocationBridge) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = resourceLocationBridge;
    }

    public SmallIconUIComponent(UIComponent uIComponent, String string, ResourceLocationBridge resourceLocationBridge) {
        super(uIComponent);
        this.lllllIllIlIIlIIlIIIlllIlI = string;
        this.lIlIlIlIlIIlIIlIIllIIIIIl = resourceLocationBridge;
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void onGuiClosed() {
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        float f3;
        float f4;
        float f5;
        int n;
        if (this.lIllIlIIIlIIIIIIIlllIlIll) {
            n = this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl || bl && this.mouseInside(mouseX, mouseY));
            int n2 = this.lIIIlllIIIIllllIlIIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl || bl && this.mouseInside(mouseX, mouseY));
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.0f, n, 0x20FFFFFF, n2);
        }
        if (this.lllllIllIlIIlIIlIIIlllIlI != null && this.mouseInside(mouseX, mouseY) && bl) {
            HudModPosition hudModPosition = MovementUI.lIlIlIlIlIIlIIlIIllIIIIIl(mouseX, (double) mouseY);
            float f6 = FontRegistry.lIlIIIIIIlIIIllllIllIIlII().IlllIIIIIIlllIlIIlllIlIIl(this.get(this.lllllIllIlIIlIIlIIIlllIlI).toUpperCase()) + 8;
            f5 = hudModPosition.lIllIlIIIlIIIIIIIlllIlIll() == Position.TOP ? this.y + this.height + 8.0f : this.y - 8.0f - (float)(FontRegistry.IlIlIlllllIlIIlIlIlllIlIl().getHeight() * 2);
            f4 = this.x + this.width / 2.0f - f6 / 2.0f;
            AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(f4, f5, f6, FontRegistry.lIIIllIllIIllIlllIlIIlllI().getHeight() * 2 + 5, 5.0f, Integer.MIN_VALUE);
            FontRegistry.lIlIIIIIIlIIIllllIllIIlII().lIlIlIlIlIIlIIlIIllIIIIIl(this.get(this.lllllIllIlIIlIIlIIIlllIlI).toUpperCase(), f4 + 4.0f, f5 + 2.0f, Integer.MAX_VALUE);
        }
        n = this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.mouseInside(mouseX, mouseY) && bl);
        float f7 = 8.0f * this.llIlIIIllIIlIllIllIllllIl;
        f5 = this.IllIllIIIllIIIlIlIlIIIIll == -1.0f ? f7 : this.IllIllIIIllIIIlIlIlIIIIll;
        f4 = this.IIlIllIlllllllIIlIIIllIIl == -1.0f ? f7 : this.IIlIllIlllllllIIlIIIllIIl;
        float f8 = this.lIIlIlllIlIlIIIlllIIlIIII == -1.0f ? this.x + this.width / 2.0f : this.lIIlIlllIlIlIIIlllIIlIIII;
        float f9 = f3 = this.llIllIlIllIlllIllIIIIllII == -1.0f ? this.y + this.height / 2.0f : this.llIllIlIllIlllIllIIIIllII;
        if (this.IllllllllllIlIIIlllIlllll) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(n), ColorUtil.lIllIlIIIlIIIIIIIlllIlIll(n), ColorUtil.llllIIlIIlIIlIIllIIlIIllI(n), ColorUtil.llIIIIIIIllIIllIlIllIIIIl(n));
        } else {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.6f);
        }
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl, f8 - f5 / 2.0f, f3 - f4 / 2.0f, f5, f4);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = resourceLocationBridge;
    }

    public ResourceLocationBridge lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.IlllIIIIIIlllIlIIlllIlIIl = bl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        this.lIllIlIIIlIIIIIIIlllIlIll = bl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        this.llIlIIIllIIlIllIllIllllIl = f;
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(float f) {
        this.IllIllIIIllIIIlIlIlIIIIll = f;
    }

    public float llIlllIIIllllIIlllIllIIIl() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public void llIIIIIIIllIIllIlIllIIIIl(float f) {
        this.IIlIllIlllllllIIlIIIllIIl = f;
    }

    public float llllIIlIIlIIlIIllIIlIIllI() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public void lIIIllIllIIllIlllIlIIlllI(float f) {
        this.lIIlIlllIlIlIIIlllIIlIIII = f;
    }

    public float llIIIIIIIllIIllIlIllIIIIl() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public void IlllllIlIIIlIIlIIllIIlIll(float f) {
        this.llIllIlIllIlllIllIIIIllII = f;
    }

    public float lIIIllIllIIllIlllIlIIlllI() {
        return this.llIllIlIllIlllIllIIIIllII;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(boolean bl) {
        this.IllllllllllIlIIIlllIlllll = bl;
    }

    public String IlllllIlIIIlIIlIIllIIlIll() {
        return this.lllllIllIlIIlIIlIIIlllIlI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ColorEase colorEase) {
        this.IllIIIlllIIIlIlllIlIIlIII = colorEase;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(ColorEase colorEase) {
        this.IIlIllIlIIllIIlIlIllllllI = colorEase;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(ColorEase colorEase) {
        this.lIIIlllIIIIllllIlIIIlIIll = colorEase;
    }
}
