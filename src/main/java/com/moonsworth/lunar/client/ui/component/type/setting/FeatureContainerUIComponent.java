package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.SettingLabel;
import com.moonsworth.lunar.client.ui.component.Debug;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.AbstractEase;
import com.moonsworth.lunar.client.ui.ease.ExponentialEase;
import com.moonsworth.lunar.client.ui.ease.LinearEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FeatureContainerUIComponent extends AbstractDescritiveSettingUIComponent {
    public static final ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl = Bridge.getInstance().initResourceLocation("lunar", "icons/settings/cog-16x16.png");
    public final AbstractFeatureContainerChild llIlIIIllIIlIllIllIllllIl;
    public final AbstractEase IllIllIIIllIIIlIlIlIIIIll;
    public final ExponentialEase ease;
    public boolean lIIlIlllIlIlIIIlllIIlIIII;
    public float llIllIlIllIlllIllIIIIllII;
    public final List<AbstractDescritiveSettingUIComponent> IllllllllllIlIIIlllIlllll = new ArrayList();

    public FeatureContainerUIComponent(AbstractFeatureContainerChild abstractFeatureContainerChild, UIComponent uIComponent) {
        super(abstractFeatureContainerChild.llIIIlllIIlllIllllIlIllIl(), uIComponent);
        this.llIlIIIllIIlIllIllIllllIl = abstractFeatureContainerChild;
        this.ease = new ExponentialEase(100L);
        this.ease.lIllIlIIIlIIIIIIIlllIlIll();
        this.IllIllIIIllIIIlIlIlIIIIll = new LinearEase(abstractFeatureContainerChild == Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIlllIIIIIIIIIIllllIlIIlI() ? 1500L : 4000L);
        this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl();
        for (AbstractSetting abstractSetting : this.llIlIIIllIIlIllIllIllllIl.lllIIIIIlllIIlIllIIlIIIlI()) {
            if (Debug.DebugHelper.lIlIlIlIlIIlIIlIIllIIIIIl(abstractSetting, this.llIlIIIllIIlIllIllIllllIl) && !Ref.isConnectedToWebSocket()) continue;
            this.IllllllllllIlIIIlllIlllll.add(abstractSetting.getUIComponent(this));
        }
        this.onMouseClick((float f, float f2, int n) -> {
            if (f < this.x + 32.0f && f2 < this.y + 20.0f) {
                this.ease.lIllIlIIIlIIIIIIIlllIlIll();
                this.setting.lIlIlIlIlIIlIIlIIllIIIIIl(((BooleanSetting)this.setting).llIlllIIIllllIIlllIllIIIl() == false);
            } else if (f2 < this.y + 20.0f) {
                this.lIIlIlllIlIlIIIlllIIlIIII = !this.lIIlIlllIlIlIIIlllIIlIIII;
            } else {
                for (AbstractDescritiveSettingUIComponent abstractDescritiveSettingUIComponent : this.IllllllllllIlIIIlllIlllll) {
                    if (!abstractDescritiveSettingUIComponent.mouseInside(f, f2)) continue;
                    return abstractDescritiveSettingUIComponent.onMouseClicked(f, f2, n);
                }
            }
            return true;
        });
    }

    @Override
    public void resoze(float f, float f2, float f3) {
        super.setPositionAndSize(f, f2, f3, this.getHeight());
        Set<AbstractSetting> hashSet = new HashSet<>();
        Set<AbstractSetting> hashSet2 = new HashSet<>();
        f3 -= 30.0f;
        float f4 = 0.0f;
        int n = 0;
        float f5 = f2 + 18.0f;
        for (AbstractDescritiveSettingUIComponent abstractDescritiveSettingUIComponent : this.IllllllllllIlIIIlllIlllll) {
            float f6;
            if (abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII() != null && abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean()) {
                hashSet.add(abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl());
                continue;
            }
            if (abstractDescritiveSettingUIComponent instanceof ColorPickerUIComponent && ((ColorPickerUIComponent)abstractDescritiveSettingUIComponent).llIlllIIIllllIIlllIllIIIl()) {
                hashSet2.add(abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl());
            }
            boolean bl = abstractDescritiveSettingUIComponent.lIllIlIIIlIIIIIIIlllIlIll();
            boolean bl2 = abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl() instanceof SettingLabel;
            float f7 = f6 = bl ? f3 / 2.0f : f3;
            if (n == 2) {
                n = 0;
                f5 += f4;
                f4 = 0.0f;
            }
            if (!bl) {
                n = 0;
                f5 += f4;
                f4 = 0.0f;
            }
            if (abstractDescritiveSettingUIComponent.getHeight() > f4) {
                f4 = abstractDescritiveSettingUIComponent.getHeight();
            }
            abstractDescritiveSettingUIComponent.resoze(f + 4.0f + (float)n * (f3 / 2.0f), f5 + 4.0f, f6);
            if (!bl) {
                f5 += f4;
                f4 = 0.0f;
                continue;
            }
            if (this.IllllllllllIlIIIlllIlllll.get(this.IllllllllllIlIIIlllIlllll.size() - 1) == abstractDescritiveSettingUIComponent) {
                f5 += f4;
            }
            ++n;
        }
        this.llIllIlIllIlllIllIIIIllII = f5 - this.y - 10.0f;
    }

    @Override
    public float getHeight() {
        return this.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean() ? 0.0f : (this.lIIlIlllIlIlIIIlllIIlIIII ? 22.0f + this.llIllIlIllIlllIllIIIIllII : 18.0f);
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return !this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {

        boolean bl2;
        float f3 = 34.0f;
        if (this.llIlIIIllIIlIllIllIllllIl.llIIIlIllIIIIlIIIlIlIllIl() != null) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.4f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl.llIIIlIllIIIIlIIIlIlIllIl(), this.x + f3, this.y + 5.0f, 10.0f, 10.0f);
            f3 += 12.0f;
        }
        FontRegistry.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl.getDetails().get("name"), this.x + f3, this.y + 4.5f, -4079426);
        float f4 = 0.0f;
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x + f4, this.y + 5.0f, 30.0f, 10.0f, 5.0f, bl && this.mouseInside(mouseX, mouseY) && mouseY < this.y + 20.0f && mouseX < this.x + 34.0f ? 1088611042 : 0x20E2E2E2, true, true, true, true);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + f4 + 1.0f, this.y + 6.0f, 28.0f, 8.0f, 2.5f, 0x35FFFFFF, true, true, true, true);
        boolean bl3 = ((BooleanSetting)this.setting).llIlllIIIllllIIlllIllIIIl();
        float f5 = 10.0f;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
        float f6 = bl3 ? this.ease.getProgress() : 1.0f - this.ease.getProgress();
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x + f4 + f5 * f6, this.y + 5.0f, 20.0f, 10.0f, 5.0f, bl3 ? -1356212614 : -1344396974, true, true, true, true);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + f4 + 1.0f + f5 * f6, this.y + 6.0f, 18.0f, 8.0f, 2.5f, 0x35FFFFFF, true, true, true, true);
        FontRegistry.lIlIIIIIIlIIIllllIllIIlII().IlllIIIIIIlllIlIIlllIlIIl(((BooleanSetting)this.setting).llIlllIIIllllIIlllIllIIIl() != false ? "ON" : "OFF", this.x + f4 + f5 * f6 + 10.0f, this.y + 6.0f, -1);
        boolean bl4 = bl2 = bl && this.mouseInside(mouseX, mouseY) && mouseY < this.y + 20.0f && mouseX > this.x + 34.0f;
        if (bl2 && !this.IllIllIIIllIIIlIlIlIIIIll.lIIIllIllIIllIlllIlIIlllI()) {
            this.IllIllIIIllIIIlIlIlIIIIll.lIllIlIIIlIIIIIIIlllIlIll();
        } else if (!bl2 && this.IllIllIIIllIIIlIlIlIIIIll.lIIIllIllIIllIlllIlIIlllI()) {
            this.IllIllIIIllIIIlIlIlIIIIll.llIIIIIIIllIIllIlIllIIIIl();
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(this.x + this.width - 11.0f, this.y + 10.0f, 1.0f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(360.0f * this.IllIllIIIllIIIlIlIlIIIIll.getProgress(), 0.0f, 0.0f, 1.0f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, bl2 ? 1.0f : 0.6f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(lIlIlIlIlIIlIIlIIllIIIIIl, -4.0f, -4.0f, 8.0f, 8.0f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        if (this.lIIlIlllIlIlIIIlllIIlIIII) {
            AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x, this.y + 19.0f, this.width - 2.0f, this.llIllIlIllIlllIllIIIIllII, 6.0f, 0x20B0B0B0);
            for (AbstractDescritiveSettingUIComponent abstractDescritiveSettingUIComponent : this.IllllllllllIlIIIlllIlllll) {
                abstractDescritiveSettingUIComponent.drawComponent(mouseX, mouseY, abstractDescritiveSettingUIComponent.mouseInside(mouseX, mouseY));
                if (!abstractDescritiveSettingUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(mouseX, mouseY)) continue;
                abstractDescritiveSettingUIComponent.lIllIlIIIlIIIIIIIlllIlIll(mouseX, mouseY);
            }
        }
    }

    @Override
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        return super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2) && f2 < this.y + 20.0f;
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll(float f, float f2) {
        String string = this.llIlIIIllIIlIllIllIllllIl.getDetails().get("description");
        if (string != null && !string.equals("description") && !string.equals("")) {
            List<String> list = FontRegistry.lIlIIIIIIlIIIllllIllIIlII().lIllIlIIIlIIIIIIIlllIlIll(string, 150.0);
            float f3 = list.size() > 1 ? 150.0f : (float)FontRegistry.lIIIllIllIIllIlllIlIIlllI().IlllIIIIIIlllIlIIlllIlIIl(string);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f + 8.0f, f2 + 6.0f, f3 + 10.0f, (float)(8 * list.size() + 5), 4.0f, -1879048192);
            int n = 0;
            for (String string2 : list) {
                FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(string2, f + 12.5f, f2 + 9.0f + (float)(n * 8), -1);
                ++n;
            }
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }

    public AbstractFeatureContainerChild llIlllIIIllllIIlllIllIIIl() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.lIIlIlllIlIlIIIlllIIlIIII = bl;
    }
}
