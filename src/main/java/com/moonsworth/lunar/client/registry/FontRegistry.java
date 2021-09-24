package com.moonsworth.lunar.client.registry;

import com.google.common.collect.ImmutableSet;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.json.file.ItemSetLoader;

import java.util.Set;

/**
 * @author Decencies
 * @since 10/07/2021 15:57
 */
public class FontRegistry extends ItemSetLoader<LCFontRenderer> {

    public static FontRegistry llIlIIIllIIlIllIllIllllIl;
    public static LCFontRenderer lIlIlIlIlIIlIIlIIllIIIIIl;
    public static LCFontRenderer IlllIIIIIIlllIlIIlllIlIIl;
    public static LCFontRenderer lIllIlIIIlIIIIIIIlllIlIll;
    public static LCFontRenderer llIlllIIIllllIIlllIllIIIl;
    public static LCFontRenderer llllIIlIIlIIlIIllIIlIIllI;
    public static LCFontRenderer IlIlIlllllIlIIlIlIlllIlIl;
    public static LCFontRenderer llIIIIIIIllIIllIlIllIIIIl;
    public static LCFontRenderer lIIIllIllIIllIlllIlIIlllI;
    public static LCFontRenderer IlllllIlIIIlIIlIIllIIlIll;
    public static LCFontRenderer llIIlIlIIIllIlIlIlIIlIIll;
    public static LCFontRenderer llIIIlllIIlllIllllIlIllIl;
    public static LCFontRenderer lllllIllIllIllllIlIllllII;
    public static LCFontRenderer lllIIIIIlllIIlIllIIlIIIlI;
    public static LCFontRenderer lIlIIIIIIlIIIllllIllIIlII;
    public static final ResourceLocationBridge IllIllIIIllIIIlIlIlIIIIll;
    public static final ResourceLocationBridge IIlIllIlllllllIIlIIIllIIl;
    public static final ResourceLocationBridge lIIlIlllIlIlIIIlllIIlIIII;
    public static final ResourceLocationBridge llIllIlIllIlllIllIIIIllII;
    public static final ResourceLocationBridge IllllllllllIlIIIlllIlllll;

    public FontRegistry() {
        llIlIIIllIIlIllIllIllllIl = this;
    }

    @Override
    public Set<LCFontRenderer> lIlIlIlIlIIlIIlIIllIIIIIl() {
        lIIIllIllIIllIlllIlIIlllI = new LCFontRenderer(IllIllIIIllIIIlIlIlIIIIll, 10.0f);
        IlllllIlIIIlIIlIIllIIlIll = new LCFontRenderer(IllIllIIIllIIIlIlIlIIIIll, 12.0f);
        IlIlIlllllIlIIlIlIlllIlIl = new LCFontRenderer(IllIllIIIllIIIlIlIlIIIIll, 14.0f);
        llIIIIIIIllIIllIlIllIIIIl = new LCFontRenderer(IllIllIIIllIIIlIlIlIIIIll, 18.0f);
        llIIlIlIIIllIlIlIlIIlIIll = new LCFontRenderer(lIIlIlllIlIlIIIlllIIlIIII, 14.0f);
        lIllIlIIIlIIIIIIIlllIlIll = new LCFontRenderer(lIIlIlllIlIlIIIlllIIlIIII, 12.0f);
        llllIIlIIlIIlIIllIIlIIllI = new LCFontRenderer(IIlIllIlllllllIIlIIIllIIl, 13.0f);
        llIlllIIIllllIIlllIllIIIl = new LCFontRenderer(IIlIllIlllllllIIlIIIllIIl, 10.0f);
        lIlIlIlIlIIlIIlIIllIIIIIl = new LCFontRenderer(lIIlIlllIlIlIIIlllIIlIIII, 16.0f);
        IlllIIIIIIlllIlIIlllIlIIl = new LCFontRenderer(lIIlIlllIlIlIIIlllIIlIIII, 18.0f);
        llIIIlllIIlllIllllIlIllIl = new LCFontRenderer(lIIlIlllIlIlIIIlllIIlIIII, 22.0f);
        lllllIllIllIllllIlIllllII = new LCFontRenderer(lIIlIlllIlIlIIIlllIIlIIII, 38.0f);
        lllIIIIIlllIIlIllIIlIIIlI = new LCFontRenderer(llIllIlIllIlllIllIIIIllII, 22.0f);
        lIlIIIIIIlIIIllllIllIIlII = new LCFontRenderer(IllllllllllIlIIIlllIlllll, 22.0f);
        return ImmutableSet.of(lIIIllIllIIllIlllIlIIlllI, IlllllIlIIIlIIlIIllIIlIll, IlIlIlllllIlIIlIlIlllIlIl, llIIIIIIIllIIllIlIllIIIIl, llIIlIlIIIllIlIlIlIIlIIll, lIllIlIIIlIIIIIIIlllIlIll, llllIIlIIlIIlIIllIIlIIllI, llIlllIIIllllIIlllIllIIIl, lIlIlIlIlIIlIIlIIllIIIIIl, IlllIIIIIIlllIlIIlllIlIIl, llIIIlllIIlllIllllIlIllIl, lllllIllIllIllllIlIllllII, lllIIIIIlllIIlIllIIlIIIlI, lIlIIIIIIlIIIllllIllIIlII);
    }

    public static FontRegistry llllIIlIIlIIlIIllIIlIIllI() {
        return llIlIIIllIIlIllIllIllllIl;
    }

    public static LCFontRenderer IlIlIlllllIlIIlIlIlllIlIl() {
        return lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public static LCFontRenderer llIIIIIIIllIIllIlIllIIIIl() {
        return IlllIIIIIIlllIlIIlllIlIIl;
    }

    public static LCFontRenderer lIIIllIllIIllIlllIlIIlllI() {
        return lIllIlIIIlIIIIIIIlllIlIll;
    }

    public static LCFontRenderer IlllllIlIIIlIIlIIllIIlIll() {
        return llIlllIIIllllIIlllIllIIIl;
    }

    public static LCFontRenderer llIIlIlIIIllIlIlIlIIlIIll() {
        return llllIIlIIlIIlIIllIIlIIllI;
    }

    public static LCFontRenderer llIIIlllIIlllIllllIlIllIl() {
        return IlIlIlllllIlIIlIlIlllIlIl;
    }

    public static LCFontRenderer lllllIllIllIllllIlIllllII() {
        return llIIIIIIIllIIllIlIllIIIIl;
    }

    public static LCFontRenderer lllIIIIIlllIIlIllIIlIIIlI() {
        return lIIIllIllIIllIlllIlIIlllI;
    }

    public static LCFontRenderer lIlIIIIIIlIIIllllIllIIlII() {
        return IlllllIlIIIlIIlIIllIIlIll;
    }

    public static LCFontRenderer llIlIIIllIIlIllIllIllllIl() {
        return llIIlIlIIIllIlIlIlIIlIIll;
    }

    public static LCFontRenderer IllIllIIIllIIIlIlIlIIIIll() {
        return llIIIlllIIlllIllllIlIllIl;
    }

    public static LCFontRenderer IIlIllIlllllllIIlIIIllIIl() {
        return lllllIllIllIllllIlIllllII;
    }

    public static LCFontRenderer lIIlIlllIlIlIIIlllIIlIIII() {
        return lllIIIIIlllIIlIllIIlIIIlI;
    }

    public static LCFontRenderer llIllIlIllIlllIllIIIIllII() {
        return lIlIIIIIIlIIIllllIllIIlII;
    }

    static {
        IllIllIIIllIIIlIlIlIIIIll = Bridge.getInstance().initResourceLocation("lunar", "fonts/roboto-bold.ttf");
        IIlIllIlllllllIIlIIIllIIl = Bridge.getInstance().initResourceLocation("lunar", "fonts/roboto-medium.ttf");
        lIIlIlllIlIlIIIlllIIlIIII = Bridge.getInstance().initResourceLocation("lunar", "fonts/roboto-light.ttf");
        llIllIlIllIlllIllIIIIllII = Bridge.getInstance().initResourceLocation("lunar", "fonts/raleway-extrabold.ttf");
        IllllllllllIlIIIlllIlllll = Bridge.getInstance().initResourceLocation("lunar", "fonts/raleway-light.ttf");
    }

}
