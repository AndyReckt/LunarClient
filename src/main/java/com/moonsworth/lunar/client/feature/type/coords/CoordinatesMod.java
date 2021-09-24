package com.moonsworth.lunar.client.feature.type.coords;

import com.google.common.collect.ImmutableList;

import com.moonsworth.lunar.bridge.minecraft.util.Vector3i;
import com.moonsworth.lunar.bridge.minecraft.world.biome.BiomeGenBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.world.biome.BiomeType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.feature.type.armor.ListMode;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.*;
import com.moonsworth.lunar.client.util.MathHelperUtil;

import java.util.List;

public class CoordinatesMod extends DraggableHudMod {
    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI;
    public BooleanSetting lIlIIIIIIlIIIllllIllIIlII;
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;
    public BooleanSetting IIlIllIlllllllIIlIIIllIIl;
    public BooleanSetting lIIlIlllIlIlIIIlllIIlIIII;
    public BooleanSetting llIllIlIllIlllIllIIIIllII;
    public NumberSetting IllllllllllIlIIIlllIlllll;
    public ColorSetting lllllIllIlIIlIIlIIIlllIlI;
    public ColorSetting IllIIIlllIIIlIlllIlIIlIII;
    public ColorSetting IIlIllIlIIllIIlIlIllllllI;
    public ColorSetting lIIIlllIIIIllllIlIIIlIIll;
    public ColorSetting llIIIlIllIIIIlIIIlIlIllIl;
    public ColorSetting llllIlIllllIlIlIIIllIlIlI;
    public ColorSetting IlIllIIlIIlIIIllIllllIIll;
    public ColorSetting lIllllIllIIlIIlIIIlIIIlII;
    public ColorSetting lIlIlIIIIIIllIlIIIIllIIII;
    public ColorSetting lIIlIIIIIIlIIlIIllIlIIlII;
    public ColorSetting IlIIlIIlIIlIIllIIIllIIllI;
    public ColorSetting IIlIlIIIllIIllllIllllIlIl;
    public BooleanSetting lllllIIIIlIlllIllIIIlIIlI;
    public BooleanSetting IIlllIllIlIllIllIIllIlIIl;
    public BooleanSetting lIlIIlIlllIIlIIIlIlIlIllI;
    public BooleanSetting lIIlllIIIIIlllIIIlIlIlllI;
    public ColorSetting IIIlIIIIIIllIIIIllIIIIlII;
    public ColorSetting IlIIIlIlIlIlIlIllIIllIIlI;
    public ColorSetting IlIlIllIIllllIllllllIIlIl;
    public EnumSetting<ListMode> lIIlIIlllIIIIlIlllIIIIlll;

    public CoordinatesMod() {
        super(true, HudModPosition.TOP_LEFT);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(10.0F, 24.0F);
    }

    public List<AbstractSetting<?>> IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(new SettingLabel("generalOptions"), this.lIIlIIlllIIIIlIlllIIIIlll = new EnumSetting<>("mode", ListMode.lIlIlIlIlIIlIIlIIllIIIIIl), this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("background", true), this.lIlIIIIIIlIIIllllIllIIlII = new BooleanSetting("text_shadow", true), this.lllIIIIIlllIIlIllIIlIIIlI = new BooleanSetting("show_while_typing", true), this.IIlIllIlllllllIIlIIIllIIl = new BooleanSetting("border", false), this.IllllllllllIlIIIlllIlllll = new NumberSetting("border_thickness", 0.5F, 0.5F, 3.0F), new SettingLabel("renderOptions"), this.llIllIlIllIlllIllIIIIllII = new BooleanSetting("show_c", false), this.lIIlIlllIlIlIIIlllIIlIIII = new BooleanSetting("show_labels", true), this.IIlllIllIlIllIllIIllIlIIl = new BooleanSetting("show_biome", true, () -> {
            return this.lIIlIIlllIIIIlIlllIIIIlll.llIlllIIIllllIIlllIllIIIl() == ListMode.IlllIIIIIIlllIlIIlllIlIIl;
        }), this.lIlIIlIlllIIlIIIlIlIlIllI = new BooleanSetting("biome_coordinates", true, () -> {
            return this.lIIlIIlllIIIIlIlllIIIIlll.llIlllIIIllllIIlllIllIIIl() == ListMode.IlllIIIIIIlllIlIIlllIlIIl && this.IIlllIllIlIllIllIIllIlIIl.llIlllIIIllllIIlllIllIIIl();
        }), new AbstractSetting<?>[] {this.lIIlllIIIIIlllIIIlIlIlllI = new BooleanSetting("biome_color", true, () -> {
                return this.lIIlIIlllIIIIlIlllIIIIlll.llIlllIIIllllIIlllIllIIIl() == ListMode.IlllIIIIIIlllIlIIlllIlIIl && this.IIlllIllIlIllIllIIllIlIIl.llIlllIIIllllIIlllIllIIIl();
            }), this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("direction", true), this.lllllIIIIlIlllIllIIIlIIlI = new BooleanSetting("directionAffect", true), new SettingLabel("colorOptions"), this.IIlIllIlIIllIIlIlIllllllI = new ColorSetting("text_coordinates", -1), this.lllllIllIlIIlIIlIIIlllIlI = new ColorSetting("background", 1862270976), this.IllIIIlllIIIlIlllIlIIlIII = new ColorSetting("border", -1627389952), new ButtonsSetting("applyToAll", (var1, var2, var3) -> {
                this.lIIIlllIIIIllllIlIIIlIIll.IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlIIllIIlIlIllllllI);
                this.llIIIlIllIIIIlIIIlIlIllIl.IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlIIllIIlIlIllllllI);
                this.llllIlIllllIlIlIIIllIlIlI.IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlIIllIIlIlIllllllI);
                this.IlIllIIlIIlIIIllIllllIIll.IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlIIllIIlIlIllllllI);
                this.lIllllIllIIlIIlIIIlIIIlII.IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlIIllIIlIlIllllllI);
                this.lIlIlIIIIIIllIlIIIIllIIII.IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlIIllIIlIlIllllllI);
                this.lIIlIIIIIIlIIlIIllIlIIlII.IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlIIllIIlIlIllllllI);
                this.IlIIlIIlIIlIIllIIIllIIllI.IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlIIllIIlIlIllllllI);
                this.IIlIlIIIllIIllllIllllIlIl.IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlIIllIIlIlIllllllI);
                this.IlIIIlIlIlIlIlIllIIllIIlI.IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlIIllIIlIlIllllllI);
                this.IIIlIIIIIIllIIIIllIIIIlII.IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlIIllIIlIlIllllllI);
                this.IlIlIllIIllllIllllllIIlIl.IlllIIIIIIlllIlIIlllIlIIl(this.IIlIllIlIIllIIlIlIllllllI);
                return true;
            }), this.llIIIlIllIIIIlIIIlIlIllIl = new ColorSetting("x_label_color", -1, () -> {
                return !(Boolean) this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl();
            }), this.lIIIlllIIIIllllIlIIIlIIll = new ColorSetting("x_axis_color", -1), this.IlIllIIlIIlIIIllIllllIIll = new ColorSetting("y_label_color", -1, () -> {
                return !(Boolean) this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl();
            }), this.llllIlIllllIlIlIIIllIlIlI = new ColorSetting("y_axis_color", -1), this.lIlIlIIIIIIllIlIIIIllIIII = new ColorSetting("z_label_color", -1, () -> {
                return !(Boolean) this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl();
            }), this.lIllllIllIIlIIlIIIlIIIlII = new ColorSetting("z_axis_color", -1), this.IlIIlIIlIIlIIllIIIllIIllI = new ColorSetting("c_label_color", -1, () -> {
                return !(Boolean) this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl() || !(Boolean) this.llIllIlIllIlllIllIIIIllII.llIlllIIIllllIIlllIllIIIl();
            }), this.lIIlIIIIIIlIIlIIllIlIIlII = new ColorSetting("c_axis_color", -1, () -> {
                return !(Boolean) this.llIllIlIllIlllIllIIIIllII.llIlllIIIllllIIlllIllIIIl();
            }), this.IIlIlIIIllIIllllIllllIlIl = new ColorSetting("direction_color", -1), this.IlIlIllIIllllIllllllIIlIl = new ColorSetting("direction_affect_color", -1, () -> {
                return this.lllllIIIIlIlllIllIIIlIIlI.llIlllIIIllllIIlllIllIIIl();
            }), this.IlIIIlIlIlIlIlIllIIllIIlI = new ColorSetting("biomeColor_color", -1, () -> {
                return this.lIIlIIlllIIIIlIlllIIIIlll.llIlllIIIllllIIlllIllIIIl() == ListMode.IlllIIIIIIlllIlIIlllIlIIl;
            }), this.IIIlIIIIIIllIIIIllIIIIlII = new ColorSetting("biomeLabelColor_color", -1, () -> {
                return this.lIIlIIlllIIIIlIlllIIIIlll.llIlllIIIllllIIlllIllIIIl() == ListMode.IlllIIIIIIlllIlIIlllIlIIl || !(Boolean) this.IIlllIllIlIllIllIIllIlIIl.llIlllIIIllllIIlllIllIIIl() || !(Boolean) this.lIlIIlIlllIIlIIIlIlIlIllI.llIlllIIIllllIIlllIllIIIl();
            })
        });
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        if (Ref.getWorld() == null) {
            short var4 = 500;
            byte var5 = 62;
            short var6 = 250;
            this.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var5, var6, 180.0F, new Vector3i(var4, var5, var6), 92, 4269, var2, var3);
        } else {
            super.IlllIIIIIIlllIlIIlllIlIIl(var1, var2, var3);
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        int var4 = MathHelperUtil.IlllIIIIIIlllIlIIlllIlIIl(Ref.getPlayer().bridge$getPosX());
        int var5 = (int) Ref.getPlayer().bridge$getBoundingBox().bridge$getMinY();
        int var6 = MathHelperUtil.IlllIIIIIIlllIlIIlllIlIIl(Ref.getPlayer().bridge$getPosZ());
        Vector3i var7 = new Vector3i(var4, var5, var6);
        int var8 = Ref.getMinecraft().bridge$getRenderGlobal().bridge$getMaximumRenderCount();
        int var9 = Ref.getMinecraft().bridge$getRenderGlobal().bridge$getUnculledRenderCount();
        this.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var5, var6, (float) this.mc.bridge$getPlayer().bridge$getRotationYaw(), var7, var9, var8, var2, var3);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int var1, int var2, int var3, float var4, Vector3i var5, int var6, int var7, float var8, float var9) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(var8, var9, 0.0F);
        float var10;
        if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
            this.lllllIllIlIIlIIlIIIlllIlI.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F, 0.0F, this.llIIIIIIIllIIllIlIllIIIIl, this.lIIIllIllIIllIlllIlIIlllI);
            if (this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl()) {
                var10 = (Float) this.IllllllllllIlIIIlllIlllll.llIlllIIIllllIIlllIllIIIl();
                this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F, -var10, this.llIIIIIIIllIIllIlIllIIIIl, var10);
                this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F, this.lIIIllIllIIllIlllIlIIlllI, this.llIIIIIIIllIIllIlIllIIIIl, var10);
                this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F - var10, -var10, var10, this.lIIIllIllIIllIlllIlIIlllI + var10 * 2.0F);
                this.IllIIIlllIIIlIlllIlIIlIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIIIIIIllIIllIlIllIIIIl, -var10, var10, this.lIIIllIllIIllIlllIlIIlllI + var10 * 2.0F);
            }
        }

        if (!Ref.getMinecraft().bridge$getGuiIngame().bridge$getChatGUI().bridge$getChatOpen() || this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl()) {
            var10 = 0.0F;
            float var11 = 0.0F;
            float var12;
            if (this.lIIlIIlllIIIIlIlllIIIIlll.llIlllIIIllllIIlllIllIIIl() == ListMode.IlllIIIIIIlllIlIIlllIlIIl) {
                var12 = this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() ? 3.0F : 0.0F;
                var10 = 5.0F;
                if (!(Boolean) this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
                    var10 = this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl("(", var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                }

                String[] var20 = new String[] {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
                double var21 = (double) MathHelperUtil.lIlIlIlIlIIlIIlIIllIIIIIl(var4) + 180.0D;
                var21 += 22.5D;
                var21 %= 360.0D;
                var21 /= 45.0D;
                String var23 = var20[MathHelperUtil.IlllIIIIIIlllIlIIlllIlIIl(var21)];
                var10 = this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl() ? this.llIIIlIllIIIIlIIIlIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl("X: ", var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) : var10;
                var10 = this.lIIIlllIIIIllllIlIIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(String.valueOf(var1), var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                if (this.lllllIIIIlIlllIllIIIlIIlI.llIlllIIIllllIIlllIllIIIl() && (var23.contains("W") || var23.contains("E"))) {
                    var10 = this.IlIlIllIIllllIllllllIIlIl.lIlIlIlIlIIlIIlIIllIIIIIl(var23.contains("W") ? " (-)" : " (+)", var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                }

                var10 = this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl(", ", var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                var10 = this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl() ? this.IlIllIIlIIlIIIllIllllIIll.lIlIlIlIlIIlIIlIIllIIIIIl("Y: ", var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) : var10;
                var10 = this.llllIlIllllIlIlIIIllIlIlI.lIlIlIlIlIIlIIlIIllIIIIIl(String.valueOf(var2), var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                var10 = this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl(", ", var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                var10 = this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl() ? this.lIlIlIIIIIIllIlIIIIllIIII.lIlIlIlIlIIlIIlIIllIIIIIl("Z: ", var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) : var10;
                var10 = this.lIllllIllIIlIIlIIIlIIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(String.valueOf(var3), var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                if (this.lllllIIIIlIlllIllIIIlIIlI.llIlllIIIllllIIlllIllIIIl() && (var23.contains("N") || var23.contains("S"))) {
                    var10 = this.IlIlIllIIllllIllllllIIlIl.lIlIlIlIlIIlIIlIIllIIIIIl(var23.contains("N") ? " (-)" : " (+)", var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                }

                var10 = this.llIllIlIllIlllIllIIIIllII.llIlllIIIllllIIlllIllIIIl() ? this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl(", ", var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) : var10;
                if (this.llIllIlIllIlllIllIIIIllII.llIlllIIIllllIIlllIllIIIl()) {
                    var10 = this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl() ? this.IlIIlIIlIIlIIllIIIllIIllI.lIlIlIlIlIIlIIlIIllIIIIIl("C: ", var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) : var10;
                    var10 = this.lIIlIIIIIIlIIlIIllIlIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(var6 + "/" + var7, var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                }

                if (!(Boolean) this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
                    var10 = this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl(")", var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                } else {
                    var11 += 4.0F;
                }

                if (this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl()) {
                    var10 = this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl(" " + var23, var10, var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                }

                var11 += (float) Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl();
            } else {
                var10 = 35.0F;
                var11 = 5.0F;
                var12 = 0.0F;
                float var13 = 0.0F;
                float var14 = 0.0F;
                float var15 = this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl() ? this.llIIIlIllIIIIlIIIlIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl("X: ", 5.0F, var11, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) : 5.0F;
                var10 = Math.max(var10, this.lIIIlllIIIIllllIlIIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(String.valueOf(var1), var15, var11, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()));
                var13 = var11;
                var11 += (float) (Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() + 2);
                var15 = this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl() ? this.IlIllIIlIIlIIIllIllllIIll.lIlIlIlIlIIlIIlIIllIIIIIl("Y: ", 5.0F, var11, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) : 5.0F;
                var10 = Math.max(var10, this.llllIlIllllIlIlIIIllIlIlI.lIlIlIlIlIIlIIlIIllIIIIIl(String.valueOf(var2), var15, var11, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()));
                var12 = var11;
                var11 += (float) (Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() + 2);
                var15 = this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl() ? this.lIlIlIIIIIIllIlIIIIllIIII.lIlIlIlIlIIlIIlIIllIIIIIl("Z: ", 5.0F, var11, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) : 5.0F;
                var10 = Math.max(var10, this.lIllllIllIIlIIlIIIlIIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(String.valueOf(var3), var15, var11, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()));
                var14 = var11;
                var11 += (float) (Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() + 2);
                if (this.llIllIlIllIlllIllIIIIllII.llIlllIIIllllIIlllIllIIIl()) {
                    var15 = this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl() ? this.IlIIlIIlIIlIIllIIIllIIllI.lIlIlIlIlIIlIIlIIllIIIIIl("C: ", 5.0F, var11, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) : 5.0F;
                    var10 = Math.max(var10, this.lIIlIIIIIIlIIlIIllIlIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(var6 + "/" + var7, var15, var11, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()));
                    var11 += (float) (Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() + 2);
                }

                if (this.IIlllIllIlIllIllIIllIlIIl.llIlllIIIllllIIlllIllIIIl()) {
                    var15 = this.lIlIIlIlllIIlIIIlIlIlIllI.llIlllIIIllllIIlllIllIIIl() ? this.IIIlIIIIIIllIIIIllIIIIlII.lIlIlIlIlIIlIIlIIllIIIIIl("Biome: ", 5.0F, var11, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) : 5.0F;
                    BiomeGenBaseBridge var16 = Ref.getWorld() != null ? this.mc.bridge$getWorld().bridge$getChunkFromBlockCoords(var5).bridge$getBiome(var5, this.mc.bridge$getWorld().bridge$getWorldChunkManager()) : null;
                    BiomeType var17 = BiomeType.lIlIlIlIlIIlIIlIIllIIIIIl(var16);
                    int var18 = this.IlIIIlIlIlIlIlIllIIllIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(var8 + var9);
                    if (this.lIIlllIIIIIlllIIIlIlIlllI.llIlllIIIllllIIlllIllIIIl()) {
                        var18 = lIlIlIlIlIIlIIlIIllIIIIIl(var17);
                    }

                    var10 = Math.max(var10, Ref.getFontRenderer().bridge$drawString(var17.IlllIIIIIIlllIlIIlllIlIIl(), var15, var11, var18, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()));
                    var11 += (float) (Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() + 2);
                }

                String[] var22 = new String[] {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
                double var24 = (double) MathHelperUtil.lIlIlIlIlIIlIIlIIllIIIIIl(var4) + 180.0D;
                var24 += 22.5D;
                var24 %= 360.0D;
                var24 /= 45.0D;
                String var19 = var22[MathHelperUtil.IlllIIIIIIlllIlIIlllIlIIl(var24)];
                if (this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl()) {
                    var10 += 20.0F;
                    if (var11 == 0.0F) {
                        var11 = (float) (Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() + 2);
                    }

                    this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl(var19, var10 - Ref.getFontRenderer().bridge$getStringWidth(var19), var12, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                }

                if (this.lllllIIIIlIlllIllIIIlIIlI.llIlllIIIllllIIlllIllIIIl() && !this.lllllIIIIlIlllIllIIIlIIlI.llIllIlIllIlllIllIIIIllII().getAsBoolean()) {
                    if (!(Boolean) this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl()) {
                        var10 += 20.0F;
                        if (var11 == 0.0F) {
                            var11 = (float) (Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() + 2);
                        }
                    }

                    if (this.lllllIIIIlIlllIllIIIlIIlI.llIlllIIIllllIIlllIllIIIl() && (var19.contains("W") || var19.contains("E"))) {
                        this.IlIlIllIIllllIllllllIIlIl.lIlIlIlIlIIlIIlIIllIIIIIl(var19.contains("W") ? "-" : "+", var10 - Ref.getFontRenderer().bridge$getStringWidth("-"), var13, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                    }

                    if (this.lllllIIIIlIlllIllIIIlIIlI.llIlllIIIllllIIlllIllIIIl() && (var19.contains("N") || var19.contains("S"))) {
                        this.IlIlIllIIllllIllllllIIlIl.lIlIlIlIlIIlIIlIIllIIIIIl(var19.contains("N") ? "-" : "+", var10 - Ref.getFontRenderer().bridge$getStringWidth("-"), var14, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
                    }
                }

                if (!(Boolean) this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
                    var11 += 8.0F;
                } else {
                    var11 += 2.0F;
                }
            }

            this.IlllIIIIIIlllIlIIlllIlIIl(var10 + 5.0F, var11);
        }

        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(-var8, -var9, 0.0F);
    }

    public static int lIlIlIlIlIIlIIlIIllIIIIIl(BiomeType var0) {
        switch (var0) {
        case IIllllIIlllIlIIlIIlllIlII:
            return -32787;
        case IllIlIIllIIlllIIllIlIlIII:
            return -10240;
        case lIlIlIlIlIIlIIlIIllIIIIIl:
        case llIIIlIllIIIIlIIIlIlIllIl:
        case lIIIllIllIIllIlllIlIIlllI:
            return -16752657;
        case IlllIIIIIIlllIlIIlllIlIIl:
            return -10510539;
        case lIllIlIIIlIIIIIIIlllIlIll:
        case lIIlIlllIlIlIIIlllIIlIIII:
        case IlIlllIIIIIllIIllIllIIlll:
        case IIlIllIlllllllIIlIIIllIIl:
            return -1516367;
        case llIlllIIIllllIIlllIllIIIl:
        case lllllIllIlIIlIIlIIIlllIlI:
        case lIlIIlIlllIIlIIIlIlIlIllI:
        case llllIlIllllIlIlIIIllIlIlI:
        case IllllIIllllIllIIIIlllllII:
        case IIllIIlIIIlIlIlIlIIllIllI:
            return -7368817;
        case llllIIlIIlIIlIIllIIlIIllI:
        case llIllIlIllIlllIllIIIIllII:
            return -11629531;
        case IlIlIlllllIlIIlIlIlllIlIl:
        case IllllllllllIlIIIlllIlllll:
        case IllIlIIlllIIlIIllIIIIIIIl:
        case IIlllIllIIlllllIllllllIII:
        case IlIlIIllllllIIlIIllIIllIl:
        case lllllIIIIlIlllIllIIIlIIlI:
        case IIlllIllIlIllIllIIllIlIIl:
            return -11637939;
        case llIIIIIIIllIIllIlIllIIIIl:
        case IllIllIllIIlIlllIIlllIIll:
            return -12295900;
        case IlllllIlIIIlIIlIIllIIlIll:
        case llllIIlIllllllIIllIllIlII:
            return -7729393;
        case lIlIIllIIIlIIIlIIIlIIlIll:
            return -10270148;
        case IIlIIIlIlIlIlIllIlIlIIlll:
            return -15758473;
        case IIIIlIIlIIIIllIlIlIIIlIlI:
            return -11118485;
        case llIllIIIIlIIIIIIlllIllIlI:
        case lIlIIIIIllIIlIIlIIlIlIIlI:
        case IIllIlIllIlIllIllIllIllII:
        case IlIlllIlIlllIllIIIIIIlllI:
        case llIIlIlIIIllIlIlIlIIlIIll:
        case lllllIlIllIlIlllIIIlIIlIl:
            return -9568091;
        case llIIIlllIIlllIllllIlIllIl:
        case lllllIllIllIllllIlIllllII:
        case IlIIIIlllIllllIlIlIllIlII:
        case lIlIIIIIIlIIIllllIllIIlII:
        case IlIllIIlIIlIIIllIllllIIll:
        case IlIIlIIlIIlIIllIIIllIIllI:
        case IIlIlIIIllIIllllIllllIlIl:
        case IIIlIlIllIlIlIIIIIlIllIII:
        case lllIIIIIlllIIlIllIIlIIIlI:
        case IIIIIIIIIIIIIIIllllIIlIIl:
        case IlIlIlIlIIIlIIlIIlllIllIl:
        case lIIIlIllllIIlIIlIIlIIIIlI:
            return -6308109;
        case llIlIIIllIIlIllIllIllllIl:
        case IllIllIIIllIIIlIlIlIIIIll:
            return -9080700;
        case IllIIIlllIIIlIlllIlIIlIII:
        case lIIIlllIIIIllllIlIIIlIIll:
        case IIlIllIlIIllIIlIlIllllllI:
        case lIlIIIlIIlIIIlIIIlllIlIII:
        case IlIllIIlIIlIlIIlIIlIllIll:
            return -14913786;
        case lIllllIllIIlIIlIIIlIIIlII:
        case lIlIlIIIIIIllIlIIIIllIIII:
        case lIlllllIIlllIllIIlIIlIlll:
        case lIIlIIllIlIIlIIllIIIIlIIl:
            return -3223858;
        case lIIlIIIIIIlIIlIIllIlIIlII:
        case IllIIlllIllIlllllIlIllIll:
            return -13145823;
        case lIIlllIIIIIlllIIIlIlIlllI:
        case IIIlIIIIIIllIIIIllIIIIlII:
        case llIllllIlIIlIIIIllIllIIll:
        case lIllIllIllIIIlllIIIlllllI:
            return -8225734;
        case IlIIIlIlIlIlIlIllIIllIIlI:
        case lIIlIIlllIIIIlIlllIIIIlll:
        case IlIIlllIIllIIlIlIlIlIIlll:
        case lllIIIIllIllIlIIlllIIllII:
        case IlllIIIlIllIIIlIIllllllIl:
        case IlIlIllIIllllIllllllIIlIl:
            return -5022683;
        case llllIlIlIIIllllIIlIllIlII:
        case llIIIllllIIIllIIIIlIlIlll:
        case IIIIlIllIllIlIIIIIlIlIlIl:
        case llIIIIllIlIIlIlIIlllIllIl:
            return -16711727;
        case IlllllIlIlIlIIIIIllllIlIl:
        case lIIllllIllIllllllllIlllII:
            return -9925062;
        default:
            return -1118465;
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Coordinates", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("coords", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.HUD));
    }
}
