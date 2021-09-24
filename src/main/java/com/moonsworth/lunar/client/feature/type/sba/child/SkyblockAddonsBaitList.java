package com.moonsworth.lunar.client.feature.type.sba.child;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SkyblockAddonsBaitList extends AbstractFeatureContainerChild {
    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI;
    public ColorSetting lIlIIIIIIlIIIllllIllIIlII;
    public final Map llIlIIIllIIlIllIllIllllIl;

    public SkyblockAddonsBaitList(ConfigurableFeature var1) {
        super(var1, false, HudModPosition.MIDDLE_LEFT);
        this.llIlIIIllIIlIllIllIllllIl = ImmutableMap.of(EnumChatColor.IllIllIIIllIIIlIlIlIIIIll + "Minnow Bait", 1, EnumChatColor.IllIllIIIllIIIlIlIlIIIIll + "Fish Bait", 2, EnumChatColor.IllIllIIIllIIIlIlIlIIIIll + "Light Bait", 3);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(115.0F, 72.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3, this.llIlIIIllIIlIllIllIllllIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().isHoldingRod()) {
            Map var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getBaitsInInventory();
            this.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3, var4);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, Map var3) {
        float var4 = 0.0F;

        Map.Entry var6;
        for(Iterator var5 = var3.entrySet().iterator(); var5.hasNext(); var4 = Math.max(var4, Ref.getFontRenderer().bridge$getStringWidth(String.valueOf(var6.getValue())))) {
            var6 = (Map.Entry)var5.next();
        }

        float var14 = var1;
        float var15 = var2;
        byte var7 = 1;
        byte var8 = 8;
        float var9 = (float)(var8 + var7) + var4;
        float var10 = (float)(var8 * var3.size());
        Iterator var11 = var3.entrySet().iterator();

        while(var11.hasNext()) {
            Map.Entry var12 = (Map.Entry)var11.next();
            if ((Integer)var12.getValue() != 0) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
                String var13 = EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(((String)var12.getKey()).toLowerCase(Locale.US)).split(" ")[0];
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.getInstance().initResourceLocation("lunar", "skyblockaddons/baits/" + var13 + ".png"), var8, var14, var15);
                this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(String.valueOf(var12.getValue()), var1 + (float)(var8 * 2) + (float)var7, var15 + (float)var8 - 4.0F, this.lllIIIIIlllIIlIllIIlIIIlI.llIlllIIIllllIIlllIllIIIl());
                var15 += (float)(var8 * 2);
            }
        }

        this.IlllIIIIIIlllIlIIlllIlIIl((float)(var8 * 2) + var4 + (float)var7, var15 - var2);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.lllIIIIIlllIIlIllIIlIIIlI = new BooleanSetting("text_shadow", true), this.lIlIIIIIIlIIIllllIllIIlII = new ColorSetting("bait_list_color", -1));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Bait List", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("bait_list", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.HUD), ImmutableList.of(MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl));
    }
}
