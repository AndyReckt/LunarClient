package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.setting.CrosshairPreviewSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class CrosshairPreviewUIComponent extends AbstractDescritiveSettingUIComponent {
    public static final ResourceLocationBridge[] previews = new ResourceLocationBridge[] {Bridge.getInstance().initResourceLocation("lunar", "previews/biome_0.png"), Bridge.getInstance().initResourceLocation("lunar", "previews/biome_1.png"), Bridge.getInstance().initResourceLocation("lunar", "previews/biome_2.png"), Bridge.getInstance().initResourceLocation("lunar", "previews/biome_3.png")};

    public CrosshairPreviewUIComponent(CrosshairPreviewSetting crosshairPreviewSetting, UIComponent uIComponent) {
        super(crosshairPreviewSetting, uIComponent);
        this.onMouseClick((float f, float f2, int n) -> {
            if (f < this.x + this.width - 85.0f || f > this.x + this.width) {
                return false;
            }
            crosshairPreviewSetting.lIlIlIlIlIIlIIlIIllIIIIIl((int)Math.floor((f2 - this.y) * 4.0f / this.height));
            return true;
        });
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        int n = Math.min(3, Math.max(0, (Integer) this.setting.llIlllIIIllllIIlllIllIIIl()));
        Bridge.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(-1);
        float f3 = this.width - 85.0f;
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(previews[n], this.x, this.y, f3, this.height);
        for (int i = 0; i < 4; ++i) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(previews[i], this.x + this.width - 85.0f, this.y + (float)i * this.height / 4.0f, 85.0f, this.height / 4.0f);
            if (n == i) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + f3, this.y + (float)i * this.height / 4.0f, 85.0f, this.height / 4.0f - 1.0f, 1.0f, -10496);
            }
            Bridge.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(-1);
        }
        ((CrosshairPreviewSetting)this.setting).IlllIIIIIIlllIlIIlllIlIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.x + f3 / 2.0f, this.y + this.height / 2.0f);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, int n) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f - f5, f2 - f5, f3 + f5 * 2.0f, f5, n);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f - f5, f2 + f4, f3 + f5 * 2.0f, f5, n);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f - f5, f2, f5, f4, n);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f + f3, f2, f5, f4, n);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }

    @Override
    public float getHeight() {
        return 96.0f;
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }
}
