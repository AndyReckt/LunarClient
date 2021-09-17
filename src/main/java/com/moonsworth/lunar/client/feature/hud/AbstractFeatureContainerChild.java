package com.moonsworth.lunar.client.feature.hud;

public abstract class AbstractFeatureContainerChild extends DraggableHudMod {
    public final ConfigurableFeature lllIIIIIlllIIlIllIIlIIIlI;

    public AbstractFeatureContainerChild(ConfigurableFeature configurableFeature, boolean bl, Anchor anchor) {
        super(bl, anchor);
        this.lllIIIIIlllIIlIllIIlIIIlI = configurableFeature;
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lllIIIIIlllIIlIllIIlIIIlI.IlllIIIIIIlllIlIIlllIlIIl() && super.IlllIIIIIIlllIlIIlllIlIIl();
    }

    public ConfigurableFeature IlIllIIlIIlIIIllIllllIIll() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }
}