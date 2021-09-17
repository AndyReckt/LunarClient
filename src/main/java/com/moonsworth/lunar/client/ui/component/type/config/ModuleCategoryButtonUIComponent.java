package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class ModuleCategoryButtonUIComponent
extends MainUITopBarButtonUIComponent {
    public final ModuleCategory IIlIllIlllllllIIlIIIllIIl;

    public ModuleCategoryButtonUIComponent(ModuleCategory moduleCategory, UIComponent uIComponent) {
        super(uIComponent, moduleCategory.toString().toUpperCase());
        this.IIlIllIlllllllIIlIIIllIIl = moduleCategory;
        this.lIllIlIIIlIIIIIIIlllIlIll = new ColorEase(-2141746990, -11561732);
        if (moduleCategory == ModuleCategory.IlllIIIIIIlllIlIIlllIlIIl) {
            this.lIllIlIIIlIIIIIIIlllIlIll = new ColorEase(-2142268416, -11561984);
        }
        this.width = (float)this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(this.get(this.IIlIllIlllllllIIlIIIllIIl.toString(), new Object[0]).replace("", " ").trim()) + 16.0f;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, this.width, 14.0f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, boolean bl) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.0f, 0, this.llIlIIIllIIlIllIllIllllIl || this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) ? 1621271202 : 0x20A2A2A2, this.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIlIIIllIIlIllIllIllllIl || bl && this.IlllIIIIIIlllIlIIlllIlIIl(f, f2)));
        float f3 = this.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl();
        String string = this.get(this.IIlIllIlllllllIIlIIIllIIl.toString(), new Object[0]).toUpperCase().replace("", " ").trim();
        this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(string, this.x + this.width / 2.0f + 1.0f, this.y + this.height / 2.0f - f3 + 1.0f - this.IllIllIIIllIIIlIlIlIIIIll, 0x20000000);
        this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(string, this.x + this.width / 2.0f, this.y + this.height / 2.0f - f3 - this.IllIllIIIllIIIlIlIlIIIIll, this.llIlIIIllIIlIllIllIllllIl || this.IlllIIIIIIlllIlIIlllIlIIl(f, f2) && bl ? -1 : -1342177281);
    }

    public ModuleCategory lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }
}
 