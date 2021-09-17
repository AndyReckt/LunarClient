package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public abstract class IllIllIIIllIIIlIlIlIIIIll
extends AbstractListUIComponent {
    public Object lIlIlIlIlIIlIIlIIllIIIIIl;

    public IllIllIIIllIIIlIlIlIIIIll(UIComponent uIComponent) {
        super(uIComponent);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f + 2.0f, f2, 100.0f, this.llIlIIIllIIlIllIllIllllIl.size() * 10 + 8);
        int n = 0;
        for (UIComponent uIComponent : this.llIlIIIllIIlIllIllIllllIl) {
            uIComponent.lIlIlIlIlIIlIIlIIllIIIIIl(f + 2.0f + 1.0f, this.y + 4.0f + (float)(n * 10), this.width - 2.0f, 10.0f);
            ++n;
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 6.0f, -820175587);
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, bl);
    }

    public Object llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Object object) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = object;
    }
}
 