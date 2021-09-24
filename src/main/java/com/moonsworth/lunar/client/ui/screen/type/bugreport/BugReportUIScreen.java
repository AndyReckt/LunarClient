package com.moonsworth.lunar.client.ui.screen.type.bugreport;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.crash.ReportHandler;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.setting.SettingLabel;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.*;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.ArrayList;
import java.util.List;

public class BugReportUIScreen extends AbstractUIScreen {
    public static long lIlIlIlIlIIlIIlIIllIIIIIl = 0L;
    public com.moonsworth.lunar.client.ui.component.type.setting.lIIlIlllIlIlIIIlllIIlIIII IlllIIIIIIlllIlIIlllIlIIl;
    public final TextboxWithIcon lIllIlIIIlIIIIIIIlllIlIll;
    public final llIlIIIllIIlIllIllIllllIl llIlllIIIllllIIlllIllIIIl;
    public final llIlIIIllIIlIllIllIllllIl llIIIlllIIlllIllllIlIllIl;
    public final llIlIIIllIIlIllIllIllllIl lllllIllIllIllllIlIllllII;
    public SmallIconUIComponent lllIIIIIlllIIlIllIIlIIIlI;
    public final DefaultButtonUIComponent lIlIIIIIIlIIIllllIllIIlII;
    public final SmallIconUIComponent nignog; // llIlIIIllIIlIllIllIllllIl
    public BugReportUIScreen.Category asasasasas; // IllIllIIIllIIIlIlIlIIIIll
    public final GuiScreenBridge IIlIllIlllllllIIlIIIllIIl;
    public final float lIIlIlllIlIlIIIlllIIlIIII;

    public BugReportUIScreen(GuiScreenBridge var1) {
        this.asasasasas = BugReportUIScreen.Category.lIlIlIlIlIIlIIlIIllIIIIIl;
        this.lIIlIlllIlIlIIIlllIIlIIII = 120.0F;
        this.IIlIllIlllllllIIlIIIllIIl = var1;
        this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of(this.llIlllIIIllllIIlllIllIIIl = new llIlIIIllIIlIllIllIllllIl(new SettingLabel("shortDescription"), null), this.llIIIlllIIlllIllllIlIllIl = new llIlIIIllIIlIllIllIllllIl(new SettingLabel("section"), null), this.lllllIllIllIllllIlIllllII = new llIlIIIllIIlIllIllIllllIl(new SettingLabel(this.asasasasas.toString()), null), this.lIllIlIIIlIIIIIIIlllIlIll = new TextboxWithIcon(this.IlllIIIIIIlllIlIIlllIlIIl, FontRegistry.llIIlIlIIIllIlIlIlIIlIIll(), "description", 553648127, 905969663), this.lIlIIIIIIlIIIllllIllIIlII = new DefaultButtonUIComponent(this.IlllIIIIIIlllIlIIlllIlIIl, "submit"), this.nignog = new SmallIconUIComponent(this.IlllIIIIIIlllIlIIlllIlIIl, Bridge.getInstance().initResourceLocation("lunar", "icons/cosmetics/back-40x40.png")), this.lllIIIIIlllIIlIllIIlIIIlI = new SmallIconUIComponent(this.IlllIIIIIIlllIlIIlllIlIIl, Bridge.getInstance().initResourceLocation("lunar", "icons/assets/arrow-down-17x17.png"))));
        this.lllIIIIIlllIIlIllIIlIIIlI.onMouseClick((var1x, var2, var3) -> {
            this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(new IllIllIIIllIIIlIlIlIIIIll(this.IlllIIIIIIlllIlIIlllIlIIl) {
                public List<UIComponent> lIllIlIIIlIIIIIIIlllIlIll() {
                    List<UIComponent> var1 = new ArrayList<>();

                    for (Category var5 : Category.values()) {
                        lIlIlIIIIIIllIlIIIIllIIII var6;
                        var1.add(var6 = new lIlIlIIIIIIllIlIIIIllIIII(this.parent, BugReportUIScreen.this.lllllIllIllIllllIlIllllII.llIIIIIIIllIIllIlIllIIIIl().get(var5.toString()), -1));
                        var6.onMouseClick((var2x, var3x, var4x) -> {
                            float var5x = (float) FontRegistry.lIlIIIIIIlIIIllllIllIIlII().IlllIIIIIIlllIlIIlllIlIIl(((SettingLabel) BugReportUIScreen.this.llIIIlllIIlllIllllIlIllIl.llIIIIIIIllIIllIlIllIIIIl()).IlllIIIIIIlllIlIIlllIlIIl().toUpperCase());
                            BugReportUIScreen.this.asasasasas = var5;
                            ((SettingLabel) BugReportUIScreen.this.lllllIllIllIllllIlIllllII.llIIIIIIIllIIllIlIllIIIIl()).lIlIlIlIlIIlIIlIIllIIIIIl((Object) var5.toString());
                            BugReportUIScreen.this.lllllIllIllIllllIlIllllII.resoze(BugReportUIScreen.this.IlllIIIIIIlllIlIIlllIlIIl.getX() + BugReportUIScreen.this.IlllIIIIIIlllIlIIlllIlIIl.getWidth() - 74.0F, BugReportUIScreen.this.IlllIIIIIIlllIlIIlllIlIIl.getY() + 70.0F, var5x);
                            BugReportUIScreen.this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl((IllIllIIIllIIIlIlIlIIIIll) null);
                            return true;
                        });
                    }

                    return var1;
                }
            });
            this.IlllIIIIIIlllIlIIlllIlIIl.llIllIlIllIlllIllIIIIllII().lIlIlIlIlIIlIIlIIllIIIIIl(var1x, var2);
            return true;
        });
        this.nignog.lIllIlIIIlIIIIIIIlllIlIll(new ColorEase(553648127, 1358901296));
        this.lIllIlIIIlIIIIIIIlllIlIll.setTyping(true);
        this.lIllIlIIIlIIIIIIIlllIlIll.llIIIlllIIlllIllllIlIllIl(180);
        this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(() -> {
            if (this.lIllIlIIIlIIIIIIIlllIlIll.IIlIllIlIIllIIlIlIllllllI() == -65536) {
                this.lIllIlIIIlIIIIIIIlllIlIll.llIIlIlIIIllIlIlIlIIlIIll(0);
            }

        });
        this.lIlIIIIIIlIIIllllIllIIlII.onMouseClick((var2, var3, var4) -> {
            try {
                if (!this.lIllIlIIIlIIIIIIIlllIlIll.getText().isEmpty() && this.lIllIlIIIlIIIIIIIlllIlIll.getText().contains(" ") && this.lIllIlIIIlIIIIIIIlllIlIll.getText().length() >= 5) {
                    if (!this.lIllIlIIIlIIIIIIIlllIlIll.getText().toLowerCase().contains("penis") && !this.lIllIlIIIlIIIIIIIlllIlIll.getText().toLowerCase().contains("dick")) {
                        if (System.currentTimeMillis() - lIlIlIlIlIIlIIlIIllIIIIIl < 3000L) {
                            Ref.getMinecraft().bridge$displayScreen(var1);
                            return true;
                        } else {
                            String var5 = this.lIllIlIIIlIIIIIIIlllIlIll.getText();
                            String var6 = this.asasasasas.name();
                            ReportHandler.lIlIlIlIlIIlIIlIIllIIIIIl(var6, var5);
                            Ref.getMinecraft().bridge$displayScreen(var1);
                            Ref.lIlIlIlIlIIlIIlIIllIIIIIl("The bug report has been submitted. Thank you!");
                            lIlIlIlIlIIlIIlIIllIIIIIl = System.currentTimeMillis();
                            return true;
                        }
                    } else {
                        this.lIllIlIIIlIIIIIIIlllIlIll.llIIlIlIIIllIlIlIlIIlIIll(-65536);
                        return false;
                    }
                } else {
                    this.lIllIlIIIlIIIIIIIlllIlIll.llIIlIlIIIllIlIlIlIIlIIll(-65536);
                    return false;
                }
            } catch (Exception var7) {
                var7.printStackTrace();
                return false;
            }
        });
        this.nignog.onMouseClick((var1x, var2, var3) -> {
            Ref.getMinecraft().bridge$displayScreen(var1);
            return true;
        });
    }

    public List<UIComponent> llIIlIlIIIllIlIlIlIIlIIll() {
        return ImmutableList.of(this.IlllIIIIIIlllIlIIlllIlIIl = new lIIlIlllIlIlIIIlllIIlIIII(null, "reportABug") {
            public void IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, float var3, float var4) {
                BugReportUIScreen.this.llIlllIIIllllIIlllIllIIIl.setPositionAndSize(var1, var2 + 32.0F, 16.0F, 16.0F);
                BugReportUIScreen.this.lIllIlIIIlIIIIIIIlllIlIll.setPositionAndSize(var1 + 8.0F, var2 + 48.0F, var3 - 16.0F, 16.0F);
                BugReportUIScreen.this.lllIIIIIlllIIlIllIIlIIIlI.setPositionAndSize(var1 + var3 - 24.0F, var2 + 70.0F, 14.0F, 14.0F);
                BugReportUIScreen.this.llIIIlllIIlllIllllIlIllIl.setPositionAndSize(var1, var2 + 70.0F, 14.0F, 14.0F);
                BugReportUIScreen.this.lllllIllIllIllllIlIllllII.resoze(var1 + var3 - 74.0F, var2 + 70.0F, 0.0F);
                BugReportUIScreen.this.lIlIIIIIIlIIIllllIllIIlII.setPositionAndSize(var1 + var3 - 56.0F, var2 + 120.0F - 24.0F, 50.0F, 18.0F);
                BugReportUIScreen.this.nignog.setPositionAndSize(var1 + 6.0F, var2 + 120.0F - 24.0F, 18.0F, 18.0F);
            }
        });
    }

    public void llIIIlllIIlllIllllIlIllIl() {
        float var1 = 350.0F;
        float var2 = this.IllllllllllIlIIIlllIlllll() / 2.0F - var1 / 2.0F;
        float var3 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0F - 60.0F;
        this.IlllIIIIIIlllIlIIlllIlIIl.setPositionAndSize(var2, var3, var1, 120.0F);
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    public void lllllIllIllIllllIlIllllII() {
        ((SettingLabel)this.llIlllIIIllllIIlllIllIIIl.llIIIIIIIllIIllIlIllIIIIl()).lIlIlIlIlIIlIIlIIllIIIIIl((Object)this.get("shortDescriptionChars", new Object[] {180 - this.lIllIlIIIlIIIIIIIlllIlIll.getText().length()}));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2) {
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, int var3) {
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, int var3) {
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(char var1, KeyType var2) {
    }

    public void lIlIIIIIIlIIIllllIllIIlII() {
        Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(false);
    }

    public String getLanguagePath() {
        return super.getLanguagePath() + ".bug";
    }

    public enum Category {
        lIlIlIlIlIIlIIlIIllIIIIIl("mod"),
        IlllIIIIIIlllIlIIlllIlIIl("gui"),
        lIllIlIIIlIIIIIIIlllIlIll("cosmetic"),
        llIlllIIIllllIIlllIllIIIl("store"),
        llllIIlIIlIIlIIllIIlIIllI("voice"),
        IlIlIlllllIlIIlIlIlllIlIl("launcher"),
        llIIIIIIIllIIllIlIllIIIIl("other");

        public final String lIIIllIllIIllIlllIlIIlllI;

        public String toString() {
            return this.lIIIllIllIIllIlllIlIIlllI;
        }

        Category(String var3) {
            this.lIIIllIllIIllIlllIlIIlllI = var3;
        }
    }
}
