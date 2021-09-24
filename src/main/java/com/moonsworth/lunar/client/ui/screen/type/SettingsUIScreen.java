package com.moonsworth.lunar.client.ui.screen.type;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.render.RenderScaledGameOverlayEvent;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.config.ClientSettingsParentUIComponent;
import com.moonsworth.lunar.client.ui.component.type.config.ModuleListUIComponent;
import com.moonsworth.lunar.client.ui.ease.ExponentialEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.List;

public class SettingsUIScreen extends AbstractUIScreen {
    public ClientSettingsParentUIComponent parent;
    public ExponentialEase ease;
    public final GuiScreenBridge lIllIlIIIlIIIIIIIlllIlIll;

    public SettingsUIScreen(GuiScreenBridge guiScreenBridge) {
        this.lIllIlIIIlIIIIIIIlllIlIll = guiScreenBridge;
        this.ease = new ExponentialEase(5000L);
        this.ease.lIllIlIIIlIIIIIIIlllIlIll();
    }

    @Override
    public List<UIComponent> llIIlIlIIIllIlIlIlIIlIIll() {
        this.parent = new ClientSettingsParentUIComponent(this, null);
        return ImmutableList.of(this.parent);
    }

    public void llIlllIIIllllIIlllIllIIIl(int n) {
        this.llIIIIIIIllIIllIlIllIIIIl().IlllIIIIIIlllIlIIlllIlIIl(n);
    }

    @Override
    public void llIIIlllIIlllIllllIlIllIl() {
        float f = 492.0f;
        float f2 = 303.0f;
        this.parent.setPositionAndSize(this.IllllllllllIlIIIlllIlllll() / 2.0f - f / 2.0f, this.lllllIllIlIIlIIlIIIlllIlI() / 2.0f - f2 / 2.0f, f, f2);
    }

    @Override
    public void lllllIllIllIllllIlIllllII() {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        if (Ref.getMinecraft().bridge$getWorld() == null) {
            EventBus.getInstance().call(new RenderScaledGameOverlayEvent(SettingsUIScreen.llllIlIllllIlIlIIIllIlIlI().lIllIlIIIlIIIIIIIlllIlIll(), SettingsUIScreen.llllIlIllllIlIlIIIllIlIlI().llIlllIIIllllIIlllIllIIIl()));
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, int n) {
        if (this.parent != null && this.parent.lIIlIlllIlIlIIIlllIIlIIII().IlllIIIIIIlllIlIIlllIlIIl(f, f2, n)) {
            SettingsUIScreen.IIlIllIlllllllIIlIIIllIIl();
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
        if (this.parent.lIIlIlllIlIlIIIlllIIlIIII() instanceof ModuleListUIComponent) {
            Ref.getLC().lllllIllIllIllllIlIllllII().save();
        }
    }

    @Override
    public String getLanguagePath() {
        return super.getLanguagePath() + ".settings";
    }

    public ClientSettingsParentUIComponent llIIIIIIIllIIllIlIllIIIIl() {
        return this.parent;
    }

    public ExponentialEase lIIIllIllIIllIlllIlIIlllI() {
        return this.ease;
    }

    public GuiScreenBridge IlllllIlIIIlIIlIIllIIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }
}
