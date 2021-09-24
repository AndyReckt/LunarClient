package com.moonsworth.lunar.client.feature.hud;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.client.feature.Feature;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public abstract class ConfigurableFeature extends Feature {
    public final List<AbstractFeatureContainerChild> llllIIlIIlIIlIIllIIlIIllI = Collections.synchronizedList(this.llllIlIlIIIllllIIlIllIlII());
    public Predicate lllllIllIllIllllIlIllllII = abstractFeatureContainerChild -> true;

    public List<AbstractFeatureContainerChild> llllIlIlIIIllllIIlIllIlII() {
        return ImmutableList.of();
    }

    public ConfigurableFeature(boolean bl) {
        super(bl);
    }

    @Override
    public void write(JsonObject jsonObject) {
        super.write(jsonObject);
        for (AbstractFeatureContainerChild abstractFeatureContainerChild : this.llllIIlIIlIIlIIllIIlIIllI) {
            try {
                JsonObject jsonObject2 = new JsonObject();
                abstractFeatureContainerChild.write(jsonObject2);
                if (jsonObject2.entrySet().isEmpty()) continue;
                jsonObject.add(abstractFeatureContainerChild.getDetails().getId(), jsonObject2);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void read(JsonObject jsonObject) {
        super.read(jsonObject);
        for (ConfigurableFeature configurableFeature : this.llllIIlIIlIIlIIllIIlIIllI) {
            try {
                JsonObject jsonObject2 = jsonObject.has(configurableFeature.getDetails().getId()) && !jsonObject.get(configurableFeature.getDetails().getId()).isJsonNull() ? jsonObject.getAsJsonObject(configurableFeature.getDetails().getId()) : new JsonObject();
                configurableFeature.read(jsonObject2);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public List<AbstractFeatureContainerChild> llIIIllllIIIllIIIIlIlIlll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Predicate predicate) {
        this.lllllIllIllIllllIlIllllII = predicate;
    }
}