package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.CustomScreen;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.config.FeatureSettingsUIComponent;
import com.moonsworth.lunar.client.ui.screen.type.SettingsUIScreen;

public class IlIIlIIlIIlIIllIIIllIIllI
extends AbstractDescritiveSettingUIComponent {
    public IIlllIllIlIllIllIIllIlIIl lIlIlIlIlIIlIIlIIllIIIIIl;

    public IlIIlIIlIIlIIllIIIllIIllI(lllllIIIIlIlllIllIIIlIIlI lllllIIIIlIlllIllIIIlIIlI2, UIComponent uIComponent) {
        super(lllllIIIIlIlllIllIIIlIIlI2, uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new IIlllIllIlIllIllIIllIlIIl(uIComponent, lllllIIIIlIlllIllIIIlIIlI2.llIlllIIIllllIIlllIllIIIl());
        this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(lllllIIIIlIlllIllIIIlIIlI2::llIlllIIIllllIIlllIllIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(lllllIIIIlIlllIllIIIlIIlI2::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(lllllIIIIlIlllIllIIIlIIlI2::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(lllllIIIIlIlllIllIIIlIIlI2::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(() -> true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl((String)lllllIIIIlIlllIllIIIlIIlI2.llIlllIIIllllIIlllIllIIIl());
        this.lIlIlIlIlIIlIIlIIllIIIIIl.llIlllIIIllllIIlllIllIIIl((f, f2, n) -> {
            SettingsUIScreen settingsUIScreen;
            CustomScreen customScreen;
            GuiScreenBridge guiScreenBridge = Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen();
            if (guiScreenBridge instanceof WrappedGuiScreenBridge && (customScreen = ((WrappedGuiScreenBridge)guiScreenBridge).getCustomScreen()) instanceof SettingsUIScreen && (settingsUIScreen = (SettingsUIScreen)customScreen).llIIIIIIIllIIllIlIllIIIIl().lIIlIlllIlIlIIIlllIIlIIII() instanceof FeatureSettingsUIComponent) {
                FeatureSettingsUIComponent featureSettingsUIComponent = (FeatureSettingsUIComponent)settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl().lIIlIlllIlIlIIIlllIIlIIII();
                for (AbstractSetting abstractSetting : featureSettingsUIComponent.llllIIlIIlIIlIIllIIlIIllI().lllIIIIIlllIIlIllIIlIIIlI()) {
                    if (!(abstractSetting instanceof lllllIIIIlIlllIllIIIlIIlI) || abstractSetting.f_().equals(lllllIIIIlIlllIllIIIlIIlI2.f_())) continue;
                    ((lllllIIIIlIlllIllIIIlIIlI)abstractSetting).lIlIlIlIlIIlIIlIIllIIIIIl(false);
                }
            }
            return true;
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n));
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            } else if (lllllIIIIlIlllIllIIIlIIlI2.lIlIlIlIlIIlIIlIIllIIIIIl()) {
                lllllIIIIlIlllIllIIIlIIlI2.lIlIlIlIlIIlIIlIIllIIIIIl(false);
            }
            return false;
        });
    }

    @Override
    public float IllIllIIIllIIIlIlIlIIIIll() {
        return ((lllllIIIIlIlllIllIIIlIIlI)this.llIIIIIIIllIIllIlIllIIIIl()).llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0f : 14.0f;
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return false;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(((lllllIIIIlIlllIllIIIlIIlI)this.IlllIIIIIIlllIlIIlllIlIIl).f_(), this.x, this.y + 1.5f, -4079426);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + this.width - 90.0f, this.y + 2.0f, 90.0f, 12.0f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }
}
 