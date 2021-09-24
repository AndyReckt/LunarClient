package com.moonsworth.lunar.client.feature.type.uhc;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.hud.RenderEntityItemScaleEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.setting.NumberSetting;

import java.util.List;

public class UHCOverlayMod extends ConfigurableFeature {
    public NumberSetting llllIIlIIlIIlIIllIIlIIllI;
    public NumberSetting IlIlIlllllIlIIlIlIlllIlIl;
    public NumberSetting llIIIIIIIllIIllIlIllIIIIl;
    public NumberSetting lIIIllIllIIllIlllIlIIlllI;
    public NumberSetting IlllllIlIIIlIIlIIllIIlIll;

    public UHCOverlayMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderEntityItemScaleEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(String var1) {
        byte var3 = -1;
        switch(var1.hashCode()) {
        case -1255829167:
            if (var1.equals("minecraft:golden_apple")) {
                var3 = 1;
            }
            break;
        case -1228739152:
            if (var1.equals("minecraft:gold_ore")) {
                var3 = 3;
            }
            break;
        case -1134211248:
            if (var1.equals("minecraft:skull")) {
                var3 = 4;
            }
            break;
        case -314907087:
            if (var1.equals("minecraft:player_head")) {
                var3 = 5;
            }
            break;
        case 292026517:
            if (var1.equals("minecraft:gold_ingot")) {
                var3 = 0;
            }
            break;
        case 612489800:
            if (var1.equals("minecraft:gold_nugget")) {
                var3 = 2;
            }
        }

        switch(var3) {
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
            return true;
        default:
            return false;
        }
    }

    public float IlllIIIIIIlllIlIIlllIlIIl(String var1) {
        byte var3 = -1;
        switch(var1.hashCode()) {
        case -1255829167:
            if (var1.equals("minecraft:golden_apple")) {
                var3 = 3;
            }
            break;
        case -1228739152:
            if (var1.equals("minecraft:gold_ore")) {
                var3 = 2;
            }
            break;
        case -1134211248:
            if (var1.equals("minecraft:skull")) {
                var3 = 4;
            }
            break;
        case -314907087:
            if (var1.equals("minecraft:player_head")) {
                var3 = 5;
            }
            break;
        case 292026517:
            if (var1.equals("minecraft:gold_ingot")) {
                var3 = 0;
            }
            break;
        case 612489800:
            if (var1.equals("minecraft:gold_nugget")) {
                var3 = 1;
            }
        }

        switch(var3) {
        case 0:
            return (Float)this.IlIlIlllllIlIIlIlIlllIlIl.llIlllIIIllllIIlllIllIIIl();
        case 1:
            return (Float)this.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl();
        case 2:
            return (Float)this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl();
        case 3:
            return (Float)this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl();
        case 4:
        case 5:
            return (Float)this.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl();
        default:
            return 1.0F;
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderEntityItemScaleEvent var1) {
        if (!var1.lIllIlIIIlIIIIIIIlllIlIll()) {
            String var2 = var1.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getItem().bridge$getItem().bridge$getRegistryName();
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl(var2)) {
                float var3 = this.IlllIIIIIIlllIlIIlllIlIIl(var2);
                if (Bridge.getMinecraftVersion().lIllIlIIIlIIIIIIIlllIlIll()) {
                    var1.lIlIlIlIlIIlIIlIIllIIIIIl(var3);
                } else {
                    Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(var3, var3, var3);
                    if (var1.IlllIIIIIIlllIlIIlllIlIIl()) {
                        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0F, 0.05F * var3, 0.0F);
                    }
                }
            }

        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean var1) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(var1);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.IlIlIlllllIlIIlIlIlllIlIl = new NumberSetting("gold_ingot_scale", 2.0F, 1.0F, 5.0F, 2), this.llllIIlIIlIIlIIllIIlIIllI = new NumberSetting("gold_nugget_scale", 2.0F, 1.0F, 5.0F, 2), this.llIIIIIIIllIIllIlIllIIIIl = new NumberSetting("gold_ore_scale", 2.0F, 1.0F, 5.0F, 2), this.lIIIllIllIIllIlllIlIIlllI = new NumberSetting("gold_apple_scale", 2.0F, 1.0F, 5.0F, 2), this.IlllllIlIIIlIIlIIllIIlIll = new NumberSetting("skull_scale", 2.0F, 1.0F, 5.0F, 2));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("UHC Overlay", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("uhc_overlay", ImmutableList.of(ModuleCategory.ALL));
    }

    public NumberSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public NumberSetting lIllllIllIIlIIlIIIlIIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public NumberSetting lIlIlIIIIIIllIlIIIIllIIII() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public NumberSetting lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public NumberSetting IlIIlIIlIIlIIllIIIllIIllI() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }
}