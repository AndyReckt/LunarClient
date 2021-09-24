package com.moonsworth.lunar.client.feature.type.particles;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ParticleType;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.type.entity.EntityCriticalStrikeEvent;
import com.moonsworth.lunar.client.event.type.entity.EntityEnchantCriticalStrike;
import com.moonsworth.lunar.client.event.type.entity.EventPreAttackEntity;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.NumberSetting;

import java.util.List;

public class ParticleMultiplierMod extends ConfigurableFeature {
    public NumberSetting llllIIlIIlIIlIIllIIlIIllI;
    public BooleanSetting IlIlIlllllIlIIlIlIlllIlIl;
    public BooleanSetting llIIIIIIIllIIllIlIllIIIIl;
    public BooleanSetting lIIIllIllIIllIlllIlIIlllI;
    public BooleanSetting IlllllIlIIIlIIlIIllIIlIll;

    public ParticleMultiplierMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(EntityCriticalStrikeEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(EntityEnchantCriticalStrike.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(EventPreAttackEntity.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EventPreAttackEntity var1) {
        if (var1.IlllIIIIIIlllIlIIlllIlIIl() instanceof EntityLivingBaseBridge) {
            if (!(var1.IlllIIIIIIlllIlIIlllIlIIl() instanceof com.moonsworth.lunar.bridge.minecraft.client.entity.item.lIlIlIlIlIIlIIlIIllIIIIIl)) {
                if (this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() && var1.lIllIlIIIlIIIIIIIlllIlIll() <= 3.0D) {
                    for(int var2 = 0; var2 < (Integer)this.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl(); ++var2) {
                        this.mc.bridge$getEffectRenderer().bridge$emitParticleAtEntity(var1.IlllIIIIIIlllIlIIlllIlIIl(), ParticleType.llIIIlllIIlllIllllIlIllIl);
                    }
                }

            }
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityCriticalStrikeEvent var1) {
        if (!(Boolean)this.IlIlIlllllIlIIlIlIlllIlIl.llIlllIIIllllIIlllIllIIIl()) {
            var1.setCancelled(true);
        } else if (this.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl()) {
            for(int var2 = 0; var2 < (Integer)this.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl(); ++var2) {
                this.mc.bridge$getEffectRenderer().bridge$emitParticleAtEntity(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), ParticleType.llIIlIlIIIllIlIlIlIIlIIll);
            }

        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityEnchantCriticalStrike var1) {
        if (this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl()) {
            for(int var2 = 0; var2 < (Integer)this.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl(); ++var2) {
                this.mc.bridge$getEffectRenderer().bridge$emitParticleAtEntity(var1.lIlIlIlIlIIlIIlIIllIIIIIl(), ParticleType.llIIIlllIIlllIllllIlIllIl);
            }

        }
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.llllIIlIIlIIlIIllIIlIIllI = new NumberSetting("particleMultiplier", 2, 1, 10), this.IlIlIlllllIlIIlIlIlllIlIl = new BooleanSetting("showCriticals", true), this.IlllllIlIIIlIIlIIllIIlIll = new BooleanSetting("affectCriticals", true), this.llIIIIIIIllIIllIlIllIIIIl = new BooleanSetting("affectEnchantedCrits", true), this.lIIIllIllIIllIlllIlIIlllI = new BooleanSetting("alwaysShowEnchantedCrits", false));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Particle Multiplier", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("particleMultiplierMod", ImmutableList.of(ModuleCategory.ALL), ImmutableList.of(MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl, MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl, MinecraftVersion.llllIIlIIlIIlIIllIIlIIllI, MinecraftVersion.llIlllIIIllllIIlllIllIIIl));
    }

    public NumberSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public BooleanSetting lIllllIllIIlIIlIIIlIIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public BooleanSetting lIlIlIIIIIIllIlIIIIllIIII() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public BooleanSetting lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public BooleanSetting IlIIlIIlIIlIIllIIIllIIllI() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }
}
