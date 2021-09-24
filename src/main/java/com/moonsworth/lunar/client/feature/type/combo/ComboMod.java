package com.moonsworth.lunar.client.feature.type.combo;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.client.event.type.entity.EntityDamageEvent;
import com.moonsworth.lunar.client.event.type.entity.EntityStatusEvent;
import com.moonsworth.lunar.client.event.type.world.PreRunTickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudMod;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudModSize;
import com.moonsworth.lunar.client.ref.Ref;

public class ComboMod extends SimpleHudMod {
    public int IllIIIlllIIIlIlllIlIIlIII;
    public boolean IIlIllIlIIllIIlIlIllllllI = false;

    public ComboMod() {
        super(false, HudModPosition.TOP_RIGHT);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(EntityDamageEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(EntityStatusEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(PreRunTickEvent.class, (var1) -> {
            if (Ref.getPlayer() == null || !Ref.getPlayer().bridge$getLastAttacker().isPresent() || Ref.getPlayer().bridge$getTicksExisted() - Ref.getPlayer().bridge$getLastAttackerTime() >= 80) {
                if (this.IIlIllIlIIllIIlIlIllllllI) {
                    this.IllIIIlllIIIlIlllIlIIlIII = 0;
                }

                this.IIlIllIlIIllIIlIlIllllllI = !this.IIlIllIlIIllIIlIlIllllllI;
            }
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityStatusEvent var1) {
        if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof EntityPlayerBridge && Ref.getPlayer().bridge$getLastAttacker().isPresent() && Ref.getPlayer().bridge$getLastAttacker().get().equals(var1.lIlIlIlIlIIlIIlIIllIIIIIl()) && Math.abs(Ref.getPlayer().bridge$getLastAttackerTime() - Ref.getPlayer().bridge$getTicksExisted()) <= 4) {
            ++this.IllIIIlllIIIlIlllIlIIlIII;
        }

    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(-10.0F, 90.0F);
    }

    public SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI() {
        return new SimpleHudModSize(10, 18, 22, 46, 56, 62);
    }

    public String lllllIlIllIlIlllIIIlIIlIl() {
        return (this.IllIIIlllIIIlIlllIlIIlIII == 0 ? "No" : this.IllIIIlllIIIlIlllIlIIlIII) + " Combo";
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("combo");
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityDamageEvent var1) {
        if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() instanceof EntityPlayerBridge) {
            if (var1.lIlIlIlIlIIlIIlIIllIIIIIl().equals(Ref.getPlayer()) && var1.IlllIIIIIIlllIlIIlllIlIIl().isGeneric()) {
                this.IllIIIlllIIIlIlllIlIIlIII = 0;
            }

        }
    }

    public String IlIlIlIlIIIlIIlIIlllIllIl() {
        return "[4 Combo]";
    }
}
