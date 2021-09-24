package com.moonsworth.lunar.client.feature.type.doycounter;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudMod;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudModSize;
import com.moonsworth.lunar.client.ref.Ref;

public class DayCounterMod extends SimpleHudMod {
    public DayCounterMod() {
        super(false, HudModPosition.TOP_CENTER);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("daycounter", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.NEW, ModuleCategory.HUD));
    }

    public String IlIlIlIlIIIlIIlIIlllIllIl() {
        return "10 Days";
    }

    public SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI() {
        return new SimpleHudModSize(10, 18, 22, 46, 56, 62);
    }

    public boolean IIIIlIllIllIlIIIIIlIlIlIl() {
        return true;
    }

    public String lllllIlIllIlIlllIIIlIIlIl() {
        if (Ref.getWorld() != null && Ref.getWorld().bridge$getWorldInfo() != null) {
            long var1 = Ref.getWorld().bridge$getWorldInfo().bridge$getGameTime() / 24000L;
            return var1 + " Day" + (var1 != 1L ? "s" : "");
        } else {
            return null;
        }
    }
}
