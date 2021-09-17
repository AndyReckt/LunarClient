package com.moonsworth.lunar.client.ui.screen.type.mainmenu;

/**
 * @author Decencies
 * @since 10/07/2021 18:54
 */
public class MainMenuLoginUIScreen extends BaseMainMenuUIScreen {
    public final float llIlIIIllIIlIllIllIllllIl = 310.0F;
    public final float IllIllIIIllIIIlIlIlIIIIll = 130.0F;
    public lllllIllIlIIlIIlIIIlllIlI IIlIllIlllllllIIlIIIllIIl = new lllllIllIlIIlIIlIIIlllIlI((UIComponent)null, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), this.get("login", new Object[0]), 553648127, 905969663);
    public lllllIllIlIIlIIlIIIlllIlI lIIlIlllIlIlIIIlllIIlIIII = new lllllIllIlIIlIIlIIIlllIlI((UIComponent)null, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), this.get("password", new Object[0]), 553648127, 905969663);
    public llIllIlIllIlllIllIIIIllII llIllIlIllIlllIllIIIIllII;
    public IlllIIIIIIlllIlIIlllIlIIl IllllllllllIlIIIlllIlllll;
    public IlllIIIIIIlllIlIIlllIlIIl lllllIllIlIIlIIlIIIlllIlI;
    public String IllIIIlllIIIlIlllIlIIlIII;
    public MainMenuLoginUIScreen.MainMenuEase IIlIllIlIIllIIlIlIllllllI;

    public MainMenuLoginUIScreen() {
        this.lIIlIlllIlIlIIIlllIIlIIII.IlIlIlllllIlIIlIlIlllIlIl(true);
        this.IllllllllllIlIIIlllIlllll = new IlllIIIIIIlllIlIIlllIlIIl((UIComponent)null, this.get("confirm", new Object[0]), FontRegistry.llIIlIlIIIllIlIlIlIIlIIll());
        this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl((MouseEventCallback)((var1, var2, var3) -> {
            this.IlllllIlIIIlIIlIIllIIlIll();
            return false;
        }));
        this.lllllIllIlIIlIIlIIIlllIlI = new IlllIIIIIIlllIlIIlllIlIIl((UIComponent)null, this.get("back", new Object[0]), FontRegistry.llIIlIlIIIllIlIlIlIIlIIll());
        this.lllllIllIlIIlIIlIIIlllIlI.lIlIlIlIlIIlIIlIIllIIIIIl((MouseEventCallback)((var0, var1, var2) -> {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen((GuiScreenBridge)null);
            return true;
        }));
        this.llIllIlIllIlllIllIIIIllII = new llIllIlIllIlllIllIIIIllII((UIComponent)null, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "icons/mainmenu/windows.png"));
        this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll(true);
        this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(new ColorEase(-1, -1));
        this.llIllIlIllIlllIllIIIIllII.IlIlIlllllIlIIlIlIlllIlIl(21.0F);
        this.llIllIlIllIlllIllIIIIllII.llIIIIIIIllIIllIlIllIIIIl(21.0F);
        this.llIllIlIllIlllIllIIIIllII.lIllIlIIIlIIIIIIIlllIlIll((var0, var1, var2) -> {
            AuthUtil.lIlIlIlIlIIlIIlIIllIIIIIl();
            return true;
        });
        this.llIIlIlIIIllIlIlIlIIlIIll.add(this.IIlIllIlllllllIIlIIIllIIl);
        this.llIIlIlIIIllIlIlIlIIlIIll.add(this.lIIlIlllIlIlIIIlllIIlIIII);
        this.llIIlIlIIIllIlIlIlIIlIIll.add(this.IllllllllllIlIIIlllIlllll);
        this.llIIlIlIIIllIlIlIlIIlIIll.add(this.lllllIllIlIIlIIlIIIlllIlI);
        this.llIIlIlIIIllIlIlIlIIlIIll.add(this.llIllIlIllIlllIllIIIIllII);
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

        FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl(this.get("loginRequest", new Object[0]), this.IllllllllllIlIIIlllIlllll() / 2.0F, var4 - 30.0F + 1.0F, 536870912);
        FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl(this.get("loginRequest", new Object[0]), this.IllllllllllIlIIIlllIlllll() / 2.0F, var4 - 30.0F, -4275267);
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
        this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0F - 75.0F, var1 + var2 + 23.0F, 150.0F, 15.0F);
        this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0F - 75.0F, var1 + var2 + 46.0F, 150.0F, 15.0F);
        this.llIllIlIllIlllIllIIIIllII.lIIIllIllIIllIlllIlIIlllI(this.IllllllllllIlIIIlllIlllll() / 2.0F - 75.0F + 15.0F);
        this.llIllIlIllIlllIllIIIIllII.IlllllIlIIIlIIlIIllIIlIll(var1 + 22.0F);
        this.llIllIlIllIlllIllIIIIllII.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0F - 75.0F, var1 + 10.0F, 150.0F, 24.0F);
        this.IllllllllllIlIIIlllIlllll.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0F - 25.0F, var1 + var2 + 69.0F, 50.0F, 15.0F);
        this.lllllIllIlIIlIIlIIIlllIlI.lIlIlIlIlIIlIIlIIllIIIIIl(this.IllllllllllIlIIIlllIlllll() / 2.0F - 17.5F, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F + 65.0F + 10.0F, 35.0F, 15.0F);
    }

    public void lIlIIIIIIlIIIllllIllIIlII() {
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(char var1, KeyType var2) {
        if (var2 == KeyType.IllIlIIllIIlllIIllIlIlIII) {
            if (this.IIlIllIlllllllIIlIIIllIIl.llIllIlIllIlllIllIIIIllII()) {
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            } else if (this.lIIlIlllIlIlIIIlllIIlIIII.llIllIlIllIlllIllIIIIllII()) {
                this.lIIlIlllIlIlIIIlllIIlIIII.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(true);
            }
        } else if (var2 == KeyType.IlIlIlIlIIIlIIlIIlllIllIl) {
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
        String var1 = this.IIlIllIlllllllIIlIIIllIIl.llllIIlIIlIIlIIllIIlIIllI();
        String var2 = this.lIIlIlllIlIlIIIlllIIlIIII.llllIIlIIlIIlIIllIIlIIllI();
        if (!var1.isEmpty() && !var2.isEmpty()) {
            boolean var3;
            AccountManager var4;
            try {
                var4 = new AccountManager(var1, var2);
                var3 = LunarClient.IIllIlIllIlIllIllIllIllII().llIlIIIllIIlIllIllIllllIl().IlllIIIIIIlllIlIIlllIlIIl((Account)var4);
            } catch (AuthenticationException var6) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(var6.getMessage(), 5000L);
                return;
            }

            if (var3) {
                Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen((GuiScreenBridge)null);
                LunarClient.IIllIlIllIlIllIllIllIllII().llIlIIIllIIlIllIllIllllIl().lIllIlIIIlIIIIIIIlllIlIll(var4);
            } else {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(this.get("failedToLogin", new Object[0]), 5000L);
            }

            if (var3) {
                AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
            }

        } else {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.get("emptyFields", new Object[0]), 3000L);
        }
    }

    public lllllIllIlIIlIIlIIIlllIlI llIIIIIIIllIIllIlIllIIIIl() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public lllllIllIlIIlIIlIIIlllIlI lIIIllIllIIllIlllIlIIlllI() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    @OriginalName("lunar/cp/lIllIlIIIlIIIIIIIlllIlIll$lIlIlIlIlIIlIIlIIllIIIIIl")
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
            if (this.lllllIllIllIllllIlIllllII() <= this.IlllllIlIIIlIIlIIllIIlIll.IIlIllIlllllllIIlIIIllIIl()) {
                this.IlllllIlIIIlIIlIIllIIlIll.lIllIlIIIlIIIIIIIlllIlIll();
            }

            if (!this.lIIIllIllIIllIlllIlIIlllI.IlIlIlllllIlIIlIlIlllIlIl() && !this.IlllllIlIIIlIIlIIllIIlIll.llllIIlIIlIIlIIllIIlIIllI()) {
                return this.lIIIllIllIIllIlllIlIIlllI.IlllllIlIIIlIIlIIllIIlIll();
            } else {
                return this.IlllllIlIIIlIIlIIllIIlIll.llllIIlIIlIIlIIllIIlIIllI() ? 1.0F - this.IlllllIlIIIlIIlIIllIIlIll.IlllllIlIIIlIIlIIllIIlIll() : 1.0F;
            }
        }

        // $FF: synthetic method
        public MainMenuEase(long var1, Object var3) {
            this(var1);
        }
    }
}