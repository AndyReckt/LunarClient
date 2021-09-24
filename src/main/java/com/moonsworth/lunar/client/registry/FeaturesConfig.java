package com.moonsworth.lunar.client.registry;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.feature.type.borders.BordersMod;
import com.moonsworth.lunar.client.feature.type.hologram.HologramsMod;
import com.moonsworth.lunar.client.feature.type.nameplates.CustomNameplateMod;
import com.moonsworth.lunar.client.feature.type.title.TitlesMod;
import com.moonsworth.lunar.client.json.file.JsonFile;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;

import java.util.Set;

public class FeaturesConfig extends ItemSetLoader<Feature> implements JsonFile {
    public CustomNameplateMod lIlIlIlIlIIlIIlIIllIIIIIl;

    @Override
    public Set<Feature> lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new CustomNameplateMod();
        return ImmutableSet.of(new HologramsMod(), new TitlesMod(), this.lIlIlIlIlIIlIIlIIllIIIIIl, new BordersMod());
    }

    @Override
    public void b_() {
        super.b_();
        for (Feature feature : this.llIlllIIIllllIIlllIllIIIl()) {
            if (!feature.lIlIIIIIIlIIIllllIllIIlII()) continue;
            feature.lIllIlIIIlIIIIIIIlllIlIll();
        }
        this.load();
    }

    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "features.json";
    }

    @Override
    public void read(JsonObject jsonObject) {
        for (Feature feature : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                JsonObject jsonObject2 = jsonObject.has(feature.getDetails().getId()) && !jsonObject.get(feature.getDetails().getId()).isJsonNull() ? jsonObject.getAsJsonObject(feature.getDetails().getId()) : new JsonObject();
                feature.read(jsonObject2);
            } catch (Exception exception) {}
        }
    }

    @Override
    public void write(JsonObject jsonObject) {
        for (Feature feature : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                JsonObject jsonObject2 = new JsonObject();
                feature.write(jsonObject2);
                if (jsonObject2.entrySet().isEmpty()) continue;
                jsonObject.add(feature.getDetails().getId(), jsonObject2);
            } catch (Exception exception) {}
        }
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.save();
    }

    public CustomNameplateMod IlllllIlIIIlIIlIIllIIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
