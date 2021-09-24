package com.moonsworth.lunar.client.feature.type.fps;

import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudMod;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudModSize;
import com.moonsworth.lunar.client.ref.Ref;

public class FPSMod
    extends SimpleHudMod {
    public FPSMod() {
        super(false, HudModPosition.TOP_LEFT);
    }

    @Override
    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(70.0f, 46.0f);
    }

    @Override
    public String IlIlIlIlIIIlIIlIIlllIllIl() {
        return "[1466 FPS]";
    }

    @Override
    public SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI() {
        return new SimpleHudModSize(10, 18, 22, 50, 56, 62);
    }

    @Override
    public FeatureDetails initDetails() {
        return new FeatureDetails("fps");
    }

    @Override
    public String lllllIlIllIlIlllIIIlIIlIl() {
        return Ref.getMinecraft().bridge$getDebugFPS() + " FPS";
    }
}
