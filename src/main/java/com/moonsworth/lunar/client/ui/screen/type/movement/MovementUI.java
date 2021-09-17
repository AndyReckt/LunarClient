package com.moonsworth.lunar.client.ui.screen.type.movement;

import com.google.common.util.concurrent.AtomicDouble;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.UsedEnum;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.render.RenderScaledGameOverlayEvent;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.feature.hud.*;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.config.FeatureSettingsUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.FeatureContainerUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.IlllIIIIIIlllIlIIlllIlIIl;
import com.moonsworth.lunar.client.ui.component.type.setting.llIllIlIllIlllIllIIIIllII;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.ease.QuadraticEase;
import com.moonsworth.lunar.client.ui.ease.SinusoidalEase;
import com.moonsworth.lunar.client.ui.event.MouseEventCallback;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.AnimatedLunarLogoUIComponent;
import com.moonsworth.lunar.client.ui.screen.type.SettingsUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.bugreport.BugReportUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.emotes.EmotesUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.MainMenuUIWrapper;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

public class MovementUI extends AbstractUIScreen {
    public static final float lIlIlIlIlIIlIIlIIllIIIIIl = 2.0F;
    public com.moonsworth.lunar.client.ui.component.type.setting.llIllIlIllIlllIllIIIIllII IlllIIIIIIlllIlIIlllIlIIl = new llIllIlIllIlllIllIIIIllII(null, "reportABug", Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/eye-24.png"));
    public com.moonsworth.lunar.client.ui.component.type.setting.IlllIIIIIIlllIlIIlllIlIIl lIllIlIIIlIIIIIIIlllIlIll;
    public IlllIIIIIIlllIlIIlllIlIIl llIlllIIIllllIIlllIllIIIl;
    public IlllIIIIIIlllIlIIlllIlIIl llIIIlllIIlllIllllIlIllIl;
    public IlllIIIIIIlllIlIIlllIlIIl lllllIllIllIllllIlIllllII;
    public AnimatedLunarLogoUIComponent lllIIIIIlllIIlIllIIlIIIlI;
    public DraggableHudMod lIlIIIIIIlIIIllllIllIIlII;
    public DraggableHudMod llIlIIIllIIlIllIllIllllIl;
    public boolean IllIllIIIllIIIlIlIlIIIIll;
    public Map<DraggableHudMod, SelectedAbstractHudMod> IIlIllIlllllllIIlIIIllIIl;
    public List lIIlIlllIlIlIIIlllIIlIIII;
    public List llIllIlIllIlllIllIIIIllII;
    public List<HistoricalAbstractHudMod> IllllllllllIlIIIlllIlllll;
    public static final float lllllIllIlIIlIIlIIIlllIlI = 5.0F;
    public static final float IllIIIlllIIIlIlllIlIIlIII = 2.0F;
    public final Color IIlIllIlIIllIIlIlIllllllI;
    public static final SinusoidalEase lIIIlllIIIIllllIlIIIlIIll = new SinusoidalEase(1000L);
    public static final SinusoidalEase llIIIlIllIIIIlIIIlIlIllIl = new SinusoidalEase(1000L);
    public float llllIlIllllIlIlIIIllIlIlI;
    public float IlIllIIlIIlIIIllIllllIIll;
    public float lIllllIllIIlIIlIIIlIIIlII;
    public float lIlIlIIIIIIllIlIIIIllIIII;
    public long lIIlIIIIIIlIIlIIllIlIIlII;
    public List<DraggableHudMod> IlIIlIIlIIlIIllIIIllIIllI;
    public MovementUI.ScaleAbstractHudMod IIlIlIIIllIIllllIllllIlIl;
    public boolean lllllIIIIlIlllIllIIIlIIlI;
    public long IIlllIllIlIllIllIIllIlIIl;
    public List<ConfigurableFeature> lIlIIlIlllIIlIIIlIlIlIllI;
    public QuadraticEase lIIlllIIIIIlllIIIlIlIlllI;
    public final ResourceLocationBridge IIIlIIIIIIllIIIIllIIIIlII;
    public final ResourceLocationBridge IlIIIlIlIlIlIlIllIIllIIlI;
    public int IlIlIllIIllllIllllllIIlIl;
    public static final float lIIlIIlllIIIIlIlllIIIIlll = 20.0F;
    public float llIllIIIIlIIIIIIlllIllIlI;

    public MovementUI() {
        this.lIllIlIIIlIIIIIIIlllIlIll = new IlllIIIIIIlllIlIIlllIlIIl((UIComponent)null, "help", FontRegistry.llIIIlllIIlllIllllIlIllIl);
        this.llIlllIIIllllIIlllIllIIIl = new IlllIIIIIIlllIlIIlllIlIIl((UIComponent)null, "", FontRegistry.llIIIlllIIlllIllllIlIllIl);
        this.llIIIlllIIlllIllllIlIllIl = new IlllIIIIIIlllIlIIlllIlIIl((UIComponent)null, "", FontRegistry.llIIIlllIIlllIllllIlIllIl);
        this.lllllIllIllIllllIlIllllII = new IlllIIIIIIlllIlIIlllIlIIl((UIComponent)null, "", FontRegistry.llIIIlllIIlllIllllIlIllIl);
        this.lllIIIIIlllIIlIllIIlIIIlI = new AnimatedLunarLogoUIComponent((UIComponent)null, true, false);
        this.lIlIIIIIIlIIIllllIllIIlII = null;
        this.llIlIIIllIIlIllIllIllllIl = null;
        this.IllIllIIIllIIIlIlIlIIIIll = false;
        this.IIlIllIlllllllIIlIIIllIIl = new HashMap();
        this.lIIlIlllIlIlIIIlllIIlIIII = new ArrayList();
        this.llIllIlIllIlllIllIIIIllII = new ArrayList();
        this.IllllllllllIlIIIlllIlllll = new ArrayList();
        this.IIlIllIlIIllIIlIlIllllllI = new Color(-2540289, true);
        this.IlIIlIIlIIlIIllIIIllIIllI = new ArrayList();
        this.lIlIIlIlllIIlIIIlIlIlIllI = new ArrayList();
        this.lIIlllIIIIIlllIIIlIlIlllI = new QuadraticEase(500L);
        this.IIIlIIIIIIllIIIIllIIIIlII = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/exit-17x17-small.png");
        this.IlIIIlIlIlIlIlIllIIllIIlI = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/mainmenu/cog-20x20.png");
        this.llIllIIIIlIIIIIIlllIllIlI = 8.0F;
        this.llIIlIlIIIllIlIlIlIIlIIll.add(this.llIlllIIIllllIIlllIllIIIl);
        this.llIIlIlIIIllIlIlIlIIlIIll.add(this.llIIIlllIIlllIllllIlIllIl);
        this.llIIlIlIIIllIlIlIlIIlIIll.add(this.lllllIllIllIllllIlIllllII);
        this.llIIlIlIIIllIlIlIlIIlIIll.add(this.lIllIlIIIlIIIIIIIlllIlIll);
        this.llIIlIlIIIllIlIlIlIIlIIll.add(this.IlllIIIIIIlllIlIIlllIlIIl);
        this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl((MouseEventCallback)((var1, var2, var3) -> {
            if (this.lIlIIIIIIlIIIllllIllIIlII == null && var3 == 0) {
                this.lIllllIllIIlIIlIIIlIIIlII = 0.0F;
                this.lIlIlIIIIIIllIlIIIIllIIII = 0.0F;
                if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getWorld() == null) {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIWrapper(new SettingsUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen()))));
                } else {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new SettingsUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen())));
                }

                return true;
            } else {
                return false;
            }
        }));
        this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl((BooleanSupplier)(() -> {
            return !Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll();
        }));
        this.lllllIllIllIllllIlIllllII.lIlIlIlIlIIlIIlIIllIIIIIl((BooleanSupplier)(() -> {
            return !Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll();
        }));
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl((MouseEventCallback)((var1, var2, var3) -> {
            this.lIllllIllIIlIIlIIIlIIIlII = 0.0F;
            this.lIlIlIIIIIIllIlIIIIllIIII = 0.0F;
            if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getWorld() == null) {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIWrapper(new BugReportUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen()))));
            } else {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new BugReportUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen())));
            }

            return true;
        }));
        this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl((MouseEventCallback)((var1, var2, var3) -> {
            if (this.lIlIIIIIIlIIIllllIllIIlII == null && var3 == 0) {
                this.lIllllIllIIlIIlIIIlIIIlII = 0.0F;
                this.lIlIlIIIIIIllIlIIIIllIIII = 0.0F;
                if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getWorld() == null) {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIWrapper(new CosmeticsUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen()))));
                } else {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new CosmeticsUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen())));
                }

                return true;
            } else {
                return false;
            }
        }));
        this.lllllIllIllIllllIlIllllII.lIlIlIlIlIIlIIlIIllIIIIIl((MouseEventCallback)((var1, var2, var3) -> {
            if (this.lIlIIIIIIlIIIllllIllIIlII == null && var3 == 0) {
                if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getWorld() == null) {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIWrapper(new EmotesUIScreen())));
                } else {
                    Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new EmotesUIScreen()));
                }

                return true;
            } else {
                return false;
            }
        }));
        this.llIlllIIIllllIIlllIllIIIl.IlllIIIIIIlllIlIIlllIlIIl(-1);
        this.llIlllIIIllllIIlllIllIIIl.IlllIIIIIIlllIlIIlllIlIIl(new ColorEase(805306368, 1342177280));
        this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(new ColorEase(1076176165, -1711276033));
        this.llIlllIIIllllIIlllIllIIIl.IlIlIlllllIlIIlIlIlllIlIl(2.0F);
        this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl("settings", true);
        this.llIIIlllIIlllIllllIlIllIl.IlllIIIIIIlllIlIIlllIlIIl(-1);
        this.llIIIlllIIlllIllllIlIllIl.IlllIIIIIIlllIlIIlllIlIIl(new ColorEase(805306368, 1342177280));
        this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(new ColorEase(1076176165, -1711276033));
        this.llIIIlllIIlllIllllIlIllIl.IlIlIlllllIlIIlIlIlllIlIl(2.0F);
        this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/cosmetic-28x28.png"));
        this.lllllIllIllIllllIlIllllII.IlllIIIIIIlllIlIIlllIlIIl(-1);
        this.lllllIllIllIllllIlIllllII.IlllIIIIIIlllIlIIlllIlIIl(new ColorEase(805306368, 1342177280));
        this.lllllIllIllIllllIlIllllII.lIlIlIlIlIIlIIlIIllIIIIIl(new ColorEase(1076176165, -1711276033));
        this.lllllIllIllIllllIlIllllII.IlIlIlllllIlIIlIlIlllIlIl(2.0F);
        this.lllllIllIllIllllIlIllllII.lIlIlIlIlIIlIIlIIllIIIIIl(Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/emote-28x28.png"));
        this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(-1);
        this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(new ColorEase(805306368, 1342177280));
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(new ColorEase(1076176165, -1711276033));
        this.lIllIlIIIlIIIIIIIlllIlIll.IlIlIlllllIlIIlIlIlllIlIl(2.0F);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl("help", true);
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
        this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll(new ColorEase(805306368, 1342177280));
        this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(new ColorEase(1426128895, 1426128895));
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(1.5F);
    }

    public List llIIlIlIIIllIlIlIlIIlIIll() {
        return Collections.emptyList();
    }

    public void llIIIlllIIlllIllllIlIllIl() {
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(32.0F, this.lllllIllIlIIlIIlIIIlllIlI() - 28.0F, 24.0F, 24.0F);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(4.0F, this.lllllIllIlIIlIIlIIIlllIlI() - 28.0F, 24.0F, 24.0F);
        this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0F - 50.0F, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 19.0F, 100.0F, 28.0F);
        this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0F + 50.0F + 4.0F, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 19.0F, 28.0F, 28.0F);
        this.lllllIllIllIllllIlIllllII.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0F - 50.0F - 4.0F - 28.0F, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 19.0F, 28.0F, 28.0F);
        this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0F - 32.0F, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 85.0F, 64.0F, 58.5F);
        this.lIIlllIIIIIlllIIIlIlIlllI.lIllIlIIIlIIIIIIIlllIlIll();
        this.lIllllIllIIlIIlIIIlIIIlII = 0.0F;
        this.lIlIlIIIIIIllIlIIIIllIIII = 0.0F;
    }

    public void lllllIllIllIllllIlIllllII() {
        if (this.lIIlIlllIlIlIIIlllIIlIIII.size() > 50) {
            this.lIIlIlllIlIlIIIlllIIlIIII.remove(0);
        }

        if (!this.lIlIIlIlllIIlIIIlIlIlIllI.isEmpty()) {
            int var1 = 0;
            int var2 = 0;
            if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IIllllIIlllIlIIlIIlllIlII)) {
                --var1;
            }

            if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IllIlIIlllIIlIIllIIIIIIIl)) {
                ++var1;
            }

            if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlllIIIIIllIIllIllIIlll)) {
                --var2;
            }

            if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.lIlIIllIIIlIIIlIIIlIIlIll)) {
                ++var2;
            }

            if (var1 == 0 && var2 == 0) {
                this.IlIlIllIIllllIllllllIIlIl = 0;
            } else {
                ++this.IlIlIllIIllllIllllllIIlIl;
            }

            if (this.IlIlIllIIllllIllllllIIlIl > 10) {
                if (this.IlIlIllIIllllIllllllIIlIl > 20) {
                    var1 *= 2;
                    var2 *= 2;
                }

                Iterator var3 = this.lIlIIlIlllIIlIIIlIlIlIllI.iterator();

                while(var3.hasNext()) {
                    DraggableHudMod var4 = (DraggableHudMod)var3.next();
                    var4.lIlIlIlIlIIlIIlIIllIIIIIl(var4.IlIIIlIlIlIlIlIllIIllIIlI() + (float)var1, var4.IlIlIllIIllllIllllllIIlIl() + (float)var2);
                }
            }
        } else {
            this.IlIlIllIIllllIllllllIIlIl = 0;
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        this.IlllllIlIIIlIIlIIllIIlIll();
        Anchor var3 = lIlIlIlIlIIlIIlIIllIIIIIl((double)var1, (double)var2);
        if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl(UsedEnum.MOVEMENT_UI)) {
            Ref.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(var3.name(), (float)((int)var1), (float)((int)var2), -1);
        }

        if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getWorld() == null) {
            EventBus.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl((new RenderScaledGameOverlayEvent(this.IllllllllllIlIIIlllIlllll(), this.lllllIllIlIIlIIlIIIlllIlI())));
        }

        if (lIIIlllIIIIllllIlIIIlIIll.lIIIllIllIIllIlllIlIIlllI()) {
            AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(0.0F, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 0.25F, this.IllllllllllIlIIIlllIlllll(), this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F + 0.25F, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl((float)this.IIlIllIlIIllIIlIlIllllllI.getRed() / 255.0F, (float)this.IIlIllIlIIllIIlIlIllllllI.getGreen() / 255.0F, (float)this.IIlIllIlIIllIIlIlIllllllI.getBlue() / 255.0F, lIIIlllIIIIllllIlIIIlIIll.IlllllIlIIIlIIlIIllIIlIll()));
        }

        if (llIIIlIllIIIIlIIIlIlIllIl.lIIIllIllIIllIlllIlIIlllI()) {
            AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.IllllllllllIlIIIlllIlllll() / 2.0F - 0.25F, 0.0F, this.IllllllllllIlIIIlllIlllll() / 2.0F + 0.25F, this.lllllIllIlIIlIIlIIIlllIlI(), ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl((float)this.IIlIllIlIIllIIlIlIllllllI.getRed() / 255.0F, (float)this.IIlIllIlIIllIIlIlIllllllI.getGreen() / 255.0F, (float)this.IIlIllIlIIllIIlIlIllllllI.getBlue() / 255.0F, llIIIlIllIIIIlIIIlIlIllIl.IlllllIlIIIlIIlIIllIIlIll()));
        }

        if ((this.lIlIlIIIIIIllIlIIIIllIIII != 0.0F || this.lIllllIllIIlIIlIIIlIIIlII != 0.0F) && System.currentTimeMillis() - this.lIIlIIIIIIlIIlIIllIlIIlII >= 100L) {
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(Math.min(var1, this.lIllllIllIIlIIlIIIlIIIlII), Math.min(var2, this.lIlIlIIIIIIllIlIIIIllIIII), var1 > this.lIllllIllIIlIIlIIIlIIIlII ? var1 - this.lIllllIllIIlIIlIIIlIIIlII : this.lIllllIllIIlIIlIIIlIIIlII - var1, var2 > this.lIlIlIIIIIIllIlIIIIllIIII ? var2 - this.lIlIlIIIIIIllIlIIIIllIIII : this.lIlIlIIIIIIllIlIIIIllIIII - var2, 1350565844);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(Math.min(var1, this.lIllllIllIIlIIlIIIlIIIlII), Math.min(var2, this.lIlIlIIIIIIllIlIIIIllIIII), var1 > this.lIllllIllIIlIIlIIIlIIIlII ? var1 - this.lIllllIllIIlIIlIIIlIIIlII : this.lIllllIllIIlIIlIIIlIIIlII - var1, var2 > this.lIlIlIIIIIIllIlIIIIllIIII ? var2 - this.lIlIlIIIIIIllIlIIIIllIIII : this.lIlIlIIIIIIllIlIIIIllIIII - var2, 0.5F, -8388652, 0);
        }

        this.IlIIlIIlIIlIIllIIIllIIllI = new ArrayList();
        AtomicBoolean var4 = new AtomicBoolean(false);
        boolean var5 = false;
        Iterator<ConfigurableFeature> var6 = this.llIIIIIIIllIIllIlIllIIIIl().iterator();

        while(var6.hasNext()) {
            ConfigurableFeature var7 = (ConfigurableFeature)var6.next();
            if (var7 instanceof DraggableHudMod && var7.IlllIIIIIIlllIlIIlllIlIIl()) {
                if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getGameSettings().bridge$showDebugInfo() && !(Boolean)LunarClient.IIllIlIllIlIllIllIllIllII().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lIlIIIIIIlIIIllllIllIIlII().llIlllIIIllllIIlllIllIIIl() || Ref.llIIIlllIIlllIllllIlIllIl() == FriendsUIScreen.class && !(Boolean)Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llIlIIIllIIlIllIllIllllIl().llIlllIIIllllIIlllIllIIIl()) {
                    break;
                }

                DraggableHudMod var8 = (DraggableHudMod)var7;
                if (!var8.IlIlllIlIlllIllIIIIIIlllI()) {
                    double var9 = var8.lIlIlIlIlIIlIIlIIllIIIIIl((double)this.IllllllllllIlIIIlllIlllll()) * (double)var8.lIIlIIIIIIlIIlIIllIlIIlII();
                    double var11 = var8.IlllIIIIIIlllIlIIlllIlIIl((double)this.lllllIllIlIIlIIlIIIlllIlI()) * (double)var8.lIIlIIIIIIlIIlIIllIlIIlII();
                    boolean var13 = (this.lIlIIIIIIlIIIllllIllIIlII == null || this.lIlIIIIIIlIIIllllIllIIlII == var8) && (double)var1 >= var9 && (double)var1 <= var9 + (double)var8.IlIIlIIlIIlIIllIIIllIIllI() && (double)var2 >= var11 && (double)var2 <= var11 + (double)var8.IIlIlIIIllIIllllIllllIlIl();
                    float var14 = Math.min(this.lIllllIllIIlIIlIIIlIIIlII, var1);
                    float var15 = Math.min(this.lIlIlIIIIIIllIlIIIIllIIII, var2);
                    float var16 = Math.max(this.lIllllIllIIlIIlIIIlIIIlII, var1);
                    float var17 = Math.max(this.lIlIlIIIIIIllIlIIIIllIIII, var2);
                    boolean var18 = false;
                    if (System.currentTimeMillis() - this.lIIlIIIIIIlIIlIIllIlIIlII >= 100L && (this.lIlIlIIIIIIllIlIIIIllIIII != 0.0F || this.lIllllIllIIlIIlIIIlIIIlII != 0.0F) && (this.lIlIlIlIlIIlIIlIIllIIIIIl(var14, var16, var15, var17, (float)var8.IIlllIllIlIllIllIIllIlIIl(), (float)(var8.lIlIIlIlllIIlIIIlIlIlIllI() + (double)var8.IIlIlIIIllIIllllIllllIlIl())) || this.lIlIlIlIlIIlIIlIIllIIIIIl(var14, var16, var15, var17, (float)var8.IIlllIllIlIllIllIIllIlIIl() + var8.IlIIlIIlIIlIIllIIIllIIllI(), (float)var8.lIlIIlIlllIIlIIIlIlIlIllI()) || this.lIlIlIlIlIIlIIlIIllIIIIIl(var14, var16, var15, var17, (float)var8.IIlllIllIlIllIllIIllIlIIl(), (float)var8.lIlIIlIlllIIlIIIlIlIlIllI()) || this.lIlIlIlIlIIlIIlIIllIIIIIl(var14, var16, var15, var17, (float)var8.IIlllIllIlIllIllIIllIlIIl() + var8.IlIIlIIlIIlIIllIIIllIIllI(), (float)var8.lIlIIlIlllIIlIIIlIlIlIllI() + var8.IIlIlIIIllIIllllIllllIlIl()))) {
                        this.IlIIlIIlIIlIIllIIIllIIllI.add(var8);
                        var18 = true;
                    }

                    AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll((float)var9, (float)var11, var8.IlIIlIIlIIlIIllIIIllIIllI(), var8.IIlIlIIIllIIllllIllllIlIl(), !this.lIlIIlIlllIIlIIIlIlIlIllI.contains(var8) && !var18 ? (var13 ? -2130706433 : 553648127) : 1350565844);
                    AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((float)var9, (float)var11, var8.IlIIlIIlIIlIIllIIIllIIllI(), var8.IIlIlIIIllIIllllIllllIlIl(), 0.5F, Integer.MIN_VALUE, 0);
                    int var19 = var8.lIlIIIIIllIIlIIlIIlIlIIlI().IlllIIIIIIlllIlIIlllIlIIl() == Position.LEFT ? (var8.lIlIIIIIllIIlIIlIIlIlIIlI().lIllIlIIIlIIIIIIIlllIlIll() == Position.BOTTOM ? 1 : 3) : (var8.lIlIIIIIllIIlIIlIIlIlIIlI().lIllIlIIIlIIIIIIIlllIlIll() == Position.TOP ? 2 : 0);
                    float var20;
                    float var21;
                    if (this.lllllIIIIlIlllIllIIIlIIlI && this.IIlIlIIIllIIllllIllllIlIl != null) {
                        var20 = (float)(((float)this.IIlIlIIIllIIllllIllllIlIl.llllIIlIIlIIlIIllIIlIIllI() != 0.0F && this.IIlIlIIIllIIllllIllllIlIl.llllIIlIIlIIlIIllIIlIIllI() != 2 ? var9 + (double)var8.IlIIlIIlIIlIIllIIIllIIllI() : var9) - 2.5D);
                        var21 = (float)(((float)this.IIlIlIIIllIIllllIllllIlIl.llllIIlIIlIIlIIllIIlIIllI() != 0.0F && this.IIlIlIIIllIIllllIllllIlIl.llllIIlIIlIIlIIllIIlIIllI() != 1 ? var11 + (double)var8.IIlIlIIIllIIllllIllllIlIl() : var11) - 2.5D);
                    } else {
                        var20 = (float)(var19 != 0 && var19 != 2 ? var9 + (double)var8.IlIIlIIlIIlIIllIIIllIIllI() : var9) - 2.5F;
                        var21 = (float)(var19 != 0 && var19 != 1 ? var11 + (double)var8.IIlIlIIIllIIllllIllllIlIl() : var11) - 2.5F;
                    }

                    boolean var22 = (this.lIlIIIIIIlIIIllllIllIIlII == null || this.lIlIIIIIIlIIIllllIllIIlII == var8) && var1 >= var20 - 2.0F && var1 <= var20 + 7.0F && var2 >= var21 - 2.0F && var2 <= var21 + 7.0F;
                    if (var8.IIIlIIIIIIllIIIIllIIIIlII() && this.lllllIIIIlIlllIllIIIlIIlI && this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().equals(var8) || !var5 && var22 || var13) {
                        if (!this.lllllIIIIlIlllIllIIIlIIlI || this.IIlIlIIIllIIllllIllllIlIl == null) {
                            this.IIlIlIIIllIIllllIllllIlIl = new MovementUI.ScaleAbstractHudMod(var8, var8.lIlIIIIIllIIlIIlIIlIlIIlI(), var1, var2, var19, var8.lIIlIIIIIIlIIlIIllIlIIlII(), new float[]{var20, var21});
                        }

                        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(var20, var21, 5.0F, 5.0F, -8388652);
                        var5 = true;
                    }

                    boolean var23 = this.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2, this.lIlIlIlIlIIlIIlIIllIIIIIl(var8));
                    boolean var24 = this.IlllIIIIIIlllIlIIlllIlIIl(var1, var2, this.IlllIIIIIIlllIlIIlllIlIIl(var8));
                    if (var13 || var23 || var24 || var22) {
                        this.lIlIIIIIIlIIIllllIllIIlII = var8;
                        var4.set(true);
                    }

                    if (this.llIlIIIllIIlIllIllIllllIl != null && this.llIlIIIllIIlIllIllIllllIl == var8 && this.lIlIIlIlllIIlIIIlIlIlIllI.contains(var8)) {
                        MovementUI.SelectedAbstractHudMod var25 = (MovementUI.SelectedAbstractHudMod)this.IIlIllIlllllllIIlIIIllIIl.get(var8);
                        float var26 = var1 - var25.IlllIIIIIIlllIlIIlllIlIIl();
                        float var27 = var2 - var25.lIllIlIIIlIIIIIIIlllIlIll();
                        if (!this.IllIllIIIllIIIlIlIlIIIIll) {
                            if (var26 == var8.IlIIIlIlIlIlIlIllIIllIIlI() && var27 == var8.IlIlIllIIllllIllllllIIlIl()) {
                                continue;
                            }

                            this.IllIllIIIllIIIlIlIlIIIIll = true;
                        }

                        float var28 = (float)((double)(var26 - var8.IlIIIlIlIlIlIlIllIIllIIlI()) + var8.IIlllIllIlIllIllIIllIlIIl());
                        float var29 = (float)((double)(var27 - var8.IlIlIllIIllllIllllllIIlIl()) + var8.lIlIIlIlllIIlIIIlIlIlIllI());
                        if (!Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(1)) {
                            if (var28 < 2.0F || var28 + var8.IlIIlIIlIIlIIllIIIllIIllI() > this.IllllllllllIlIIIlllIlllll()) {
                                var26 = var8.IlIIIlIlIlIlIlIllIIllIIlI();
                            }

                            if (var29 < 2.0F || var29 + var8.IIlIlIIIllIIllllIllllIlIl() > this.lllllIllIlIIlIIlIIIlllIlI()) {
                                var27 = var8.IlIlIllIIllllIllllllIIlIl();
                            }
                        }

                        AtomicDouble var30 = new AtomicDouble((double)var26);
                        AtomicDouble var31 = new AtomicDouble((double)var27);
                        var8.lIlIlIlIlIIlIIlIIllIIIIIl(var26, var27);
                        boolean var32 = this.lIlIIlIlllIIlIIIlIlIlIllI.size() == 1 && Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(0) && this.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2, var8, var3, var30, var31);
                        var26 = (float)var30.get();
                        var27 = (float)var31.get();
                        if (!var32) {
                            this.IlIllIIlIIlIIIllIllllIIll = 0.0F;
                            this.llllIlIllllIlIlIIIllIlIlI = 0.0F;
                        } else {
                            var8.lIlIlIlIlIIlIIlIIllIIIIIl(var26, var27);
                        }
                    }
                }
            }
        }

        if (this.llIlIIIllIIlIllIllIllllIl != null) {
            var6 = this.lIlIIlIlllIIlIIIlIlIlIllI.iterator();

            label243:
            while(true) {
                DraggableHudMod var35;
                do {
                    do {
                        do {
                            if (!var6.hasNext()) {
                                break label243;
                            }

                            var35 = (DraggableHudMod)var6.next();
                        } while(var35 == null);
                    } while(this.llIlIIIllIIlIllIllIllllIl == var35);
                } while(!this.IllIllIIIllIIIlIlIlIIIIll);

                MovementUI.SelectedAbstractHudMod var38 = (MovementUI.SelectedAbstractHudMod)this.IIlIllIlllllllIIlIIIllIIl.get(var35);
                float var40 = var1 - var38.IlllIIIIIIlllIlIIlllIlIIl();
                float var10 = var2 - var38.lIllIlIIIlIIIIIIIlllIlIll();
                float var42 = (float)((double)(var40 - var35.IlIIIlIlIlIlIlIllIIllIIlI()) + var35.IIlllIllIlIllIllIIllIlIIl());
                float var12 = (float)((double)(var10 - var35.IlIlIllIIllllIllllllIIlIl()) + var35.lIlIIlIlllIIlIIIlIlIlIllI());
                if (!Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(1)) {
                    if (var42 < 2.0F || var42 + var35.IlIIlIIlIIlIIllIIIllIIllI() > this.IllllllllllIlIIIlllIlllll()) {
                        var40 = var35.IlIIIlIlIlIlIlIllIIllIIlI();
                    }

                    if (var12 < 2.0F || var12 + var35.IIlIlIIIllIIllllIllllIlIl() > this.lllllIllIlIIlIIlIIIlllIlI()) {
                        var10 = var35.IlIlIllIIllllIllllllIIlIl();
                    }
                }

                var35.lIlIlIlIlIIlIIlIIllIIIIIl(var40, var10);
            }
        }

        if (var4.get()) {
            float[] var33 = this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII);
            boolean var36 = this.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2, var33);
            float[] var39 = this.IlllIIIIIIlllIlIIlllIlIIl(this.lIlIIIIIIlIIIllllIllIIlII);
            boolean var41 = this.IlllIIIIIIlllIlIIlllIlIIl(var1, var2, var39);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(0.0F, 0.0F, 0.0F, !var36 ? 0.7F : 1.0F);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlIIIlIlIlIlIlIllIIllIIlI, var33[0] + 1.0F, var33[1] + 1.0F, this.llIllIIIIlIIIIIIlllIllIlI, this.llIllIIIIlIIIIIIlllIllIlI);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(0.0F, 0.0F, 0.0F, !var41 ? 0.7F : 1.0F);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIIlIIIIIIllIIIIllIIIIlII, var39[0] + 1.0F, var39[1] + 1.0F, this.llIllIIIIlIIIIIIlllIllIlI, this.llIllIIIIlIIIIIIlllIllIlI);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, !var36 ? 0.5F : 1.0F);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlIIIlIlIlIlIlIllIIllIIlI, var33[0], var33[1], this.llIllIIIIlIIIIIIlllIllIlI, this.llIllIIIIlIIIIIIlllIllIlI);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 0.2F, 0.2F, !var41 ? 0.5F : 1.0F);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIIlIIIIIIllIIIIllIIIIlII, var39[0], var39[1], this.llIllIIIIlIIIIIIlllIllIlI, this.llIllIIIIlIIIIIIlllIllIlI);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        } else {
            this.lIlIIIIIIlIIIllllIllIIlII = null;
        }

        if (this.lllllIIIIlIlllIllIIIlIIlI && this.IIlIlIIIllIIllllIllllIlIl != null) {
            float var37 = 1.0F;
            float var34;
            switch(this.IIlIlIIIllIIllllIllllIlIl.llllIIlIIlIIlIIllIIlIIllI()) {
            case 0:
                var34 = var2 - this.IIlIlIIIllIIllllIllllIlIl.llIlllIIIllllIIlllIllIIIl + (var1 - this.IIlIlIIIllIIllllIllllIlIl.lIllIlIIIlIIIIIIIlllIlIll);
                var37 = this.IIlIlIIIllIIllllIllllIlIl.IlIlIlllllIlIIlIlIlllIlIl() - var34 / 115.0F;
                break;
            case 1:
                var34 = var1 - this.IIlIlIIIllIIllllIllllIlIl.lIllIlIIIlIIIIIIIlllIlIll - (var2 - this.IIlIlIIIllIIllllIllllIlIl.llIlllIIIllllIIlllIllIIIl);
                var37 = this.IIlIlIIIllIIllllIllllIlIl.IlIlIlllllIlIIlIlIlllIlIl() + var34 / 115.0F;
                break;
            case 2:
                var34 = var1 - this.IIlIlIIIllIIllllIllllIlIl.lIllIlIIIlIIIIIIIlllIlIll - (var2 - this.IIlIlIIIllIIllllIllllIlIl.llIlllIIIllllIIlllIllIIIl);
                var37 = this.IIlIlIIIllIIllllIllllIlIl.IlIlIlllllIlIIlIlIlllIlIl() - var34 / 115.0F;
                break;
            case 3:
                var34 = var2 - this.IIlIlIIIllIIllllIllllIlIl.llIlllIIIllllIIlllIllIIIl + (var1 - this.IIlIlIIIllIIllllIllllIlIl.lIllIlIIIlIIIIIIIlllIlIll);
                var37 = this.IIlIlIIIllIIllllIllllIlIl.IlIlIlllllIlIIlIlIlllIlIl() + var34 / 115.0F;
            }

            if (var37 >= 0.5F && var37 <= 1.5F) {
                this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().lIllIlIIIlIIIIIIIlllIlIll((float)((double)Math.round((double)var37 * 100.0D) / 100.0D));
            }
        }

        this.save();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        if (this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(var1, var2)) {
            this.lllIIIIIlllIIlIllIIlIIIlI();
        }

    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6) {
        return var5 > var1 && var5 < var2 && var6 > var3 && var6 < var4;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1) {
        if (this.lIlIIlIlllIIlIIIlIlIlIllI.size() == 1) {
            DraggableHudMod var2 = this.llIlIIIllIIlIllIllIllllIl;
            var2.lIlIlIlIlIIlIIlIIllIIIIIl(var2.IlIIIlIlIlIlIlIllIIllIIlI() + var1, var2.IlIlIllIIllllIllllllIIlIl());
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float var1) {
        if (this.lIlIIlIlllIIlIIIlIlIlIllI.size() == 1) {
            DraggableHudMod var2 = this.llIlIIIllIIlIllIllIllllIl;
            var2.lIlIlIlIlIIlIIlIIllIIIIIl(var2.IlIIIlIlIlIlIlIllIIllIIlI(), var2.IlIlIllIIllllIllllllIIlIl() + var1);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, int var2) {
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(0.0F, var1 - 0.25F, this.IllllllllllIlIIIlllIlllll(), var1 + 0.25F, var2);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float var1, int var2) {
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(var1 - 0.25F, 0.0F, var1 + 0.25F, this.lllllIllIlIIlIIlIIIlllIlI(), var2);
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, DraggableHudMod var3, Anchor var4, AtomicDouble var5, AtomicDouble var6) {
        boolean var7 = false;
        if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl(UsedEnum.MOVEMENT_UI)) {
            Ref.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(var3.IIlllIllIlIllIllIIllIlIIl() + " " + var3.lIlIIlIlllIIlIIIlIlIlIllI(), (float)((int)var3.IIlllIllIlIllIllIIllIlIIl()), (float)((int)var3.lIlIIlIlllIIlIIIlIlIlIllI()), -1);
        }

        if (var4 != Anchor.BOTTOM_CENTER_L && var4 != Anchor.BOTTOM_CENTER_R) {
            float var8 = (float)(var3.lIlIIlIlllIIlIIIlIlIlIllI() + (double)(var3.IIlIlIIIllIIllllIllllIlIl() / 2.0F));
            float var9 = (float)(var3.IIlllIllIlIllIllIIllIlIIl() + (double)(var3.IlIIlIIlIIlIIllIIIllIIllI() / 2.0F));
            if (var4.lIllIlIIIlIIIIIIIlllIlIll() == Position.MIDDLE && var8 > this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 5.0F && var8 < this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F + 5.0F) {
                if (this.llllIlIllllIlIlIIIllIlIlI == 0.0F) {
                    this.llllIlIllllIlIlIIIllIlIlI = var2;
                }

                var7 = true;
                if (Math.abs(this.llllIlIllllIlIlIIIllIlIlI - var2) < 10.0F) {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F, this.IIlIllIlIIllIIlIlIllllllI.getRGB());
                }
            }

            if (var4.IlllIIIIIIlllIlIIlllIlIIl() == Position.MIDDLE && var9 > this.IllllllllllIlIIIlllIlllll() / 2.0F - 5.0F && var9 < this.IllllllllllIlIIIlllIlllll() / 2.0F + 5.0F) {
                if (this.IlIllIIlIIlIIIllIllllIIll == 0.0F) {
                    this.IlIllIIlIIlIIIllIllllIIll = var1;
                }

                var7 = true;
                if (Math.abs(this.IlIllIIlIIlIIIllIllllIIll - var1) < 10.0F) {
                    this.IlllIIIIIIlllIlIIlllIlIIl(this.IllllllllllIlIIIlllIlllll() / 2.0F, this.IIlIllIlIIllIIlIlIllllllI.getRGB());
                }
            }
        }

        LinkedList var28 = new LinkedList(this.llIIIIIIIllIIllIlIllIIIIl());
        var28 = (LinkedList)var28.stream().sorted((var2x, var3x) -> {
            if (var2x != var3 && var3x != var3 && var2x instanceof DraggableHudMod && var3x instanceof DraggableHudMod) {
                float[] floats1 = ((DraggableHudMod)var2x).lllllIIIIlIlllIllIIIlIIlI();
                float[] floats2 = ((DraggableHudMod)var2x).lllllIIIIlIlllIllIIIlIIlI();
                float[] floats3 = var3.lllllIIIIlIlllIllIIIlIIlI();
                Rectangle randomRect = new Rectangle((int)floats1[0], (int)floats1[1], (int)((DraggableHudMod)var2x).IlIIlIIlIIlIIllIIIllIIllI(), (int)((DraggableHudMod)var2x).IIlIlIIIllIIllllIllllIlIl());
                Rectangle var8 = new Rectangle((int)floats2[0], (int)floats2[1], (int)((DraggableHudMod)var3x).IlIIlIIlIIlIIllIIIllIIllI(), (int)((DraggableHudMod)var3x).IIlIlIIIllIIllllIllllIlIl());
                Rectangle var9 = new Rectangle((int)floats3[0], (int)floats3[1], (int)var3.IlIIlIIlIIlIIllIIIllIIllI(), (int)var3.IIlIlIIIllIIllllIllllIlIl());

                try {
                    return this.lIlIlIlIlIIlIIlIIllIIIIIl(randomRect, var9) > this.lIlIlIlIlIIlIIlIIllIIIIIl(var8, var9) ? -1 : 1;
                } catch (Exception var11) {
                    return 0;
                }
            } else {
                return 0;
            }
        }).collect(Collectors.toCollection(LinkedList::new));
        Iterator var29 = var28.iterator();

        while(var29.hasNext()) {
            ConfigurableFeature var10 = (ConfigurableFeature)var29.next();
            if (var10 != var3 && var10 instanceof DraggableHudMod && var10.IlllIIIIIIlllIlIIlllIlIIl()) {
                DraggableHudMod var11 = (DraggableHudMod)var10;
                boolean var12 = true;
                boolean var13 = true;
                float[] var14 = var11.lllllIIIIlIlllIllIIIlIIlI();
                float var15 = var14[0] * var11.lIIlIIIIIIlIIlIIllIlIIlII();
                float var16 = var14[1] * var11.lIIlIIIIIIlIIlIIllIlIIlII();
                float[] var17 = var3.lllllIIIIlIlllIllIIIlIIlI();
                float var18 = var17[0] * var3.lIIlIIIIIIlIIlIIllIlIIlII();
                float var19 = var17[1] * var3.lIIlIIIIIIlIIlIIllIlIIlII();
                float var20 = var15 - var18;
                float var21 = var15 + var11.IlIIlIIlIIlIIllIIIllIIllI() - (var18 + var3.IlIIlIIlIIlIIllIIIllIIllI());
                float var22 = var15 + var11.IlIIlIIlIIlIIllIIIllIIllI() - var18;
                float var23 = var15 - (var18 + var3.IlIIlIIlIIlIIllIIIllIIllI());
                float var24 = var16 - var19;
                float var25 = var16 + var11.IIlIlIIIllIIllllIllllIlIl() - (var19 + var3.IIlIlIIIllIIllllIllllIlIl());
                float var26 = var16 + var11.IIlIlIIIllIIllllIllllIlIl() - var19;
                float var27 = var16 - (var19 + var3.IIlIlIIIllIIllllIllllIlIl());
                if (var20 >= -2.0F && var20 <= 2.0F) {
                    var12 = false;
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(var20);
                    this.IlllIIIIIIlllIlIIlllIlIIl((float)var11.IIlllIllIlIllIllIIllIlIIl(), this.IIlIllIlIIllIIlIlIllllllI.getRGB());
                }

                if (var21 >= -2.0F && var21 <= 2.0F && var12) {
                    var12 = false;
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(var21);
                    this.IlllIIIIIIlllIlIIlllIlIIl((float)var11.IIlllIllIlIllIllIIllIlIIl() + var11.IlIIlIIlIIlIIllIIIllIIllI(), this.IIlIllIlIIllIIlIlIllllllI.getRGB());
                }

                if (var23 >= -2.0F && var23 <= 2.0F && var12) {
                    var12 = false;
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(var23);
                    this.IlllIIIIIIlllIlIIlllIlIIl((float)var11.IIlllIllIlIllIllIIllIlIIl(), this.IIlIllIlIIllIIlIlIllllllI.getRGB());
                }

                if (var22 >= -2.0F && var22 <= 2.0F && var12) {
                    this.lIlIlIlIlIIlIIlIIllIIIIIl(var22);
                    this.IlllIIIIIIlllIlIIlllIlIIl((float)var11.IIlllIllIlIllIllIIllIlIIl() + var11.IlIIlIIlIIlIIllIIIllIIllI(), this.IIlIllIlIIllIIlIlIllllllI.getRGB());
                }

                if (var24 >= -2.0F && var24 <= 2.0F) {
                    var13 = false;
                    this.IlllIIIIIIlllIlIIlllIlIIl(var24);
                    this.lIlIlIlIlIIlIIlIIllIIIIIl((float)var11.lIlIIlIlllIIlIIIlIlIlIllI(), this.IIlIllIlIIllIIlIlIllllllI.getRGB());
                }

                if (var25 >= -2.0F && var25 <= 2.0F && var13) {
                    var13 = false;
                    this.IlllIIIIIIlllIlIIlllIlIIl(var25);
                    this.lIlIlIlIlIIlIIlIIllIIIIIl((float)var11.lIlIIlIlllIIlIIIlIlIlIllI() + var11.IIlIlIIIllIIllllIllllIlIl(), this.IIlIllIlIIllIIlIlIllllllI.getRGB());
                }

                if (var27 >= -2.0F && var27 <= 2.0F && var13) {
                    var13 = false;
                    this.IlllIIIIIIlllIlIIlllIlIIl(var27);
                    this.lIlIlIlIlIIlIIlIIllIIIIIl((float)var11.lIlIIlIlllIIlIIIlIlIlIllI(), this.IIlIllIlIIllIIlIlIllllllI.getRGB());
                }

                if (var26 >= -2.0F && var26 <= 2.0F && var13) {
                    this.IlllIIIIIIlllIlIIlllIlIIl(var26);
                    this.lIlIlIlIlIIlIIlIIllIIIIIl((float)var11.lIlIIlIlllIIlIIIlIlIlIllI() + var11.IIlIlIIIllIIllllIllllIlIl(), this.IIlIllIlIIllIIlIlIllllllI.getRGB());
                }
            }
        }

        return var7;
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(Rectangle var1, Rectangle var2) {
        float var3 = (float)Math.max(Math.abs(var1.x - var2.x) - var2.width / 2, 0);
        float var4 = (float)Math.max(Math.abs(var1.y - var2.y) - var2.height / 2, 0);
        return var3 * var3 + var4 * var4;
    }

    public void save() {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().IlllIIIIIIlllIlIIlllIlIIl(0.0F), Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().lIllIlIIIlIIIIIIIlllIlIll(0.0F), Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().llIlllIIIllllIIlllIllIIIl(0.0F), this.lIIlllIIIIIlllIIIlIlIlllI.IlllllIlIIIlIIlIIllIIlIll());
        if (this.lIIlllIIIIIlllIIIlIlIlllI.IlllllIlIIIlIIlIIllIIlIll() > 0.2F) {
            Color var1 = new Color(Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().IlllIIIIIIlllIlIIlllIlIIl(0.0F), Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().lIllIlIIIlIIIIIIIlllIlIll(0.0F), Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().llIlllIIIllllIIlllIllIIIl(0.0F), this.lIIlllIIIIIlllIIIlIlIlllI.IlllllIlIIIlIIlIIllIIlIll());
            String var2 = "LUNAR";
            int var3 = FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.IlllIIIIIIlllIlIIlllIlIIl(var2);
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(var2, this.IllllllllllIlIIIlllIlllll() / 2.0F - (float)var3 - 2.0F + 1.0F, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 40.0F + 1.0F, (new Color(0.0F, 0.0F, 0.0F, 0.4F * this.lIIlllIIIIIlllIIIlIlIlllI.IlllllIlIIIlIIlIIllIIlIll())).getRGB());
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(var2, this.IllllllllllIlIIIlllIlllll() / 2.0F - (float)var3 - 2.0F, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 40.0F, var1.getRGB());
            FontRegistry.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl("CLIENT", this.IllllllllllIlIIIlllIlllll() / 2.0F + 2.0F + 1.0F, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 40.0F + 1.0F, (new Color(0.0F, 0.0F, 0.0F, 0.4F * this.lIIlllIIIIIlllIIIlIlIlllI.IlllllIlIIIlIIlIIllIIlIll())).getRGB());
            FontRegistry.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl("CLIENT", this.IllllllllllIlIIIlllIlllll() / 2.0F + 2.0F, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 40.0F, var1.getRGB());
        }

        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0F, -20.0F * this.lIIlllIIIIIlllIIIlIlIlllI.IlllllIlIIIlIIlIIllIIlIll(), 0.0F);
        this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F, 0.0F, true);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
    }

    public void IlllllIlIIIlIIlIIllIIlIll() {
        float var1 = 0.5F;
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(2.0F - var1, 2.0F - var1, this.IllllllllllIlIIIlllIlllll() - 2.0F - var1 * 2.0F, this.lllllIllIlIIlIIlIIIlllIlI() - 2.0F - var1 * 2.0F, var1, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F, 1.0F, 1.0F, 0.8F * this.lIIlllIIIIIlllIIIlIlIlllI.IlllllIlIIIlIIlIIllIIlIll()), 0);
    }

    public static Anchor lIlIlIlIlIIlIIlIIllIIIIIl(double var0, double var2) {
        double var4 = (double)((int)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().lIllIlIIIlIIIIIIIlllIlIll());
        double var6 = (double)((int)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llIlllIIIllllIIlllIllIIIl());
        if (var0 < var4 / 3.0D && var2 < var6 / 3.0D) {
            return Anchor.TOP_LEFT;
        } else if (var0 > var4 / 3.0D * 2.0D && var2 < var6 / 3.0D) {
            return Anchor.TOP_RIGHT;
        } else if (var2 < var6 / 3.0D) {
            return Anchor.TOP_CENTER;
        } else if (var0 < var4 / 3.0D && var2 < var6 / 3.0D * 2.0D) {
            return Anchor.MIDDLE_LEFT;
        } else if (var0 > var4 / 3.0D * 2.0D && var2 < var6 / 3.0D * 2.0D) {
            return Anchor.MIDDLE_RIGHT;
        } else if (var2 < var6 / 3.0D * 2.0D) {
            return Anchor.MIDDLE_CENTER;
        } else if (var0 < var4 / 3.0D) {
            return Anchor.BOTTOM_LEFT;
        } else if (var0 < var4 / 3.0D * 2.0D) {
            return var0 > var4 / 3.0D + var4 / 6.0D ? Anchor.BOTTOM_CENTER_R : Anchor.BOTTOM_CENTER_L;
        } else {
            return Anchor.BOTTOM_RIGHT;
        }
    }

    public float[] lIlIlIlIlIIlIIlIIllIIIIIl(DraggableHudMod var1) {
        float var2;
        float var3;
        if (var1.lIIlIIlllIIIIlIlllIIIIlll() > 16.0F && var1.llIllIIIIlIIIIIIlllIllIlI() > 10.0F) {
            var2 = (float)var1.IIlllIllIlIllIllIIllIlIIl() + 1.0F;
            var3 = (float)var1.lIlIIlIlllIIlIIIlIlIlIllI() + var1.IIlIlIIIllIIllllIllllIlIl() - this.llIllIIIIlIIIIIIlllIllIlI - 2.0F;
        } else {
            var2 = (float)var1.IIlllIllIlIllIllIIllIlIIl() + var1.lIIlIIlllIIIIlIlllIIIIlll() * (Float)var1.llIIlIlIIIllIlIlIlIIlIIll.llIlllIIIllllIIlllIllIIIl() / 2.0F - this.llIllIIIIlIIIIIIlllIllIlI - 2.0F;
            if (var1.lIlIIIIIllIIlIIlIIlIlIIlI().lIllIlIIIlIIIIIIIlllIlIll().equals(Position.TOP)) {
                var3 = (float)(var1.lIlIIlIlllIIlIIIlIlIlIllI() + (double)(var1.llIllIIIIlIIIIIIlllIllIlI() * (Float)var1.llIIlIlIIIllIlIlIlIIlIIll.llIlllIIIllllIIlllIllIIIl() * 2.0F)) - this.llIllIIIIlIIIIIIlllIllIlI - 2.0F;
            } else {
                var3 = (float)var1.lIlIIlIlllIIlIIIlIlIlIllI() - this.llIllIIIIlIIIIIIlllIllIlI - 2.0F;
            }
        }

        return new float[]{var2, var3};
    }

    public float[] IlllIIIIIIlllIlIIlllIlIIl(DraggableHudMod var1) {
        float var2;
        float var3;
        if (var1.lIIlIIlllIIIIlIlllIIIIlll() > 16.0F && var1.llIllIIIIlIIIIIIlllIllIlI() > 10.0F) {
            var2 = (float)var1.IIlllIllIlIllIllIIllIlIIl() + var1.IlIIlIIlIIlIIllIIIllIIllI() - this.llIllIIIIlIIIIIIlllIllIlI - 2.0F;
            var3 = (float)var1.lIlIIlIlllIIlIIIlIlIlIllI() + var1.IIlIlIIIllIIllllIllllIlIl() - this.llIllIIIIlIIIIIIlllIllIlI - 2.0F;
        } else {
            var2 = (float)var1.IIlllIllIlIllIllIIllIlIIl() + var1.lIIlIIlllIIIIlIlllIIIIlll() * (Float)var1.llIIlIlIIIllIlIlIlIIlIIll.llIlllIIIllllIIlllIllIIIl() / 2.0F + 2.0F;
            if (var1.lIlIIIIIllIIlIIlIIlIlIIlI().lIllIlIIIlIIIIIIIlllIlIll().equals(Position.TOP)) {
                var3 = (float)(var1.lIlIIlIlllIIlIIIlIlIlIllI() + (double)(var1.llIllIIIIlIIIIIIlllIllIlI() * (Float)var1.llIIlIlIIIllIlIlIlIIlIIll.llIlllIIIllllIIlllIllIIIl() * 2.0F)) - this.llIllIIIIlIIIIIIlllIllIlI - 2.0F;
            } else {
                var3 = (float)var1.lIlIIlIlllIIlIIIlIlIlIllI() - this.llIllIIIIlIIIIIIlllIllIlI - 2.0F;
            }
        }

        return new float[]{var2, var3};
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float[] var3) {
        return var1 > var3[0] - 2.0F && var2 > var3[1] - 2.0F && var1 < var3[0] + this.llIllIIIIlIIIIIIlllIllIlI + 2.0F && var2 < var3[1] + this.llIllIIIIlIIIIIIlllIllIlI + 2.25F;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, float[] var3) {
        return var1 > var3[0] - 2.0F && var2 > var3[1] - 2.0F && var1 < var3[0] + this.llIllIIIIlIIIIIIlllIllIlI + 2.0F && var2 < var3[1] + this.llIllIIIIlIIIIIIlllIllIlI + 2.25F;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, int var3) {
        if (!this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(var1, var2)) {
            Iterator var6;
            if (!this.lllllIIIIlIlllIllIIIlIIlI && this.lIlIIIIIIlIIIllllIllIIlII != null) {
                Feature var4 = this.lIlIIIIIIlIIIllllIllIIlII instanceof AbstractFeatureContainerChild ? ((AbstractFeatureContainerChild)this.lIlIIIIIIlIIIllllIllIIlII).IlIllIIlIIlIIIllIllllIIll() : this.lIlIIIIIIlIIIllllIllIIlII;
                if (this.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2, this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII))) {
                    IIlIllIlllllllIIlIIIllIIl();
                    SettingsUIScreen var5 = new SettingsUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen());
                    var5.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(new FeatureSettingsUIComponent(var5.llIIIIIIIllIIllIlIllIIIIl(), (Feature)var4));
                    if (this.lIlIIIIIIlIIIllllIllIIlII instanceof AbstractFeatureContainerChild) {
                        var6 = ((FeatureSettingsUIComponent)var5.llIIIIIIIllIIllIlIllIIIIl().lIIlIlllIlIlIIIlllIIlIIII()).lIIlIlllIlIlIIIlllIIlIIII().iterator();

                        while(var6.hasNext()) {
                            AbstractDescritiveSettingUIComponent var10 = (AbstractDescritiveSettingUIComponent)var6.next();
                            if (var10 instanceof FeatureContainerUIComponent) {
                                AbstractFeatureContainerChild var8 = ((FeatureContainerUIComponent)var10).llIlllIIIllllIIlllIllIIIl();
                                ((FeatureContainerUIComponent)var10).lIlIlIlIlIIlIIlIIllIIIIIl(var8 == this.lIlIIIIIIlIIIllllIllIIlII);
                                if (var8 == this.lIlIIIIIIlIIIllllIllIIlII) {
                                    ((FeatureSettingsUIComponent)var5.llIIIIIIIllIIllIlIllIIIIl().lIIlIlllIlIlIIIlllIIlIIII()).lIlIlIlIlIIlIIlIIllIIIIIl((UIComponent)var10);
                                }
                            }
                        }
                    }

                    if (Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getWorld() == null) {
                        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new MainMenuUIWrapper(var5)));
                    } else {
                        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(var5));
                    }

                    var5.llIlllIIIllllIIlllIllIIIl(0);
                    return;
                }

                if (this.IlllIIIIIIlllIlIIlllIlIIl(var1, var2, this.IlllIIIIIIlllIlIIlllIlIIl(this.lIlIIIIIIlIIIllllIllIIlII))) {
                    IIlIllIlllllllIIlIIIllIIl();
                    this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl(false);
                    return;
                }
            } else {
                this.lIlIIlIlllIIlIIIlIlIlIllI.clear();
            }

            if ((var3 == 0 || var3 == 1) && this.IIlIlIIIllIIllllIllllIlIl != null && !this.lllllIIIIlIlllIllIIIlIIlI && ((double)var1 >= this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().IIlllIllIlIllIllIIllIlIIl() - 2.5D && (double)var1 <= this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().IIlllIllIlIllIllIIllIlIIl() + 2.5D || (double)var1 >= this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().IIlllIllIlIllIllIIllIlIIl() + (double)this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().IlIIlIIlIIlIIllIIIllIIllI() - 2.5D && (double)var1 <= this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().IIlllIllIlIllIllIIllIlIIl() + (double)this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().IlIIlIIlIIlIIllIIIllIIllI() + 2.5D) && ((double)var2 <= this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIIlIlllIIlIIIlIlIlIllI() + 2.5D && (double)var2 >= this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIIlIlllIIlIIIlIlIlIllI() - 2.5D || (double)var2 >= this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIIlIlllIIlIIIlIlIlIllI() + (double)this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().IIlIlIIIllIIllllIllllIlIl() - 2.5D && (double)var2 <= this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIIlIlllIIlIIIlIlIlIllI() + (double)this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().IIlIlIIIllIIllllIllllIlIl() + 2.5D)) {
                this.IllllllllllIlIIIlllIlllll.add(new MovementUI.HistoricalAbstractHudMod(this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl(), this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIIIIIllIIlIIlIIlIlIIlI(), this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().lIIlIIIIIIlIIlIIllIlIIlII(), this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().IlIIIlIlIlIlIlIllIIllIIlI(), this.IIlIlIIIllIIllllIllllIlIl.lIlIlIlIlIIlIIlIIllIIIIIl().IlIlIllIIllllIllllllIIlIl(), System.currentTimeMillis()));
                this.lllllIIIIlIlllIllIIIlIIlI = true;
            } else {
                if (!this.lllllIIIIlIlllIllIIIlIIlI && (var3 == 0 || var3 == 1)) {
                    if (this.lIlIIIIIIlIIIllllIllIIlII != null) {
                        long var9 = System.currentTimeMillis();
                        if (var3 == 1) {
                            this.IIlllIllIlIllIllIIllIlIIl = var9;
                        }

                        var6 = this.llIIIIIIIllIIllIlIllIIIIl().iterator();

                        while(var6.hasNext()) {
                            ConfigurableFeature var7 = (ConfigurableFeature)var6.next();
                            if (var7 instanceof DraggableHudMod && var7.IlllIIIIIIlllIlIIlllIlIIl()) {
                                this.IllllllllllIlIIIlllIlllll.add(new MovementUI.HistoricalAbstractHudMod((DraggableHudMod)var7, ((DraggableHudMod)var7).lIlIIIIIllIIlIIlIIlIlIIlI(), ((DraggableHudMod)var7).lIIlIIIIIIlIIlIIllIlIIlII(), ((DraggableHudMod)var7).IlIIIlIlIlIlIlIllIIllIIlI(), ((DraggableHudMod)var7).IlIlIllIIllllIllllllIIlIl(), var9));
                            }
                        }

                        this.llIlIIIllIIlIllIllIllllIl = this.lIlIIIIIIlIIIllllIllIIlII;
                        if (!this.lIlIIlIlllIIlIIIlIlIlIllI.contains(this.lIlIIIIIIlIIIllllIllIIlII)) {
                            if (!IIlIllIlIIllIIlIlIllllllI()) {
                                this.lIlIIlIlllIIlIIIlIlIlIllI.clear();
                                this.IIlIllIlllllllIIlIIIllIIl.clear();
                            }

                            this.lIlIIlIlllIIlIIIlIlIlIllI.add(this.lIlIIIIIIlIIIllllIllIIlII);
                            this.IIlIllIlllllllIIlIIIllIIl.put(this.lIlIIIIIIlIIIllllIllIIlII, new MovementUI.SelectedAbstractHudMod(this.lIlIIIIIIlIIIllllIllIIlII, var1 - this.lIlIIIIIIlIIIllllIllIIlII.IlIIIlIlIlIlIlIllIIllIIlI(), var2 - this.lIlIIIIIIlIIIllllIllIIlII.IlIlIllIIllllIllllllIIlIl()));
                        }

                        this.IIlIllIlllllllIIlIIIllIIl.forEach((var2x, var3x) -> {
                            var3x.IlllIIIIIIlllIlIIlllIlIIl(var2 - var2x.IlIlIllIIllllIllllllIIlIl());
                            var3x.lIlIlIlIlIIlIIlIIllIIIIIl(var1 - var2x.IlIIIlIlIlIlIlIllIIllIIlI());
                        });
                        this.IllIllIIIllIIIlIlIlIIIIll = false;
                    } else {
                        this.lIlIlIIIIIIllIlIIIIllIIII = var2;
                        this.lIllllIllIIlIIlIIIlIIIlII = var1;
                        this.lIIlIIIIIIlIIlIIllIlIIlII = System.currentTimeMillis();
                    }
                }

            }
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, int var3) {
        this.lIlIIlIlllIIlIIIlIlIlIllI.forEach((var1x) -> {
            Anchor anchor = lIlIlIlIlIIlIIlIIllIIIIIl(var1x.IIlllIllIlIllIllIIllIlIIl(), var1x.lIlIIlIlllIIlIIIlIlIlIllI());
            if (anchor != var1x.lIlIIIIIllIIlIIlIIlIlIIlI()) {
                float[] points = new float[]{var1x.IlIIIlIlIlIlIlIllIIllIIlI(), var1x.IlIlIllIIllllIllllllIIlIl()};
                double var4 = var1x.lIlIlIlIlIIlIIlIIllIIIIIl(anchor, (double)this.IllllllllllIlIIIlllIlllll()) * (double)var1x.lIIlIIIIIIlIIlIIllIlIIlII();
                double var6 = var1x.IlllIIIIIIlllIlIIlllIlIIl(anchor, (double)this.lllllIllIlIIlIIlIIIlllIlI()) * (double)var1x.lIIlIIIIIIlIIlIIllIlIIlII();
                double var8 = var1x.lIlIlIlIlIIlIIlIIllIIIIIl(var1x.lIlIIIIIllIIlIIlIIlIlIIlI(), (double)this.IllllllllllIlIIIlllIlllll()) * (double)var1x.lIIlIIIIIIlIIlIIllIlIIlII();
                double var10 = var1x.IlllIIIIIIlllIlIIlllIlIIl(var1x.lIlIIIIIllIIlIIlIIlIlIIlI(), (double)this.lllllIllIlIIlIIlIIIlllIlI()) * (double)var1x.lIIlIIIIIIlIIlIIllIlIIlII();
                var1x.lIlIlIlIlIIlIIlIIllIIIIIl(anchor);
                var1x.lIlIlIlIlIIlIIlIIllIIIIIl((float)((double)points[0] - var4 + var8), (float)((double)points[1] - var6 + var10));
            }
        });
        if (this.lllllIIIIlIlllIllIIIlIIlI && this.IIlIlIIIllIIllllIllllIlIl != null) {
            this.lIIlIlllIlIlIIIlllIIlIIII.addAll(this.IllllllllllIlIIIlllIlllll);
            this.IllllllllllIlIIIlllIlllll.clear();
            this.lllllIIIIlIlllIllIIIlIIlI = false;
            this.IIlIlIIIllIIllllIllllIlIl = null;
        }

        if (this.llIlIIIllIIlIllIllIllllIl != null && var3 == 1 && System.currentTimeMillis() - this.IIlllIllIlIllIllIIllIlIIl <= 250L) {
            if (!AbstractUIScreen.lIIIlllIIIIllllIlIIIlIIll()) {
                if (this.llIlIIIllIIlIllIllIllllIl.lIlIIIIIllIIlIIlIIlIlIIlI() == Anchor.TOP_CENTER) {
                    llIIIlIllIIIIlIIIlIlIllIl.lIllIlIIIlIIIIIIIlllIlIll();
                    this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F, this.llIlIIIllIIlIllIllIllllIl.IlIlIllIIllllIllllllIIlIl());
                } else if (this.llIlIIIllIIlIllIllIllllIl.lIlIIIIIllIIlIIlIIlIlIIlI() != Anchor.MIDDLE_LEFT && this.llIlIIIllIIlIllIllIllllIl.lIlIIIIIllIIlIIlIIlIlIIlI() != Anchor.MIDDLE_RIGHT) {
                    if (this.llIlIIIllIIlIllIllIllllIl.lIlIIIIIllIIlIIlIIlIlIIlI() != Anchor.BOTTOM_CENTER_L && this.llIlIIIllIIlIllIllIllllIl.lIlIIIIIllIIlIIlIIlIlIIlI() != Anchor.BOTTOM_CENTER_R) {
                        if (this.llIlIIIllIIlIllIllIllllIl.lIlIIIIIllIIlIIlIIlIlIIlI().lIllIlIIIlIIIIIIIlllIlIll() == Position.MIDDLE) {
                            lIIIlllIIIIllllIlIIIlIIll.lIllIlIIIlIIIIIIIlllIlIll();
                        }

                        if (this.llIlIIIllIIlIllIllIllllIl.lIlIIIIIllIIlIIlIIlIlIIlI().IlllIIIIIIlllIlIIlllIlIIl() == Position.MIDDLE) {
                            llIIIlIllIIIIlIIIlIlIllIl.lIllIlIIIlIIIIIIIlllIlIll();
                        }

                        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F, 0.0F);
                    } else {
                        llIIIlIllIIIIlIIIlIlIllIl.lIllIlIIIlIIIIIIIlllIlIll();
                        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F, this.llIlIIIllIIlIllIllIllllIl.IlIlIllIIllllIllllllIIlIl());
                    }
                } else {
                    lIIIlllIIIIllllIlIIIlIIll.lIllIlIIIlIIIIIIIlllIlIll();
                    this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl.IlIIIlIlIlIlIlIllIIllIIlI(), 0.0F);
                }
            } else {
                if (this.llIlIIIllIIlIllIllIllllIl.lIlIIIIIllIIlIIlIIlIlIIlI().lIllIlIIIlIIIIIIIlllIlIll() == Position.MIDDLE) {
                    lIIIlllIIIIllllIlIIIlIIll.lIllIlIIIlIIIIIIIlllIlIll();
                }

                if (this.llIlIIIllIIlIllIllIllllIl.lIlIIIIIllIIlIIlIIlIlIIlI().IlllIIIIIIlllIlIIlllIlIIl() == Position.MIDDLE) {
                    llIIIlIllIIIIlIIIlIlIllIl.lIllIlIIIlIIIIIIIlllIlIll();
                }

                this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F, 0.0F);
            }

            IIlIllIlllllllIIlIIIllIIl();
        }

        if (var3 == 0 || var3 == 1) {
            if (this.lIlIlIIIIIIllIlIIIIllIIII != 0.0F || this.lIllllIllIIlIIlIIIlIIIlII != 0.0F) {
                this.lIlIlIIIIIIllIlIIIIllIIII = 0.0F;
                this.lIllllIllIIlIIlIIIlIIIlII = 0.0F;
                this.lIlIIlIlllIIlIIIlIlIlIllI.addAll(this.IlIIlIIlIIlIIllIIIllIIllI);
                this.IIlIllIlllllllIIlIIIllIIl.clear();
                this.IlIIlIIlIIlIIllIIIllIIllI.forEach((var3x) -> {
                    this.IIlIllIlllllllIIlIIIllIIl.put(var3x, new MovementUI.SelectedAbstractHudMod(var3x, var1 - var3x.IlIIIlIlIlIlIlIllIIllIIlI(), var2 - var3x.IlIlIllIIllllIllllllIIlIl()));
                });
                this.llllIlIllllIlIlIIIllIlIlI = 0.0F;
                this.IlIllIIlIIlIIIllIllllIIll = 0.0F;
                this.llIlIIIllIIlIllIllIllllIl = null;
            }

            if (this.llIlIIIllIIlIllIllIllllIl != null) {
                this.IllllllllllIlIIIlllIlllll.forEach((var1x) -> {
                    if (var1x.lIlIlIlIlIIlIIlIIllIIIIIl().IlIIIlIlIlIlIlIllIIllIIlI() != var1x.llIlllIIIllllIIlllIllIIIl || var1x.lIlIlIlIlIIlIIlIIllIIIIIl().IlIlIllIIllllIllllllIIlIl() != var1x.llllIIlIIlIIlIIllIIlIIllI) {
                        this.lIIlIlllIlIlIIIlllIIlIIII.add(var1x);
                    }
                });
                this.IllllllllllIlIIIlllIlllll.clear();
                this.llllIlIllllIlIlIIIllIlIlI = 0.0F;
                this.IlIllIIlIIlIIIllIllllIIll = 0.0F;
                this.llIlIIIllIIlIllIllIllllIl = null;
                Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().save();
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
            }
        }

    }

    public Set<ConfigurableFeature> llIIIIIIIllIIllIlIllIIIIl() {
        Set var1 = (Set) LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl().stream().filter((var0) -> {
            return var0 instanceof DraggableHudMod && var0.IlllIIIIIIlllIlIIlllIlIIl();
        }).collect(Collectors.toSet());
        LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIllIllllIlIllllII().llIlllIIIllllIIlllIllIIIl().stream().filter((var0) -> {
            return var0.llIIIllllIIIllIIIIlIlIlll().size() > 0;
        }).forEach((var1x) -> {
            Iterator var2 = var1x.llIIIllllIIIllIIIIlIlIlll().iterator();

            while(var2.hasNext()) {
                AbstractFeatureContainerChild var3 = (AbstractFeatureContainerChild)var2.next();
                if (var3.IlllIIIIIIlllIlIIlllIlIIl()) {
                    var1.add(var3);
                }
            }

        });
        return var1;
    }

    public void lllIIIIIlllIIlIllIIlIIIlI() {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glTranslatef(0.0F, this.lllllIllIlIIlIIlIIIlllIlI() - 185.0F, 0.0F);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(0.0F, 0.0F, 240.0F, 140.0F, Integer.MIN_VALUE);
        FontRegistry.IlIlIlllllIlIIlIlIlllIlIl().lIlIlIlIlIIlIIlIIllIIIIIl(this.get("shortcutsMovement", new Object[0]), 4.0F, 2.0F, -1);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(4.0F, 12.0F, 234.0F, 12.5F, -2130706433);
        byte var1 = 16;
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Mouse1", 6, var1);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl("| " + EnumChatColor.lllllIllIllIllllIlIllllII + this.get("hold", new Object[0]) + EnumChatColor.IllIIIlllIIIlIlllIlIIlIII + " " + this.get("addModsToRegion", new Object[0]), 80.0F, (float)var1, -1);
        int var2 = var1 + 12;
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Mouse1", 6, var2);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl("| " + EnumChatColor.lllllIllIllIllllIlIllllII + this.get("hold", new Object[0]) + EnumChatColor.IllIIIlllIIIlIlllIlIIlIII + " " + this.get("selectDragMods", new Object[0]), 80.0F, (float)var2, -1);
        var2 += 12;
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Mouse2", 6, var2);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl("| " + EnumChatColor.lllllIllIllIllllIlIllllII + this.get("click", new Object[0]) + EnumChatColor.IllIIIlllIIIlIlllIlIIlIII + " " + this.get("resetToClosest", new Object[0]), 80.0F, (float)var2, -1);
        var2 += 12;
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Mouse2", 6, var2);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl("| " + EnumChatColor.lllllIllIllIllllIlIllllII + this.get("hold", new Object[0]) + EnumChatColor.IllIIIlllIIIlIlllIlIIlIII + " " + this.get("dontLockDragging", new Object[0]), 80.0F, (float)var2, -1);
        var2 += 12;
        this.lIlIlIlIlIIlIIlIIllIIIIIl("CTRL", 6, var2);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl("+", 30.0F, (float)var2, -1);
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Mouse1", 36, var2);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl("| " + this.get("toggleModSelection", new Object[0]), 80.0F, (float)var2, -1);
        var2 += 12;
        this.lIlIlIlIlIIlIIlIIllIIIIIl("CTRL", 6, var2);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl("+", 30.0F, (float)var2, -1);
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Z", 36, var2);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl("| " + this.get("undoMovements", new Object[0]), 80.0F, (float)var2, -1);
        var2 += 12;
        this.lIlIlIlIlIIlIIlIIllIIIIIl("CTRL", 6, var2);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl("+", 30.0F, (float)var2, -1);
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Y", 36, var2);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl("| " + this.get("redoMovements", new Object[0]), 80.0F, (float)var2, -1);
        var1 = 112;
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Up", 31, var1);
        var2 = var1 + 12;
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Left", 6, var2);
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Down", 26, var2);
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Right", 51, var2);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl("| " + this.get("moveWithPrecision", new Object[0]), 80.0F, (float)var2, -1);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1, int var2, int var3) {
        LCFontRenderer var4 = FontRegistry.llIIlIlIIIllIlIlIlIIlIIll();
        float var5 = (float)var4.IlllIIIIIIlllIlIIlllIlIIl(var1);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll((float)var2, (float)var3, var5 + 4.0F, 10.0F, 2.0F, -1);
        var4.lIlIlIlIlIIlIIlIIllIIIIIl(var1, (float)(var2 + 2), (float)var3, -16777216);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(char var1, KeyType var2) {
        Iterator var5;
        DraggableHudMod var10;
        if (AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) {
            MovementUI.HistoricalAbstractHudMod var3;
            ArrayList var4;
            MovementUI.HistoricalAbstractHudMod var6;
            if (var2 == KeyType.IIIlIIIIIIllIIIIllIIIIlII && this.lIIlIlllIlIlIIIlllIIlIIII.size() > 0) {
                var3 = (MovementUI.HistoricalAbstractHudMod)this.lIIlIlllIlIlIIIlllIIlIIII.get(this.lIIlIlllIlIlIIIlllIIlIIII.size() - 1);
                var4 = new ArrayList();
                var5 = this.lIIlIlllIlIlIIIlllIIlIIII.iterator();

                while(var5.hasNext()) {
                    var6 = (MovementUI.HistoricalAbstractHudMod)var5.next();
                    if (var3.IlIlIlllllIlIIlIlIlllIlIl() == var6.IlIlIlllllIlIIlIlIlllIlIl()) {
                        var4.add(var6);
                        this.llIllIlIllIlllIllIIIIllII.add(new MovementUI.HistoricalAbstractHudMod(var6.lIlIlIlIlIIlIIlIIllIIIIIl(), var6.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIIIIIllIIlIIlIIlIlIIlI(), var6.lIlIlIlIlIIlIIlIIllIIIIIl().lIIlIIIIIIlIIlIIllIlIIlII(), var6.lIlIlIlIlIIlIIlIIllIIIIIl().IlIIIlIlIlIlIlIllIIllIIlI(), var6.lIlIlIlIlIIlIIlIIllIIIIIl().IlIlIllIIllllIllllllIIlIl(), var3.IlIlIlllllIlIIlIlIlllIlIl()));
                        if (!var6.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl() && var6.lIlIlIlIlIIlIIlIIllIIIIIl.IlIIIlIlIlIlIlIllIIllIIlI() == var6.llIlllIIIllllIIlllIllIIIl && var6.llllIIlIIlIIlIIllIIlIIllI == var6.lIlIlIlIlIIlIIlIIllIIIIIl.IlIlIllIIllllIllllllIIlIl()) {
                            var6.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(true);
                        }

                        var6.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(var6.lIllIlIIIlIIIIIIIlllIlIll);
                        var6.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var6.IlllIIIIIIlllIlIIlllIlIIl());
                        var6.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var6.llIlllIIIllllIIlllIllIIIl, var6.llllIIlIIlIIlIIllIIlIIllI);
                    }
                }

                this.lIIlIlllIlIlIIIlllIIlIIII.removeAll(var4);
            }

            if (var2 == KeyType.lIIlllIIIIIlllIIIlIlIlllI && this.llIllIlIllIlllIllIIIIllII.size() > 0) {
                var3 = (MovementUI.HistoricalAbstractHudMod)this.llIllIlIllIlllIllIIIIllII.get(this.llIllIlIllIlllIllIIIIllII.size() - 1);
                var4 = new ArrayList();
                var5 = this.llIllIlIllIlllIllIIIIllII.iterator();

                while(var5.hasNext()) {
                    var6 = (MovementUI.HistoricalAbstractHudMod)var5.next();
                    if (var3.IlIlIlllllIlIIlIlIlllIlIl() == var6.IlIlIlllllIlIIlIlIlllIlIl()) {
                        var4.add(var6);
                        this.lIIlIlllIlIlIIIlllIIlIIII.add(new MovementUI.HistoricalAbstractHudMod(var6.lIlIlIlIlIIlIIlIIllIIIIIl(), var6.lIlIlIlIlIIlIIlIIllIIIIIl().lIlIIIIIllIIlIIlIIlIlIIlI(), var6.lIlIlIlIlIIlIIlIIllIIIIIl().lIIlIIIIIIlIIlIIllIlIIlII(), var6.lIlIlIlIlIIlIIlIIllIIIIIl().IlIIIlIlIlIlIlIllIIllIIlI(), var6.lIlIlIlIlIIlIIlIIllIIIIIl().IlIlIllIIllllIllllllIIlIl(), var3.IlIlIlllllIlIIlIlIlllIlIl()));
                        if (!var6.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl() && var6.lIlIlIlIlIIlIIlIIllIIIIIl.IlIIIlIlIlIlIlIllIIllIIlI() == var6.llIlllIIIllllIIlllIllIIIl && var6.llllIIlIIlIIlIIllIIlIIllI == var6.lIlIlIlIlIIlIIlIIllIIIIIl.IlIlIllIIllllIllllllIIlIl()) {
                            var6.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(true);
                        }

                        var6.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(var6.lIllIlIIIlIIIIIIIlllIlIll);
                        var6.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var6.IlllIIIIIIlllIlIIlllIlIIl());
                        var6.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var6.llIlllIIIllllIIlllIllIIIl, var6.llllIIlIIlIIlIIllIIlIIllI);
                    }
                }

                this.llIllIlIllIlllIllIIIIllII.removeAll(var4);
            }

            if (var2 == KeyType.lIlIIlIlllIIlIIIlIlIlIllI && this.lIlIIlIlllIIlIIIlIlIlIllI != null && !this.lIlIIlIlllIIlIIIlIlIlIllI.isEmpty()) {
                long var7 = System.currentTimeMillis();
                var5 = this.lIlIIlIlllIIlIIIlIlIlIllI.iterator();

                while(var5.hasNext()) {
                    var10 = (DraggableHudMod)var5.next();
                    if (var10 != null) {
                        this.lIIlIlllIlIlIIIlllIIlIIII.add(new MovementUI.HistoricalAbstractHudMod(var10, var10.lIlIIIIIllIIlIIlIIlIlIIlI(), var10.lIIlIIIIIIlIIlIIllIlIIlII(), var10.IlIIIlIlIlIlIlIllIIllIIlI(), var10.IlIlIllIIllllIllllllIIlIl(), var7));
                        var10.IlllIIIIIIlllIlIIlllIlIIl(false);
                    }
                }

                this.lIlIIlIlllIIlIIIlIlIlIllI.clear();
            }
        }

        if (!this.lIlIIlIlllIIlIIIlIlIlIllI.isEmpty()) {
            int var8 = 0;
            int var9 = 0;
            if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IIllllIIlllIlIIlIIlllIlII)) {
                --var8;
            }

            if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IllIlIIlllIIlIIllIIIIIIIl)) {
                ++var8;
            }

            if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlllIIIIIllIIllIllIIlll)) {
                --var9;
            }

            if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.lIlIIllIIIlIIIlIIIlIIlIll)) {
                ++var9;
            }

            var5 = this.lIlIIlIlllIIlIIIlIlIlIllI.iterator();

            while(var5.hasNext()) {
                var10 = (DraggableHudMod)var5.next();
                if (var10 != null) {
                    var10.lIlIlIlIlIIlIIlIIllIIIIIl(var10.IlIIIlIlIlIlIlIllIIllIIlI() + (float)var8, var10.IlIlIllIIllllIllllllIIlIl() + (float)var9);
                }
            }
        }

    }

    public String getLanguagePath() {
        return super.getLanguagePath() + ".movement";
    }

    public void lIlIIIIIIlIIIllllIllIIlII() {
    }

    public static class SelectedAbstractHudMod {
        public DraggableHudMod lIlIlIlIlIIlIIlIIllIIIIIl;
        public float IlllIIIIIIlllIlIIlllIlIIl;
        public float lIllIlIIIlIIIIIIIlllIlIll;

        public SelectedAbstractHudMod(DraggableHudMod var1, float var2, float var3) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
            this.IlllIIIIIIlllIlIIlllIlIIl = var2;
            this.lIllIlIIIlIIIIIIIlllIlIll = var3;
        }

        public DraggableHudMod lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public float IlllIIIIIIlllIlIIlllIlIIl() {
            return this.IlllIIIIIIlllIlIIlllIlIIl;
        }

        public float lIllIlIIIlIIIIIIIlllIlIll() {
            return this.lIllIlIIIlIIIIIIIlllIlIll;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(DraggableHudMod var1) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1) {
            this.IlllIIIIIIlllIlIIlllIlIIl = var1;
        }

        public void IlllIIIIIIlllIlIIlllIlIIl(float var1) {
            this.lIllIlIIIlIIIIIIIlllIlIll = var1;
        }

        public boolean equals(Object var1) {
            if (var1 == this) {
                return true;
            } else if (!(var1 instanceof MovementUI.SelectedAbstractHudMod)) {
                return false;
            } else {
                MovementUI.SelectedAbstractHudMod var2 = (MovementUI.SelectedAbstractHudMod)var1;
                if (!var2.lIlIlIlIlIIlIIlIIllIIIIIl((Object)this)) {
                    return false;
                } else if (Float.compare(this.IlllIIIIIIlllIlIIlllIlIIl(), var2.IlllIIIIIIlllIlIIlllIlIIl()) != 0) {
                    return false;
                } else if (Float.compare(this.lIllIlIIIlIIIIIIIlllIlIll(), var2.lIllIlIIIlIIIIIIIlllIlIll()) != 0) {
                    return false;
                } else {
                    DraggableHudMod var3 = this.lIlIlIlIlIIlIIlIIllIIIIIl();
                    DraggableHudMod var4 = var2.lIlIlIlIlIIlIIlIIllIIIIIl();
                    if (var3 == null) {
                        if (var4 == null) {
                            return true;
                        }
                    } else if (var3.equals(var4)) {
                        return true;
                    }

                    return false;
                }
            }
        }

        public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object var1) {
            return var1 instanceof MovementUI.SelectedAbstractHudMod;
        }

        public int hashCode() {
            boolean var1 = true;
            byte var2 = 1;
            int var4 = var2 * 59 + Float.floatToIntBits(this.IlllIIIIIIlllIlIIlllIlIIl());
            var4 = var4 * 59 + Float.floatToIntBits(this.lIllIlIIIlIIIIIIIlllIlIll());
            DraggableHudMod var3 = this.lIlIlIlIlIIlIIlIIllIIIIIl();
            var4 = var4 * 59 + (var3 == null ? 43 : var3.hashCode());
            return var4;
        }

        public String toString() {
            return "MovementUI.SelectedAbstractHudMod(mod=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", dragX=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", dragY=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ")";
        }
    }

    public static class ScaleAbstractHudMod {
        public DraggableHudMod lIlIlIlIlIIlIIlIIllIIIIIl;
        public Anchor IlllIIIIIIlllIlIIlllIlIIl;
        public float lIllIlIIIlIIIIIIIlllIlIll;
        public float llIlllIIIllllIIlllIllIIIl;
        public int llllIIlIIlIIlIIllIIlIIllI;
        public float IlIlIlllllIlIIlIlIlllIlIl;
        public float[] llIIIIIIIllIIllIlIllIIIIl;

        public ScaleAbstractHudMod(DraggableHudMod var1, Anchor var2, float var3, float var4, int var5, float var6, float[] var7) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
            this.IlllIIIIIIlllIlIIlllIlIIl = var2;
            this.lIllIlIIIlIIIIIIIlllIlIll = var3;
            this.llIlllIIIllllIIlllIllIIIl = var4;
            this.llllIIlIIlIIlIIllIIlIIllI = var5;
            this.IlIlIlllllIlIIlIlIlllIlIl = var6;
            this.llIIIIIIIllIIllIlIllIIIIl = var7;
        }

        public DraggableHudMod lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public Anchor IlllIIIIIIlllIlIIlllIlIIl() {
            return this.IlllIIIIIIlllIlIIlllIlIIl;
        }

        public float lIllIlIIIlIIIIIIIlllIlIll() {
            return this.lIllIlIIIlIIIIIIIlllIlIll;
        }

        public float llIlllIIIllllIIlllIllIIIl() {
            return this.llIlllIIIllllIIlllIllIIIl;
        }

        public int llllIIlIIlIIlIIllIIlIIllI() {
            return this.llllIIlIIlIIlIIllIIlIIllI;
        }

        public float IlIlIlllllIlIIlIlIlllIlIl() {
            return this.IlIlIlllllIlIIlIlIlllIlIl;
        }

        public float[] llIIIIIIIllIIllIlIllIIIIl() {
            return this.llIIIIIIIllIIllIlIllIIIIl;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(DraggableHudMod var1) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(Anchor var1) {
            this.IlllIIIIIIlllIlIIlllIlIIl = var1;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1) {
            this.lIllIlIIIlIIIIIIIlllIlIll = var1;
        }

        public void IlllIIIIIIlllIlIIlllIlIIl(float var1) {
            this.llIlllIIIllllIIlllIllIIIl = var1;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(int var1) {
            this.llllIIlIIlIIlIIllIIlIIllI = var1;
        }

        public void lIllIlIIIlIIIIIIIlllIlIll(float var1) {
            this.IlIlIlllllIlIIlIlIlllIlIl = var1;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(float[] var1) {
            this.llIIIIIIIllIIllIlIllIIIIl = var1;
        }

        public boolean equals(Object var1) {
            if (var1 == this) {
                return true;
            } else if (!(var1 instanceof MovementUI.ScaleAbstractHudMod)) {
                return false;
            } else {
                MovementUI.ScaleAbstractHudMod var2 = (MovementUI.ScaleAbstractHudMod)var1;
                if (!var2.lIlIlIlIlIIlIIlIIllIIIIIl((Object)this)) {
                    return false;
                } else if (Float.compare(this.lIllIlIIIlIIIIIIIlllIlIll(), var2.lIllIlIIIlIIIIIIIlllIlIll()) != 0) {
                    return false;
                } else if (Float.compare(this.llIlllIIIllllIIlllIllIIIl(), var2.llIlllIIIllllIIlllIllIIIl()) != 0) {
                    return false;
                } else if (this.llllIIlIIlIIlIIllIIlIIllI() != var2.llllIIlIIlIIlIIllIIlIIllI()) {
                    return false;
                } else if (Float.compare(this.IlIlIlllllIlIIlIlIlllIlIl(), var2.IlIlIlllllIlIIlIlIlllIlIl()) != 0) {
                    return false;
                } else {
                    DraggableHudMod var3 = this.lIlIlIlIlIIlIIlIIllIIIIIl();
                    DraggableHudMod var4 = var2.lIlIlIlIlIIlIIlIIllIIIIIl();
                    if (var3 == null) {
                        if (var4 != null) {
                            return false;
                        }
                    } else if (!var3.equals(var4)) {
                        return false;
                    }

                    label42: {
                        Anchor var5 = this.IlllIIIIIIlllIlIIlllIlIIl();
                        Anchor var6 = var2.IlllIIIIIIlllIlIIlllIlIIl();
                        if (var5 == null) {
                            if (var6 == null) {
                                break label42;
                            }
                        } else if (var5.equals(var6)) {
                            break label42;
                        }

                        return false;
                    }

                    if (!Arrays.equals(this.llIIIIIIIllIIllIlIllIIIIl(), var2.llIIIIIIIllIIllIlIllIIIIl())) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }

        public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object var1) {
            return var1 instanceof MovementUI.ScaleAbstractHudMod;
        }

        public int hashCode() {
            boolean var1 = true;
            byte var2 = 1;
            int var5 = var2 * 59 + Float.floatToIntBits(this.lIllIlIIIlIIIIIIIlllIlIll());
            var5 = var5 * 59 + Float.floatToIntBits(this.llIlllIIIllllIIlllIllIIIl());
            var5 = var5 * 59 + this.llllIIlIIlIIlIIllIIlIIllI();
            var5 = var5 * 59 + Float.floatToIntBits(this.IlIlIlllllIlIIlIlIlllIlIl());
            DraggableHudMod var3 = this.lIlIlIlIlIIlIIlIIllIIIIIl();
            var5 = var5 * 59 + (var3 == null ? 43 : var3.hashCode());
            Anchor var4 = this.IlllIIIIIIlllIlIIlllIlIIl();
            var5 = var5 * 59 + (var4 == null ? 43 : var4.hashCode());
            var5 = var5 * 59 + Arrays.hashCode(this.llIIIIIIIllIIllIlIllIIIIl());
            return var5;
        }

        public String toString() {
            return "MovementUI.ScaleAbstractHudMod(mod=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", hudModPosition=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", mouseX=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ", mouseY=" + this.llIlllIIIllllIIlllIllIIIl() + ", scaleRegion=" + this.llllIIlIIlIIlIIllIIlIIllI() + ", scale=" + this.IlIlIlllllIlIIlIlIlllIlIl() + ", drawing=" + Arrays.toString(this.llIIIIIIIllIIllIlIllIIIIl()) + ")";
        }
    }

    public static class HistoricalAbstractHudMod {
        public DraggableHudMod lIlIlIlIlIIlIIlIIllIIIIIl;
        public Anchor IlllIIIIIIlllIlIIlllIlIIl;
        public float lIllIlIIIlIIIIIIIlllIlIll;
        public float llIlllIIIllllIIlllIllIIIl;
        public float llllIIlIIlIIlIIllIIlIIllI;
        public long IlIlIlllllIlIIlIlIlllIlIl;

        public HistoricalAbstractHudMod(DraggableHudMod var1, Anchor var2, float var3, float var4, float var5, long var6) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
            this.IlllIIIIIIlllIlIIlllIlIIl = var2;
            this.lIllIlIIIlIIIIIIIlllIlIll = var3;
            this.llIlllIIIllllIIlllIllIIIl = var4;
            this.llllIIlIIlIIlIIllIIlIIllI = var5;
            this.IlIlIlllllIlIIlIlIlllIlIl = var6;
        }

        public DraggableHudMod lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.lIlIlIlIlIIlIIlIIllIIIIIl;
        }

        public Anchor IlllIIIIIIlllIlIIlllIlIIl() {
            return this.IlllIIIIIIlllIlIIlllIlIIl;
        }

        public float lIllIlIIIlIIIIIIIlllIlIll() {
            return this.lIllIlIIIlIIIIIIIlllIlIll;
        }

        public float llIlllIIIllllIIlllIllIIIl() {
            return this.llIlllIIIllllIIlllIllIIIl;
        }

        public float llllIIlIIlIIlIIllIIlIIllI() {
            return this.llllIIlIIlIIlIIllIIlIIllI;
        }

        public long IlIlIlllllIlIIlIlIlllIlIl() {
            return this.IlIlIlllllIlIIlIlIlllIlIl;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(DraggableHudMod var1) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(Anchor var1) {
            this.IlllIIIIIIlllIlIIlllIlIIl = var1;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1) {
            this.lIllIlIIIlIIIIIIIlllIlIll = var1;
        }

        public void IlllIIIIIIlllIlIIlllIlIIl(float var1) {
            this.llIlllIIIllllIIlllIllIIIl = var1;
        }

        public void lIllIlIIIlIIIIIIIlllIlIll(float var1) {
            this.llllIIlIIlIIlIIllIIlIIllI = var1;
        }

        public void lIlIlIlIlIIlIIlIIllIIIIIl(long var1) {
            this.IlIlIlllllIlIIlIlIlllIlIl = var1;
        }

        public boolean equals(Object var1) {
            if (var1 == this) {
                return true;
            } else if (!(var1 instanceof MovementUI.HistoricalAbstractHudMod)) {
                return false;
            } else {
                MovementUI.HistoricalAbstractHudMod var2 = (MovementUI.HistoricalAbstractHudMod)var1;
                if (!var2.lIlIlIlIlIIlIIlIIllIIIIIl((Object)this)) {
                    return false;
                } else if (Float.compare(this.lIllIlIIIlIIIIIIIlllIlIll(), var2.lIllIlIIIlIIIIIIIlllIlIll()) != 0) {
                    return false;
                } else if (Float.compare(this.llIlllIIIllllIIlllIllIIIl(), var2.llIlllIIIllllIIlllIllIIIl()) != 0) {
                    return false;
                } else if (Float.compare(this.llllIIlIIlIIlIIllIIlIIllI(), var2.llllIIlIIlIIlIIllIIlIIllI()) != 0) {
                    return false;
                } else if (this.IlIlIlllllIlIIlIlIlllIlIl() != var2.IlIlIlllllIlIIlIlIlllIlIl()) {
                    return false;
                } else {
                    DraggableHudMod var3 = this.lIlIlIlIlIIlIIlIIllIIIIIl();
                    DraggableHudMod var4 = var2.lIlIlIlIlIIlIIlIIllIIIIIl();
                    if (var3 == null) {
                        if (var4 != null) {
                            return false;
                        }
                    } else if (!var3.equals(var4)) {
                        return false;
                    }

                    Anchor var5 = this.IlllIIIIIIlllIlIIlllIlIIl();
                    Anchor var6 = var2.IlllIIIIIIlllIlIIlllIlIIl();
                    if (var5 == null) {
                        if (var6 != null) {
                            return false;
                        }
                    } else if (!var5.equals(var6)) {
                        return false;
                    }

                    return true;
                }
            }
        }

        public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object var1) {
            return var1 instanceof MovementUI.HistoricalAbstractHudMod;
        }

        public int hashCode() {
            boolean var1 = true;
            byte var2 = 1;
            int var7 = var2 * 59 + Float.floatToIntBits(this.lIllIlIIIlIIIIIIIlllIlIll());
            var7 = var7 * 59 + Float.floatToIntBits(this.llIlllIIIllllIIlllIllIIIl());
            var7 = var7 * 59 + Float.floatToIntBits(this.llllIIlIIlIIlIIllIIlIIllI());
            long var3 = this.IlIlIlllllIlIIlIlIlllIlIl();
            var7 = var7 * 59 + (int)(var3 >>> 32 ^ var3);
            DraggableHudMod var5 = this.lIlIlIlIlIIlIIlIIllIIIIIl();
            var7 = var7 * 59 + (var5 == null ? 43 : var5.hashCode());
            Anchor var6 = this.IlllIIIIIIlllIlIIlllIlIIl();
            var7 = var7 * 59 + (var6 == null ? 43 : var6.hashCode());
            return var7;
        }

        public String toString() {
            return "MovementUI.HistoricalAbstractHudMod(mod=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", hudModPosition=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", scale=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ", x=" + this.llIlllIIIllllIIlllIllIIIl() + ", y=" + this.llllIIlIIlIIlIIllIIlIIllI() + ", groupingTime=" + this.IlIlIlllllIlIIlIlIlllIlIl() + ")";
        }
    }
}
 