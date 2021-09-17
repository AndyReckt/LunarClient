package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.HKTextSetting;
import com.moonsworth.lunar.client.setting.SettingLabel;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.Debug;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.overlay.ClientSettingsParentUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.*;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import org.lwjgl.opengl.GL11;

import java.util.*;

public class FeatureSettingsUIComponent
extends AbstractListUIComponent<AbstractDescritiveSettingUIComponent> {
    public final Feature lIlIlIlIlIIlIIlIIllIIIIIl;
    public final String IlllIIIIIIlllIlIIlllIlIIl;
    public final ResourceLocationBridge lIllIlIIIlIIIIIIIlllIlIll;
    public lIlIlIIIIIIllIlIIIIllIIII IIlIllIlllllllIIlIIIllIIl;
    public lIlIlIIIIIIllIlIIIIllIIII lIIlIlllIlIlIIIlllIIlIIII;
    public com.moonsworth.lunar.client.ui.component.type.setting.IIlIllIlIIllIIlIlIllllllI llIllIlIllIlllIllIIIIllII;
    public UIComponent IllllllllllIlIIIlllIlllll = null;
    public boolean lllllIllIlIIlIIlIIIlllIlI;
    public boolean IllIIIlllIIIlIlllIlIIlIII = true;
    public Set<AbstractSetting<?>> IIlIllIlIIllIIlIlIllllllI = new HashSet<>();
    public Set lIIIlllIIIIllllIlIIIlIIll = new HashSet();

    public FeatureSettingsUIComponent(ClientSettingsParentUIComponent clientSettingsParentUIComponent, Feature feature) {
        super(clientSettingsParentUIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = feature;
        this.IlllIIIIIIlllIlIIlllIlIIl = feature.llIIlIlIIIllIlIlIlIIlIIll().get("name", new Object[0]).toUpperCase().replace("", " ").trim();
        this.lIllIlIIIlIIIIIIIlllIlIll = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/settings/arrow-left-32x32.png");
        this.llIllIlIllIlllIllIIIIllII = new IIlIllIlIIllIIlIlIllllllI(this);
        this.lllllIllIlIIlIIlIIIlllIlI = feature instanceof DraggableHudMod || feature instanceof ConfigurableFeature && !((ConfigurableFeature)feature).llIIIllllIIIllIIIIlIlIlll().isEmpty();
        this.IIlIllIlllllllIIlIIIllIIl = new lIlIlIIIIIIllIlIIIIllIIII(this, "resetToDefaults");
        if (this.lllllIllIlIIlIIlIIIlllIlI) {
            this.lIIlIlllIlIlIIIlllIIlIIII = new lIlIlIIIIIIllIlIIIIllIIII(this, "resetPosition");
            this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
                if (feature instanceof DraggableHudMod) {
                    ((DraggableHudMod)feature).lIlIlIlIlIIlIIlIIllIIIIIl(((DraggableHudMod)feature).IIllIlIllIlIllIllIllIllII());
                    ((DraggableHudMod)feature).lIlIlIIIIIIllIlIIIIllIIII();
                }
                if (feature instanceof ConfigurableFeature) {
                    for (AbstractFeatureContainerChild abstractFeatureContainerChild : ((ConfigurableFeature)feature).llIIIllllIIIllIIIIlIlIlll()) {
                        abstractFeatureContainerChild.lIlIlIlIlIIlIIlIIllIIIIIl(abstractFeatureContainerChild.IIllIlIllIlIllIllIllIllII());
                        abstractFeatureContainerChild.lIlIlIIIIIIllIlIIIIllIIII();
                    }
                }
                WrappedGuiScreenBridge wrappedGuiScreenBridge = (WrappedGuiScreenBridge)Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen();
                wrappedGuiScreenBridge.getCustomScreen().llllIIlIIlIIlIIllIIlIIllI();
                return true;
            });
        }
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            for (I18nBridge i18nBridge : feature.lllIIIIIlllIIlIllIIlIIIlI()) {
                ((AbstractSetting)i18nBridge).d_();
            }
            if (feature instanceof ConfigurableFeature && ((ConfigurableFeature)feature).llIIIllllIIIllIIIIlIlIlll() != null) {
                for (I18nBridge i18nBridge : ((ConfigurableFeature)feature).llIIIllllIIIllIIIIlIlIlll()) {
                    ((Feature)i18nBridge).llIIIlllIIlllIllllIlIllIl().d_();
                    for (AbstractSetting abstractSetting : ((Feature)i18nBridge).lllIIIIIlllIIlIllIIlIIIlI()) {
                        abstractSetting.d_();
                    }
                }
            }
            WrappedGuiScreenBridge wrappedGuiScreenBridge = (WrappedGuiScreenBridge) Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen();
            wrappedGuiScreenBridge.getCustomScreen().llllIIlIIlIIlIIllIIlIIllI();
            return true;
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            if (this.lllllIllIlIIlIIlIIIlllIlI && this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            if (this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && f2 >= this.y + 3.0f && f2 < this.y + 21.0f && f >= 4.0f && f <= f + 25.0f) {
                clientSettingsParentUIComponent.llIIIIIIIllIIllIlIllIIIIl().IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl("");
                clientSettingsParentUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(clientSettingsParentUIComponent.llIIIIIIIllIIllIlIllIIIIl());
                clientSettingsParentUIComponent.IlllIIIIIIlllIlIIlllIlIIl(0);
                return true;
            }
            for (AbstractDescritiveSettingUIComponent abstractDescritiveSettingUIComponent : this.llIlIIIllIIlIllIllIllllIl) {
                if (abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII() == null || abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean() || !abstractDescritiveSettingUIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll())) continue;
                return abstractDescritiveSettingUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll(), n);
            }
            if (this.llIllIlIllIlllIllIIIIllII.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            return false;
        });
        if (feature instanceof ConfigurableFeature && !((ConfigurableFeature)feature).llIIIllllIIIllIIIIlIlIlll().isEmpty()) {
            for (I18nBridge i18nBridge : ((ConfigurableFeature)feature).llIIIllllIIIllIIIIlIlIlll()) {
                this.llIlIIIllIIlIllIllIllllIl.add(new FeatureContainerUIComponent((AbstractFeatureContainerChild)i18nBridge, (UIComponent)this));
            }
        }
        for (I18nBridge i18nBridge : feature.lllIIIIIlllIIlIllIIlIIIlI()) {
            if (Debug.DebugHelper.lIlIlIlIlIIlIIlIIllIIIIIl(i18nBridge, feature) && !Ref.llIlllIIIllllIIlllIllIIIl()) continue;
            this.llIlIIIllIIlIllIllIllllIl.add(((AbstractSetting)i18nBridge).lIlIlIlIlIIlIIlIIllIIIIIl(this));
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(true);
    }

    @Override
    public List lIllIlIIIlIIIIIIIlllIlIll() {
        return new ArrayList();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        Collection<AbstractSetting> collection;
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        float f5 = f2 + 27.0f;
        float f6 = 0.0f;
        String string = this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIlIlIIIllIlIlIlIIlIIll().get("description", new Object[0]);
        if (!string.equalsIgnoreCase("") && !string.equals("description")) {
            boolean bl;
            List<String> strings = FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIllIlIIIlIIIIIIIlllIlIll(string, f3 - 12.0f);
            f6 += (float)strings.size() * 8.0f + 8.0f;
            boolean bl2 = bl = this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIlIlIIIllIlIlIlIIlIIll().llllIIlIIlIIlIIllIIlIIllI() != null && !this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIlIlIIIllIlIlIlIIlIIll().llllIIlIIlIIlIIllIIlIIllI().isEmpty();
            if (bl) {
                String string2 = this.get("originalAuthors", new Object[0]) + String.join((CharSequence)", ", this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIlIlIIIllIlIlIlIIlIIll().llllIIlIIlIIlIIllIIlIIllI());
                List list = FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIllIlIIIlIIIIIIIlllIlIll(string2, f3 - 12.0f);
                f6 += (float)list.size() * 8.0f + 4.0f;
            }
        }
        this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 6.0f, f5 += f6, 4.0f, f4 - 40.0f - f6);
        Set<AbstractSetting<?>> set = new HashSet();
        HashSet<AbstractSetting> hashSet = new HashSet<AbstractSetting>();
        f3 -= 30.0f;
        float f7 = 0.0f;
        int n = 0;
        float f8 = f5;
        for (I18nBridge i18nBridge : this.llIlIIIllIIlIllIllIllllIl) {
            float f9;
            if (((AbstractDescritiveSettingUIComponent)i18nBridge).llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII() != null && ((AbstractDescritiveSettingUIComponent)i18nBridge).llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean()) {
                set.add(((AbstractDescritiveSettingUIComponent)i18nBridge).llIIIIIIIllIIllIlIllIIIIl());
                continue;
            }
            if (i18nBridge instanceof ColorPickerUIComponent && ((ColorPickerUIComponent)i18nBridge).llIlllIIIllllIIlllIllIIIl()) {
                hashSet.add(((ColorPickerUIComponent)i18nBridge).llIIIIIIIllIIllIlIllIIIIl());
            }
            boolean bl = ((AbstractDescritiveSettingUIComponent)i18nBridge).lIllIlIIIlIIIIIIIlllIlIll();
            boolean bl3 = ((AbstractDescritiveSettingUIComponent)i18nBridge).llIIIIIIIllIIllIlIllIIIIl() instanceof SettingLabel;
            float f10 = f9 = bl ? f3 / 2.0f : f3;
            if (n == 2) {
                n = 0;
                f8 += f7;
                f7 = 0.0f;
            }
            if (!bl) {
                n = 0;
                f8 += f7;
                f7 = 0.0f;
            }
            if (((AbstractDescritiveSettingUIComponent)i18nBridge).IllIllIIIllIIIlIlIlIIIIll() > f7) {
                f7 = ((AbstractDescritiveSettingUIComponent)i18nBridge).IllIllIIIllIIIlIlIlIIIIll();
            }
            ((AbstractDescritiveSettingUIComponent)i18nBridge).lIlIlIlIlIIlIIlIIllIIIIIl(f + (bl3 ? 0.0f : 15.0f) + (float)n * (f3 / 2.0f), f8, f9);
            if (!bl) {
                f8 += f7;
                f7 = 0.0f;
                continue;
            }
            if (this.llIlIIIllIIlIllIllIllllIl.get(this.llIlIIIllIIlIllIllIllllIl.size() - 1) == i18nBridge) {
                f8 += f7;
            }
            ++n;
        }
        if (!set.equals(this.IIlIllIlIIllIIlIlIllllllI) && !this.IllIIIlllIIIlIlllIlIIlIII) {
            this.llIlIIIllIIlIllIllIllllIl.removeIf(abstractDescritiveSettingUIComponent -> abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl().llIllIlIllIlllIllIIIIllII().getAsBoolean());
            this.IIlIllIlIIllIIlIlIllllllI.removeAll(set);
            for (I18nBridge i18nBridge : this.IIlIllIlIIllIIlIlIllllllI) {
                this.llIlIIIllIIlIllIllIllllIl.add(((AbstractSetting)i18nBridge).lIlIlIlIlIIlIIlIIllIIIIIl(this));
            }
            this.llIlIIIllIIlIllIllIllllIl.sort(Comparator.comparingInt(abstractDescritiveSettingUIComponent -> this.lIlIlIlIlIIlIIlIIllIIIIIl.lllIIIIIlllIIlIllIIlIIIlI().indexOf(abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl())));
        }
        if (!this.lIIIlllIIIIllllIlIIIlIIll.equals(hashSet) && !this.IllIIIlllIIIlIlllIlIIlIII && this.lIIIlllIIIIllllIlIIIlIIll.size() <= hashSet.size()) {
            this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll() - 65.0f);
        }
        this.lIIIlllIIIIllllIlIIIlIIll = hashSet;
        if (!this.IllIIIlllIIIlIlllIlIIlIII) {
            this.IIlIllIlIIllIIlIlIllllllI = set;
        }
        this.IllIIIlllIIIlIlllIlIIlIII = false;
        this.llIllIlIllIlllIllIIIIllII.IlIlIlllllIlIIlIlIlllIlIl(f8 - f5 + 4.0f);
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 50.0f, f2 + 4.0f, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll()) + 8, 16.0f);
        if (this.lllllIllIlIIlIIlIIIlllIlI) {
            this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - (float)(FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll()) + 8 + FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll())), f2 + 4.0f, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll()) + 8, 16.0f);
        }
        if (this.IllllllllllIlIIIlllIlllll != null) {
            this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(-(this.IllllllllllIlIIIlllIlllll.lIlIIIIIIlIIIllllIllIIlII() - f5));
            this.IllllllllllIlIIIlllIlllll = null;
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        super.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        WrappedGuiScreenBridge wrappedGuiScreenBridge;
        int n;
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y, this.width, 25.0f, 8.0f, 0x35000000, true, true, false, false);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + 25.0f, this.width, this.height - 25.0f, 12.0f, 0x20000000, false, false, true, true);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 24.0f, this.width, 1.0f, 0x20FFFFFF);
        FontRegistry.lllllIllIllIllllIlIllllII().lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl, this.x + 30.0f, this.y + 7.0f, -1);
        float f3 = 0.0f;
        String string = this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIlIlIIIllIlIlIlIIlIIll().get("description", new Object[0]);
        if (!string.equals("") && !string.equals("description")) {
            List<String> strings = FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIllIlIIIlIIIIIIIlllIlIll(string, this.width - 12.0f);
            int n2 = 0;
            for (String string2 : strings) {
                FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(string2, this.x + 6.0f, this.y + 28.0f + (float)n2 * 8.0f + 0.5f, -1);
                ++n2;
            }
            f3 += (float)n2 * 8.0f + 8.0f;
            boolean bl2 = this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIlIlIIIllIlIlIlIIlIIll().llllIIlIIlIIlIIllIIlIIllI() != null && !this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIlIlIIIllIlIlIlIIlIIll().llllIIlIIlIIlIIllIIlIIllI().isEmpty();
            n = 0;
            if (bl2) {
                String string3 = this.get("originalAuthors", new Object[0]) + String.join((CharSequence)", ", this.lIlIlIlIlIIlIIlIIllIIIIIl.llIIlIlIIIllIlIlIlIIlIIll().llllIIlIIlIIlIIllIIlIIllI());
                List<String> list2 = FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIllIlIIIlIIIIIIIlllIlIll(string3, this.width - 12.0f);
                for (String string4 : list2) {
                    FontRegistry.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl(string4, this.x + 6.0f, this.y + 24.0f + f3 + (float)n * 8.0f + 0.5f, -1);
                    ++n;
                }
                f3 += (float)n * 8.0f + 4.0f;
            }
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 24.0f + (bl2 ? 2.0f : 0.0f), this.width, f3, 0x15000000);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 25.0f + (bl2 ? 3.0f : 0.0f) + (float)n2 * 8.0f + (float)n * 8.0f + 8.0f, this.width, 1.0f, 0x20FFFFFF);
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll, 8.0f, this.x + 7.0f, this.y + 4.0f);
        if (this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && f2 > this.y + 3.0f && f2 < this.y + 21.0f && f >= this.x + 4.0f && f <= this.x + 25.0f) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll, 8.0f, this.x + 7.0f, this.y + 4.0f);
        }
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        if (this.lllllIllIlIIlIIlIIIlllIlI) {
            this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable((int)3089);
        float f4 = 0.0f;
        if (this.lllIIIIIlllIIlIllIIlIIIlI.bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge && (wrappedGuiScreenBridge = (WrappedGuiScreenBridge)this.lllIIIIIlllIIlIllIIlIIIlI.bridge$getCurrentScreen()).getCustomScreen() instanceof AbstractUIScreen) {
            AbstractUIScreen abstractUIScreen = (AbstractUIScreen)wrappedGuiScreenBridge.getCustomScreen();
            f4 = abstractUIScreen.lllllIllIlIIlIIlIIIlllIlI();
        }
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)this.x, (int)(this.y + 26.0f + f3), (int)(this.x + this.width), (int)(this.y + this.height), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)f4);
        this.llIllIlIllIlllIllIIIIllII.IlllIIIIIIlllIlIIlllIlIIl(f, f2, bl);
        for (UIComponent uIComponent : this.llIlIIIllIIlIllIllIllllIl) {
            boolean bl3;
            n = uIComponent.lIlIIIIIIlIIIllllIllIIlII() + uIComponent.IllIllIIIllIIIlIlIlIIIIll() + this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll() < this.llIllIlIllIlllIllIIIIllII.lIlIIIIIIlIIIllllIllIIlII() ? 1 : 0;
            boolean bl4 = bl3 = uIComponent.lIlIIIIIIlIIIllllIllIIlII() + this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll() > this.llIllIlIllIlllIllIIIIllII.lIlIIIIIIlIIIllllIllIIlII() + this.llIllIlIllIlllIllIIIIllII.IllIllIIIllIIIlIlIlIIIIll();
            if (n != 0 || bl3) continue;
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll(), bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f, f2, new UIComponent[0]));
        }
        if (this.IllIllIIIllIIIlIlIlIIIIll != null) {
            this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll(), bl && this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllIllIIIllIIIlIlIlIIIIll, f, f2, new UIComponent[0]));
        }
        this.llIllIlIllIlllIllIIIIllII.llllIIlIIlIIlIIllIIlIIllI(f, f2, bl);
        GL11.glDisable((int)3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        for (AbstractDescritiveSettingUIComponent abstractDescritiveSettingUIComponent : this.llIlIIIllIIlIllIllIllllIl) {
            boolean bl5;
            n = abstractDescritiveSettingUIComponent.lIlIIIIIIlIIIllllIllIIlII() + abstractDescritiveSettingUIComponent.IllIllIIIllIIIlIlIlIIIIll() + this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll() < this.llIllIlIllIlllIllIIIIllII.lIlIIIIIIlIIIllllIllIIlII() ? 1 : 0;
            boolean bl6 = bl5 = abstractDescritiveSettingUIComponent.lIlIIIIIIlIIIllllIllIIlII() + this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll() > this.llIllIlIllIlllIllIIIIllII.lIlIIIIIIlIIIllllIllIIlII() + this.llIllIlIllIlllIllIIIIllII.IllIllIIIllIIIlIlIlIIIIll();
            if (n != 0 || bl5) continue;
            if (abstractDescritiveSettingUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll())) {
                abstractDescritiveSettingUIComponent.lIllIlIIIlIIIIIIIlllIlIll(f, f2);
            }
            if (abstractDescritiveSettingUIComponent instanceof ClashesWithWarningUIComponent && ((ClashesWithWarningUIComponent)abstractDescritiveSettingUIComponent).llllIIlIIlIIlIIllIIlIIllI().IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll())) {
                ((ClashesWithWarningUIComponent)abstractDescritiveSettingUIComponent).llIlllIIIllllIIlllIllIIIl(f, f2);
            }
            if (!(abstractDescritiveSettingUIComponent instanceof HKTextSettingUIComponent) || !((HKTextSettingUIComponent)abstractDescritiveSettingUIComponent).llllIIlIIlIIlIIllIIlIIllI().IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll())) continue;
            ((HKTextSettingUIComponent)abstractDescritiveSettingUIComponent).llIlllIIIllllIIlllIllIIIl(f, f2);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
        if (keyType == KeyType.IllllIIllllIllIIIIlllllII || keyType == KeyType.IIllllIIlllIlIIlIIlllIlII) {
            if (this.llIlIIIllIIlIllIllIllllIl.stream().anyMatch(abstractDescritiveSettingUIComponent -> abstractDescritiveSettingUIComponent instanceof HKTextSettingUIComponent && ((HKTextSetting)((HKTextSettingUIComponent)abstractDescritiveSettingUIComponent).llIIIIIIIllIIllIlIllIIIIl()).IlllIIIIIIlllIlIIlllIlIIl() || abstractDescritiveSettingUIComponent instanceof IlIIlIIlIIlIIllIIIllIIllI && ((lllllIIIIlIlllIllIIIlIIlI)((IlIIlIIlIIlIIllIIIllIIllI)abstractDescritiveSettingUIComponent).llIIIIIIIllIIllIlIllIIIIl()).lIlIlIlIlIIlIIlIIllIIIIIl())) {
                return;
            }
            ((ClientSettingsParentUIComponent)this.lIIIllIllIIllIlllIlIIlllI).llIIIIIIIllIIllIlIllIIIIl().IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl("");
            ((ClientSettingsParentUIComponent)this.lIIIllIllIIllIlllIlIIlllI).lIlIlIlIlIIlIIlIIllIIIIIl(((ClientSettingsParentUIComponent)this.lIIIllIllIIllIlllIlIIlllI).llIIIIIIIllIIllIlIllIIIIl());
            ((ClientSettingsParentUIComponent)this.lIIIllIllIIllIlllIlIIlllI).IlllIIIIIIlllIlIIlllIlIIl(0);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    public Feature llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public IIlIllIlIIllIIlIlIllllllI llIIIIIIIllIIllIlIllIIIIl() {
        return this.llIllIlIllIlllIllIIIIllII;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent) {
        this.IllllllllllIlIIIlllIlllll = uIComponent;
    }
}
 