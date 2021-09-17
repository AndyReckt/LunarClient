package com.moonsworth.lunar.client.ui.screen.type.mainmenu;

import com.google.common.collect.Lists;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.llIllIlIllIlllIllIIIIllII;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Decencies
 * @since 10/07/2021 18:47
 */
public class BaseMainMenuUIScreen extends AbstractUIScreen {
    public static int llIlIIIllIIlIllIllIllllIl = 0;
    public ManUserIconUIComponent lIlIlIlIlIIlIIlIIllIIIIIl;
    public llIllIlIllIlllIllIIIIllII IlllIIIIIIlllIlIIlllIlIIl;
    public llIllIlIllIlllIllIIIIllII lIllIlIIIlIIIIIIIlllIlIll;
    public llIllIlIllIlllIllIIIIllII llIlllIIIllllIIlllIllIIIl;
    public llIllIlIllIlllIllIIIIllII llIIIlllIIlllIllllIlIllIl;
    public llIllIlIllIlllIllIIIIllII lllllIllIllIllllIlIllllII;
    public llIllIlIllIlllIllIIIIllII lllIIIIIlllIIlIllIIlIIIlI;
    public llIllIlIllIlllIllIIIIllII lIlIIIIIIlIIIllllIllIIlII;

    public BaseMainMenuUIScreen() {
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (Ref.llIIIlllIIlllIllllIlIllIl() != MainMenuUIScreen.class) {
                return false;
            }
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIWrapper(new MovementUI())));
            return true;
        });
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (!Ref.IlllIIIIIIlllIlIIlllIlIIl().llIlIIIllIIlIllIllIllllIl().llIIIlllIIlllIllllIlIllIl()) {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuLoginUIScreen()));
                return false;
            }
            if (Ref.llIIIlllIIlllIllllIlIllIl() != MainMenuUIScreen.class) {
                return false;
            }
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIWrapper(new CosmeticsUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen()))));
            return true;
        });
        this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initGuiOptions(null));
            return true;
        });
        this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initLanguage(null));
            return true;
        });
        if (this.lllIIIIIlllIIlIllIIlIIIlI != null && Bridge.IlllIIIIIIlllIlIIlllIlIIl().llllIIlIIlIIlIIllIIlIIllI()) {
            this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
                if (!Ref.IlllIIIIIIlllIlIIlllIlIIl().llIlIIIllIIlIllIllIllllIl().llIIIlllIIlllIllllIlIllIl()) {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuLoginUIScreen()));
                    return false;
                }
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initRealms(null));
                return true;
            });
        }
        this.lllllIllIllIllllIlIllllII.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$shutdownMinecraftApplet();
            return true;
        });
        this.lllllIllIllIllllIlIllllII.lIllIlIIIlIIIIIIIlllIlIll(new ColorEase(0x20FFFFFF, 1358901296));
        if (this.lIlIIIIIIlIIIllllIllIIlII != null) {
            this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
                if (!Ref.IlllIIIIIIlllIlIIlllIlIIl().llIlIIIllIIlIllIllIllllIl().llIIIlllIIlllIllllIlIllIl()) {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuLoginUIScreen()));
                    return false;
                }
                Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().lIllllIllIIlIIlIIIlIIIlII().handleMainMenuButton();
                return true;
            });
        }
    }

    @Override
    public List llIIlIlIIIllIlIlIlIIlIIll() {
        UIComponent[] uIComponentArray = new UIComponent[6];
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new ManUserIconUIComponent(this, null);
        uIComponentArray[0] = this.lIlIlIlIlIIlIIlIIllIIIIIl;
        this.lllllIllIllIllllIlIllllII = new llIllIlIllIlllIllIIIIllII(null, "btnExit", Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/mainmenu/exit-17x17.png"));
        uIComponentArray[1] = this.lllllIllIllIllllIlIllllII;
        this.IlllIIIIIIlllIlIIlllIlIIl = new llIllIlIllIlllIllIIIIllII(null, "btnMenu", Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/logo-22x22.png"));
        uIComponentArray[2] = this.IlllIIIIIIlllIlIIlllIlIIl;
        this.lIllIlIIIlIIIIIIIlllIlIll = new llIllIlIllIlllIllIIIIllII(null, "btnCosmetics", Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/mainmenu/cosmetics-20x20.png"));
        uIComponentArray[3] = this.lIllIlIIIlIIIIIIIlllIlIll;
        this.llIlllIIIllllIIlllIllIIIl = new llIllIlIllIlllIllIIIIllII(null, "btnOptions", Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/mainmenu/cog-20x20.png"));
        uIComponentArray[4] = this.llIlllIIIllllIIlllIllIIIl;
        this.llIIIlllIIlllIllllIlIllIl = new llIllIlIllIlllIllIIIIllII(null, "btnLanguage", Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/mainmenu/globe-20x20.png"));
        uIComponentArray[5] = this.llIIIlllIIlllIllllIlIllIl;
        ArrayList<UIComponent> arrayList = Lists.newArrayList(uIComponentArray);
        if (Bridge.IlllIIIIIIlllIlIIlllIlIIl().llllIIlIIlIIlIIllIIlIIllI()) {
            this.lllIIIIIlllIIlIllIIlIIIlI = new llIllIlIllIlllIllIIIIllII(null, Bridge.IlllIIIIIIlllIlIIlllIlIIl().llllIIlIIlIIlIIllIIlIIllI() ? "btnRealms" : null, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/mainmenu/realms-24x24.png"));
            arrayList.add(this.lllIIIIIlllIIlIllIIlIIIlI);
        }
        if (Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().llIIlIlIIIllIlIlIlIIlIIll().lIllIlIIIlIIIIIIIlllIlIll()) {
            this.lIlIIIIIIlIIIllllIllIIlII = new llIllIlIllIlllIllIIIIllII(null, "btnReplayViewer", Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/mainmenu/camera-20x20.png"));
            arrayList.add(this.lIlIIIIIIlIIIllllIllIIlII);
        }
        return arrayList;
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        float f = 18.0f;
        float f2 = 5.0f;
        this.lllllIllIllIllllIlIllllII.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() - f - 8.0f, 10.0f, f, f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f - f / 2.0f, 10.0f, f, f);
        List<UIComponent> list = this.llIIlIlIIIllIlIlIlIIlIIll.stream().filter(uIComponent -> uIComponent instanceof llIllIlIllIlllIllIIIIllII && uIComponent != this.lllllIllIllIllllIlIllllII).collect(Collectors.toList());
        int n = list.size();
        float f3 = this.IllllllllllIlIIIlllIlllll() / 2.0f - (float)n * (f + f2) / 2.0f;
        float f4 = this.lllllIllIlIIlIIlIIIlllIlI() - f - 12.0f;
        for (UIComponent uIComponent2 : list) {
            uIComponent2.lIlIlIlIlIIlIIlIIllIIIIIl(f3, f4, f, f);
            f3 += f + f2;
        }
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
        ++llIlIIIllIIlIllIllIllllIl;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n, int n2, float f) {
        if (Ref.llIIIIIIIllIIllIlIllIIIIl() == null) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableAlpha();
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$renderSkybox(this.IlIlIlllllIlIIlIlIlllIlIl, this.llIIIIIIIllIIllIlIllIIIIl, llIlIIIllIIlIllIllIllllIl, f);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableAlpha();
        }
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n, n2, f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        this.llIIIIIIIllIIllIlIllIIIIl();
    }

    public void llIIIIIIIllIIllIlIllIIIIl() {
        FontRegistry.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl("Lunar Client " + Bridge.IlllIIIIIIlllIlIIlllIlIIl().IlIlIlllllIlIIlIlIlllIlIl() + " (" + LunarClient.IlIlllIlIlllIllIIIIIIlllI() + "/" + LunarClient.llIIIllllIIIllIIIIlIlIlll() + ")", 10.0f, this.lllllIllIlIIlIIlIIIlllIlI() - 16.0f, -1597125171);
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
