package com.moonsworth.lunar.client.ui.screen.type.mainmenu.login;

import com.mojang.authlib.exceptions.AuthenticationException;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.client.account.Account;
import com.moonsworth.lunar.client.account.MojangAccount;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.DefaultButtonUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.SmallIconUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.TextboxWithIcon;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.ease.LinearEase;
import com.moonsworth.lunar.client.ui.event.MouseEventCallback;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.BaseMainMenuUIScreen;
import com.moonsworth.lunar.client.util.AuthUtil;
import com.moonsworth.lunar.client.util.ColorUtil;

/**
 * @author Decencies
 * @since 10/07/2021 18:54
 */
public class MainMenuLoginUIScreen extends BaseMainMenuUIScreen {
    public final float llIlIIIllIIlIllIllIllllIl = 310.0F;
    public final float IllIllIIIllIIIlIlIlIIIIll = 130.0F;
    public TextboxWithIcon IIlIllIlllllllIIlIIIllIIl = new TextboxWithIcon(null, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), this.get("login"), 553648127, 905969663);
    public TextboxWithIcon lIIlIlllIlIlIIIlllIIlIIII = new TextboxWithIcon(null, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), this.get("password"), 553648127, 905969663);
    public SmallIconUIComponent llIllIlIllIlllIllIIIIllII;
    public DefaultButtonUIComponent IllllllllllIlIIIlllIlllll;
    public DefaultButtonUIComponent lllllIllIlIIlIIlIIIlllIlI;
    public String IllIIIlllIIIlIlllIlIIlIII;
    public MainMenuLoginUIScreen.MainMenuEase IIlIllIlIIllIIlIlIllllllI;

    public MainMenuLoginUIScreen() {
        this.lIIlIlllIlIlIIIlllIIlIIII.IlIlIlllllIlIIlIlIlllIlIl(true);
        this.IllllllllllIlIIIlllIlllll = new DefaultButtonUIComponent(null, this.get("confirm"), FontRegistry.llIIlIlIIIllIlIlIlIIlIIll());
        this.IllllllllllIlIIIlllIlllll.onMouseClick((var1, var2, var3) -> {
            this.IlllllIlIIIlIIlIIllIIlIll();
            return false;
        });
        this.lllllIllIlIIlIIlIIIlllIlI = new DefaultButtonUIComponent(null, this.get("back"), FontRegistry.llIIlIlIIIllIlIlIlIIlIIll());
        this.lllllIllIlIIlIIlIIIlllIlI.onMouseClick((var0, var1, var2) -> {
            Ref.getMinecraft().bridge$displayScreen(null);
            return true;
        });
        this.llIllIlIllIlllIllIIIIllII = new SmallIconUIComponent(null, Bridge.getInstance().initResourceLocation("lunar", "icons/mainmenu/windows.png"));
        this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll(true);
        this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(new ColorEase(-1, -1));
        this.llIllIlIllIlllIllIIIIllII.IlIlIlllllIlIIlIlIlllIlIl(21.0F);
        this.llIllIlIllIlllIllIIIIllII.llIIIIIIIllIIllIlIllIIIIl(21.0F);
        this.llIllIlIllIlllIllIIIIllII.onMouseRelease((var0, var1, var2) -> {
            AuthUtil.lIlIlIlIlIIlIIlIIllIIIIIl();
            return true;
        });
        this.components.add(this.IIlIllIlllllllIIlIIIllIIl);
        this.components.add(this.lIIlIlllIlIlIIIlllIIlIIII);
        this.components.add(this.IllllllllllIlIIIlllIlllll);
        this.components.add(this.lllllIllIlIIlIIlIIIlllIlI);
        this.components.add(this.llIllIlIllIlllIllIIIIllII);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2);
        float var3 = this.IllllllllllIlIIIlllIlllll() / 2.0F - 155.0F;
        float var4 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 65.0F;
        float var5 = 32.5F;
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var3, var4, 310.0F, 130.0F, 5.0F, 536870912, 553648127, 805306368);
        if (this.IIlIllIlIIllIIlIlIllllllI != null && this.IIlIllIlIIllIIlIlIllllllI.lIIIllIllIIllIlllIlIIlllI()) {
            int var6 = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(1.0F, 0.15F, 0.15F, 0.75F * this.IIlIllIlIIllIIlIlIllllllI.lIlIlIlIlIIlIIlIIllIIIIIl());
            FontRegistry.IlIlIlllllIlIIlIlIlllIlIl().IlllIIIIIIlllIlIIlllIlIIl(this.IllIIIlllIIIlIlllIlIIlIII, this.IllllllllllIlIIIlllIlllll() / 2.0F, var4 - 12.0F, var6);
        }

        FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl(this.get("loginRequest"), this.IllllllllllIlIIIlllIlllll() / 2.0F, var4 - 30.0F + 1.0F, 536870912);
        FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl(this.get("loginRequest"), this.IllllllllllIlIIIlllIlllll() / 2.0F, var4 - 30.0F, -4275267);
        FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl("Sign in with Microsoft", this.IllllllllllIlIIIlllIlllll() / 2.0F + 10.0F, var4 + 16.0F, -4275267);
        float var7 = var4 + 34.0F;
        AbstractUIScreen.llIlllIIIllllIIlllIllIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0F - 85.0F, this.IllllllllllIlIIIlllIlllll() / 2.0F + 85.0F, var4 + var5 + 23.0F + (var7 - (var4 + var5 + 23.0F)) / 2.0F - 1.0F, -4275267);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, int var3) {
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, int var3) {
    }

    public void llIIIlllIIlllIllllIlIllIl() {
        super.llIIIlllIIlllIllllIlIllIl();
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
        float var1 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 65.0F;
        float var2 = 32.5F;
        this.IIlIllIlllllllIIlIIIllIIl.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() / 2.0F - 75.0F, var1 + var2 + 23.0F, 150.0F, 15.0F);
        this.lIIlIlllIlIlIIIlllIIlIIII.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() / 2.0F - 75.0F, var1 + var2 + 46.0F, 150.0F, 15.0F);
        this.llIllIlIllIlllIllIIIIllII.lIIIllIllIIllIlllIlIIlllI(this.IllllllllllIlIIIlllIlllll() / 2.0F - 75.0F + 15.0F);
        this.llIllIlIllIlllIllIIIIllII.IlllllIlIIIlIIlIIllIIlIll(var1 + 22.0F);
        this.llIllIlIllIlllIllIIIIllII.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() / 2.0F - 75.0F, var1 + 10.0F, 150.0F, 24.0F);
        this.IllllllllllIlIIIlllIlllll.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() / 2.0F - 25.0F, var1 + var2 + 69.0F, 50.0F, 15.0F);
        this.lllllIllIlIIlIIlIIIlllIlI.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() / 2.0F - 17.5F, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F + 65.0F + 10.0F, 35.0F, 15.0F);
    }

    public void lIlIIIIIIlIIIllllIllIIlII() {
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(char var1, KeyType var2) {
        if (var2 == KeyType.KEY_TAB) {
            if (this.IIlIllIlllllllIIlIIIllIIl.isTyping()) {
                this.IIlIllIlllllllIIlIIIllIIl.setTyping(false);
                this.lIIlIlllIlIlIIIlllIIlIIII.setTyping(true);
            } else if (this.lIIlIlllIlIlIIIlllIIlIIII.isTyping()) {
                this.lIIlIlllIlIlIIIlllIIlIIII.setTyping(false);
                this.IIlIllIlllllllIIlIIIllIIl.setTyping(true);
            }
        } else if (var2 == KeyType.KEY_RETURN) {
            this.IlllllIlIIIlIIlIIllIIlIll();
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1, long var2) {
        this.IllIIIlllIIIlIlllIlIIlIII = var1;
        this.IIlIllIlIIllIIlIlIllllllI = new MainMenuLoginUIScreen.MainMenuEase(var2);
    }

    public String getLanguagePath() {
        return super.getLanguagePath() + ".addAccount";
    }

    public void IlllllIlIIIlIIlIIllIIlIll() {
        String var1 = this.IIlIllIlllllllIIlIIIllIIl.getText();
        String var2 = this.lIIlIlllIlIlIIIlllIIlIIII.getText();
        if (!var1.isEmpty() && !var2.isEmpty()) {
            boolean var3;
            MojangAccount var4;
            try {
                var4 = new MojangAccount(var1, var2);
                var3 = LunarClient.getInstance().llIlIIIllIIlIllIllIllllIl().IlllIIIIIIlllIlIIlllIlIIl(var4);
            } catch (AuthenticationException var6) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(var6.getMessage(), 5000L);
                return;
            }

            if (var3) {
                Ref.getMinecraft().bridge$displayScreen(null);
                LunarClient.getInstance().llIlIIIllIIlIllIllIllllIl().lIllIlIIIlIIIIIIIlllIlIll(var4);
            } else {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(this.get("failedToLogin"), 5000L);
            }

            if (var3) {
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
            }

        } else {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.get("emptyFields"), 3000L);
        }
    }

    public TextboxWithIcon bruh() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public TextboxWithIcon lIIIllIllIIllIlllIlIIlllI() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public static class MainMenuEase extends LinearEase {
        public final LinearEase lIIIllIllIIllIlllIlIIlllI;
        public final LinearEase IlllllIlIIIlIIlIIllIIlIll;

        public MainMenuEase(long var1) {
            super(var1);
            this.lIIIllIllIIllIlllIlIIlllI = new LinearEase(500L);
            this.IlllllIlIIIlIIlIIllIIlIll = new LinearEase(500L);
            this.lIllIlIIIlIIIIIIIlllIlIll();
            this.lIIIllIllIIllIlllIlIIlllI.lIllIlIIIlIIIIIIIlllIlIll();
        }

        public float lIlIlIlIlIIlIIlIIllIIIIIl() {
            if (this.lllllIllIllIllllIlIllllII() <= this.IlllllIlIIIlIIlIIllIIlIll.getDuration()) {
                this.IlllllIlIIIlIIlIIllIIlIll.lIllIlIIIlIIIIIIIlllIlIll();
            }

            if (!this.lIIIllIllIIllIlllIlIIlllI.IlIlIlllllIlIIlIlIlllIlIl() && !this.IlllllIlIIIlIIlIIllIIlIll.llllIIlIIlIIlIIllIIlIIllI()) {
                return this.lIIIllIllIIllIlllIlIIlllI.getProgress();
            } else {
                return this.IlllllIlIIIlIIlIIllIIlIll.llllIIlIIlIIlIIllIIlIIllI() ? 1.0F - this.IlllllIlIIIlIIlIIllIIlIll.getProgress() : 1.0F;
            }
        }

        // $FF: synthetic method
        public MainMenuEase(long var1, Object var3) {
            this(var1);
        }
    }
}