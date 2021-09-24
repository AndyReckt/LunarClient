package com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics;

import com.moonsworth.lunar.client.cosmetic.Cosmetic;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ExponentialEase;

public abstract class AbstractCosmeticUIComponent extends UIComponent {
    public int lIlIlIlIlIIlIIlIIllIIIIIl;
    public Cosmetic cosmetic;
    public ExponentialEase ease;

    public AbstractCosmeticUIComponent(UIComponent uIComponent, Cosmetic cosmetic) {
        super(uIComponent);
        this.cosmetic = cosmetic;
        this.setEase();
    }

    public abstract boolean lIllIlIIIlIIIIIIIlllIlIll();

    public abstract String llIlllIIIllllIIlllIllIIIl();

    public void setEase() { this.ease = new ExponentialEase(500L); }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
    }

    public Cosmetic getCosmetic() {
        return this.cosmetic;
    }
}
