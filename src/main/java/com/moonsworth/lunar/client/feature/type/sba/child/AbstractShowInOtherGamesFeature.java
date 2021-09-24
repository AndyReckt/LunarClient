package com.moonsworth.lunar.client.feature.type.sba.child;

import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.setting.BooleanSetting;

import java.util.List;

public abstract class AbstractShowInOtherGamesFeature extends AbstractFeatureContainerChild {
    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI;

    public AbstractShowInOtherGamesFeature(ConfigurableFeature var1, boolean var2, HudModPosition var3) {
        super(var1, var2, var3);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        super.lIllllIllIIlIIlIIIlIIIlII();
    }

    public List llllIIlIIlIIlIIllIIlIIllI() {
        List var1 = super.llllIIlIIlIIlIIllIIlIIllI();
        var1.add(1, this.lllIIIIIlllIIlIllIIlIIIlI = new BooleanSetting("show_on_other_games", false));
        return var1;
    }

    public BooleanSetting IIIIIIIIIIIIIIIllllIIlIIl() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }
}