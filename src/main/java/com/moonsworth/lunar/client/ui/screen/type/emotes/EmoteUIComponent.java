package com.moonsworth.lunar.client.ui.screen.type.emotes;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.emote.AbstractEmote;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.ease.ColorEase;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

public class EmoteUIComponent extends UIComponent {
    public final EmotesUIScreen lIlIlIlIlIIlIIlIIllIIIIIl;
    public final AbstractEmote IlllIIIIIIlllIlIIlllIlIIl;
    public final Integer lIllIlIIIlIIIIIIIlllIlIll;
    public final int llIlIIIllIIlIllIllIllllIl;
    public boolean IllIllIIIllIIIlIlIlIIIIll;
    public final ColorEase IIlIllIlllllllIIlIIIllIIl;

    public EmoteUIComponent(EmotesUIScreen emotesUIScreen, UIComponent uIComponent, AbstractEmote abstractEmote, int n, boolean bl) {
        super(uIComponent);
        this.lIlIlIlIlIIlIIlIIllIIIIIl = emotesUIScreen;
        this.IlllIIIIIIlllIlIIlllIlIIl = abstractEmote;
        this.lIllIlIIIlIIIIIIIlllIlIll = abstractEmote.IlIlIlllllIlIIlIlIlllIlIl();
        this.llIlIIIllIIlIllIllIllllIl = n;
        this.IllIllIIIllIIIlIlIlIIIIll = bl;
        this.IIlIllIlllllllIIlIIIllIIl = new ColorEase(0, bl ? 1086980096 : 1073793536);
    }

    @Override
    public void onUpdateScreen() {
    }

    @Override
    public void drawComponent(float mouseX, float mouseY, boolean bl) {
        int n = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.0f, 0.0f, 0.0f, 0.2f);
        int n2 = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(0.1f, 0.6f, 0.1f, 1.0f);
        int n3 = ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(1.0f, 1.0f, 1.0f, 0.2f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.x + 2.0f, this.y + 2.0f, this.getWidth() - 4.0f, this.getHeight() - 4.0f, 4.0f, n, n3, this.IIlIllIlllllllIIlIIIllIIl.lIlIlIlIlIIlIIlIIllIIIIIl(bl && this.mouseInside(mouseX, mouseY) && (this.IllIllIIIllIIIlIlIlIIIIll || this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl.size() < 8)));
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.llIIIIIIIllIIllIlIllIIIIl(), 18.0f, this.x + 2.0f, this.y + 1.0f);
    }

    @Override
    public boolean onMouseClicked(float mouseX, float mouseY, int mouseButton) {
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl.contains(this.lIllIlIIIlIIIIIIIlllIlIll) && !this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl.contains(this.lIllIlIIIlIIIIIIIlllIlIll)) {
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl.size() >= 8) {
                return false;
            }
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl.add(this.lIllIlIIIlIIIIIIIlllIlIll);
            this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl.remove(this.lIllIlIIIlIIIIIIIlllIlIll);
            float f3 = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll.getYOffset();
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f3);
            this.IllIllIIIllIIIlIlIlIIIIll = true;
        } else if (this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl.contains(this.lIllIlIIIlIIIIIIIlllIlIll)) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl.add(this.lIllIlIIIlIIIIIIIlllIlIll);
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl.remove(this.lIllIlIIIlIIIIIIIlllIlIll);
            float f4 = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll.getYOffset();
            this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(f4);
            this.IllIllIIIllIIIlIlIlIIIIll = false;
        }
        return true;
    }

    @Override
    public void onKeyTyped(char c, KeyType keyType) {
    }

    @Override
    public void onGuiClosed() {
    }

    public AbstractEmote lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public Integer llIlllIIIllllIIlllIllIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public int llllIIlIIlIIlIIllIIlIIllI() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public boolean load() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }
}
