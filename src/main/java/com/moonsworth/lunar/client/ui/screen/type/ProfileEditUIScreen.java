package com.moonsworth.lunar.client.ui.screen.type;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;
import com.moonsworth.lunar.client.profile.Profile;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.SettingLabel;
import com.moonsworth.lunar.client.ui.component.type.setting.*;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.event.MouseEventCallback;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuUIWrapper;
import com.moonsworth.lunar.client.ui.screen.type.warning.WarningUIScreen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Decencies
 * @since 11/07/2021 22:28
 */
public class ProfileEditUIScreen extends AbstractUIScreen {
    public com.moonsworth.lunar.client.ui.component.type.setting.lIIlIlllIlIlIIIlllIIlIIII lIlIlIlIlIIlIIlIIllIIIIIl;
    public final TextboxWithIcon IlllIIIIIIlllIlIIlllIlIIl;
    public final com.moonsworth.lunar.client.ui.component.type.setting.llIlIIIllIIlIllIllIllllIl lIllIlIIIlIIIIIIIlllIlIll;
    public final llIlIIIllIIlIllIllIllllIl llIlllIIIllllIIlllIllIIIl;
    public final llIlIIIllIIlIllIllIllllIl llIIIlllIIlllIllllIlIllIl;
    public final TextboxWithIcon lllllIllIllIllllIlIllllII;
    public SmallIconUIComponent lllIIIIIlllIIlIllIIlIIIlI;
    public final DefaultButtonUIComponent lIlIIIIIIlIIIllllIllIIlII;
    public final DefaultButtonUIComponent llIlIIIllIIlIllIllIllllIl;
    public final DefaultButtonUIComponent IllIllIIIllIIIlIlIlIIIIll;
    public final SmallIconUIComponent IIlIllIlllllllIIlIIIllIIl;
    public final GuiScreenBridge lIIlIlllIlIlIIIlllIIlIIII;
    public final Profile llIllIlIllIlllIllIIIIllII;
    public String IllllllllllIlIIIlllIlllll;
    public ResourceLocationBridge lllllIllIlIIlIIlIIIlllIlI;
    public final float IllIIIlllIIIlIlllIlIIlIII = 152.0F;

    public ProfileEditUIScreen(GuiScreenBridge var1, Profile var2) {
        this.lIIlIlllIlIlIIIlllIIlIIII = var1;
        this.llIllIlIllIlllIllIIIIllII = var2;
        this.IllllllllllIlIIIlllIlllll = var2.getIconName();
        if (!this.IllllllllllIlIIIlllIlllll.equalsIgnoreCase("")) {
            this.lllllIllIlIIlIIlIIIlllIlI = Bridge.getInstance().initResourceLocation("lunar", "icons/profiles/" + this.IllllllllllIlIIIlllIlllll + ".png");
        } else {
            this.lllllIllIlIIlIIlIIIlllIlI = null;
        }

        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of(this.lIllIlIIIlIIIIIIIlllIlIll = new llIlIIIllIIlIllIllIllllIl(new SettingLabel("profileName"), null), this.llIlllIIIllllIIlllIllIIIl = new llIlIIIllIIlIllIllIllllIl(new SettingLabel("icon"), null), this.IlllIIIIIIlllIlIIlllIlIIl = new TextboxWithIcon(this.lIlIlIlIlIIlIIlIIllIIIIIl, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), var2.getDisplayName(), 553648127, 905969663), this.llIIIlllIIlllIllllIlIllIl = new llIlIIIllIIlIllIllIllllIl(new SettingLabel("lblServer"), null), this.lllllIllIllIllllIlIllllII = new TextboxWithIcon(this.lIlIlIlIlIIlIIlIIllIIIIIl, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), var2.getServer().equals("") ? "Unknown" : var2.getServer(), 553648127, 905969663), this.lIlIIIIIIlIIIllllIllIIlII = new DefaultButtonUIComponent(this.lIlIlIlIlIIlIIlIIllIIIIIl, "save"), this.llIlIIIllIIlIllIllIllllIl = new DefaultButtonUIComponent(this.lIlIlIlIlIIlIIlIIllIIIIIl, "reset"), this.IllIllIIIllIIIlIlIlIIIIll = new DefaultButtonUIComponent(this.lIlIlIlIlIIlIIlIIllIIIIIl, "delete"), this.IIlIllIlllllllIIlIIIllIIl = new SmallIconUIComponent(this.lIlIlIlIlIIlIIlIIllIIIIIl, Bridge.getInstance().initResourceLocation("lunar", "icons/cosmetics/back-40x40.png")), this.lllIIIIIlllIIlIllIIlIIIlI = new SmallIconUIComponent(this.lIlIlIlIlIIlIIlIIllIIIIIl, Bridge.getInstance().initResourceLocation("lunar", "icons/assets/arrow-down-17x17.png"))));
        this.lllIIIIIlllIIlIllIIlIIIlI.onMouseClick((var1x, var2x, var3) -> {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(new IllIllIIIllIIIlIlIlIIIIll(this.lIlIlIlIlIIlIIlIIllIIIIIl) {
                public List lIllIlIIIlIIIIIIIlllIlIll() {
                    ArrayList var1 = new ArrayList();
                    ProfileIconType[] var2 = ProfileIconType.values();
                    int var3 = var2.length;

                    for (ProfileIconType var5 : var2) {
                        lIlIlIIIIIIllIlIIIIllIIII var6;
                        var1.add(var6 = new lIlIlIIIIIIllIlIIIIllIIII(this.sumTing, var5.lIIIllIllIIllIlllIlIIlllI, -1));
                        var6.onMouseClick((var2x, var3x, var4x) -> {
                            ProfileEditUIScreen.this.IllllllllllIlIIIlllIlllll = var5.llIIIIIIIllIIllIlIllIIIIl;
                            if (var5 != ProfileIconType.lIlIlIlIlIIlIIlIIllIIIIIl) {
                                ProfileEditUIScreen.this.lllllIllIlIIlIIlIIIlllIlI = Bridge.getInstance().initResourceLocation("lunar", "icons/profiles/" + ProfileEditUIScreen.this.IllllllllllIlIIIlllIlllll + ".png");
                            } else {
                                ProfileEditUIScreen.this.lllllIllIlIIlIIlIIIlllIlI = null;
                            }

                            ProfileEditUIScreen.this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl((IllIllIIIllIIIlIlIlIIIIll) null);
                            return true;
                        });
                    }

                    return var1;
                }
            });
            this.lIlIlIlIlIIlIIlIIllIIIIIl.llIllIlIllIlllIllIIIIllII().lIlIlIlIlIIlIIlIIllIIIIIl(var1x, var2x);
            return true;
        });
        this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll(new ColorEase(553648127, 1358901296));
        this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll(false);
        this.IlllIIIIIIlllIlIIlllIlIIl.setText(var2.getDisplayName());
        this.IlllIIIIIIlllIlIIlllIlIIl.llIIIlllIIlllIllllIlIllIl(20);
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (this.IlllIIIIIIlllIlIIlllIlIIl.IIlIllIlIIllIIlIlIllllllI() == -65536) {
                this.IlllIIIIIIlllIlIIlllIlIIl.llIIlIlIIIllIlIlIlIIlIIll(0);
            }

        });
        this.lllllIllIllIllllIlIllllII.lIllIlIIIlIIIIIIIlllIlIll(false);
        this.lllllIllIllIllllIlIllllII.setText(var2.getServer());
        this.lllllIllIllIllllIlIllllII.llIIIlllIIlllIllllIlIllIl(60);
        this.lllllIllIllIllllIlIllllII.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (this.lllllIllIllIllllIlIllllII.IIlIllIlIIllIIlIlIllllllI() == -65536) {
                this.lllllIllIllIllllIlIllllII.llIIlIlIIIllIlIlIlIIlIIll(0);
            }

        });
        this.lIlIIIIIIlIIIllllIllIIlII.onMouseRelease((var3, var4, var5) -> {
            if (this.IlllIIIIIIlllIlIIlllIlIIl.getText().isEmpty()) {
                this.IlllIIIIIIlllIlIIlllIlIIl.llIIlIlIIIllIlIlIlIIlIIll(-65536);
                return false;
            } else {
                var2.setDisplayName(this.IlllIIIIIIlllIlIIlllIlIIl.getText());
                var2.setIcon(this.IllllllllllIlIIIlllIlllll);
                var2.setServer(this.lllllIllIllIllllIlIllllII.getText());
                Ref.getMinecraft().bridge$displayScreen(var1);
                return true;
            }
        });
        this.llIlIIIllIIlIllIllIllllIl.onMouseClick((var2x, var3, var4) -> {
            GuiScreenBridge var5 = Ref.getMinecraft().bridge$getCurrentScreen();
            Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new WarningUIScreen(this.getLanguagePath() + ".resetProfile", (var2xx) -> {
                if (!var2xx) {
                    Ref.getMinecraft().bridge$displayScreen(var5);
                } else {
                    Profile profile = Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().getSelectedProfile();
                    if (!var2.isActive()) {
                        Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl(var2);
                    }

                    ArrayList list = new ArrayList();
                    Iterator var5x = Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llIlllIIIllllIIlllIllIIIl().values().iterator();

                    while(var5x.hasNext()) {
                        ItemSetLoader var6 = (ItemSetLoader)var5x.next();
                        list.addAll(var6.llIlllIIIllllIIlllIllIIIl());
                    }

                    ConfigurableFeature var10;
                    for(var5x = Ref.getLC().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl().iterator(); var5x.hasNext(); list.addAll(var10.lllIIIIIlllIIlIllIIlIIIlI())) {
                        var10 = (ConfigurableFeature)var5x.next();
                        var10.IlllIIIIIIlllIlIIlllIlIIl(var10.lIlIIIIIIlIIIllllIllIIlII());
                        Iterator var7 = var10.llIIIllllIIIllIIIIlIlIlll().iterator();

                        while(var7.hasNext()) {
                            AbstractFeatureContainerChild var8 = (AbstractFeatureContainerChild)var7.next();
                            var8.IlllIIIIIIlllIlIIlllIlIIl(var8.lIlIIIIIIlIIIllllIllIIlII());
                            list.addAll(var8.lllIIIIIlllIIlIllIIlIIIlI());
                        }

                        if (var10 instanceof DraggableHudMod) {
                            ((DraggableHudMod)var10).lIlIlIlIlIIlIIlIIllIIIIIl(((DraggableHudMod)var10).IIllIlIllIlIllIllIllIllII());
                            ((DraggableHudMod)var10).lIlIlIIIIIIllIlIIIIllIIII();
                        }
                    }

                    Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().getCompactMenu().d_();
                    var5x = list.iterator();

                    while(var5x.hasNext()) {
                        AbstractSetting var11 = (AbstractSetting)var5x.next();
                        var11.d_();
                    }

                    if (!profile.isActive()) {
                        Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl(profile);
                    }

                    SettingsUIScreen var9 = new SettingsUIScreen(null);
                    var9.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(var9.llIIIIIIIllIIllIlIllIIIIl().llIIIIIIIllIIllIlIllIIIIl());
                    if (Ref.getWorld() == null) {
                        Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuUIWrapper(var9)));
                    } else {
                        Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(var9));
                    }

                }
            })));
            return true;
        });
        this.IllIllIIIllIIIlIlIlIIIIll.onMouseClick((var2x, var3, var4) -> {
            if (var2.isDefault()) {
                return false;
            } else {
                GuiScreenBridge var5 = Ref.getMinecraft().bridge$getCurrentScreen();
                Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new WarningUIScreen(this.getLanguagePath() + ".deleteConfirm", (var2xx) -> {
                    if (var2xx) {
                        if (var2.isActive()) {
                            Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getLC().lIlIlIIIIIIllIlIIIIllIIII().llIlllIIIllllIIlllIllIIIl());
                        }

                        LunarClient.getInstance().lIlIlIIIIIIllIlIIIIllIIII().remove(var2);
                        SettingsUIScreen settingsUIScreen = new SettingsUIScreen(null);
                        settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(settingsUIScreen.llIIIIIIIllIIllIlIllIIIIl().llIIIIIIIllIIllIlIllIIIIl());
                        if (Ref.getWorld() == null) {
                            Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuUIWrapper(settingsUIScreen)));
                        } else {
                            Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(settingsUIScreen));
                        }
                    } else {
                        Ref.getMinecraft().bridge$displayScreen(var5);
                    }

                })));
                return true;
            }
        });
        this.IIlIllIlllllllIIlIIIllIIl.onMouseClick((var3, var4, var5) -> {
            if (this.IlllIIIIIIlllIlIIlllIlIIl.getText().equalsIgnoreCase(var2.getDisplayName()) && this.IllllllllllIlIIIlllIlllll.equalsIgnoreCase(var2.getIconName())) {
                Ref.getMinecraft().bridge$displayScreen(var1);
                return true;
            } else {
                GuiScreenBridge var6 = Ref.getMinecraft().bridge$getCurrentScreen();
                Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new WarningUIScreen(this.getLanguagePath() + ".backConfirm", (var2x) -> {
                    if (var2x) {
                        Ref.getMinecraft().bridge$displayScreen(var1);
                    } else {
                        Ref.getMinecraft().bridge$displayScreen(var6);
                    }

                })));
                return true;
            }
        });
    }

    public List llIIlIlIIIllIlIlIlIIlIIll() {
        return ImmutableList.of(this.lIlIlIlIlIIlIIlIIllIIIIIl = new lIIlIlllIlIlIIIlllIIlIIII(null, "profileEditor") {
            public void IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, float var3, float var4) {
                ProfileEditUIScreen.this.lIllIlIIIlIIIIIIIlllIlIll.setPositionAndSize(var1, var2 + 32.0F, 16.0F, 16.0F);
                ProfileEditUIScreen.this.IlllIIIIIIlllIlIIlllIlIIl.setPositionAndSize(var1 + 8.0F, var2 + 48.0F, var3 - 112.0F, 16.0F);
                ProfileEditUIScreen.this.llIIIlllIIlllIllllIlIllIl.setPositionAndSize(var1, var2 + 64.0F, 16.0F, 16.0F);
                ProfileEditUIScreen.this.lllllIllIllIllllIlIllllII.setPositionAndSize(var1 + 8.0F, var2 + 80.0F, var3 - 112.0F, 16.0F);
                ProfileEditUIScreen.this.llIlllIIIllllIIlllIllIIIl.setPositionAndSize(var1 + var3 - 29.0F, var2 + 32.0F, 14.0F, 14.0F);
                ProfileEditUIScreen.this.lllIIIIIlllIIlIllIIlIIIlI.setPositionAndSize(var1 + var3 - 24.0F, var2 + 48.0F, 14.0F, 14.0F);
                byte var5 = 0;
                DefaultButtonUIComponent var10000 = ProfileEditUIScreen.this.lIlIIIIIIlIIIllllIllIIlII;
                float var10001 = var1 + var3;
                int var6 = var5 + 56;
                var10000.setPositionAndSize(var10001 - (float)var6, var2 + 152.0F - 24.0F, 50.0F, 18.0F);
                if (!ProfileEditUIScreen.this.llIllIlIllIlllIllIIIIllII.isDefault()) {
                    var10000 = ProfileEditUIScreen.this.IllIllIIIllIIIlIlIlIIIIll;
                    var10001 = var1 + var3;
                    var6 += 56;
                    var10000.setPositionAndSize(var10001 - (float)var6, var2 + 152.0F - 24.0F, 50.0F, 18.0F);
                }

                if (Ref.getWorld() != null) {
                    var10000 = ProfileEditUIScreen.this.llIlIIIllIIlIllIllIllllIl;
                    var10001 = var1 + var3;
                    var6 += 56;
                    var10000.setPositionAndSize(var10001 - (float)var6, var2 + 152.0F - 24.0F, 50.0F, 18.0F);
                }

                ProfileEditUIScreen.this.IIlIllIlllllllIIlIIIllIIl.setPositionAndSize(var1 + 6.0F, var2 + 152.0F - 24.0F, 18.0F, 18.0F);
            }
        });
    }

    public void llIIIlllIIlllIllllIlIllIl() {
        float var1 = 350.0F;
        float var2 = this.IllllllllllIlIIIlllIlllll() / 2.0F - var1 / 2.0F;
        float var3 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 76.0F;
        this.lIlIlIlIlIIlIIlIIllIIIIIl.setPositionAndSize(var2, var3, var1, 152.0F);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    public void lllllIllIllIllllIlIllllII() {
        this.lIllIlIIIlIIIIIIIlllIlIll.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.get("shortDescriptionChars", 20 - this.IlllIIIIIIlllIlIIlllIlIIl.getText().length()));
        this.llIIIlllIIlllIllllIlIllIl.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.get("lblServer"));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2) {
        if (this.lllllIllIlIIlIIlIIIlllIlI != null) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllllIllIlIIlIIlIIIlllIlI, this.lIlIlIlIlIIlIIlIIllIIIIIl.getX() + this.lIlIlIlIlIIlIIlIIllIIIIIl.getWidth() - 36.0F, this.lIlIlIlIlIIlIIlIIllIIIIIl.getY() + 50.0F, 10.0F, 10.0F);
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, int var3) {
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, int var3) {
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(char var1, KeyType var2) {
    }

    public void lIlIIIIIIlIIIllllIllIIlII() {
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    public String getLanguagePath() {
        return super.getLanguagePath() + ".profile";
    }

    public enum ProfileIconType {
        lIlIlIlIlIIlIIlIIllIIIIIl("", "None"),
        IlllIIIIIIlllIlIIlllIlIIl("clock", "Clock"),
        lIllIlIIIlIIIIIIIlllIlIll("apple", "Apple"),
        llIlllIIIllllIIlllIllIIIl("hypixel", "Hypixel"),
        llllIIlIIlIIlIIllIIlIIllI("crossed-swords", "Swords"),
        IlIlIlllllIlIIlIlIlllIlIl("mouse", "Mouse");

        public final String llIIIIIIIllIIllIlIllIIIIl;
        public final String lIIIllIllIIllIlllIlIIlllI;

        public String toString() {
            return this.lIIIllIllIIllIlllIlIIlllI;
        }

        ProfileIconType(String var3, String var4) {
            this.llIIIIIIIllIIllIlIllIIIIl = var3;
            this.lIIIllIllIIllIlllIlIIlllI = var4;
        }
    }
}