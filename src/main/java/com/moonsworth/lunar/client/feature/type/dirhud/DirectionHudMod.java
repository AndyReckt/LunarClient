package com.moonsworth.lunar.client.feature.type.dirhud;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.feature.type.waypoints.Waypoint;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.profile.FriendProfile;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.setting.NumberSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import org.lwjgl.opengl.GL11;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class DirectionHudMod extends DraggableHudMod {
    public static final ResourceLocationBridge lllIIIIIlllIIlIllIIlIIIlI = Bridge.getInstance().initResourceLocation("lunar", "icons/compass.png");
    public final LCFontRenderer lIlIIIIIIlIIIllllIllIIlII = FontRegistry.llIIIlllIIlllIllllIlIllIl();
    public final LCFontRenderer llIlIIIllIIlIllIllIllllIl = FontRegistry.lllIIIIIlllIIlIllIIlIIIlI();
    public NumberSetting IllIllIIIllIIIlIlIlIIIIll;
    public final float IIlIllIlllllllIIlIIIllIIl = 300.0F;
    public BooleanSetting lIIlIlllIlIlIIIlllIIlIIII;
    public ColorSetting llIllIlIllIlllIllIIIIllII;
    public ColorSetting IllllllllllIlIIIlllIlllll;

    public DirectionHudMod() {
        super(true, HudModPosition.TOP_CENTER);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F, 4.0F);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        EntityPlayerSPBridge var4 = Ref.getPlayer();
        float var5 = var4 == null ? 0.0F : this.IlllIIIIIIlllIlIIlllIlIIl((int)var4.bridge$getRotationYaw());
        int var11;
        if (this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl()) {
            var5 = var4 == null ? 0.0F : (float)((int)Bridge.lIIlIlllIlIlIIIlllIIlIIII().bridge$floor_float((float)(Ref.getPlayer().bridge$getRotationYaw() * 256.0D / 360.0D + 0.5D)) & 255);
            var11 = this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(var2 + var3);
            this.mc.bridge$getTextureManager().bridge$bindTexture(lllIIIIIlllIIlIllIIlIIIlI);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableAlpha();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$tryBlendFuncSeparate(770, 771, 1, 0);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$shadeModel(7425);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
            if (var5 < 128.0F) {
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3, (int)var5, 0, 65, 12);
            } else {
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3, (int)(var5 - 128.0F), 12, 65, 12);
            }

            GL11.glColor4f((float)(var11 >> 16 & 255) / 255.0F, (float)(var11 >> 8 & 255) / 255.0F, (float)(var11 & 255) / 255.0F, 1.0F);
            if (var5 < 128.0F) {
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3, (int)var5, 24, 65, 12);
            } else {
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3, (int)(var5 - 128.0F), 36, 65, 12);
            }

            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$shadeModel(7424);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableAlpha();
            this.IllllllllllIlIIIlllIlllll.llIlllIIIllllIIlllIllIIIl("|", var2 + 32.0F, var3 + 1.0F);
            this.IllllllllllIlIIIlllIlllll.llIlllIIIllllIIlllIllIIIl("|", var2 + 32.0F, var3 + 5.0F);
            this.IlllIIIIIIlllIlIIlllIlIIl(65.0F, 12.0F);
        } else {
            float var6 = (Float)this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() / 2.0F;
            float var7 = -2.0F;
            this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl(String.format("%d", (int)var5), var2 + var6 + 0.5F, var3 + var7, 805306368);
            this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl(String.format("%d", (int)var5), var2 + var6, var3 + var7 + 0.5F, -1);
            var7 += (float)(this.llIlIIIllIIlIllIllIllllIl.getHeight() * 3) + 1.0F;
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var2 + var6, var3 + var7, 6.0F, -1);
            this.IlllIIIIIIlllIlIIlllIlIIl((Float)this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl(), 32.0F);
            Iterator<Waypoint> var8 = LunarClient.getInstance().llIllIlIllIlllIllIIIIllII().llIlllIIIllllIIlllIllIIIl().iterator();

            while(var8.hasNext()) {
                Waypoint var9 = var8.next();
                if (var9.isVisible() && var9.lIlIlIlIlIIlIIlIIllIIIIIl()) {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var9, var2 + var6, var3 + var7, var5);
                }
            }

            Iterator<FriendProfile> friendProfileIterator = LunarClient.getInstance().getFriendRegistry().llIlllIIIllllIIlllIllIIIl().values().iterator();

            while(friendProfileIterator.hasNext()) {
                FriendProfile var12 = friendProfileIterator.next();
                Optional<EntityPlayerBridge> var10 = this.mc.bridge$getWorld().bridge$getPlayerByUniqueId(var12.lIllIlIIIlIIIIIIIlllIlIll());
                if (!var10.isPresent()) {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var12.llIlIIIllIIlIllIllIllllIl().bridge$xCoord(), var12.llIlIIIllIIlIllIllIllllIl().bridge$zCoord(), var12.lIlIIIIIIlIIIllllIllIIlII(), var6, var5, var2, var3);
                } else if (var10.get() != this.mc.bridge$getPlayer()) {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var10.get().bridge$getPosX(), var10.get().bridge$getPosZ(), var12.lIlIIIIIIlIIIllllIllIIlII(), var6, var5, var2, var3);
                }
            }

            var7 += 8.0F;

            for(var11 = 0; var11 <= 360; var11 += 15) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(var6, var7, (Float)this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl(), var11, var5, var2, var3);
            }

        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerSPBridge var1, Waypoint var2, float var3, float var4, float var5) {
        float var6 = (float)(var1.bridge$getPosX() - var2.getLocation().bridge$xCoord());
        float var7 = (float)(var1.bridge$getPosZ() - var2.getLocation().bridge$zCoord());
        float var8 = (float)(Math.atan2(var7, var6) * 180.0D / 3.141592653589793D + 90.0D);
        float var9 = 300.0F * var8 / 360.0F - 300.0F * var5 / 360.0F;
        if (var9 > 150.0F) {
            var9 -= 300.0F;
        }

        if (var9 < -150.0F) {
            var9 += 300.0F;
        }

        int var10 = 255 - (int)(Math.abs(var9) / ((Float)this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() / 2.0F) * 255.0F);
        if (var10 >= 35) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var3 + var9, var4, 6.0F, var10 << 24 | var2.getColor().lIlIlIlIlIIlIIlIIllIIIIIl(var3 + var4) & 16777215);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(EntityPlayerSPBridge var1, double var2, double var4, int var6, float var7, float var8, float var9, float var10) {
        float var11 = (float)(var1.bridge$getPosX() - var2);
        float var12 = (float)(var1.bridge$getPosZ() - var4);
        float var13 = (float)(Math.atan2(var12, var11) * 180.0D / 3.141592653589793D + 90.0D);
        float var14 = 300.0F * var13 / 360.0F - 300.0F * var8 / 360.0F;
        if (var14 > 150.0F) {
            var14 -= 300.0F;
        }

        if (var14 < -150.0F) {
            var14 += 300.0F;
        }

        int var15 = 255 - (int)(Math.abs(var14) / ((Float)this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() / 2.0F) * 255.0F);
        if (var15 >= 35) {
            GlStateManagerBridge var16 = Bridge.llIIIIIIIllIIllIlIllIIIIl();
            var16.bridge$enableBlend();
            var16.bridge$disableTexture2D();
            var16.bridge$blendFunc(770, 771);
            byte var17 = 6;
            byte var18 = 8;
            int var19 = -4 - var18;
            float var20 = (float)(var6 >> 16 & 255) / 255.0F;
            float var21 = (float)(var6 >> 8 & 255) / 255.0F;
            float var22 = (float)(var6 & 255) / 255.0F;
            var16.bridge$color(var20, var21, var22, 0.75F);
            var16.bridge$pushMatrix();
            var16.bridge$translate(var9 + var7 + var14, var10 + 18.0F, 0.0F);
            var16.bridge$scale(0.5D, 0.5D, 0.5D);
            var16.bridge$translate(-20.0F, 0.0F, 0.0F);
            var16.bridge$rotate(45.0F, 0.0F, 0.0F, 1.0F);
            var16.bridge$translate((float)(var17 * 2), 0.0F, 0.0F);
            var16.bridge$rotate(90.0F, 0.0F, 0.0F, -1.0F);
            var16.bridge$rotate(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glBegin(7);
            GL11.glVertex3f(var17, (float)var19 + (float)var18 / 2.0F, 0.0F);
            GL11.glVertex3f(var17, (float)var19, 0.0F);
            GL11.glVertex3f((float)(-var17), (float)var19, 0.0F);
            GL11.glVertex3f((float)(-var17), (float)var19 + (float)var18 / 2.0F, 0.0F);
            GL11.glEnd();
            var16.bridge$rotate(90.0F, 0.0F, 0.0F, -1.0F);
            var16.bridge$translate((float)(var17 * 2) + 3.0F, (float)var18 / 2.0F + 2.0F, 0.0F);
            GL11.glBegin(7);
            GL11.glVertex3f((float)(var17 - 1), (float)var19 + (float)var18 / 2.0F, 0.0F);
            GL11.glVertex3f((float)(var17 - 1), (float)var19, 0.0F);
            GL11.glVertex3f((float)(-var17) / 2.0F, (float)var19, 0.0F);
            GL11.glVertex3f((float)(-var17) / 2.0F, (float)var19 + (float)var18 / 2.0F, 0.0F);
            GL11.glEnd();
            var16.bridge$popMatrix();
            var16.bridge$enableTexture2D();
            var16.bridge$disableBlend();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, int var4, float var5, float var6, float var7) {
        int var8 = var4 % 90;
        int var9 = var4 % 45;
        float var10 = 300.0F * (float)var4 / 360.0F - 300.0F * var5 / 360.0F;
        if (var10 > 150.0F) {
            var10 -= 300.0F;
        }

        if (var10 < -150.0F) {
            var10 += 300.0F;
        }

        int var11 = 255 - (int)(Math.abs(var10) / (var3 / 2.0F) * 255.0F);
        if (var11 >= 35) {
            int var12 = Math.max(35, var11) << 24 | 16777215;
            if (var8 == 0) {
                AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(var6 + var1 + var10 - 0.5F, var7 + var2, 1.0F, 8.0F, var12);
                switch(var4) {
                case 0:
                case 360:
                    this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl("S", var6 + var1 + var10, var7 + var2 + 10.0F, var12);
                    break;
                case 90:
                    this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl("W", var6 + var1 + var10, var7 + var2 + 10.0F, var12);
                    break;
                case 180:
                    this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl("N", var6 + var1 + var10, var7 + var2 + 10.0F, var12);
                    break;
                case 270:
                    this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl("E", var6 + var1 + var10, var7 + var2 + 10.0F, var12);
                }
            } else if (var9 == 0) {
                switch(var4) {
                case 45:
                    this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl("SW", var6 + var1 + var10, var7 + var2, var12);
                    break;
                case 135:
                    this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl("NW", var6 + var1 + var10, var7 + var2, var12);
                    break;
                case 225:
                    this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl("NE", var6 + var1 + var10, var7 + var2, var12);
                    break;
                case 315:
                    this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl("SE", var6 + var1 + var10, var7 + var2, var12);
                }
            } else {
                AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(var6 + var1 + var10 - 0.25F, var7 + var2, 0.5F, 5.0F, var12);
                this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl("" + var4, var6 + var1 + var10 - 0.5F, var7 + var2 + 6.0F, var12);
            }

        }
    }

    public float IlllIIIIIIlllIlIIlllIlIIl(int var1) {
        int var2 = var1;
        if (var1 < 0) {
            while(var2 < 0) {
                var2 += 360;
            }
        } else if (var1 > 360) {
            while(var2 > 360) {
                var2 -= 360;
            }
        }

        return (float)var2;
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.lIIlIlllIlIlIIIlllIIlIIII = new BooleanSetting("useLegacyStyle", false), this.IllIllIIIllIIIlIlIlIIIIll = new NumberSetting("width", 300.0F, 100.0F, 375.0F, 0, () -> {
            return this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl();
        }), this.llIllIlIllIlllIllIIIIllII = new ColorSetting("directionColor", -1, () -> {
            return !(Boolean)this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl();
        }), this.IllllllllllIlIIIlllIlllll = new ColorSetting("markerColor", -43691, () -> {
            return !(Boolean)this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl();
        }));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        double var8 = Ref.getPlayer() == null ? 0.0D : Ref.getPlayer().bridge$getRotationYaw();
        float var10 = this.IlllIIIIIIlllIlIIlllIlIIl((int)var8);

        for(int var11 = 0; var11 <= 360; var11 += 15) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(var1 + var3 / 2.0F, var2 + var4 / 2.0F, var3 - 10.0F, var11, var10, 0.0F, 0.0F);
        }

        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var1 + var3 / 2.0F, var2 + var4 / 2.0F - 10.0F, 6.0F, -1);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("directionhud", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.HUD));
    }
}
