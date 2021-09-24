package com.moonsworth.lunar.client.profile.main;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.gui.CustomScreen;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.UsedEnum;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.cosmetic.CosmeticType;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.json.file.JsonFile;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.notification.NotificationPosition;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.*;
import com.moonsworth.lunar.client.ui.component.Debug;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.SettingsUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuUIWrapper;
import com.moonsworth.lunar.client.util.MathHelperUtil;
import com.moonsworth.lunar.client.util.ScaledResolutionHelper;
import org.apache.commons.lang3.text.WordUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class GeneralOptions extends ItemSetLoader<AbstractSetting<?>> implements JsonFile {
    @Debug
    public BooleanSetting lIlIlIlIlIIlIIlIIllIIIIIl;
    @Debug
    public EnumSetting<UsedEnum> IlllIIIIIIlllIlIIlllIlIIl;
    public BooleanSetting lIllIlIIIlIIIIIIIlllIlIll;
    public EnumSetting<NotificationPosition> llIlllIIIllllIIlllIllIIIl;
    public BooleanSetting llllIIlIIlIIlIIllIIlIIllI;
    public BooleanSetting IlIlIlllllIlIIlIlIlllIlIl;
    public BooleanSetting llIIIIIIIllIIllIlIllIIIIl;
    public EnumSetting<GeneralOptions.SomeScaleFactorShit> lIIIllIllIIllIlllIlIIlllI;
    public EnumSetting<GlassRenderSetting> IlllllIlIIIlIIlIIllIIlIll;
    public BooleanSetting llIIlIlIIIllIlIlIlIIlIIll;
    public BooleanSetting llIIIlllIIlllIllllIlIllIl;
    public BooleanSetting lllllIllIllIllllIlIllllII;
    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI;
    public BooleanSetting lIlIIIIIIlIIIllllIllIIlII;
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;
    public BooleanSetting IIlIllIlllllllIIlIIIllIIl;
    public BooleanSetting lIIlIlllIlIlIIIlllIIlIIII;
    public BooleanSetting llIllIlIllIlllIllIIIIllII;
    public BooleanSetting IllllllllllIlIIIlllIlllll;
    public EnumSetting<GeneralOptions.SortingOptions> lllllIllIlIIlIIlIIIlllIlI;
    public BooleanSetting IllIIIlllIIIlIlllIlIIlIII;
    public BooleanSetting searchOptions;
    public BooleanSetting lIIIlllIIIIllllIlIIIlIIll;
    public ColorSetting llIIIlIllIIIIlIIIlIlIllIl;
    public ColorSetting llllIlIllllIlIlIIIllIlIlI;
    public ColorSetting IlIllIIlIIlIIIllIllllIIll;
    public NumberSetting lIllllIllIIlIIlIIIlIIIlII;
    public NumberSetting lIlIlIIIIIIllIlIIIIllIIII;
    public BooleanSetting compactMenu;

    public GeneralOptions() {
        this.compactMenu = new BooleanSetting("compact_menu", false);
        this.compactMenu.lIlIlIlIlIIlIIlIIllIIIIIl((bl) -> {
            if (Ref.llIIIlllIIlllIllllIlIllIl() == SettingsUIScreen.class) {
                SettingsUIScreen settingsUIScreen = Ref.getWorld() == null ? (SettingsUIScreen) ((MainMenuUIWrapper) ((WrappedGuiScreenBridge) Ref.getMinecraft().bridge$getCurrentScreen()).getCustomScreen()).bruh() : (SettingsUIScreen) ((WrappedGuiScreenBridge) Ref.getMinecraft().bridge$getCurrentScreen()).getCustomScreen();
                settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl().llIIIIIIIllIIllIlIllIIIIl().initialize();
            }
        });
        this.lllllIllIlIIlIIlIIIlllIlI.lIlIlIlIlIIlIIlIIllIIIIIl((lIllIlIIIlIIIIIIIlllIlIll2) -> {
            if (Ref.llIIIlllIIlllIllllIlIllIl() == SettingsUIScreen.class) {
                SettingsUIScreen settingsUIScreen = Ref.getWorld() == null ? (SettingsUIScreen) ((MainMenuUIWrapper) ((WrappedGuiScreenBridge) Ref.getMinecraft().bridge$getCurrentScreen()).getCustomScreen()).bruh() : (SettingsUIScreen) ((WrappedGuiScreenBridge) Ref.getMinecraft().bridge$getCurrentScreen()).getCustomScreen();
                settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl().llIIIIIIIllIIllIlIllIIIIl().initialize();
            }
        });
    }


    @Override
    public Set lIlIlIlIlIIlIIlIIllIIIIIl() {
        ArrayList<AbstractSetting<?>> arrayList = new ArrayList<>();
        SettingLabel settingLabel = new SettingLabel("texturePackOptions");
        AbstractSetting<?>[] abstractSettingArray = new AbstractSetting[37];
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new BooleanSetting("debug_01", true);
        abstractSettingArray[0] = this.lIlIlIlIlIIlIIlIIllIIIIIl;
        this.IlllIIIIIIlllIlIIlllIlIIl = new EnumSetting<>("debug_enum", UsedEnum.ALL);
        abstractSettingArray[1] = this.IlllIIIIIIlllIlIIlllIlIIl;
        abstractSettingArray[2] = new SettingLabel("hudOptions");
        this.llIlllIIIllllIIlllIllIIIl = new EnumSetting<>("popup_location", NotificationPosition.TOP_RIGHT);
        abstractSettingArray[3] = this.llIlllIIIllllIIlllIllIIIl;
        this.llllIIlIIlIIlIIllIIlIIllI = new BooleanSetting("shift_effects", false);
        abstractSettingArray[4] = this.llllIIlIIlIIlIIllIIlIIllI;
        this.llIllIlIllIlllIllIIIIllII = new IIlIllIlllllllIIlIIIllIIl("achievements", Bridge.getMinecraftVersion().lIllIlIIIlIIIIIIIlllIlIll() ? "advancements" : "achievements", true);
        abstractSettingArray[5] = this.llIllIlIllIlllIllIIIIllII;
        this.IllllllllllIlIIIlllIlllll = new BooleanSetting("tutorial_hints", true, () -> Bridge.getMinecraftVersion().llIlllIIIllllIIlllIllIIIl());
        abstractSettingArray[6] = this.IllllllllllIlIIIlllIlllll;
        this.IlIlIlllllIlIIlIlIlllIlIl = new BooleanSetting("show_hud_in_debug", false);
        abstractSettingArray[7] = this.IlIlIlllllIlIIlIlIlllIlIl;
        this.llIIIIIIIllIIllIlIllIIIIl = new BooleanSetting("show_hud_in_shift_tab", false);
        abstractSettingArray[8] = this.llIIIIIIIllIIllIlIllIIIIl;
        this.lllllIllIllIllllIlIllllII = new BooleanSetting("friends_menu_disable", false);
        abstractSettingArray[9] = this.lllllIllIllIllllIlIllllII;
        this.lIlIIIIIIlIIIllllIllIIlII = new BooleanSetting("showInF5", true);
        abstractSettingArray[10] = this.lIlIIIIIIlIIIllllIllIIlII;
        this.lllIIIIIlllIIlIllIIlIIIlI = new BooleanSetting("friend_online_status", true);
        abstractSettingArray[11] = this.lllIIIIIlllIIlIllIIlIIIlI;
        this.lIIIllIllIIllIlllIlIIlllI = new EnumSetting<>("use_minecraft_scale_enum", GeneralOptions.SomeScaleFactorShit.OFF);
        abstractSettingArray[12] = this.lIIIllIllIIllIlllIlIIlllI;
        SettingLabel settingLabel2 = new SettingLabel("cosmeticOptions");
        abstractSettingArray[13] = settingLabel2;
        this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("nametag", false);
        abstractSettingArray[14] = this.llIlIIIllIIlIllIllIllllIl;
        this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("nametagLogo", true);
        abstractSettingArray[15] = this.IllIllIIIllIIIlIlIlIIIIll;
        this.IIlIllIlllllllIIlIIIllIIl = new BooleanSetting("tabLogo", true);
        abstractSettingArray[16] = this.IIlIllIlllllllIIlIIIllIIl;
        abstractSettingArray[17] = new SettingLabel("modOptions");
        this.searchOptions = new BooleanSetting("searchOptions", true);
        abstractSettingArray[18] = this.searchOptions;
        this.IllIIIlllIIIlIlllIlIIlIII = new BooleanSetting("lockMods", false);
        abstractSettingArray[19] = this.IllIIIlllIIIlIlllIlIIlIII;
        this.lllllIllIlIIlIIlIIIlllIlI = new EnumSetting("sortingOptions", GeneralOptions.SortingOptions.CUSTOM);
        abstractSettingArray[20] = this.lllllIllIlIIlIIlIIIlllIlI;
        abstractSettingArray[21] = new SettingLabel("miscOptions");
        this.lIllIlIIIlIIIIIIIlllIlIll = new BooleanSetting("borderless_fullscreen", false);
        abstractSettingArray[22] = this.lIllIlIIIlIIIIIIIlllIlIll;
        this.lIIlIlllIlIlIIIlllIIlIIII = new BooleanSetting("weather", false);
        abstractSettingArray[23] = this.lIIlIlllIlIlIIIlllIIlIIII;
        abstractSettingArray[24] = settingLabel;
        this.llIIIlllIIlllIllllIlIllIl = new BooleanSetting("trans_res_pack_menu_bg", false);
        abstractSettingArray[25] = this.llIIIlllIIlllIllllIlIllIl;
        this.llIIlIlIIIllIlIlIlIIlIIll = new BooleanSetting("red_string", false);
        abstractSettingArray[26] = this.llIIlIlIIIllIlIlIlIIlIIll;
        this.IlllllIlIIIlIIlIIllIIlIll = new EnumSetting<>("clear_glass", GlassRenderSetting.OFF);
        abstractSettingArray[27] = this.IlllllIlIIIlIIlIIllIIlIll;
        abstractSettingArray[28] = new SettingLabel("colorOptions");
        this.IlIllIIlIIlIIIllIllllIIll = new ColorSetting("hudLayoutColor", -1);
        abstractSettingArray[29] = this.IlIllIIlIIlIIIllIllllIIll;
        this.llIIIlIllIIIIlIIIlIlIllIl = new ColorSetting("text", -1);
        abstractSettingArray[30] = this.llIIIlIllIIIIlIIIlIlIllIl;
        this.llllIlIllllIlIlIIIllIlIlI = new ColorSetting("background", 0x6F000000);
        abstractSettingArray[31] = this.llllIlIllllIlIlIIIllIlIlI;
        abstractSettingArray[32] = new ButtonsSetting("applyToAll", (f, f2, n) -> {
            for (ConfigurableFeature configurableFeature : Ref.getLC().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl()) {
                for (AbstractSetting<?> abstractSetting : configurableFeature.lllIIIIIlllIIlIllIIlIIIlI()) {
                    if (!(abstractSetting instanceof ColorSetting)) continue;
                    ColorSetting colorSetting = (ColorSetting) abstractSetting;
                    if (colorSetting.lIIlIlllIlIlIIIlllIIlIIII().contains("text") && colorSetting != Ref.getLC().lllllIllIllIllllIlIllllII().llIIIlllIIlllIllllIlIllIl().lllIIIIIlllIIlIllIIlIIIlI) {
                        colorSetting.IlllIIIIIIlllIlIIlllIlIIl(this.llIIIlIllIIIIlIIIlIlIllIl);
                    }
                    if (!colorSetting.lIIlIlllIlIlIIIlllIIlIIII().contains("background") || colorSetting == Ref.getLC().lllllIllIllIllllIlIllllII().llIIIlllIIlllIllllIlIllIl().lIlIIIIIIlIIIllllIllIIlII)
                        continue;
                    colorSetting.IlllIIIIIIlllIlIIlllIlIIl(this.llllIlIllllIlIlIIIllIlIlI);
                }
            }
            return true;
        });
        abstractSettingArray[33] = new SettingLabel("sizeOption");
        this.lIlIlIIIIIIllIlIIIIllIIII = new NumberSetting("backgroundHeight", 18, 10, 24);
        abstractSettingArray[34] = this.lIlIlIIIIIIllIlIIIIllIIII;
        this.lIllllIllIIlIIlIIIlIIIlII = new NumberSetting("backgroundWidth", 56, 40, 72, 0);
        abstractSettingArray[35] = this.lIllllIllIIlIIlIIIlIIIlII;
        abstractSettingArray[36] = new ButtonsSetting("applyToAll", (f, f2, n) -> {
            for (ConfigurableFeature configurableFeature : Ref.getLC().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl()) {
                for (AbstractSetting<?> abstractSetting : configurableFeature.lllIIIIIlllIIlIllIIlIIIlI()) {
                    if (!(abstractSetting instanceof NumberSetting)) continue;
                    NumberSetting numberSetting = (NumberSetting) abstractSetting;
                    if (numberSetting.lIIlIlllIlIlIIIlllIIlIIII().contains("backgroundHeight")) {
                        numberSetting.lIlIlIlIlIIlIIlIIllIIIIIl(MathHelperUtil.lIlIlIlIlIIlIIlIIllIIIIIl((Integer) this.lIlIlIIIIIIllIlIIIIllIIII.llIlllIIIllllIIlllIllIIIl(), (Integer) numberSetting.lllllIllIllIllllIlIllllII(), (Integer) numberSetting.lllIIIIIlllIIlIllIIlIIIlI()));
                    }
                    if (!numberSetting.lIIlIlllIlIlIIIlllIIlIIII().contains("backgroundWidth")) continue;
                    numberSetting.lIlIlIlIlIIlIIlIIllIIIIIl(MathHelperUtil.lIlIlIlIlIIlIIlIIllIIIIIl((Integer) this.lIllllIllIIlIIlIIIlIIIlII.llIlllIIIllllIIlllIllIIIl(), (Integer) numberSetting.lllllIllIllIllllIlIllllII(), (Integer) numberSetting.lllIIIIIlllIIlIllIIlIIIlI()));
                }
            }
            return true;
        });
        Collections.addAll(arrayList, abstractSettingArray);
        if (Bridge.getMinecraftVersion().llIlllIIIllllIIlllIllIIIl()) {
            this.lIIIlllIIIIllllIlIIIlIIll = new BooleanSetting("modernKeybindHandling", false);
            arrayList.add(arrayList.indexOf(settingLabel), this.lIIIlllIIIIllllIlIIIlIIll);
        }
        int n2 = arrayList.indexOf(settingLabel2);
        for (CosmeticType cosmeticType : CosmeticType.values()) {
            arrayList.add(n2 + 1, cosmeticType.lIIIllIllIIllIlllIlIIlllI());
        }
        return ImmutableSet.copyOf(arrayList);
    }

    @Override
    public void b_() {
        super.b_();
        this.load();
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl((bl) -> LunarLogger.info((Object) "Debugging has been %s for %s type(s).", bl ? "enabled" : "disabled", this.IlllIIIIIIlllIlIIlllIlIIl.llIlllIIIllllIIlllIllIIIl().name()));
        this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl((illlIIIIIIlllIlIIlllIlIIl) -> {
            if (Ref.getMinecraft().bridge$getCurrentScreen() != null && Ref.getMinecraft().bridge$getCurrentScreen() instanceof WrappedGuiScreenBridge) {
                CustomScreen customScreen = ((WrappedGuiScreenBridge) Ref.getMinecraft().bridge$getCurrentScreen()).getCustomScreen();
                if (!(customScreen instanceof SettingsUIScreen) && !(customScreen instanceof MainMenuUIWrapper)) {
                    return;
                }
                SettingsUIScreen settingsUIScreen = customScreen instanceof MainMenuUIWrapper ? (SettingsUIScreen) ((MainMenuUIWrapper) customScreen).bruh() : (SettingsUIScreen) customScreen;
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(new ScaledResolutionHelper(Ref.getMinecraft()));
                settingsUIScreen.llllIIlIIlIIlIIllIIlIIllI();
            }
        });
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl((bl) -> {
            if (System.currentTimeMillis() - Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().getSwitchTime() < 500L) {
                return;
            }
            if (Ref.getMinecraft().bridge$isFullScreen()) {
                Ref.getMinecraft().bridge$toggleFullscreen();
                Ref.getMinecraft().bridge$toggleFullscreen();
            }
        });
        this.llIIlIlIIIllIlIlIlIIlIIll.IlllIIIIIIlllIlIIlllIlIIl((bl) -> Ref.getMinecraft().bridge$getRenderGlobal().bridge$reloadChunks());
        this.IlllllIlIIIlIIlIIllIIlIll.IlllIIIIIIlllIlIIlllIlIIl((glassRenderSetting) -> Ref.getMinecraft().bridge$getRenderGlobal().bridge$reloadChunks());
    }


    @Override
    public File IlIlIlllllIlIIlIlIlllIlIl() {
        return new File(LunarClient.getInstance().IlIlIlllllIlIIlIlIlllIlIl() + File.separator + Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().getSelectedProfile().getName(), this.llllIIlIIlIIlIIllIIlIIllI());
    }

    @Override
    public String llllIIlIIlIIlIIllIIlIIllI() {
        return "general.json";
    }

    @Override
    public void read(final JsonObject jsonObject) {
        this.compactMenu.read(jsonObject);
        for (AbstractSetting<?> abstractSetting : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                abstractSetting.read(jsonObject);
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public void write(final JsonObject jsonObject) {
        this.compactMenu.write(jsonObject);
        for (AbstractSetting<?> abstractSetting : this.llIlllIIIllllIIlllIllIIIl()) {
            try {
                abstractSetting.write(jsonObject);
            } catch (Exception ignored) {
            }
        }
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.save();
    }

    public BooleanSetting IlllllIlIIIlIIlIIllIIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public EnumSetting llIIlIlIIIllIlIlIlIIlIIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public BooleanSetting llIIIlllIIlllIllllIlIllIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public EnumSetting lllllIllIllIllllIlIllllII() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public BooleanSetting lllIIIIIlllIIlIllIIlIIIlI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public BooleanSetting lIlIIIIIIlIIIllllIllIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public BooleanSetting llIlIIIllIIlIllIllIllllIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public EnumSetting IllIllIIIllIIIlIlIlIIIIll() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public EnumSetting IIlIllIlllllllIIlIIIllIIl() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public BooleanSetting lIIlIlllIlIlIIIlllIIlIIII() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public BooleanSetting llIllIlIllIlllIllIIIIllII() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public BooleanSetting IllllllllllIlIIIlllIlllll() {
        return this.lllllIllIllIllllIlIllllII;
    }

    public BooleanSetting lllllIllIlIIlIIlIIIlllIlI() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public BooleanSetting IllIIIlllIIIlIlllIlIIlIII() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public BooleanSetting IIlIllIlIIllIIlIlIllllllI() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public ColorSetting lIIIlllIIIIllllIlIIIlIIll() {
        return this.llIIIlIllIIIIlIIIlIlIllIl;
    }

    public ColorSetting llIIIlIllIIIIlIIIlIlIllIl() {
        return this.llllIlIllllIlIlIIIllIlIlI;
    }

    public ColorSetting llllIlIllllIlIlIIIllIlIlI() {
        return this.IlIllIIlIIlIIIllIllllIIll;
    }

    public NumberSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.lIllllIllIIlIIlIIIlIIIlII;
    }

    public NumberSetting lIllllIllIIlIIlIIIlIIIlII() {
        return this.lIlIlIIIIIIllIlIIIIllIIII;
    }

    public BooleanSetting getCompactMenu() {
        return this.compactMenu;
    }

    public BooleanSetting lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public BooleanSetting IlIIlIIlIIlIIllIIIllIIllI() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public BooleanSetting IIlIlIIIllIIllllIllllIlIl() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public BooleanSetting lllllIIIIlIlllIllIIIlIIlI() {
        return this.llIllIlIllIlllIllIIIIllII;
    }

    public BooleanSetting IIlllIllIlIllIllIIllIlIIl() {
        return this.IllllllllllIlIIIlllIlllll;
    }

    public EnumSetting lIlIIlIlllIIlIIIlIlIlIllI() {
        return this.lllllIllIlIIlIIlIIIlllIlI;
    }

    public BooleanSetting lIIlllIIIIIlllIIIlIlIlllI() {
        return this.IllIIIlllIIIlIlllIlIIlIII;
    }

    public BooleanSetting getSearchOptions() {
        return this.searchOptions;
    }

    public BooleanSetting IlIIIlIlIlIlIlIllIIllIIlI() {
        return this.lIIIlllIIIIllllIlIIIlIIll;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final BooleanSetting liIlIIIIIIlIIlIIllIlIIlII) {
        this.compactMenu = liIlIIIIIIlIIlIIllIlIIlII;
    }

    public enum ChatColor implements IEnumSetting {
        OFF,
        DARK_BLUE,
        DARK_GREEN,
        DARK_AQUA,
        DARK_RED,
        DARK_PURPLE,
        GOLD,
        GRAY,
        DARK_GRAY,
        BLUE,
        GREEN,
        AQUA,
        RED,
        LIGHT_PURPLE,
        YELLOW,
        WHITE;
        @Override
        public String toString() {
            return WordUtils.capitalize(this.name().toLowerCase().replace("_", " "));
        }

        @Override
        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.name();
        }

        public EnumChatColor IlllIIIIIIlllIlIIlllIlIIl() {
            if (this == OFF) {
                return EnumChatColor.RESET;
            }
            return EnumChatColor.valueOf(this.name());
        }
    }

    public enum SortingOptions implements IEnumSetting {
        CUSTOM("custom"),
        ALPHABETICAL( "alphabetical"),
        NORMAL("normal");

        public final String llIlllIIIllllIIlllIllIIIl;

        @Override
        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.name();
        }

        @Override
        public String toString() {
            return this.get(this.llIlllIIIllllIIlllIllIIIl);
        }

        SortingOptions(final String llIlllIIIllllIIlllIllIIIl) {
            this.llIlllIIIllllIIlllIllIIIl = llIlllIIIllllIIlllIllIIIl;
        }
    }

    // IlllIIIIIIlllIlIIlllIlIIl
    public enum SomeScaleFactorShit implements IEnumSetting {
        OFF("off"),
        MODS( "mods"),
        ALL( "all");

        public final String llIlllIIIllllIIlllIllIIIl;

        @Override
        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.name();
        }

        @Override
        public String toString() {
            return this.get(this.llIlllIIIllllIIlllIllIIIl);
        }

        SomeScaleFactorShit(final String llIlllIIIllllIIlllIllIIIl) {
            this.llIlllIIIllllIIlllIllIIIl = llIlllIIIllllIIlllIllIIIl;
        }
    }
}
