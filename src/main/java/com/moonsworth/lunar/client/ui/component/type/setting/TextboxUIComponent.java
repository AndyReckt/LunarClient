package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ClipboardBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.UIScreenCloseException;
import com.moonsworth.lunar.client.util.StringValidator;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.opengl.GL11;

public abstract class TextboxUIComponent extends UIComponent implements UIScreenCloseException {
    public final LCFontRenderer IlllIIIIIIlllIlIIlllIlIIl;
    public String text;
    public final String llIlIIIllIIlIllIllIllllIl;
    public int IllIllIIIllIIIlIlIlIIIIll;
    public int IIlIllIlllllllIIlIIIllIIl;
    public int lIIlIlllIlIlIIIlllIIlIIII;
    public int llIllIlIllIlllIllIIIIllII;
    public int IllllllllllIlIIIlllIlllll;
    public int lllllIllIlIIlIIlIIIlllIlI;
    public int IllIIIlllIIIlIlllIlIIlIII;
    public int IIlIllIlIIllIIlIlIllllllI;
    public boolean lIIIlllIIIIllllIlIIIlIIll;
    public boolean llIIIlIllIIIIlIIIlIlIllIl;
    public boolean llllIlIllllIlIlIIIllIlIlI;
    public boolean IlIllIIlIIlIIIllIllllIIll;
    public boolean lIllllIllIIlIIlIIIlIIIlII;
    public boolean lIlIlIIIIIIllIlIIIIllIIII;
    public boolean isCensored;
    public boolean typing;
    public Runnable IIlIlIIIllIIllllIllllIlIl;
    public Runnable lIlIlIlIlIIlIIlIIllIIIIIl;
    public ResourceLocationBridge lllllIIIIlIlllIllIIIlIIlI;

    public TextboxUIComponent(UIComponent var1, ResourceLocationBridge var2, LCFontRenderer var3, String var4, int var5, int var6) {
        this(var1, var3, var4, var5, var6);
        this.lllllIIIIlIlllIllIIIlIIlI = var2;
    }

    public TextboxUIComponent(UIComponent var1, LCFontRenderer var2, String var3, int var4, int var5) {
        super(var1);
        this.text = "";
        this.llIllIlIllIlllIllIIIIllII = 256;
        this.llIIIlIllIIIIlIIIlIlIllIl = true;
        this.llllIlIllllIlIlIIIllIlIlI = true;
        this.IlIllIIlIIlIIIllIllllIIll = true;
        this.lIllllIllIIlIIlIIIlIIIlII = true;
        this.lIlIlIIIIIIllIlIIIIllIIII = true;
        this.isCensored = false;
        this.lllllIIIIlIlllIllIIIlIIlI = null;
        this.IlllIIIIIIlllIlIIlllIlIIl = var2;
        this.llIlIIIllIIlIllIllIllllIl = var3;
        this.IllIllIIIllIIIlIlIlIIIIll = var4;
        this.lIIlIlllIlIlIIIlllIIlIIII = 0;
        this.IIlIllIlllllllIIlIIIllIIl = var5;
        this.onMouseClick((var1x, var2x, var3x) -> {
            boolean hovered = this.mouseInside(var1x, var2x);
            if (this.llIIIlIllIIIIlIIIlIlIllIl && var3x == 1 && hovered) {
                this.setText("");
            }

            if (this.lIllllIllIIlIIlIIIlIIIlII) {
                this.setTyping(hovered);
            }

            if (this.typing && var3x == 0) {
                float offX = var1x - this.x;
                if (this.IlIllIIlIIlIIIllIllllIIll) {
                    offX -= 4.0F;
                }

                if (this.lllllIIIIlIlllIllIIIlIIlI != null) {
                    offX -= 12.0F;
                }

                String var6 = this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.text.substring(this.IllIIIlllIIIlIlllIlIIlIII), this.IllllllllllIlIIIlllIlllll());
                this.IlIlIlllllIlIIlIlIlllIlIl(this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var6, offX).length() + this.IllIIIlllIIIlIlllIlIIlIII);
            }

            return true;
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((var1x, var2x, var3x) -> {
            if (this.isTyping()) {
                this.setTyping(false);
                return true;
            } else {
                return false;
            }
        });
    }

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        ++this.IIlIllIlIIllIIlIlIllllllI;
    }

    public void setText(String var1) {
        if (var1.length() > this.llIllIlIllIlllIllIIIIllII) {
            this.text = var1.substring(0, this.llIllIlIllIlllIllIIIIllII);
        } else {
            this.text = var1;
        }

        this.IlllllIlIIIlIIlIIllIIlIll();
    }

    public String getText() {
        return this.text;
    }

    public String llIIIIIIIllIIllIlIllIIIIl() {
        int var1 = Math.min(this.IllllllllllIlIIIlllIlllll, this.lllllIllIlIIlIIlIIIlllIlI);
        int var2 = Math.max(this.IllllllllllIlIIIlllIlllll, this.lllllIllIlIIlIIlIIIlllIlI);
        return this.text.substring(var1, var2);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(String var1) {
        String var2 = "";
        String var3 = StringValidator.lIlIlIlIlIIlIIlIIllIIIIIl(var1);
        int var4 = Math.min(this.IllllllllllIlIIIlllIlllll, this.lllllIllIlIIlIIlIIIlllIlI);
        int var5 = Math.max(this.IllllllllllIlIIIlllIlllll, this.lllllIllIlIIlIIlIIIlllIlI);
        int var6 = this.llIllIlIllIlllIllIIIIllII - this.text.length() - (var4 - this.lllllIllIlIIlIIlIIIlllIlI);
        if (this.text.length() > 0) {
            var2 = var2 + this.text.substring(0, var4);
        }

        int var7;
        if (var6 < var3.length()) {
            var2 = var2 + var3.substring(0, var6);
            var7 = var6;
        } else {
            var2 = var2 + var3;
            var7 = var3.length();
        }

        if (this.text.length() > 0 && var5 < this.text.length()) {
            var2 = var2 + this.text.substring(var5);
        }

        this.text = var2;
        this.llllIIlIIlIIlIIllIIlIIllI(var4 - this.lllllIllIlIIlIIlIIIlllIlI + var7);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int var1) {
        if (!this.text.isEmpty()) {
            if (this.lllllIllIlIIlIIlIIIlllIlI != this.IllllllllllIlIIIlllIlllll) {
                this.IlllIIIIIIlllIlIIlllIlIIl("");
            } else {
                this.lIllIlIIIlIIIIIIIlllIlIll(this.llIlllIIIllllIIlllIllIIIl(var1) - this.IllllllllllIlIIIlllIlllll);
            }

        }
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(int var1) {
        if (!this.text.isEmpty()) {
            if (this.lllllIllIlIIlIIlIIIlllIlI != this.IllllllllllIlIIIlllIlllll) {
                this.IlllIIIIIIlllIlIIlllIlIIl("");
            } else {
                boolean var2 = var1 < 0;
                int var3 = var2 ? this.IllllllllllIlIIIlllIlllll + var1 : this.IllllllllllIlIIIlllIlllll;
                int var4 = var2 ? this.IllllllllllIlIIIlllIlllll : this.IllllllllllIlIIIlllIlllll + var1;
                String var5 = "";
                if (var3 >= 0) {
                    var5 = this.text.substring(0, var3);
                }

                if (var4 < this.text.length()) {
                    var5 = var5 + this.text.substring(var4);
                }

                this.text = var5;
                if (var2) {
                    this.llllIIlIIlIIlIIllIIlIIllI(var1);
                }

            }
        }
    }

    public int llIlllIIIllllIIlllIllIIIl(int var1) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(var1, this.llIIIlIllIIIIlIIIlIlIllIl());
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl(int var1, int var2) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2, true);
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl(int var1, int var2, boolean var3) {
        boolean var4 = var1 < 0;
        int var5 = Math.abs(var1);

        for (int var6 = 0; var6 < var5; ++var6) {
            if (!var4) {
                int var7 = this.text.length();
                var2 = this.text.indexOf(32, var2);
                if (var2 == -1) {
                    var2 = var7;
                } else {
                    while (var3 && var2 < var7 && this.text.charAt(var2) == ' ') {
                        ++var2;
                    }
                }
            } else {
                while (var3 && var2 > 0 && this.text.charAt(var2 - 1) == ' ') {
                    --var2;
                }

                while (var2 > 0 && this.text.charAt(var2 - 1) != ' ') {
                    --var2;
                }
            }
        }

        return var2;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(int var1) {
        this.IlIlIlllllIlIIlIlIlllIlIl(this.lllllIllIlIIlIIlIIIlllIlI + var1);
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(int var1) {
        this.IllllllllllIlIIIlllIlllll = var1;
        int var2 = this.text.length();
        if (this.IllllllllllIlIIIlllIlllll < 0) {
            this.IllllllllllIlIIIlllIlllll = 0;
        }

        if (this.IllllllllllIlIIIlllIlllll > var2) {
            this.IllllllllllIlIIIlllIlllll = var2;
        }

        this.llIIIIIIIllIIllIlIllIIIIl(this.IllllllllllIlIIIlllIlllll);
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl != null) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.run();
        }

    }

    public void save() {
        this.IlIlIlllllIlIIlIlIlllIlIl(0);
    }

    public void IlllllIlIIIlIIlIIllIIlIll() {
        this.IlIlIlllllIlIIlIlIlllIlIl(this.text.length());
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl(char var1, KeyType var2) {
        if (!this.typing) {
            return false;
        } else {
            ClipboardBridge var3 = Bridge.IIlIllIlIIllIIlIlIllllllI();
            switch (var1) {
            case '':
                this.IlllllIlIIIlIIlIIllIIlIll();
                this.llIIIIIIIllIIllIlIllIIIIl(0);
                return true;
            case '':
                var3.bridge$setClipboardString(this.llIIIIIIIllIIllIlIllIIIIl());
                return true;
            case '':
                if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                    this.IlllIIIIIIlllIlIIlllIlIIl(var3.bridge$getClipboardString());
                }

                return true;
            case '':
                var3.bridge$setClipboardString(this.llIIIIIIIllIIllIlIllIIIIl());
                if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                    this.IlllIIIIIIlllIlIIlllIlIIl("");
                }

                return true;
            default:
                switch (var2) {
                case KEY_BACK:
                    if (AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) {
                        if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                            this.IlllIIIIIIlllIlIIlllIlIIl(-1);
                        }
                    } else if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                        this.lIllIlIIIlIIIIIIIlllIlIll(-1);
                    }

                    return true;
                case KEY_HOME:
                    if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LSHIFT)) {
                        this.llIIIIIIIllIIllIlIllIIIIl(0);
                    } else {
                        this.save();
                    }

                    return true;
                case KEY_LEFT:
                    if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LSHIFT)) {
                        if (AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) {
                            this.llIIIIIIIllIIllIlIllIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl(-1, this.llllIlIllllIlIlIIIllIlIlI()));
                        } else {
                            this.llIIIIIIIllIIllIlIllIIIIl(this.llllIlIllllIlIlIIIllIlIlI() - 1);
                        }
                    } else if (AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) {
                        this.IlIlIlllllIlIIlIlIlllIlIl(this.llIlllIIIllllIIlllIllIIIl(-1));
                    } else {
                        this.llllIIlIIlIIlIIllIIlIIllI(-1);
                    }

                    return true;
                case KEY_RIGHT:
                    if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LSHIFT)) {
                        if (AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) {
                            this.llIIIIIIIllIIllIlIllIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl(1, this.llllIlIllllIlIlIIIllIlIlI()));
                        } else {
                            this.llIIIIIIIllIIllIlIllIIIIl(this.llllIlIllllIlIlIIIllIlIlI() + 1);
                        }
                    } else if (AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) {
                        this.IlIlIlllllIlIIlIlIlllIlIl(this.llIlllIIIllllIIlllIllIIIl(1));
                    } else {
                        this.llllIIlIIlIIlIIllIIlIIllI(1);
                    }

                    return true;
                case KEY_END:
                    if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LSHIFT)) {
                        this.llIIIIIIIllIIllIlIllIIIIl(this.text.length());
                    } else {
                        this.IlllllIlIIIlIIlIIllIIlIll();
                    }

                    return true;
                case KEY_DELETE:
                    if (AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) {
                        if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                            this.IlllIIIIIIlllIlIIlllIlIIl(1);
                        }
                    } else if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                        this.lIllIlIIIlIIIIIIIlllIlIll(1);
                    }

                    return true;
                default:
                    boolean var4 = Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_LMENU) || Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.KEY_RMENU);
                    if (AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI() && !var4 && !AbstractUIScreen.lIIIlllIIIIllllIlIIIlIIll()) {
                        switch (var2) {
                        case KEY_A:
                            this.IlllllIlIIIlIIlIIllIIlIll();
                            this.llIIIIIIIllIIllIlIllIIIIl(0);
                            return true;
                        case KEY_C:
                            var3.bridge$setClipboardString(this.llIIIIIIIllIIllIlIllIIIIl());
                            return true;
                        case KEY_X:
                            var3.bridge$setClipboardString(this.llIIIIIIIllIIllIlIllIIIIl());
                            if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                                this.IlllIIIIIIlllIlIIlllIlIIl("");
                            }

                            return true;
                        case KEY_V:
                            if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                                this.IlllIIIIIIlllIlIIlllIlIIl(var3.bridge$getClipboardString());
                            }

                            return true;
                        }
                    }

                    if (StringValidator.lIlIlIlIlIIlIIlIIllIIIIIl(var1)) {
                        if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                            this.IlllIIIIIIlllIlIIlllIlIIl(Character.toString(var1));
                        }

                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }

    public abstract void llIIlIlIIIllIlIlIlIIlIIll();

    public void lIIlIlllIlIlIIIlllIIlIIII() {
        if (this.lIlIlIIIIIIllIlIIIIllIIII()) {
            if (this.lIIlIIIIIIlIIlIIllIlIIlII()) {
                this.llIIlIlIIIllIlIlIlIIlIIll();
            }

            int var1 = this.IllllllllllIlIIIlllIlllll - this.IllIIIlllIIIlIlllIlIIlIII;
            int var2 = this.lllllIllIlIIlIIlIIIlllIlI - this.IllIIIlllIIIlIlllIlIIlIII;
            String var3 = this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.text.substring(this.IllIIIlllIIIlIlllIlIIlIII), this.IllllllllllIlIIIlllIlllll());
            boolean var4 = var1 >= 0 && var1 <= var3.length();
            boolean var5 = this.typing && this.IIlIllIlIIllIIlIlIllllllI / 6 % 2 == 0 && var4;
            float var6 = this.IlIllIIlIIlIIIllIllllIIll ? this.x + 4.0F + (float) (this.lllllIIIIlIlllIllIIIlIIlI != null ? 12 : 0) : this.x;
            float var7 = this.IlIllIIlIIlIIIllIllllIIll ? this.y + (this.height - 8.0F) / 2.0F : this.y;
            float var8 = var6;
            if (var2 > var3.length()) {
                var2 = var3.length();
            }

            if (this.lllllIIIIlIlllIllIIIlIIlI != null) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 0.2F);
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllllIIIIlIlllIllIIIlIIlI, 2.75F, this.x + 7.0F, this.y + 4.5F);
            }

            if (var3.length() > 0) {
                String var9 = var4 ? var3.substring(0, var1) : var3;
                var8 = this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.isCensored ? StringUtils.repeat('*', var9.length()) : var9, var6, var7, -1862270977);
            } else if (!this.isTyping()) {
                this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.get(this.llIlIIIllIIlIllIllIllllIl), var6, var7, 822083583);
            }

            boolean var12 = this.IllllllllllIlIIIlllIlllll < this.text.length() || this.text.length() >= this.lIIIlllIIIIllllIlIIIlIIll();
            float var10 = var8;
            if (!var4) {
                var10 = var1 > 0 ? var6 + this.width - 8.0F : var6;
            } else if (var12) {
                var10 = var8 - 1.0F;
                --var8;
            }

            if (var3.length() > 0 && var4 && var1 < var3.length()) {
                String var11 = var3.substring(var1);
                this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.isCensored ? StringUtils.repeat('*', var11.length()) : var11, var8 + 2.0F, var7, -1862270977);
            }

            if (var5) {
                if (var12) {
                    AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(var10 + 1.5F, var7 + 1.0F, var10 + 2.0F, var7 + 3.0F + (float) this.IlllIIIIIIlllIlIIlllIlIIl.getHeight(), -3092272);
                } else {
                    this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl("_", var10, var7, -1862270977);
                }
            }

            if (var2 != var1) {
                float var13 = var6 + (float) this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(var3.substring(0, var2));
                this.IlllIIIIIIlllIlIIlllIlIIl(var10, var7 - 1.0F + 2.0F, var13 - 1.0F, var7 + 1.0F + (float) this.IlllIIIIIIlllIlIIlllIlIIl.getHeight() + 2.0F);
            }

        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, float var3, float var4) {
        float var5;
        if (var1 < var3) {
            var5 = var1;
            var1 = var3;
            var3 = var5;
        }

        if (var2 < var4) {
            var5 = var2;
            var2 = var4;
            var4 = var5;
        }

        if (var3 > this.x + this.width) {
            var3 = this.x + this.width;
        }

        if (var1 > this.x + this.width) {
            var1 = this.x + this.width;
        }

        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        GL11.glEnable(3058);
        GL11.glLogicOp(5387);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRect(var1, var2, var3 - var1, var4 - var2, -16776961);
        GL11.glDisable(3058);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
    }

    public void setTyping(boolean var1) {
        if (var1 && !this.typing) {
            this.IIlIllIlIIllIIlIlIllllllI = 0;
        }

        if (var1 && this.IIlIlIIIllIIllllIllllIlIl != null) {
            this.IIlIlIIIllIIllllIllllIlIl.run();
        }

        this.typing = var1;
    }

    public boolean isTyping() {
        return this.typing;
    }

    public float IllllllllllIlIIIlllIlllll() {
        return this.lIIlIIIIIIlIIlIIllIlIIlII() ? this.width - 12.0F - (float) (this.lllllIIIIlIlllIllIIIlIIlI != null ? 18 : 0) : this.width - 6.0F - (float) (this.lllllIIIIlIlllIllIIIlIIlI != null ? 18 : 0);
    }

    public void llIIIIIIIllIIllIlIllIIIIl(int var1) {
        int var2 = this.text.length();
        if (var1 > var2) {
            var1 = var2;
        }

        if (var1 < 0) {
            var1 = 0;
        }

        this.lllllIllIlIIlIIlIIIlllIlI = var1;
        if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
            if (this.IllIIIlllIIIlIlllIlIIlIII > var2) {
                this.IllIIIlllIIIlIlllIlIIlIII = var2;
            }

            float var3 = this.IllllllllllIlIIIlllIlllll();
            String var4 = this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.text.substring(this.IllIIIlllIIIlIlllIlIIlIII), var3);
            int var5 = var4.length() + this.IllIIIlllIIIlIlllIlIIlIII;
            if (var1 == this.IllIIIlllIIIlIlllIlIIlIII) {
                this.IllIIIlllIIIlIlllIlIIlIII -= this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.text, var3, true).length();
            }

            if (var1 > var5) {
                this.IllIIIlllIIIlIlllIlIIlIII += var1 - var5;
            } else if (var1 <= this.IllIIIlllIIIlIlllIlIIlIII) {
                this.IllIIIlllIIIlIlllIlIIlIII -= this.IllIIIlllIIIlIlllIlIIlIII - var1;
            }

            if (this.IllIIIlllIIIlIlllIlIIlIII < 0) {
                this.IllIIIlllIIIlIlllIlIIlIII = 0;
            }

            if (this.IllIIIlllIIIlIlllIlIIlIII > var2) {
                this.IllIIIlllIIIlIlllIlIIlIII = var2;
            }
        }

    }

    public void onUpdateScreen() {
        this.lIllIlIIIlIIIIIIIlllIlIll();
    }

    public void drawComponent(float mouseX, float mouseY, boolean var3) {
        this.lIIlIlllIlIlIIIlllIIlIIII();
    }

    public void onKeyTyped(char var1, KeyType var2) {
        if (var2 == KeyType.KEY_ESCAPE) {
            this.setTyping(false);
        }

        this.IlllIIIIIIlllIlIIlllIlIIl(var1, var2);
    }

    public void onGuiClosed() {
    }

    public boolean shouldCancel() {
        return this.typing;
    }

    public void lIIIllIllIIllIlllIlIIlllI(int var1) {
        this.IllIllIIIllIIIlIlIlIIIIll = var1;
    }

    public void IlllllIlIIIlIIlIIllIIlIll(int var1) {
        this.IIlIllIlllllllIIlIIIllIIl = var1;
    }

    public void llIIlIlIIIllIlIlIlIIlIIll(int var1) {
        this.lIIlIlllIlIlIIIlllIIlIIII = var1;
    }

    public int lllllIllIlIIlIIlIIIlllIlI() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public int IllIIIlllIIIlIlllIlIIlIII() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public int IIlIllIlIIllIIlIlIllllllI() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public void llIIIlllIIlllIllllIlIllIl(int var1) {
        this.llIllIlIllIlllIllIIIIllII = var1;
    }

    public int lIIIlllIIIIllllIlIIIlIIll() {
        return this.llIllIlIllIlllIllIIIIllII;
    }

    public int llIIIlIllIIIIlIIIlIlIllIl() {
        return this.IllllllllllIlIIIlllIlllll;
    }

    public int llllIlIllllIlIlIIIllIlIlI() {
        return this.lllllIllIlIIlIIlIIIlllIlI;
    }

    public boolean IlIllIIlIIlIIIllIllllIIll() {
        return this.lIIIlllIIIIllllIlIIIlIIll;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean var1) {
        this.lIIIlllIIIIllllIlIIIlIIll = var1;
    }

    public boolean lIllllIllIIlIIlIIIlIIIlII() {
        return this.llIIIlIllIIIIlIIIlIlIllIl;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(boolean var1) {
        this.llIIIlIllIIIIlIIIlIlIllIl = var1;
    }

    public boolean lIlIlIIIIIIllIlIIIIllIIII() {
        return this.llllIlIllllIlIlIIIllIlIlI;
    }

    public void llIlllIIIllllIIlllIllIIIl(boolean var1) {
        this.llllIlIllllIlIlIIIllIlIlI = var1;
    }

    public boolean lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.IlIllIIlIIlIIIllIllllIIll;
    }

    public boolean IlIIlIIlIIlIIllIIIllIIllI() {
        return this.lIllllIllIIlIIlIIIlIIIlII;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(boolean var1) {
        this.lIlIlIIIIIIllIlIIIIllIIII = var1;
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(boolean var1) {
        this.isCensored = var1;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Runnable var1) {
        this.IIlIlIIIllIIllllIllllIlIl = var1;
    }
}
