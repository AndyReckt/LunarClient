package com.moonsworth.lunar.client.feature.type.saturation;

import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudMod;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudModSize;
import com.moonsworth.lunar.client.ref.Ref;

public class SaturationMod extends SimpleHudMod {
    public SaturationMod() {
        super(false, HudModPosition.TOP_RIGHT);
    }

    public String IllIlIIllIIlllIIllIlIlIII() {
        return "0";
    }

    public String lllllIlIllIlIlllIIIlIIlIl() {
        return Ref.getPlayer() != null && Ref.getPlayer().bridge$getFoodStats() != null ? (int)Ref.getPlayer().bridge$getFoodStats().bridge$getSaturationLevel() + "" : "";
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(-10.0F, 70.0F);
    }

    public boolean llIIIIllIlIIlIlIIlllIllIl() {
        return false;
    }

    public String IlIlIlIlIIIlIIlIIlllIllIl() {
        return "Saturation";
    }

    public SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI() {
        return new SimpleHudModSize(10, 18, 22, 40, 56, 62);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("saturation");
    }
}
