package com.moonsworth.lunar.client.ui.screen.type.radial;

import com.google.common.base.Preconditions;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.QuadraticEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.AnimatedLunarLogoUIComponent;
import com.moonsworth.lunar.client.util.ScaledResolutionHelper;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class RadialMenuUIScreen
    extends AbstractUIScreen {
    public static final int lIlIlIlIlIIlIIlIIllIIIIIl = 8;
    public final RadialMenuEntry[] llIIIlllIIlllIllllIlIllIl = new RadialMenuEntry[8];
    public final RadialMenuUIComponent[] lllllIllIllIllllIlIllllII = new RadialMenuUIComponent[8];
    public int IlllIIIIIIlllIlIIlllIlIIl = 0;
    public Consumer<RadialMenuEntry> lIllIlIIIlIIIIIIIlllIlIll;
    public final KeyType lllIIIIIlllIIlIllIIlIIIlI;
    public Runnable llIlllIIIllllIIlllIllIIIl;
    public Long lIlIIIIIIlIIIllllIllIIlII;
    public static final int llIlIIIllIIlIllIllIllllIl = 250;
    public static final ResourceLocationBridge IllIllIIIllIIIlIlIlIIIIll = Bridge.getInstance().initResourceLocation("lunar", "icons/left-click-40.png");
    public static final AnimatedLunarLogoUIComponent IIlIllIlllllllIIlIIIllIIl = new AnimatedLunarLogoUIComponent(null, true, false);
    public static final float lIIlIlllIlIlIIIlllIIlIIII = 20.0f;
    public QuadraticEase llIllIlIllIlllIllIIIIllII = new QuadraticEase(500L);

    public RadialMenuUIScreen(KeyType keyType, List<RadialMenuEntry> list) {
        int n;
        Preconditions.checkNotNull(list, "options");
        Preconditions.checkArgument(list.size() <= 8, "cannot have more than 8 options");
        for (n = 0; n < list.size(); ++n) {
            this.llIIIlllIIlllIllllIlIllIl[n] = list.get(n);
        }
        for (n = 0; n < this.lllllIllIllIllllIlIllllII.length; ++n) {
            RadialMenuEntry radialMenuEntry = null;
            if (n < list.size()) {
                radialMenuEntry = list.get(n);
            }
            this.lllllIllIllIllllIlIllllII[n] = new RadialMenuUIComponent(this, n, radialMenuEntry);
        }
        this.lllIIIIIlllIIlIllIIlIIIlI = keyType;
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        IIlIllIlllllllIIlIIIllIIl.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() / 2.0f - 32.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 165.0f, 64.0f, 58.5f);
        this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll();
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
        ++this.IlllIIIIIIlllIlIIlllIlIIl;
        if (!Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.lllIIIIIlllIIlIllIIlIIIlI)) {
            if (this.lIllIlIIIlIIIIIIIlllIlIll != null) {
                for (int i = 0; i < this.lllllIllIllIllllIlIllllII.length; ++i) {
                    RadialMenuUIComponent radialMenuUIComponent = this.lllllIllIllIllllIlIllllII[i];
                    RadialMenuEntry radialMenuEntry = this.llIIIlllIIlllIllllIlIllIl[i];
                    ScaledResolutionHelper scaledResolutionHelper = AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI();
                    int n = scaledResolutionHelper.lIlIlIlIlIIlIIlIIllIIIIIl();
                    int n2 = scaledResolutionHelper.IlllIIIIIIlllIlIIlllIlIIl();
                    int n3 = Bridge.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl() * n / Ref.getMinecraft().bridge$displayWidth();
                    int n4 = !Bridge.getMinecraftVersion().lIllIlIIIlIIIIIIIlllIlIll() ? n2 - Bridge.llIIIlllIIlllIllllIlIllIl().IlllIIIIIIlllIlIIlllIlIIl() * n2 / Ref.getMinecraft().bridge$displayHeight() - 1 : Bridge.llIIIlllIIlllIllllIlIllIl().IlllIIIIIIlllIlIIlllIlIIl() * n2 / Ref.getMinecraft().bridge$displayHeight() - 1;
                    if (!radialMenuUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl((float)n3 / RadialMenuUIScreen.lIIlIlllIlIlIIIlllIIlIIII(), (float)n4 / RadialMenuUIScreen.lIIlIlllIlIlIIIlllIIlIIII())) continue;
                    this.lIllIlIIIlIIIIIIIlllIlIll.accept(radialMenuEntry);
                    break;
                }
            }
            Ref.getMinecraft().bridge$displayScreen(null);
        } else if (this.llIlllIIIllllIIlllIllIIIl != null && this.lIlIIIIIIlIIIllllIllIIlII != null && TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) - this.lIlIIIIIIlIIIllllIllIIlII > 250L) {
            this.llIlllIIIllllIIlllIllIIIl.run();
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        ScaledResolutionHelper scaledResolutionHelper = AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI();
        int n = scaledResolutionHelper.lIlIlIlIlIIlIIlIIllIIIIIl();
        int n2 = scaledResolutionHelper.IlllIIIIIIlllIlIIlllIlIIl();
        for (RadialMenuUIComponent radialMenuUIComponent : this.lllllIllIllIllllIlIllllII) {
            if (radialMenuUIComponent == null) continue;
            radialMenuUIComponent.drawComponent(f, f2, true);
        }
        float f3 = 10.0f;
        float f4 = (float)this.IlllIIIIIIlllIlIIlllIlIIl >= f3 ? 1.0f : (float)this.IlllIIIIIIlllIlIIlllIlIIl / f3;
        this.lIllIlIIIlIIIIIIIlllIlIll((float)n / 2.0f / RadialMenuUIScreen.lIIlIlllIlIlIIIlllIIlIIII(), (float)n2 / 2.0f / RadialMenuUIScreen.lIIlIlllIlIlIIIlllIIlIIII());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f4);
        if (this.llIlllIIIllllIIlllIllIIIl != null) {
            RadialMenuUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(IllIllIIIllIIIlIlIlIIIIll, this.IllllllllllIlIIIlllIlllll() / 2.0f + -5.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f + -8.0f, 10.0f, 16.0f);
        }
        GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.5f * f4);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((float)n / 2.0f / RadialMenuUIScreen.lIIlIlllIlIlIIIlllIIlIIII(), (float)n2 / 2.0f / RadialMenuUIScreen.lIIlIlllIlIlIIIlllIIlIIII(), 90.0, 88.0, 100.0, 100, 100.0);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((float)n / 2.0f / RadialMenuUIScreen.lIIlIlllIlIlIIIlllIIlIIII(), (float)n2 / 2.0f / RadialMenuUIScreen.lIIlIlllIlIlIIIlllIIlIIII(), 20.0, 18.0, 100.0, 100, 100.0);
        if (this.lIlIIIIIIlIIIllllIllIIlII != null) {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.8f * f4);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((float)n / 2.0f / RadialMenuUIScreen.lIIlIlllIlIlIIIlllIIlIIII(), (float)n2 / 2.0f / RadialMenuUIScreen.lIIlIlllIlIlIIIlllIIlIIII(), 20.0, 18.0, 63.0, 250, Math.min(250L, TimeUnit.NANOSECONDS.toMillis(System.nanoTime()) - this.lIlIIIIIIlIIIllllIllIIlII));
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float f, float f2) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().IlllIIIIIIlllIlIIlllIlIIl(0.0f), Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().lIllIlIIIlIIIIIIIlllIlIll(0.0f), Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().llIlllIIIllllIIlllIllIIIl(0.0f), this.llIllIlIllIlllIllIIIIllII.getProgress());
        if (this.llIllIlIllIlllIllIIIIllII.getProgress() > 0.2f) {
            Color color = new Color(Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().IlllIIIIIIlllIlIIlllIlIIl(0.0f), Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().lIllIlIIIlIIIIIIIlllIlIll(0.0f), Ref.getLC().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().llIlllIIIllllIIlllIllIIIl(0.0f), this.llIllIlIllIlllIllIIIIllII.getProgress());
            String string = "LUNAR";
            int n = FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.IlllIIIIIIlllIlIIlllIlIIl(string);
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(string, f - (float)n - 2.0f + 1.0f, f2 - 120.0f + 1.0f, new Color(0.0f, 0.0f, 0.0f, 0.4f * this.llIllIlIllIlllIllIIIIllII.getProgress()).getRGB());
            FontRegistry.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(string, f - (float)n - 2.0f, f2 - 120.0f, color.getRGB());
            FontRegistry.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl("CLIENT", f + 2.0f + 1.0f, f2 - 120.0f + 1.0f, new Color(0.0f, 0.0f, 0.0f, 0.4f * this.llIllIlIllIlllIllIIIIllII.getProgress()).getRGB());
            FontRegistry.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl("CLIENT", f + 2.0f, f2 - 120.0f, color.getRGB());
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0f, -20.0f * this.llIllIlIllIlllIllIIIIllII.getProgress(), 0.0f);
        IIlIllIlllllllIIlIIIllIIl.drawComponent(0.0f, 0.0f, true);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll != null) {
            for (int i = 0; i < this.lllllIllIllIllllIlIllllII.length; ++i) {
                RadialMenuUIComponent radialMenuUIComponent = this.lllllIllIllIllllIlIllllII[i];
                RadialMenuEntry radialMenuEntry = this.llIIIlllIIlllIllllIlIllIl[i];
                if (!radialMenuUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2)) continue;
                this.lIllIlIIIlIIIIIIIlllIlIll.accept(radialMenuEntry);
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                Ref.getMinecraft().bridge$displayScreen(null);
                return;
            }
            if (this.llIlllIIIllllIIlllIllIIIl != null) {
                this.lIlIIIIIIlIIIllllIllIIlII = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            }
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
        this.lIlIIIIIIlIIIllllIllIIlII = null;
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(char c, KeyType keyType) {
        if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.lllIIIIIlllIIlIllIIlIIIlI)) {
            try {
                int n = Integer.parseInt(Bridge.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(keyType));
                if (n >= 1 && n <= 8) {
                    this.lIllIlIIIlIIIIIIIlllIlIll.accept(this.llIIIlllIIlllIllllIlIllIl[n - 1]);
                    AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                    Ref.getMinecraft().bridge$displayScreen(null);
                }
            } catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
    }

    @Override
    public void lIlIIIIIIlIIIllllIllIIlII() {
    }

    @Override
    public List<UIComponent> llIIlIlIIIllIlIlIlIIlIIll() {
        return Collections.emptyList();
    }
}
