package com.moonsworth.lunar.client.feature.type.shinypots;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.setting.BooleanSetting;

import java.util.HashMap;
import java.util.List;

public class ShinyPotsMod extends ConfigurableFeature {
    public HashMap<Integer, Integer> llllIIlIIlIIlIIllIIlIIllI = new HashMap<>();
    public HashMap<String, Integer> IlIlIlllllIlIIlIlIlllIlIl = new HashMap<>();
    public BooleanSetting llIIIIIIIllIIllIlIllIIIIl;
    public BooleanSetting lIIIllIllIIllIlllIlIIlllI;

    public ShinyPotsMod() {
        super(false);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.llIIIIIIIllIIllIlIllIIIIl = new BooleanSetting("colored", false), this.lIIIllIllIIllIlllIlIIlllI = new BooleanSetting("renderGlintBehindPotion", false, () -> {
            return Bridge.getMinecraftVersion() != MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl;
        }));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Shiny Pots", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("shinyPots", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.MECHANIC));
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl(ItemStackBridge var1) {
        if (!(Boolean)this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl()) {
            return -8372020;
        } else {
            return Bridge.getMinecraftVersion().llIlllIIIllllIIlllIllIIIl() ? this.IlllIIIIIIlllIlIIlllIlIIl(var1) : this.lIllIlIIIlIIIIIIIlllIlIll(var1);
        }
    }

    public int IlllIIIIIIlllIlIIlllIlIIl(ItemStackBridge var1) {
        int var2 = var1.bridge$getItemDamage();
        Integer var3 = this.llllIIlIIlIIlIIllIIlIIllI.get(var2);
        if (var3 == null) {
            var3 = Bridge.llIlIIIllIIlIllIllIllllIl().bridge$potionItem().bridge$getColorFromItemStack(var1, 0) | -16777216;
            this.llllIIlIIlIIlIIllIIlIIllI.put(var2, var3);
        }

        return var3;
    }

    public int lIllIlIIIlIIIIIIIlllIlIll(ItemStackBridge var1) {
        String var2 = var1.bridge$getDisplayName();
        Integer var3 = this.IlIlIlllllIlIIlIlIlllIlIl.get(var2);
        if (var3 == null) {
            var3 = Bridge.llIlIIIllIIlIllIllIllllIl().bridge$potionItem().bridge$getColorFromItemStack(var1, 0) | -16777216;
            this.IlIlIlllllIlIIlIlIlllIlIl.put(var2, var3);
        }

        return var3;
    }

    public BooleanSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public BooleanSetting lIllllIllIIlIIlIIIlIIIlII() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }
}
