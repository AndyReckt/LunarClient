package com.moonsworth.lunar.client.ui.screen;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.LinearEase;
import com.moonsworth.lunar.client.ui.ease.QuadraticEase;
import org.lwjgl.opengl.GL11;

import java.util.concurrent.ThreadLocalRandom;

public class AnimatedLunarLogoUIComponent
extends UIComponent {
    public static final int lIlIlIlIlIIlIIlIIllIIIIIl = 8;
    public static final float IlllIIIIIIlllIlIIlllIlIIl = 0.15f;
    public static final ResourceLocationBridge lIllIlIIIlIIIIIIIlllIlIll = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "animatedlogo/128/logo_128_no_stars.png");
    public static final ResourceLocationBridge[] llIlIIIllIIlIllIllIllllIl = new ResourceLocationBridge[8];
    public final StarEase[] IllIllIIIllIIIlIlIlIIIIll = new StarEase[8];
    public final float[] IIlIllIlllllllIIlIIIllIIl = new float[8];
    public boolean lIIlIlllIlIlIIIlllIIlIIII = true;
    public final boolean llIllIlIllIlllIllIIIIllII;
    public final boolean IllllllllllIlIIIlllIlllll;

    public AnimatedLunarLogoUIComponent(UIComponent uIComponent, boolean bl, boolean bl2) {
        super(uIComponent);
        for (int i = 1; i <= 8; ++i) {
            if (llIlIIIllIIlIllIllIllllIl[i - 1] != null) continue;
            AnimatedLunarLogoUIComponent.llIlIIIllIIlIllIllIllllIl[i - 1] = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "animatedlogo/128/logo_128_star_" + i + ".png");
        }
        this.lIllIlIIIlIIIIIIIlllIlIll();
        this.IllllllllllIlIIIlllIlllll = bl2;
        this.llIllIlIllIlllIllIIIIllII = bl;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        for (int i = 1; i <= 8; ++i) {
            if (this.IllIllIIIllIIIlIlIlIIIIll[i - 1] != null && !this.IllIllIIIllIIIlIlIlIIIIll[i - 1].lIIIllIllIIllIlllIlIIlllI()) {
                this.lIIlIlllIlIlIIIlllIIlIIII = false;
            }
            if (this.IllIllIIIllIIIlIlIlIIIIll[i - 1] != null && this.IllIllIIIllIIIlIlIlIIIIll[i - 1].lIIIllIllIIllIlllIlIIlllI()) continue;
            long l = ThreadLocalRandom.current().nextLong(4000L, 12000L);
            if (this.lIIlIlllIlIlIIIlllIIlIIII) {
                this.IIlIllIlllllllIIlIIIllIIl[i - 1] = Math.max(ThreadLocalRandom.current().nextFloat(), 0.8f);
            }
            this.IllIllIIIllIIIlIlIlIIIIll[i - 1] = new StarEase(l, null);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        GL11.glPushMatrix();
        if (this.llIllIlIllIlllIllIIIIllII) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(0.0f, 0.0f, 0.0f, 0.2f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(lIllIlIIIlIIIIIIIlllIlIll, this.x + 1.0f, this.y + 1.0f, this.width, this.height);
        }
        if (!this.IllllllllllIlIIIlllIlllll) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().IlllIIIIIIlllIlIIlllIlIIl(0.0f), Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().lIllIlIIIlIIIIIIIlllIlIll(0.0f), Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().llIlllIIIllllIIlllIllIIIl(0.0f), 1.0f);
        } else {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
        }
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(lIllIlIIIlIIIIIIIlllIlIll, this.x, this.y, this.width, this.height);
        for (int i = 0; i < 8; ++i) {
            StarEase lIlIlIlIlIIlIIlIIllIIIIIl2 = this.IllIllIIIllIIIlIlIlIIIIll[i];
            if (!lIlIlIlIlIIlIIlIIllIIIIIl2.llllIIlIIlIIlIIllIIlIIllI()) {
                lIlIlIlIlIIlIIlIIllIIIIIl2.lIllIlIIIlIIIIIIIlllIlIll();
            }
            GL11.glPushMatrix();
            if (!lIlIlIlIlIIlIIlIIllIIIIIl2.lIIIllIllIIllIlllIlIIlllI()) {
                this.lIllIlIIIlIIIIIIIlllIlIll();
            }
            float f3 = 1.0f * lIlIlIlIlIIlIIlIIllIIIIIl2.IIlIllIlIIllIIlIlIllllllI();
            if (lIlIlIlIlIIlIIlIIllIIIIIl2.lIlIlIlIlIIlIIlIIllIIIIIl() && this.lIIlIlllIlIlIIIlllIIlIIII) {
                this.lIIlIlllIlIlIIIlllIIlIIII = false;
            }
            if (this.lIIlIlllIlIlIIIlllIIlIIII) {
                f3 = Math.max(f3, this.IIlIllIlllllllIIlIIIllIIl[i]);
            }
            if (this.llIllIlIllIlllIllIIIIllII) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(0.0f, 0.0f, 0.0f, f3 / 5.0f);
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(llIlIIIllIIlIllIllIllllIl[i], this.x + 1.0f, this.y + 1.0f, this.width, this.height);
            }
            if (!this.IllllllllllIlIIIlllIlllll) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().IlllIIIIIIlllIlIIlllIlIIl(0.0f), Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().lIllIlIIIlIIIIIIIlllIlIll(0.0f), Ref.IlllIIIIIIlllIlIIlllIlIIl().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().llllIlIllllIlIlIIIllIlIlI().llIlllIIIllllIIlllIllIIIl(0.0f), f3);
            } else {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, f3);
            }
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(llIlIIIllIIlIllIllIllllIl[i], this.x, this.y, this.width, this.height);
            GL11.glPopMatrix();
        }
        GL11.glPopMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    public static class StarEase extends LinearEase {
        public QuadraticEase lIIIllIllIIllIlllIlIIlllI;
        public QuadraticEase IlllllIlIIIlIIlIIllIIlIll;

        public StarEase(long l) {
            super((long)((float)l * 1.0f));
            this.lIIIllIllIIllIlllIlIIlllI = new QuadraticEase(Math.min((long)Math.min((float)l * 0.2f, 3000.0f), 1500L));
            this.IlllllIlIIIlIIlIIllIIlIll = new QuadraticEase(Math.min((long)((float)l * 0.4f), 5000L));
        }

        @Override
        public void lIllIlIIIlIIIIIIIlllIlIll() {
            super.lIllIlIIIlIIIIIIIlllIlIll();
            if (!this.lIIIllIllIIllIlllIlIIlllI.llllIIlIIlIIlIIllIIlIIllI()) {
                this.lIIIllIllIIllIlllIlIIlllI.lIllIlIIIlIIIIIIIlllIlIll();
            }
        }

        // todo
        public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.lIIIllIllIIllIlllIlIIlllI.IlIlIlllllIlIIlIlIlllIlIl();
        }

        public float IIlIllIlIIllIIlIlIllllllI() {
            if (!this.lIIIllIllIIllIlllIlIIlllI.llllIIlIIlIIlIIllIIlIIllI()) {
                this.lIIIllIllIIllIlllIlIIlllI.lIllIlIIIlIIIIIIIlllIlIll();
            }
            if (this.lIIIllIllIIllIlllIlIIlllI.lIIIllIllIIllIlllIlIIlllI()) {
                return Math.max(1.0f * this.lIIIllIllIIllIlllIlIIlllI.IlllllIlIIIlIIlIIllIIlIll(), 0.15f);
            }
            if (this.lllllIllIllIllllIlIllllII() <= this.IlllllIlIIIlIIlIIllIIlIll.IIlIllIlllllllIIlIIIllIIl()) {
                if (!this.IlllllIlIIIlIIlIIllIIlIll.llllIIlIIlIIlIIllIIlIIllI()) {
                    this.IlllllIlIIIlIIlIIllIIlIll.lIllIlIIIlIIIIIIIlllIlIll();
                }
                return 1.0f - 0.85f * this.IlllllIlIIIlIIlIIllIIlIll.IlllllIlIIIlIIlIIllIIlIll();
            }
            return 1.0f;
        }

        public StarEase(long l, Object var3_2) {
            this(l);
        }
    }
}