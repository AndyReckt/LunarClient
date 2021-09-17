package com.moonsworth.lunar.client.ui.component.type.misc;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.util.ClipboardBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.BooleanCallbackSetting;
import com.moonsworth.lunar.client.util.StringValidator;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.opengl.GL11;

/**
 * @author Decencies
 * @since 10/07/2021 18:55
 */
public abstract class TextboxUIComponent
        extends UIComponent
        implements BooleanCallbackSetting {
    public final LCFontRenderer IlllIIIIIIlllIlIIlllIlIIl;
    public String lIllIlIIIlIIIIIIIlllIlIll = "";
    public final String llIlIIIllIIlIllIllIllllIl;
    public int IllIllIIIllIIIlIlIlIIIIll;
    public int IIlIllIlllllllIIlIIIllIIl;
    public int lIIlIlllIlIlIIIlllIIlIIII;
    public int llIllIlIllIlllIllIIIIllII = 256;
    public int IllllllllllIlIIIlllIlllll;
    public int lllllIllIlIIlIIlIIIlllIlI;
    public int IllIIIlllIIIlIlllIlIIlIII;
    public int IIlIllIlIIllIIlIlIllllllI;
    public boolean lIIIlllIIIIllllIlIIIlIIll;
    public boolean llIIIlIllIIIIlIIIlIlIllIl = true;
    public boolean llllIlIllllIlIlIIIllIlIlI = true;
    public boolean IlIllIIlIIlIIIllIllllIIll = true;
    public boolean lIllllIllIIlIIlIIIlIIIlII = true;
    public boolean lIlIlIIIIIIllIlIIIIllIIII = true;
    public boolean lIIlIIIIIIlIIlIIllIlIIlII = false;
    public boolean IlIIlIIlIIlIIllIIIllIIllI;
    public Runnable IIlIlIIIllIIllllIllllIlIl;
    public Runnable lIlIlIlIlIIlIIlIIllIIIIIl;
    public ResourceLocationBridge lllllIIIIlIlllIllIIIlIIlI = null;

    public TextboxUIComponent(UIComponent uIComponent, ResourceLocationBridge resourceLocationBridge, LCFontRenderer lCFontRenderer, String string, int n, int n2) {
        this(uIComponent, lCFontRenderer, string, n, n2);
        this.lllllIIIIlIlllIllIIIlIIlI = resourceLocationBridge;
    }

    public TextboxUIComponent(UIComponent uIComponent, LCFontRenderer lCFontRenderer, String text, int n2, int n3) {
        super(uIComponent);
        this.IlllIIIIIIlllIlIIlllIlIIl = lCFontRenderer;
        this.llIlIIIllIIlIllIllIllllIl = text;
        this.IllIllIIIllIIIlIlIlIIIIll = n2;
        this.lIIlIlllIlIlIIIlllIIlIIII = 0;
        this.IIlIllIlllllllIIlIIIllIIl = n3;
        this.lIlIlIlIlIIlIIlIIllIIIIIl((float f, float f2, int n) -> {
            boolean bl = this.IlllIIIIIIlllIlIIlllIlIIl(f, f2);
            if (this.llIIIlIllIIIIlIIIlIlIllIl && n == 1 && bl) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl("");
            }
            if (this.lIllllIllIIlIIlIIIlIIIlII) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(bl);
            }
            if (this.IlIIlIIlIIlIIllIIIllIIllI && n == 0) {
                float f3 = f - this.x;
                if (this.IlIllIIlIIlIIIllIllllIIll) {
                    f3 -= 4.0f;
                }
                if (this.lllllIIIIlIlllIllIIIlIIlI != null) {
                    f3 -= 12.0f;
                }
                String string = this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.substring(this.IllIIIlllIIIlIlllIlIIlIII), this.IllllllllllIlIIIlllIlllll());
                this.IlIlIlllllIlIIlIlIlllIlIl(this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(string, f3).length() + this.IllIIIlllIIIlIlllIlIIlIII);
            }
            return true;
        });
        this.IlllIIIIIIlllIlIIlllIlIIl((float f, float f2, int n) -> {
            if (this.llIllIlIllIlllIllIIIIllII()) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(false);
                return true;
            }
            return false;
        });
    }

    public void lIllIlIIIlIIIIIIIlllIlIll() {
        ++this.IIlIllIlIIllIIlIlIllllllI;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.lIllIlIIIlIIIIIIIlllIlIll = string.length() > this.llIllIlIllIlllIllIIIIllII ? string.substring(0, this.llIllIlIllIlllIllIIIIllII) : string;
        this.IlllllIlIIIlIIlIIllIIlIll();
    }

    public String llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public String llIIIIIIIllIIllIlIllIIIIl() {
        int n = Math.min(this.IllllllllllIlIIIlllIlllll, this.lllllIllIlIIlIIlIIIlllIlI);
        int n2 = Math.max(this.IllllllllllIlIIIlllIlllll, this.lllllIllIlIIlIIlIIIlllIlI);
        return this.lIllIlIIIlIIIIIIIlllIlIll.substring(n, n2);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(String string) {
        int n;
        String string2 = "";
        String string3 = StringValidator.lIlIlIlIlIIlIIlIIllIIIIIl(string);
        int n2 = Math.min(this.IllllllllllIlIIIlllIlllll, this.lllllIllIlIIlIIlIIIlllIlI);
        int n3 = Math.max(this.IllllllllllIlIIIlllIlllll, this.lllllIllIlIIlIIlIIIlllIlI);
        int n4 = this.llIllIlIllIlllIllIIIIllII - this.lIllIlIIIlIIIIIIIlllIlIll.length() - (n2 - this.lllllIllIlIIlIIlIIIlllIlI);
        if (this.lIllIlIIIlIIIIIIIlllIlIll.length() > 0) {
            string2 = string2 + this.lIllIlIIIlIIIIIIIlllIlIll.substring(0, n2);
        }
        if (n4 < string3.length()) {
            string2 = string2 + string3.substring(0, n4);
            n = n4;
        } else {
            string2 = string2 + string3;
            n = string3.length();
        }
        if (this.lIllIlIIIlIIIIIIIlllIlIll.length() > 0 && n3 < this.lIllIlIIIlIIIIIIIlllIlIll.length()) {
            string2 = string2 + this.lIllIlIIIlIIIIIIIlllIlIll.substring(n3);
        }
        this.lIllIlIIIlIIIIIIIlllIlIll = string2;
        this.llllIIlIIlIIlIIllIIlIIllI(n2 - this.lllllIllIlIIlIIlIIIlllIlI + n);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll.isEmpty()) {
            return;
        }
        if (this.lllllIllIlIIlIIlIIIlllIlI != this.IllllllllllIlIIIlllIlllll) {
            this.IlllIIIIIIlllIlIIlllIlIIl("");
        } else {
            this.lIllIlIIIlIIIIIIIlllIlIll(this.llIlllIIIllllIIlllIllIIIl(n) - this.IllllllllllIlIIIlllIlllll);
        }
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(int n) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll.isEmpty()) {
            return;
        }
        if (this.lllllIllIlIIlIIlIIIlllIlI != this.IllllllllllIlIIIlllIlllll) {
            this.IlllIIIIIIlllIlIIlllIlIIl("");
            return;
        }
        boolean bl = n < 0;
        int n2 = bl ? this.IllllllllllIlIIIlllIlllll + n : this.IllllllllllIlIIIlllIlllll;
        int n3 = bl ? this.IllllllllllIlIIIlllIlllll : this.IllllllllllIlIIIlllIlllll + n;
        String string = "";
        if (n2 >= 0) {
            string = this.lIllIlIIIlIIIIIIIlllIlIll.substring(0, n2);
        }
        if (n3 < this.lIllIlIIIlIIIIIIIlllIlIll.length()) {
            string = string + this.lIllIlIIIlIIIIIIIlllIlIll.substring(n3);
        }
        this.lIllIlIIIlIIIIIIIlllIlIll = string;
        if (bl) {
            this.llllIIlIIlIIlIIllIIlIIllI(n);
        }
    }

    public int llIlllIIIllllIIlllIllIIIl(int n) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(n, this.llIIIlIllIIIIlIIIlIlIllIl());
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl(int n, int n2) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(n, n2, true);
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl(int n, int n2, boolean bl) {
        boolean bl2 = n < 0;
        int n3 = Math.abs(n);
        for (int i = 0; i < n3; ++i) {
            if (bl2) {
                while (bl && n2 > 0 && this.lIllIlIIIlIIIIIIIlllIlIll.charAt(n2 - 1) == ' ') {
                    --n2;
                }
                while (n2 > 0 && this.lIllIlIIIlIIIIIIIlllIlIll.charAt(n2 - 1) != ' ') {
                    --n2;
                }
                continue;
            }
            int n4 = this.lIllIlIIIlIIIIIIIlllIlIll.length();
            if ((n2 = this.lIllIlIIIlIIIIIIIlllIlIll.indexOf(32, n2)) == -1) {
                n2 = n4;
                continue;
            }
            while (bl && n2 < n4 && this.lIllIlIIIlIIIIIIIlllIlIll.charAt(n2) == ' ') {
                ++n2;
            }
        }
        return n2;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(int n) {
        this.IlIlIlllllIlIIlIlIlllIlIl(this.lllllIllIlIIlIIlIIIlllIlI + n);
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(int n) {
        this.IllllllllllIlIIIlllIlllll = n;
        int n2 = this.lIllIlIIIlIIIIIIIlllIlIll.length();
        if (this.IllllllllllIlIIIlllIlllll < 0) {
            this.IllllllllllIlIIIlllIlllll = 0;
        }
        if (this.IllllllllllIlIIIlllIlllll > n2) {
            this.IllllllllllIlIIIlllIlllll = n2;
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
        this.IlIlIlllllIlIIlIlIlllIlIl(this.lIllIlIIIlIIIIIIIlllIlIll.length());
    }


    public boolean IlllIIIIIIlllIlIIlllIlIIl(char c, KeyType keyType) {
        boolean bl;
        if (!this.IlIIlIIlIIlIIllIIIllIIllI) {
            return false;
        }
        ClipboardBridge clipboardBridge = Bridge.IIlIllIlIIllIIlIlIllllllI();
        switch (c) {
            case '': {
                this.IlllllIlIIIlIIlIIllIIlIll();
                this.llIIIIIIIllIIllIlIllIIIIl(0);
                return true;
            }
            case '': {
                clipboardBridge.bridge$setClipboardString(this.llIIIIIIIllIIllIlIllIIIIl());
                return true;
            }
            case '': {
                if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                    this.IlllIIIIIIlllIlIIlllIlIIl(clipboardBridge.bridge$getClipboardString());
                }
                return true;
            }
            case '': {
                clipboardBridge.bridge$setClipboardString(this.llIIIIIIIllIIllIlIllIIIIl());
                if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                    this.IlllIIIIIIlllIlIIlllIlIIl("");
                }
                return true;
            }
        }
        switch (keyType) {
            case IllllIIllllIllIIIIlllllII: {
                if (AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) {
                    if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                        this.IlllIIIIIIlllIlIIlllIlIIl(-1);
                    }
                } else if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                    this.lIllIlIIIlIIIIIIIlllIlIll(-1);
                }
                return true;
            }
            case IllIllIllIIlIlllIIlllIIll: {
                if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlIllIIllllIllllllIIlIl)) {
                    this.llIIIIIIIllIIllIlIllIIIIl(0);
                } else {
                    this.save();
                }
                return true;
            }
            case IIllllIIlllIlIIlIIlllIlII: {
                if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlIllIIllllIllllllIIlIl)) {
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
            }
            case IllIlIIlllIIlIIllIIIIIIIl: {
                if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlIllIIllllIllllllIIlIl)) {
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
            }
            case lIlllllIIlllIllIIlIIlIlll: {
                if (Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlIllIIllllIllllllIIlIl)) {
                    this.llIIIIIIIllIIllIlIllIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.length());
                } else {
                    this.IlllllIlIIIlIIlIIllIIlIll();
                }
                return true;
            }
            case lIIlIIllIlIIlIIllIIIIlIIl: {
                if (AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) {
                    if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                        this.IlllIIIIIIlllIlIIlllIlIIl(1);
                    }
                } else if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                    this.lIllIlIIIlIIIIIIIlllIlIll(1);
                }
                return true;
            }
        }
        boolean bl2 = bl = Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.llIIIIllIlIIlIlIIlllIllIl) || Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IIIIlIllIllIlIIIIIlIlIlIl);
        if (AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI() && !bl && !AbstractUIScreen.lIIIlllIIIIllllIlIIIlIIll()) {
            switch (keyType) {
                case lllllIllIllIllllIlIllllII: {
                    this.IlllllIlIIIlIIlIIllIIlIll();
                    this.llIIIIIIIllIIllIlIllIIIIl(0);
                    return true;
                }
                case lIlIIIIIIlIIIllllIllIIlII: {
                    clipboardBridge.bridge$setClipboardString(this.llIIIIIIIllIIllIlIllIIIIl());
                    return true;
                }
                case lIlIIlIlllIIlIIIlIlIlIllI: {
                    clipboardBridge.bridge$setClipboardString(this.llIIIIIIIllIIllIlIllIIIIl());
                    if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                        this.IlllIIIIIIlllIlIIlllIlIIl("");
                    }
                    return true;
                }
                case lllllIIIIlIlllIllIIIlIIlI: {
                    if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                        this.IlllIIIIIIlllIlIIlllIlIIl(clipboardBridge.bridge$getClipboardString());
                    }
                    return true;
                }
            }
        }
        if (StringValidator.lIlIlIlIlIIlIIlIIllIIIIIl(c)) {
            if (this.lIlIlIIIIIIllIlIIIIllIIII) {
                this.IlllIIIIIIlllIlIIlllIlIIl(Character.toString(c));
            }
            return true;
        }
        return false;
    }

    public abstract void llIIlIlIIIllIlIlIlIIlIIll();

    public void lIIlIlllIlIlIIIlllIIlIIII() {
        boolean bl;
        if (!this.lIlIlIIIIIIllIlIIIIllIIII()) {
            return;
        }
        if (this.lIIlIIIIIIlIIlIIllIlIIlII()) {
            this.llIIlIlIIIllIlIlIlIIlIIll();
        }
        int n = this.IllllllllllIlIIIlllIlllll - this.IllIIIlllIIIlIlllIlIIlIII;
        int n2 = this.lllllIllIlIIlIIlIIIlllIlI - this.IllIIIlllIIIlIlllIlIIlIII;
        String string = this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.substring(this.IllIIIlllIIIlIlllIlIIlIII), this.IllllllllllIlIIIlllIlllll());
        boolean bl2 = n >= 0 && n <= string.length();
        boolean bl3 = bl = this.IlIIlIIlIIlIIllIIIllIIllI && this.IIlIllIlIIllIIlIlIllllllI / 6 % 2 == 0 && bl2;
        float f = this.IlIllIIlIIlIIIllIllllIIll ? this.x + 4.0f + (float)(this.lllllIIIIlIlllIllIIIlIIlI != null ? 12 : 0) : this.x;
        float f2 = this.IlIllIIlIIlIIIllIllllIIll ? this.y + (this.height - 8.0f) / 2.0f : this.y;
        float f3 = f;
        if (n2 > string.length()) {
            n2 = string.length();
        }
        if (this.lllllIIIIlIlllIllIIIlIIlI != null) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 0.2f);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllllIIIIlIlllIllIIIlIIlI, 2.75f, this.x + 7.0f, this.y + 4.5f);
        }
        if (string.length() > 0) {
            String string2 = bl2 ? string.substring(0, n) : string;
            f3 = this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIlIIIIIIlIIlIIllIlIIlII ? StringUtils.repeat('*', string2.length()) : string2, f, f2, -1862270977);
        } else if (!this.llIllIlIllIlllIllIIIIllII()) {
            this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.get(this.llIlIIIllIIlIllIllIllllIl, new Object[0]), f, f2, 0x30FFFFFF);
        }
        boolean bl4 = this.IllllllllllIlIIIlllIlllll < this.lIllIlIIIlIIIIIIIlllIlIll.length() || this.lIllIlIIIlIIIIIIIlllIlIll.length() >= this.lIIIlllIIIIllllIlIIIlIIll();
        float f4 = f3;
        if (!bl2) {
            f4 = n > 0 ? f + this.width - 8.0f : f;
        } else if (bl4) {
            f4 = f3 - 1.0f;
            f3 -= 1.0f;
        }
        if (string.length() > 0 && bl2 && n < string.length()) {
            String string3 = string.substring(n);
            this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIlIIIIIIlIIlIIllIlIIlII ? StringUtils.repeat('*', string3.length()) : string3, f3 + 2.0f, f2, -1862270977);
        }
        if (bl) {
            if (bl4) {
                AbstractUIScreen.IlllIIIIIIlllIlIIlllIlIIl(f4 + 1.5f, f2 + 1.0f, f4 + 2.0f, f2 + 3.0f + (float)this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(), -3092272);
            } else {
                this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl("_", f4, f2, -1862270977);
            }
        }
        if (n2 != n) {
            float f5 = f + (float)this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(string.substring(0, n2));
            this.IlllIIIIIIlllIlIIlllIlIIl(f4, f2 - 1.0f + 2.0f, f5 - 1.0f, f2 + 1.0f + (float)this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl() + 2.0f);
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, float f3, float f4) {
        float f5;
        if (f < f3) {
            f5 = f;
            f = f3;
            f3 = f5;
        }
        if (f2 < f4) {
            f5 = f2;
            f2 = f4;
            f4 = f5;
        }
        if (f3 > this.x + this.width) {
            f3 = this.x + this.width;
        }
        if (f > this.x + this.width) {
            f = this.x + this.width;
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        GL11.glEnable((int)3058);
        GL11.glLogicOp((int)5387);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRect(f, f2, f3 - f, f4 - f2, -16776961);
        GL11.glDisable((int)3058);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        if (bl && !this.IlIIlIIlIIlIIllIIIllIIllI) {
            this.IIlIllIlIIllIIlIlIllllllI = 0;
        }
        if (bl && this.IIlIlIIIllIIllllIllllIlIl != null) {
            this.IIlIlIIIllIIllllIllllIlIl.run();
        }
        this.IlIIlIIlIIlIIllIIIllIIllI = bl;
    }

    public boolean llIllIlIllIlllIllIIIIllII() {
        return this.IlIIlIIlIIlIIllIIIllIIllI;
    }

    public float IllllllllllIlIIIlllIlllll() {
        return this.lIIlIIIIIIlIIlIIllIlIIlII() ? this.width - 12.0f - (float)(this.lllllIIIIlIlllIllIIIlIIlI != null ? 18 : 0) : this.width - 6.0f - (float)(this.lllllIIIIlIlllIllIIIlIIlI != null ? 18 : 0);
    }

    public void llIIIIIIIllIIllIlIllIIIIl(int n) {
        int n2 = this.lIllIlIIIlIIIIIIIlllIlIll.length();
        if (n > n2) {
            n = n2;
        }
        if (n < 0) {
            n = 0;
        }
        this.lllllIllIlIIlIIlIIIlllIlI = n;
        if (this.IlllIIIIIIlllIlIIlllIlIIl != null) {
            if (this.IllIIIlllIIIlIlllIlIIlIII > n2) {
                this.IllIIIlllIIIlIlllIlIIlIII = n2;
            }
            float f = this.IllllllllllIlIIIlllIlllll();
            String string = this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll.substring(this.IllIIIlllIIIlIlllIlIIlIII), f);
            int n3 = string.length() + this.IllIIIlllIIIlIlllIlIIlIII;
            if (n == this.IllIIIlllIIIlIlllIlIIlIII) {
                this.IllIIIlllIIIlIlllIlIIlIII -= this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIllIlIIIlIIIIIIIlllIlIll, f, true).length();
            }
            if (n > n3) {
                this.IllIIIlllIIIlIlllIlIIlIII += n - n3;
            } else if (n <= this.IllIIIlllIIIlIlllIlIIlIII) {
                this.IllIIIlllIIIlIlllIlIIlIII -= this.IllIIIlllIIIlIlllIlIIlIII - n;
            }
            if (this.IllIIIlllIIIlIlllIlIIlIII < 0) {
                this.IllIIIlllIIIlIlllIlIIlIII = 0;
            }
            if (this.IllIIIlllIIIlIlllIlIIlIII > n2) {
                this.IllIIIlllIIIlIlllIlIIlIII = n2;
            }
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        this.lIllIlIIIlIIIIIIIlllIlIll();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        this.lIIlIlllIlIlIIIlllIIlIIII();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
        if (keyType == KeyType.lIIIlIllllIIlIIlIIlIIIIlI) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(false);
        }
        this.IlllIIIIIIlllIlIIlllIlIIl(c, keyType);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    @Override
    public boolean c_() {
        return this.IlIIlIIlIIlIIllIIIllIIllI;
    }

    public void lIIIllIllIIllIlllIlIIlllI(int n) {
        this.IllIllIIIllIIIlIlIlIIIIll = n;
    }

    public void IlllllIlIIIlIIlIIllIIlIll(int n) {
        this.IIlIllIlllllllIIlIIIllIIl = n;
    }

    public void llIIlIlIIIllIlIlIlIIlIIll(int n) {
        this.lIIlIlllIlIlIIIlllIIlIIII = n;
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

    public void llIIIlllIIlllIllllIlIllIl(int n) {
        this.llIllIlIllIlllIllIIIIllII = n;
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

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        this.lIIIlllIIIIllllIlIIIlIIll = bl;
    }

    public boolean lIllllIllIIlIIlIIIlIIIlII() {
        return this.llIIIlIllIIIIlIIIlIlIllIl;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(boolean bl) {
        this.llIIIlIllIIIIlIIIlIlIllIl = bl;
    }

    public boolean lIlIlIIIIIIllIlIIIIllIIII() {
        return this.llllIlIllllIlIlIIIllIlIlI;
    }

    public void llIlllIIIllllIIlllIllIIIl(boolean bl) {
        this.llllIlIllllIlIlIIIllIlIlI = bl;
    }

    public boolean lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.IlIllIIlIIlIIIllIllllIIll;
    }

    public boolean IlIIlIIlIIlIIllIIIllIIllI() {
        return this.lIllllIllIIlIIlIIIlIIIlII;
    }

    public void llllIIlIIlIIlIIllIIlIIllI(boolean bl) {
        this.lIlIlIIIIIIllIlIIIIllIIII = bl;
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(boolean bl) {
        this.lIIlIIIIIIlIIlIIllIlIIlII = bl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Runnable runnable) {
        this.IIlIlIIIllIIllllIllllIlIl = runnable;
    }

}
