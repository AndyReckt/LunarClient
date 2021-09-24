package com.moonsworth.lunar.client.ui.screen.type.warning;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.registry.FontRegistry;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.DefaultButtonUIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.List;
import java.util.function.Consumer;

public class WarningUIScreen extends AbstractUIScreen {
    public DefaultButtonUIComponent cancel;
    public DefaultButtonUIComponent understood;
    public ColorEase ease;
    public final Consumer<Boolean> callback;
    public String messageTranslationKey;
    public boolean lllllIllIllIllllIlIllllII;

    public WarningUIScreen(String messageTranslationKey, Consumer<Boolean> callback) {
        this.messageTranslationKey = messageTranslationKey;
        this.ease = new ColorEase(2000L, -1, -52429);
        this.cancel = new DefaultButtonUIComponent(null, "cancel");
        this.understood = new DefaultButtonUIComponent(null, "understood");
        this.callback = callback;
    }

    @Override
    public List<UIComponent> llIIlIlIIIllIlIlIlIIlIIll() {
        return ImmutableList.of();
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        this.lllllIllIllIllllIlIllllII = true;
        float f = 200.0f;
        float f2 = this.IllllllllllIlIIIlllIlllll() / 2.0f;
        float f3 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 50.0f;
        this.understood.setPositionAndSize(f2 - f / 2.0f, f3 + 55.0f, f, 16.0f);
        this.cancel.setPositionAndSize(f2 - f / 2.0f, f3 + 77.0f, f, 16.0f);
        this.cancel.lIlIlIlIlIIlIIlIIllIIIIIl(true);
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        if (this.lllllIllIllIllllIlIllllII && this.ease.IlIlIlllllIlIIlIlIlllIlIl()) {
            this.lllllIllIllIllllIlIllllII = false;
        } else if (!this.lllllIllIllIllllIlIllllII && this.ease.IlIlIlllllIlIIlIlIlllIlIl()) {
            this.lllllIllIllIllllIlIllllII = true;
        }
        float f3 = this.IllllllllllIlIIIlllIlllll() / 2.0f - 160.0f;
        float f4 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 60.0f;
        float f5 = 320.0f;
        float f6 = 114.0f;
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f3, f4 + 24.0f, f5, 0.5f, 0x20FFFFFF);
        AbstractUIScreen.llllIIlIIlIIlIIllIIlIIllI(f3, f4 + 1.0f, f5, 23.0f, 5.0f, 0x25000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f3 - 1.0f, f4, f5 + 2.0f, f6, 4.0f, 0x40000000);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f3, f4 + 1.0f, f5, f6 - 2.0f, 3.0f, 0x20FFFFFF);
        AbstractUIScreen.IlllllIlIIIlIIlIIllIIlIll(f3, f4 + 1.0f, f5, f6 - 2.0f, 5.0f, Integer.MIN_VALUE);
        float f7 = this.IllllllllllIlIIIlllIlllll() / 2.0f;
        float f8 = this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - 54.0f;
        FontRegistry.IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl(this.get("warning"), f7, f8, this.ease.lIlIlIlIlIIlIIlIIllIIIIIl(this.lllllIllIllIllllIlIllllII));
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(this.get("lineOne"), f7, f8 + 30.0f, -1);
        FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(this.get("lineTwo"), f7, f8 + 40.0f, -1);
        this.cancel.drawComponent(f, f2, true);
        this.understood.drawComponent(f, f2, true);
    }

    @Override
    public String getLanguagePath() {
        return super.getLanguagePath() + "." + this.messageTranslationKey;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        if (this.cancel.mouseInside(f, f2)) {
            AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
            this.callback.accept(false);
        } else if (this.understood.mouseInside(f, f2)) {
            AbstractUIScreen.IIlIllIlllllllIIlIIIllIIl();
            this.callback.accept(true);
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(char c, KeyType keyType) {
    }

    @Override
    public void lIlIIIIIIlIIIllllIllIIlII() {
    }
}
