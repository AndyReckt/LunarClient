package com.moonsworth.lunar.client.ui.component.type.config;

import com.moonsworth.lunar.client.setting.ConfigCategory;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

public class SettingsCategoryUIComponent extends MainUITopBarButtonUIComponent {
    public final ConfigCategory category;

    public SettingsCategoryUIComponent(ConfigCategory configCategory, UIComponent uIComponent) {
        super(uIComponent, configCategory.toString().toUpperCase());
        this.category = configCategory;
        this.ease = new ColorEase(-2142268164, -11561732);
        this.width = (float)this.fontRenderer.IlllIIIIIIlllIlIIlllIlIIl(this.get(this.category.toString()).replace("", " ").trim()) + 16.0f;
    }

    @Override
    public void setPosition(float f, float f2) {
        super.setPositionAndSize(f, f2, this.width, 14.0f);
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x, this.y, this.width, this.height, 4.0f, 0, this.selected || this.mouseInside(mouseX, mouseY) ? 1621271202 : 0x20A2A2A2, this.ease.lIlIlIlIlIIlIIlIIllIIIIIl(this.selected || bl && this.mouseInside(mouseX, mouseY)));
        float f3 = this.fontRenderer.getHeight();
        String string = this.get(this.category.toString()).toUpperCase().replace("", " ").trim();
        this.fontRenderer.IlllIIIIIIlllIlIIlllIlIIl(string, this.x + this.width / 2.0f + 1.0f, this.y + this.height / 2.0f - f3 + 1.0f - this.IllIllIIIllIIIlIlIlIIIIll, 0x20000000);
        this.fontRenderer.IlllIIIIIIlllIlIIlllIlIIl(string, this.x + this.width / 2.0f, this.y + this.height / 2.0f - f3 - this.IllIllIIIllIIIlIlIlIIIIll, this.selected || this.mouseInside(mouseX, mouseY) && bl ? -1 : -1342177281);
    }

    public ConfigCategory lIllIlIIIlIIIIIIIlllIlIll() {
        return this.category;
    }
}
