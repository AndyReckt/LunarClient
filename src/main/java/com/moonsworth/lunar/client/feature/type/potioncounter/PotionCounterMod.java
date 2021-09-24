package com.moonsworth.lunar.client.feature.type.potioncounter;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.item.ItemPotionBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudMod;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudModSize;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.EnumSetting;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class PotionCounterMod extends SimpleHudMod {
    public EnumSetting<PotionCounterDisplayType> IllIIIlllIIIlIlllIlIIlIII;

    public PotionCounterMod() {
        super(false, HudModPosition.TOP_CENTER);
        this.IlllIIIIIIlllIlIIlllIlIIl(56.0F, 14.0F);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F, 62.0F);
    }

    public String IlIlIlIlIIIlIIlIIlllIllIl() {
        return "Potion Counter";
    }

    public SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI() {
        return new SimpleHudModSize(10, 18, 22, 40, 56, 62);
    }

    public String lllllIlIllIlIlllIIIlIIlIl() {
        long var1 = Ref.getPlayer() == null ? 0L : this.IlIlllIIIIIllIIllIllIIlll();
        String var3 = this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl() == PotionCounterDisplayType.SOUP ? "soup" : "pots";
        return var1 + " " + var3;
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("potion_counter");
    }

    public long IlIlllIIIIIllIIllIllIIlll() {
        Stream<ItemStackBridge> var1 = Ref.getPlayer().bridge$getInventory().bridge$getMainInventory().stream().filter(Objects::nonNull);
        return this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl() == PotionCounterDisplayType.SOUP ? (long)var1.filter((var0) -> {
            return var0.bridge$getItem().bridge$isItemSoup();
        }).mapToInt(ItemStackBridge::bridge$getStackSize).sum() : (long)var1.filter((var0) -> {
            return var0.bridge$getItem() != null && var0.bridge$getItem().bridge$isItemPotion();
        }).filter((var0) -> {
            return var0.bridge$getItem().bridge$hasEffect(var0);
        }).filter((var0) -> ((ItemPotionBridge)var0.bridge$getItem())
        .bridge$getEffects(var0).stream()
        .anyMatch((potion) -> potion.bridge$getPotionID() == Bridge.IIlIllIlllllllIIlIIIllIIl().bridge$heal().bridge$getID() && Bridge.IIlIllIlllllllIIlIIIllIIl().bridge$isPotionSplash(var0)))
        .mapToInt(ItemStackBridge::bridge$getStackSize)
        .sum();
    }

    public List IIIIIIIIIIIIIIIllllIIlIIl() {
        return ImmutableList.of(this.IllIIIlllIIIlIlllIlIIlIII = new EnumSetting<>("potionCounter", PotionCounterDisplayType.POTION));
    }
}
