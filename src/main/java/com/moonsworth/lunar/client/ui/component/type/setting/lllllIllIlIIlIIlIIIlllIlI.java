package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.misc.TextboxUIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class lllllIllIlIIlIIlIIIlllIlI
extends TextboxUIComponent {
    public lllllIllIlIIlIIlIIIlllIlI(UIComponent uIComponent, ResourceLocationBridge resourceLocationBridge, LCFontRenderer lCFontRenderer, String string, int n, int n2) {
        super(uIComponent, resourceLocationBridge, lCFontRenderer, string, n, n2);
    }

    public lllllIllIlIIlIIlIIIlllIlI(UIComponent uIComponent, LCFontRenderer lCFontRenderer, String string, int n, int n2) {
        super(uIComponent, lCFontRenderer, string, n, n2);
    }

    @Override
    public void llIIlIlIIIllIlIlIlIIlIIll() {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 5.0f, this.IIlIllIlIIllIIlIlIllllllI(), 0x20FFFFFF, this.lllllIllIlIIlIIlIIIlllIlI());
    }
}