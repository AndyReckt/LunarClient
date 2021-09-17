package com.moonsworth.lunar.client.cosmetic.type;

import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.client.cosmetic.Cosmetic;
import com.moonsworth.lunar.client.cosmetic.CosmeticType;

public class HatCosmeticType extends Cosmetic {
    public HatCosmeticType(long l, String string, float f, String string2, boolean bl) {
        this(l, string, f, string2, CosmeticType.HAT, bl);
    }

    public HatCosmeticType(long l, String string, float f, String string2, CosmeticType cosmeticType, boolean bl) {
        super(l, string, f, string2, cosmeticType, bl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, float f) {
    }
}