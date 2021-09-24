package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.client.profile.FriendProfile;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public abstract class IllIllIIIllIIIlIlIlIIIIll extends AbstractListUIComponent<UIComponent> {
    public FriendProfile lIlIlIlIlIIlIIlIIllIIIIIl;

    public IllIllIIIllIIIlIlIlIIIIll(UIComponent uIComponent) {
        super(uIComponent);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        this.setPositionAndSize(f + 2.0f, f2, 100.0f, this.components.size() * 10 + 8);
        int n = 0;
        for (UIComponent uIComponent : this.components) {
            uIComponent.setPositionAndSize(f + 2.0f + 1.0f, this.y + 4.0f + (float)(n * 10), this.width - 2.0f, 10.0f);
            ++n;
        }
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 6.0f, -820175587);
        super.drawComponent(mouseX, mouseY, bl);
    }

    public FriendProfile llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(FriendProfile friend) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = friend;
    }
}
