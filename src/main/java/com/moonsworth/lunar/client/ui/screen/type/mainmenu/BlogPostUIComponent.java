package com.moonsworth.lunar.client.ui.screen.type.mainmenu;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.blog.BlogCache;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.ease.QuadraticEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;
import com.moonsworth.lunar.client.util.MathHelperUtil;
import org.lwjgl.opengl.GL11;

public class BlogPostUIComponent
    extends UIComponent {
    public final BlogCache IlllIIIIIIlllIlIIlllIlIIl;
    public final QuadraticEase lIllIlIIIlIIIIIIIlllIlIll = new QuadraticEase(1500L);
    public final QuadraticEase llIlIIIllIIlIllIllIllllIl = new QuadraticEase(1500L);
    public final MainMenuUIScreen IllIllIIIllIIIlIlIlIIIIll;
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl;
    public ColorEase IIlIllIlllllllIIlIIIllIIl = new ColorEase(275L, 0, -1);

    public BlogPostUIComponent(UIComponent uIComponent, MainMenuUIScreen mainMenuUIScreen, BlogCache blogCache) {
        super(uIComponent);
        this.IlllIIIIIIlllIlIIlllIlIIl = blogCache;
        this.IllIllIIIllIIIlIlIlIIIIll = mainMenuUIScreen;
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        if (this.IlllIIIIIIlllIlIIlllIlIIl.llllIIlIIlIIlIIllIIlIIllI() != null) {
            float f3 = 1.0f;
            if (this.lIllIlIIIlIIIIIIIlllIlIll.lIIIllIllIIllIlllIlIIlllI()) {
                f3 = 1.0f * this.lIllIlIIIlIIIIIIIlllIlIll.getProgress();
            }
            if (this.llIlIIIllIIlIllIllIllllIl.lIIIllIllIIllIlllIlIIlllI()) {
                f3 = 1.0f - 1.0f * this.llIlIIIllIIlIllIllIllllIl.getProgress();
            }
            f3 = (float) MathHelperUtil.lIlIlIlIlIIlIIlIIllIIIIIl(f3, 0.0, 1.0);
            if (!(this.llIlIIIllIIlIllIllIllllIl.lIIIllIllIIllIlllIlIIlllI() || this.lIllIlIIIlIIIIIIIlllIlIll.lIIIllIllIIllIlllIlIIlllI() || this.lIlIlIlIlIIlIIlIIllIIIIIl)) {
                return;
            }
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f * f3);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            GL11.glEnable(3089);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)this.x, (int)this.y, (int)(this.x + this.width), (int)(this.y + this.height), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.IllIllIIIllIIIlIlIlIIIIll.lllllIllIlIIlIIlIIIlllIlI());
            float f4 = 1.0f + ColorUtil.llIIIIIIIllIIllIlIllIIIIl(this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.mouseInside(mouseX, mouseY))) / 10.0f;
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.llllIIlIIlIIlIIllIIlIIllI(), this.x - this.width / 2.0f * f4 + this.width / 2.0f - 0.5f, this.y - this.height / 2.0f * f4 + this.height / 2.0f - 0.5f, this.width * f4 + 0.5f, this.height * f4 + 0.5f);
            GL11.glDisable(3089);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawGradientRect((int)this.x, (int)this.y, (int)(this.x + this.width), (int)(this.y + this.height), ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(-1880956190, f3), 0, 0.0f);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x - 1.5f, this.y - 1.5f, this.width + 2.5f, this.height + 2.5f, 4.0f, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(1076176165, f3));
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x - 0.5f, this.y - 0.5f, this.width + 0.5f, this.height + 0.5f, 3.0f, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(-8289919, f3));
        } else {
            this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl();
        }
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }

    public BlogCache lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public QuadraticEase llIlllIIIllllIIlllIllIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public QuadraticEase llllIIlIIlIIlIIllIIlIIllI() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public boolean load() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = bl;
    }
}