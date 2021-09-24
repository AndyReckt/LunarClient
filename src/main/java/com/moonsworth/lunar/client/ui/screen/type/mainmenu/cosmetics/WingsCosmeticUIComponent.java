package com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.cosmetic.type.WingsCosmeticTypeWithRenderf;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

public class WingsCosmeticUIComponent extends AbstractCosmeticUIComponent {
    public final ColorEase color = new ColorEase(0, -16777216);

    public WingsCosmeticUIComponent(UIComponent uIComponent, WingsCosmeticTypeWithRenderf wingsCosmeticTypeWithRenderf) {
        super(uIComponent, wingsCosmeticTypeWithRenderf);
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void onGuiClosed() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        if (!this.ease.llllIIlIIlIIlIIllIIlIIllI()) {
            this.ease.lIllIlIIIlIIIIIIIlllIlIll();
        }
        float f3 = this.ease.getProgress();
        int n = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.0f, 0.0f, 0.0f, 0.2f);
        int n2 = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.24f, 0.5f, 0.25f, 1.0f);
        int n3 = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(1.0f, 1.0f, 1.0f, 0.2f);
        if (this.cosmetic == null) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 5.0f, n, n3, n);
        } else {
            float f4 = ColorUtil.llIIIIIIIllIIllIlIllIIIIl(this.color.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY))) * 0.3f;
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, (0.7f + f4) * f3);
            if (this.cosmetic.IlIlIlllllIlIIlIlIlllIlIl() != null) {
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.cosmetic.IlIlIlllllIlIIlIlIlllIlIl(), this.x + this.width / 2.0f - (this.width - 4.0f) / 2.0f, this.y + this.height / 2.0f - (this.height - 12.0f) / 2.0f, this.width - 4.0f, this.height - 12.0f);
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 5.0f, n, this.cosmetic.llIIIIIIIllIIllIlIllIIIIl() ? n2 : n3, 0);
            }
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return this.cosmetic.llIIIIIIIllIIllIlIllIIIIl();
    }

    @Override
    public String llIlllIIIllllIIlllIllIIIl() {
        return this.cosmetic.IlllIIIIIIlllIlIIlllIlIIl();
    }
}