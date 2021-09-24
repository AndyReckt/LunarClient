package com.moonsworth.lunar.client.ui.component.type.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.AbstractListUIComponent;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.ArrayList;
import java.util.List;

public abstract class lIIlIlllIlIlIIIlllIIlIIII extends AbstractListUIComponent<UIComponent> {
    public String translationKey;
    public boolean IlllIIIIIIlllIlIIlllIlIIl = true;
    public boolean lIllIlIIIlIIIIIIIlllIlIll = true;

    public lIIlIlllIlIlIIIlllIIlIIII(UIComponent uIComponent, String string) {
        super(uIComponent);
        this.translationKey = string;
    }

    @Override
    public void setPositionAndSize(float x, float y, float width, float height) {
        super.setPositionAndSize(x, y, width, height);
        this.IlllIIIIIIlllIlIIlllIlIIl(x, y, width, height);
    }

    public abstract void IlllIIIIIIlllIlIIlllIlIIl(float var1, float var2, float var3, float var4);

    @Override
    public List<UIComponent> lIllIlIIIlIIIIIIIlllIlIll() {
        return new ArrayList<>();
    }

    @Override
    public void onUpdateScreen() {
        super.onUpdateScreen();
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll) {
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 24.0f, this.width, 0.5f, 0x20FFFFFF);
            AbstractUIScreen.llllIIlIIlIIlIIllIIlIIllI(this.x, this.y + 1.0f, this.width, 23.0f, 5.0f, 0x25000000);
        }
        if (this.IlllIIIIIIlllIlIIlllIlIIl) {
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + this.height - 30.0f, this.width, 0.5f, 0x20FFFFFF);
            AbstractUIScreen.llIIIIIIIllIIllIlIllIIIIl(this.x, this.y + this.height - 29.5f, this.width, 28.5f, 5.0f, 0x45000000);
        }
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x - 1.0f, this.y, this.width + 2.0f, this.height, 4.0f, 0x40000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 3.0f, 0x20FFFFFF);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(this.x, this.y + 1.0f, this.width, this.height - 2.0f, 5.0f, Integer.MIN_VALUE);
        if (this.lIllIlIIIlIIIIIIIlllIlIll) {
            FontRegistry.IllIllIIIllIIIlIlIlIIIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.get(this.translationKey), this.x + 8.0f, this.y + 6.0f, -1);
        }
        super.drawComponent(mouseX, mouseY, bl);
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
        super.onKeyTyped(c, keyType);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }

    public String llllIIlIIlIIlIIllIIlIIllI() {
        return this.get(this.translationKey);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        this.translationKey = string;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.IlllIIIIIIlllIlIIlllIlIIl = bl;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(boolean bl) {
        this.lIllIlIIIlIIIIIIIlllIlIll = bl;
    }
}