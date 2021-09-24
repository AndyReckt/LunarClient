package com.moonsworth.lunar.client.ui.screen.type.mainmenu.login;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.account.Account;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.ScrollbarUIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.ease.QuadraticEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class AccountButtonListUIComponent extends AbstractListUIComponent<AltAccountButtonUIComponent> {
    public static final ResourceLocationBridge IIlIllIlllllllIIlIIIllIIl = Bridge.getInstance().initResourceLocation("lunar", "icons/assets/man-user-16x16.png");
    public static final int lIIlIlllIlIlIIIlllIIlIIII = 3;
    public final ScrollbarUIComponent lIlIlIlIlIIlIIlIIllIIIIIl = new ScrollbarUIComponent(this);
    public final ColorEase[] llIllIlIllIlllIllIIIIllII = new ColorEase[] {new ColorEase(300L, 0x20FFFFFF, 0x40000000), new ColorEase(300L, 0x20FFFFFF, 0x40000000)};
    public final QuadraticEase IlllIIIIIIlllIlIIlllIlIIl = new QuadraticEase(200L);
    public static float IllllllllllIlIIIlllIlllll;
    public static float lllllIllIlIIlIIlIIIlllIlI;
    public final float lIllIlIIIlIIIIIIIlllIlIll;
    public float IllIIIlllIIIlIlllIlIIlIII;
    public boolean IIlIllIlIIllIIlIlIllllllI;
    public final AbstractUIScreen lIIIlllIIIIllllIlIIIlIIll;

    public AccountButtonListUIComponent(AbstractUIScreen abstractUIScreen, UIComponent parent) {
        super(parent);
        this.lIIIlllIIIIllllIlIIIlIIll = abstractUIScreen;
        this.lIllIlIIIlIIIIIIIlllIlIll = 100.0f;
        this.onMouseClick((float f, float f2, int n) -> {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(f, f2)) {
                return this.lIlIlIlIlIIlIIlIIllIIIIIl.onMouseClicked(f, f2, n);
            }
            for (UIComponent uIComponent : this.components) {
                if (!uIComponent.mouseInside(f, f2 - this.lIlIlIlIlIIlIIlIIllIIIIIl.getYOffset())) continue;
                return uIComponent.onMouseClicked(f, f2 - this.lIlIlIlIlIIlIIlIIllIIIIIl.getYOffset(), n);
            }
            return false;
        });
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        if (IllllllllllIlIIIlllIlllll == 0.0f) {
            IllllllllllIlIIIlllIlllll = height;
            lllllIllIlIIlIIlIIIlllIlI = width;
        }
        int n = 0;
        this.components = this.lIllIlIIIlIIIIIIIlllIlIll();
        for (AltAccountButtonUIComponent altAccountButtonUIComponent : this.lIIlIlllIlIlIIIlllIIlIIII()) {
            altAccountButtonUIComponent.setPositionAndSize(x, y + (float)(n * 16), this.lIllIlIIIlIIIIIIIlllIlIll, 16.0f);
            if (++n != this.components.size()) continue;
            altAccountButtonUIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(true);
        }
        this.IllIIIlllIIIlIlllIlIIlIII = Math.min((float)(n - 1) * 16.0f, 48.0f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.setPositionAndSize(x + width - 6.0f, y + 20.0f, 4.0f, height - 20.0f);
        this.lIlIlIlIlIIlIIlIIllIIIIIl.setContentHeight((float)(n - 1) * 16.0f - 4.0f);
    }

    @Override
    public void onUpdateScreen() {
        super.onUpdateScreen();
    }

    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return LunarClient.getInstance().llIlIIIllIIlIllIllIllllIl().llIIlIlIIIllIlIlIlIIlIIll();
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        if (this.mouseInside(mouseX, mouseY) && !this.IIlIllIlIIllIIlIlIllllllI) {
            this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll();
            this.IIlIllIlIIllIIlIlIllllllI = true;
        } else if (this.IIlIllIlIIllIIlIlIllllllI && !this.mouseInside(mouseX, mouseY)) {
            this.IlllIIIIIIlllIlIIlllIlIIl.llIIIIIIIllIIllIlIllIIIIl();
            this.setPositionAndSize(this.x, this.y, lllllIllIlIIlIIlIIIlllIlI, IllllllllllIlIIIlllIlllll);
            for (UIComponent uIComponent : this.components) {
                uIComponent.setPositionAndSize(uIComponent.getX(), uIComponent.getY(), uIComponent.getWidth(), uIComponent.getHeight());
            }
            this.IIlIllIlIIllIIlIlIllllllI = false;
        }
        if (this.IlllIIIIIIlllIlIIlllIlIIl.lIIIllIllIIllIlllIlIIlllI()) {
            this.setPositionAndSize(this.x, this.y, lllllIllIlIIlIIlIIIlllIlI + (this.lIllIlIIIlIIIIIIIlllIlIll - lllllIllIlIIlIIlIIIlllIlI) * this.IlllIIIIIIlllIlIIlllIlIIl.getProgress(), IllllllllllIlIIIlllIlllll + this.IllIIIlllIIIlIlllIlIIlIII * this.IlllIIIIIIlllIlIIlllIlIIl.getProgress());
            for (UIComponent uIComponent : this.components) {
                uIComponent.setPositionAndSize(uIComponent.getX(), uIComponent.getY(), this.width, uIComponent.getHeight());
            }
            this.IIlIllIlIIllIIlIlIllllllI = true;
        } else if (!this.IlllIIIIIIlllIlIIlllIlIIl.lIIIllIllIIllIlllIlIIlllI() && !this.mouseInside(mouseX, mouseY)) {
            this.IIlIllIlIIllIIlIlIllllllI = false;
        }
        int n = this.llIllIlIllIlllIllIIIIllII[this.llllIIlIIlIIlIIllIIlIIllI() ? 0 : 1].lIlIlIlIlIIlIIlIIllIIIIIl(this.mouseInside(mouseX, mouseY) && bl);
        float f3 = 8.0f;
        if (!this.IIlIllIlIIllIIlIlIllllllI) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.5f, n);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(this.llllIIlIIlIIlIIllIIlIIllI() ? 1.0f : 1.0f, this.llllIIlIIlIIlIIllIIlIIllI() ? 1.0f : 0.3f, this.llllIIlIIlIIlIIllIIlIIllI() ? 1.0f : 0.3f, 0.6f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(IIlIllIlllllllIIlIIIllIIl, this.x + this.width / 2.0f - f3 / 2.0f, this.y + this.height / 2.0f - f3 / 2.0f, f3, f3);
        } else {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.5f, n);
            this.components.get(0).drawComponent(mouseX, mouseY, bl);
            GL11.glPushMatrix();
            GL11.glEnable(3089);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl((int)(this.x - 2.0f), (int)(this.y + 16.0f), (int)(this.x + this.width + 2.0f), (int)(this.y + this.height + 2.0f), (float)((int)((float)AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().llllIIlIIlIIlIIllIIlIIllI() * AbstractUIScreen.lIIlIlllIlIlIIIlllIIlIIII())), (int)this.lIIIlllIIIIllllIlIIIlIIll.lllllIllIlIIlIIlIIIlllIlI());
            this.lIlIlIlIlIIlIIlIIllIIIIIl.onDraw(mouseX, mouseY, bl);
            for (AltAccountButtonUIComponent altAccountButtonUIComponent : this.components) {
                if (altAccountButtonUIComponent instanceof SelectedAccountButtonUIComponent || !(altAccountButtonUIComponent.getX() >= this.x)) continue;
                altAccountButtonUIComponent.drawComponent(mouseX, mouseY - this.lIlIlIlIlIIlIIlIIllIIIIIl.getYOffset(), bl && !this.lIlIlIlIlIIlIIlIIllIIIIIl.lIIIllIllIIllIlllIlIIlllI());
            }
            this.lIlIlIlIlIIlIIlIIllIIIIIl.llllIIlIIlIIlIIllIIlIIllI(mouseX, mouseY, bl);
            GL11.glDisable(3089);
            GL11.glPopMatrix();
        }
    }

    public float llIIIIIIIllIIllIlIllIIIIl() {
        return (float)this.components.size() * 16.0f + 10.0f;
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        return 22.0f + f + 10.0f;
    }

    @Override
    public List<AltAccountButtonUIComponent> lIllIlIIIlIIIIIIIlllIlIll() {
        ArrayList<AltAccountButtonUIComponent> arrayList = new ArrayList<AltAccountButtonUIComponent>();
        for (Account account : LunarClient.getInstance().llIlIIIllIIlIllIllIllllIl().llIlllIIIllllIIlllIllIIIl().values()) {
            if (account.getProfile().getId().equals(Ref.getMinecraft().bridge$getSession().bridge$getPlayerID().replace("-", ""))) continue;
            AltAccountButtonUIComponent altAccountButtonUIComponent = new AltAccountButtonUIComponent(this, account);
            arrayList.add(altAccountButtonUIComponent);
        }
        arrayList.add(0, new SelectedAccountButtonUIComponent(this, LunarClient.getInstance().llIlIIIllIIlIllIllIllllIl().IlllllIlIIIlIIlIIllIIlIll()));
        return arrayList;
    }

    @Override
    public void handleMouseScrollDelta(int n) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.handleMouseScrollDelta(n);
        super.handleMouseScrollDelta(n);
    }
}