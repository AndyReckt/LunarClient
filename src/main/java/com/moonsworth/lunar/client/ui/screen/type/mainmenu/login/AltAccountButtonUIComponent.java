package com.moonsworth.lunar.client.ui.screen.type.mainmenu.login;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.account.Account;
import com.moonsworth.lunar.client.account.AccountType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.SmallIconUIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.ease.QuadraticEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class AltAccountButtonUIComponent extends UIComponent {
    public final Account lIlIlIlIlIIlIIlIIllIIIIIl;
    public final QuadraticEase IlllIIIIIIlllIlIIlllIlIIl = new QuadraticEase(500L);
    public SmallIconUIComponent llIlIIIllIIlIllIllIllllIl = new SmallIconUIComponent(this, Bridge.getInstance().initResourceLocation("lunar", "icons/exit-17x17-small.png"));
    public final ColorEase[] IllIllIIIllIIIlIlIlIIIIll = new ColorEase[] {new ColorEase(553648127, 1174405119), new ColorEase(816455712, -2136334304)};
    public final ColorEase[] IIlIllIlllllllIIlIIIllIIl = new ColorEase[] {new ColorEase(200L, 553648127, 553648127), new ColorEase(200L, 447361072, 1353330736)};
    public boolean lIllIlIIIlIIIIIIIlllIlIll;

    public AltAccountButtonUIComponent(AccountButtonListUIComponent var1, Account var2) {
        super(var1);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = var2;
        this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl(false);
        this.llIlIIIllIIlIllIllIllllIl.lIllIlIIIlIIIIIIIlllIlIll(true);
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(new ColorEase(1358954495, -1711329232));
        this.llIlIIIllIIlIllIllIllllIl.onMouseClick(((var3, var4, var5) -> {
            if (!this.mouseInside(var3, var4)) {
                return false;
            } else {
                boolean var6 = LunarClient.getInstance().llIlIIIllIIlIllIllIllllIl().lIlIlIlIlIIlIIlIIllIIIIIl(var2);
                if (var6) {
                    var1.setPositionAndSize(var1.getX(), var1.getY(), var1.getWidth(), var1.getHeight() - 16.0F);
                }

                return var6;
            }
        }));
        if (!(this instanceof SelectedAccountButtonUIComponent)) {
            this.onMouseClick((var3, var4, var5) -> {
                if (var1.lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(var3, var4)) {
                    return false;
                } else if (this.llIlIIIllIIlIllIllIllllIl.mouseInside(var3, var4)) {
                    return this.llIlIIIllIIlIllIllIllllIl.onMouseClicked(var3, var4, var5);
                } else {
                    if (this.mouseInside(var3, var4)) {
                        if (var2.getAccessToken() != null && var2.IlllIIIIIIlllIlIIlllIlIIl() && LunarClient.getInstance().llIlIIIllIIlIllIllIllllIl().lIllIlIIIlIIIIIIIlllIlIll(var2)) {
                            AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
                            var1.setPositionAndSize(var1.getX(), var1.getY(), var1.lIllIlIIIlIIIIIIIlllIlIll, var1.getHeight());
                        } else {
                            MainMenuLoginUIScreen var6;
                            this.mc.bridge$displayScreen(Bridge.getInstance().initCustomScreen(var6 = new MainMenuLoginUIScreen()));
                            if (var2.getType() == AccountType.MOJANG) {
                                var6.bruh().setText(var2.getUsername());
                            }

                            var6.lIlIlIlIlIIlIIlIIllIIIIIl(this.get("invalidSessionStatus"), 10000L);
                        }
                    }

                    return true;
                }
            });
        }

    }

    public void onUpdateScreen() {
    }

    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        float var5 = 10.0F;
        this.llIlIIIllIIlIllIllIllllIl.setPositionAndSize(x + width - var5 / 2.0F - 7.0F, y + height / 2.0F - var5 / 2.0F, var5, var5);
    }

    public void drawComponent(float mouseX, float mouseY, boolean var3) {
        if (!this.IlllIIIIIIlllIlIIlllIlIIl.llllIIlIIlIIlIIllIIlIIllI()) {
            this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll();
        }

        int var4;
        int var5;
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl.getAccessToken() != null && this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl()) {
            var4 = this.IIlIllIlllllllIIlIIIllIIl[0].lIlIlIlIlIIlIIlIIllIIIIIl(this.mouseInside(mouseX, mouseY) && var3 && !((AccountButtonListUIComponent)this.parent).lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(mouseX, mouseY) && !this.llIlIIIllIIlIllIllIllllIl.mouseInside(mouseX, mouseY));
            var5 = this.IllIllIIIllIIIlIlIlIIIIll[0].lIlIlIlIlIIlIIlIIllIIIIIl(this.mouseInside(mouseX, mouseY) && var3 && !((AccountButtonListUIComponent)this.parent).lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(mouseX, mouseY) && !this.llIlIIIllIIlIllIllIllllIl.mouseInside(mouseX, mouseY));
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 0.7F * this.IlllIIIIIIlllIlIIlllIlIIl.getProgress());
            AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y, this.width, this.height, 4.0F, var5, false, false, this.lIllIlIIIlIIIIIIIlllIlIll, this.lIllIlIIIlIIIIIIIlllIlIll);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y + 1.0F, this.width, this.height - 1.0F, 4.5F, var4, false, false, this.lIllIlIIIlIIIIIIIlllIlIll, this.lIllIlIIIlIIIIIIIlllIlIll);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, this.IlllIIIIIIlllIlIIlllIlIIl.getProgress());
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.getHead(), 6.0F, this.x + 2.0F, this.y + 2.0F);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 0.7F * this.IlllIIIIIIlllIlIIlllIlIIl.getProgress());
            FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.getProfile().getName(), this.x + this.width / 2.0F, this.y + this.height / 2.0F - (float)FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().getHeight() / 2.0F - 2.0F, -2130706433);
        } else {
            var4 = this.IIlIllIlllllllIIlIIIllIIl[1].lIlIlIlIlIIlIIlIIllIIIIIl(this.mouseInside(mouseX, mouseY) && var3 && !((AccountButtonListUIComponent)this.parent).lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(mouseX, mouseY));
            var5 = this.IllIllIIIllIIIlIlIlIIIIll[1].lIlIlIlIlIIlIIlIIllIIIIIl(this.mouseInside(mouseX, mouseY) && var3 && !((AccountButtonListUIComponent)this.parent).lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(mouseX, mouseY));
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 0.3F, 0.3F, 0.7F * this.IlllIIIIIIlllIlIIlllIlIIl.getProgress());
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y + 1.0F, this.width, this.height - 1.5F, 4.5F, var4, false, false, this.lIllIlIIIlIIIIIIIlllIlIll, this.lIllIlIIIlIIIIIIIlllIlIll);
            AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(this.x, this.y + 1.0F, this.width, this.height - 1.5F, 4.5F, var5, false, false, this.lIllIlIIIlIIIIIIIlllIlIll, this.lIllIlIIIlIIIIIIIlllIlIll);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, this.IlllIIIIIIlllIlIIlllIlIIl.getProgress());
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.getHead(), 6.0F, this.x + 3.0F, this.y + 2.5F);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 0.7F * this.IlllIIIIIIlllIlIIlllIlIIl.getProgress());
            FontRegistry.llllIIlIIlIIlIIllIIlIIllI.IlllIIIIIIlllIlIIlllIlIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.getProfile().getName(), this.x + this.width / 2.0F, this.y + this.height / 2.0F - (float)FontRegistry.llllIIlIIlIIlIIllIIlIIllI.getHeight() / 2.0F - 2.0F, -2130706433);
        }

        this.llIlIIIllIIlIllIllIllllIl.drawComponent(mouseX, mouseY, var3);
    }

    public void onKeyTyped(char var1, KeyType var2) {
    }

    public void onGuiClosed() {
    }

    public Account lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean var1) {
        this.lIllIlIIIlIIIIIIIlllIlIll = var1;
    }
}
