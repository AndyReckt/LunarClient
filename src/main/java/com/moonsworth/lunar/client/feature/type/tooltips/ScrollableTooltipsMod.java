package com.moonsworth.lunar.client.feature.type.tooltips;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.event.type.gui.DrawTooltipEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.setting.LunarKeybindSetting;

import java.util.List;

public class ScrollableTooltipsMod extends ConfigurableFeature {
    public static int llllIIlIIlIIlIIllIIlIIllI = 0;
    public static int IlIlIlllllIlIIlIlIlllIlIl = 0;
    public LunarKeybindSetting llIIIIIIIllIIllIlIllIIIIl;

    public ScrollableTooltipsMod() {
        super(true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(DrawTooltipEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(DrawTooltipEvent var1) {
        var1.setCancelled(true);
        var1.lIllIlIIIlIIIIIIIlllIlIll().bridge$drawScrollableHoveringText(var1.IlllIIIIIIlllIlIIlllIlIIl().orElse(null), var1.llIlllIIIllllIIlllIllIIIl(), var1.llllIIlIIlIIlIIllIIlIIllI(), var1.IlIlIlllllIlIIlIlIlllIlIl());
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(
                   this.llIIIIIIIllIIllIlIllIIIIl = new LunarKeybindSetting(this, "horizontalScrollingKey", KeyType.KEY_LSHIFT, false)
               );
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Scrollable Tooltips", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("scrollable_tooltips", ImmutableList.of(ModuleCategory.NEW, ModuleCategory.MECHANIC, ModuleCategory.ALL), "Sk1er");
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(ItemStackBridge var1, ItemStackBridge var2) {
        if (var1.bridge$getDisplayName() != null && var2.bridge$getDisplayName() != null) {
            if (var1.bridge$getDisplayName().equalsIgnoreCase(var2.bridge$getDisplayName())) {
                return var1 == var2;
            } else {
                return false;
            }
        } else {
            return var1 == var2 || var1.bridge$areItemsEqual(var2);
        }
    }

    public LunarKeybindSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }
}
