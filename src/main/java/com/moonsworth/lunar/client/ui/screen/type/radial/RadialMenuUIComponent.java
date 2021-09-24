package com.moonsworth.lunar.client.ui.screen.type.radial;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;
import com.moonsworth.lunar.client.util.ScaledResolutionHelper;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class RadialMenuUIComponent
    extends UIComponent {
    public final RadialMenuUIScreen lIlIlIlIlIIlIIlIIllIIIIIl;
    public final float IlllIIIIIIlllIlIIlllIlIIl;
    public final RadialMenuEntry lIllIlIIIlIIIIIIIlllIlIll;
    public Color llIlIIIllIIlIllIllIllllIl = new Color(0.3f, 0.3f, 0.3f, 0.3f);
    public ColorEase IllIllIIIllIIIlIlIlIIIIll;
    public ColorEase IIlIllIlllllllIIlIIIllIIl;

    public RadialMenuUIComponent(RadialMenuUIScreen radialMenuUIScreen, int n, RadialMenuEntry radialMenuEntry) {
        super(null);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = radialMenuUIScreen;
        float f = 45.0f;
        this.IlllIIIIIIlllIlIIlllIlIIl = f / 2.0f + (float)n * f;
        this.lIllIlIIIlIIIIIIIlllIlIll = radialMenuEntry;
        this.IllIllIIIllIIIlIlIlIIIIll = new ColorEase(500L, new Color(0.2f, 0.2f, 0.2f, 0.1f).getRGB(), new Color(0.2f, 0.2f, 0.3f, 0.5f).getRGB());
        this.IIlIllIlllllllIIlIIIllIIl = new ColorEase(500L, new Color(0.0f, 0.0f, 0.0f, 0.9f).getRGB(), -1);
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        boolean bl2 = this.lIllIlIIIlIIIIIIIlllIlIll != null && this.lIlIlIlIlIIlIIlIIllIIIIIl(mouseX, mouseY) && bl;
        int n = this.IllIllIIIllIIIlIlIlIIIIll.lIlIlIlIlIIlIIlIIllIIIIIl(bl2);
        ScaledResolutionHelper scaledResolutionHelper = AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI();
        int n2 = scaledResolutionHelper.lIlIlIlIlIIlIIlIIllIIIIIl();
        int n3 = scaledResolutionHelper.IlllIIIIIIlllIlIIlllIlIIl();
        float f3 = 10.0f;
        float f4 = (float)this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl >= f3 ? 1.0f : (float)this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl / f3;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        if (this.lIllIlIIIlIIIIIIIlllIlIll == null) {
            GL11.glColor4d((float)this.llIlIIIllIIlIllIllIllllIl.getRed() / 255.0f, (float)this.llIlIIIllIIlIllIllIllllIl.getGreen() / 255.0f, (float)this.llIlIIIllIIlIllIllIllllIl.getBlue() / 255.0f, (float)this.llIlIIIllIIlIllIllIllllIl.getAlpha() / 255.0f * f4);
        } else {
            GL11.glColor4d(ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(n), ColorUtil.lIllIlIIIlIIIIIIIlllIlIll(n), ColorUtil.llllIIlIIlIIlIIllIIlIIllI(n), ColorUtil.llIIIIIIIllIIllIlIllIIIIl(n) * f4);
        }
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((float)n2 / 2.0f / AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII(), (float)n3 / 2.0f / AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII(), 88.0, 20.0, 360.0f - this.IlllIIIIIIlllIlIIlllIlIIl + 90.0f, 360.0f - this.IlllIIIIIIlllIlIIlllIlIIl + 90.0f + 45.0f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        if (this.lIllIlIIIlIIIIIIIlllIlIll != null) {
            n = this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl2);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            float f5 = this.IlllIIIIIIlllIlIIlllIlIIl - 90.0f;
            double d = Math.toRadians(f5 -= 22.5f);
            int n4 = 60;
            double d2 = (double)((float)n2 / 2.0f / AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII()) + (double)n4 * Math.cos(d);
            double d3 = (double)((float)n3 / 2.0f / AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII()) + (double)n4 * Math.sin(d);
            GL11.glColor4d(ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(n), ColorUtil.lIllIlIIIlIIIIIIIlllIlIll(n), ColorUtil.llllIIlIIlIIlIIllIIlIIllI(n), ColorUtil.llIIIIIIIllIIllIlIllIIIIl(n) * f4);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.lIllIlIIIlIIIIIIIlllIlIll(), 20.0f, (float)d2 - 20.0f, (float)d3 - 20.0f);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            if (bl2) {
                RadialMenuUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of(this.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl()), (int) mouseX, (int) mouseY);
            }
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        boolean bl;
        ScaledResolutionHelper scaledResolutionHelper = AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI();
        int n = scaledResolutionHelper.lIlIlIlIlIIlIIlIIllIIIIIl();
        int n2 = scaledResolutionHelper.IlllIIIIIIlllIlIIlllIlIIl();
        int n3 = (int)(f - (float)(n / 2) / AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII());
        int n4 = (int)(f2 - (float)(n2 / 2) / AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII());
        double d = Math.sqrt(n3 * n3 + n4 * n4);
        double d2 = Math.toDegrees(Math.atan2(n4, n3)) + 90.0;
        double d3 = this.IlllIIIIIIlllIlIIlllIlIIl - 45.0f;
        if (d3 < 0.0) {
            d3 += 360.0;
        }
        double d4 = this.IlllIIIIIIlllIlIIlllIlIIl;
        boolean bl2 = bl = d2 < 0.0;
        if (d3 > d4) {
            d4 += 360.0;
            bl = true;
        }
        if (bl) {
            d2 += 360.0;
        }
        return d >= 20.0 && d <= 175.0 && d2 >= d3 && d2 <= d4;
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }
}
