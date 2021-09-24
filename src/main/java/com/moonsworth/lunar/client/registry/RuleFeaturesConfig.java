package com.moonsworth.lunar.client.registry;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.lunarclient.bukkitapi.nethandler.client.obj.ServerRule;
import com.moonsworth.lunar.client.feature.IlllIIIIIIlllIlIIlllIlIIl;
import com.moonsworth.lunar.client.json.file.JsonFile;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;

import java.util.Set;

public class RuleFeaturesConfig extends ItemSetLoader<IlllIIIIIIlllIlIIlllIlIIl> implements JsonFile {
    @Override
    public Set<IlllIIIIIIlllIlIIlllIlIIl> lIlIlIlIlIIlIIlIIllIIIIIl() {
        return ImmutableSet.of();
    }

    public IlllIIIIIIlllIlIIlllIlIIl lIlIlIlIlIIlIIlIIllIIIIIl(ServerRule serverRule) {
        for (IlllIIIIIIlllIlIIlllIlIIl illlIIIIIIlllIlIIlllIlIIl : this.llIlllIIIllllIIlllIllIIIl()) {
            if (illlIIIIIIlllIlIIlllIlIIl.lIlIlIIIIIIllIlIIIIllIIII() != serverRule) continue;
            return illlIIIIIIlllIlIIlllIlIIl;
        }
        return null;
    }

    @Override
    public void b_() {
        super.b_();
        for (IlllIIIIIIlllIlIIlllIlIIl illlIIIIIIlllIlIIlllIlIIl : this.llIlllIIIllllIIlllIllIIIl()) {
            if (!illlIIIIIIlllIlIIlllIlIIl.lIlIIIIIIlIIIllllIllIIlII()) continue;
            illlIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll();
        }
        this.load();
    }

    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "rule-features.json";
    }

    @Override
    public void read(JsonObject jsonObject) {
        for (IlllIIIIIIlllIlIIlllIlIIl illlIIIIIIlllIlIIlllIlIIl : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                illlIIIIIIlllIlIIlllIlIIl.read(jsonObject.getAsJsonObject(illlIIIIIIlllIlIIlllIlIIl.getDetails().getId()));
            } catch (Exception exception) {}
        }
    }

    @Override
    public void write(JsonObject jsonObject) {
        for (IlllIIIIIIlllIlIIlllIlIIl illlIIIIIIlllIlIIlllIlIIl : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject.add(illlIIIIIIlllIlIIlllIlIIl.getDetails().getId(), jsonObject2);
                illlIIIIIIlllIlIIlllIlIIl.write(jsonObject2);
            } catch (Exception exception) {}
        }
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.save();
    }
}
