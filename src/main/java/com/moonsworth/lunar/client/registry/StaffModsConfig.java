package com.moonsworth.lunar.client.registry;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.json.file.DefaultJson;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;

import java.io.File;
import java.util.Set;

public class StaffModsConfig
extends ItemSetLoader<ConfigurableFeature>
implements DefaultJson {
    public XrayMod lIlIlIlIlIIlIIlIIllIIIIIl;

    @Override
    public Set lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new XrayMod();
        return ImmutableSet.of(this.lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    @Override
    public void b_() {
        super.b_();
        for (ConfigurableFeature configurableFeature : this.llIlllIIIllllIIlllIllIIIl()) {
            if (!configurableFeature.lIlIIIIIIlIIIllllIllIIlII()) continue;
            configurableFeature.lIllIlIIIlIIIIIIIlllIlIll();
        }
        this.load();
    }

    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "staff_mods.json";
    }

    @Override
    public File IlIlIlllllIlIIlIlIlllIlIl() {
        return new File(LunarClient.IIllIlIllIlIllIllIllIllII().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + Ref.IlllIIIIIIlllIlIIlllIlIIl().lIlIlIIIIIIllIlIIIIllIIII().llllIIlIIlIIlIIllIIlIIllI().IlllIIIIIIlllIlIIlllIlIIl(), this.llllIIlIIlIIlIIllIIlIIllI());
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        for (ConfigurableFeature configurableFeature : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                configurableFeature.IlllIIIIIIlllIlIIlllIlIIl(jsonObject.getAsJsonObject(configurableFeature.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl()));
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        for (ConfigurableFeature configurableFeature : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject.add(configurableFeature.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(), (JsonElement)jsonObject2);
                configurableFeature.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.save();
    }

    public XrayMod IlllllIlIIIlIIlIIllIIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
 