package com.moonsworth.lunar.client.registry;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.staff.AbstractStaffMod;
import com.moonsworth.lunar.client.feature.staff.type.XrayMod;
import com.moonsworth.lunar.client.json.file.JsonFile;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.ref.Ref;

import java.io.File;
import java.util.Set;

public class StaffModsConfig extends ItemSetLoader<AbstractStaffMod> implements JsonFile {
    public XrayMod lIlIlIlIlIIlIIlIIllIIIIIl;

    @Override
    public Set<AbstractStaffMod> lIlIlIlIlIIlIIlIIllIIIIIl() {
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
        return new File(LunarClient.getInstance().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().getSelectedProfile().getName(), this.llllIIlIIlIIlIIllIIlIIllI());
    }

    @Override
    public void read(JsonObject jsonObject) {
        for (ConfigurableFeature configurableFeature : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                configurableFeature.read(jsonObject.getAsJsonObject(configurableFeature.getDetails().getId()));
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void write(JsonObject jsonObject) {
        for (ConfigurableFeature configurableFeature : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject.add(configurableFeature.getDetails().getId(), jsonObject2);
                configurableFeature.write(jsonObject2);
            } catch (Exception exception) {
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
