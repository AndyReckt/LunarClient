package com.moonsworth.lunar.client.registry;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.lunarclient.bukkitapi.nethandler.client.obj.ServerRule;
import com.moonsworth.lunar.client.feature.IlllIIIIIIlllIlIIlllIlIIl;
import com.moonsworth.lunar.client.json.file.DefaultJson;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;

import java.util.Set;

public class RuleFeaturesConfig
extends ItemSetLoader<IlllIIIIIIlllIlIIlllIlIIl>
implements DefaultJson {
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
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        for (IlllIIIIIIlllIlIIlllIlIIl illlIIIIIIlllIlIIlllIlIIl : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                illlIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(jsonObject.getAsJsonObject(illlIIIIIIlllIlIIlllIlIIl.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl()));
            }
            catch (Exception exception) {}
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        for (IlllIIIIIIlllIlIIlllIlIIl illlIIIIIIlllIlIIlllIlIIl : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                JsonObject jsonObject2 = new JsonObject();
                jsonObject.add(illlIIIIIIlllIlIIlllIlIIl.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(), jsonObject2);
                illlIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2);
            }
            catch (Exception exception) {}
        }
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.save();
    }
}
 