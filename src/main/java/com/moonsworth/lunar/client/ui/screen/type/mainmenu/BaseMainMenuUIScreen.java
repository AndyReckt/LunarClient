package com.moonsworth.lunar.client.ui.screen.type.mainmenu;

import com.google.common.collect.Lists;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.SmallIconUIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.base.CosmeticsUIScreenBase;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.login.AccountButtonListUIComponent;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.login.MainMenuLoginUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.movement.MovementUI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Decencies
 * @since 10/07/2021 18:47
 */
public class BaseMainMenuUIScreen extends AbstractUIScreen {
    public static int llIlIIIllIIlIllIllIllllIl = 0;
    public AccountButtonListUIComponent lIlIlIlIlIIlIIlIIllIIIIIl;
    public SmallIconUIComponent menu;
    public SmallIconUIComponent cosmetics;
    public SmallIconUIComponent options;
    public SmallIconUIComponent language;
    public SmallIconUIComponent exit;
    public SmallIconUIComponent realms;
    public SmallIconUIComponent replays;

    public BaseMainMenuUIScreen() {
        this.menu.onMouseClick((float f, float f2, int n) -> {
            if (Ref.llIIIlllIIlllIllllIlIllIl() != MainMenuUIScreen.class) {
                return false;
            }
            Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuUIWrapper(new MovementUI())));
            return true;
        });
        this.cosmetics.onMouseClick((float f, float f2, int n) -> {
            if (!Ref.getLC().llIlIIIllIIlIllIllIllllIl().llIIIlllIIlllIllllIlIllIl()) {
                Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuLoginUIScreen()));
                return false;
            }
            if (Ref.llIIIlllIIlllIllllIlIllIl() != MainMenuUIScreen.class) {
                return false;
            }
            Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuUIWrapper(new CosmeticsUIScreenBase(Ref.getMinecraft().bridge$getCurrentScreen()))));
            return true;
        });
        this.options.onMouseClick((float f, float f2, int n) -> {
            Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initGuiOptions(null));
            return true;
        });
        this.language.onMouseClick((float f, float f2, int n) -> {
            Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initLanguage(null));
            return true;
        });
        if (this.realms != null && Bridge.getMinecraftVersion().isLatestVersion()) {
            this.realms.onMouseClick((float f, float f2, int n) -> {
                if (!Ref.getLC().llIlIIIllIIlIllIllIllllIl().llIIIlllIIlllIllllIlIllIl()) {
                    Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuLoginUIScreen()));
                    return false;
                }
                Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initRealms(null));
                return true;
            });
        }
        this.exit.onMouseClick((float f, float f2, int n) -> {
            Ref.getMinecraft().bridge$shutdownMinecraftApplet();
            return true;
        });
        this.exit.lIllIlIIIlIIIIIIIlllIlIll(new ColorEase(0x20FFFFFF, 1358901296));
        if (this.replays != null) {
            this.replays.onMouseClick((float f, float f2, int n) -> {
                if (!Ref.getLC().llIlIIIllIIlIllIllIllllIl().llIIIlllIIlllIllllIlIllIl()) {
                    Ref.getMinecraft().bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuLoginUIScreen()));
                    return false;
                }
                Ref.getLC().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().lIllllIllIIlIIlIIIlIIIlII().handleMainMenuButton();
                return true;
            });
        }
    }

    @Override
    public List llIIlIlIIIllIlIlIlIIlIIll() {
        UIComponent[] uIComponentArray = new UIComponent[6];
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new AccountButtonListUIComponent(this, null);
        uIComponentArray[0] = this.lIlIlIlIlIIlIIlIIllIIIIIl;
        this.exit = new SmallIconUIComponent(null, "btnExit", Bridge.getInstance().initResourceLocation("lunar", "icons/mainmenu/exit-17x17.png"));
        uIComponentArray[1] = this.exit;
        this.menu = new SmallIconUIComponent(null, "btnMenu", Bridge.getInstance().initResourceLocation("lunar", "icons/assets/logo-22x22.png"));
        uIComponentArray[2] = this.menu;
        this.cosmetics = new SmallIconUIComponent(null, "btnCosmetics", Bridge.getInstance().initResourceLocation("lunar", "icons/mainmenu/cosmetics-20x20.png"));
        uIComponentArray[3] = this.cosmetics;
        this.options = new SmallIconUIComponent(null, "btnOptions", Bridge.getInstance().initResourceLocation("lunar", "icons/mainmenu/cog-20x20.png"));
        uIComponentArray[4] = this.options;
        this.language = new SmallIconUIComponent(null, "btnLanguage", Bridge.getInstance().initResourceLocation("lunar", "icons/mainmenu/globe-20x20.png"));
        uIComponentArray[5] = this.language;
        ArrayList<UIComponent> arrayList = Lists.newArrayList(uIComponentArray);
        if (Bridge.getMinecraftVersion().isLatestVersion()) {
            this.realms = new SmallIconUIComponent(null, Bridge.getMinecraftVersion().isLatestVersion() ? "btnRealms" : null, Bridge.getInstance().initResourceLocation("lunar", "icons/mainmenu/realms-24x24.png"));
            arrayList.add(this.realms);
        }
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().getDetails().isEnabledOnCurrentVersion()) {
            this.replays = new SmallIconUIComponent(null, "btnReplayViewer", Bridge.getInstance().initResourceLocation("lunar", "icons/mainmenu/camera-20x20.png"));
            arrayList.add(this.replays);
        }
        return arrayList;
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        float f = 18.0f;
        float f2 = 5.0f;
        this.exit.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() - f - 8.0f, 10.0f, f, f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.setPositionAndSize(f - f / 2.0f, 10.0f, f, f);
        List<UIComponent> list = this.components.stream().filter(uIComponent -> uIComponent instanceof SmallIconUIComponent && uIComponent != this.exit).collect(Collectors.toList());
        int n = list.size();
        float f3 = this.IllllllllllIlIIIlllIlllll() / 2.0f - (float)n * (f + f2) / 2.0f;
        float f4 = this.lllllIllIlIIlIIlIIIlllIlI() - f - 12.0f;
        for (UIComponent uIComponent2 : list) {
            uIComponent2.setPositionAndSize(f3, f4, f, f);
            f3 += f + f2;
        }
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
        ++llIlIIIllIIlIllIllIllllIl;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        if (Ref.getWorld() == null) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableAlpha();
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$renderSkybox(this.screenWidth, this.screenHeight, llIlIIIllIIlIllIllIllllIl, f);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableAlpha();
        }
        super.drawScreen(n, n2, f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {


        this.llIIIIIIIllIIllIlIllIIIIl();
    }

    public void llIIIIIIIllIIllIlIllIIIIl() {
        FontRegistry.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl("Lunar Client " + Bridge.getMinecraftVersion().IlIlIlllllIlIIlIlIlllIlIl() + " (" + LunarClient.IlIlllIlIlllIllIIIIIIlllI() + "/" + LunarClient.llIIIllllIIIllIIIIlIlIlll() + ")", 10.0f, this.lllllIllIlIIlIIlIIIlllIlI() - 16.0f, -1597125171);
        FontRegistry.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl("Copyright Mojang Studios. Do not distribute!", this.IllllllllllIlIIIlllIlllll() - 170.0f, this.lllllIllIlIIlIIlIIIlllIlI() - 16.0f, -1597125171);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(char c, KeyType keyType) {
    }

    @Override
    public void lIlIIIIIIlIIIllllIllIIlII() {
    }

    @Override
    public String getLanguagePath() {
        return super.getLanguagePath() + ".mainmenu";
    }
}
