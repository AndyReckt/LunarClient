package com.moonsworth.lunar.client.ui.component.type.overlay;

public class llllIIlIIlIIlIIllIIlIIllI
extends UIComponent {
    public final WebsocketProfile lIlIlIlIlIIlIIlIIllIIIIIl;
    public final ColorEase IlllIIIIIIlllIlIIlllIlIIl = new ColorEase(-2130706433, -1);

    public llllIIlIIlIIlIIllIIlIIllI(UIComponent uIComponent, WebsocketProfile websocketProfile) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = websocketProfile;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        LunarClient.IIllIlIllIlIllIllIllIllII().lllllIllIlIIlIIlIIIlllIlI().lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(), this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(), ColorUtil.llIIIIIIIllIIllIlIllIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2))));
        if (this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)) {
            LCFontRenderer lCFontRenderer = FontRegistry.llIIIlllIIlllIllllIlIllIl();
            AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x - 9.0f - (float)lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.llllIIlIIlIIlIIllIIlIIllI().toUpperCase()) - 6.0f, this.y + 1.0f, lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.llllIIlIIlIIlIIllIIlIIllI().toUpperCase()) + 7, this.height, 4.0f, Integer.MIN_VALUE);
            lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.llIlllIIIllllIIlllIllIIIl().toUpperCase(), this.x - 11.0f - (float)lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl.llllIIlIIlIIlIIllIIlIIllI().toUpperCase()), this.y + 3.0f, -1);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(char c, KeyType keyType) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl() {
    }

    public WebsocketProfile lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }
}
 