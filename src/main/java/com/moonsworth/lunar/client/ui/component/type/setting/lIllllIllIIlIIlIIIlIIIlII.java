package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class lIllllIllIIlIIlIIIlIIIlII extends AbstractDescritiveSettingUIComponent {
    public Runnable lIlIlIlIlIIlIIlIIllIIIIIl;

    public lIllllIllIIlIIlIIIlIIIlII(BooleanSetting booleanSetting, UIComponent uIComponent) {
        super(booleanSetting, uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            booleanSetting.lIlIlIlIlIIlIIlIIllIIIIIl((Boolean)booleanSetting.llIlllIIIllllIIlllIllIIIl() == false);
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl != null) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl.run();
            }
            return true;
        });
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, this.IllIllIIIllIIIlIlIlIIIIll());
    }

    @Override
    public float IllIllIIIllIIIlIlIlIIIIll() {
        return ((BooleanSetting)this.llIIIIIIIllIIllIlIllIIIIl()).llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0f : 14.0f;
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return true;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        FontRegistry.IlIlIlllllIlIIlIlIlllIlIl().lIlIlIlIlIIlIIlIIllIIIIIl(((BooleanSetting)this.IlllIIIIIIlllIlIIlllIlIIl).f_(), this.x + 13.0f, this.y + 1.5f, -4079426);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + 2.0f, 8.0f, 8.0f, 4.0f, bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) ? -11561732 : -1437625092, true, true, true, true);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 1.0f, this.y + 3.0f, 6.0f, 6.0f, 2.0f, 0x35FFFFFF, true, true, true, true);
        if (((Boolean)((BooleanSetting)this.IlllIIIIIIlllIlIIlllIlIIl).llIlllIIIllllIIlllIllIIIl()).booleanValue()) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/settings/checked-14x14.png"), 3.0f, this.x + 1.0f, this.y + 2.5f);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Runnable runnable) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = runnable;
    }
}