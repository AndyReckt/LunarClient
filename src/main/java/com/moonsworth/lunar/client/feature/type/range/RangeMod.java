package com.moonsworth.lunar.client.feature.type.range;

import com.moonsworth.lunar.client.event.type.entity.EntityStatusEvent;
import com.moonsworth.lunar.client.event.type.entity.EventPreAttackEntity;
import com.moonsworth.lunar.client.event.type.world.PreRunTickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudMod;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudModSize;
import com.moonsworth.lunar.client.ref.Ref;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class RangeMod extends SimpleHudMod {
    public static final DecimalFormat lIIIlllIIIIllllIlIIIlIIll;
    public boolean llIIIlIllIIIIlIIIlIlIllIl = false;
    public double IllIIIlllIIIlIlllIlIIlIII;
    public int IIlIllIlIIllIIlIlIllllllI;
    public double llllIlIllllIlIlIIIllIlIlI;

    public RangeMod() {
        super(false, HudModPosition.TOP_LEFT);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(EntityStatusEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(PreRunTickEvent.class, (var1) -> {
            if (Ref.getPlayer() == null || Ref.getPlayer().bridge$getTicksExisted() - Ref.getPlayer().bridge$getLastAttackerTime() >= 80) {
                if (this.llIIIlIllIIIIlIIIlIlIllIl) {
                    this.llllIlIllllIlIlIIIllIlIlI = 0.0D;
                }

                this.llIIIlIllIIIIlIIIlIlIllIl = !this.llIIIlIllIIIIlIIIlIlIllIl;
            }
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(EventPreAttackEntity.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI() {
        return new SimpleHudModSize(10, 18, 22, 40, 65, 72);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EventPreAttackEntity var1) {
        this.IIlIllIlIIllIIlIlIllllllI = var1.IlllIIIIIIlllIlIIlllIlIIl().bridge$getEntityId();
        this.IllIIIlllIIIlIlllIlIIlIII = var1.lIllIlIIIlIIIIIIIlllIlIll();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityStatusEvent var1) {
        if (var1.IlllIIIIIIlllIlIIlllIlIIl() == 2 && var1.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getEntityId() == this.IIlIllIlIIllIIlIlIllllllI && Math.abs(Ref.getPlayer().bridge$getLastAttackerTime() - Ref.getPlayer().bridge$getTicksExisted()) <= 4) {
            this.llllIlIllllIlIlIIIllIlIlI = this.IllIIIlllIIIlIlllIlIIlIII;
        }

    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(70.0F, 106.0F);
    }

    public String lllllIlIllIlIlllIIIlIIlIl() {
        return lIIIlllIIIIllllIlIIIlIIll.format(Math.min(3.0D, this.llllIlIllllIlIlIIIllIlIlI)) + " blocks";
    }

    public String IlIlIlIlIIIlIIlIIlllIllIl() {
        return "[1.3 blocks]";
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("range");
    }

    static {
        lIIIlllIIIIllllIlIIIlIIll = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.ENGLISH));
    }
}
