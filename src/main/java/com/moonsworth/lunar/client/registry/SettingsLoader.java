package com.moonsworth.lunar.client.registry;

import com.google.common.collect.ImmutableMap;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.json.file.JsonFile;
import com.moonsworth.lunar.client.json.file.ItemMapLoader;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.profile.main.ControlsMenu;
import com.moonsworth.lunar.client.profile.main.GeneralOptions;
import com.moonsworth.lunar.client.profile.main.PerformanceConfig;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.ConfigCategory;

import java.util.Map;

public class SettingsLoader extends ItemMapLoader<ConfigCategory, ItemSetLoader<? extends I18nBridge>> {
    public GeneralOptions lIlIlIlIlIIlIIlIIllIIIIIl;
    public PerformanceConfig IlllIIIIIIlllIlIIlllIlIIl;
    public ControlsMenu lIllIlIIIlIIIIIIIlllIlIll;

    @Override
    public Map<ConfigCategory, ItemSetLoader<? extends I18nBridge>> lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new GeneralOptions();
        this.IlllIIIIIIlllIlIIlllIlIIl = new PerformanceConfig();
        this.lIllIlIIIlIIIIIIIlllIlIll = new ControlsMenu();
        return ImmutableMap.of(ConfigCategory.GENERAL, this.lIlIlIlIlIIlIIlIIllIIIIIl, ConfigCategory.PERFORMANCE, this.IlllIIIIIIlllIlIIlllIlIIl, ConfigCategory.CONTROLS, this.lIllIlIIIlIIIIIIIlllIlIll);
    }

    @Override
    public void b_() {
        for (ItemSetLoader<?> itemSetLoader : this.llIlllIIIllllIIlllIllIIIl().values()) {
            itemSetLoader.b_();
            if (!(itemSetLoader instanceof JsonFile)) continue;
            ((JsonFile)(itemSetLoader)).load();
        }
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        for (ItemSetLoader<?> itemSetLoader : this.llIlllIIIllllIIlllIllIIIl().values()) {
            itemSetLoader.lIllIlIIIlIIIIIIIlllIlIll();
            if (!(itemSetLoader instanceof JsonFile)) continue;
            ((JsonFile) itemSetLoader).save();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractSetting<?> abstractSetting) {
        for (ItemSetLoader<?> object : this.llIlllIIIllllIIlllIllIIIl().values()) {
            if (!object.llIlllIIIllllIIlllIllIIIl().contains(abstractSetting) || !(object instanceof JsonFile)) continue;
            ((JsonFile)object).save();
            return;
        }
        for (Feature object : Ref.getLC().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl()) {
            if (!object.lllIIIIIlllIIlIllIIlIIIlI().contains(abstractSetting)) continue;
            Ref.getLC().lllllIllIllIllllIlIllllII().save();
            return;
        }
    }

    public GeneralOptions llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public PerformanceConfig IlIlIlllllIlIIlIlIlllIlIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public ControlsMenu llIIIIIIIllIIllIlIllIIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }
}
