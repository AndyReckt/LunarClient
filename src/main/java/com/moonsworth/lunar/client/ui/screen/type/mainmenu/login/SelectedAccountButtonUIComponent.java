package com.moonsworth.lunar.client.ui.screen.type.mainmenu.login;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.account.Account;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.type.setting.SmallIconUIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class SelectedAccountButtonUIComponent extends AltAccountButtonUIComponent {
    public final SmallIconUIComponent llIlIIIllIIlIllIllIllllIl = new SmallIconUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/add-16x16.png"));

    public SelectedAccountButtonUIComponent(AccountButtonListUIComponent var1, Account var2) {
        super(var1, var2);
        this.onMouseClick((var1x, var2x, var3) -> {
            return this.llIlIIIllIIlIllIllIllllIl.mouseInside(var1x, var2x) && this.llIlIIIllIIlIllIllIllllIl.onMouseClicked(var1x, var2x, var3);
        });
        this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl(false);
        this.llIlIIIllIIlIllIllIllllIl.lIllIlIIIlIIIIIIIlllIlIll(true);
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(new ColorEase(1358954495, -536870913));
        this.llIlIIIllIIlIllIllIllllIl.onMouseClick((var1x, var2x, var3) -> {
            if (!this.mouseInside(var1x, var2x)) {
                return false;
            } else {
                this.mc.bridge$displayScreen(Bridge.getInstance().initCustomScreen(new MainMenuLoginUIScreen()));
                return true;
            }
        });
    }

    public boolean llIlllIIIllllIIlllIllIIIl() {
        return LunarClient.getInstance().llIlIIIllIIlIllIllIllllIl().llIIlIlIIIllIlIlIlIIlIIll();
    }

    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        float var5 = 18.0F;
        this.llIlIIIllIIlIllIllIllllIl.setPositionAndSize(x + width - var5 / 2.0F - 7.0F, y + height / 2.0F - var5 / 2.0F, var5, var5);
    }

    public void drawComponent(float mouseX, float mouseY, boolean var3) {
        int var4 = 436251136;
        if (!this.IlllIIIIIIlllIlIIlllIlIIl.llllIIlIIlIIlIIllIIlIIllI()) {
            this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll();
        }

        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y + 1.0F, this.width, this.height - 1.0F, 4.5F, var4, true, true, this.lIllIlIIIlIIIIIIIlllIlIll, this.lIllIlIIIlIIIIIIIlllIlIll);
        AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + 1.0F, this.width, this.height - 1.0F, 4.5F, this.llIlllIIIllllIIlllIllIIIl() ? 536914432 : 715128832, true, true, this.lIllIlIIIlIIIIIIIlllIlIll, this.lIllIlIIIlIIIIIIIlllIlIll);
        this.llIlIIIllIIlIllIllIllllIl.drawComponent(mouseX, mouseY, var3);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F * this.IlllIIIIIIlllIlIIlllIlIIl.getProgress());
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl != null) {
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.getHead(), 6.0F, this.x + 3.0F, this.y + 2.5F);
        }

        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 0.7F * this.IlllIIIIIIlllIlIIlllIlIIl.getProgress() * ((AccountButtonListUIComponent)this.parent).IlllIIIIIIlllIlIIlllIlIIl.getProgress());
        FontRegistry.lIllIlIIIlIIIIIIIlllIlIll.IlllIIIIIIlllIlIIlllIlIIl(this.llIlllIIIllllIIlllIllIIIl() ? this.get("loggedInAs") : this.get("invalidSession"), this.x + this.width / 2.0F, this.y + this.height / 2.0F - this.height / 4.0F - (float)FontRegistry.lIllIlIIIlIIIIIIIlllIlIll.getHeight() / 2.0F - 2.0F, -2130706433);
        FontRegistry.llllIIlIIlIIlIIllIIlIIllI.IlllIIIIIIlllIlIIlllIlIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl == null ? "?" : this.lIlIlIlIlIIlIIlIIllIIIIIl.getProfile().getName(), this.x + this.width / 2.0F, this.y + this.height / 2.0F + this.height / 4.0F - (float)FontRegistry.llllIIlIIlIIlIIllIIlIIllI.getHeight() / 2.0F - 3.0F, -2130706433);
    }
}
