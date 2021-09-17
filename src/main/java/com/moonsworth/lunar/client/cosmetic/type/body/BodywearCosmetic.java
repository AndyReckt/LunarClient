package com.moonsworth.lunar.client.cosmetic.type.body;

import com.moonsworth.lunar.client.cosmetic.part.AbstractCosmetic;
import com.moonsworth.lunar.client.cosmetic.part.BodyPart;
import com.moonsworth.lunar.client.cosmetic.part.BodySection;
import com.moonsworth.lunar.client.util.CosmeticRotationHelper;

public class BodywearCosmetic
extends AbstractCosmetic {
    public BodywearCosmetic(String string, boolean bl, CosmeticRotationHelper... cosmeticRotationHelperArray) {
        super(string, BodyPart.BODY, BodySection.BODYWEAR, bl, cosmeticRotationHelperArray);
    }
}
 