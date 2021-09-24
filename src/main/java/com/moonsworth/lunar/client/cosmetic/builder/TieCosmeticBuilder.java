package com.moonsworth.lunar.client.cosmetic.builder;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.moonsworth.lunar.bridge.minecraft.util.Vector3f;
import com.moonsworth.lunar.client.cosmetic.part.AbstractCosmetic;
import com.moonsworth.lunar.client.cosmetic.type.body.BodywearCosmetic;
import com.moonsworth.lunar.client.util.CosmeticRotationHelper;

public class TieCosmeticBuilder {
    public static final BiMap<String, AbstractCosmetic> lIlIlIlIlIIlIIlIIllIIIIIl = ((ImmutableBiMap.Builder) ImmutableBiMap.builder().put("tie", new BodywearCosmetic("tie", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge != null) {
            return new Vector3f(0.0f, 0.0f, -0.15f);
        }
        return new Vector3f(0.0f, -0.8f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(1.5f, 1.5f, 1.5f);
        }
        return null;
    })).lIIIllIllIIllIlllIlIIlllI())).put("bowtie", new BodywearCosmetic("bowtie", false, CosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl((entityPlayerBridge) -> {
        if (entityPlayerBridge != null) {
            return new Vector3f(0.0f, 0.15f, -0.15f);
        }
        return new Vector3f(0.0f, -0.45f, 0.0f);
    }), CosmeticRotationHelper.IlllIIIIIIlllIlIIlllIlIIl((abstractClientPlayerBridge) -> {
        if (abstractClientPlayerBridge == null) {
            return new Vector3f(2.0f, 2.0f, 2.0f);
        }
        return null;
    })).lIIIllIllIIllIlllIlIIlllI()).build();
}
