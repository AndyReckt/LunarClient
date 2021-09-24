package com.moonsworth.lunar.client.feature.type.memory;

import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudMod;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudModSize;

public class MemoryMod extends SimpleHudMod {
    public MemoryMod() {
        super(false, HudModPosition.TOP_RIGHT);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(-10.0F, 50.0F);
    }

    public String IlIlIlIlIIIlIIlIIlllIllIl() {
        return "[Mem: 16%]";
    }

    public SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI() {
        return new SimpleHudModSize(10, 18, 22, 46, 56, 62);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("memory");
    }

    public String lllllIlIllIlIlllIIIlIIlIl() {
        Runtime var1 = Runtime.getRuntime();
        return "Mem: " + (var1.totalMemory() - var1.freeMemory()) * 100L / var1.maxMemory() + "%";
    }
}
