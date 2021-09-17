package com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.component;

import com.moonsworth.lunar.client.cosmetic.Cosmetic;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ExponentialEase;

public abstract class AbstractCosmeticUIComponent
extends UIComponent {
    public int lIlIlIlIlIIlIIlIIllIIIIIl;
    public Cosmetic IlllIIIIIIlllIlIIlllIlIIl;
    public ExponentialEase lIllIlIIIlIIIIIIIlllIlIll;

    public AbstractCosmeticUIComponent(UIComponent uIComponent, Cosmetic cosmetic) {
        super(uIComponent);
        this.IlllIIIIIIlllIlIIlllIlIIl = cosmetic;
        this.llllIIlIIlIIlIIllIIlIIllI();
    }

    // todo fix
    @Override
    public abstract boolean lIllIlIIIlIIIIIIIlllIlIll();

    public abstract String llIlllIIIllllIIlllIllIIIl();

    public void llllIIlIIlIIlIIllIIlIIllI() {
        this.lIllIlIIIlIIIIIIIlllIlIll = new ExponentialEase(500L);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(int n) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = n;
    }

    public Cosmetic llIIIIIIIllIIllIlIllIIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}
 