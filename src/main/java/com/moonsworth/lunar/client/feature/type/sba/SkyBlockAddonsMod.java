package com.moonsworth.lunar.client.feature.type.sba;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.feature.type.coodowns.CooldownsMod;
import com.moonsworth.lunar.client.feature.type.sba.child.*;
import com.moonsworth.lunar.client.profile.main.Where;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.sba.SkyblockWrapperBridge;
import com.moonsworth.lunar.client.setting.*;
import com.moonsworth.lunar.client.ui.component.type.setting.TextSetting;
import org.apache.commons.lang3.text.WordUtils;

import java.util.*;
import java.util.function.Predicate;

public class SkyBlockAddonsMod extends ConfigurableFeature {
    public EnumSetting lIllllIllIIlIIlIIIlIIIlII;
    public BooleanSetting lIlIlIIIIIIllIlIIIIllIIII;
    public BooleanSetting lIIlIIIIIIlIIlIIllIlIIlII;
    public BooleanSetting IlIIlIIlIIlIIllIIIllIIllI;
    public BooleanSetting IIlIlIIIllIIllllIllllIlIl;
    public BooleanSetting lllllIIIIlIlllIllIIIlIIlI;
    public BooleanSetting IIlllIllIlIllIllIIllIlIIl;
    public BooleanSetting lIlIIlIlllIIlIIIlIlIlIllI;
    public BooleanSetting lIIlllIIIIIlllIIIlIlIlllI;
    public BooleanSetting IIIlIIIIIIllIIIIllIIIIlII;
    public BooleanSetting IlIIIlIlIlIlIlIllIIllIIlI;
    public BooleanSetting IlIlIllIIllllIllllllIIlIl;
    public BooleanSetting lIIlIIlllIIIIlIlllIIIIlll;
    public BooleanSetting llIllIIIIlIIIIIIlllIllIlI;
    public BooleanSetting lIlIIIIIllIIlIIlIIlIlIIlI;
    public BooleanSetting IIllIlIllIlIllIllIllIllII;
    public BooleanSetting IlIlllIlIlllIllIIIIIIlllI;
    public BooleanSetting llllIlIlIIIllllIIlIllIlII;
    public BooleanSetting llIIIllllIIIllIIIIlIlIlll;
    public ColorSetting IIIIIIIIIIIIIIIllllIIlIIl;
    public BooleanSetting llIIIIllIlIIlIlIIlllIllIl;
    public BooleanSetting IIIIlIllIllIlIIIIIlIlIlIl;
    public BooleanSetting IlIlIlIlIIIlIIlIIlllIllIl;
    public BooleanSetting lIIIlIllllIIlIIlIIlIIIIlI;
    public BooleanSetting lllllIlIllIlIlllIIIlIIlIl;
    public BooleanSetting IllIlIIllIIlllIIllIlIlIII;
    public BooleanSetting IlIlllIIIIIllIIllIllIIlll;
    public BooleanSetting IllllIIllllIllIIIIlllllII;
    public BooleanSetting IIllllIIlllIlIIlIIlllIlII;
    public BooleanSetting IllIlIIlllIIlIIllIIIIIIIl;
    public BooleanSetting IllIllIllIIlIlllIIlllIIll;
    public BooleanSetting IlIIIIlllIllllIlIlIllIlII;
    public BooleanSetting lIlIIIlIIlIIIlIIIlllIlIII;
    public BooleanSetting IlIllIIlIIlIlIIlIIlIllIll;
    public BooleanSetting lIlllllIIlllIllIIlIIlIlll;
    public BooleanSetting lIIlIIllIlIIlIIllIIIIlIIl;
    public BooleanSetting IllIIlllIllIlllllIlIllIll;
    public BooleanSetting IIIlIlIllIlIlIIIIIlIllIII;
    public BooleanSetting IIlllIllIIlllllIllllllIII;
    public BooleanSetting IlIlIIllllllIIlIIllIIllIl;
    public BooleanSetting IIllIIlIIIlIlIlIlIIllIllI;
    public BooleanSetting llIllllIlIIlIIIIllIllIIll;
    public BooleanSetting lIllIllIllIIIlllIIIlllllI;
    public BooleanSetting IlIIlllIIllIIlIlIlIlIIlll;
    public BooleanSetting IlllIIIlIllIIIlIIllllllIl;
    public BooleanSetting lllIIIIllIllIlIIlllIIllII;
    public BooleanSetting IlllllIlIlIlIIIIIllllIlIl;
    public BooleanSetting lIIllllIllIllllllllIlllII;
    public BooleanSetting lIlIIllIIIlIIIlIIIlIIlIll;
    public BooleanSetting llllIIlIllllllIIllIllIlII;
    public BooleanSetting IIlIIIlIlIlIlIllIlIlIIlll;
    public ColorSetting IIIIlIIlIIIIllIlIlIIIlIlI;
    public BooleanSetting lIIIlIlIlIIlIllIIIIlllIlI;
    public EnumSetting IIllIlIIllIIlIIllllIIllII;
    public EnumSetting lIIIIIlIIIlIIIlIIlIIIIIlI;
    public LunarKeybindSetting lIlllIlllIIIllIIIIIlIIllI;
    public LunarKeybindSetting IIIIlIIIIIllllIlllllllIIl;
    public final Set<Integer> lIIlllIIIIlIIIIllIIlllllI = new HashSet<>();
    public int lIIIIllIIIllllllllIIlllIl;
    public int IIIIlIIlIIIlllllIlllIIlII;
    public int IlIlIIlIllllIllIIlIlIllII;
    public AbstractSetting IIIIlllIlIIlllllIIllIIIII;
    public AbstractSetting lIIIllIIIlIlIlIIlIIlllIlI;
    public EnumSetting llIIlIIIllllIIIllIIIIIIll;
    public SkyblockWrapperBridge llIIlllIllIIIlIlIlllIlIII = new DummySkyblockWrapper();
    public long IIIllIlIllIIllIlIlllIllIl = 0L;
    public SkyBlockAddonsManaBarChild llllIIlIIlIIlIIllIIlIIllI;
    public SkyBlockAddonsManaTextChild IlIlIlllllIlIIlIlIlllIlIl;
    public SkyBlockAddonsHealthBarChild llIIIIIIIllIIllIlIllIIIIl;
    public SkyBlockAddonsHealthTextChild lIIIllIllIIllIlllIlIIlllI;
    public SkyBlockAddonsDefenseTextChild IlllllIlIIIlIIlIIllIIlIll;
    public SkyBlockAddonsDefensePercentageChild llIIlIlIIIllIlIlIlIIlIIll;
    public SkyBlockAddonsDefenseIconChild llIIIlllIIlllIllllIlIllIl;
    public SkyBlockAddonsSpeedTextChild lllIIIIIlllIIlIllIIlIIIlI;
    public SkyblockAddonsBirchParkRainmaker lIlIIIIIIlIIIllllIllIIlII;
    public SkyblockAddonsdarkAuctionoTimer llIlIIIllIIlIllIllIllllIl;
    public SkyblockAddonsEndstoneProtector IllIllIIIllIIIlIlIlIIIIll;
    public SkyblockAddonsMagmaTimer IIlIllIlllllllIIlIIIllIIl;
    public SkyBlockAddonsPowerOrbStausChild lIIlIlllIlIlIIIlllIIlIIII;
    public SkyblockAddonsBoneDisplay llIllIlIllIlllIllIIIIllII;
    public SkyblockAddonsSkillDisplay IllllllllllIlIIIlllIlllll;
    public SkyblockAddonsSummoningEyeCounter lllllIllIlIIlIIlIIIlllIlI;
    public SkyblockAddonsTickerChargesDisplay IllIIIlllIIIlIlllIlIIlIII;
    public SkyblockAddonsZealotCounter IIlIllIlIIllIIlIlIllllllI;
    public SkyblockAddonsZealotTotalCounter lIIIlllIIIIllllIlIIIlIIll;
    public SkyblockAddonsZealotPerEye llIIIlIllIIIIlIIIlIlIllIl;
    public SkyblockAddonsBaitList llllIlIllllIlIlIIIllIlIlI;
    public SkyblockAddonsFeatureWarnings IlIllIIlIIlIIIllIllllIIll;

    public SkyBlockAddonsMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl((var1) -> {
            boolean var2 = this.llIIlllIllIIIlIlIlllIlIII.isSkyBlock();
            if (!(var1 instanceof AbstractShowInOtherGamesFeature)) {
                return var2;
            } else {
                return ((AbstractShowInOtherGamesFeature) var1).IIIIIIIIIIIIIIIllllIIlIIl().llIlllIIIllllIIlllIllIIIl() || var2;
            }
        });
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.IlIIIIlllIllllIlIlIllIlII.lIlIlIlIlIIlIIlIIllIIIIIl((var0) -> {
            if (var0 && Ref.getLC() != null && Ref.getLC().lllllIllIllIllllIlIllllII() != null && Ref.getLC().lllllIllIllIllllIlIllllII().IlIllIIlIIlIIIllIllllIIll() != null && !Ref.getLC().lllllIllIllIllllIlIllllII().IlIllIIlIIlIIIllIllllIIll().IlllIIIIIIlllIlIIlllIlIIl()) {
                Ref.getLC().lllllIllIllIllllIlIllllII().IlIllIIlIIlIIIllIllllIIll().IlllIIIIIIlllIlIIlllIlIIl(true);
            }
        });
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent var1) {
        if (this.llIIlllIllIIIlIlIlllIlIII.isSkyBlock() && Ref.getLC().lllllIllIllIllllIlIllllII().llIIIlIllIIIIlIIIlIlIllIl() != null) {
            if (this.IIllIIlIIIlIlIlIlIIllIllI.llIlllIIIllllIIlllIllIIIl() && System.currentTimeMillis() <= this.llIIlllIllIIIlIlIlllIlIII.getLastDamaged() + 5000L) {
                long var2 = this.llIIlllIllIIIlIlIlllIlIII.getLastDamaged() + 5000L;
                int var4 = (int) Math.ceil((double) (var2 - System.currentTimeMillis()));
                if (this.IIIllIlIllIIllIlIlllIllIl == var2) {
                    return;
                }

                this.IIIllIlIllIIllIlIlllIllIl = var2;
                if (var4 - 2000 > 0) {
                    CooldownsMod.IlllIIIIIIlllIlIIlllIlIIl("Combat", var4 - 2000, 399);
                }

                CooldownsMod.lIlIlIlIlIIlIIlIIllIIIIIl("Combat TP", var4, this.llIIlllIllIIIlIlIlllIlIII.getWarpItem());
            }

        }
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(
                new SettingLabel("hudOptions"),
                this.lIIlllIIIIIlllIIIlIlIlllI = new BooleanSetting("hideHealthBar", false),
                this.lllllIIIIlIlllIllIIIlIIlI = new BooleanSetting("hideFoodBar", true),
                this.lIlllllIIlllIllIIlIIlIlll = new BooleanSetting("hidePetHealthBar", true),
                this.IIllIIlIIIlIlIlIlIIllIllI = new BooleanSetting("combatTimerDisplay", true),
                this.IIlIlIIIllIIllllIllllIlIl = new BooleanSetting("skeletonHelmetBars", true),
                new SettingLabel("zealotOptions"),
                this.lIlIIIlIIlIIIlIIIlllIlIII = new BooleanSetting("specialZealotAlert", true),
                this.lIIllllIllIllllllllIlllII = new BooleanSetting("zealotCounterExplosiveBowSupport", false),
                this.lIIIlIlIlIIlIllIIIIlllIlI = new BooleanSetting("zealotColorBoolean", false),
                this.IIIIlIIlIIIIllIlIlIIIlIlI = new ColorSetting("zealotColor", -14671840, () -> !(Boolean) this.lIIIlIlIlIIlIllIIIIlllIlI.llIlllIIIllllIIlllIllIIIl()),
                new SettingLabel("safetyOptions"),
                this.lIllllIllIIlIIlIIIlIIIlII = new EnumSetting("dropConfirmation", Where.IlllIIIIIIlllIlIIlllIlIIl),
                this.llllIlIlIIIllllIIlIllIlII = new BooleanSetting("lockSlots", true),
                this.llIIlIIIllllIIIllIIIIIIll = new EnumSetting("minimum_hotbar_item_rarity", ItemRarity.IlllIIIIIIlllIlIIlllIlIIl),
                this.IIIIlllIlIIlllllIIllIIIII = new TextSetting("drop_blacklist", ""),
                this.lIIIllIIIlIlIlIIlIIlllIlI = new TextSetting("drop_whitelist", ""),
                this.IIIIlIllIllIlIIIIIlIlIlIl = new BooleanSetting("stopDroppingSellingRareItems", true),
                this.IllllIIllllIllIIIIlllllII = new BooleanSetting("avoidBlinkingNightVision", true),
                this.llIIIIllIlIIlIlIIlllIllIl = new BooleanSetting("dontOpenProfilesWithBow", true),
                this.IIIIlIIIIIllllIlllllllIIl = new LunarKeybindSetting(this, "freezeKey", KeyType.KEY_J, false),
                this.lIlllIlllIIIllIIIIIlIIllI = new LunarKeybindSetting(this, "lockKey", KeyType.KEY_L, false),
                new SettingLabel("indicatorOptions"),
                this.IlIlIlIlIIIlIIlIIlllIllIl = new BooleanSetting("makeBackpackInventoriesColored", true),
                this.IlIIIIlllIllllIlIlIllIlII = new BooleanSetting("slayerIndicator", true),
                this.IlIlIIllllllIIlIIllIIllIl = new BooleanSetting("turnBowGreenWhenUsingToxicArrowPoison", true),
                this.IlIlllIIIIIllIIllIllIIlll = new BooleanSetting("fishingSoundIndicator", true),
                this.lllllIlIllIlIlllIIIlIIlIl = new BooleanSetting("changeBarColorForPotions", false),
                this.llIIIllllIIIllIIIIlIlIlll = new BooleanSetting("colorEnderChestInEnd", true),
                this.IIIIIIIIIIIIIIIllllIIlIIl = new ColorSetting("endEnderChestColor", -14671840, () -> !this.llIIIllllIIIllIIIIlIlIlll.llIlllIIIllllIIlllIllIIIl()),
                new SettingLabel("entityOptions"),
                this.llllIIlIllllllIIllIllIlII = new BooleanSetting("hideSvenPupNametags", false),
                this.IlIlIllIIllllIllllllIIlIl = new BooleanSetting("hidePlayersInLobby", false),
                this.IlIIlIIlIIlIIllIIIllIIllI = new BooleanSetting("hideBones", true),
                new SettingLabel("locationResourceOptions"),
                this.lllIIIIllIllIlIIlllIIllII = new BooleanSetting("enableMessageWhenBreakingPark", true),
                new SettingLabel("backpackOptions"),
                this.lIIlIIIIIIlIIlIIllIlIIlII = new BooleanSetting("showBackpackPreview", true),
                this.IlIIIlIlIlIlIlIllIIllIIlI = new BooleanSetting("showBackpackHoldingShift", false),
                this.IIIlIlIllIlIlIIIIIlIllIII = new BooleanSetting("backpackPreviewAh", false),
                this.IllIIlllIllIlllllIlIllIll = new BooleanSetting("cakeBagPreview", false),
                this.IIllIlIIllIIlIIllllIIllII = new EnumSetting("backpackStyle", BackpackStyle.lIlIlIlIlIIlIIlIIllIIIIIl),
                new SettingLabel("warpTpOptions"),
                this.llIllllIlIIlIIIIllIllIIll = new BooleanSetting("fancyWarpMenu", true),
                this.IIlIIIlIlIlIlIllIlIlIIlll = new BooleanSetting("warpAdvancedMode", false),
                this.lIlIIllIIIlIIIlIIIlIIlIll = new BooleanSetting("disableEndermanTeleportionEffect", false),
                new SettingLabel("tooltipOptions"), this.IlIIlllIIllIIlIlIlIlIIlll = new BooleanSetting("hideGreyEnchants", true),
                this.lIlIIIIIllIIlIIlIIlIlIIlI = new BooleanSetting("showItemAnvilUses", true),
                this.lIIIlIllllIIlIIlIIlIIIIlI = new BooleanSetting("replaceRomanNumeralsWithNumbers", false),
                this.IllIlIIlllIIlIIllIIIIIIIl = new BooleanSetting("organizeEnchants", true),
                this.IIlllIllIlIllIllIIllIlIIl = new BooleanSetting("showEnchantmentsReforges", true),
                this.IIlllIllIIlllllIllllllIII = new BooleanSetting("showBrokenFragments", true),
                new SettingLabel("containerOptions"),
                this.IlIlllIlIlllIllIIIIIIlllI = new BooleanSetting("dontResetCursorInventory", true),
                new SettingLabel("enchantedItemsBlacklist"), new SettingLabel("chatOptions"),
                this.IlllllIlIlIlIIIIIllllIlIl = new BooleanSetting("disableTeleportPadMessages", true),
                this.lIIlIIllIlIIlIIllIIIIlIIl = new BooleanSetting("disableMagicalSoupMessages", false));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("SkyBlock Addons", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return (new FeatureDetails("skyblockAddons", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.NEW), ImmutableList.of(MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl), new String[] {"Biscuit"})).lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of("sba", "Hypixel SkyBlock Addons"));
    }

    public List llllIlIlIIIllllIIlIllIlII() {
        return ImmutableList.of(
                   this.llllIIlIIlIIlIIllIIlIIllI = new SkyBlockAddonsManaBarChild(this),
                   this.IlIlIlllllIlIIlIlIlllIlIl = new SkyBlockAddonsManaTextChild(this),
                   this.llIIIIIIIllIIllIlIllIIIIl = new SkyBlockAddonsHealthBarChild(this),
                   this.lIIIllIllIIllIlllIlIIlllI = new SkyBlockAddonsHealthTextChild(this),
                   this.llIIIlllIIlllIllllIlIllIl = new SkyBlockAddonsDefenseIconChild(this),
                   this.IlllllIlIIIlIIlIIllIIlIll = new SkyBlockAddonsDefenseTextChild(this),
                   this.llIIlIlIIIllIlIlIlIIlIIll = new SkyBlockAddonsDefensePercentageChild(this),
                   this.lllIIIIIlllIIlIllIIlIIIlI = new SkyBlockAddonsSpeedTextChild(this),
                   this.lIlIIIIIIlIIIllllIllIIlII = new SkyblockAddonsBirchParkRainmaker(this),
                   this.llIlIIIllIIlIllIllIllllIl = new SkyblockAddonsdarkAuctionoTimer(this),
                   this.IllIllIIIllIIIlIlIlIIIIll = new SkyblockAddonsEndstoneProtector(this),
                   this.IIlIllIlllllllIIlIIIllIIl = new SkyblockAddonsMagmaTimer(this),
                   this.lIIlIlllIlIlIIIlllIIlIIII = new SkyBlockAddonsPowerOrbStausChild(this),
                   this.llIllIlIllIlllIllIIIIllII = new SkyblockAddonsBoneDisplay(this),
                   this.IllllllllllIlIIIlllIlllll = new SkyblockAddonsSkillDisplay(this),
                   this.lllllIllIlIIlIIlIIIlllIlI = new SkyblockAddonsSummoningEyeCounter(this),
                   this.IllIIIlllIIIlIlllIlIIlIII = new SkyblockAddonsTickerChargesDisplay(this),
                   this.IIlIllIlIIllIIlIlIllllllI = new SkyblockAddonsZealotCounter(this),
                   this.lIIIlllIIIIllllIlIIIlIIll = new SkyblockAddonsZealotTotalCounter(this),
                   this.llIIIlIllIIIIlIIIlIlIllIl = new SkyblockAddonsZealotPerEye(this),
                   this.llllIlIllllIlIlIIIllIlIlI = new SkyblockAddonsBaitList(this),
                   this.IlIllIIlIIlIIIllIllllIIll = new SkyblockAddonsFeatureWarnings(this));
    }

    public List IlIllIIlIIlIIIllIllllIIll() {
        return Arrays.asList(((TextSetting) this.IIIIlllIlIIlllllIIllIIIII).llIlllIIIllllIIlllIllIIIl().split(","));
    }

    public List lIllllIllIIlIIlIIIlIIIlII() {
        return Arrays.asList(((TextSetting) this.lIIIllIIIlIlIlIIlIIlllIlI).llIlllIIIllllIIlllIllIIIl().split(","));
    }

    public void write(JsonObject var1) {
        super.write(var1);
        JsonArray var2 = new JsonArray();
        Iterator<Integer> var3 = this.lIIlllIIIIlIIIIllIIlllllI.iterator();

        while (var3.hasNext()) {
            Integer var4 = var3.next();
            var2.add(new JsonPrimitive(var4));
        }

        if (this.lIIIIllIIIllllllllIIlllIl != 0) {
            var1.addProperty("zealot_kills", this.lIIIIllIIIllllllllIIlllIl);
        }

        if (this.IIIIlIIlIIIlllllIlllIIlII != 0) {
            var1.addProperty("total_zealot_kills", this.IIIIlIIlIIIlllllIlllIIlII);
        }

        if (this.IlIlIIlIllllIllIIlIlIllII != 0) {
            var1.addProperty("summoningEyeCount", this.IlIlIIlIllllIllIIlIlIllII);
        }

        if (this.lIIlllIIIIlIIIIllIIlllllI.size() > 0) {
            var1.add("locked_slots", var2);
        }

    }

    public void read(JsonObject var1) {
        super.read(var1);
        if (var1.has("zealot_kills") && !var1.get("zealot_kills").isJsonNull()) {
            this.lIIIIllIIIllllllllIIlllIl = var1.get("zealot_kills").getAsInt();
        }

        if (var1.has("total_zealot_kills") && !var1.get("total_zealot_kills").isJsonNull()) {
            this.IIIIlIIlIIIlllllIlllIIlII = var1.get("total_zealot_kills").getAsInt();
        }

        if (var1.has("summoningEyeCount") && !var1.get("summoningEyeCount").isJsonNull()) {
            this.IlIlIIlIllllIllIIlIlIllII = var1.get("summoningEyeCount").getAsInt();
        }

        if (var1.has("locked_slots") && var1.get("locked_slots").isJsonArray()) {
            JsonArray var2 = var1.getAsJsonArray("locked_slots");
            var2.forEach((var1x) -> {
                this.lIIlllIIIIlIIIIllIIlllllI.add(var1x.getAsInt());
            });
        }

    }

    public EnumSetting lIlIlIIIIIIllIlIIIIllIIII() {
        return this.lIllllIllIIlIIlIIIlIIIlII;
    }

    public BooleanSetting lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.lIlIlIIIIIIllIlIIIIllIIII;
    }

    public BooleanSetting IlIIlIIlIIlIIllIIIllIIllI() {
        return this.lIIlIIIIIIlIIlIIllIlIIlII;
    }

    public BooleanSetting IIlIlIIIllIIllllIllllIlIl() {
        return this.IlIIlIIlIIlIIllIIIllIIllI;
    }

    public BooleanSetting lllllIIIIlIlllIllIIIlIIlI() {
        return this.IIlIlIIIllIIllllIllllIlIl;
    }

    public BooleanSetting IIlllIllIlIllIllIIllIlIIl() {
        return this.lllllIIIIlIlllIllIIIlIIlI;
    }

    public BooleanSetting lIlIIlIlllIIlIIIlIlIlIllI() {
        return this.IIlllIllIlIllIllIIllIlIIl;
    }

    public BooleanSetting lIIlllIIIIIlllIIIlIlIlllI() {
        return this.lIlIIlIlllIIlIIIlIlIlIllI;
    }

    public BooleanSetting IIIlIIIIIIllIIIIllIIIIlII() {
        return this.lIIlllIIIIIlllIIIlIlIlllI;
    }

    public BooleanSetting IlIIIlIlIlIlIlIllIIllIIlI() {
        return this.IIIlIIIIIIllIIIIllIIIIlII;
    }

    public BooleanSetting IlIlIllIIllllIllllllIIlIl() {
        return this.IlIIIlIlIlIlIlIllIIllIIlI;
    }

    public BooleanSetting lIIlIIlllIIIIlIlllIIIIlll() {
        return this.IlIlIllIIllllIllllllIIlIl;
    }

    public BooleanSetting llIllIIIIlIIIIIIlllIllIlI() {
        return this.lIIlIIlllIIIIlIlllIIIIlll;
    }

    public BooleanSetting lIlIIIIIllIIlIIlIIlIlIIlI() {
        return this.llIllIIIIlIIIIIIlllIllIlI;
    }

    public BooleanSetting IIllIlIllIlIllIllIllIllII() {
        return this.lIlIIIIIllIIlIIlIIlIlIIlI;
    }

    public BooleanSetting IlIlllIlIlllIllIIIIIIlllI() {
        return this.IIllIlIllIlIllIllIllIllII;
    }

    public BooleanSetting IIIIIIIIIIIIIIIllllIIlIIl() {
        return this.IlIlllIlIlllIllIIIIIIlllI;
    }

    public BooleanSetting llIIIIllIlIIlIlIIlllIllIl() {
        return this.llllIlIlIIIllllIIlIllIlII;
    }

    public BooleanSetting IIIIlIllIllIlIIIIIlIlIlIl() {
        return this.llIIIllllIIIllIIIIlIlIlll;
    }

    public ColorSetting IlIlIlIlIIIlIIlIIlllIllIl() {
        return this.IIIIIIIIIIIIIIIllllIIlIIl;
    }

    public BooleanSetting lIIIlIllllIIlIIlIIlIIIIlI() {
        return this.llIIIIllIlIIlIlIIlllIllIl;
    }

    public BooleanSetting lllllIlIllIlIlllIIIlIIlIl() {
        return this.IIIIlIllIllIlIIIIIlIlIlIl;
    }

    public BooleanSetting IllIlIIllIIlllIIllIlIlIII() {
        return this.IlIlIlIlIIIlIIlIIlllIllIl;
    }

    public BooleanSetting IlIlllIIIIIllIIllIllIIlll() {
        return this.lIIIlIllllIIlIIlIIlIIIIlI;
    }

    public BooleanSetting IllllIIllllIllIIIIlllllII() {
        return this.lllllIlIllIlIlllIIIlIIlIl;
    }

    public BooleanSetting IIllllIIlllIlIIlIIlllIlII() {
        return this.IllIlIIllIIlllIIllIlIlIII;
    }

    public BooleanSetting IllIlIIlllIIlIIllIIIIIIIl() {
        return this.IlIlllIIIIIllIIllIllIIlll;
    }

    public BooleanSetting IllIllIllIIlIlllIIlllIIll() {
        return this.IllllIIllllIllIIIIlllllII;
    }

    public BooleanSetting IlIIIIlllIllllIlIlIllIlII() {
        return this.IIllllIIlllIlIIlIIlllIlII;
    }

    public BooleanSetting lIlIIIlIIlIIIlIIIlllIlIII() {
        return this.IllIlIIlllIIlIIllIIIIIIIl;
    }

    public BooleanSetting IlIllIIlIIlIlIIlIIlIllIll() {
        return this.IllIllIllIIlIlllIIlllIIll;
    }

    public BooleanSetting lIlllllIIlllIllIIlIIlIlll() {
        return this.IlIIIIlllIllllIlIlIllIlII;
    }

    public BooleanSetting lIIlIIllIlIIlIIllIIIIlIIl() {
        return this.lIlIIIlIIlIIIlIIIlllIlIII;
    }

    public BooleanSetting IllIIlllIllIlllllIlIllIll() {
        return this.IlIllIIlIIlIlIIlIIlIllIll;
    }

    public BooleanSetting IIIlIlIllIlIlIIIIIlIllIII() {
        return this.lIlllllIIlllIllIIlIIlIlll;
    }

    public BooleanSetting IIlllIllIIlllllIllllllIII() {
        return this.lIIlIIllIlIIlIIllIIIIlIIl;
    }

    public BooleanSetting IlIlIIllllllIIlIIllIIllIl() {
        return this.IllIIlllIllIlllllIlIllIll;
    }

    public BooleanSetting IIllIIlIIIlIlIlIlIIllIllI() {
        return this.IIIlIlIllIlIlIIIIIlIllIII;
    }

    public BooleanSetting llIllllIlIIlIIIIllIllIIll() {
        return this.IIlllIllIIlllllIllllllIII;
    }

    public BooleanSetting lIllIllIllIIIlllIIIlllllI() {
        return this.IlIlIIllllllIIlIIllIIllIl;
    }

    public BooleanSetting IlIIlllIIllIIlIlIlIlIIlll() {
        return this.IIllIIlIIIlIlIlIlIIllIllI;
    }

    public BooleanSetting IlllIIIlIllIIIlIIllllllIl() {
        return this.llIllllIlIIlIIIIllIllIIll;
    }

    public BooleanSetting lllIIIIllIllIlIIlllIIllII() {
        return this.lIllIllIllIIIlllIIIlllllI;
    }

    public BooleanSetting IlllllIlIlIlIIIIIllllIlIl() {
        return this.IlIIlllIIllIIlIlIlIlIIlll;
    }

    public BooleanSetting lIIllllIllIllllllllIlllII() {
        return this.IlllIIIlIllIIIlIIllllllIl;
    }

    public BooleanSetting lIlIIllIIIlIIIlIIIlIIlIll() {
        return this.lllIIIIllIllIlIIlllIIllII;
    }

    public BooleanSetting llllIIlIllllllIIllIllIlII() {
        return this.IlllllIlIlIlIIIIIllllIlIl;
    }

    public BooleanSetting IIlIIIlIlIlIlIllIlIlIIlll() {
        return this.lIIllllIllIllllllllIlllII;
    }

    public BooleanSetting IIIIlIIlIIIIllIlIlIIIlIlI() {
        return this.lIlIIllIIIlIIIlIIIlIIlIll;
    }

    public BooleanSetting lIIIlIlIlIIlIllIIIIlllIlI() {
        return this.llllIIlIllllllIIllIllIlII;
    }

    public BooleanSetting IIllIlIIllIIlIIllllIIllII() {
        return this.IIlIIIlIlIlIlIllIlIlIIlll;
    }

    public ColorSetting lIIIIIlIIIlIIIlIIlIIIIIlI() {
        return this.IIIIlIIlIIIIllIlIlIIIlIlI;
    }

    public BooleanSetting lIlllIlllIIIllIIIIIlIIllI() {
        return this.lIIIlIlIlIIlIllIIIIlllIlI;
    }

    public EnumSetting IIIIlIIIIIllllIlllllllIIl() {
        return this.IIllIlIIllIIlIIllllIIllII;
    }

    public EnumSetting lIIlllIIIIlIIIIllIIlllllI() {
        return this.lIIIIIlIIIlIIIlIIlIIIIIlI;
    }

    public LunarKeybindSetting lIIIIllIIIllllllllIIlllIl() {
        return this.lIlllIlllIIIllIIIIIlIIllI;
    }

    public LunarKeybindSetting IIIIlIIlIIIlllllIlllIIlII() {
        return this.IIIIlIIIIIllllIlllllllIIl;
    }

    public Set IlIlIIlIllllIllIIlIlIllII() {
        return this.lIIlllIIIIlIIIIllIIlllllI;
    }

    public int IIIIlllIlIIlllllIIllIIIII() {
        return this.lIIIIllIIIllllllllIIlllIl;
    }

    public int lIIIllIIIlIlIlIIlIIlllIlI() {
        return this.IIIIlIIlIIIlllllIlllIIlII;
    }

    public int llIIlIIIllllIIIllIIIIIIll() {
        return this.IlIlIIlIllllIllIIlIlIllII;
    }

    public EnumSetting llIIlllIllIIIlIlIlllIlIII() {
        return this.llIIlIIIllllIIIllIIIIIIll;
    }

    public SkyblockWrapperBridge IIIllIlIllIIllIlIlllIllIl() {
        return this.llIIlllIllIIIlIlIlllIlIII;
    }

    public long IIIlIIIlIIIlIlllIIIlIlIIl() {
        return this.IIIllIlIllIIllIlIlllIllIl;
    }

    public SkyBlockAddonsManaBarChild IlllIIlIIIllllIIlIlIlIIII() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public SkyBlockAddonsManaTextChild IlIIIllIlIlIlIIllIlIIlIII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public SkyBlockAddonsHealthBarChild IIIIIIIIIIIIIIIIlIllIlllI() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public SkyBlockAddonsHealthTextChild lIlllIIIIllIIIIIllIIllIIl() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public SkyBlockAddonsDefenseTextChild IlIIlIlIlIlIIlIlIIIIlIIll() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public SkyBlockAddonsDefensePercentageChild lIIllIIIIllllIlIIIIlIlIIl() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public SkyBlockAddonsDefenseIconChild IlIIIIIIIIlIIllllIlIllllI() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public SkyBlockAddonsSpeedTextChild IIlllIIIIIIIIIIllllIlIIlI() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public SkyblockAddonsBirchParkRainmaker lIllIIIIlllIlllIIIlIllIIl() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public SkyblockAddonsdarkAuctionoTimer lIIlIIIlIIIlIlllIllIlIIll() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public SkyblockAddonsEndstoneProtector IIllIllllIIlllIlIIIIIIlll() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public SkyblockAddonsMagmaTimer lIIIlIlIlIIlIllIIllIlllIl() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public SkyBlockAddonsPowerOrbStausChild lIIllIlllIIIlIlllIIIIIlIl() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public SkyblockAddonsBoneDisplay lIlIlIIlIIIlIllIllIIlIIIl() {
        return this.llIllIlIllIlllIllIIIIllII;
    }

    public SkyblockAddonsSkillDisplay lIIIlllIlIlIIIlIIIlIlIIII() {
        return this.IllllllllllIlIIIlllIlllll;
    }

    public SkyblockAddonsSummoningEyeCounter lIlIlllIllIlIIIIllllIIllI() {
        return this.lllllIllIlIIlIIlIIIlllIlI;
    }

    public SkyblockAddonsTickerChargesDisplay IIllllIlllIIllIllIIIlllll() {
        return this.IllIIIlllIIIlIlllIlIIlIII;
    }

    public SkyblockAddonsZealotCounter lIlIIllIIIlllIllIllIIIlIl() {
        return this.IIlIllIlIIllIIlIlIllllllI;
    }

    public SkyblockAddonsZealotTotalCounter llIIllIIlllIIIIlIIIIIIllI() {
        return this.lIIIlllIIIIllllIlIIIlIIll;
    }

    public SkyblockAddonsZealotPerEye IIIlIIllIlIIIllIlIIIIIIlI() {
        return this.llIIIlIllIIIIlIIIlIlIllIl;
    }

    public SkyblockAddonsBaitList IlIlllllIIIIlllIlIIlIIIll() {
        return this.llllIlIllllIlIlIIIllIlIlI;
    }

    public SkyblockAddonsFeatureWarnings llllIIlIIIlIlllIIllllIlIl() {
        return this.IlIllIIlIIlIIIllIllllIIll;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int var1) {
        this.lIIIIllIIIllllllllIIlllIl = var1;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(int var1) {
        this.IIIIlIIlIIIlllllIlllIIlII = var1;
    }

    public void llIlllIIIllllIIlllIllIIIl(int var1) {
        this.IlIlIIlIllllIllIIlIlIllII = var1;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(SkyblockWrapperBridge var1) {
        this.llIIlllIllIIIlIlIlllIlIII = var1;
    }

    public enum ItemRarity implements IEnumSetting {
        lIlIlIlIlIIlIIlIIllIIIIIl("COMMON"),
        IlllIIIIIIlllIlIIlllIlIIl("UNCOMMON"),
        lIllIlIIIlIIIIIIIlllIlIll("RARE"),
        llIlllIIIllllIIlllIllIIIl("EPIC"),
        llllIIlIIlIIlIIllIIlIIllI("LEGENDARY"),
        IlIlIlllllIlIIlIlIlllIlIl("MYTHIC"),
        llIIIIIIIllIIllIlIllIIIIl("SPECIAL"),
        lIIIllIllIIllIlllIlIIlllI("VERY SPECIAL");

        public final String IlllllIlIIIlIIlIIllIIlIll;

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.IlllllIlIIIlIIlIIllIIlIll.toLowerCase().replaceAll(" ", "_");
        }

        public String toString() {
            return this.IlllllIlIIIlIIlIIllIIlIll;
        }

        public String IlllIIIIIIlllIlIIlllIlIIl() {
            return this.IlllllIlIIIlIIlIIllIIlIll;
        }

        ItemRarity(String var3) {
            this.IlllllIlIIIlIIlIIllIIlIll = var3;
        }
    }

    public enum IlllIIIIIIlllIlIIlllIlIIl implements IEnumSetting {
        lIlIlIlIlIIlIIlIIllIIIIIl("free"),
        IlllIIIIIIlllIlIIlllIlIIl("three"),
        lIllIlIIIlIIIIIIIlllIlIll("five"),
        llIlllIIIllllIIlllIllIIIl("six");

        public final String llllIIlIIlIIlIIllIIlIIllI;

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.name();
        }

        public String toString() {
            return this.get(this.llllIIlIIlIIlIIllIIlIIllI);
        }

        IlllIIIIIIlllIlIIlllIlIIl(String var3) {
            this.llllIIlIIlIIlIIllIIlIIllI = var3;
        }
    }

    public enum BackpackStyle implements IEnumSetting {
        lIlIlIlIlIIlIIlIIllIIIIIl("regular"),
        IlllIIIIIIlllIlIIlllIlIIl("compact");

        public final String lIllIlIIIlIIIIIIIlllIlIll;

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return WordUtils.capitalize(this.lIllIlIIIlIIIIIIIlllIlIll);
        }

        public String toString() {
            return this.get(this.lIllIlIIIlIIIIIIIlllIlIll);
        }

        BackpackStyle(String var3) {
            this.lIllIlIIIlIIIIIIIlllIlIll = var3;
        }
    }
}