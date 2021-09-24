package com.moonsworth.lunar.client.feature.type.potioneffects;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import com.moonsworth.lunar.bridge.minecraft.potion.PotionBridge;
import com.moonsworth.lunar.bridge.minecraft.potion.PotionEffectBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.feature.hud.Position;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.*;

import java.util.*;

public class PotionEffectsMod extends DraggableHudMod {
    public final ResourceLocationBridge lllIIIIIlllIIlIllIIlIIIlI = Bridge.getInstance().initResourceLocation("textures/gui/container/inventory.png");
    public BooleanSetting lIlIIIIIIlIIIllllIllIIlII;
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;
    public BooleanSetting IIlIllIlllllllIIlIIIllIIl;
    public BooleanSetting lIIlIlllIlIlIIIlllIIlIIII;
    public BooleanSetting llIllIlIllIlllIllIIIIllII;
    public BooleanSetting IllllllllllIlIIIlllIlllll;
    public BooleanSetting lllllIllIlIIlIIlIIIlllIlI;
    public BooleanSetting IllIIIlllIIIlIlllIlIIlIII;
    public BooleanSetting IIlIllIlIIllIIlIlIllllllI;
    public BooleanSetting lIIIlllIIIIllllIlIIIlIIll;
    public BooleanSetting llIIIlIllIIIIlIIIlIlIllIl;
    public BooleanSetting llllIlIllllIlIlIIIllIlIlI;
    public BooleanSetting IlIllIIlIIlIIIllIllllIIll;
    public BooleanSetting lIllllIllIIlIIlIIIlIIIlII;
    public BooleanSetting lIlIlIIIIIIllIlIIIIllIIII;
    public BooleanSetting lIIlIIIIIIlIIlIIllIlIIlII;
    public BooleanSetting IlIIlIIlIIlIIllIIIllIIllI;
    public BooleanSetting IIlIlIIIllIIllllIllllIlIl;
    public NumberSetting lllllIIIIlIlllIllIIIlIIlI;
    public BooleanSetting IIlllIllIlIllIllIIllIlIIl;
    public static final Map lIlIIlIlllIIlIIIlIlIlIllI = (new ImmutableMap.Builder()).put(1, -11141121).put(2, -10851199).put(3, -2506685).put(4, -11910633).put(5, -7134173).put(8, -1).put(10, -3318613).put(12, -1795526).put(13, -13741415).put(14, -8420462).put(15, -14737629).put(16, -14737503).put(17, -10979757).put(18, -12038840).put(19, -11627727).put(20, -13293017).put(22, -14331227).build();
    public ColorSetting lIIlllIIIIIlllIIIlIlIlllI;
    public ColorSetting IIIlIIIIIIllIIIIllIIIIlII;
    public int IlIIIlIlIlIlIlIllIIllIIlI = 0;

    public PotionEffectsMod() {
        super(true, HudModPosition.MIDDLE_LEFT);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(10.0F, 0.0F);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, (var1) -> {
            ++this.IlIIIlIlIlIlIlIllIIllIIlI;
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        if (this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl() || !Ref.getMinecraft().bridge$getGuiIngame().bridge$getChatGUI().bridge$getChatOpen()) {
            List var4 = Ref.getPlayer().bridge$getActivePotionEffects();
            if (var4.isEmpty()) {
                return;
            }

            this.lIlIlIlIlIIlIIlIIllIIIIIl(var4, false, var2, var3);
        }

    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        if (this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl() || !Ref.getMinecraft().bridge$getGuiIngame().bridge$getChatGUI().bridge$getChatOpen()) {
            Object var4 = null;
            if (Ref.getPlayer() != null && !Ref.getPlayer().bridge$getActivePotionEffects().isEmpty()) {
                var4 = Ref.getPlayer().bridge$getActivePotionEffects();
            } else {
                HashMap var5 = new HashMap();
                PotionEffectBridge var6 = Bridge.IIlIllIlllllllIIlIIIllIIl().bridge$initPotionEffect(1, 1200, 3);
                PotionEffectBridge var7 = Bridge.IIlIllIlllllllIIlIIIllIIl().bridge$initPotionEffect(5, 30, 3);
                var5.put(var6.bridge$getPotionID(), var6);
                var5.put(var7.bridge$getPotionID(), var7);
                var4 = var5.values();
            }

            this.lIlIlIlIlIIlIIlIIllIIIIIl((Collection)var4, true, var2, var3);
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Collection<PotionEffectBridge> var1, boolean var2, float var3, float var4) {
        Position var5 = this.lIlIIIIIllIIlIIlIIlIlIIlI().IlllIIIIIIlllIlIIlllIlIIl();
        int var6 = 0;
        float var7 = 0.0F;
        byte var8 = 22;
        Iterator<PotionEffectBridge> var9 = var1.iterator();

        while(var9.hasNext()) {
            PotionEffectBridge var10 = var9.next();
            if (!this.lIlIlIlIlIIlIIlIIllIIIIIl(var10)) {
                PotionBridge var11 = Bridge.IIlIllIlllllllIIlIIIllIIl().bridge$getPotionTypes(var10.bridge$getPotionID());
                boolean var12 = this.llIlllIIIllllIIlllIllIIIl(var10.bridge$getDuration());
                float var13 = 0.0F;
                String var14;
                float var15;
                if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
                    var14 = Bridge.IIlIllIlllllllIIlIIIllIIl().bridge$translateToLocal(var10.bridge$getEffectName()) + this.IlllIIIIIIlllIlIIlllIlIIl(var10.bridge$getAmplifier());
                    var13 = Ref.getFontRenderer().bridge$getStringWidth(var14) + 20.0F;
                    var15 = 0.0F;
                    float var16 = 0.0F;
                    if (var5 == Position.RIGHT) {
                        var15 = this.lIIlIIlllIIIIlIlllIIIIlll() - var13;
                        var16 = (float)var6;
                    } else if (var5 == Position.LEFT) {
                        var15 = 20.0F;
                        var16 = (float)var6;
                    } else if (var5 == Position.MIDDLE) {
                        var15 = this.lIIlIIlllIIIIlIlllIIIIlll() / 2.0F - var13 / 2.0F + 20.0F;
                        var16 = (float)var6;
                    } else {
                        var15 = 20.0F;
                        var16 = 0.0F;
                    }

                    if (!(Boolean)this.IIlllIllIlIllIllIIllIlIIl.llIlllIIIllllIIlllIllIIIl()) {
                        this.IIIlIIIIIIllIIIIllIIIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(var14, var3 + var15, var4 + var16, this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl());
                    } else {
                        int var17;
                        if (lIlIIlIlllIIlIIIlIlIlIllI.containsKey(var10.bridge$getPotionID())) {
                            var17 = (Integer)lIlIIlIlllIIlIIIlIlIlIllI.get(var10.bridge$getPotionID());
                        } else if (!var11.bridge$isBadEffect()) {
                            var17 = -15691760;
                        } else {
                            var17 = -7335920;
                        }

                        Ref.getFontRenderer().bridge$drawString(var14, var3 + var15, var4 + var16, var17, this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl());
                    }

                    if (var13 > var7 && var2) {
                        var7 = var13;
                    }
                }

                var14 = Bridge.IIlIllIlllllllIIlIIIllIIl().bridge$getDurationString(var10);
                var15 = Ref.getFontRenderer().bridge$getStringWidth(var14) + 20.0F;
                if (var12) {
                    if (var5 == Position.RIGHT) {
                        this.lIIlllIIIIIlllIIIlIlIlllI.lIlIlIlIlIIlIIlIIllIIIIIl(var14, var3 + this.lIIlIIlllIIIIlIlllIIIIlll() - var15, var4 + (float)var6 + (float)(this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() ? 10 : 5), this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl());
                    } else if (var5 == Position.LEFT) {
                        this.lIIlllIIIIIlllIIIlIlIlllI.lIlIlIlIlIIlIIlIIllIIIIIl(var14, var3 + 20.0F, var4 + (float)var6 + (float)(this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() ? 10 : 5), this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl());
                    } else if (var5 == Position.MIDDLE) {
                        this.lIIlllIIIIIlllIIIlIlIlllI.lIlIlIlIlIIlIIlIIllIIIIIl(var14, var3 + this.lIIlIIlllIIIIlIlllIIIIlll() / 2.0F - var15 / 2.0F + 20.0F, var4 + (float)var6 + (float)(this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() ? 10 : 5), this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl());
                    }
                }

                if (Bridge.getMinecraftVersion().lIlIlIlIlIIlIIlIIllIIIIIl()) {
                    if (var5 == Position.RIGHT) {
                        var10.lIlIlIlIlIIlIIlIIllIIIIIl(var3 + this.lIIlIIlllIIIIlIlllIIIIlll() - 20.0F, var4 + (float)var6);
                    } else if (var5 == Position.LEFT) {
                        var10.lIlIlIlIlIIlIIlIIllIIIIIl(var3, var4 + (float)var6);
                    } else if (var5 == Position.MIDDLE) {
                        var10.lIlIlIlIlIIlIIlIIllIIIIIl(var3 + this.lIIlIIlllIIIIlIlllIIIIlll() / 2.0F - var13 / 2.0F, var4 + (float)var6);
                    }
                } else if (var11.bridge$hasStatusIcon()) {
                    Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
                    Ref.getMinecraft().bridge$getTextureManager().bridge$bindTexture(this.lllIIIIIlllIIlIllIIlIIIlI);
                    int var18 = var11.bridge$getStatusIconIndex();
                    if (var5 == Position.RIGHT) {
                        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$texturedModalRect(var3 + this.lIIlIIlllIIIIlIlllIIIIlll() - 20.0F, var4 + (float)var6, var18 % 8 * 18, 198 + var18 / 8 * 18, 18, 18);
                    } else if (var5 == Position.LEFT) {
                        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$texturedModalRect(var3, var4 + (float)var6, var18 % 8 * 18, 198 + var18 / 8 * 18, 18, 18);
                    } else if (var5 == Position.MIDDLE) {
                        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$texturedModalRect(var3 + this.lIIlIIlllIIIIlIlllIIIIlll() / 2.0F - var13 / 2.0F, var4 + (float)var6, var18 % 8 * 18, 198 + var18 / 8 * 18, 18, 18);
                    }
                }

                if (var15 > var7) {
                    var7 = var15;
                }

                var6 += var8;
            }
        }

        this.IlllIIIIIIlllIlIIlllIlIIl(var7, (float)var6 - 4.0F);
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(PotionEffectBridge var1) {
        if (this.IlIIlIIlIIlIIllIIIllIIllI.llIlllIIIllllIIlllIllIIIl() && var1.bridge$getIsPotionDurationMax()) {
            return true;
        } else {
            switch(var1.bridge$getPotionID()) {
            case 1:
                return this.llIllIlIllIlllIllIIIIllII.llIlllIIIllllIIlllIllIIIl();
            case 2:
                return this.IllllllllllIlIIIlllIlllll.llIlllIIIllllIIlllIllIIIl();
            case 3:
                return this.lIlIlIIIIIIllIlIIIIllIIII.llIlllIIIllllIIlllIllIIIl();
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            default:
                return false;
            case 5:
                return this.lllllIllIlIIlIIlIIIlllIlI.llIlllIIIllllIIlllIllIIIl();
            case 8:
                return this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl();
            case 10:
                return this.IIlIllIlIIllIIlIlIllllllI.llIlllIIIllllIIlllIllIIIl();
            case 12:
                return this.lIIIlllIIIIllllIlIIIlIIll.llIlllIIIllllIIlllIllIIIl();
            case 13:
                return this.llIIIlIllIIIIlIIIlIlIllIl.llIlllIIIllllIIlllIllIIIl();
            case 14:
                return this.lIIlIIIIIIlIIlIIllIlIIlII.llIlllIIIllllIIlllIllIIIl();
            case 16:
                return this.llllIlIllllIlIlIIIllIlIlI.llIlllIIIllllIIlllIllIIIl();
            case 18:
                return this.IlIllIIlIIlIIIllIllllIIll.llIlllIIIllllIIlllIllIIIl();
            case 19:
                return this.lIllllIllIIlIIlIIIlIIIlII.llIlllIIIllllIIlllIllIIIl();
            }
        }
    }

    public boolean llIlllIIIllllIIlllIllIIIl(float var1) {
        if (this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl() && var1 <= (float)((Integer)this.lllllIIIIlIlllIllIIIlIIlI.llIlllIIIllllIIlllIllIIIl() * 22)) {
            if (this.IlIIIlIlIlIlIlIllIIllIIlI > 20) {
                this.IlIIIlIlIlIlIlIllIIllIIlI = 0;
            }

            return this.IlIIIlIlIlIlIlIllIIllIIlI <= 10;
        } else {
            return true;
        }
    }

    public String IlllIIIIIIlllIlIIlllIlIIl(int var1) {
        switch(var1) {
        case 1:
            return " II";
        case 2:
            return " III";
        case 3:
            return " IV";
        case 4:
            return " V";
        case 5:
            return " VI";
        case 6:
            return " VII";
        case 7:
            return " VIII";
        case 8:
            return " IX";
        case 9:
            return " X";
        default:
            return var1 > 9 ? " " + var1 + 1 : "";
        }
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(new SettingLabel("generalOptions"), this.lIlIIIIIIlIIIllllIllIIlII = new BooleanSetting("show_in_inventory", true), this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("display_typing", true), this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("effect_name", true), this.lIIlIlllIlIlIIIlllIIlIIII = new BooleanSetting("text_shadow", true), this.IIlIlIIIllIIllllIllllIlIl = new BooleanSetting("hide_modern_icons", true, () -> {
            return Bridge.getMinecraftVersion().llIlllIIIllllIIlllIllIIIl();
        }), new SettingLabel("blinkOptions"), this.IIlIllIlllllllIIlIIIllIIl = new BooleanSetting("blink", true), this.lllllIIIIlIlllIllIIIlIIlI = new NumberSetting("blink_duration", 10, 2, 20), new SettingLabel("colorOptions"), this.IIlllIllIlIllIllIIllIlIIl = new BooleanSetting("color_name_based_on_effect", false), this.IIIlIIIIIIllIIIIllIIIIlII = new ColorSetting("text", -1), this.lIIlllIIIIIlllIIIlIlIlllI = new ColorSetting("duration", -1), new SettingLabel("excludePotionEffects"), this.IlIIlIIlIIlIIllIIIllIIllI = new BooleanSetting("excludePerm", false), this.llIllIlIllIlllIllIIIIllII = new BooleanSetting("excludeSpeed", false), this.IllllllllllIlIIIlllIlllll = new BooleanSetting("excludeSlowness", false), this.lllllIllIlIIlIIlIIIlllIlI = new BooleanSetting("excludeStrength", false), this.IllIIIlllIIIlIlllIlIIlIII = new BooleanSetting("excludeJumpBoost", false), this.IIlIllIlIIllIIlIlIllllllI = new BooleanSetting("excludeRegen", false), this.lIIIlllIIIIllllIlIIIlIIll = new BooleanSetting("excludeFireRes", false), this.llIIIlIllIIIIlIIIlIlIllIl = new BooleanSetting("excludeWaterBreathing", false), this.llllIlIllllIlIlIIIllIlIlI = new BooleanSetting("excludeNightVision", false), this.IlIllIIlIIlIIIllIllllIIll = new BooleanSetting("excludeWeakness", false), this.lIllllIllIIlIIlIIIlIIIlII = new BooleanSetting("excludePoison", false), this.lIlIlIIIIIIllIlIIIIllIIII = new BooleanSetting("excludeHaste", false), this.lIIlIIIIIIlIIlIIllIlIIlII = new BooleanSetting("excludeInvis", false));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Potion Effects", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("potioneffects", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.HUD));
    }

    public BooleanSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public BooleanSetting IIIIIIIIIIIIIIIllllIIlIIl() {
        return this.IIlIlIIIllIIllllIllllIlIl;
    }
}
