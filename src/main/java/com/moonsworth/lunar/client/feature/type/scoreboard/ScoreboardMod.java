package com.moonsworth.lunar.client.feature.type.scoreboard;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import com.moonsworth.lunar.bridge.minecraft.scoreboard.ScoreBridge;
import com.moonsworth.lunar.bridge.minecraft.scoreboard.ScoreObjectiveBridge;
import com.moonsworth.lunar.bridge.minecraft.scoreboard.ScorePlayerTeamBridge;
import com.moonsworth.lunar.bridge.minecraft.scoreboard.ScoreboardBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ScoreboardMod extends DraggableHudMod {
    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI;
    public BooleanSetting lIlIIIIIIlIIIllllIllIIlII;
    public ColorSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;
    public ColorSetting IIlIllIlllllllIIlIIIllIIl;
    public NumberSetting lIIlIlllIlIlIIIlllIIlIIII;

    public ScoreboardMod() {
        super(true, HudModPosition.MIDDLE_RIGHT);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        ScoreboardBridge var4 = this.mc.bridge$getWorld().bridge$getScoreboard();
        ScoreObjectiveBridge var5 = null;
        ScorePlayerTeamBridge var6 = var4.bridge$getPlayersTeam(this.mc.bridge$getPlayer().bridge$getName());
        if (var6 != null) {
            int var7 = var6.bridge$getChatFormat().llllIIlIIlIIlIIllIIlIIllI();
            if (Bridge.getMinecraftVersion() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl) {
                var5 = var4.bridge$getObjectiveInDisplaySlot(1);
            } else if (var7 >= 0) {
                try {
                    var5 = var4.bridge$getObjectiveInDisplaySlot(3 + var7);
                } catch (ArrayIndexOutOfBoundsException var9) {
                }
            }
        }

        ScoreObjectiveBridge var10 = var5 != null ? var5 : var4.bridge$getObjectiveInDisplaySlot(1);
        if (var10 != null) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(var10, var2, var3);
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ScoreObjectiveBridge var1, float var2, float var3) {
        this.llIlIIIllIIlIllIllIllllIl.IlllllIlIIIlIIlIIllIIlIll(Math.min(175.0F, this.llIlIIIllIIlIllIllIllllIl.llllIIlIIlIIlIIllIIlIIllI(0.0F)));
        ScoreboardBridge var4 = var1.bridge$getScoreboard();
        Collection<ScoreBridge> var5 = var4.bridge$getSortedScores(var1);
        ArrayList<ScoreBridge> var6 = new ArrayList<>();

        for (ScoreBridge var8 : var5) {
            if (var8.bridge$getPlayerName() != null && !var8.bridge$getPlayerName().startsWith("#")) {
                var6.add(var8);
            }
        }

        ArrayList<ScoreBridge> var20 = Lists.newArrayList(var6);
        ArrayList<ScoreBridge> var21;
        if (var20.size() > 15) {
            var21 = Lists.newArrayList(Iterables.skip(var20, var5.size() - 15));
        } else {
            var21 = var20;
        }

        int var9 = (int) Ref.getFontRenderer().bridge$getStringWidth(var1.bridge$getDisplayName());
        String[] var10 = new String[var21.size()];
        int var11 = 0;

        for (Iterator<ScoreBridge> var12 = var21.iterator(); var12.hasNext(); ++var11) {
            ScoreBridge var13 = var12.next();
            ScorePlayerTeamBridge var14 = var4.bridge$getPlayersTeam(var13.bridge$getPlayerName());
            var10[var11] = this.lIlIlIlIlIIlIIlIIllIIIIIl(var14, var13.bridge$getPlayerName());
            var9 = (int) Math.max((float) var9, Ref.getFontRenderer().bridge$getStringWidth(var10[var11] + ": " + EnumChatColor.lllIIIIIlllIIlIllIIlIIIlI + var13.bridge$getScorePoints()));
        }

        int var22 = var5.size() * Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() + 10;
        byte var23 = 2;
        int var24 = var9 + 2;
        if (this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl() && (float) var9 > Ref.getFontRenderer().bridge$getStringWidth(var1.bridge$getDisplayName())) {
            var24 = (int) ((float) var24 - Math.min((float) var9 - Ref.getFontRenderer().bridge$getStringWidth(var1.bridge$getDisplayName()), 9.0F));
        } else if (this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl()) {
            var24 += 4;
        }

        if (!var21.isEmpty()) {
            this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3 + (float) (var22 - var21.size() * Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl()) - (float) Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() - 1.0F, (float) var24, (float) var22);
            if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
                float var15 = (Float) this.lIIlIlllIlIlIIIlllIIlIIII.llIlllIIIllllIIlllIllIIIl();
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3 + -var15, (float) var24, var15);
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3 + (float) var22, (float) var24, var15);
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var2 - var15, var3 + -var15, var15, (float) var22 + var15 * 2.0F);
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var2 + (float) var24, var3 - var15, var15, (float) var22 + var15 * 2.0F);
            }
        }

        var11 = 0;

        for (ScoreBridge var16 : var21) {
            ++var11;
            String var17 = var10[var11 - 1];
            int var18 = var22 - var11 * Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl();
            Ref.getFontRenderer().bridge$drawString(var17, var2 + (float) var23, var3 + (float) var18, -1, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
            String var19;
            if (!(Boolean) this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl()) {
                var19 = EnumChatColor.lllIIIIIlllIIlIllIIlIIIlI + "" + var16.bridge$getScorePoints();
                Ref.getFontRenderer().bridge$drawString(var19, var2 + (float) var24 - Ref.getFontRenderer().bridge$getStringWidth(var19), var3 + (float) var18, -545247184, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
            }

            if (var11 == var21.size()) {
                var19 = var1.bridge$getDisplayName();
                if (this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl()) {
                    Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl(var19, var2 + (float) var24 / 2.0F, var3 + (float) var18 - (float) Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl(), -1);
                } else {
                    Ref.getFontRenderer().IlllIIIIIIlllIlIIlllIlIIl(var19, var2 + (float) var24 / 2.0F, var3 + (float) var18 - (float) Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl(), -1);
                }
            }
        }

        this.IlllIIIIIIlllIlIIlllIlIIl((float) var24, (float) (var5.size() * Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() + 10));
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(new SettingLabel("generalOptions"), this.lllIIIIIlllIIlIllIIlIIIlI = new BooleanSetting("numbers", false), this.lIlIIIIIIlIIIllllIllIIlII = new BooleanSetting("text_shadow", false), this.lIIlIlllIlIlIIIlllIIlIIII = new NumberSetting("border_thickness", 0.5F, 0.5F, 3.0F), this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("border", false), new SettingLabel("colorOptions"), this.llIlIIIllIIlIllIllIllllIl = new ColorSetting("background_color", 1342177280), this.IIlIllIlllllllIIlIIIllIIl = new ColorSetting("border", -1627389952));
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        if (Ref.getWorld() != null && this.mc.bridge$getWorld().bridge$getScoreboard().bridge$getObjectiveInDisplaySlot(1) != null) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.mc.bridge$getWorld().bridge$getScoreboard().bridge$getObjectiveInDisplaySlot(1), var2, var3);
        } else {
            ScoreboardBridge var4 = Bridge.getInstance().initScoreboard();
            ScoreObjectiveBridge var5 = Bridge.getInstance().initDummyScoreObjective(var4, "Lunar Client");
            var5.bridge$setDisplayName(EnumChatColor.lllIIIIIlllIIlIllIIlIIIlI + "" + EnumChatColor.lllllIllIllIllllIlIllllII + "Lunar" + EnumChatColor.RESET + " " + EnumChatColor.lIIlIlllIlIlIIIlllIIlIIII + "Client");
            var4.bridge$getValueFromObjective("Steve", var5).bridge$setScorePoints(0);
            var4.bridge$getValueFromObjective("Alex", var5).bridge$setScorePoints(0);
            this.lIlIlIlIlIIlIIlIIllIIIIIl(var5, var2, var3);
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Scoreboard", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("scoreboard", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.HUD));
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl(ScorePlayerTeamBridge var1, String var2) {
        return var1 == null ? var2 : var1.bridge$formatString(var2);
    }
}