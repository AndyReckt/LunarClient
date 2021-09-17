package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.ConfigCategory;
import com.moonsworth.lunar.client.setting.SettingLabel;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.Debug;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.*;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.BooleanCallbackSetting;
import com.moonsworth.lunar.client.util.LanguageParser;
import org.lwjgl.opengl.GL11;

import java.util.*;

public class lIlIIIIIIlIIIllllIllIIlII
extends AbstractListUIComponent {
    public List<SettingsCategoryUIComponent> lIlIlIlIlIIlIIlIIllIIIIIl;
    public Map<ConfigCategory, List<AbstractDescritiveSettingUIComponent>> IlllIIIIIIlllIlIIlllIlIIl;
    public ConfigCategory lIllIlIIIlIIIIIIIlllIlIll = ConfigCategory.lIlIlIlIlIIlIIlIIllIIIIIl;
    public lllllIllIlIIlIIlIIIlllIlI IIlIllIlllllllIIlIIIllIIl;
    public IIlIllIlIIllIIlIlIllllllI lIIlIlllIlIlIIIlllIIlIIII;
    public Set llIllIlIllIlllIllIIIIllII = new HashSet();
    public boolean IllllllllllIlIIIlllIlllll = true;

    public lIlIIIIIIlIIIllllIllIIlII(UIComponent parent) {
        super(parent);
        this.lIIlIlllIlIlIIIlllIIlIIII = new IIlIllIlIIllIIlIlIllllllI(this);
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            for (UIComponent uIComponent : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) continue;
                return uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            for (UIComponent uIComponent : this.IlllIIIIIIlllIlIIlllIlIIl.get(this.lIllIlIIIlIIIIIIIlllIlIll)) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll())) continue;
                return uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll(), n);
            }
            if (n == 1 && this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl("");
            }
            return this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n) || this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((f, f2, n) -> this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(f, f2, n));
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new ArrayList();
        for (ConfigCategory configCategory : ConfigCategory.values()) {
            SettingsCategoryUIComponent i18nBridge = new SettingsCategoryUIComponent(configCategory, this);
            this.lIlIlIlIlIIlIIlIIllIIIIIl.add(i18nBridge);
            if (configCategory == ConfigCategory.lIlIlIlIlIIlIIlIIllIIIIIl) {
                ((MainUITopBarButtonUIComponent)i18nBridge).lIlIlIlIlIIlIIlIIllIIIIIl(true);
            }
            ((UIComponent)i18nBridge).lIlIlIlIlIIlIIlIIllIIIIIl((arg_0, arg_1, arg_2) -> this.lIlIlIlIlIIlIIlIIllIIIIIl((SettingsCategoryUIComponent)i18nBridge, arg_0, arg_1, arg_2));
        }
        this.IlllIIIIIIlllIlIIlllIlIIl = new HashMap();
        for (Map.Entry<ConfigCategory, ItemSetLoader<?>> entry : this.lIlIIIIIIlIIIllllIllIIlII.lllIIIIIlllIIlIllIIlIIIlI().llIlllIIIllllIIlllIllIIIl().entrySet()) {
            this.IlllIIIIIIlllIlIIlllIlIIl.putIfAbsent(entry.getKey(), new ArrayList<>());
            ItemSetLoader<I18nBridge> itemSetLoader = (ItemSetLoader)entry.getValue();
            for (I18nBridge i18nBridge : itemSetLoader.llIlllIIIllllIIlllIllIIIl()) {
                if (((AbstractSetting)i18nBridge).llIllIlIllIlllIllIIIIllII() != null && ((AbstractSetting)i18nBridge).llIllIlIllIlllIllIIIIllII().getAsBoolean() || Debug.DebugHelper.lIlIlIlIlIIlIIlIIllIIIIIl(i18nBridge, itemSetLoader) && !Ref.llIlllIIIllllIIlllIllIIIl()) continue;
                ((List)this.IlllIIIIIIlllIlIIlllIlIIl.get(entry.getKey())).add(((AbstractSetting)i18nBridge).lIlIlIlIlIIlIIlIIllIIIIIl(this));
            }
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        float f5 = 100.0f;
        float f6 = 14.0f;
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - f5 - 4.0f, f2 + 1.0f, f5, f6);
        float f7 = 0.0f;
        for (SettingsCategoryUIComponent settingsCategoryUIComponent : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            settingsCategoryUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f + f7, f2 + 1.0f);
            f7 += settingsCategoryUIComponent.llIlIIIllIIlIllIllIllllIl() + 4.0f;
        }
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 6.0f, f2 + 20.0f, 4.0f, f4 - 20.0f);
        HashSet hashSet = new HashSet();
        f3 -= 30.0f;
        float f8 = f2 + 27.0f;
        float f9 = 0.0f;
        int n = 0;
        ArrayList<AbstractDescritiveSettingUIComponent> arrayList = new ArrayList<AbstractDescritiveSettingUIComponent>();
        if (!this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI().isEmpty()) {
            String string = this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI();
            for (AbstractDescritiveSettingUIComponent abstractDescritiveSettingUIComponent : this.IlllIIIIIIlllIlIIlllIlIIl.get(this.lIllIlIIIlIIIIIIIlllIlIll)) {
                String[] stringArray;
                if (abstractDescritiveSettingUIComponent instanceof llIlIIIllIIlIllIllIllllIl) continue;
                AbstractSetting abstractSetting = abstractDescritiveSettingUIComponent.llIIIIIIIllIIllIlIllIIIIl();
                if (abstractSetting.f_().toLowerCase().contains(this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI())) {
                    arrayList.add(abstractDescritiveSettingUIComponent);
                    continue;
                }
                for (String string2 : stringArray = abstractSetting.f_().split(" ")) {
                    if (!(string2 = LanguageParser.lIlIlIlIlIIlIIlIIllIIIIIl(string2)).toLowerCase().startsWith(string.toLowerCase())) continue;
                    arrayList.add(abstractDescritiveSettingUIComponent);
                }
            }
        }
        for (Object object : (List)this.IlllIIIIIIlllIlIIlllIlIIl.get(this.lIllIlIIIlIIIIIIIlllIlIll)) {
            float f10;
            if (!this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI().isEmpty() && !arrayList.contains(object)) {
                ((AbstractDescritiveSettingUIComponent)object).lIlIlIlIlIIlIIlIIllIIIIIl(f - f3, f2, f3);
                continue;
            }
            if (object instanceof ColorPickerUIComponent && ((ColorPickerUIComponent)object).llIlllIIIllllIIlllIllIIIl()) {
                hashSet.add(((ColorPickerUIComponent)object).llIIIIIIIllIIllIlIllIIIIl());
            }
            boolean bl = ((AbstractDescritiveSettingUIComponent)object).lIllIlIIIlIIIIIIIlllIlIll();
            boolean bl2 = ((AbstractDescritiveSettingUIComponent)object).llIIIIIIIllIIllIlIllIIIIl() instanceof SettingLabel;
            float f11 = f10 = bl ? f3 / 2.0f : f3;
            if (n == 2) {
                n = 0;
                f8 += f9;
                f9 = 0.0f;
            }
            if (!bl) {
                n = 0;
                f8 += f9;
                f9 = 0.0f;
            }
            if (((AbstractDescritiveSettingUIComponent)object).IllIllIIIllIIIlIlIlIIIIll() > f9) {
                f9 = ((AbstractDescritiveSettingUIComponent)object).IllIllIIIllIIIlIlIlIIIIll();
            }
            ((AbstractDescritiveSettingUIComponent)object).lIlIlIlIlIIlIIlIIllIIIIIl(f + (bl2 ? 0.0f : 15.0f) + (float)n * (f3 / 2.0f), f8, f10);
            if (!bl) {
                f8 += f9;
                f9 = 0.0f;
                continue;
            }
            ++n;
        }
        if (!this.llIllIlIllIlllIllIIIIllII.equals(hashSet) && !this.IllllllllllIlIIIlllIlllll && this.llIllIlIllIlllIllIIIIllII.size() <= hashSet.size()) {
            this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll() - 65.0f);
        }
        this.llIllIlIllIlllIllIIIIllII = hashSet;
        this.IllllllllllIlIIIlllIlllll = false;
        this.lIIlIlllIlIlIIIlllIIlIIII.IlIlIlllllIlIIlIlIlllIlIl(f8 - (f2 + 27.0f) + 6.0f);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    @Override
    public List lIllIlIIIlIIIIIIIlllIlIll() {
        UIComponent[] uIComponentArray = new UIComponent[1];
        this.IIlIllIlllllllIIlIIIllIIl = new lllllIllIlIIlIIlIIIlllIlI(this, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/magnifying-glass-12x12.png"), FontRegistry.llllIIlIIlIIlIIllIIlIIllI, "searchPlaceholder", 0x20FFFFFF, 0x35FFFFFF);
        uIComponentArray[0] = this.IIlIllIlllllllIIlIIIllIIl;
        return Arrays.asList(uIComponentArray);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        boolean bl2;
        boolean bl3;
        Object aaa;
        for (SettingsCategoryUIComponent iterator2 : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            ((UIComponent)((Object)iterator2)).lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glEnable((int)3089);
        float f3 = 0.0f;
        if (this.lllIIIIIlllIIlIllIIlIIIlI.bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge && (aaa = (WrappedGuiScreenBridge)this.lllIIIIIlllIIlIllIIlIIIlI.bridge$getCurrentScreen()).getCustomScreen() instanceof AbstractUIScreen) {
            I18nBridge i18nBridge = (AbstractUIScreen)aaa.getCustomScreen();
            f3 = ((AbstractUIScreen)i18nBridge).lllllIllIlIIlIIlIIIlllIlI();
        }
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x - 2.0f), (int)(this.y + 20.0f), (int)(this.x + this.width + 2.0f), (int)(this.y + this.height + 5.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)f3);
        this.lIIlIlllIlIlIIIlllIIlIIII.IlllIIIIIIlllIlIIlllIlIIl(f, f2, bl);
        for (AbstractDescritiveSettingUIComponent i18nBridge : this.IlllIIIIIIlllIlIIlllIlIIl.get(this.lIllIlIIIlIIIIIIIlllIlIll)) {
            bl3 = ((UIComponent)i18nBridge).lIlIIIIIIlIIIllllIllIIlII() + ((UIComponent)i18nBridge).IllIllIIIllIIIlIlIlIIIIll() + this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll() < this.lIIlIlllIlIlIIIlllIIlIIII.lIlIIIIIIlIIIllllIllIIlII();
            boolean bl4 = bl2 = ((UIComponent)i18nBridge).lIlIIIIIIlIIIllllIllIIlII() + this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll() > this.lIIlIlllIlIlIIIlllIIlIIII.lIlIIIIIIlIIIllllIllIIlII() + this.lIIlIlllIlIlIIIlllIIlIIII.IllIllIIIllIIIlIlIlIIIIll();
            if (!(((UIComponent)i18nBridge).lllIIIIIlllIIlIllIIlIIIlI() >= this.x) || bl3 || bl2) continue;
            ((UIComponent)i18nBridge).lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll(), bl && !this.lIIlIlllIlIlIIIlllIIlIIII.lIIIllIllIIllIlllIlIIlllI());
        }
        this.lIIlIlllIlIlIIIlllIIlIIII.llllIIlIIlIIlIIllIIlIIllI(f, f2, bl);
        GL11.glDisable((int)3089);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        for (AbstractDescritiveSettingUIComponent i18nBridge : this.IlllIIIIIIlllIlIIlllIlIIl.get(this.lIllIlIIIlIIIIIIIlllIlIll)) {
            bl3 = ((UIComponent)i18nBridge).lIlIIIIIIlIIIllllIllIIlII() + ((AbstractDescritiveSettingUIComponent)i18nBridge).IllIllIIIllIIIlIlIlIIIIll() + this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll() < this.lIIlIlllIlIlIIIlllIIlIIII.lIlIIIIIIlIIIllllIllIIlII();
            boolean bl5 = bl2 = ((UIComponent)i18nBridge).lIlIIIIIIlIIIllllIllIIlII() + this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll() > this.lIIlIlllIlIlIIIlllIIlIIII.lIlIIIIIIlIIIllllIllIIlII() + this.lIIlIlllIlIlIIIlllIIlIIII.IllIllIIIllIIIlIlIlIIIIll();
            if (bl3 || bl2) continue;
            if (((AbstractDescritiveSettingUIComponent)i18nBridge).lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll())) {
                ((AbstractDescritiveSettingUIComponent)i18nBridge).lIllIlIIIlIIIIIIIlllIlIll(f, f2);
            }
            if (!(i18nBridge instanceof ClashesWithWarningUIComponent) || !((ClashesWithWarningUIComponent)i18nBridge).llllIIlIIlIIlIIllIIlIIllI().IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.lIIlIlllIlIlIIIlllIIlIIII.lIllIlIIIlIIIIIIIlllIlIll())) continue;
            ((ClashesWithWarningUIComponent)i18nBridge).llIlllIIIllllIIlllIllIIIl(f, f2);
        }
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        super.lIlIlIlIlIIlIIlIIllIIIIIl();
        for (UIComponent uIComponent : this.IlllIIIIIIlllIlIIlllIlIIl.get(this.lIllIlIIIlIIIIIIIlllIlIll)) {
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl();
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        for (UIComponent uIComponent : this.IlllIIIIIIlllIlIIlllIlIIl.get(this.lIllIlIIIlIIIIIIIlllIlIll)) {
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
        }
        if (this.IIlIllIlllllllIIlIIIllIIl.llIllIlIllIlllIllIIIIllII()) {
            if (keyType == KeyType.lIIIlIllllIIlIIlIIlIIIIlI) {
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl("");
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                return;
            }
            this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
        super.IlllIIIIIIlllIlIIlllIlIIl();
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    @Override
    public boolean c_() {
        return super.c_() || ((List)this.IlllIIIIIIlllIlIIlllIlIIl.get(this.lIllIlIIIlIIIIIIIlllIlIll)).stream().anyMatch(abstractDescritiveSettingUIComponent -> abstractDescritiveSettingUIComponent instanceof BooleanCallbackSetting && ((BooleanCallbackSetting)((Object)abstractDescritiveSettingUIComponent)).c_());
    }

    public lllllIllIlIIlIIlIIIlllIlI llllIIlIIlIIlIIllIIlIIllI() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public IIlIllIlIIllIIlIlIllllllI llIIIIIIIllIIllIlIllIIIIl() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(SettingsCategoryUIComponent settingsCategoryUIComponent, float f, float f2, int n) {
        for (SettingsCategoryUIComponent settingsCategoryUIComponent2 : this.lIlIlIlIlIIlIIlIIllIIIIIl) {
            settingsCategoryUIComponent2.lIlIlIlIlIIlIIlIIllIIIIIl(false);
        }
        settingsCategoryUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(true);
        this.lIllIlIIIlIIIIIIIlllIlIll = settingsCategoryUIComponent.lIllIlIIIlIIIIIIIlllIlIll();
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height);
        return true;
    }
}
 