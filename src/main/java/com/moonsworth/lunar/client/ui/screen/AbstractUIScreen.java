package com.moonsworth.lunar.client.ui.screen;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.CustomScreen;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.WrappedGuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.TessellatorBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.event.EventHandler;
import com.moonsworth.lunar.client.feature.type.blur.MenuBlurMod;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.profile.main.GeneralOptions;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.BaseMainMenuUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.movement.MovementUI;
import com.moonsworth.lunar.client.ui.screen.type.overlay.FriendsUIScreen;
import com.moonsworth.lunar.client.util.ScaledResolutionHelper;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Decencies
 * @since 10/07/2021 18:23
 */
public abstract class AbstractUIScreen
        implements EventHandler,
        I18nBridge,
        CustomScreen {
    public static final ResourceLocationBridge llllIIlIIlIIlIIllIIlIIllI = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/settings/star-12x12.png");
    public int IlIlIlllllIlIIlIlIlllIlIl;
    public int llIIIIIIIllIIllIlIllIIIIl;
    public float lIIIllIllIIllIlllIlIIlllI;
    public float IlllllIlIIIlIIlIIllIIlIll;
    public List<UIComponent> llIIlIlIIIllIlIlIlIIlIIll = Collections.synchronizedList(new ArrayList<>(this.llIIlIlIIIllIlIlIlIIlIIll()));
    public static ScaledResolutionHelper lIlIlIlIlIIlIIlIIllIIIIIl;
    public static final ResourceLocationBridge IlllIIIIIIlllIlIIlllIlIIl;
    public static final ResourceLocationBridge lIllIlIIIlIIIIIIIlllIlIll;
    public static long llIlllIIIllllIIlllIllIIIl;
    public static final AnimatedLunarLogoUIComponent llIIIlllIIlllIllllIlIllIl;

    public abstract List<UIComponent> llIIlIlIIIllIlIlIlIIlIIll();

    @Override
    public String getLanguagePath() {
        return "gui";
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(MinecraftBridge minecraftBridge, int n, int n2) {
        this.IlIlIlllllIlIIlIlIlllIlIl = n;
        this.llIIIIIIIllIIllIlIllIIIIl = n2;
        lIlIlIlIlIIlIIlIIllIIIIIl = new ScaledResolutionHelper(minecraftBridge);
        float f = AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII();
        this.lIIIllIllIIllIlllIlIIlllI = (float)n / f;
        this.IlllllIlIIIlIIlIIllIIlIll = (float)n2 / f;
        this.llllIIlIIlIIlIIllIIlIIllI();
    }

    @Override
    public void llllIIlIIlIIlIIllIIlIIllI() {
        this.llIIIlllIIlllIllllIlIllIl();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n, int n2, float f) {
        float f2 = AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII();
        float f3 = (float)n / f2;
        float f4 = (float)n2 / f2;
        MenuBlurMod menuBlurMod = LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIllIllllIlIllllII().lIllllIllIIlIIlIIIlIIIlII();
        if (menuBlurMod.lIlIIlIlllIIlIIIlIlIlIllI().IlllIIIIIIlllIlIIlllIlIIl().lIlIlIlIlIIlIIlIIllIIIIIl() && !(this instanceof BaseMainMenuUIScreen) && !(this instanceof FriendsUIScreen)) {
            menuBlurMod.lIllllIllIIlIIlIIIlIIIlII();
            ColorSetting colorSetting = menuBlurMod.lIlIIlIlllIIlIIIlIlIlIllI().lIllIlIIIlIIIIIIIlllIlIll();
            colorSetting.IlllllIlIIIlIIlIIllIIlIll(Math.min(colorSetting.llllIIlIIlIIlIIllIIlIIllI(), 0.75f));
            colorSetting.lIlIlIlIlIIlIIlIIllIIIIIl(0.0f, 0.0f, (float)lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(), (float)lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl());
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(f2, f2, f2);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f3, f4);
        for (UIComponent uIComponent : this.llIIlIlIIIllIlIlIlIIlIIll) {
            if (!uIComponent.IIlIllIlllllllIIlIIIllIIl() || !uIComponent.lllllIllIllIllllIlIllllII()) continue;
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f3, f4, this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f3, f4, new UIComponent[0]));
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n, int n2, int n3) {
        block7: {
            float f = AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII();
            float f2 = (float)n / f;
            float f3 = (float)n2 / f;
            this.lIlIlIlIlIIlIIlIIllIIIIIl(f2, f3, n3);
            try {
                Object object2;
                for (UIComponent component : this.llIIlIlIIIllIlIlIlIIlIIll) {
                    if (!((UIComponent)component).IIlIllIlllllllIIlIIIllIIl()) continue;
                    ((UIComponent)component).IlllIIIIIIlllIlIIlllIlIIl(f2, f3, n3);
                }
                Object object3 = null;
                for (UIComponent uIComponent : this.llIIlIlIIIllIlIlIlIIlIIll) {
                    if (!uIComponent.IIlIllIlllllllIIlIIIllIIl() || !uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f2, f3) || !this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f2, f3, new UIComponent[0]) || !uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f2, f3, n3)) continue;
                    object3 = uIComponent;
                    AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                    break;
                }
                if (object3 == null) break block7;
                object2 = this.llIIlIlIIIllIlIlIlIIlIIll;
                synchronized (object2) {
                    this.llIIlIlIIIllIlIlIlIIlIIll.add(this.llIIlIlIIIllIlIlIlIIlIIll.remove(this.llIIlIlIIIllIlIlIlIIlIIll.indexOf(object3)));
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(int n, int n2, int n3) {
        float f = AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII();
        float f2 = (float)n / f;
        float f3 = (float)n2 / f;
        this.IlllIIIIIIlllIlIIlllIlIIl(f2 / f, f3 / f, n3);
        for (UIComponent uIComponent : this.llIIlIlIIIllIlIlIlIIlIIll) {
            if (!uIComponent.IIlIllIlllllllIIlIIIllIIl() || !uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f2, f3) || !this.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent, f2, f3, new UIComponent[0]) || !uIComponent.lIllIlIIIlIIIIIIIlllIlIll(f2, f3, n3)) continue;
            AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
            break;
        }
    }

    @Override
    public void lIllIlIIIlIIIIIIIlllIlIll() {
        this.lIlIIIIIIlIIIllllIllIIlII();
        for (UIComponent uIComponent : this.llIIlIlIIIllIlIlIlIIlIIll) {
            uIComponent.IlllIIIIIIlllIlIIlllIlIIl();
        }
    }

    @Override
    public void llIlllIIIllllIIlllIllIIIl() {
        this.lllllIllIllIllllIlIllllII();
        for (UIComponent uIComponent : this.llIIlIlIIIllIlIlIlIIlIIll) {
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl();
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        this.IlllIIIIIIlllIlIIlllIlIIl(c, keyType);
        for (UIComponent uIComponent : this.llIIlIlIIIllIlIlIlIIlIIll) {
            if (!uIComponent.IIlIllIlllllllIIlIIIllIIl()) continue;
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(c, keyType);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.IlllIIIIIIlllIlIIlllIlIIl(n);
        for (UIComponent uIComponent : this.llIIlIlIIIllIlIlIlIIlIIll) {
            if (!uIComponent.IIlIllIlllllllIIlIIIllIIl()) continue;
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        }
    }

    public abstract void llIIIlllIIlllIllllIlIllIl();

    public abstract void lllllIllIllIllllIlIllllII();

    public abstract void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2);

    public abstract void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, int var3);

    public abstract void IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, int var3);

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
    }

    public abstract void IlllIIIIIIlllIlIIlllIlIIl(char var1, KeyType var2);

    public abstract void lIlIIIIIIlIIIllllIllIIlII();

    public static void IIlIllIlllllllIIlIIIllIIl() {
        if (System.currentTimeMillis() - llIlllIIIllllIIlllIllIIIl > 50L) {
            MinecraftVersion minecraftVersion = Bridge.IlllIIIIIIlllIlIIlllIlIIl();
            if (minecraftVersion == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl || minecraftVersion == MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl) {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSoundHandler().bridge$playSound(IlllIIIIIIlllIlIIlllIlIIl);
            } else {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSoundHandler().bridge$playSound(lIllIlIIIlIIIIIIIlllIlIll);
            }
            llIlllIIIllllIIlllIllIIIl = System.currentTimeMillis();
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent, float f, float f2, UIComponent ... uIComponentArray) {
        UIComponent uIComponent2;
        List<UIComponent> list = Arrays.asList(uIComponentArray);
        boolean bl = true;
        for (int i = this.llIIlIlIIIllIlIlIlIIlIIll.size() - 1; i >= 0 && (uIComponent2 = (UIComponent)this.llIIlIlIIIllIlIlIlIIlIIll.get(i)) != uIComponent; --i) {
            if (list.contains(uIComponent2) || !uIComponent2.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) continue;
            bl = false;
            break;
        }
        return bl;
    }

    public static float lIIlIlllIlIlIIIlllIIlIIII() {
        float f;
        if (Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SomeScaleFactorShit.lIllIlIIIlIIIIIIIlllIlIll || Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SomeScaleFactorShit.IlllIIIIIIlllIlIIlllIlIIl && (Ref.llIIIlllIIlllIllllIlIllIl() == null || Ref.llIIIlllIIlllIllllIlIllIl() == MovementUI.class)) {
            return 1.0f;
        }
        switch (lIlIlIlIlIIlIIlIIllIIIIIl.llllIIlIIlIIlIIllIIlIIllI()) {
            case 1: {
                f = 0.5f;
                break;
            }
            case 2: {
                f = 1.0f;
                break;
            }
            case 3: {
                f = 1.5f;
                break;
            }
            case 4: {
                f = 2.0f;
                break;
            }
            default: {
                f = 1.0f;
            }
        }
        return 1.0f / f;
    }

    public static float llIllIlIllIlllIllIIIIllII() {
        float f;
        switch (lIlIlIlIlIIlIIlIIllIIIIIl.llllIIlIIlIIlIIllIIlIIllI()) {
            case 1: {
                f = 0.5f;
                break;
            }
            case 2: {
                f = 1.0f;
                break;
            }
            case 3: {
                f = 1.5f;
                break;
            }
            case 4: {
                f = 2.0f;
                break;
            }
            default: {
                f = 1.0f;
            }
        }
        return 1.0f / f;
    }

    public float IllllllllllIlIIIlllIlllll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlIlIlllllIlIIlIlIlllIlIl, this.lIIIllIllIIllIlllIlIIlllI);
    }

    public float lllllIllIlIIlIIlIIIlllIlI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIIIIIIllIIllIlIllIIIIl, this.IlllllIlIIIlIIlIIllIIlIll);
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(int n, float f) {
        boolean bl = false;
        GuiScreenBridge guiScreenBridge = Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen();
        if (guiScreenBridge != null) {
            if (guiScreenBridge instanceof WrappedGuiScreenBridge && ((WrappedGuiScreenBridge)guiScreenBridge).getCustomScreen() instanceof MovementUI) {
                bl = true;
            }
        } else {
            bl = true;
        }
        return Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SomeScaleFactorShit.lIllIlIIIlIIIIIIIlllIlIll || Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().IllIllIIIllIIIlIlIlIIIIll().llIlllIIIllllIIlllIllIIIl() == GeneralOptions.SomeScaleFactorShit.IlllIIIIIIlllIlIIlllIlIIl && bl ? (float)n : f;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, int n) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(n);
        float f4 = (f -= f3 / 2.0f) + f3;
        float f5 = f2 + f3 / 1.5f;
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawTriangle(f + f3 / 2.0f, f4, f, f5, f2, f2, f3, n);
        AbstractUIScreen.IllIIIlllIIIlIlllIlIIlIII();
    }

    public static void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, float f3, int n) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(n);
        float f4 = (f -= f3 / 2.0f) + f3;
        float f5 = f2 + f3;
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawTriangle(f4, f4, f, f5, f2, f2 + (f5 - f2) / 2.0f, f3, n);
        AbstractUIScreen.IllIIIlllIIIlIlllIlIIlIII();
    }

    public static void lIllIlIIIlIIIIIIIlllIlIll(float f, float f2, float f3, int n) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(n);
        float f4 = (f -= f3 / 2.0f) + f3;
        float f5 = f2 + f3;
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawTriangle(f, f, f4, f2, f5, f2 + (f5 - f2) / 2.0f, f3, n);
        AbstractUIScreen.IllIIIlllIIIlIlllIlIIlIII();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getTextureManager().bridge$bindTexture(resourceLocationBridge);
        TessellatorBridge tessellatorBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initTessellator();
        tessellatorBridge.bridge$begin(7, true, false);
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f4, f5).bridge$uv(f2 / f, f3 / f).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f4, f5 + f7).bridge$uv(f2 / f, (f3 + f) / f).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f4 + f6, f5 + f7).bridge$uv((f2 + f) / f, (f3 + f) / f).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f4 + f6, f5).bridge$uv((f2 + f) / f, f3 / f).bridge$endVertex();
        tessellatorBridge.bridge$end();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, int n, int n2, float f5, float f6) {
        float f7 = 1.0f / f5;
        float f8 = 1.0f / f6;
        TessellatorBridge tessellatorBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initTessellator();
        tessellatorBridge.bridge$begin(7, true, false);
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + (float)n2, 0.0).bridge$uv(f3 * f7, (f4 + (float)n2) * f8).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f + (float)n, f2 + (float)n2, 0.0).bridge$uv((f3 + (float)n) * f7, (f4 + (float)n2) * f8).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f + (float)n, f2, 0.0).bridge$uv((f3 + (float)n) * f7, f4 * f8).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, 0.0).bridge$uv(f3 * f7, f4 * f8).bridge$endVertex();
        tessellatorBridge.bridge$end();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(int n, int n2, int n3, int n4, int n5, int n6) {
        float f = 0.00390625f;
        float f2 = 0.00390625f;
        TessellatorBridge tessellatorBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initTessellator();
        tessellatorBridge.bridge$begin(7, true, false);
        tessellatorBridge.bridge$pos(n + 0, n2 + n6, 0.0f).bridge$uv((float)(n3 + 0) * f, (float)(n4 + n6) * f2).bridge$endVertex();
        tessellatorBridge.bridge$pos(n + n5, n2 + n6, 0.0f).bridge$uv((float)(n3 + n5) * f, (float)(n4 + n6) * f2).bridge$endVertex();
        tessellatorBridge.bridge$pos(n + n5, n2 + 0, 0.0f).bridge$uv((float)(n3 + n5) * f, (float)(n4 + 0) * f2).bridge$endVertex();
        tessellatorBridge.bridge$pos(n + 0, n2 + 0, 0.0f).bridge$uv((float)(n3 + 0) * f, (float)(n4 + 0) * f2).bridge$endVertex();
        tessellatorBridge.bridge$end();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n, int n2, int n3, int n4) {
        float f3 = 0.00390625f;
        float f4 = 0.00390625f;
        TessellatorBridge tessellatorBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initTessellator();
        tessellatorBridge.bridge$begin(7, true, false);
        tessellatorBridge.bridge$pos(f + 0.0f, f2 + (float)n4, 0.0f).bridge$uv((float)(n + 0) * f3, (float)(n2 + n4) * f4).bridge$endVertex();
        tessellatorBridge.bridge$pos(f + (float)n3, f2 + (float)n4, 0.0f).bridge$uv((float)(n + n3) * f3, (float)(n2 + n4) * f4).bridge$endVertex();
        tessellatorBridge.bridge$pos(f + (float)n3, f2 + 0.0f, 0.0f).bridge$uv((float)(n + n3) * f3, (float)(n2 + 0) * f4).bridge$endVertex();
        tessellatorBridge.bridge$pos(f + 0.0f, f2 + 0.0f, 0.0f).bridge$uv((float)(n + 0) * f3, (float)(n2 + 0) * f4).bridge$endVertex();
        tessellatorBridge.bridge$end();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, int n) {
        int n2 = 1076176165;
        int n3 = 0x20FFFFFF;
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4, f5, n2, n3, n);
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge, float f, float f2, float f3, float f4) {
        float f5 = 0.0f;
        float f6 = 0.0f;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getTextureManager().bridge$bindTexture(resourceLocationBridge);
        TessellatorBridge tessellatorBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initTessellator();
        tessellatorBridge.bridge$begin(7, true, false);
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2).bridge$uv(f5 / f3, f6 / f4).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + f4).bridge$uv(f5 / f3, (f6 + f4) / f4).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3, f2 + f4).bridge$uv((f5 + f3) / f3, (f6 + f4) / f4).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3, f2).bridge$uv((f5 + f3) / f3, f6 / f4).bridge$endVertex();
        tessellatorBridge.bridge$end();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(MatrixStackBridge matrixStackBridge, ResourceLocationBridge resourceLocationBridge, float f, float f2, float f3, float f4) {
        float f5 = 0.0f;
        float f6 = 0.0f;
        matrixStackBridge.lIllIlIIIlIIIIIIIlllIlIll();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(matrixStackBridge.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getTextureManager().bridge$bindTexture(resourceLocationBridge);
        TessellatorBridge tessellatorBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initTessellator();
        tessellatorBridge.bridge$begin(7, true, false);
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2).bridge$uv(f5 / f3, f6 / f4).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + f4).bridge$uv(f5 / f3, (f6 + f4) / f4).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3, f2 + f4).bridge$uv((f5 + f3) / f3, (f6 + f4) / f4).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3, f2).bridge$uv((f5 + f3) / f3, f6 / f4).bridge$endVertex();
        tessellatorBridge.bridge$end();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        matrixStackBridge.IlllIIIIIIlllIlIIlllIlIIl();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(float var0, float var1, float var2, float var3, float var4, int var5, boolean var6, boolean var7, boolean var8, boolean var9) {
        double var10 = (double)(var4 - 1.0F);
        byte var12 = 4;
        byte var13 = 0;
        if (var9) {
            lIlIlIlIlIIlIIlIIllIIIIIl((double)(var0 + var2 - var4 + 1.0F), (double)(var1 + var3 - var4 + 1.0F), (double)var4, var10, 0.0D, var12, (double)var13, var5);
        } else {
            llIlllIIIllllIIlllIllIIIl(var0 + var2 - var4 + 1.0F, var0 + var2, var1 + var3, var5);
            llllIIlIIlIIlIIllIIlIIllI(var0 + var2, var1 + var3 - var4, var1 + var3, var5);
        }

        if (var8) {
            lIlIlIlIlIIlIIlIIllIIIIIl((double)(var0 + var4 - 1.0F), (double)(var1 + var3 - var4 + 1.0F), (double)var4, var10, 1.0D, var12, (double)var13, var5);
        } else {
            llllIIlIIlIIlIIllIIlIIllI(var0 - 1.0F, var1 + var3 - var4, var1 + var3, var5);
            llIlllIIIllllIIlllIllIIIl(var0 - 1.0F, var0 + var4 - 2.0F, var1 + var3, var5);
        }

        if (var6) {
            lIlIlIlIlIIlIIlIIllIIIIIl((double)(var0 + var4 - 1.0F), (double)(var1 + var4 - 1.0F), (double)var4, var10, 2.0D, var12, (double)var13, var5);
        } else {
            llIlllIIIllllIIlllIllIIIl(var0 - 1.0F, var0 + var4 - 2.0F, var1 - 1.0F, var5);
            llllIIlIIlIIlIIllIIlIIllI(var0 - 1.0F, var1 - 1.0F, var1 + var4 - 1.0F, var5);
        }

        if (var7) {
            lIlIlIlIlIIlIIlIIllIIIIIl((double)(var0 + var2 - var4 + 1.0F), (double)(var1 + var4 - 1.0F), (double)var4, var10, 3.0D, var12, (double)var13, var5);
        } else {
            llIlllIIIllllIIlllIllIIIl(var0 + var2 - var4 + 1.0F, var0 + var2 - 1.0F, var1 - 1.0F, var5);
            llllIIlIIlIIlIIllIIlIIllI(var0 + var2, var1 - 2.0F, var1 + var4 - 1.0F, var5);
        }

        llIlllIIIllllIIlllIllIIIl(var0 + var4 - 1.0F, var0 + var2 - var4, var1 + var3, var5);
        llIlllIIIllllIIlllIllIIIl(var0 + var4 - 1.0F, var0 + var2 - var4, var1 - 1.0F, var5);
        llllIIlIIlIIlIIllIIlIIllI(var0 - 1.0F, var1 + var4 - 2.0F, var1 + var3 - var4 + 1.0F, var5);
        llllIIlIIlIIlIIllIIlIIllI(var0 + var2, var1 + var4 - 2.0F, var1 + var3 - var4 + 1.0F, var5);
    }

    public static void IlllIIIIIIlllIlIIlllIlIIl(float var0, float var1, float var2, float var3, float var4, int var5) {
        ++var4;
        double var6 = (double)(var4 - 1.0F);
        byte var8 = 4;
        byte var9 = 0;
        lIlIlIlIlIIlIIlIIllIIIIIl((double)(var0 + var2 - var4 + 1.0F), (double)(var1 + var3 - var4 + 1.0F), (double)var4, var6, 0.0D, var8, (double)var9, var5);
        lIlIlIlIlIIlIIlIIllIIIIIl((double)(var0 + var4 - 1.0F), (double)(var1 + var3 - var4 + 1.0F), (double)var4, var6, 1.0D, var8, (double)var9, var5);
        lIlIlIlIlIIlIIlIIllIIIIIl((double)(var0 + var4 - 1.0F), (double)(var1 + var4 - 1.0F), (double)var4, var6, 2.0D, var8, (double)var9, var5);
        lIlIlIlIlIIlIIlIIllIIIIIl((double)(var0 + var2 - var4 + 1.0F), (double)(var1 + var4 - 1.0F), (double)var4, var6, 3.0D, var8, (double)var9, var5);

        int var10;
        float var11;
        for(var10 = 0; var10 < (int)((var2 - var4) / 10.0F) - 1; ++var10) {
            var11 = var0 + var4 - 1.0F + (float)(var10 * 10);
            llIlllIIIllllIIlllIllIIIl(var11 + 5.0F, var11 + 10.0F, var1 + var3, var5);
            llIlllIIIllllIIlllIllIIIl(var11 + 5.0F, var11 + 10.0F, var1 - 1.0F, var5);
        }

        for(var10 = 0; var10 < (int)((var3 - var4) / 10.0F); ++var10) {
            var11 = var1 + var4 - 1.0F + (float)(var10 * 10);
            llllIIlIIlIIlIIllIIlIIllI(var0 - 1.0F, var11 + 5.0F, var11 + 10.0F, var5);
            llllIIlIIlIIlIIllIIlIIllI(var0 + var2, var11 + 5.0F, var11 + 10.0F, var5);
        }

    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(float var0, float var1, float var2, float var3, float var4, int var5, int var6, int var7) {
        ++var4;
        IlllllIlIIIlIIlIIllIIlIll(var0, var1, var2, var3, var4, var7);
        lIllIlIIIlIIIIIIIlllIlIll(var0, var1, var2, var3, var4 - 1.0F, var5);
        lIllIlIIIlIIIIIIIlllIlIll(var0 + 1.0F, var1 + 1.0F, var2 - 2.0F, var3 - 2.0F, var4 - 2.25F, var6);
    }

    public static void lIllIlIIIlIIIIIIIlllIlIll(float var0, float var1, float var2, float var3, float var4, int var5) {
        lIlIlIlIlIIlIIlIIllIIIIIl(var0, var1, var2, var3, 1.0F, var4, var5);
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(float var0, float var1, float var2, float var3, float var4, float var5, int var6) {
        double var7 = (double)(var5 - var4);
        byte var9 = 4;
        byte var10 = 0;
        lIlIlIlIlIIlIIlIIllIIIIIl((double)(var0 + var2 - var5 + 1.0F), (double)(var1 + var3 - var5 + 1.0F), (double)var5, var7, 0.0D, var9, (double)var10, var6);
        lIlIlIlIlIIlIIlIIllIIIIIl((double)(var0 + var5 - 1.0F), (double)(var1 + var3 - var5 + 1.0F), (double)var5, var7, 1.0D, var9, (double)var10, var6);
        lIlIlIlIlIIlIIlIIllIIIIIl((double)(var0 + var5 - 1.0F), (double)(var1 + var5 - 1.0F), (double)var5, var7, 2.0D, var9, (double)var10, var6);
        lIlIlIlIlIIlIIlIIllIIIIIl((double)(var0 + var2 - var5 + 1.0F), (double)(var1 + var5 - 1.0F), (double)var5, var7, 3.0D, var9, (double)var10, var6);
        llIlllIIIllllIIlllIllIIIl(var0 + var5 - 1.0F, var0 + var2 - var5, var1 + var3, var6);
        llIlllIIIllllIIlllIllIIIl(var0 + var5 - 1.0F, var0 + var2 - var5, var1 - 1.0F, var6);
        llllIIlIIlIIlIIllIIlIIllI(var0 - 1.0F, var1 + var5 - 2.0F, var1 + var3 - var5 + 1.0F, var6);
        llllIIlIIlIIlIIllIIlIIllI(var0 + var2, var1 + var5 - 2.0F, var1 + var3 - var5 + 1.0F, var6);
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2, double d3, double d4, double d5, int n, double d6, int n2) {
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$circleHollow(d, d2, d3, d4, d5, n, d6, n2);
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2, double d3, double d4, double d5, int n, double d6) {
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawCircleHollow(d, d2, d3, d4, d5, n, d6);
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2, double d3, double d4, double d5, double d6) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        GL11.glEnable((int)2848);
        for (double d7 = d5; d7 < d6; d7 += 0.5) {
            double d8 = d7 * Math.PI / 180.0;
            double d9 = (d7 - 1.0) * Math.PI / 180.0;
            double[] dArray = new double[]{Math.cos(d8) * d3, -Math.sin(d8) * d3, Math.cos(d9) * d3, -Math.sin(d9) * d3};
            double[] dArray2 = new double[]{Math.cos(d8) * d4, -Math.sin(d8) * d4, Math.cos(d9) * d4, -Math.sin(d9) * d4};
            Bridge.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(d + dArray2[0], d + dArray2[2], d + dArray[2], d + dArray[0], d2 + dArray2[1], d2 + dArray2[3], d2 + dArray[3], d2 + dArray[1]);
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        GL11.glDisable((int)2848);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
    }

    public static void llIlllIIIllllIIlllIllIIIl(float f, float f2, float f3, int n) {
        if (f2 < f) {
            float f4 = f;
            f = f2;
            f2 = f4;
        }
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRectGui(f, f3, f2 + 1.0f, f3 + 1.0f, n);
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2, double d3, int n) {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(n);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$blendFunc(770, 771);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawCircle(d, d2, d3, n);
        AbstractUIScreen.IllIIIlllIIIlIlllIlIIlIII();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, int n) {
        float f5 = 4.0f;
        float f6 = f5 / 4.0f;
        int n2 = 0x20FFFFFF;
        AbstractUIScreen.llllIIlIIlIIlIIllIIlIIllI(f, f2, f2 + f4 - f6, n2);
        AbstractUIScreen.llllIIlIIlIIlIIllIIlIIllI(f + f3 - f6, f2, f2 + f4 - f6, n2);
        AbstractUIScreen.llIlllIIIllllIIlllIllIIIl(f, f + f3 - f6, f2, n2);
        AbstractUIScreen.llIlllIIIllllIIlllIllIIIl(f, f + f3 - f6, f2 + f4 - f6, n2);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(f, f2, f3, f4, f5, n);
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(List<String> list, int n, int n2) {
        int n3 = 0;
        for (String string : list) {
            float f = Ref.IlllllIlIIIlIIlIIllIIlIll().bridge$getStringWidth(string);
            if (!(f > (float)n3)) continue;
            n3 = (int)f;
        }
        int n4 = n + 12;
        int n5 = n2 - 12;
        int n6 = 8;
        int n7 = -267386864;
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawGradientRect(n4 - 3, n5 - 4, n4 + n3 + 3, n5 - 3, n7, n7, 200.0f);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawGradientRect(n4 - 3, n5 + n6 + 3, n4 + n3 + 3, n5 + n6 + 4, n7, n7, 200.0f);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawGradientRect(n4 - 3, n5 - 3, n4 + n3 + 3, n5 + n6 + 3, n7, n7, 200.0f);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawGradientRect(n4 - 4, n5 - 3, n4 - 3, n5 + n6 + 3, n7, n7, 200.0f);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawGradientRect(n4 + n3 + 3, n5 - 3, n4 + n3 + 4, n5 + n6 + 3, n7, n7, 200.0f);
        int n8 = 0x505000FF;
        int n9 = (n8 & 0xFEFEFE) >> 1 | n8 & 0xFF000000;
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawGradientRect(n4 - 3, n5 - 3 + 1, n4 - 3 + 1, n5 + n6 + 3 - 1, n8, n9, 200.0f);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawGradientRect(n4 + n3 + 2, n5 - 3 + 1, n4 + n3 + 3, n5 + n6 + 3 - 1, n8, n9, 200.0f);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawGradientRect(n4 - 3, n5 - 3, n4 + n3 + 3, n5 - 3 + 1, n8, n8, 200.0f);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawGradientRect(n4 - 3, n5 + n6 + 2, n4 + n3 + 3, n5 + n6 + 3, n9, n9, 200.0f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0f, 0.0f, 201.0f);
        for (int i = 0; i < list.size(); ++i) {
            String string = (String)list.get(i);
            Ref.IlllllIlIIIlIIlIIllIIlIll().bridge$drawString(string, n4, n5, -1, true);
            if (i == 0) {
                n5 += 2;
            }
            n5 += 10;
        }
    }

    public static void llllIIlIIlIIlIIllIIlIIllI(float f, float f2, float f3, int n) {
        if (f3 < f2) {
            float f4 = f2;
            f2 = f3;
            f3 = f4;
        }
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRectGui(f, f2 + 1.0f, f + 1.0f, f3, n);
    }

    public static void lIllIlIIIlIIIIIIIlllIlIll(int n) {
        float f = (float)(n >> 24 & 0xFF) / 255.0f;
        float f2 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f3 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f4 = (float)(n & 0xFF) / 255.0f;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableAlpha();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$tryBlendFuncSeparate(770, 771, 1, 0);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$shadeModel(7425);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(f2, f3, f4, f);
    }

    public static void IllIIIlllIIIlIlllIlIIlIII() {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$shadeModel(7424);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableAlpha();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
    }

    public static void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, float f3, float f4, int n) {
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRectGui(f, f2, f3, f4, n);
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(float[] fArray, float f, int n) {
        if (fArray.length < 2 || fArray.length % 2 != 0) {
            LunarLogger.lIllIlIIIlIIIIIIIlllIlIll((Object)"Attempting to call drawLines with less than 2 points.", new Object[0]);
            return;
        }
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(n);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$glLineWidth(f);
        TessellatorBridge tessellatorBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initTessellator();
        tessellatorBridge.bridge$begin(1, false, false);
        for (int i = 0; i < fArray.length; i += 2) {
            tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(fArray[i], fArray[i + 1]).bridge$endVertex();
        }
        tessellatorBridge.bridge$end();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$glLineWidth(1.0f);
        AbstractUIScreen.IllIIIlllIIIlIlllIlIIlIII();
    }

    public static void lIllIlIIIlIIIIIIIlllIlIll(float f, float f2, float f3, float f4, int n) {
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRect(f, f2, f3, f4, n);
    }

    public static void llIlllIIIllllIIlllIllIIIl(float f, float f2, float f3, float f4, int n) {
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRect(f, f2, f + f3, f2 + f4, n);
        AbstractUIScreen.IllIIIlllIIIlIlllIlIIlIII();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(float var0, float var1, float var2, float var3, float var4, int var5, int var6) {
        lIllIlIIIlIIIIIIIlllIlIll(var0, var1, var2, var3, var6);
        lIllIlIIIlIIIIIIIlllIlIll(var0 - var4, var1 - var4, var2 + var4 * 2.0F, var4, var5);
        lIllIlIIIlIIIIIIIlllIlIll(var0 - var4, var1 + var3, var2 + var4 * 2.0F, var4, var5);
        lIllIlIIIlIIIIIIIlllIlIll(var0 - var4, var1, var4, var3, var5);
        lIllIlIIIlIIIIIIIlllIlIll(var0 + var2, var1, var4, var3, var5);
    }

    public static void llIlllIIIllllIIlllIllIIIl(float var0, float var1, float var2, float var3, float var4, int var5) {
        double var6 = (double)(var4 - 1.0F);
        byte var8 = 4;
        byte var9 = 0;
        lIlIlIlIlIIlIIlIIllIIIIIl((double)(var0 + var2 - var4 + 1.0F), (double)(var1 + var4 - 1.0F), (double)var4, var6, 3.0D, var8, (double)var9, var5);
        llIlllIIIllllIIlllIllIIIl(var0, var0 + var2, var1 + var3, var5);
        llIlllIIIllllIIlllIllIIIl(var0, var0 + var2 - var4, var1 - 1.0F, var5);
        llllIIlIIlIIlIIllIIlIIllI(var0 + var2, var1 + var4 - 2.0F, var1 + var3, var5);
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge, float f, float f2, float f3) {
        float f4 = f * 2.0f;
        float f5 = f * 2.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getTextureManager().bridge$bindTexture(resourceLocationBridge);
        TessellatorBridge tessellatorBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initTessellator();
        tessellatorBridge.bridge$begin(7, true, false);
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f2, f3).bridge$uv(f6 / f, f7 / f).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f2, f3 + f5).bridge$uv(f6 / f, (f7 + f) / f).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f2 + f4, f3 + f5).bridge$uv((f6 + f) / f, (f7 + f) / f).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f2 + f4, f3).bridge$uv((f6 + f) / f, f7 / f).bridge$endVertex();
        tessellatorBridge.bridge$end();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
    }

    public static void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, float f3, float f4, float f5, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        int n2;
        double d = f + f3;
        double d2 = f2 + f4;
        float f6 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n & 0xFF) / 255.0f;
        GL11.glPushAttrib((int)0);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(0.5, 0.5, 0.5);
        f *= 2.0f;
        f2 *= 2.0f;
        d *= 2.0;
        d2 *= 2.0;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(f7, f8, f9, f6);
        GL11.glEnable((int)2848);
        GL11.glBegin((int)9);
        if (bl) {
            for (n2 = 0; n2 <= 90; n2 += 3) {
                GL11.glVertex2d((double)((double)(f + f5) + Math.sin((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)), (double)((double)(f2 + f5) + Math.cos((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)));
            }
        } else {
            GL11.glVertex2d((double)f, (double)f2);
        }
        if (bl3) {
            for (n2 = 90; n2 <= 180; n2 += 3) {
                GL11.glVertex2d((double)((double)(f + f5) + Math.sin((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)), (double)(d2 - (double)f5 + Math.cos((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)));
            }
        } else {
            GL11.glVertex2d((double)f, (double)d2);
        }
        if (bl4) {
            for (n2 = 0; n2 <= 90; n2 += 3) {
                GL11.glVertex2d((double)(d - (double)f5 + Math.sin((double)n2 * Math.PI / 180.0) * (double)f5), (double)(d2 - (double)f5 + Math.cos((double)n2 * Math.PI / 180.0) * (double)f5));
            }
        } else {
            GL11.glVertex2d((double)d, (double)d2);
        }
        if (bl2) {
            for (n2 = 90; n2 <= 180; n2 += 3) {
                GL11.glVertex2d((double)(d - (double)f5 + Math.sin((double)n2 * Math.PI / 180.0) * (double)f5), (double)((double)(f2 + f5) + Math.cos((double)n2 * Math.PI / 180.0) * (double)f5));
            }
        } else {
            GL11.glVertex2d((double)d, (double)f2);
        }
        GL11.glEnd();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        GL11.glDisable((int)2848);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        GL11.glScaled((double)2.0, (double)2.0, (double)2.0);
        GL11.glPopAttrib();
    }

    public static void llllIIlIIlIIlIIllIIlIIllI(float f, float f2, float f3, float f4, float f5, int n) {
        double d = f + f3;
        double d2 = f2 + f4;
        float f6 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n & 0xFF) / 255.0f;
        GL11.glPushAttrib((int)0);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(0.5, 0.5, 0.5);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(f7, f8, f9, f6);
        GL11.glEnable((int)2848);
        GL11.glBegin((int)9);
        GL11.glVertex2d((double)(f *= 2.0f), (double)(f2 *= 2.0f));
        GL11.glVertex2d((double)f, (double)(d2 *= 2.0));
        GL11.glVertex2d((double)(d *= 2.0), (double)d2);
        for (int i = 90; i <= 180; i += 3) {
            GL11.glVertex2d((double)(d - (double)f5 + Math.sin((double)i * Math.PI / 180.0) * (double)f5), (double)((double)(f2 + f5) + Math.cos((double)i * Math.PI / 180.0) * (double)f5));
        }
        GL11.glEnd();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        GL11.glDisable((int)2848);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(2.0, 2.0, 2.0);
        GL11.glPopAttrib();
    }

    public static void IlIlIlllllIlIIlIlIlllIlIl(float f, float f2, float f3, float f4, float f5, int n) {
        int n2;
        double d = f + f3;
        double d2 = f2 + f4;
        float f6 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n & 0xFF) / 255.0f;
        GL11.glPushAttrib((int)0);
        GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
        f *= 2.0f;
        f2 *= 2.0f;
        d *= 2.0;
        d2 *= 2.0;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(f7, f8, f9, f6);
        GL11.glEnable((int)2848);
        GL11.glBegin((int)9);
        for (n2 = 0; n2 <= 90; n2 += 3) {
            GL11.glVertex2d((double)((double)(f + f5) + Math.sin((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)), (double)((double)(f2 + f5) + Math.cos((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)));
        }
        for (n2 = 90; n2 <= 180; n2 += 3) {
            GL11.glVertex2d((double)((double)(f + f5) + Math.sin((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)), (double)(d2 - (double)f5 + Math.cos((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)));
        }
        GL11.glVertex2d((double)d, (double)d2);
        GL11.glVertex2d((double)d, (double)f2);
        GL11.glEnd();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        GL11.glDisable((int)2848);
        GL11.glScaled((double)2.0, (double)2.0, (double)2.0);
        GL11.glPopAttrib();
    }

    public static void llIIIIIIIllIIllIlIllIIIIl(float f, float f2, float f3, float f4, float f5, int n) {
        double d = f + f3;
        double d2 = f2 + f4;
        float f6 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n & 0xFF) / 255.0f;
        GL11.glPushAttrib((int)0);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(0.5, 0.5, 0.5);
        d *= 2.0;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(f7, f8, f9, f6);
        GL11.glEnable((int)2848);
        GL11.glBegin((int)9);
        GL11.glVertex2d((double)(f *= 2.0f), (double)(f2 *= 2.0f));
        GL11.glVertex2d((double)f, (double)(d2 *= 2.0));
        for (int i = 0; i <= 90; i += 3) {
            GL11.glVertex2d((double)(d - (double)f5 + Math.sin((double)i * Math.PI / 180.0) * (double)f5), (double)(d2 - (double)f5 + Math.cos((double)i * Math.PI / 180.0) * (double)f5));
        }
        GL11.glVertex2d((double)d, (double)f2);
        GL11.glEnd();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        GL11.glDisable((int)2848);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(2.0, 2.0, 2.0);
        GL11.glPopAttrib();
    }

    public static void lIIIllIllIIllIlllIlIIlllI(float f, float f2, float f3, float f4, float f5, int n) {
        int n2;
        double d = f + f3;
        double d2 = f2 + f4;
        float f6 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n & 0xFF) / 255.0f;
        GL11.glPushAttrib((int)0);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(0.5, 0.5, 0.5);
        f *= 2.0f;
        f2 *= 2.0f;
        d *= 2.0;
        d2 *= 2.0;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(f7, f8, f9, f6);
        GL11.glEnable((int)2848);
        GL11.glBegin((int)9);
        for (n2 = 0; n2 <= 90; n2 += 3) {
            GL11.glVertex2d((double)((double)(f + f5) + Math.sin((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)), (double)((double)(f2 + f5) + Math.cos((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)));
        }
        GL11.glVertex2d((double)f, (double)d2);
        GL11.glVertex2d((double)d, (double)d2);
        for (n2 = 90; n2 <= 180; n2 += 3) {
            GL11.glVertex2d((double)(d - (double)f5 + Math.sin((double)n2 * Math.PI / 180.0) * (double)f5), (double)((double)(f2 + f5) + Math.cos((double)n2 * Math.PI / 180.0) * (double)f5));
        }
        GL11.glEnd();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        GL11.glDisable((int)2848);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(2.0, 2.0, 2.0);
        GL11.glPopAttrib();
    }

    public static boolean IlllIIIIIIlllIlIIlllIlIIl(int n, int n2, int n3, int n4, int n5, int n6) {
        return n >= n3 && n <= n5 && n2 >= n4 && n2 <= n6;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(int n, int n2, int n3, int n4, float f, int n5) {
        int n6 = n4 - n2;
        int n7 = n3 - n;
        int n8 = n5 - n4;
        GL11.glScissor((int)((int)((float)n * f)), (int)((int)((float)n8 * f)), (int)((int)((float)n7 * f)), (int)((int)((float)n6 * f)));
    }

    public static void IlllllIlIIIlIIlIIllIIlIll(float f, float f2, float f3, float f4, float f5, int n) {
        int n2;
        double d = f + f3;
        double d2 = f2 + f4;
        float f6 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n & 0xFF) / 255.0f;
        GL11.glPushAttrib((int)0);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(0.5, 0.5, 0.5);
        f *= 2.0f;
        f2 *= 2.0f;
        d *= 2.0;
        d2 *= 2.0;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(f7, f8, f9, f6);
        GL11.glEnable((int)2848);
        GL11.glBegin((int)9);
        for (n2 = 0; n2 <= 90; n2 += 3) {
            GL11.glVertex2d((double)((double)(f + f5) + Math.sin((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)), (double)((double)(f2 + f5) + Math.cos((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)));
        }
        for (n2 = 90; n2 <= 180; n2 += 3) {
            GL11.glVertex2d((double)((double)(f + f5) + Math.sin((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)), (double)(d2 - (double)f5 + Math.cos((double)n2 * Math.PI / 180.0) * (double)(f5 * -1.0f)));
        }
        for (n2 = 0; n2 <= 90; n2 += 3) {
            GL11.glVertex2d((double)(d - (double)f5 + Math.sin((double)n2 * Math.PI / 180.0) * (double)f5), (double)(d2 - (double)f5 + Math.cos((double)n2 * Math.PI / 180.0) * (double)f5));
        }
        for (n2 = 90; n2 <= 180; n2 += 3) {
            GL11.glVertex2d((double)(d - (double)f5 + Math.sin((double)n2 * Math.PI / 180.0) * (double)f5), (double)((double)(f2 + f5) + Math.cos((double)n2 * Math.PI / 180.0) * (double)f5));
        }
        GL11.glEnd();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        GL11.glDisable((int)2848);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(2.0, 2.0, 2.0);
        GL11.glPopAttrib();
    }

    public static void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2) {
        FontRegistry.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl("Version " + Bridge.IlllIIIIIIlllIlIIlllIlIIl().IlIlIlllllIlIIlIlIlllIlIl() + " (" + LunarClient.IlIlllIlIlllIllIIIIIIlllI() + "/" + LunarClient.llIIIllllIIIllIIIIlIlIlll() + ")", 10.0f, f2 - 16.0f, -1597125171);
        llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f - 16.0f - 2.0f, f2 - 24.0f, 16.0f, 16.0f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().IlllIIIIIIlllIlIIlllIlIIl(f + f2), Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().lIllIlIIIlIIIIIIIlllIlIll(f + f2), Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().llIlllIIIllllIIlllIllIIIl(f + f2), 1.0f);
        Color color = new Color(Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().IlllIIIIIIlllIlIIlllIlIIl(f + f2), Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().lIllIlIIIlIIIIIIIlllIlIll(f + f2), Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().llIlllIIIllllIIlllIllIIIl(f + f2), 1.0f);
        String string = "LUNAR";
        int n = FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.IlllIIIIIIlllIlIIlllIlIIl(string);
        FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(string, f - (float)(n * 2) - 8.0f, f2 - 20.0f, new Color(0, 0, 0, 1).getRGB());
        FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(string, f - (float)(n * 2) - 8.0f, f2 - 20.0f, color.getRGB());
        FontRegistry.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl("CLIENT", f - (float)n - 4.0f + 1.0f, f2 - 20.0f + 1.0f, new Color(0, 0, 0, 1).getRGB());
        FontRegistry.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl("CLIENT", f - (float)n - 4.0f, f2 - 20.0f, color.getRGB());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(-85.0f, 2.0f, 0.0f);
        llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(0.0f, 0.0f, false);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
    }

    public static boolean IIlIllIlIIllIIlIlIllllllI() {
        return System.getProperty("os.name").toLowerCase().contains("mac") ? Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IIllIlIllIlIllIllIllIllII) || Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlllIlIlllIllIIIIIIlllI) : Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.llIllIIIIlIIIIIIlllIllIlI) || Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.lIlIIIIIllIIlIIlIIlIlIIlI);
    }

    public static boolean lIIIlllIIIIllllIlIIIlIIll() {
        return Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlIllIIllllIllllllIIlIl) || Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIIIlIlIlIlIlIllIIllIIlI);
    }

    @Override
    public boolean IlIlIlllllIlIIlIlIlllIlIl() {
        return false;
    }

    @Override
    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    @Override
    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public List llIIIlIllIIIIlIIIlIlIllIl() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(List list) {
        this.llIIlIlIIIllIlIlIlIIlIIll = list;
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(ScaledResolutionHelper scaledResolutionHelper) {
        lIlIlIlIlIIlIIlIIllIIIIIl = scaledResolutionHelper;
    }

    public static ScaledResolutionHelper llllIlIllllIlIlIIIllIlIlI() {
        return lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    static {
        IlllIIIIIIlllIlIIlllIlIIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("gui.button.press");
        lIllIlIIIlIIIIIIIlllIlIll = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("ui.button.click");
        llIlllIIIllllIIlllIllIIIl = System.currentTimeMillis();
        llIIIlllIIlllIllllIlIllIl = new AnimatedLunarLogoUIComponent(null, true, false);
    }
}