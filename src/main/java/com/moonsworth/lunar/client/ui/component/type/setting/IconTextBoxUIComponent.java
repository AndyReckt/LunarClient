package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class IconTextBoxUIComponent extends TextboxUIComponent {
    public IconTextBoxUIComponent(UIComponent uIComponent, ResourceLocationBridge resourceLocationBridge, LCFontRenderer lCFontRenderer, String string, int n, int n2) {
        super(uIComponent, resourceLocationBridge, lCFontRenderer, string, n, n2);
    }

    @Override
    public void llIIlIlIIIllIlIlIlIIlIIll() {
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y, this.width, this.height, this.lllllIllIlIIlIIlIIIlllIlI());
    }
}