package com.moonsworth.lunar.client.ui.screen.type.mainmenu;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.IIlIllIlIIllIIlIlIllllllI;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.ease.QuadraticEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class ManUserIconUIComponent
extends AbstractListUIComponent {
    public static final ResourceLocationBridge IIlIllIlllllllIIlIIIllIIl = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/assets/man-user-16x16.png");
    public static final int lIIlIlllIlIlIIIlllIIlIIII = 3;
    public final IIlIllIlIIllIIlIlIllllllI fsfsfsf = new IIlIllIlIIllIIlIlIllllllI(this);
    public final ColorEase[] llIllIlIllIlllIllIIIIllII = new ColorEase[]{new ColorEase(300L, 0x20FFFFFF, 0x40000000), new ColorEase(300L, 0x20FFFFFF, 0x40000000)};
    public final QuadraticEase IlllIIIIIIlllIlIIlllIlIIl = new QuadraticEase(200L);
    public static float IllllllllllIlIIIlllIlllll;
    public static float lllllIllIlIIlIIlIIIlllIlI;
    public final float lIllIlIIIlIIIIIIIlllIlIll;
    public float IllIIIlllIIIlIlllIlIIlIII;
    public boolean IIlIllIlIIllIIlIlIllllllI;
    public final AbstractUIScreen lIIIlllIIIIllllIlIIIlIIll;

    public ManUserIconUIComponent(AbstractUIScreen abstractUIScreen, UIComponent parent) {
        super(parent);
        this.lIIIlllIIIIllllIlIIIlIIll = abstractUIScreen;
        this.lIllIlIIIlIIIIIIIlllIlIll = 100.0f;
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            if (this.fsfsfsf.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
                return this.fsfsfsf.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, n);
            }
            for (UIComponent uIComponent : this.llIlIIIllIIlIllIllIllllIl) {
                if (!uIComponent.IlllIIIIIIlllIlIIlllIlIIl(f, f2 - this.fsfsfsf.lIllIlIIIlIIIIIIIlllIlIll())) continue;
                return uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.fsfsfsf.lIllIlIIIlIIIIIIIlllIlIll(), n);
            }
            return false;
        });
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
        if (IllllllllllIlIIIlllIlllll == 0.0f) {
            IllllllllllIlIIIlllIlllll = f4;
            lllllIllIlIIlIIlIIIlllIlI = f3;
        }
        int n = 0;
        this.llIlIIIllIIlIllIllIllllIl = this.lIllIlIIIlIIIIIIIlllIlIll();
        for (InvalidSessionStatusUIComponent invalidSessionStatusUIComponent : this.lIIlIlllIlIlIIIlllIIlIIII()) {
            invalidSessionStatusUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + (float)(n * 16), this.lIllIlIIIlIIIIIIIlllIlIll, 16.0f);
            if (++n != this.llIlIIIllIIlIllIllIllllIl.size()) continue;
            invalidSessionStatusUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(true);
        }
        this.IllIIIlllIIIlIlllIlIIlIII = Math.min((float)(n - 1) * 16.0f, 48.0f);
        this.fsfsfsf.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 - 6.0f, f2 + 20.0f, 4.0f, f4 - 20.0f);
        this.fsfsfsf.IlIlIlllllIlIIlIlIlllIlIl((float)(n - 1) * 16.0f - 4.0f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        super.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return LunarClient.IIllIlIllIlIllIllIllIllII().llIlIIIllIIlIllIllIllllIl().llIIlIlIIIllIlIlIlIIlIIll();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        if (this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && !this.IIlIllIlIIllIIlIlIllllllI) {
            this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll();
            this.IIlIllIlIIllIIlIlIllllllI = true;
        } else if (this.IIlIllIlIIllIIlIlIllllllI && !this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.IlllIIIIIIlllIlIIlllIlIIl.llIIIIIIIllIIllIlIllIIIIl();
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, lllllIllIlIIlIIlIIIlllIlI, IllllllllllIlIIIlllIlllll);
            for (UIComponent uIComponent : this.llIlIIIllIIlIllIllIllllIl) {
                uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent.lllIIIIIlllIIlIllIIlIIIlI(), uIComponent.lIlIIIIIIlIIIllllIllIIlII(), uIComponent.llIlIIIllIIlIllIllIllllIl(), uIComponent.IllIllIIIllIIIlIlIlIIIIll());
            }
            this.IIlIllIlIIllIIlIlIllllllI = false;
        }
        if (this.IlllIIIIIIlllIlIIlllIlIIl.lIIIllIllIIllIlllIlIIlllI()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, lllllIllIlIIlIIlIIIlllIlI + (this.lIllIlIIIlIIIIIIIlllIlIll - lllllIllIlIIlIIlIIIlllIlI) * this.IlllIIIIIIlllIlIIlllIlIIl.IlllllIlIIIlIIlIIllIIlIll(), IllllllllllIlIIIlllIlllll + this.IllIIIlllIIIlIlllIlIIlIII * this.IlllIIIIIIlllIlIIlllIlIIl.IlllllIlIIIlIIlIIllIIlIll());
            for (UIComponent uIComponent : this.llIlIIIllIIlIllIllIllllIl) {
                uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(uIComponent.lllIIIIIlllIIlIllIIlIIIlI(), uIComponent.lIlIIIIIIlIIIllllIllIIlII(), this.width, uIComponent.IllIllIIIllIIIlIlIlIIIIll());
            }
            this.IIlIllIlIIllIIlIlIllllllI = true;
        } else if (!this.IlllIIIIIIlllIlIIlllIlIIl.lIIIllIllIIllIlllIlIIlllI() && !this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            this.IIlIllIlIIllIIlIlIllllllI = false;
        }
        int n = this.llIllIlIllIlllIllIIIIllII[this.llllIIlIIlIIlIIllIIlIIllI() ? 0 : 1].lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && bl);
        float f3 = 8.0f;
        if (!this.IIlIllIlIIllIIlIlIllllllI) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.5f, n);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(this.llllIIlIIlIIlIIllIIlIIllI() ? 1.0f : 1.0f, this.llllIIlIIlIIlIIllIIlIIllI() ? 1.0f : 0.3f, this.llllIIlIIlIIlIIllIIlIIllI() ? 1.0f : 0.3f, 0.6f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(IIlIllIlllllllIIlIIIllIIl, this.x + this.width / 2.0f - f3 / 2.0f, this.y + this.height / 2.0f - f3 / 2.0f, f3, f3);
        } else {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.5f, n);
            ((InvalidSessionStatusUIComponent)this.llIlIIIllIIlIllIllIllllIl.get(0)).lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
            GL11.glPushMatrix();
            GL11.glEnable((int)3089);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x - 2.0f), (int)(this.y + 16.0f), (int)(this.x + this.width + 2.0f), (int)(this.y + this.height + 2.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.lIIIlllIIIIllllIlIIIlIIll.lllllIllIlIIlIIlIIIlllIlI());
            this.fsfsfsf.IlllIIIIIIlllIlIIlllIlIIl(f, f2, bl);
            for (InvalidSessionStatusUIComponent invalidSessionStatusUIComponent : this.llIlIIIllIIlIllIllIllllIl) {
                if (invalidSessionStatusUIComponent instanceof AccountButtonUIComponent || !(invalidSessionStatusUIComponent.lllIIIIIlllIIlIllIIlIIIlI() >= this.x)) continue;
                invalidSessionStatusUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 - this.fsfsfsf.lIllIlIIIlIIIIIIIlllIlIll(), bl && !this.fsfsfsf.lIIIllIllIIllIlllIlIIlllI());
            }
            this.fsfsfsf.llllIIlIIlIIlIIllIIlIIllI(f, f2, bl);
            GL11.glDisable((int)3089);
            GL11.glPopMatrix();
        }
    }

    public float llIIIIIIIllIIllIlIllIIIIl() {
        return (float)this.llIlIIIllIIlIllIllIllllIl.size() * 16.0f + 10.0f;
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        return 22.0f + f + 10.0f;
    }

    @Override
    public List lIllIlIIIlIIIIIIIlllIlIll() {
        ArrayList<InvalidSessionStatusUIComponent> arrayList = new ArrayList<InvalidSessionStatusUIComponent>();
        for (Account account : LunarClient.IIllIlIllIlIllIllIllIllII().llIlIIIllIIlIllIllIllllIl().llIlllIIIllllIIlllIllIIIl().values()) {
            if (account.lIIIllIllIIllIlllIlIIlllI().lIlIlIlIlIIlIIlIIllIIIIIl().equals(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getSession().bridge$getPlayerID().replace("-", ""))) continue;
            InvalidSessionStatusUIComponent invalidSessionStatusUIComponent = new InvalidSessionStatusUIComponent(this, account);
            arrayList.add(invalidSessionStatusUIComponent);
        }
        arrayList.add(0, new AccountButtonUIComponent(this, LunarClient.IIllIlIllIlIllIllIllIllII().llIlIIIllIIlIllIllIllllIl().IlllllIlIIIlIIlIIllIIlIll()));
        return arrayList;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(int n) {
        this.fsfsfsf.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
    }
}