package com.moonsworth.lunar.client.feature.type.clock;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.client.event.type.world.PreRunTickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudMod;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudModSize;
import com.moonsworth.lunar.client.setting.BooleanSetting;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ClockMod extends SimpleHudMod {
    public final SimpleDateFormat IllIIIlllIIIlIlllIlIIlIII = new SimpleDateFormat("h:mm a");
    public final SimpleDateFormat IIlIllIlIIllIIlIlIllllllI = new SimpleDateFormat("HH:mm");
    public BooleanSetting lIIIlllIIIIllllIlIIIlIIll;
    public String llIIIlIllIIIIlIIIlIlIllIl;
    public Date llllIlIllllIlIlIIIllIlIlI;

    public ClockMod() {
        super(false, HudModPosition.TOP_RIGHT);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(PreRunTickEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(PreRunTickEvent var1) {
        if (this.llllIlIllllIlIlIIIllIlIlI == null) {
            this.llllIlIllllIlIlIIIllIlIlI = new Date();
        }

        this.llllIlIllllIlIlIIIllIlIlI.setTime(System.currentTimeMillis());
        if (this.lIIIlllIIIIllllIlIIIlIIll.llIlllIIIllllIIlllIllIIIl()) {
            this.llIIIlIllIIIIlIIIlIlIllIl = this.IIlIllIlIIllIIlIlIllllllI.format(this.llllIlIllllIlIlIIIllIlIlI);
        } else {
            this.llIIIlIllIIIIlIIIlIlIllIl = this.IllIIIlllIIIlIlllIlIIlIII.format(this.llllIlIllllIlIlIIIllIlIlI);
        }

    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("clock");
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(-10.0F, 10.0F);
    }

    public String IlIlIlIlIIIlIIlIIlllIllIl() {
        return "[09:45 AM]";
    }

    public SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI() {
        return new SimpleHudModSize(10, 18, 22, 46, 56, 62);
    }

    public String lllllIlIllIlIlllIIIlIIlIl() {
        return this.llIIIlIllIIIIlIIIlIlIllIl == null ? "" : this.llIIIlIllIIIIlIIIlIlIllIl;
    }

    public List IIIIIIIIIIIIIIIllllIIlIIl() {
        return ImmutableList.of(this.lIIIlllIIIIllllIlIIIlIIll = new BooleanSetting("militaryTime", false));
    }
}
