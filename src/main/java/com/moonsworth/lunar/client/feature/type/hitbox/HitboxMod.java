package com.moonsworth.lunar.client.feature.type.hitbox;

import com.google.common.collect.ImmutableList;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.item.EntityItemBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.setting.*;

import java.awt.*;
import java.util.List;

public class HitboxMod extends ConfigurableFeature {
    public HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl llllIIlIIlIIlIIllIIlIIllI;
    public HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl IlIlIlllllIlIIlIlIlllIlIl;
    public HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl llIIIIIIIllIIllIlIllIIIIl;
    public HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl lIIIllIllIIllIlllIlIIlllI;
    public HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl IlllllIlIIIlIIlIIllIIlIll;
    public EnumSetting llIIlIlIIIllIlIlIlIIlIIll;

    public HitboxMod() {
        super(false);
        EventBus.getInstance().register(TickEvent.class, (var1) -> {
            boolean var2 = Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getRenderManager().bridge$showDebugBoundingBox();
            if (this.IlllIIIIIIlllIlIIlllIlIIl() && !var2) {
                this.IlllIIIIIIlllIlIIlllIlIIl(false);
            } else if (!this.IlllIIIIIIlllIlIIlllIlIIl() && var2) {
                this.IlllIIIIIIlllIlIIlllIlIIl(true);
            }

        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean var1) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(var1);
        Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getRenderManager().bridge$setDebugBoundingBox(var1);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        this.llllIIlIIlIIlIIllIIlIIllI = new HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl("player");
        this.IlIlIlllllIlIIlIlIlllIlIl = new HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl("item");
        this.llIIIIIIIllIIllIlIllIIIIl = new HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl("projectile");
        this.lIIIllIllIIllIlllIlIIlllI = new HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl("mob");
        this.IlllllIlIIIlIIlIIllIIlIll = new HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl("expOrb");
        this.llIIlIlIIIllIlIlIlIIlIIll = new EnumSetting("hitbox.linePattern", HitboxMod.LinePattern.lIlIlIlIlIIlIIlIIllIIIIIl);
        return ImmutableList.builder().add(new SettingLabel("hitbox.globalOptions")).add(this.llIIlIlIIIllIlIlIlIIlIIll).addAll(this.llllIIlIIlIIlIIllIIlIIllI.lIlIlIlIlIIlIIlIIllIIIIIl()).addAll(this.IlIlIlllllIlIIlIlIlllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl()).addAll(this.llIIIIIIIllIIllIlIllIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl()).addAll(this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl()).addAll(this.IlllllIlIIIlIIlIIllIIlIll.lIlIlIlIlIIlIIlIIllIIIIIl()).build();
    }

    public HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl lIlIlIlIlIIlIIlIIllIIIIIl(EntityBridge var1) {
        if (var1 instanceof EntityPlayerBridge) {
            return this.llllIIlIIlIIlIIllIIlIIllI;
        } else if (var1 instanceof EntityItemBridge) {
            return this.IlIlIlllllIlIIlIlIlllIlIl;
        } else if (var1 instanceof com.moonsworth.lunar.bridge.minecraft.client.entity.llIIlIlIIIllIlIlIlIIlIIll) {
            return this.llIIIIIIIllIIllIlIllIIIIl;
        } else {
            return var1 instanceof com.moonsworth.lunar.bridge.minecraft.client.entity.IlllllIlIIIlIIlIIllIIlIll ? this.IlllllIlIIIlIIlIIllIIlIll : this.lIIIllIllIIllIlllIlIIlllI;
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Hitbox Mod", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("hitbox", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.NEW));
    }

    public HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl IlIllIIlIIlIIIllIllllIIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl lIllllIllIIlIIlIIIlIIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl lIlIlIIIIIIllIlIIIIllIIII() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public HitboxMod.lIlIlIlIlIIlIIlIIllIIIIIl IlIIlIIlIIlIIllIIIllIIllI() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public EnumSetting IIlIlIIIllIIllllIllllIlIl() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public enum LinePattern implements IEnumSetting {
        lIlIlIlIlIIlIIlIIllIIIIIl(1, 65535),
        IlllIIIIIIlllIlIIlllIlIIl(3, 65280),
        lIllIlIIIlIIIIIIIlllIlIll(1, 43690);

        public int llIlllIIIllllIIlllIllIIIl;
        public int llllIIlIIlIIlIIllIIlIIllI;

        LinePattern(int var3, int var4) {
            this.llIlllIIIllllIIlllIllIIIl = var3;
            this.llllIIlIIlIIlIIllIIlIIllI = var4;
        }

        public int IlllIIIIIIlllIlIIlllIlIIl() {
            return this.llIlllIIIllllIIlllIllIIIl;
        }

        public int lIllIlIIIlIIIIIIIlllIlIll() {
            return this.llllIIlIIlIIlIIllIIlIIllI;
        }

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return "hitbox." + this.name().toLowerCase();
        }
    }

    public static class lIlIlIlIlIIlIIlIIllIIIIIl {
        public SettingLabel lIlIlIlIlIIlIIlIIllIIIIIl;
        public NumberSetting IlllIIIIIIlllIlIIlllIlIIl;
        public ColorSetting lIllIlIIIlIIIIIIIlllIlIll;
        public BooleanSetting llIlllIIIllllIIlllIllIIIl;
        public BooleanSetting llllIIlIIlIIlIIllIIlIIllI;

        public lIlIlIlIlIIlIIlIIllIIIIIl(String var1) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = new SettingLabel("hitbox." + var1);
            this.IlllIIIIIIlllIlIIlllIlIIl = new NumberSetting("hitbox." + var1 + ".lineWidth", 1.0F, 1.0F, 5.0F);
            this.lIllIlIIIlIIIIIIIlllIlIll = new ColorSetting("hitbox." + var1 + ".lineColor", Color.WHITE.getRGB());
            this.llIlllIIIllllIIlllIllIIIl = new BooleanSetting("hitbox." + var1 + ".lookVector", false, () -> {
                return Bridge.getMinecraftVersion().ordinal() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl.ordinal();
            });
            this.llllIIlIIlIIlIIllIIlIIllI = new BooleanSetting("hitbox." + var1 + ".show", true);
        }

        public ImmutableList lIlIlIlIlIIlIIlIIllIIIIIl() {
            return ImmutableList.of(this.lIlIlIlIlIIlIIlIIllIIIIIl, this.IlllIIIIIIlllIlIIlllIlIIl, this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl, this.llllIIlIIlIIlIIllIIlIIllI);
        }

        public SettingLabel IlllIIIIIIlllIlIIlllIlIIl() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public NumberSetting lIllIlIIIlIIIIIIIlllIlIll() {
            return this.IlllIIIIIIlllIlIIlllIlIIl;
        }

        public ColorSetting llIlllIIIllllIIlllIllIIIl() {
            return this.lIllIlIIIlIIIIIIIlllIlIll;
        }

        public BooleanSetting llllIIlIIlIIlIIllIIlIIllI() {
            return this.llIlllIIIllllIIlllIllIIIl;
        }

        public BooleanSetting IlIlIlllllIlIIlIlIlllIlIl() {
            return this.llllIIlIIlIIlIIllIIlIIllI;
        }
    }
}
