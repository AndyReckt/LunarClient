package com.moonsworth.lunar.client.feature.type.timechanger;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.client.event.type.world.GetWorldHorizonEvent;
import com.moonsworth.lunar.client.event.type.world.PreRunTickEvent;
import com.moonsworth.lunar.client.event.type.world.RecieveTimeUpdatePacketEvent;
import com.moonsworth.lunar.client.event.type.world.WorldLoadEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.NumberSetting;
import com.moonsworth.lunar.client.setting.WorldTimeSetting;

import java.util.Date;
import java.util.List;

public class TimeChangerMod extends ConfigurableFeature {
    public Date llllIIlIIlIIlIIllIIlIIllI = new Date();
    public WorldTimeSetting IlIlIlllllIlIIlIlIlllIlIl;
    public NumberSetting llIIIIIIIllIIllIlIllIIIIl;
    public BooleanSetting lIIIllIllIIllIlllIlIIlllI;

    public TimeChangerMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(WorldLoadEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GetWorldHorizonEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RecieveTimeUpdatePacketEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.IlIlIlllllIlIIlIlIlllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl((var1) -> {
            if (Ref.getWorld() != null && this.IlllIIIIIIlllIlIIlllIlIIl()) {
                Ref.getWorld().bridge$setWorldTime(this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() ? (long)this.lIllllIllIIlIIlIIIlIIIlII() : (long)var1);
            }

        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(PreRunTickEvent.class, (var1) -> {
            if (this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl()) {
                if (Ref.getWorld() != null && this.IlllIIIIIIlllIlIIlllIlIIl()) {
                    Ref.getWorld().bridge$setWorldTime(this.lIllllIllIIlIIlIIIlIIIlII());
                }

            }
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RecieveTimeUpdatePacketEvent var1) {
        var1.setCancelled(true);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(GetWorldHorizonEvent var1) {
        var1.lIlIlIlIlIIlIIlIIllIIIIIl((double)(Integer)this.IlIllIIlIIlIIIllIllllIIll().llIlllIIIllllIIlllIllIIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(WorldLoadEvent var1) {
        if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() != null) {
            var1.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$setWorldTime(this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() ? (long)this.lIllllIllIIlIIlIIIlIIIlII() : (long)(Integer)this.IlIlIlllllIlIIlIlIlllIlIl.llIlllIIIllllIIlllIllIIIl());
        }

    }

    public int lIllllIllIIlIIlIIIlIIIlII() {
        if (this.llllIIlIIlIIlIIllIIlIIllI == null) {
            this.llllIIlIIlIIlIIllIIlIIllI = new Date();
        }

        this.llllIIlIIlIIlIIllIIlIIllI.setTime(System.currentTimeMillis());
        int var1 = this.llllIIlIIlIIlIIllIIlIIllI.getHours() - 6;
        if (var1 <= 0) {
            var1 += 24;
        }

        var1 *= 1000;
        var1 = (int)((double)var1 + (double)(this.llllIIlIIlIIlIIllIIlIIllI.getSeconds() + this.llllIIlIIlIIlIIllIIlIIllI.getMinutes() * 60) / 3.6D);
        return var1;
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.IlIlIlllllIlIIlIlIlllIlIl = new WorldTimeSetting("time", -12000, -18000, -6000), this.llIIIIIIIllIIllIlIllIIIIl = new NumberSetting("horizon_y_level", 63, 0, 63), this.lIIIllIllIIllIlllIlIIlllI = new BooleanSetting("useRealTime", false));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Time Changer", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("time_changer", ImmutableList.of(ModuleCategory.ALL));
    }

    public NumberSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }
}
