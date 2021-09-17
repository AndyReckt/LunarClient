package com.moonsworth.lunar.client.registry;

import com.google.common.collect.ImmutableMap;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.json.file.DefaultJson;
import com.moonsworth.lunar.client.json.file.ItemMapLoader;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.profile.main.ControlsMenu;
import com.moonsworth.lunar.client.profile.main.GeneralOptions;
import com.moonsworth.lunar.client.profile.main.PerformanceConfig;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.ConfigCategory;

import java.util.Map;

public class SettingsLoader
extends ItemMapLoader<ConfigCategory, ItemSetLoader<?>> {
    public GeneralOptions lIlIlIlIlIIlIIlIIllIIIIIl;
    public PerformanceConfig IlllIIIIIIlllIlIIlllIlIIl;
    public ControlsMenu lIllIlIIIlIIIIIIIlllIlIll;

    @Override
    public Map<ConfigCategory, ItemSetLoader<?>> lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new GeneralOptions();
        this.IlllIIIIIIlllIlIIlllIlIIl = new PerformanceConfig();
        this.lIllIlIIIlIIIIIIIlllIlIll = new ControlsMenu();
        return ImmutableMap.of(ConfigCategory.lIlIlIlIlIIlIIlIIllIIIIIl, this.lIlIlIlIlIIlIIlIIllIIIIIl, ConfigCategory.IlllIIIIIIlllIlIIlllIlIIl, this.IlllIIIIIIlllIlIIlllIlIIl, ConfigCategory.lIllIlIIIlIIIIIIIlllIlIll, this.lIllIlIIIlIIIIIIIlllIlIll);
    }

    @Override
    public void b_() {
        for (ItemSetLoader itemSetLoader : this.llIlllIIIllllIIlllIllIIIl().values()) {
            itemSetLoader.b_();
            if (!(itemSetLoader instanceof DefaultJson)) continue;
            ((DefaultJson)((Object)itemSetLoader)).load();
        }
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        for (ItemSetLoader itemSetLoader : this.llIlllIIIllllIIlllIllIIIl().values()) {
            itemSetLoader.lIllIlIIIlIIIIIIIlllIlIll();
            if (!(itemSetLoader instanceof DefaultJson)) continue;
            ((DefaultJson)((Object)itemSetLoader)).save();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractSetting abstractSetting) {
        for (Object object : this.llIlllIIIllllIIlllIllIIIl().values()) {
            if (!((ItemSetLoader)object).llIlllIIIllllIIlllIllIIIl().contains(abstractSetting) || !(object instanceof DefaultJson)) continue;
            ((DefaultJson)object).save();
            return;
        }
        for (Feature object : Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl()) {
            if (!((Feature)object).lllIIIIIlllIIlIllIIlIIIlI().contains(abstractSetting)) continue;
            Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().save();
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
 