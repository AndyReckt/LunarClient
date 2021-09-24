package com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.base;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.client.ui.ease.ExponentialEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.List;

public class CosmeticsUIScreenBase extends AbstractUIScreen {
    public CosmeticsListUIComponent lIlIlIlIlIIlIIlIIllIIIIIl;
    public ExponentialEase IlllIIIIIIlllIlIIlllIlIIl;
    public final GuiScreenBridge lIllIlIIIlIIIIIIIlllIlIll;

    public CosmeticsUIScreenBase(GuiScreenBridge guiScreenBridge) {
        this.lIllIlIIIlIIIIIIIlllIlIll = guiScreenBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = new ExponentialEase(5000L);
        this.IlllIIIIIIlllIlIIlllIlIIl.lIllIlIIIlIIIIIIIlllIlIll();
    }

    @Override
    public List llIIlIlIIIllIlIlIlIIlIIll() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = new CosmeticsListUIComponent(this);
        return ImmutableList.of(this.lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        try {
            float f = 492.0f;
            float f2 = 303.0f;
            this.lIlIlIlIlIIlIIlIIllIIIIIl.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() / 2.0f - f / 2.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - f2 / 2.0f, f, f2);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, int n) {
        if (!this.lIlIlIlIlIIlIIlIIllIIIIIl.mouseInside(f, f2)) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.onMouseReleased(f, f2, n);
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(char c, KeyType keyType) {
    }

    @Override
    public void lIlIIIIIIlIIIllllIllIIlII() {
    }

    @Override
    public String getLanguagePath() {
        return super.getLanguagePath() + ".cosmetics";
    }

    public GuiScreenBridge llIIIIIIIllIIllIlIllIIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }
}
